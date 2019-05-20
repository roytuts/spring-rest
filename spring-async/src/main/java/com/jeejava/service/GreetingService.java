package com.jeejava.service;

import java.util.concurrent.Future;

public interface GreetingService {

	Future<String> getGreetingMsg(String name) throws InterruptedException;

	void logMsg();

}
