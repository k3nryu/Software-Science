package ソフトウェア科学;

public class ShellSort {
	public static void ShellSort(int[] data) {
		int gap = data.length / 2;
		while (gap > 0) {
			for (int i=gap; i<data.length; i++) {
				int j = i;
				while (j >= gap) {
					if (data[j] < data[j-gap]) {
						int tmp = data[j];
						data[j] = data[j-gap];
						data[j-gap] = tmp;
					} else {
						break;
					}
					j -= gap;
				}
			}
			gap /= 2;
		}
	}

}
