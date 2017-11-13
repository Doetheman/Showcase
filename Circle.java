/**COMP163 Bouncing Circles
  Dr. Ken Williams
  Dorian Holmes
  10/26/2017
*/

public class Circle {
   double xc = 0.0,yc = 0.0,radius = 0.0,speed = 0.0, dir = 0.0; /** declares variables*/
   Circle( double x, double y, double radius) { /**@ param x x coordinate, @param y y coordinate, @param radius radius of circle */
       this.yc= y;
      this.xc = x;
      this.radius = radius;
   }
   public double getY() { /** Returns the y coordinate of the center of circle. */ 
      return yc; 
   }
   public void setY( double vert ){  /* set the y coordinate */
      vert = yc;
   }
   public double getX() { /** @Return xc Returns the x coordinate of the center of circle. */
      return xc; 
   }
   public void setX( double horz ){  /** @param horz sets the x coordinate */
      horz = xc; 
   }
   public double getSpeed() { /** @Return speed Returns the speed of the circle */ 
      return speed;
   }
   public void setSpeed( double fast ) { /** @param fast Set the speed of the circle */ 
      speed  = fast;
   }
   public double getDir(){  /** @ Return dir  Returns the direction of movement */ 
      return dir;
   }
   public void setDir( double compass ){ /** @Param compass Set the direction of the circle in radians */ 
      dir = compass;
   }
   public double getRadius() { /** @return radius Returns the radius of this circle. */ 
      return radius;
   }
   public void move( double time ){ /** @param time Updates the x and y coordinates after the time  */ 
      xc = xc+Math.cos(dir)* speed * time;
      yc = yc+Math.sin(dir)* speed * time;
   }
   public boolean touches( Circle other ){/** @param touches True if the other circle touches this circle */ 
      double twoRadii= radius+ other.getRadius();
      double x2 =  other.getX();
      double y2 =  other.getY();
      double distance = Math.sqrt((Math.pow(( xc - x2),2)) + (Math.pow((yc - y2),2)));
      if (distance < twoRadii)
         return true;
      return false;
      }
   
   public static void main(String[] unused){       
      Box.animate();    }
}
