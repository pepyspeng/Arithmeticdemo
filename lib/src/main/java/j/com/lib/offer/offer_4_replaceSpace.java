package j.com.lib.offer;

/**
 * 替换空格
 */
public class offer_4_replaceSpace {

    /**
     *
     * @param s string字符串
     * @return string字符串
     */
    public String replaceSpace(String s) {
        // write code here
        String[] strs = s.split("");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if(str.equals(" ")){
                sb.append("%20");
            }else{
                sb.append(str);
            }
        }
        return  sb.toString();
    }


    /**
     * 去掉空格+首字符大写
     * @param s
     */
    public static void toUpperCase(String s){
        StringBuilder sb = new StringBuilder(s);
        if(sb.charAt(0) >='a' && sb.charAt(0) <='z'){
            sb.setCharAt(0, (char) (sb.charAt(0)-32));
        }
        for (int i =1;i<sb.length();i++){
            if(sb.charAt(i-1) == ' ' &&(sb.charAt(i) >='a' && sb.charAt(i) <='z')){
                sb.setCharAt(i, (char) (sb.charAt(i)-32));
            }
        }
        for (int i =1;i<sb.length();i++){
            if(sb.charAt(i) == ' '){
                sb.deleteCharAt(i);
                i--;
            }
        }
        System.out.println(sb.toString());
    }

}
