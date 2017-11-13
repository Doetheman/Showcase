/**COMP163 Common Words
  Dr. Ken Williams
  Dorian Holmes
  11/09/2017
*/
public class UseCount implements Comparable<UseCount> { 
   String testWord = ""; /* Two instance variable. String hold english words. Int incuments. */
   int count = 1;

/* For sorting with the Comparable interface */ 
   public UseCount(String countWord){ /**@Param UseCount implement the Comparable interface and include a method compareTo*/
      testWord = countWord;
   }

   public void increment(){ // Counts time word use
      count++;
   }
   public int getCount() { // returns count
      return count;
   }
   public String  setWord(){ //Set word to testWord
      return testWord;
   }
   public String getWord(){ //returns testWord
      return testWord;
   }

   public int compareTo( UseCount other ) {  /**@Param sorts with comparable interface */   
      return other.count - this.count;    
   } 

}