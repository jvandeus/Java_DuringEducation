/*********************************************************
 *   A class which implements the Java Runnable interface.
 *             3/8/2012
 *********************************************************/
class SomeThread2 implements Runnable {
   int myID;

   SomeThread2(int id) {
      this.myID = id;
   }
 
   public void run() {
      int i;
      for (i = 1; i < 11; i++)
        System.out.println ("Thread"+myID + ": " + i);
   }
} //end class SomeThread2

