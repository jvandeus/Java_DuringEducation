/* Final Project:
 * 
 * The final Product of a lot of experimentation with thread. There currently is no real
 * practical functionality, just a demonstration of how threads work.
 * 
 * Joe Van Deusen
 */

public class threads {
    final static int CLIENTS = 4;
    final static int SERVERS = 4;
    public static int iterations;


    public static void main(String [] args){
        if (args.length > 0)
            iterations = Integer.parseInt(args[0]);
        else iterations = 1000;
	queue q = new queue(5);
	Client [] cs = new Client[CLIENTS];
	for (int i=0; i<CLIENTS; i++){
	    cs[i] = new Client(i,q);
	    cs[i].start();
	}
	Server [] ss = new Server[SERVERS];
	for (int i=0; i<SERVERS; i++){
	    ss[i] = new Server(i,q);
	    ss[i].start();
	}
    }
}

class Client extends Thread {
    int id;
    int counter = 0;
    queue q;
    long startTime = System.nanoTime();
    
    public Client(int x, queue y){
	super();
	id = x;
	q = y;
    }
    public void run(){
	for(int i=0; i<threads.iterations; i++){
	    String stuff = (""+this+" "+id+" "+counter++ +"\n");
	    while (!q.enqueue(stuff)){yield();}
	}
	
	long timed = System.nanoTime() - startTime;							//end timer, print
	System.out.println("Server Time: " + timed + "ns \n");
    }
}

class Server extends Thread {
    int id;
    int counter = 0;
    queue q;
    long startTime = System.nanoTime();	
    
    public Server(int x, queue y){
	super();
	id = x;
	q = y;
    }
    public void run(){
	for(int i=0; i<threads.iterations; i++){
	    String w = null;
	    while (w == null) {
		w = q.dequeue();
		if (w == null) yield();
	    }
	    System.out.println("server"+id+" "+w);
	}
	
	long timed = System.nanoTime() - startTime;							//end timer, print
	System.out.println("Server Time: " + timed + "ns \n");
    }
}

class queue {
   int MAX = 5;
   int count = 0;
   String [] data ;
   int firstOut = 0;
   int lastUsed = -1;

   public queue(int m){
       MAX = m;
       data = new String[MAX];
   }

   synchronized public boolean enqueue(String x){
      if (count < MAX) {
         data[++lastUsed%MAX] = x;
	 count ++;
	 return true;
      }
      return false;
   }

   synchronized public String dequeue(){
      if (count < 1) return null;
      String retval = data[firstOut++%MAX];
      count --;
      return retval;
   }
}
   

