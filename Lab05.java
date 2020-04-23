public class Lab05
{
   public static void main(String[]args)
   {
      World.readWorld("shuttle");
      World.setSize(10,10);
      World.setSpeed(10);
      
      Racer tom = new Racer(1);
      runTheRace(tom);
      Racer justin = new Racer (4);
      runTheRace(justin);
      Racer tim = new Racer(7);
      runTheRace(tim);
   }
   public static void runTheRace(Racer arg)
   {
      arg.shuttle(2);
      arg.shuttle(4);
      arg.shuttle(6);
   }
}