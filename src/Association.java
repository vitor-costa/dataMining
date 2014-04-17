import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class Association {

	private static HashMap<String, Event> events;
	
	public Association(HashMap<String, Event> events) {
		this.events = events;
	}
	
	public void run() {
		double pos_1_count = 0;
		double pos_2_count = 0;
		double neg_1_count = 0;
		double neg_2_count = 0;
		double neutral_count = 0;
		double total = events.size();
		double pos_1_up_count = 0;
		double pos_2_up_count = 0;
		double neg_1_up_count = 0;
		double neg_2_up_count = 0;
		double neutral_up_count = 0;
		double pos_1_down_count = 0;
		double pos_2_down_count = 0;
		double neg_1_down_count = 0;
		double neg_2_down_count = 0;
		double neutral_down_count = 0;
		
		// Get data from events
		Iterator<Entry<String, Event>> iterator = events.entrySet().iterator();
		Entry<String, Event> currentEvent;
		double variation;
		String feeling;
	    while(iterator.hasNext()) {
	       	currentEvent = iterator.next();
	       	feeling = ((Event) currentEvent.getValue()).getFeelingScale();
	       	variation = ((Event) currentEvent.getValue()).getVariation();
	       	if(feeling.equals("Positive_1")) {
	       		pos_1_count++;
	       		if(variation > 0) {
	       			pos_1_up_count++;
	       		}
	       		if(variation < 0) {
	       			pos_1_down_count++;
	       		}
	       	}
	       	if(feeling.equals("Positive_2")) {
	       		pos_2_count++;
	       		if(variation > 0) {
	       			pos_2_up_count++;
	       		}
	       		if(variation < 0) {
	       			pos_2_down_count++;
	       		}
	       	}
	       	if(feeling.equals("Negative_1")) {
	       		neg_1_count++;
	       		if(variation > 0) {
	       			neg_1_up_count++;
	       		}
	       		if(variation < 0) {
	       			neg_1_down_count++;
	       		}
	       	}
	       	if(feeling.equals("Negative_2")) {
	       		neg_2_count++;
	       		if(variation > 0) {
	       			neg_2_up_count++;
	       		}
	       		if(variation < 0) {
	       			neg_2_down_count++;
	       		}
	       	}
	       	if(feeling.equals("Neutral")) {
	       		neutral_count++;
	       		if(variation > 0) {
	       			neutral_up_count++;
	       		}
	       		if(variation < 0) {
	       			neutral_down_count++;
	       		}
	       	}
	       	
	    }
	    
	    System.out.println(pos_1_count+ ","+pos_2_count+ "," +neg_2_count+ "," +neg_1_count+ "," +neutral_count+ "," +total);
	    System.out.println(pos_1_up_count+ "," +pos_1_down_count+ "," +pos_2_up_count+ "," +pos_2_down_count);
	    System.out.println(neg_1_up_count+ "," +neg_1_down_count+ "," +neg_2_up_count+ "," +neg_2_down_count);
	    System.out.println(neutral_up_count+ "," +neutral_down_count);
	    
	    // Get results
	    if(neg_2_up_count > 0)
	    	System.out.println("(negative_2) -> quotation_up [sup=" + neg_2_up_count/total + "; conf=" + neg_2_up_count/neg_2_count + "]");
	    if(neg_1_up_count > 0)
	    	System.out.println("(negative_1) -> quotation_up [sup=" + neg_1_up_count/total + "; conf=" + neg_1_up_count/neg_1_count + "]");
	    if(pos_2_up_count > 0)
	    	System.out.println("(positive_2) -> quotation_up [sup=" + pos_2_up_count/total + "; conf=" + pos_2_up_count/pos_2_count + "]");
	    if(pos_1_up_count > 0)
	    	System.out.println("(positive_1) -> quotation_up [sup=" + pos_1_up_count/total + "; conf=" + pos_1_up_count/pos_1_count + "]");
	    if(neutral_up_count > 0)
	    	System.out.println("(neutral) -> quotation_up [sup=" + neutral_up_count/total + "; conf=" + neutral_up_count/neutral_count + "]");
	    if(neg_2_down_count > 0)
	    	System.out.println("(negative_2) -> quotation_down [sup=" + neg_2_down_count/total + "; conf=" + neg_2_down_count/neg_2_count + "]");
	    if(neg_1_down_count > 0)
	    	System.out.println("(negative_1) -> quotation_down [sup=" + neg_1_down_count/total + "; conf=" + neg_1_down_count/neg_1_count + "]");
	    if(pos_2_down_count > 0)
	    	System.out.println("(positive_2) -> quotation_down [sup=" + pos_2_down_count/total + "; conf=" + pos_2_down_count/pos_2_count + "]");
	    if(pos_1_down_count > 0)
	    	System.out.println("(positive_1) -> quotation_down [sup=" + pos_1_down_count/total + "; conf=" + pos_1_down_count/pos_1_count + "]");
	    if(neutral_down_count > 0)
	    	System.out.println("(neutral) -> quotation_down [sup=" + neutral_down_count/total + "; conf=" + neutral_down_count/neutral_count + "]");
	}
	
}
