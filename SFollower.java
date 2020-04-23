    //follows pacbot across streets
   public class SFollower extends Ghost
   {
      public SFollower(int x, int y,  String id, int d)
      {
         super (x,y,id, d);
      }
   
      public SFollower(String id)
      {
         super(id);
      }
      
      public void randMove()
      {
         int randDir = (int)(Math.random()*4);
         if(randDir==0)
            turnRight();
         else
            if(randDir==1)
               turnLeft();
            else
               if(randDir==2)
                  turnAround();
      }
   
     //pre:  avenue and street are location of the pacbot player
     //post: follows pacbot when it goes to make a decision
      public void makeNextMove(int avenue, int street)
      {
      //turn in a random direction, then move if clear
         int ave = avenue();
         int str = street();
         if(frontIsClear())
            move();
         else
         {	
            if(leftIsClear() && rightIsClear())
            {
               if(facingEast() && street > str)
               {
                  turnLeft();
                  move();
               }
               else
                  if(facingEast() && street < str)
                  {
                     turnRight();
                     move();
                  }
                  else
                     if(facingWest() && street < str)
                     {
                        turnLeft();
                        move();
                     }
                     else
                        if(facingWest() && street > str)
                        {
                           turnRight();
                           move();
                        }
                        else
                           randMove();
            }	
            else
               if(leftIsClear())
               {
                  if(facingEast() && street > str)
                  {
                     turnLeft();
                     move();
                  }
                  else
                     if(facingWest() && street < str)
                     {
                        turnLeft();
                        move();
                     }  
                     else
                        randMove();                   
               }
               else
                  if(rightIsClear())
                  {
                     if(facingEast() && street < str)
                     {
                        turnRight();
                        move();
                     }
                     else
                        if(facingWest() && street > str)
                        {
                           turnRight();
                           move();
                        }
                        else
                           randMove();
                  }
                  else
                     randMove();
         }
      }
   }