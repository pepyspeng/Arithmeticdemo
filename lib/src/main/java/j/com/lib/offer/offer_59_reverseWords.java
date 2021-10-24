package j.com.lib.offer;

import java.util.Stack;

public class offer_59_reverseWords {

    public static void main(String[] args) {
        String s= "the sky is blue";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords1(s));
    }

    public static String reverseWords(String s) {
        String[] array = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = array.length -1;i>=0;i--){
            if(array[i].equals(" ")){
                continue;
            }
            sb.append(array[i]).append(" ");
        }
        return  sb.toString().trim();
    }

    public static String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            sb.append(c).append(" ");
        }
        return  sb.toString().trim();
    }


}
