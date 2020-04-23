public class Racer extends Athlete
{
   public Racer(int y)
   {
      super(1, y, World.EAST, 0);
   }
   public void jumpRight()
   {
      turnLeft();
      move();
      turnRight();
      move();
      turnRight();
      move();
      turnLeft();
   }
   public void jumpLeft()
   {
      turnRight();
      move();
      turnLeft();
      move();
      turnLeft();
      move();
      turnRight();
   }
   public void sprint(int n)
   {
      for(int i=0; i<n; i++)
         move();
   }
   public void shuttle(int n)
   {
      move();
      jumpRight();
      sprint(n);
      pickBeeper();
      turnAround();
      sprint(n);
      jumpLeft();
      move();
      putBeeper();
      turnAround();
   }
}