/* COMP163 State Location
Dr. Ken William
Dorian Holmes
10/19/2017
*/

public class StateLocation {
   public static void main ( String [] args) throws java.io.IOException{
   
      java.util.Scanner keyboard = new java.util.Scanner(System.in); //Read keyboard input
      java.io.File info = new java.io.File("states.txt"); //Reads file from folder 
      java.util.Scanner data = new java.util.Scanner( info ) ;//Declare file as an object
      
      double lat = 0.0, longitude = 0.0, x = 0.0, y = 0.0, x2 = 0.0, y2 = 0.0, distance = 0.0, closestDistance = 50000; //Holds value 
      String closestState = ""; //Holds the closest state

   
      System.out.println("Enter your X and Y location");
      x = keyboard.nextDouble();  // User input for latitude 
      y = keyboard.nextDouble(); // user input for longitude
   
   
      while(data.hasNext()) { // Reads in program
         lat = data.nextDouble();
         longitude = data.nextDouble();
         String state = data.nextLine();
         double latdifference = x - lat;
         double longDifference = y - longitude;
         distance = Math.sqrt((Math.pow(latdifference,2))+Math.pow(longDifference,2)); //calculate distance
      
         if( distance < closestDistance){ // Finds lowest distance
            closestDistance = distance; // Stores lower distance 
            closestState = state; // Stores state with the lowest distance
         }
      }
      System.out.println( closestState+ " is the closest state"); // Output results
   }
}
  
 
 
