package j.com.lib.offer;

import java.util.Stack;

public class offer_59_reverseWords {

    public String reverseWords(String s) {
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

}
