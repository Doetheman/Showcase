/**COMP163 Bouncing Circles
  Dr. Ken Williams
  Dorian Holmes
  10/26/2017
*/

import java.awt.*;
import java.util.*;
import java.io.*;
public class StarsL {
   public void drawStars(java.awt.Graphics sky) throws FileNotFoundException {
      File data = new File("stars.txt");//Get file from folder
      Scanner info = new Scanner( data) ; //declare as object in program
      double x, y, z, magnitude;
      int x2, y2, z2;
      while ( info.hasNextDouble()){
         x = info.nextDouble();
         y = info.nextDouble();
         z = info.nextDouble();
         info.nextDouble();
         magnitude = info.nextDouble();
         info.nextDouble();
         
         x2 = coord2pixel(x);
         y2 = coord2pixel(y);
         z2 = coord2pixel(z);
         
         if ( (magnitude < 5.0) && ( z > 0.0)){
            sky.setColor(Color.white);
            sky.fillRect(x2,y2,2,2);
         }
      } 
   }
   private int coord2pixel( double coord ) {
   //convert coordinate location to pixels
      int pixels = 0;
      if (coord > 0.0){
         return (int)(coord*450+450);
      }
      
      else if (coord < 0.0){
         return (int)(coord*450+450);
         
      }else{
         coord = 450;
      }
      return pixels;
   }
   
   private static void main (String[] args) {
      StarFrame window = new StarFrame();
   }       
}