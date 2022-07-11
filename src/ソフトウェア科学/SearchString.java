package ソフトウェア科学;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class SearchString {

	public static void main(String[] args) {

		try{
			//ファイルの読み込み
			File file = new File("/Users/zhenwenqin/Downloads/search.dat");
			if(checkBeforeReadfile(file)){
				BufferedReader br =new BufferedReader(new FileReader(file));
				String sr;
				ArrayList<String> Al = new ArrayList<String>();
				int m = 0;
				while((sr = br.readLine()) != null){
					Al.add(sr);
					m++;
				}
				br.close();


				String[] mojiretsu = new String[m];
				for(int i = 0;i < m;i++){
					mojiretsu[i] = Al.get(i);
				}

				//キーワード読み込み
				//				System.out.println("m="+m);
				System.out.println("キーワードを入力してください");
				Scanner sc = new Scanner(System.in);
				String keyWord = sc.nextLine();
				sc.close();
				/*
				 * String型のkeyWordという変数の中に、入力したキーワードが代入されます。
				 */

				/*本文開始*/

				//キーワードを1文字ずつ配列keyに入力
				String[] key = keyWord.split("");
				int s = key.length;

				for(int k = 0;k < m;k++){
					String[] moj = mojiretsu[k].split("");	//mojiretsuを1文字ずつ配列mojに入力
					int t = mojiretsu[k].length();//mojiretsuの長さをtに入力
					
					for(int i = 0; i < t - s + 1; i++){
						int o = i, f = 0;
						while(moj[o].equals(key[f])){
							o++;f++;
							if(f==s){
								System.out.println(mojiretsu[k]);
								break;
							}
						}
						
					}

//					if(t >= s){ 
//
//						String[] moj = mojiretsu[k].split("");
//						int sCount = 0;
//						for(int i = 0;i < t - s + sCount + 1;i++){
//							if(str[sCount].equals(moj[i])){
//								sCount++;
//								if(sCount == s){
//									System.out.println(mojiretsu[k]);
//									break;
//								}
//							}else{
//								sCount = 0;
//							}
//						}
//
//					}
				}
			}else{
				System.out.println("ファイルが見つからないか読み取れません。");
			}
		}catch(FileNotFoundException e){
			System.out.println("エラー");
		}catch(IOException e){
			System.out.println("エラー");
		}

	}
	private static boolean checkBeforeReadfile(File file){
		if(file.exists()){
			if(file.isFile()&&file.canRead()){
				return true;
			}
		}
		return false;
	}

}
