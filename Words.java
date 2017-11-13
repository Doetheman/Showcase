
/**COMP163 Common Words
  Dr. Ken Williams
  Dorian Holmes
  11/09/2017
*/
import java.util.*;
import java.io.*;
public class Words {

   public static void main (String[] unused)throws IOException {
   
   
      UseCount[] wordArray = new UseCount [10000]; /*Creates an array that can hold 10,000 UseCount objects*/
      int wordCount = 0; //Declare into to count word
   
      java.util.Scanner keyboard = new java.util.Scanner(System.in); //Read keyboard input
      System.out.println("Enter file"); // Output text
      String file = keyboard.next(); //Alows user to input text
   
      File data = new File(file);//Get file from folder
      Scanner info = new Scanner(data) ; //declare as object in program
   
      while(info.hasNext()){ //reads file
         String word = info.next().toLowerCase(); //Changes file text to lower case
         word = cleanWord(word); //Uses the cleanWord method on word
      
         boolean tf = false; //Declare boolean 
      
         for( int i = 0; i < wordCount; i++){ // Search through each word and compare to words in array
         
            if(word.equals(wordArray[i].getWord())){
               wordArray[i].increment();
               tf = true;
            }
         }
         
         if(!tf){  //If not true creates new object for word and put in the array
            UseCount x = new UseCount( word);
            wordArray[wordCount] = x;
            wordCount++;
         }
      }
      java.util.Arrays.sort( wordArray, 0, wordCount ); //put words in descending order
       
      for( int j = 0; j < 25; j++) //Outputs the first 25 words and number of times they appeared
         System.out.println( wordArray[j].getCount()+ "  \t" + wordArray[j].getWord()); 
   }
   
   private static String cleanWord( String dirty ) {    
      int numChar = dirty.length() - 1;                     // index of last character    
      while (!Character.isLetter(dirty.charAt(numChar))) {  // if ends in non-letter       
         if (numChar == 0) {                                // if only one character         
            return null;                                    // nothing left       
         }       
         dirty = dirty.substring(0,numChar);                // remove last character       
         numChar--;                                         // decrement last char index    
      }    
      while (!Character.isLetter(dirty.charAt(0))) {        // if starts with non-letter       
         dirty = dirty.substring(1);                        // remove first character   
      }    
      return dirty;   
   } 
}