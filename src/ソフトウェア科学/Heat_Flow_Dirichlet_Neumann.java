package ソフトウェア科学;
import java.io.*;
public class Heat_Flow_Dirichlet_Neumann {
	public static void main(String[] args)throws Exception{
		int i,j;
		double dt = 0.001;
		double dx = 0.01;
		double kappa = 0.0117;		// 金の熱伝達係数 m^2/s
		double lambda = kappa*dt/dx/dx; 
		System.out.println(" alpha = "+lambda); 
		if(lambda >= 0.5){
			return;
		}
		int n=101;// 格子点の数
		int m=10000;// 時間格子の数
		double maxTemp = 500.0;
		double T[]=new double[n]; 
		double TT[]=new double[n]; 
		for(i=0;i<n;i++){
			T[i]=273.0+30;// 初期値として全体の温度を
		}
		int nn=0;
		T[0]=maxTemp+273.0;//境界条件として左端の温度を1000とする
		FileWriter fw=new FileWriter("Heat_Flow_Dirichlet_Neumann.csv");// ファイル名の設定
// 距離方向の出力 
		for(i=0;i<n;i++){
			fw.write( " "+ i +" , ");
		}
		fw.write("\r\n"); 
// 初期値の出力
		for(i=0;i<n;i++){
			fw.write( " " + (T[i]-273.) +" , ");
		} 
		fw.write("\r\n");
		while(nn <= m){ 
			nn++;
// 内部温度計算 
			for(i=1;i<(n-1);i++){
				TT[i]=T[i]+lambda*(T[i+1]+T[i-1]-2*T[i]);
			}
			TT[n-1] =TT[n-2]; //境界条件として右端の温度を断熱条件
			for(i=1;i<n;i++){
				T[i] = TT[i];
			}
// 計算結果の出力 
			if((nn)%1000 == 0){
				for(i=0;i<n;i++){
					fw.write( " " + (T[i]-273.) +" , ");
				}
				fw.write("\r\n");
			}
		}
		fw.close();
	}
}


