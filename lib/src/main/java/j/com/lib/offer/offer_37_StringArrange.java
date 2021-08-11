package j.com.lib.offer;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class offer_37_StringArrange {

    public static void main(String[] args) {
        offer_37_StringArrange stringArrange = new offer_37_StringArrange();
        String test = "ab";
        Set<String> result =   stringArrange.rec(test.toCharArray(),0,test.length()-1);
        System.out.println(result);
        ArrayList<String> result1 = new ArrayList<>();
        Iterator<String> iterator = result.iterator();
       while (iterator.hasNext()){
           result1.add(iterator.next());
       }
        System.out.println(result);
    }
    Set<String> result = new TreeSet<>();
    public Set<String> rec(char[] array, int start, int end) {
        if (start == end) {
            StringBuilder sb = new StringBuilder();
            for (char c : array) {
                sb.append(c);
            }
            result.add(sb.toString());
        }else{
            for (int i = start;i<=end;i++){
                swap(array,i,start);
                result=  rec(array,start+1,end);
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
