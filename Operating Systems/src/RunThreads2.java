/**************************************************
 *   A program which makes use of the SomeThread2 class.
 *               3/8/2012
 *************************************************/

public class RunThreads2
{
   public static void main (String[] args)
   {
     Thread p1 = new Thread(new SomeThread2(1));
     p1.start();

     Thread p2 = new Thread(new SomeThread2(2)); 
     p2.start();

     Thread p3 = new Thread(new SomeThread2(3)); 
     p3.start();
   }
} //end class RunThreads2


