package j.com.lib.offer;

import java.util.ArrayList;

public class offer_37_StringArrange {

    public static void main(String[] args) {
        offer_37_StringArrange stringArrange = new offer_37_StringArrange();
        String test = "abc";
        ArrayList<String> result =   stringArrange.rec(test.toCharArray(),0,test.length()-1);
        System.out.println(result.toString());
//        for (String c : result) {
//            System.out.println(c);
//        }
    }

    public ArrayList<String> rec(char[] array, int start, int end) {
        ArrayList<String> result = new ArrayList<>();
//        if (end <= 1) {
//            return result;
//        }
        if (start == end) {
            for (char c : array) {
                System.out.print(c);
                result.add(c+"");
            }
            System.out.println();
        }else{
            for (int i = start;i<=end;i++){
                swap(array,i,start);
                rec(array,start+1,end);
                swap(array,i,start);
            }
        }
        return result;
    }

    public void swap(char[] array, int m, int n) {
        char temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }
}
