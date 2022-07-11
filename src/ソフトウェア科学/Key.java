package ソフトウェア科学;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Key {

	public static void main(String[] args) throws IOException {
		
		int key_length=10;
		int plane_length=10;
		
//		共通鍵の読込
		byte key[]=new byte [key_length];
		BufferedInputStream flink = new BufferedInputStream(new FileInputStream("/Users/zhenwenqin/Documents/workspace/ソフトウェア科学/1415062K.txt"));
		flink.read(key);
//		flink.read(key,0,key_length);
//		System.out.println(flink.read(key));
		
//		平文の読込
		byte plane[]=new byte [plane_length];
		BufferedInputStream flinp=new BufferedInputStream(new FileInputStream("/Users/zhenwenqin/Documents/workspace/ソフトウェア科学/1415062P.txt"));
		flinp.read(plane);
//		flinp.read(plane,0,plane_length);
		
//		暗号化
		for(int j=0;j<key_length;j++) {
			plane[j]^=(byte)key[j];
			System.out.println(plane[j]);
		}
		
//		復号化(error)
//		for(int j=0;j<key_length;j++) {
//			System.out.println(key[j]);
//			plane[j] =(byte) Math.pow((double)plane[j],1.0/key[j]);
//			System.out.println(plane[j]);
//		}
		
//		暗号文の書込
		BufferedOutputStream flinc=new BufferedOutputStream(new FileOutputStream("/Users/zhenwenqin/Documents/workspace/ソフトウェア科学/1415062C.txt"));
		flinc.write(plane);
//		flinc.write(plane,0,plane_length);
		
		flink.close();
		flinp.close();
		flinc.close();
		

	}

}
