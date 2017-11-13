
/*COMP163 Weather Trends
  Dr. Ken Williams
  Dorian Holmes
  10/06/2017
*/
  public class GreenWeather {
   public static void main( String [] args) throws java.io.IOException {
   
      int year = 0, years=0, month = 0, day = 0, dailyLow = 0, precipitation = 0 , snow = 0, dailyHigh = 0;//declare variables
      int totalDays = 0;
      double fsum = 0.0, yearSum = 0.0, year2 = 0.0, yearLow = 0.0, yearTLow = 0.0;
   
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
         double f = 0.0; //Declare variable for fahrenhrit 
         f = ((9.0*dailyLow)/50.0)+32.0; //
         fsum += f; 
         totalDays++;
         if( month == 12 && day == 31) {
            double avgLow = fsum/totalDays;  // Calculate the average low temps
            System.out.println(year+" "+ avgLow); //Outputs the year and average low for each year
            years++; // counts year
            yearSum += year; // sum year number
            year2 += Math.pow(year,2); //year number squared
            yearLow += avgLow; //sum the average low
            yearTLow += year * avgLow; //year times the average low
            totalDays = 0; //reset days
            fsum = 0; // reset low temp
         }}// repeats untill it goes through all the data in file
         double slope = ((years)*(yearTLow)-(yearSum)*(yearLow))/(years*year2-yearSum*yearSum);//Calculate slope
         System.out.println("increase in annual low is "+slope+" degrees per year "+1/slope+" year to change one degree");//Outputs the slope and year yo change on degree
         }}