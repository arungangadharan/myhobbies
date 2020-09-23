package com.sample.webclient.WebClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StreamUtils;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			
	
			long startTime = System.currentTimeMillis();
			
			/******************* Synchronous  *******************/
						
			WebClient client2 = WebClient.create("http://localhost:8081/");
			Mono<String> ops = client2.get().retrieve().bodyToMono(String.class);	
			
			WebClient client3 = WebClient.create("http://localhost:8081/sample-1");
			Mono<String> ops3 = client3.get().retrieve().bodyToMono(String.class);	
			
			WebClient client4 = WebClient.create("http://localhost:8081/sample-2");
			Mono<String> ops4 = client4.get().retrieve().bodyToMono(String.class);	
			
			WebClient client5 = WebClient.create("http://localhost:8081/sample-3");
			Mono<String> ops5 = client5.get().retrieve().bodyToMono(String.class);
			
			String result = ops.block();
		    System.out.println(result);
		    long curenntTime = System.currentTimeMillis();
			System.out.println( "Greetings from root! after "+ (curenntTime - startTime)/1000 + " seconds..");
			
			String result3 = ops3.block();
		    System.out.println(result3);
		    curenntTime = System.currentTimeMillis();
			System.out.println( "Greetings from sample-1 ! after "+ (curenntTime - startTime)/1000 + " seconds..");
							
			String result4 = ops4.block();
		    System.out.println(result4);
		    curenntTime = System.currentTimeMillis();
			System.out.println( "Greetings from sample-2! after "+ (curenntTime - startTime)/1000 + " seconds..");
									
			String result5 = ops5.block();
		    System.out.println(result5);
		    curenntTime = System.currentTimeMillis();
			System.out.println( "Greetings from sample-3! after "+ (curenntTime - startTime)/1000 + " seconds..");

			/******************* Synchronous : End  *******************/
			
//			ThreadClass t1 = new ThreadClass();
//			t1.URI = "http://localhost:8081";
//			t1.run();
//			
//			ThreadClass t2 = new ThreadClass();
//			t2.URI = "http://localhost:8081/sample-1";
//			t2.run();
//			
//			ThreadClass t3 = new ThreadClass();
//			t3.URI = "http://localhost:8081/sample-2";
//			t3.run();	
//			
//			ThreadClass t4 = new ThreadClass();
//			t4.URI = "http://localhost:8081/sample-3";
//			t4.run();	
//			long curenntTime = System.currentTimeMillis();
//			System.out.println( "Total time taken - "+ (curenntTime - startTime)/1000 + " seconds..");
//		    tweetFlux1.subscribe(tweet -> System.out.println("Response is " + tweet.toString()));
			
			/******************* Asynchronous  *******************/
			
			 Mono<String> tweetFlux1 = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8081")
		    	      .retrieve()
		    	      .bodyToMono(String.class);
			 
		    Mono<String> tweetFlux2 = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8081/sample-1")
		    	      .retrieve()
		    	      .bodyToMono(String.class);
		    
		    Mono<String> tweetFlux3 = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8081/sample-2")
		    	      .retrieve()
		    	      .bodyToMono(String.class);
		    
		    Mono<String> tweetFlux4 = WebClient.create()
		    	      .get()
		    	      .uri("http://localhost:8081/sample-3")
		    	      .retrieve()
		    	      .bodyToMono(String.class);
		    
		    Mono.zip(tweetFlux1, tweetFlux2, tweetFlux3, tweetFlux4).subscribe(tweet -> System.out.println("Response is " + tweet.toString()));
		    /******************* Asynchronous : End  *******************/
		    
		    
//		    Mono.zip(tweetFlux1, tweetFlux2, tweetFlux3, tweetFlux4).map(tweet -> {
//		    	List<Mono<String>> results = Arrays.asList(tweetFlux1, tweetFlux2, tweetFlux3);
//		    });
		    
			
//		      WebClient webClient = WebClient.create("http://localhost:8080");
//		      Mono<String> result = webClient.get()
//		                                     .retrieve()
//		                                     .bodyToMono(String.class);
//		      String response = result.block();
//      System.out.println(response);

		};
	}

}
