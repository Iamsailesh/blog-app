import java.util.Scanner;

public class trytry {
//	public static int fact(int n) {
//		if(n==0 || n==1) {
//			
//			return 1;
//		}
//		else {
//			return n*fact(n-1);
//		}
//	}
	
	public static void main(String[] args) {
		
				
//		System.out.println(fact(0));
	
//		 int arr[]= {1,2,3,4,5,6,7,8};
		 
		 
//		 for(int i=0; i<arr.length; i++) {
//			 sum=sum+arr[i];
//		 }
//		System.out.println(sum);
//		
//	}
		 
//		 for(int a: arr) {
//			 if(a%2==0) {
//				 System.out.println(a);
//			 }
//		 }
		 
		 
//		 int num=153;
//		 int digitSum=0;
//		 
//		 while(num!=0) {
//			 digitSum=digitSum+ (int) Math.pow(num%10, 3);
//			 num=num/10;
//		 }
//		 System.out.println(digitSum);
		
		
//		int n=100;
//		int count=0;
//		for(int i=1; i<=n; i++) {
//			if(n%i==0) {
//				count++;
//			}
//		}
//		if(count>2) System.out.println("the number is not prime");
//		else System.out.println("The number is prime");
		
//		int n=1012;
//		int sum=0;
//	
//		
//		while(n!=0) {
//			sum=sum*10+n%10;
//			n=n/10;
//			
//		}
//		System.out.println(sum);
		
//		String str="Hello";
//		String rev="";
//		
//		for(int i=str.length()-1; i>=0; i--) {
//			rev=rev+ str.charAt(i);
//		}
//		System.out.println(rev);
		
		Scanner scan= new Scanner(System.in);
		System.out.println("Give me a number for fibonecci series .");
		int a=scan.nextInt();
		int n1=0;
		int n2=1;
		int sum=0;
		System.out.print(n1 + " " + n2 + " ");
		
		for(int i=2; i<a; i++) {
			sum=n1+n2;
			System.out.print(sum);
			n1=n2;
			n2=sum;
		}
		
	}
		
}
