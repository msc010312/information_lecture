package com.example.app.scheduled;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduling {
	
//	@Scheduled(fixedRate = 1000)
//	public void t1() {
//		System.out.println("Scheduling t1 invoke");
//	}
	
//	@Scheduled(cron="* * * * * *")
//	public void t2() {
//		System.out.println("Scheduling t2 invoke");
//	}
}
