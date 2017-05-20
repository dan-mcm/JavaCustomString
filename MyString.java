package a1_09556362;

public class MyString {
	
	// Returns a new string with the characters in str converted to lowercase.
	public static String toLowerCase(String str) {
		String output = "";
		
		if(str.length()==0){
			output += "";
		} else {
			for(int i=0; i < str.length(); i++){
				char initialLetter = str.charAt(i);
				if(MyCharacter.isUpperCase(initialLetter)){
					initialLetter = MyCharacter.toLowerCase(initialLetter);
					output += initialLetter;
				} else {
					output += initialLetter;
				}	
			}
		}
		return output;
	}

	// Returns a new string with the characters in str converted to uppercase.
	public static String toUpperCase(String str) {
		String output = "";	
		for(int i=0; i< str.length(); i++){
			char initialLetter = str.charAt(i);
			if(MyCharacter.isLowerCase(initialLetter)){
				char convertedLetter = MyCharacter.toUpperCase(initialLetter);
				output += convertedLetter;
			} else {
				output += initialLetter;
			}
		}
		
		return output;
	}

	// Returns true if the two strings s1 and s2 are equal; false otherwise. 
	// Two strings are considered equal if they are of the same length and 
	// corresponding characters in the two strings are equal.
	public static boolean equals(String s1, String s2) {
			
			if (s1.length() != s2.length()){
				return false;
			}
			else if (s1.length()==0 && s2.length()==0){
				return true;
			} 
			else {
				int oddCounter = 0;
					
				//this loop checks if characters are the same for each string
				//if they are not the same it increments the odd counter
				for(int i=0; i < s1.length(); i++){
					char word1Letter = s1.charAt(i);
					char word2Letter = s2.charAt(i);
					
					if (word1Letter != word2Letter){
						oddCounter += 1;
					}
					
				}
				
				if(oddCounter > 0){
					return false;
				} else {
					return true;
				}	
			}	
		}
	
	
	// Returns true if the two strings s1 and s2 are equal ignoring case; false 
	// otherwise. Two strings are considered equal if they are of the same length 
	// and corresponding characters in the two strings are equal ignoring case.
	public static boolean equalsIgnoreCase(String s1, String s2) {
			//by making both strings lower case it prevents issues comparing different case characters
			//this would also work with the toUpperCase method
			
			s1 = MyString.toLowerCase(s1);
			s2 = MyString.toLowerCase(s2);
			
			if(equals(s1,s2)){
				return true;
			} else {
				return false;
			}	
		}

	// Returns a new string with every occurrence of character ch1 in str replaced 
	// with character ch2.	
	public static String replace(String str, char ch1, char ch2) {
		String output = "";
		
		//loop checks each character in string - if character matches the users ch1 input
		//changes ch1 character to ch2 character - appends character onto output variable
		if (str.length()==0){
			output+="";
		} else {
			for(int i = 0; i < str.length(); i++){
				char letter = str.charAt(i);
				if (letter == ch1){
					output += ch2;
				} else {
					output += letter;
				}
			}
		}
		return output;
	}

	// Returns a new string with all leading and trailing whitespace characters (space 
	// or tab characters) in str removed.
	public static String trim(String str) {
		String output = "";
		int counterFront = 0;
		int counterBack = 0;
		
		//this gets counter for number white spaces before string
		for(int i = 0; i<str.length(); i++){
			char currentLetter = str.charAt(i);
			if(MyCharacter.isWhitespace(currentLetter)){
				counterFront +=1;
			} else {
				break;
			}
		}
		
		//this gets counter for number white space at end of string
		for(int i = str.length()-1; i > 0; i--){
			char currentLetter = str.charAt(i);
			if(MyCharacter.isWhitespace(currentLetter)){
				counterBack +=1;
			} else {
				break;
			}
			
		}
		
		//this uses counters as range values and generates output string
		for(int i=counterFront;i<str.length()-counterBack;i++){
			char currentLetter = str.charAt(i);
			output += currentLetter;
		}
		
		return output;
	}
	
	// Returns true if str starts with the specified prefix; false otherwise.
	public static boolean startsWith(String str, String prefix) {
		String temp = "";
		int counter = 0;
		
		//special case if prefix is empty then condition is true
		if(prefix.length() == 0){
			return true;
		//special case 2 if string is smaller then the prefix then condition is false
		} else if (str.length() < prefix.length()){
			return false;
		} else {
			
			//making a new substring from the main string equal to the length of the prefix
			for(int i = 0; i < prefix.length(); i++){
				char mainLetter = str.charAt(i);
				temp += mainLetter;
			}
			
			//comparing all the characters in substring and prefix 
			for(int i = 0; i < prefix.length(); i++){
				char originalLetter = temp.charAt(i);
				char prefixLetter = prefix.charAt(i);
				
				//incrementing a counter for each match
				if(originalLetter == prefixLetter){
					counter += 1;
				}
			}	
				//if the number of matches is the same as the length of the prefix
				//then the prefix exists
				if(counter == prefix.length()){
					return true;
				} else {
					return false;
				}
				
		}
		
	}
	
	// Returns true if str ends with the specified suffix; false otherwise.
	public static boolean endsWith(String str, String suffix) {
		String temp = "";
		int counter = 0;
		int diffL = str.length() - suffix.length();
	
		//if there both blank return true;
		if(diffL==0 && str.length()==0){
			return true;
		//if the difference is negative (suffix is longer than string) then return false....
		} else if (diffL<0){
			return false;
		} else {
		if (str.length() <= 1 && suffix.length() == 0){
			return true;
		} else {
		
				//making a new substring from the main string equal to the length of the suffix
				for(int i = diffL; i < str.length(); i++){
					char mainLetter = str.charAt(i);
					temp += mainLetter;
				}
				
				//comparing all the characters in substring and suffix 
				for(int i = 0; i < suffix.length(); i++){
					char originalLetter = temp.charAt(i);
					char suffixLetter = suffix.charAt(i);
					//incrementing a counter for each match
					if(originalLetter == suffixLetter){
						counter += 1;
					} else {
						counter += 0;
					}
				}
					
					//if the number of matches is the same as the length of the suffix
					//then the prefix exists
					if(counter == suffix.length()){
						return true;
					} else {
						return false;
					}
					
				}
			}
		
	}
}
