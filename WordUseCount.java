/*COMP163 Word Use Count
  Dr. Ken Williams
  Dorian Holmes
  10/12/2017
*/
public class WordUseCount{
   public static void main( String[] args) throws java.net.MalformedURLException,java.io.IOException { 
      java.util.Scanner keyboard = new java.util.Scanner(System.in);       
      System.out.print("Enter the URL");       
      String mixedFileName = keyboard.next(); //stores what user enters in 
      String filename  = mixedFileName.toLowerCase();  //makes it lowercase
      java.net.URL webFile = new java.net.URL(filename);       
      java.util.Scanner file = new java.util.Scanner(webFile.openStream()); //opens and declare url as object
      int count = 0; // declare variable
      System.out.print("Enter word");
      String word = keyboard.next().toLowerCase().trim(); //stores word as a lowercase
      int find = 0; 
      int pos = 0; 
      String line; //declare variable
      while(file.hasNext()) {
         line = file.nextLine(); // read line
         line = line.toLowerCase();// makes line lower case
         pos = line.indexOf(word);
         while(pos != -1){
            count++; //incrument number of loops occuring
            pos = line.indexOf(word,pos+1);   // find word        
         }
      }
      System.out.println( word + " occurs " +count+" time."); // Prints output on screen
      
   }
}