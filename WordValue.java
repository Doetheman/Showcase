/**COMP163 Movie Review Evaluation
  Dr. Ken Williams
  Dorian Holmes
  11/03/2017
*/
public class WordValue{ 
   int       wordCount = 0;  //Instance variables to hold count of words and the sum of ratings
   int      sumRatings = 0;
   /**
   @param total initialize sum to a parameter
   @param rating increments the use count by one and adds the rating to the sum. 
   @param avgRating returns the average rating
   */
   public WordValue(int total){
  sumRatings = total;
  
   }
   public void addRating(int rating){
      wordCount++;
      sumRatings += rating;
   }
   public double avgRating(){
      return sumRatings/wordCount;
   }
}