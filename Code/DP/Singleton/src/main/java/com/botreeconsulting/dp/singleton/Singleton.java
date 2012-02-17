package com.botreeconsulting.dp.singleton;

public class Singleton {
	
	// Private constructor prevents instantiation from other classes
    private Singleton() { }

    /**
    * SingletonHolder is loaded on the first execution of Singleton.getInstance() 
    * or the first access to SingletonHolder.INSTANCE, not before.
    */
    private static class SingletonHolder { 
            public static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
            return SingletonHolder.instance;
    }
    
    public static String encrypt(String feed, String salt){
    	
    	//Encryption Logic Here.
    	
    	return "";
    }
}
