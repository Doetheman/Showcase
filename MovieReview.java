/**COMP163 Movie Review Evaluation
  Dr. Ken Williams
  Dorian Holmes
  11/03/2017
*/

public class MovieReview{
   public static void main ( String [] args)throws java.io.IOException {
   
      java.io.File data = new java.io.File("movieReviews.txt");
      java.util.Scanner info =  new java.util.Scanner( data) ;
      /**
      Get file from folder.
         declare as object in program.
         */
      java.util.Hashtable<String, WordValue> dict = new java.util.Hashtable<>(18000); 
   /** Put an object in the dictionary,giving it both the WordValue object to store. 
       In the dictionary and a key String to find it. 
   Declare begin as WordValue reference.
   While read more data in the file.
     Read rating level number.  
         Read next word.  
         Convert to lower case.  
         While word not equal to "." and if first character is a letter the word will not be ignored.
         */
      WordValue begin;
   
      int rating = 0,tempRating = 0; //declare variables
      String word;
      while( info.hasNext()){
         rating = info.nextInt();
         word = info.next().toLowerCase();
      
         while( !word.equals(".")){
         
            if(Character.isLetter(word.charAt(0))){
               begin = dict.get(word);
               if( null == begin){
                  begin = new WordValue(tempRating);
                  dict.put( word,begin );
               }else{
                  begin.addRating( tempRating) ;
               }
            }    
            info.next();
            word = word.toLowerCase();
         
         }       
      }     
      /**
      Read user's keyboard.
      Convert word to lower case.
      If begin not null program will add begin.avgRating() to sum for review.  
      Increment count of words in review.
      Read word and convert to lower case review average is sum dived by count of words.
      If review average is greater than 2.0 display positive else display negative.
      */
      java.util.Scanner keyboard = new java.util.Scanner(System.in) ;
    
      System.out.println(" Enter in your Review" );
    
      String userReview = keyboard.next();
             
             
      userReview= userReview.toLowerCase();
             
      double  ratingTotal=0;
      double count=0; 
      while (! userReview.equals(".")){
      
         begin = dict.get(userReview); 
         count++;
          
         if (  begin != null ) {               
            ratingTotal= begin.avgRating();
            begin.addRating(tempRating);
         }
         userReview= userReview.toLowerCase();
      }    
      double amountOfAvg = ratingTotal/ count;
                
      System.out.println( " The average of this rating is " + ratingTotal );
   
      if ( amountOfAvg > 2.0){
         System.out.println (" Positive Review");
      }else{
         System.out.println( " Negative Review");
       
      }      
   } 

}



