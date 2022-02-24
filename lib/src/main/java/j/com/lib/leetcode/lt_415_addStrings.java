package j.com.lib.leetcode;

public class lt_415_addStrings {

    public static void main(String[] args) {
        lt_415_addStrings addStrings = new lt_415_addStrings();
        System.out.println(addStrings.addStrings("11", "123"));
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int temp1 = 0;
            if (i >= 0) {
                temp1 = num1.charAt(i) - '0';
            }
            i--;
            int temp2 = 0;
            if (j >= 0) {
                temp2 = num2.charAt(j) - '0';
            }
            j--;
            int sum = temp1 + temp2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
