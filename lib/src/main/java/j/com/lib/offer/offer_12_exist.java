package j.com.lib.offer;


/**
 * 矩阵中的路径
 * [['A','B','C','E']
 * ,['S','F','C','S']
 * ,['A','D','E','E']]
 * word = "ABCCED"
 * <p>
 * return true
 */
public class offer_12_exist {

    public static void main(String[] args) {
        offer_12_exist exist = new offer_12_exist();
        char[][] arr = new char[][]{
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist.exist2(arr,"BCCED"));
    }

    public boolean exist2(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (dfs2(board, i, j, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board  数组
     * @param row    横坐标 x
     * @param column 纵坐标 y
     * @param target 目标数组
     * @param k      目标数组的index
     * @return
     */
    public boolean dfs2(char[][] board, int row, int column, char[] target, int k) {
        //先判断 x,y是否越界
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length ||
                //再判断是够相等
                board[row][column] != target[k]) {
            return false;
        }

        if (k == target.length - 1) {
            //全部搜索完毕了
            return true;
        }
        //代表已经搜索过了。
        board[row][column] = ' ';
        boolean result = dfs2(board, row + 1, column, target, k + 1) ||
                dfs2(board, row - 1, column, target, k + 1) ||
                dfs2(board, row, column + 1, target, k + 1) ||
                dfs2(board, row, column - 1, target, k + 1);
        board[row][column] = target[k];
        return result;
    }


    public boolean exist1(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs1(board, i, j, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs1(char[][] board, int i, int j, char[] words, int k) {

        if (
            //数组越界
                i >= board.length || i < 0 || j >= board[0].length || j < 0
                        // 数据不相等
                        || board[i][j] != words[k]
        ) {
            return false;
        }
        //全部搜索完毕
        if (k == words.length - 1) {
            return true;
        }
        board[i][j] = ' ';
        //搜索顺序  下 上 右 左
        boolean result = dfs1(board, i + 1, j, words, k + 1)
                || dfs1(board, i, j - 1, words, k + 1)
                || dfs1(board, i, j + 1, words, k + 1)
                || dfs1(board, i - 1, j, words, k + 1);
        board[i][j] = words[k];
        return result;
    }


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
        boolean result = dfs(board, row + 1, column, word, k + 1)
                || dfs(board, row - 1, column, word, k + 1)
                || dfs(board, row, column + 1, word, k + 1)
                || dfs(board, row, column - 1, word, k + 1);
        board[row][column] = word[k];
        return result;
    }

}
