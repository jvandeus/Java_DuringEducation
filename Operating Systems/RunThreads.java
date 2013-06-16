/******************************************************
 *   A program which makes use of the SomeThread class.
 *               3/8/2012
 *****************************************************/

// import SomeThread;
public class RunThreads
{
   public static void main (String[] args)
   {
     SomeThread p1 = new SomeThread(1);
     p1.start();
 
     SomeThread p2 = new SomeThread(2);
     p2.start();

     SomeThread p3 = new SomeThread(3);
     p3.start();
   }
}// end class RunThreads


