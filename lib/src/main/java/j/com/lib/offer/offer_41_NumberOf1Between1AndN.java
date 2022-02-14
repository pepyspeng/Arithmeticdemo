package j.com.lib.offer;

public class offer_41_NumberOf1Between1AndN {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(1013));
    }

    /**
     * 1出现的次数
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        //总数
        int count = 0;
        //当前位数，个十百千
        int bitNum = 1;
        //高位
        int high = n / 10;
        //低位
        int low = 0;
        //当前位
        int cur = n % 10;
        //当前位置 和 高位 都为0 时，说明已经越过了高位，调出循环
        while (cur != 0 || high != 0) {
            if (cur == 0) {
                //如果当前位是0，例如 23045，那么百位出现1的范围是：100-22199，那么高位就是23种组合(0-22)，低位有100中组合(0-99)
                count += high * bitNum;
            } else if (cur == 1) {
                //如果当前位是1，例如 23145，那么可以分为两种情况，1：0-23045 和 2：23046-23145
                //第一种情况可以直接复用上面也就是(high*bitNum)
                //第二种情况其实就是(0-45)，也就是低位+1= low+1
                count += high * bitNum + low + 1;
            } else {
                //如果当前位大于1，例如23345,首先先拆分成 1: 0-23199 和2: 23200-23345，第二种情况没有符合的。
                //考虑第一种情况，其实也就是 当前位是1 的情况，不过这里的low+1，也就是相当于 bitNum。
                // high*bitNum+（low+1） = high * bitNum + bitNum = (high+1)*bitNum
                count += (high + 1) * bitNum;
            }
            //计算完成后，还得把所有位置向右挪一步
            //低位= 低位+ 当前数字*当前位
            low += cur * bitNum;
            //当前位置 = 高位取余数
            cur = high % 10;
            //高位 = 高位 取 除数
            high = high / 10;
            //当前位置*10
            bitNum = bitNum * 10;

        }
        return count;
    }

    /**
     * 三种情况，都可以由cur=0演化而来。
     * 1、当cur=0时，以23045为例子，求百位位置上出现1的次数。此时可选范围是00100---22199，high有23种排列组合，low有100种排列组合，
     * 所以百位位置上出现1的次数总数为：23*100-->即high*digit;
     * 2、当cur=1时，以23145为例子，求百位上出现1的次数。此时可以把0~23145拆分成两项：0~23045以及23046~23145。
     * 那么0~23045可以由第一种情况得出结果：high*digit=23*100。
     * 剩下的工作就是求23046~23145中百位出现1的次数，显然只有23100~23145才满足要求，
     * 所以第二项的结果就是low+1=45+1。总的公式为high*digit+low+1；
     * 3、当cur>1时，以23345为例子，求百位上出现1的次数，此时可以把0~23345拆分成0~23199以及23200~23345。
     * 第二项23200~23345显然没有满足要求的数字。那么求0~23199中百位出现1次数可以由第二种情况得出：high*digit+low+1=23*100+99+1。
     * 由于cur是>1的，所以所求的数字（23345）向下取到 满足要求的最大数字（23199）时，low位数字必然是99，而0~99个数正好是digit（100=99+1）。
     * 所以可以把22345转化为22199，此时公式为high*digit+low+1 = high*digit+digit=（high+1）*digit。
     * 由此看出，cur=1可以由cur=0演变过来，cur>1可以由cur=1演变过来
     *
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int bitNum = 1;
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        while (cur != 0 || high != 0) {
            if (cur == 0) {
                // case 1 : cur == 0
                // cur = 0 时，高位需要借位用于低位计算
                // count = (high-1)*bitNum +(99+1)
                // count = high*bitNum - bitNum +(99+1)
                count += high * bitNum;
            } else if (cur == 1) {
                // case 2: cur == 1
                // 相当于 高位+低位
                // count = （high*bitNum）+ (low+1)
                count += high * bitNum + low + 1;
            } else {
                // case3 : cur>1
                //相当于 为 0的情况 ，不需要借位来计算
                //count = （high*bitNum）+(低位计算结果)
                count += (high + 1) * bitNum;
            }
            //low 、 cur 、 high 都向左偏移一位
            low += cur * bitNum;
            cur = high % 10;
            high = high / 10;
            bitNum = bitNum * 10;
        }
        return count;
    }
}
