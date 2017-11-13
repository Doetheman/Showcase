/*COMP163 Average Frost
  Dr. Ken Williams
  Dorian Holmes
  10/13/2017
*/
public class DailyFrost {
   public static void main( String [] args) throws java.io.IOException {
   
      int year = 0, years=0, month = 0, day = 0, dailyLow = 0, precipitation = 0 , snow = 0, dailyHigh = 0;//declare variables
      double lowest = 0.0, dYear = 0.0, yearCount = 0.0, avgCount = 0.0;
      String calaDay = null;
      boolean found = true;
      java.io.File data = new java.io.File("weatherDaily.dat");//Get file from folder
      java.util.Scanner info = new java.util.Scanner( data ) ; //declare as object in program
   
      while( info.hasNextInt()){ //Declare data in file as variables
         year = info.nextInt();
         month = info.nextInt();
         day = info.nextInt();
         precipitation = info.nextInt();
         snow = info.nextInt();
         dailyHigh = info.nextInt();
         dailyLow = info.nextInt();
                 
         if( found == true && dailyLow < 0 && month > 7){  
            found = false;
            System.out.println("Date of first frost "+ month + "," + day + ","+ year);
            dYear += dayOfYear(year,month,day); //Convert year, month and day to day of the year. 
            yearCount++; //day count
            avgCount = (dYear / yearCount); //average day
         }
         if( month == 12 && day == 31) {
            found = true;
         
         }
      
      }
      System.out.println("Average first frost is the "+avgCount+" day of the year");
      System.out.println("Average first frost is on "+monthDay(avgCount));//day of the year to month / day  
   
   }
  /* Day of the year for first of month */    
   static final int[] monthSum = {0, 31, 59, 90, 120, 151, 181, 212,
   243, 273, 304, 334, 366};        
  /**     * Convert year, month and day to day of the year.     
  * @param y year     
  * @param m month    
   * @param d day     
   
   */
  
   static int dayOfYear( int y, int m, int d ) {       
      int doy = d + monthSum[m-1]; // simple day of the year       
      if (y % 4 == 0 && m > 2) {   // if leap year and after Feb 29          
         doy++;                    // add one to day for leap day       
      }       
      return doy;    }    /**    
     * Convert day of the year to month / day      
     * @param dday day of the year     
     */    
   static String monthDay( double dday ) {       
      int day = (int)(dday + 0.5);     // round off to integer day       
      for (int month = 1; month <= 12; month++) {         
         if (day <= monthSum[month]) {             
            return month +"/"+ (day - monthSum[month-1]);         
         }       
      }      
      return "?/?";   
   }
}