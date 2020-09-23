package com.sample.webclient.WebClient;

public class Runner {
	
	public static void main(String[] args) {
		
		System.out.println("Start...");
		long startTime = System.currentTimeMillis();
		
		ThreadClass t1 = new ThreadClass();
		t1.URI = "http://localhost:8081";
		t1.run();
		
		long curenntTime = System.currentTimeMillis();
		System.out.println( "T1 after "+ (curenntTime - startTime)/1000 + " seconds..");
		
		ThreadClass t2 = new ThreadClass();
		t2.URI = "http://localhost:8081/sample-1";
		t2.run();
		curenntTime = System.currentTimeMillis();
		System.out.println( "T2 after "+ (curenntTime - startTime)/1000 + " seconds..");
		
		ThreadClass t3 = new ThreadClass();
		t3.URI = "http://localhost:8081/sample-2";
		t3.run();	
		curenntTime = System.currentTimeMillis();
		System.out.println( "T3 after "+ (curenntTime - startTime)/1000 + " seconds..");
		
		ThreadClass t4 = new ThreadClass();
		t4.URI = "http://localhost:8081/sample-3";
		t4.run();	
		curenntTime = System.currentTimeMillis();
		System.out.println( "T4 after "+ (curenntTime - startTime)/1000 + " seconds..");

	}

}
