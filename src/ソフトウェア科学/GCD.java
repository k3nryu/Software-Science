package ソフトウェア科学;


public class GCD {
	public static int gcd(int a,int b) {
		if(b==0) {
			return a;
		}
		int a_0 = a;
		int a_1 = b;
		while(a_1 != 0) {
			int c = a_0;
			a_0 = a_1;
			a_1 = c % a_0;
		}
		return a_0;
	}
	public static int gcd_rec(int a,int b) {
		if(b==0) {
			return a;
		}else {
			return gcd(b, a % b);
		}
		
	}
	public static void main(String[] args) {
		System.out.println(GCD.gcd(5,2));
		System.out.println(GCD.gcd_rec(4,2));
	}

}
