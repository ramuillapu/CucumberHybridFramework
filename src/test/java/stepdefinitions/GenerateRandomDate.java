package stepdefinitions;

import java.util.Date;

public class GenerateRandomDate {

	public static void main(String[] args) {
		
		String email = generateRandomEmail();
		
		
	}
		public static String generateRandomEmail() {
			
			Date date = new Date();
			String dateString = date.toString();
			String removeAllspaces = dateString.replaceAll(" ", "");
			String removeAllColumns = removeAllspaces.replaceAll(":", "");
			String completEmail = removeAllColumns+"@gmail.com";
			return completEmail;
		}


}
