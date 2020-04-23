public class Climber extends Athlete
{
   public Climber(int x)
   {
      super(x, 1, World.NORTH, 1);
   }
   public void climbUpRight()
   {
      turnLeft();
      move();
      move();
      turnRight();
      move();
   }
   public void climbUpLeft()
   {
      turnRight();
      move();
      move();
      turnLeft();
      move();
   }
   public void climbDownRight()
   {
      move();
      turnRight();
      move();
      move();
      turnLeft();
   }
   public void climbDownLeft()
   {
      move();
      turnLeft();
      move();
      move();
      turnRight();
   }   
}