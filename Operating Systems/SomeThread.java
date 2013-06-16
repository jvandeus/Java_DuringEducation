/**************************************************
 *   A class which extends the Java Thread class.
 *             3/8/2012
 *************************************************/

class SomeThread extends Thread {
   int myID;

   SomeThread(int id) {
      this.myID = id;
   }
 
   public void run() {
      int i;
	  for (i = 1; i < 11; i++)
	  {
		  System.out.println("Thread" + myID + ": " + i);
		  try
		  {
			  //do what you want to do before sleeping
			  Thread.currentThread().sleep(100);//sleep for 1000 ms
			  //do what you want to do after sleeptig
		  }
		  catch (InterruptedException ie)
		  {
			  //If this thread was intrrupted by nother thread 
		  }
	  }
   }
} //end class SomeThread
