package j.com.lib.offer;

import java.util.HashMap;

public class BinaryTreeNode {

    private int index;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    public String value;


    public BinaryTreeNode(String value) {
        this.value = value;
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = s.length();
        int count = 0;
        while(right<length){
            char c = s.charAt(right);
            //放入窗口，更新右坐标
            right++;
            int value = map.getOrDefault(c,0);
            map.put(c,value+1);
            while(map.getOrDefault(c,0)>1){
                //说明有重复的，移动左边坐标
                char d = s.charAt(left);
                left -- ;
                map.put(d,map.getOrDefault(d,0) -1);
            }
            length = Math.max(length,right-left);
        }
        return length;
    }
}
