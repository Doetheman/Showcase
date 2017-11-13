/**COMP163 Drunk Driver
  Dr. Ken Williams
  Dorian Holmes
  11/10/2017
*/

public class DrunkDriver { 
   public static void main( String [] Doeman) throws java.io.IOException {
   
      int [] accidents = new int [24] ; // Array stores number of accidents for the hour
      int [] drunkAcc = new int [24]; //number of drunk
      
      java.io. File data = new java.io.File("accident.txt"); /** Read file*/
      java.util.Scanner info = new java.util.Scanner(data); /** Make file */
     
      int day = 0, month = 0, hour = 0, minute = 0, DayOfWeek = 1, drunkDrv = 0, leastAcc = 5000000, leastDang = 5, mostAcc = 0, mostDang = 0, drunkHour = 0;
      double mostDrunk = 0.0; /**Declare variables*/
      
      
      while(info.hasNextInt()){/** Declare file text to variables*/
         day = info.nextInt();
         month = info.nextInt();
         DayOfWeek = info.nextInt();
         hour = info.nextInt();
         minute = info.nextInt();
         drunkDrv = info.nextInt();
         
                  if(hour < 24){  /**count the total number of accidents in that hour within 24 hours*/
            accidents[hour]++;
            if(drunkDrv > 0){ /**count the number of accidents that involved a drunken driver*/
               drunkAcc[hour]++;
            }
         } 
         }
      System.out.format("%7s %5s %5s","hour","accidents","% drunks"); /**Prints hour, accidents, and drunk above columns*/
      System.out.println();
      for( int i = 0; i <24; i++){ /**Loop will start 24 times */                                    
         double avg = drunkAcc[i] * 100.1/ accidents[i];
         
         if( avg > mostDrunk){ /** Find hour with most drunk accidents*/
         mostDrunk = avg; 
         drunkHour = i;
         }
         if( accidents[i] > mostAcc){ /** Finds hour with most accidents*/
         mostAcc = accidents[i];
         mostDang = i;
         }
         if( accidents[i] < leastAcc){ /** Finds hour with least accidents*/
         leastAcc = accidents[i];
         leastDang = i;
         }
         
         System.out.format("%5d:00 %5d %7.2f" ,i, accidents[i] ,avg); /** prints out hours, accidents, and drunk average*/
         System.out.println();
               }
         System.out.println("The safest hour to drive is " +leastDang+":00"); /** Prints least of hour with least accidents*/
         System.out.println("The most dangerous hur to drive is " +mostDang+":00");/** prints hour with most accidents*/
         System.out.println("The hour of most drunk drivers is " +drunkHour+":00");/** prints hour with most drunk driver */

   }}