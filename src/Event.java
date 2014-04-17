
public class Event {
	private String date;
	private String articleText;
	private String quotation;
	private String feeling;
	private double variation;
	private String feelingScale;
	
	public String getFeelingScale() {
		return feelingScale;
	}

	public void setFeelingScale(String feelingScale) {
		this.feelingScale = feelingScale;
	}

	
	public Event(String date, String articleText) {
		this.date = date;
		this.articleText = articleText;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getArticleText() {
		return articleText;
	}
	public void setArticleText(String articleText) {
		this.articleText = articleText;
	}
	public String getQuotation() {
		return quotation;
	}
	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}
	public String getFeeling() {
		return feeling;
	}
	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

	public double getVariation() {
		return variation;
	}
	
	public void setVariation(double variation) {
		this.variation = variation;
	}
	
	
}
