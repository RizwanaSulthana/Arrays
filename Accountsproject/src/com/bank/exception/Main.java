package com.bank.exception;
import java.util.Scanner;

public class Main {
	public static void main(String []args)
	{
		int x[]= {1,2,3,4,5,6,7,8,9,10};
		System.out.println(x.length);
		int sum=0;
		for(int i=0;i<x.length;i++)
		{
			sum+=x[i];
		//System.out.println(x[i]);	
		
		}
		System.out.println("sum" +sum);
		float avg=(float)sum/x.length;
		System.out.println("avg" +avg);
		
		Scanner s1=new Scanner(System.in);
		System.out.println("enter the num");
		int value=s1.nextInt();
		for(int i=0;i<x.length;i++)
		{
			if(x[i]<value)
			{
				System.out.println(x[i]);
			}
		}
		//System.out.println(x[4]);
		
	}

}
