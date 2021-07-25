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

}
