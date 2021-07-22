
import java.util.Scanner;
import homework01.NumberUtil;

public class FirstNumberApp {
	 public static void main(String[] args) {
		  int n;
		  Scanner nhap = new Scanner(System.in);
		  System.out.println("Nhập số nguyên n lớn hơn hoặc bằng 1: ");
		  n = nhap.nextInt();
		  while (n<1)
		  {
		      System.out.println("n phải lớn hơn hoặc bằng 1. Nhập lại: ");
		      n = nhap.nextInt();
		  }
		  if(n>0) {
		   if (NumberUtil.isPrimeNumber(n)== 1)
		      System.out.println(n+ " là số nguyên tố");
		   else
		    System.out.println(n+ " là hợp số"); 
		   if (NumberUtil.checkSquareNumber(n)== 1||n==1)
			      System.out.println(n+ " là số chính phương");
			   else
			    System.out.println(n+ " không là số chính phương"); 
		   if (NumberUtil.checkPerfectNumber(n)== 1)
			      System.out.println(n+ " là số hoàn hảo");
			   else
			    System.out.println(n+ " không là số hoàn hảo"); 
		  }
		 }

}