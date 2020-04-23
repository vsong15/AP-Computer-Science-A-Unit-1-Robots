   //Name______________________________ Date_____________
public class Athlete extends Robot //estends describes the hierarchy
{
   public Athlete()//default constructor
   {
      super(1, 1, World.NORTH, World.INFINITY);
            //super refers to one class UP! (Robot)
   }
         
   public Athlete(int x, int y, int dir, int beep)//4-arg construction
   {
      super(x, y, dir, beep);
   }
      
   public void turnAround()
   {
      this.turnLeft();
      this.turnLeft();      
   }
      
   public void turnRight()
   {
      turnLeft();
      turnLeft();
      turnLeft();     
   }
   public void plop()
   {
      putBeeper();
      move();
   }
}