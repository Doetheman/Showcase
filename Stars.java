/**COMP163 Display Star
  Dr. Ken Williams
  Dorian Holmes
  10/27/2017
*/

public class Stars{

public void drawStars(java.awt.Graphics sky) throws java.io.FileNotFoundException{
   java.io.File info = new java.io.File ("stars.txt"); // reads txt file
   java.util.Scanner data = new java.util.Scanner (info); // ,makes txt file object 
   java.io.File bam = new java.io.File ("constellations.txt"); // reads txt file
   java.util.Scanner line = new java.util.Scanner (bam); //makes it an object
   
   double x,y,z,magnitude,x1,y1,xT,yT; //Variable hold txt file values and coordinates
   int nLarge, xInt,x2,y2,z2,yInt,xInt2,yInt2; //maximum variable to hold max value. x and y variables to hold pixels
   while( data.hasNextDouble()){ //read star text
      x = data.nextDouble();
      y = data.nextDouble();
      z = data.nextDouble();
      data.nextDouble();
      magnitude = data.nextDouble();
      data.nextDouble();
      
      x2 = coord2pixel (x); //convert coordinates to pixels
      y2 = coord2pixel (y);
      z2 = coord2pixel (z);
      
      nLarge= (int)(5.0 - magnitude)+1; //larger stars
      
      if ( magnitude < 5.0 && z > 0){ //draw stars
      sky.setColor(java.awt.Color.white);
      sky.fillRect(x2,y2,max,max);
      }
      }
      while( line.hasNext()){ //read constellation txt file
      xT = line.nextDouble();
      yT = line.nextDouble();
      x1 = line.nextDouble();
      y1 = line.nextDouble();
      
      xInt = coord2pixel(xT); // convert to pixels
      yInt = coord2pixel(yT);
      xInt2 = coord2pixel(x1);
      yInt2 = coord2pixel(y1);
      sky.setColor(java.awt.Color.BLUE);  //connect stars with blue line
      sky.drawLine(xInt,yInt,xInt2, yInt2);
      }
      }
      private int coord2pixel( double coord ) { /**coord2pixel converts coordinates to pixels*/
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
      return pixels; //returns value
   }
   
   private static void main (String[] args) {
      StarFrame window = new StarFrame();
   }       
}
   