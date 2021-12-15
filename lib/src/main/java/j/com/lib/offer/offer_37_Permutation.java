package j.com.lib.offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 输出字符串的所有排列
 */
public class offer_37_Permutation {

    public static void main(String[] args) {
        offer_37_Permutation permutation = new offer_37_Permutation();
        System.out.println(Arrays.toString(permutation1("ab")));
    }
    //
    static Set<String> result = new HashSet<>();
    static boolean[] visited;

    public static String[] permutation1(String s) {
        visited = new boolean[s.length()];
        dfs1(s.toCharArray(), new StringBuilder());
        return result.toArray(new String[0]);
    }


    public static void dfs1(char[] array, StringBuilder sb) {
        if (array.length == sb.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            StringBuilder sb1 = new StringBuilder(sb);
            dfs1(array, sb1.append(array[i]));
            visited[i] = false;
        }
    }


    public ArrayList<String> Permutation(String str) {
        StringBuilder strBuilder = new StringBuilder(str);
        ArrayList<String> result = help(strBuilder);
        return result;
    }

    public ArrayList<String> help(StringBuilder str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 1) {
            result.add(str.toString());
        } else {
            for (int i = 0; i < str.length(); i++) {
                char temp = str.charAt(i);
                str.setCharAt(i, str.charAt(0));
                str.setCharAt(0, temp);
                ArrayList newResult = help(new StringBuilder(str.substring(1)));
                for (int j = 0; j < newResult.size(); j++) {
                    result.add(str.substring(0, 1) + newResult.get(j));
                }
                temp = str.charAt(0);
                str.setCharAt(0, str.charAt(i));
                str.setCharAt(i, temp);
            }
        }
        Collections.sort(result);
        return result;
    }
}
