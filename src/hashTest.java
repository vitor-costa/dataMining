import java.util.HashSet;


public class hashTest {
	public static void main(String[] args) {
		HashSet<String> hash = new HashSet<String>();
		hash.add("casa");
		
		if(hash.contains("casa")) {
			System.out.println("OK");
		}
	}
}
