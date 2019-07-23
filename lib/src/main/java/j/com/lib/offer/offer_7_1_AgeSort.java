package j.com.lib.offer;

public class offer_7_1_AgeSort {

    public static void main(String[] args) {
        offer_7_1_AgeSort ageSort = new offer_7_1_AgeSort();

        int[] ages = new int[]{20, 23, 25, 21, 30, 45, 32, 21, 34, 54, 45, 76, 23, 45, 54, 32, 21, 22, 33, 44, 55, 13, 43, 54, 43};
        ageSort(ages);
        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }


    }

    private static void ageSort(int[] ages) {
        int[] count = new int[100];
        if (ages == null || ages.length <= 0) {
            System.out.println("数组为空");
            return;
        }
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0 || ages[i] > 99) {
                System.out.println("非法年龄");
                return;
            }
            count[ages[i]]++;
        }
        int curIndex = 0;//用于记录ages数组当前下标.将ages里面重排序
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i] ; j++) {
                ages[curIndex++] = i;
            }
        }


    }

    /**
     * 排序函数
     *
     * @param ages 存放公司全体人员年龄的数组
     */
    /*public static void ageSort(int[] ages) {
        //countAge的下标i代表年龄，countAge[i]代表年龄为i的员工人数
        int[] countAge = new int[100];

        //健壮性判断
        if (ages == null || ages.length <= 0) {
            System.out.println("数组为空！");
            return;
        }
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0 || ages[i] > 99) {
                System.out.println("数组中存在非法年龄！");
                return;
            }
        }

        //统计每个年龄的人数，存储在countAge数组中
        for (int i = 0; i < ages.length; i++)
            countAge[ages[i]]++;

        //将countAge数组展开，存放在ages数组中
        int curIndex = 0;//用于记录ages数组当前下标
        for (int i = 0; i < countAge.length; i++) {
            for (int j = 0; j < countAge[i]; j++) {
                ages[curIndex] = i;
                curIndex++;
            }
        }
    }*/
}
