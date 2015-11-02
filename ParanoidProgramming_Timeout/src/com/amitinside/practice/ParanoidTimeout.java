package com.amitinside.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ParanoidTimeout {
	
	AtomicInteger counter = new AtomicInteger();
	
	ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
	Callable<String> callbale = new Callable<String>() {
		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	private void init () throws InterruptedException, ExecutionException {
		Future<String> handler = executorService.submit(callbale);
		String response = handler.get();
		counter.set(0);
		counter.incrementAndGet();
		executorService.schedule(callbale, 2, TimeUnit.SECONDS);
	}
	

}
