import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
 
public class LoadPage {
	private static boolean copyHtml = false;
	private final static int MAX_PAGE = 5;
	private final static String URL_BITCOIN = "http://www.globo.com/busca/?q=bitcoin";
	private static HashMap<String, Event> events;
	private static HashMap<String, String> quotations;
	
	/* Pega o arquivo CSV do link e o baixa
    URL website = new URL("https://blockchain.info/pt/charts/trade-volume?showDataPoints=false&timespan=&show_header=true&daysAverageString=1&scale=0&format=csv&address=");
    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
    FileOutputStream fos = new FileOutputStream("information.html");
    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    */
	
	
	public static Event extractText(String url, BufferedWriter file) {
		Event event = null;
		String articleText = null;
		String date = null;
		try {
			org.jsoup.nodes.Document doc; // = Jsoup.connect(url).get();
			doc = Jsoup.connect(url).get();
			org.jsoup.select.Elements titles = doc.select(".materia-conteudo");
			org.jsoup.select.Elements dateFromText = doc.select(".published");
			
			for(Element e: titles){
				//System.out.println("text: " +e.text());
				//System.out.println("html: "+ e.html());
				file.write(e.text());
	            file.newLine();
	            file.newLine();
	            articleText = e.text();
			}
			for(Element e: dateFromText) {
				date = e.text();
			}
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>date:" + date);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if(articleText != null && date != null) {
			event = new Event(date, articleText);
		}
		return event;
	}
	
    public void getPage(URL url, File file) throws IOException {
    	int pageNumber = 1;
        BufferedReader in =
                new BufferedReader(new InputStreamReader(url.openStream()));
 
         BufferedWriter out = new BufferedWriter(new FileWriter(file));
 
        String inputLine;
        // Itera entre as páginas de resultado sobre o termo 'bitcoin'
        while(pageNumber < MAX_PAGE) {
	        while ((inputLine = in.readLine()) != null) {
	            // Imprime link no console
	            System.out.println(inputLine);
	            // Grava link no arquivo
	            if(inputLine.contains("link-url")) {
	            	out.write(inputLine);
		            out.newLine();
	            }
	        }
	        // Muda a página de resultados
	        pageNumber++;
	        url = new URL(URL_BITCOIN + "&page=" + pageNumber);
	        in = new BufferedReader(new InputStreamReader(url.openStream()));
        }
 
        in.close();
        out.flush();
        out.close();
    }
    
    private static boolean canCopyPage() {
    	return copyHtml;
	}

    public static void deactivatePageCopying() {
    	copyHtml = false;
    }
    
	public static void activatePageCopying() {
    	copyHtml = true;
    }
 
    public static void main(String[] args) {
    	events = new HashMap<String, Event>();
    	quotations = new HashMap<String, String>();
    	Entry currentEvent = null;
        URL url = null;
        File file = new File("./page.html");
        File text = new File("./text.html");
        //File quotationsFile = new File("./quotations.csv");
        try {
        	
            url = new URL(URL_BITCOIN);
            new LoadPage().getPage(url, file);
            File pages = new File("./page.html");
            getText(pages, text);
            extractQuotations();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        upgradeQuotations();
        System.out.println(events.size());
        System.out.println(quotations.size());
        Iterator<Entry<String, Event>> iterator = events.entrySet().iterator();
        while(iterator.hasNext()) {
        	currentEvent = iterator.next();
        	System.out.println("date: " + ((String) currentEvent.getKey()).substring(0, 10));
        	System.out.println("quotation: " + ((Event) currentEvent.getValue()).getQuotation());
        	System.out.println("---");
        }
    }

    static void upgradeQuotations() {
    	Iterator<Entry<String, Event>> iterator = events.entrySet().iterator();
    	Entry currentEvent = null;
    	Entry currentQuotation = null;
    	while(iterator.hasNext()) {
    		Iterator<Entry<String, String>> quotationIterator = quotations.entrySet().iterator();
    		currentEvent = iterator.next();
    		while(quotationIterator.hasNext()) {
    			currentQuotation = quotationIterator.next();
    			System.out.println(((String) currentQuotation.getKey()).substring(0, 10));
    			System.out.println(((String) currentEvent.getKey()).substring(0, 10));
    			if(((String) currentQuotation.getKey()).substring(0, 10).equals(((String) currentEvent.getKey()).substring(0, 10))) {
    				((Event) currentEvent.getValue()).setQuotation((String) currentQuotation.getValue());
    				break;
    			}
    		}
    	}
    }
    
    static void upgradeVariations() {
    	Iterator<Entry<String, Event>> iterator = events.entrySet().iterator();
    	Entry currentEvent = null;
    	Entry currentQuotation = null;
    	while(iterator.hasNext()) {
    		Iterator<Entry<String, String>> quotationIterator = quotations.entrySet().iterator();
    		currentEvent = iterator.next();
    		while(quotationIterator.hasNext()) {
    			currentQuotation = quotationIterator.next();
    			System.out.println(((String) currentQuotation.getKey()).substring(0, 10));
    			System.out.println(((String) currentEvent.getKey()).substring(0, 10));
    			if(((String) currentQuotation.getKey()).substring(0, 10).equals(((String) currentEvent.getKey()).substring(0, 10))) {
    				for(int i = 0; i < 30; i++) {
    					if(quotationIterator.hasNext()) {
    						currentQuotation = quotationIterator.next();
    					}
    				}
    				String[] val = ((String) currentQuotation.getValue()).split(".");
    				String[] quo = ((Event) currentEvent.getValue()).getQuotation().split(".");
    				((Event) currentEvent.getValue()).setVariation(Integer.getInteger(val[0]) - Integer.getInteger(quo[0]));
    				break;
    			}
    		}
    	}
    }
    
	private static void getText(File pages, File text) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(pages));
        BufferedReader link = null;
        URL url = null;
        BufferedWriter out = new BufferedWriter(new FileWriter(text));
        String inputLine;
        Event eventTemp = null;
        
        while ((inputLine = in.readLine()) != null) {
            // Imprime página no console
            System.out.println(inputLine);
            
            inputLine = inputLine.subSequence(inputLine.indexOf('h') + 6, inputLine.lastIndexOf('l') + 1).toString();
            System.out.println(inputLine);
            url = new URL(inputLine);
            try{
            	eventTemp = extractText(inputLine, out);
            	if(eventTemp != null) {
            		events.put(eventTemp.getDate(), eventTemp);
            	}
//	            link = new BufferedReader(new InputStreamReader(url.openStream()));
//	            String link_text;
//	            while((link_text = link.readLine()) != null) {
//	            	if(link_text.contains("materia-conteudo entry-content")) {
//		            	activatePageCopying();
//		            }
//		             Grava pagina no arquivo
//		            if(canCopyPage()) {
//			            out.write(link_text);
//			            out.newLine();
//		            }
//		            if(link_text.contains("<!-- google_ad_section_end -->")) {
//		            	deactivatePageCopying();
//		            }
//	            }
	            
            } catch(Exception e) {
            	System.out.println("Pagina com erro.");
            }
            // Para ter certeza que bloqueou
            deactivatePageCopying();
        }
        
        in.close();
        out.flush();
        out.close();
	}
	
	public static void extractQuotations() {
		 
		String csvFile = "./quotations.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			        // use comma as separator
				String[] data = line.split(cvsSplitBy);
	 
				System.out.println("Country [code= " + data[0] 
	                                 + " , name=" + data[1] + "]");
				quotations.put(data[0],data[1]);
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
	  }
	
	public void updateFeelings() {
		Iterator<Entry<String, Event>> iterator = events.entrySet().iterator();
		Entry currentEvent = null;
		
		while(iterator.hasNext()) {
    		currentEvent = iterator.next();
    		getFeeling((Event) currentEvent.getValue());
    	}		
	}
	
	public void getFeeling(Event event) {
		String text;
		String[] words;
		int positiveCount = 0;
		int negativeCount = 0;
		
		text = event.getArticleText();
		
		words = text.split(" ");
		
		for(int i = 0; i < words.length; i++) {
			int result = analyzeWord(words[i]);
			if(result == 1) {
				positiveCount++;
			} else if(result == -1) {
				negativeCount++;
			}
		}
		
		if(negativeCount > positiveCount) {
			event.setFeeling("Negative");
		} else if(positiveCount > negativeCount) {
			event.setFeeling("Positive");
		} else {
			event.setFeeling("Neutral");
		}
		
	}
	
	public int analyzeWord(String word) {
		int feeling = 0;
		
		if(word.equals("condenou")) {
			feeling = -1;
		} else if(word.equals("milh�o")) {
			feeling = 1;
		}
		
		return feeling;
	}
}