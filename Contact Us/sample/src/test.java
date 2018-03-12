import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class test {
	/*public static void main(String args[]){
		DecimalFormat df = new DecimalFormat("0.00");
		float f = -8.0222222f;
		f = Float.parseFloat(df.format(f));
		System.out.println(f);
		String val1 = "5.19";
		String val2 = "5.19";
		if(val1 == val2){
			System.out.println("Pass");
		}
		else 
			System.out.println("Fail");
		
	}*/
	 /*public static void main(String args[]){
		 int i=0;
		while (i< 9){
			
			int tar = 2;
    		//String tar1 = Integer.toString(tar);
			System.out.println("Hello"); 
			System.out.println(i);
		
			i = i+2;
		 }
		
	 }*/
	 
	public static void main(String args[]) throws IOException{
		/*Runtime rt = null;
		rt = Runtime.getRuntime();
		rt.exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe google.com");
		*/
		 Date date1 = new Date();
		  System.out.println(date1);
		  DateFormat dateFormat = new SimpleDateFormat("dd MMMMMMMMM yyyy");     
		  String dateFormatted = dateFormat.format(date1);    //date format will now be `31 DEC 2014
		  System.out.println(dateFormatted);
		  Calendar c1 = Calendar.getInstance();
		    
		  String todayDate = dateFormat.format(c1.getTime());
		  System.out.println(todayDate);
		  c1.add(Calendar.MONTH,4);
		  System.out.println("gggggggggggggggg" + c1.getTime());
		  String tomorrowsDate = dateFormat.format(c1.getTime());
		  System.out.println(tomorrowsDate);
		  c1.add(Calendar.DATE,-2); 
		  c1.getTime();
		  System.out.println(  c1.getTime());
		  String yesterdaysDate = dateFormat.format(c1.getTime());
		  System.out.println(yesterdaysDate);
	}
	/* public static void main(String[] args){
         String[] set1 = {"1","2"};
         String[] set2 = {"A","B","C"};
         String[] set3 = {"$", "%", "£", "!"};
         Object[][] sets = {set1, set2, set3};

         printCombinations(sets);
 }


 private static void printCombinations(Object[][] sets){
     int[] counters = new int[sets.length];

     do{
        System.out.println(getCombinationString(counters, sets));
     }while(increment(counters, sets));
 }

 private static boolean increment(int[] counters, Object[][] sets){
         for(int i=counters.length-1;i>=0;i--){
             if(counters[i] < sets[i].length-1){
                 counters[i]++;
                 return true;
             } else {
                 counters[i] = 0;
             }
         }
         return false;
 }

 private static String getCombinationString(int[] counters, Object[][] sets){
     String combo = "{";
     for(int i = 0; i<counters.length;i++){
         combo = combo+sets[i][counters[i]]+",";
     }
     return combo.substring(0,combo.length()-1)+"}";

 }
*/

}
