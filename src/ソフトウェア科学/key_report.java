package ソフトウェア科学;

import java.util.Random;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class key_report {

	public static void main(String[] args) throws IOException {
		int key_length=100;
//		int plane_length=100;
		int block_length=7;
		
//		一様乱数の定義
		Random random =new Random();
		
//		共通鍵の読込
//		byte key[]=new byte[block_length];
		byte key[]=new byte [key_length];
		BufferedInputStream flink = new BufferedInputStream(new FileInputStream("/Users/zhenwenqin/Documents/workspace/ソフトウェア科学/K.txt"));
		flink.read(key,0,key.length);
		
//		平文の読込
		byte plane[]=new byte [block_length];
		byte	 cypher_test[]=new byte[block_length];
		BufferedInputStream flinp=new BufferedInputStream(new FileInputStream("/Users/zhenwenqin/Documents/workspace/ソフトウェア科学/P.txt"));
		flinp.read(plane,0,plane.length);
		
//		暗号化
		int t = flinp.read(plane,0,block_length);
		System.out.println(t);
		while(flinp.read(plane,0,block_length) != -1){	
			if(t	<block_length){	
				for(int k=t;k<block_length;k++){	
					plane[k]	=(byte)(random.nextInt(255));//ダミーデータの付加
				}	
			}	
			for(int j=0;	j<key.length;j++){	
				cypher_test[j]=(byte)(plane[j]^key[j]);							
			}
			flinp.read(plane,0,plane.length);	
			if(t	<block_length){	
//				????
			}	
		}	
		
//		暗号文の書込
		BufferedOutputStream flinc=new BufferedOutputStream(new FileOutputStream("/Users/zhenwenqin/Documents/workspace/ソフトウェア科学/C.txt"));
		flinc.write(plane,0,plane.length);
		
		flink.close();
		flinp.close();
		flinc.close();
		
	}

}
