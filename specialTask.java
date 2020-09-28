class specialTask {

	//This is used to set year boundaries
	static int MaxValidYear = 9999; 
	static int MinValidYear = 0; 
	
	public static void main(String[] args) {  
		printBonusDatesBetween(0, 9999); 
	}

	static void printBonusDatesBetween(int fromYear, int toYear) {
		for (int year = fromYear; year < toYear; year++) 
	    { 
	        String str; 
	  
	        // Year is stored as a string to have 0's in case they are needed
	        while(true) {
	        	if(year < 10) {
		        	str = "000" + String.valueOf(year);
		        	break;
		        } else {
		        	if(year < 100) {
			        	str = "00" + String.valueOf(year);
			        	break;
			        } else {
			        	if(year < 1000) {
				        	str = "0" + String.valueOf(year);
				        	break;
				        } else {
				        	str = String.valueOf(year);
				        	break;
			    		}
		    		}
	    		}
	        }
	        
	        // Year string is stored in reverse
	        String rev = str; 
	        rev = reverse(rev); 
	  
	        // The day and the month is taken oun of the reversed year string
	        int month = Integer.parseInt(rev.substring(0, 2)); 
	        int day = Integer.parseInt(rev.substring(2, 4)); 
	  
	        // If the current date is valid and reversed, it is printed out
	        if (isValidDate(year, month, day)) 
	        { 
	        	String dayStr;
	        	String monthStr;
	        	
	        	// If the day of month is less than 10 - add 0 to the front
	        	if(day < 10) {
	        		dayStr = "0" + day;
	        	} else {
	        		dayStr = String.valueOf(day);
	        	}
	        	
	        	// If the month is less than 10 - add 0 to the front
	        	if(month < 10) {
	        		monthStr = "0" + month;
	        	}else {
	        		monthStr = String.valueOf(month);
	        	}
	        	
	            System.out.print(str + "-" + monthStr + "-" + dayStr + "\n"); 
	        } 
	    } 
	}
	
	// This method reverses the inputted information
	static String reverse(String input)  { 
	        char[] a = input.toCharArray(); 
	        int l, r = a.length - 1; 
	        for (l = 0; l < r; l++, r--)  
	        { 
	            char temp = a[l]; 
	            a[l] = a[r]; 
	            a[r] = temp; 
	        } 
	        return String.valueOf(a); 
	   } 
	  
	// Returns true if given year is leap
	static boolean isLeap(int year) 
	{ 
	    // Return true if year is a multiple of 4 and not multiple of 100. 
	    // OR year is multiple of 400. 
	    return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)); 
	} 
	  
	// Returns true if given 
	// year is valid or not. 
	static boolean isValidDate(int year, int month, int day) 
	{ 
	    // If year, month and day are not in given range 
	    if (year > MaxValidYear || year < MinValidYear) 
	        return false; 
	    if (month < 1 || month > 12) 
	        return false; 
	    if (day < 1 || day > 31) 
	        return false; 
	  
	    // Handle February month as leap year 
	    if (month == 2) { 
	        if (isLeap(year)) 
	            return (day <= 29); 
	        else
	            return (day <= 28); 
	    } 
	  
	    // Months of April, June, September and November must have number of days less than or equal to 30
	    if (month == 4 || month == 6 || month == 9 || month == 11) {
	    	return (day <= 30); 
	    }
	  
	    return true; 
	} 
}
