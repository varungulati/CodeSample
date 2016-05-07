package com.mallon.tdd;

public class PrimeNumber {

	public boolean isPrime(String numberString) throws Exception {
		int n = Integer.parseInt(numberString);
		if(n == 1) {
			return false;
		}
		throw new Exception();
	}

}
