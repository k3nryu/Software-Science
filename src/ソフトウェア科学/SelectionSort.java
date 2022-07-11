package ソフトウェア科学;

public class SelectionSort {
	public static void  sort(int[] n) {
	    for(int i = 0; i < n.length-1; i++) {
	        int index = i;
	        for(int j = i + 1; j < n.length; j++) {
	            if(n[j] < n[index]) index = j;
	        }
	        if(i != index) {
	            int tmp = n[index];
	            n[index] = n[i];
	            n[i] = tmp;
	        }
	    }
	}
}
