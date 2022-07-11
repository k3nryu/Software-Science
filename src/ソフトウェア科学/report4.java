package ソフトウェア科学;

import java.util.Random;

public class report4 {
	public static void main(String[] args) {
		int n =1000000;
		int x[]=new int[n];
		Random rnd =new Random();
		for(int i=0;i<n;i++){
			x[i]=rnd.nextInt(n);
		}
		int l=x[0];
		int r=x[n-1];
		
		
//		long start1 =System.currentTimeMillis();
//		BubbleSort.BubbleSort1(x);
//		long stop1 =System.currentTimeMillis();
//		System.out.println(stop1-start1);
		
		long start2 =System.currentTimeMillis();
		mergeSort.mergeSort(x);
		long stop2 =System.currentTimeMillis();
		System.out.println(stop2-start2);
		
//		long start3 =System.currentTimeMillis();
//		QuickSort.Quicksort(x,l,r);
//		long stop3 =System.currentTimeMillis();
//		System.out.println(stop3-start3);
		
		long start4 =System.currentTimeMillis();
		HeapSort.heapSort(x, n);
		long stop4 =System.currentTimeMillis();
		System.out.println(stop4-start4);
		
		long start5 =System.currentTimeMillis();
		CombSort.combSort(x);
		long stop5 =System.currentTimeMillis();
		System.out.println(stop5-start5);
		
		long start6 =System.currentTimeMillis();
		ShellSort.ShellSort(x);
		long stop6 =System.currentTimeMillis();
		System.out.println(stop6-start6);
		
//		long start7 =System.currentTimeMillis();
//		SelectionSort.sort(x);
//		long stop7 =System.currentTimeMillis();
//		System.out.println(stop7-start7);

	}

}
