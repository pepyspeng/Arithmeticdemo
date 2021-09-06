package j.com.lib.offer;

/**
 * JZ43 左旋转字符串
 */
public class offer_53_LeftRotateString {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef",3));
    }

    public static String LeftRotateString(String str,int n) {
//         if(str.length()<=n){
//             return str;
//         }
//         return str.substring(n,str.length())+str.substring(0,n);
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = n;i<len+n;i++){
            sb.append(str.charAt(i%len));
        }
        return sb.toString();
    }
}
