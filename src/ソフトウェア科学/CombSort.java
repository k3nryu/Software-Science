package ソフトウェア科学;

public class CombSort{
	public static void combSort(int[] data) {
		int h = data.length * 10 / 13;

		while (true) {
			int swaps = 0;
			for (int i = 0; i + h < data.length; ++i) {
				if (data[i] > data[i + h]) {
					swap(data, i, i + h);
					++swaps;
				}
			}
			if (h == 1) {
				if (swaps == 0) {
					break;
				}
			} else {
				h = h * 10 / 13;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}