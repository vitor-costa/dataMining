import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Apriori {

	List<String> itemsets; 
	
	String configFile = "apriori-config.txt";
	String transactionFile = "apriori-transactions.txt";
	String outputFile = "apriori-output.txt";
	
	int numItems; //number of items per transaction
	int numTransactions; //number of transactions
	//DEFINIR VALOR DO SUPORTE MINIMO
	final double minSup = 0; //minimum support for a frequent itemset (0 < minSup < 1)
	
	public Apriori() {
		super();
	}

	public void aprioriProcess() throws Exception
	{
		getConfig();
		
		createBasicItemsets();
		
	    int itemsetSize = 2; //the current itemset being looked at
        
        while (itemsets.size() > 0)
        {
            calculateFrequentItemsets();

            if(itemsets.size() != 0)
            {
                createNewItemsets();
            }

            itemsetSize++;
        }	
	}

	private void getConfig() throws IOException
	{
		numItems = 0;
		numTransactions = 0;
		
		BufferedReader inputData = new BufferedReader(new FileReader(transactionFile));
		
		while (inputData.ready()) {    		
			String line = inputData.readLine();
			
			if (line.matches("\\s*")) continue; //be friendly with empty lines
			
			numTransactions++;
			
			StringTokenizer t = new StringTokenizer(line, " ");
			
			while (t.hasMoreTokens()) {
				numItems++;
			}    		
		}
		
		inputData.close();
	}
	
	private void calculateFrequentItemsets() throws IOException
    {
		List<String> frequentCandidates = new ArrayList<String>(); 

		int frequencyCount = 0;
		
		BufferedReader inputData = new BufferedReader(new InputStreamReader(new FileInputStream(transactionFile)));

		for (int i = 0; i < itemsets.size(); i++) {
			String candidate = itemsets.get(i);
			
			for (int j = 0; j < numTransactions; j++) {
				String line = inputData.readLine();
				
				if (line.contains(candidate)) frequencyCount++;
			}
			
			if ((frequencyCount / (double) (numTransactions)) >= minSup) {
				frequentCandidates.add(itemsets.get(i));
			}
		}
		
		inputData.close();

        //new candidates are only the frequent candidates
		itemsets = frequentCandidates;
    }
	
	private void createBasicItemsets() {
		FeelingsAnalyzer fa = new FeelingsAnalyzer();
		
		HashSet<String> positiveWords = fa.getPositiveHash();
		HashSet<String> negativeWords = fa.getNegativeHash();
		
		for (String word : positiveWords) {
			itemsets.add(word + ",Positive");
			itemsets.add(word + ",Negative");
		}
		
		for (String word : negativeWords) {
			itemsets.add(word + ",Positive");
			itemsets.add(word + ",Negative");
		}
	}
	
    private void createNewItemsets()
    {
    	//by construction, all existing itemsets have the same size
    	int currentSizeOfItemsets = itemsets.get(0).length();
    		
    	HashMap<String, int[]> tempCandidates = new HashMap<String, int[]>();
    	
       //TODO
    }
}
