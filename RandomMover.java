    //moves randomly (doesn't follow pacbot)
   public class RandomMover extends Ghost
   {
      public RandomMover(int x, int y,  String id, int d)
      {
         super (x,y,id, d);
      }
   
      public RandomMover(String id)
      {
         super(id);
      }
   
      public void makeNextMove(int avenue, int street)
      {
         if(frontIsClear())
            move();
         else
            randMove();      
      }
   
   }