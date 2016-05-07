package com.mallon.tdd;
import static org.junit.Assert.*;
import org.junit.Test;

public class PrimeNumberTest {

	@Test(expected=Exception.class)
	public void test_that_the_string_one_throw_exception() throws Exception {
		PrimeNumber primeNumber = new PrimeNumber();
		primeNumber.isPrime("One");
	}
}
