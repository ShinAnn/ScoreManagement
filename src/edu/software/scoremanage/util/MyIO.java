package edu.software.scoremanage.util;

import java.util.Scanner;

public class MyIO {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void println(String s){
		System.out.println(s);
	}
	public static void println(){
		System.out.println();
	}
	public static void print(String s){
		System.out.print(s);
	}
	public static String scanString(){
		String s = scanner.next();
		return s;
	}
	public static int scanInt(){
		return scanner.nextInt();
	}
	public static boolean scanBool(){
		return scanner.nextBoolean();
	}
	public static float scanFloat(){
		return scanner.nextFloat();
	}
}
