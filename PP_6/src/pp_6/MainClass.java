package pp_6;

import java.util.List;
import java.util.ArrayList;
import java.lang.Thread;
import java.util.Random;
import java.lang.Math;

public class MainClass extends Thread {
	 static List<Double> piList = new ArrayList<Double>();
	 
	 public static void main(String[] args){
	  }
	 
	 public double calculatePi(int threads, int samples) throws InterruptedException
     {
		 Thread[] thread_tab = new Thread[threads];
		 double pi = 0;
		 piList.clear(); 
		 for(int i = 0; i< threads; i++)
		 {
		 thread_tab[i] = new Thread(() ->
		 {
			Random rnd = new Random(Thread.currentThread().getId());
			int good = 0; 
			for(int j = 0; j < samples; j++)
			{
			double x = (double)(rnd.nextInt(200) - 100) / 100;
			double y = (double)(rnd.nextInt(200) - 100) / 100;
			if (Math.sqrt(x*x + y*y) <= 1) ++good;
			}
		    piList.add(4 * (double)good / (double)samples);
		});

		 thread_tab[i].start();
		 }
		 
		 for(int i = 0; i <threads; i++)
		 {
		 thread_tab[i].join();
		 }
		 
		 for(int i = 0; i < piList.size(); i++)
		 {
			 pi += piList.get(i);
		} 
         return pi/threads;
     }
}