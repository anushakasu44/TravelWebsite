package com.app.qa.tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class InterviewjavaPrograms {

	
	public static void main(String[] args) {

        revString("peep");
		removeGrabage();
		trim();
		revInteger(12345);
		findMissingNumberInArray();
		findDuplicatesinArray();
		MaxNumArray();
		MinNumArray();
		Stringmanipulations();
		swapWithtwoIntegerVariables();
		swaptwoStringvariables();
		System.out.println("5 is prime number: "+isPrimeNumber(5));
		getAllprimeNumbers(20);
		palimdromIntegerNum(123454321);
		palimdromStringr("madam");
		amstrongNum(153);
		factNumWithoutRecursive(4) ;
		System.out.println("factorial of 6 is : "+factNumWithRecursive(6));
		findDuplicateWordsArray();
		
	}
	
	public static void revString(String str1) {
		String str2="";
		for(int i=str1.length()-1;i>=0;i--){
			str2=str2+str1.charAt(i);
			
		}
		System.out.println("String reverse is : "+str2);
		System.out.println(str2.equals(str1));
	}
	
	
	public static void removeGrabage() {
		String s1="5474657%%%%%%%anu*&%#$@186358isA74675d";
		s1=s1.replaceAll("[^a-zA-Z0-9]","");
		System.out.println(s1);
	}
	
	
	public static void trim() {
		String s1="  anu arun   ";
		s1=s1.trim();
		s1=s1.replace(" ", "");
        System.out.println(s1);
	}
	
	public static void revInteger(int num) {
		int rev=0;
		int r;
		
		
		while(num>0) {
			r=num%10;
			rev=(rev*10)+r;
			num=num/10;
			}
		System.out.println("reverse of the integer is"+rev);
		
	}
	
	
	public static void findMissingNumberInArray() {
		int a[]= {1,2,3,4,6,7};
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum=sum+a[i];
		}
			System.out.println(sum);
	    int sum1=0;
	    for(int j=1;j<=7;j++) {
		sum1=sum1+j;
		
	}
	System.out.println(sum1);
	int sum2=sum1-sum;
	System.out.println("missing element of an array is "+sum2);
	
	
	}
	
	
	public static void findDuplicatesinArray() {
		String s3[]= {"anu","aru","munny","deepu","aru"};
		
		//************Method1***Complexity:O(n*n)**************WORST SOLUTION//
		for(int i=0;i<s3.length;i++) {
			for(int j=i+1;i<s3.length;i++) {
				if(s3[i].equals(s3[j])) {
				System.out.println("dublicate element is "+s3[i]);
				}
		}
	}
		//**************Method2**Complexity:O(n)***//
		HashSet<String> hashobj=new HashSet<String>() ;
			for(String find:s3) {
				if(hashobj.add(find)==false) {
					System.out.println("dublicate element is :"+find);
				}
			}
			
			//**************Method3**********//	
		HashMap<String,Integer> hapobj=new HashMap<String,Integer>();
		for(String store:s3) {
			Integer count=hapobj.get(store);
			if(count==null) {
			hapobj.put(store, 1);
			}
			else {
				hapobj.put(store, ++count);
			}
		}
			Set<Entry<String,Integer>> entry=hapobj.entrySet();
			for(Entry<String,Integer> ent:entry) {
				if(ent.getValue()>1) {
					System.out.println(ent.getKey());
				}
			}
	}
	
	public static void MaxNumArray() {
		int MaxArray[]= {3,6,4,7,9,3,0};
		
		int largest=MaxArray[0];
		for(int i=1;i<MaxArray.length;i++) {
			if(MaxArray[i]>largest) {
				largest=MaxArray[i];
				}}
		System.out.println("Largest number is :"+largest);
	}
	
	public static void MinNumArray() {
		int MaxArray[]= {3,6,4,7,9,3,0};
		
		int smallest=MaxArray[0];
		for(int i=1;i<MaxArray.length;i++) {
			if(MaxArray[i]<smallest) {
				smallest=MaxArray[i];
				}}
		System.out.println("smallest number is :"+smallest);
	}
	
	public static void Stringmanipulations() {
		String str=" Aruu is good boy and anu is a good girl aru ";
		
		System.out.println(str.charAt(10));
		System.out.println(str.indexOf("u"));//first occurrence
		System.out.println(str.indexOf("u", str.indexOf("u"))+1);//2nd occurrence
		System.out.println(str.endsWith("aru "));
		System.out.println(str.concat("s"));
		System.out.println(str.indexOf("boy"));
		System.out.println(str.replaceAll("[^a-zA-Z0-9]", ""));
		System.out.println(str.trim());
		System.out.println(str.toUpperCase());
		System.out.println(str.substring(5));
		System.out.println(str.subSequence(0, 6));
		String strr[]=str.split(" ");
		for(String word:strr) {
			System.out.println(word);
		}
	}

public static void swapWithtwoIntegerVariables() {
	//********without using 3rd variable****//
	int a=10;
	int b=20;
	a=a+b;
	b=a-b;
	a=a-b;
	System.out.println("Value of a is :" +a);
	System.out.println("Value of b is :" +b);
	//********with using 3rd variable****//
	
	int a1=5;
	int b1=8;
	int t;
	t=a1;
	a1=b1;
	b1=t;
	System.out.println("Value of a1 is :" +a1);
	System.out.println("Value of b1 is :" +b1);
}


public static void swaptwoStringvariables() {
	String ss1="anu";
	String ss2="aru";
	
	ss1=ss1+ss2;
	ss2=ss1.substring(0, ss1.length()-ss2.length());
	ss1=ss1.substring(ss2.length());
	System.out.println("Value of ss1 is :" +ss1);
	System.out.println("Value of ss2 is :" +ss2);
	
}


public static boolean isPrimeNumber(int num) {
	if(num<=1) {
		return false;
	}
	for(int i=2;i<num;i++) {
		if(num%i==0) {
		return false;
		}
	}
       return true;
	
	
}
public static void getAllprimeNumbers(int num) {
	for(int i=2;i<=num;i++) {
		if(isPrimeNumber(i)) {
			System.out.println(i+" ");
			}
		
	}
}

public static void palimdromIntegerNum(int num) {
	int r;
	int sum=0;
	int t;
	t=num;
	while(num>0) {
	r=num%10;
	sum=(sum*10)+r;
	num=num/10;
	}
	if(t==sum) {
	System.out.println("is palimdrom number");
	}else {
		System.out.println("not a palimdrom number");
	}
}

public static void palimdromStringr(String strng) {
	//Palindrom::::;151,232//
	String strng1="";
	
	for(int i=strng.length()-1;i>=0;i--) {
		strng1=strng1+strng.charAt(i);
	}
	System.out.println(strng1);
	if(strng1.equals(strng)){
	System.out.println("is palimdrom number");
	}else {
		System.out.println("not a palimdrom number");
	}
}

public static void amstrongNum(int num) {
	//Amstrong num::153::1cube+5Cube+3Cube===153//
	int t;
	int r;
	int cube = 0;
	t=num;
	while(num>0) {
		r=num%10;
		cube=cube+(r*r*r);
		num=num/10;
	}
	if(t==cube) {
		System.out.println("is palimdrom number");
		}else {
			System.out.println("not a palimdrom number");
		}
}

public static int factNumWithoutRecursive(int num) {
	//Method 1//
	
	if(num==0) {
		return 1;
	}
	int fact=1;
	for(int i=1;i<=num;i++) {
	  fact=fact*i;
	}
	System.out.println("factorial of "+num+" is :"+fact);
	return fact;
}
	
public static int factNumWithRecursive(int num) {
	//Method 2//
	if(num==0) {
		return 1;
	}
	else {
		return num*factNumWithRecursive(num-1);
		}
}

public static void findDuplicateWordsArray() {
	String string="aru is aru and aru";
	String words[]=string.split(" ");
	
	HashMap<String,Integer> wordCount=new HashMap<String,Integer>();
	for(String word:words) {
		if(wordCount.containsKey(word)) {
			wordCount.put(word, wordCount.get(word)+1);
		}else {
			wordCount.put(word, 1);
		}
	}
		Set<String> setobj=wordCount.keySet();
		for(String word:setobj) {
			if(wordCount.get(word)>1) {
				System.out.println(word+": "+wordCount.get(word));
			}
		}
	}
}

