package j.com.lib.offer;


/**
 * Created by pepys on 2019/6/25
 * description:��ά�����еĲ���
 */
public class offer_3_find2Array {


    public static void main(String[] args) {
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        find2Array(array, 7);
    }


    public static void find2Array(int[][] array, int target) {
        int row = 0;
        int colums = array.length - 1;

        while (row >= 0 || colums >= 0) {
            if (array[row][colums] == target) {
                System.out.println("�ҵ����,λ�ڵ�" + (row + 1) + "��,��" + (colums + 1) + "��");
                return;
            } else if (array[row][colums] > target) {
                //˵����ǰ�е��������ݶ���Ŀ��ֵС����Ϊ�ų���ǰ��
                colums--;
            } else if (array[row][colums] < target) {
                //˵����ǰ�е��������ݶ���Ŀ��ֵ����Ϊ�ų���ǰ��
                row++;
            }
        }

    }


    public void find(int[][] array,int row,int colum,int target) {

    }

}
