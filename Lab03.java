//Lab03
//Vincent Song
public class Lab03
{
   public static void takeTheField(Athlete arg)
   {
      arg.move();
      arg.move();
      arg.move();
      arg.move();
      arg.turnRight();
      arg.move();
      arg.move();
   }
   public static void goToGoalie(Athlete arg)
   {
      arg.move();
      arg.move();
      arg.move();
      arg.turnLeft();
      arg.move();
      arg.move();
      arg.turnLeft();
      arg.turnLeft();
   }
      
   public static void main(String[]args)
   {
      World.readWorld("Arena");
      World.setSize(10,10);
      World.setSpeed(10);
      
      Robot coach = new Robot (2,7,World.EAST,2);
      Athlete henry = new Athlete();
      Athlete avery = new Athlete();
      Athlete josh = new Athlete();
      Athlete ryan = new Athlete();
      Athlete joe = new Athlete();
      Athlete hector = new Athlete();
      Lab03.takeTheField(henry);
      goToGoalie(henry);
      takeTheField(avery);
      avery.move();
      avery.move();
      avery.move();
      avery.move();
      avery.turnLeft();
      avery.move();
      avery.turnLeft();
      avery.turnLeft();
      takeTheField(josh);
      josh.move();
      josh.turnLeft();
      josh.move();
      josh.move();
      josh.turnLeft();
      josh.turnLeft();
      takeTheField(ryan);
      ryan.move();
      ryan.move();
      ryan.turnLeft();
      ryan.move();
      ryan.turnLeft();
      ryan.turnLeft();
      takeTheField(joe);
      joe.move();
      joe.move();
      joe.move();
      joe.turnLeft();
      joe.turnLeft();
      joe.turnLeft();
      takeTheField(hector);
      hector.move();
      hector.move();
      hector.move();
      hector.move();
      hector.move();
      hector.turnLeft();
      hector.move();
      hector.move();
      hector.turnLeft();
      hector.turnLeft();
   }
}