package ソフトウェア科学;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BS_REPORT {
	static String path ="";

	public static void main(String[] args) {

		//ここにはDATA.txtのパスを書きます。変えましょう。
		path = "/Users/zhenwenqin/Downloads/DATA.txt" ;

		//データ数のデフォルト:100万にしているので、必要に応じて変えてください
		for(int l=0;l<3;l++){
			Sort(500000);
		}

	}


	public static long Sort(int n){ // 引数：データ数n、fileの読み込みが必要
//		System.out.println("データ数: " + n);
		File fileInput = new File(path);

		int x[] = new int[n];

		try {
			FileReader fr = new FileReader(fileInput);
			BufferedReader br = new BufferedReader(fr);

			String str;
			int idx = 0;
			while((str = br.readLine()) != null && idx < n){
				x[idx] += Integer.parseInt(str);
				idx++;
			}
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			return -1;
		}

		long start = System.currentTimeMillis();
		for(int i = 0; i < n-1; i++){
			for(int j = n-1; j > i; j--){
				if(x[j] < x[j-1]){
					int t = x[j];
					x[j] = x[j-1];
					x[j-1] = t;
				}
			}
		}
		long stop = System.currentTimeMillis();

//		System.out.println("cpu time = " + (stop - start) + "msec");
		System.out.println(stop - start);
		return stop - start;
	}
}
