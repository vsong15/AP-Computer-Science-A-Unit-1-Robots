	//Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
	//version 4.16.2003
    public abstract class Dancer extends Athlete implements Runnable
   {
       public Dancer(int x, int y, int dir, int beep)
      {
         super(x, y, dir, beep);
      }
      
       public Dancer()
      {
         super(1, 1, World.EAST, 0);
      }
      
       public abstract void danceStep();
       
       public void run()
      {
         for(int k = 1; k <= 10; k++)
         {
            danceStep();
         }
      }
   }