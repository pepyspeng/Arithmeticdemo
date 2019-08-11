package com.arithmeticdemo.TDD;

public class FizzBuzz {

    public String printNum(int num){
        if(isMode(num,3) && isMode(num,5)){
            return "FizzBuzz";
        }else if(isMode(num,3)){
            return "Fizz";
        }else if(isMode(num,5)){
            return"Buzz";
        }
        return String.valueOf(num);
    }

    private boolean isMode(int num,int mode){
        return num%mode == 0 || String.valueOf(num).contains(mode+"");
    }
}
