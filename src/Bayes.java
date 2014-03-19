import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class Bayes {
	private double pUp;
	private double pDown;
	private double pPos;
	private double pNeg;
	private double pPosUp;
	private double pNegUp;
	private double pPosDown;
	private double pNegDown;
	
	
	private double getpPosUp() {
		return pPosUp;
	}

	private void setpPosUp(double pPosUp) {
		this.pPosUp = pPosUp;
	}

	private double getpNegUp() {
		return pNegUp;
	}

	private void setpNegUp(double pNegUp) {
		this.pNegUp = pNegUp;
	}

	private double getpPosDown() {
		return pPosDown;
	}

	private void setpPosDown(double pPosDown) {
		this.pPosDown = pPosDown;
	}

	private double getpNegDown() {
		return pNegDown;
	}

	private void setpNegDown(double pNegDown) {
		this.pNegDown = pNegDown;
	}

	private double getpUp() {
		return pUp;
	}

	private void setpUp(double pUp) {
		this.pUp = pUp;
	}

	private double getpDown() {
		return pDown;
	}

	private void setpDown(double pDown) {
		this.pDown = pDown;
	}

	private double getpPos() {
		return pPos;
	}

	private void setpPos(double pPos) {
		this.pPos = pPos;
	}

	private double getpNeg() {
		return pNeg;
	}

	private void setpNeg(double pNeg) {
		this.pNeg = pNeg;
	}

	public void getProbabilities(HashMap<String, Event> events) {
		Iterator<Entry<String, Event>> iterator = events.entrySet().iterator();
		Entry currentEvent = null;
		int eventCount = events.size();
		int positiveCount = 0;
		int negativeCount = 0;
		int upCount = 0;
		int downCount = 0;
		int posUpCount = 0;
		int negUpCount = 0;
		int posDownCount = 0;
		int negDownCount = 0;
		
		while(iterator.hasNext()) {
    		currentEvent = iterator.next();
    		Event event = (Event) currentEvent.getValue();
    		if(event.getFeeling().equals("Positive")) {
    			positiveCount++;
    		}
    		if(event.getFeeling().equals("Negative")) {
    			negativeCount++;
    		}
    		if(event.getVariation() > 0) {
    			upCount++;
    			if(event.getFeeling().equals("Positive")) {
    				posUpCount++;
    			}
    			if(event.getFeeling().equals("Negative")) {
    				negUpCount++;
    			}
    		}
    		if(event.getVariation() < 0) {
    			downCount++;
    			if(event.getFeeling().equals("Positive")) {
    				posDownCount++;
    			}
    			if(event.getFeeling().equals("Negative")) {
    				negDownCount++;
    			}
    		}
    	}
		
		setpDown(downCount/eventCount);
		setpNeg(negativeCount/eventCount);
		setpPos(positiveCount/eventCount);
		setpUp(upCount/eventCount);
		setpNegDown(negDownCount/downCount);
		setpNegUp(negUpCount/upCount);
		setpPosDown(posDownCount/downCount);
		setpPosUp(posUpCount/upCount);
	}
	
	public double probabilityDownGivenPositive() {
		return probabilityAGivenB(getpPosDown(), getpDown(), getpUp());
	}
	
	public double probabilityUpGivenPositive() {
		return probabilityAGivenB(getpPosUp(), getpUp(), getpPos());
	}
	
	public double probabilityDownNegative() {
		return probabilityAGivenB(getpNegDown(), getpDown(), getpNeg());
	}
	
	public double probabilityUpNegative() {
		return probabilityAGivenB(getpNegUp(), getpUp(), getpNeg());
	}
	
	public double probabilityAGivenB(double pBA, double pA, double pB) {
		return (pBA*pA)/pB;
	}
}
