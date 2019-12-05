package com.example.demo.model;

public class UserContext {
	
	
	public static  ThreadLocal<String> uc=new ThreadLocal<String>();
	
	
	public static ThreadLocal<String> getUserContext(){
		
		return uc;
	}
	
	public static void clearUserContext() {
		
		uc.remove();
	}
	

}
