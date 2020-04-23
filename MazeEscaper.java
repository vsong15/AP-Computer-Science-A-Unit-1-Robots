   //Torbert, e-mail: mr@torbert.com, website: www.mr.torbert.com
	//version 4.16.2003
    public abstract class MazeEscaper extends Athlete
   {
       public MazeEscaper()
      {
         super(1, 1,World.NORTH, 0); 
      }
      
       public abstract void walkDownCurrentSegment();
       //This will handle the three decisions:
       //either turnToTheNextSegment, just move or just turn depending on the situation
       
       public abstract void turnToTheNextSegment();
       //turn and move to follow the wall of your choosing
       //Republicans follow the right wall, democrats follow the left wall
       
   }