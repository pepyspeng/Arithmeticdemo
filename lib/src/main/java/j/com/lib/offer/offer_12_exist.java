package j.com.lib.offer;

/**
 * 矩阵中的路径
 * [["A","B","C","E"]
 * ,["S","F","C","S"]
 * ,["A","D","E","E"]]
 * word = "ABCCED"
 * <p>
 * return true
 */
public class offer_12_exist {

    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, array, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int column, char[] word, int k) {
        //数组月结
        if (row > board.length || row < 0 || column > board[0].length || column < 0
                //当前字符不在word里
                || word[k] != board[row][column]) {
            return false;
        }
        if (k == word.length - 1) {
            //全部搜索完毕
            return true;
        }
        board[row][column] = '\0';
        boolean result = dfs(board,row+1,column,word,k+1)
                || dfs(board,row-1,column,word,k+1)
                || dfs(board,row,column+1,word,k+1)
                || dfs(board,row,column-1,word,k+1);
        board[row][column] = word[k];
        return  result;
    }

}
