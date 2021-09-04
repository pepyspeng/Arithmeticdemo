package j.com.lib.offer;


/**
 * @author     : zhupp
 * @date       : 2021/9/2
 * description :二叉搜索树的后续遍历
 */
public class offer_33_VerifySquenceOfBST {
    public static void main(String[] args) {
    }

    /**
     * 二叉搜索树的中序排列是有序的。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length ==0){return false;}
        return dfs(sequence,0,sequence.length-1);
    }

    public boolean dfs(int[] array,int left,int right){
        if(left>right){
            //只有一个节点
            return  true;
        }
        //后序的最后一个是根节点。
        int root = array[right];
        int i = 0;
        for (i = left;i<right;i++){
            //后序遍历中，通过找到比根节点大的，来区分左右子树
            if(array[i]>root){
                break;
            }
        }
        for(int j=i;j<right;j++){
            //在右子树中，一旦找到比根节点小的，说明不是搜索二叉树
            if(array[j]<root){
                return false;
            }
        }
        return dfs(array,left,i-1) && dfs(array,i,right-1);
    }


  /*  public boolean dfs(int[] array,int left,int right){
        if(left>right){
            return true;
        }
        int root = array[right];
        int i;
        for(i = left;i<right;i++){
            if(array[i]>root){
                //i 区分左右节点
                break;
            }
        }
        for(int j = i;j<right;j++){
            if(array[j]<root){
                return false;
            }
        }
        return dfs(array,left,i-1) && dfs(array,i,right-1);

    }*/
}
