package com.arithmeticdemo;

import com.arithmeticdemo.TDD.FizzBuzz;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void should_for_3_remane_fizz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("1",fizzBuzz.printNum(1));
        assertEquals("Fizz",fizzBuzz.printNum(3));
        assertEquals("Buzz",fizzBuzz.printNum(5));
        assertEquals("FizzBuzz",fizzBuzz.printNum(15));
        assertEquals("Fizz",fizzBuzz.printNum(13));
    }
}