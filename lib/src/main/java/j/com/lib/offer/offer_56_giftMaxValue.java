package j.com.lib.offer;


/**
 * 礼物最大价值
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class offer_56_giftMaxValue {


    public int maxValue(int[][] grid) {
        //行
        int row = grid.length;
        int column = grid[0].length;
//        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    //左上角的起始点
                    grid[i][j] = grid[i][j];
                    continue;
                }else if(i == 0){
                    //只算第一行
                    grid[i][j] +=grid[i][j-1];
                }else if(j == 0){
                    grid[i][j] += grid[i-1][j];
                }else{
                    grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[row-1][column-1];
    }

}
