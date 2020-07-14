package com.spring.factorial;

import org.springframework.stereotype.Component;

@Component("for")
public class ForCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		long result=1;
		//for문으로 구하는 factorial
		for(long i=num ; i>0 ; i-- ) {
			result*=i;
		}
		return result;
	}

}
