package ソフトウェア科学;

import java.util.Random;

public class BubbleSort {
	public static void BubbleSort1(int[] x) {
		int n=x.length;
		for(int i=0;i<n-1;i++){
			for(int j=n-1;j>i;j--){ 
				if(x[j]<x[j-1]){
					int t=x[j];
					x[j]=x[j-1]; 
					x[j-1]=t;
				} 
			}
		}
	}
	public static void BubbleSort2(int[] x) {
		int n=x.length;
		boolean didSwap;
		for(int i=0; i<n-1; i++) {
			didSwap =false;
			for(int j=n-1;j>i;j--){ 
				//				最良の時の計算量はただn-1から、とても速くて事後評価しにくいため、ここで遅くするために無駄計算時間します
				//				for(int o=0;o<1000000;o++){
				//					for(int f=0;f<10;f++){
				//						int h=0;
				//						h++;
				//					}
				//				}
				if(x[j]<x[j-1]){
					int t=x[j];
					x[j]=x[j-1]; 
					x[j-1]=t;
					didSwap = true;
				} 
			}
			if(didSwap == false){
				return;
			}
		}   
	}

	public static void main(String[] args) {
		int n =1000;
		int x[]=new int[n];
		Random rnd =new Random();
		for(int i=0;i<n;i++){
			x[i]=rnd.nextInt(n);
		}
//		for(int i=0;i<n;i++){
//			x[i]=n-i;
//		}

		long start =System.currentTimeMillis();
		BubbleSort2(x);
		long stop =System.currentTimeMillis();

		System.out.println("cpu time="+(stop-start)+"msec");
//		for(int i=0;i<n;i++){
//			System.out.println(x[i]);
//		}
	}
}
