package com.sample.webclient.WebClient;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class ThreadClass extends Thread{
	
	public String URI = null;
	
	public void run() {
		
//		WebClient client2 = WebClient.create(URI);
//		Mono<String> ops = client2.get().retrieve().bodyToMono(String.class);	
//		String result = ops.block();
//	    System.out.println(result);
	    
//	    curenntTime = System.currentTimeMillis();
	    
	    System.out.println("Enterng NON-BLOCKING Controller!");
	    Mono<String> tweetFlux = WebClient.create()
	    	      .get()
	    	      .uri(URI)
	    	      .retrieve()
	    	      .bodyToMono(String.class);
	    
	    tweetFlux.subscribe(tweet -> System.out.println("Response is " + tweet.toString()));
//	    tweetFlux.subscribe();
	    	      
//	    tweetFlux.publishOn(Schedulers.elastic());
		
//	    	    tweetFlux.subscribe();
	    	    System.out.println("Exiting NON-BLOCKING Controller!");
	    	    
	    	    
		
	}

}
