package com.tap.security;

import com.tap.security.secretkey.SecretKey;

public class Security {
	
	public static String encryption(String s) {
		
		String e="";
		for(int i=0;i<s.length();i++) {
			
			e+=(char)(s.charAt(i)+SecretKey.getKey());
			
		}
		
		return e;
		
	}

	
public static String decryption(String s) {
		
		String e="";
		for(int i=0;i<s.length();i++) {
			
			e+=(char)(s.charAt(i)-SecretKey.getKey());
			
		}
		
		return e;
		
	}

//public static void main(String[] args) {
//	System.out.println((encryption("Masood")));
//}
	
}
