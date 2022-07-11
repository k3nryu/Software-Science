package ソフトウェア科学;
import java.io.*;
public class Heat_Flow_Dirichlet_Neumann_2D_new{
// 2-Dimensional Simulation＜40cm x 40cm＞
//
    public static void main(String[] args)throws Exception{
        int i,j;
        double dt = 0.001;
        double dx = 0.01;
        double dy = 0.01;
        double kappa = 0.0117;                         // Thermal conductivity [m^2/s]
        double lambdax = kappa*dt/dx/dx;
        double lambday = kappa*dt/dy/dy;
        System.out.println("  alpha<x> = "+lambdax+"  alpha<y> = "+lambday);
//
        int nx=41;                                 // Number of x-direction mesh
        int ny=41;                                 // Number of y-direction mesh
        int m=5000;                              // Number of time mesh
        double maxTemp = 500.0;
        double T[][]=new double[nx][ny];
        double TT[][]=new double[nx][ny];
        for(i=0;i<nx;i++){
            for(j=0;j<ny;j++){
                T[i][j]=273.0+30;                  // Initial temperature [K]
            }
        }
        int nn=0;
// 境界条件
        for(j=0;j<ny;j++){
            T[0][j]=maxTemp+273.0;
        }
        for(i=0;i<nx;i++){
            T[i][0] = maxTemp+273;
        }
        FileWriter fw=new FileWriter("Heat_Flow_Dirichlet_Neumann_0.csv");    // ファイル名の設定
// output initial values
        for(i=0;i<nx;i++){
            for(j=0;j<ny;j++){
                fw.write( "  " + (T[i][j]-273.) +" , ");
            }
            fw.write("\r\n");
        }
        fw.close();
//
// roop
        int mm=0;
        while(nn <= m){
            nn++;
// Caliculation internal domain
            for(i=1;i<(nx-1);i++){
                for(j=1;j<(ny-1);j++){
                    TT[i][j]=T[i][j]+lambdax*(T[i+1][j]+T[i-1][j]-2*T[i][j])
                    +lambday*(T[i][j+1]+T[i][j-1]-2*T[i][j]);
                }
            }
//Boundary condition <Adibatic conditon>
            for(i=0;i<nx;i++){
                TT[i][ny-1] =TT[i][ny-2]; 
            }
            for(j=0;j<ny;j++){
                TT[nx-1][j] = TT[nx-2][j];
            }
            for(i=0;i<nx;i++){
                for(j=0;j<ny;j++){
                    T[i][j] = TT[i][j];
                }
            }
// Boundary value
            for(j=0;j<ny;j++){
                T[0][j]=maxTemp+273.0; 
            }
            for(i=0;i<nx;i++){
                T[i][0] = maxTemp+273;
            }


// Output file on disk memory
            if((nn)%500 == 0){
                mm++; 
                FileWriter fww=new FileWriter("Heat_Flow_Dirichlet_Neumann_"+mm+".csv");    // Difine file name
                for(i=0;i<nx;i++){
                    for(j=0;j<ny;j++){
                        fww.write( "  " + (T[i][j]-273.) +" , ");
                     }
                     fww.write("\r\n");
                }
                 fww.close();
            }
        }
       
    }
}