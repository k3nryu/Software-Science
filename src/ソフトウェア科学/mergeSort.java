package ソフトウェア科学;

import java.util.Random;

public class mergeSort {
	public static void merge(int[] a1,int[] a2,int[]a){
		int i=0,j=0;
		while(i<a1.length || j<a2.length){
			if(j>=a2.length || (i<a1.length &&
					a1[i]<a2[j])){
				a[i+j]=a1[i];
				i++;
			}else{
				a[i+j]=a2[j];
				j++;
			}
		}
	} 
	public static void mergeSort(int[] a){
		if(a.length>1){
			int m=a.length/2;
			int n=a.length-m;
			int[] a1=new int[m];
			int[] a2=new int[n];
			for(int i=0;i<m;i++) a1[i]=a[i];
			for(int i=0;i<n;i++) a2[i]=a[m+i];
			mergeSort(a1);
			mergeSort(a2);
			merge(a1,a2,a);
		}
	}
    public static void main(String[] args) {
		int n =200000;
		int x[]=new int[n];
		Random rnd =new Random();
		for(int i=0;i<n;i++){
			x[i]=rnd.nextInt(n);
		}
		int l=x[0];
		int r=x[n-1];
		long start =System.currentTimeMillis();
		mergeSort(x);
		long stop =System.currentTimeMillis();

		System.out.println("cpu time="+(stop-start)+"msec");
	}


}
