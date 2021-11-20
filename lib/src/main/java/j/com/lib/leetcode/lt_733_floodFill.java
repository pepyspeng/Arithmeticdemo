package j.com.lib.leetcode;


import j.com.lib.MyPrint;

/**
 * @author : zhupp
 * @date : 2021/10/28
 * description : 图像渲染
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 输入:
 * image = [[1,1,1],
 * [1,1,0],
 * [1,0,1]]
 * <p>
 * sr = 1, sc = 1, newColor = 2
 * <p>
 * 输出：[[2,2,2],
 * [2,2,0],
 * [2,0,1]]
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。，也就是被0隔开了
 */
public class lt_733_floodFill {
    static MyPrint myPrint = new MyPrint();

    public static void main(String[] args) {
        int[][] array = new int[][]{{0, 0, 0}, {0, 0, 0}};
        floodFill(array, 0, 0, 2);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + "");
            }
            System.out.println("------------------");
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int origColor = image[sr][sc];
        fillImage(image, sr, sc, origColor, newColor);

        return image;
    }

    private static void fillImage(int[][] image, int x, int y, int origColor, int newColor) {
        myPrint.printIndent(myPrint.count++);
        System.out.println("x:" + x + "--y:" + y+"--start");
        //数组越界
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            System.out.println("x:" + x + "--y:" + y+"--end");
            myPrint.printIndent(myPrint.count--);
            return;
        }
        //碰壁，遇到其他颜色，不能更改
        if (image[x][y] != origColor) {
            System.out.println("x:" + x + "--y:" + y+"--end");
            myPrint.printIndent(myPrint.count--);
            return;
        }
        //已经探索过
        if (image[x][y] == -1) {
            System.out.println("x:" + x + "--y:" + y+"--end");
            myPrint.printIndent(myPrint.count--);
            return;
        }
        image[x][y] = -1;
        fillImage(image, x, y + 1, origColor, newColor);
        fillImage(image, x, y - 1, origColor, newColor);
        fillImage(image, x + 1, y, origColor, newColor);
        fillImage(image, x - 1, y, origColor, newColor);
        image[x][y] = newColor;
        System.out.println("x:" + x + "--y:" + y+"--end");
        myPrint.printIndent(myPrint.count--);
    }


}
