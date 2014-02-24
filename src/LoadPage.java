import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
 
public class LoadPage {
	private static boolean copyHtml = false;
	private final static int MAX_PAGE = 2;
	private final static String URL_BITCOIN = "http://www.globo.com/busca/?q=bitcoin";
	
	/* Pega o arquivo CSV do link e o baixa
    URL website = new URL("https://blockchain.info/pt/charts/trade-volume?showDataPoints=false&timespan=&show_header=true&daysAverageString=1&scale=0&format=csv&address=");
    ReadableByteChannel rbc = Channels.newChannel(website.openStream());
    FileOutputStream fos = new FileOutputStream("information.html");
    fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    */
	
	public static void extractText(String url, BufferedWriter file) {
		try {
			org.jsoup.nodes.Document doc; // = Jsoup.connect(url).get();
			doc = Jsoup.connect(url).get();
			org.jsoup.select.Elements titles = doc.select(".materia-conteudo");
			
			for(Element e: titles){
				System.out.println("text: " +e.text());
				System.out.println("html: "+ e.html());
				file.write(e.text());
	            file.newLine();
	            file.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
        URL url = null;
        File file = new File("./page.html");
        File text = new File("./text.html");
        try {
            url = new URL(URL_BITCOIN);
            new LoadPage().getPage(url, file);
            File pages = new File("./page.html");
            getText(pages, text);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private static void getText(File pages, File text) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(pages));
        BufferedReader link = null;
        URL url = null;
 
         BufferedWriter out = new BufferedWriter(new FileWriter(text));
 
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            // Imprime página no console
            System.out.println(inputLine);
            
            inputLine = inputLine.subSequence(inputLine.indexOf('h') + 6, inputLine.lastIndexOf('l') + 1).toString();
            System.out.println(inputLine);
            url = new URL(inputLine);
            try{
            	extractText(inputLine, out);
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
}