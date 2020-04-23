//in Lab00.java
//Mr. Murray P.2, Vincent Song, 9/6/2019
public class Lab00
{
   public static void main(String[]arg)
   {
      World.readWorld("first");
      World.setSize(10,10);
      World.setSpeed(8);
      
      //create an instance of a Robot
      
      Robot karel = new Robot();
      karel.move();
      karel.pickBeeper(); 
      karel.move();
      karel.turnLeft();
      karel.move();
      karel.putBeeper();
      karel.move();
      karel.turnLeft();
      karel.turnLeft();
   }
}