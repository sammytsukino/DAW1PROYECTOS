import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ejercicio1 {

	public static void main (String [] args) {
		
		//Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)@([a-zA-Z0-9]+[.]([a-z]{2,5}$)");
		//Pattern pattern = Pattern.compile("^([0-9])([!@#$%&])([a-z])([A-Z]{8}$)");
		Pattern pattern = Pattern.compile("^([A-Z])([0-9]){4}$");
		Matcher matcher = pattern.matcher("DAME");
		
		boolean matchFound = matcher.find();
		if(matchFound) {
			System.out.println("Match found");
		}else {
			System.out.println("Match not found");
		}
		
		
		
		
	}
}