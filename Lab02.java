//Lab02
//Vincent Song
public class Lab02
{
   public static void main(String[]args)
   {
      //three world lines
      World.readWorld("maze");
      World.setSize(8,8);
      World.setSpeed(9);
      //create your athlete
      
      Athlete rafael=new Athlete();
      //athlete Rafael=new Athlete(1,1,World.NORTH,World.INFINITY);
      
      //drop beepers on your way out the maze
      rafael.putBeeper();
      rafael.move();
      rafael.turnRight();
      rafael.plop();
      rafael.turnLeft();
      rafael.plop();
      rafael.turnLeft();
      rafael.plop();
      rafael.turnRight();
      rafael.plop();
      rafael.plop();
      rafael.plop();
      rafael.turnRight();
      rafael.plop();
      rafael.plop();
      rafael.plop();
      rafael.plop();
      rafael.turnRight();
      rafael.plop();
      rafael.plop();
      rafael.plop();
      rafael.turnLeft();
      rafael.plop();
      rafael.turnLeft();
      rafael.plop();
      rafael.plop();
      rafael.turnRight();
      rafael.plop();
      rafael.plop();
      rafael.putBeeper();
   }
}