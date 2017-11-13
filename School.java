/*COMP163 School Ratings 
  Dr. Ken Williams
  Dorian Holmes
  10/05/2017
*/
public class School {
   public static void main( String [] args) throws java.io.IOException { //Allows the program to handle the file exception
      int Bs = 0, inState = 0, outState = 0, lowestInState = 10000, highestInState = 0; //Declare variables
      double retention = 0.0, bestRetention = 0.0, lowestRetention = 1;
      String highestName = "", lowestName ="", bestR = "", lowestR = ""; 
   
      java.io.File info = new java.io.File("NCuniversityData.dat"); //Reads file from folder 
      java.util.Scanner data = new java.util.Scanner( info ) ;//Declare file as an object
   
      while( data.hasNext()){//Declares varibles for data in file
         Bs = data.nextInt();
         inState = data.nextInt();
         data.nextInt();
         retention = data.nextDouble();
         String name = data.nextLine();
         if(( Bs != 0) && ( Bs != 2)){
            if( retention > bestRetention && retention != -9999){ //Finds the highest retention rate and its school
               bestRetention = retention;
               bestR = name; // 
            }
            if(retention < lowestRetention && retention != -9999){//Finds the lowest retention rate and its school
               lowestRetention = retention;
               lowestR = name;
            }
            if(inState != -9999 && inState < lowestInState){//Finds the lowest instate cost and its school
               lowestInState = inState;
               lowestName = name;
            }
            if ( inState != -9999 && inState > highestInState){//Finds the highest instate cost and its school
               highestInState = inState;
               highestName = name;
            }}}
      System.out.println("Best retention rate is "+ bestRetention*100+ "% at"+ bestR); //Output
      System.out.println("Worst retention rate is "+ lowestRetention*100+ "% at "+lowestR);
      System.out.println("Lowest in-state cost is $"+lowestInState+" at"+lowestName);
      System.out.println("Highest in-state cost is $"+highestInState+" at"+highestName);   
        
   }}
