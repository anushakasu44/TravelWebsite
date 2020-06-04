package com.app.qa.tests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



String string="anusha kasu";
char lett[]=string.toCharArray();
	
//count the duplicate char in string//
HashMap<Character,Integer> hashobj=new HashMap<Character,Integer>();
for(Character letters:lett) {
	if(hashobj.containsKey(letters)) {
		hashobj.put(letters, hashobj.get(letters)+1);
	}else {
		hashobj.put(letters, 1);
	}
}
	Set<Character> setobj=hashobj.keySet();
	for(Character letters:setobj) {
		if(hashobj.get(letters)>2) {
			System.out.println(letters+":"+hashobj.get(letters));
		}
	}
	
	
	//for find out the duplicate char in string//
	String string1="anusha";
	char letter[]=string1.toCharArray();

	HashSet<Character> dub=new HashSet<Character>();
	for(Character chars:letter) {
		if(dub.add(chars)==false) {
			System.out.println("duplicate char is:"+chars);
		}
	}
	
	
	//for find out the duplicate char in string//
	for(int i=0;i<string1.length();i++) {
		for(int j=i+1;j<string1.length();j++) {
			if(string1.charAt(i)==string1.charAt(j)) {
				System.out.println("duplicate char is "+string1.charAt(j));
			}
		}
	}
	
}


	
	
}

	



