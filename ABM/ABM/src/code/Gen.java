package code;

public class Gen extends Thread {
	public static int gtimer=0;
	public static String ss="aaro";
	public static Thread t,t2;
	public static int number=50;
	public static void main(String args[]) throws InterruptedException {
	//	Environment en= new Environment(0);
		Gen obj= new Gen();
		int i=0;
		while(i<number) {
			t=new Thread(obj);
			t.start();
			i++;
		}
		
	}
	
	public void run()
	{
		String []abc= {"abc"};
		Environment.emain(abc);
		
	}
	

}
