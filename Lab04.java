public class Lab04
{
   public static void main(String[]args)
   {
      World.readWorld("mountain");
      World.setSize(16,16);
      World.setSpeed(20);
      
      Climber jerry = new Climber(8);
      jerry.turnRight();
      jerry.move();
      jerry.climbUpRight();
      jerry.climbUpRight();
      jerry.climbUpRight();
      jerry.climbDownRight();
      jerry.climbDownRight();
      jerry.pickBeeper();
      jerry.climbDownRight();
      jerry.move();
      jerry.turnLeft();
      jerry.turnLeft();
      jerry.move();
      jerry.climbUpLeft();
      jerry.climbUpLeft();
      jerry.climbUpLeft();
      jerry.climbDownLeft();
      jerry.climbDownLeft();
      jerry.climbDownLeft();
      jerry.move();
      jerry.turnRight();
   }
}