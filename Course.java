/*COMP163 Course Information Program
  Dr. Ken Williams
  Dorian Holmes
  11/03/2017
*/

public class Course{
   public static void main ( String [] args)throws java.io.IOException { //Main program
   
   /** As file is being read, object will be put into hash table
       Allows user to input text from keyboard
   */
      java.util.Hashtable<String,csClass> hash = new java.util.Hashtable<>();
      
      java.io.File data = new java.io.File("CScourses.txt");
      java.util.Scanner info =  new java.util.Scanner( data);
      
      java.util.Scanner keyboard = new java.util.Scanner(System.in);
      String EnteredNumber = ""; //Declare variable to hold user input
      
      while( info.hasNext()){ //Reads file
         String courseNumber = info.next();
         String crn          = info.next();
         String lastName     = info.next();
         String time         = info.next();
         String days         = info.next();
         String room         = info.next();
         String title        = info.nextLine();
      /** @param csClass Retrieves data using get method to put in the hash table 
      */
         csClass courseInfo  = new csClass( courseNumber, crn, lastName,
                   days,time, room, title);
         hash.put( courseNumber, courseInfo); 
      }
      /** Asks for user input and gives course description
          until the user input is END
      */
      while(true){
         System.out.println("Enter course number");
         EnteredNumber = keyboard.next(); 
         csClass found = hash.get( EnteredNumber ); 
      
         if (found == null){    // if course is not in the table 
         
            System.out.println ( "No such course");
         }else{
            System.out.println("CRN: "+ found.CRN+" Instructor: "+found.profLastN+" " +found.course+ " days: "+found.days+" starts: "+found.time+" "+ found.room);
         }
         if(EnteredNumber.equals("END")){
            break;
         }
      }
   }
}