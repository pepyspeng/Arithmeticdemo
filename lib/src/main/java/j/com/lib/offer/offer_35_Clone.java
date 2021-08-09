package j.com.lib.offer;

/**
 * 复杂链表的复制
 */
public class offer_35_Clone {

    public static void main(String[] args) {
        RandomListNode root = RandomListNode.getRandom();
        Clone(root);
        while (root != null) {
            System.out.println("label:"+ root.label);
            root = root.next;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;

        }
        //每个结点都复制一个
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label+"1");
            RandomListNode tempNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = tempNode;
            currentNode = tempNode;
        }
        //将随机节点也复制一下
        currentNode = pHead;
        while (currentNode != null) {
            pHead.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        //  A---A1---B---B1---C---C1---D---D1
        while (currentNode != null) {
            //pCloneNode :null = currentNode.next : A1
            RandomListNode pCloneNode = currentNode.next;
            // currentNode.next ：A1 = pCloneNode.nex：B
            currentNode.next = pCloneNode.next;
            //pCloneNode.next: B = pCloneNode.next.next : B1
            pCloneNode.next = pCloneNode.next == null ? null : pCloneNode.next.next;
            //currentNode :A =  currentNode.next；B
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }


    public static class RandomListNode {
        String label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(String label) {
            this.label = label;
        }


        public static RandomListNode getRandom() {
            RandomListNode nodeA = new RandomListNode("A");
            RandomListNode nodeB = new RandomListNode("B");
            RandomListNode nodeC = new RandomListNode("C");
            RandomListNode nodeD = new RandomListNode("D");
            RandomListNode nodeE = new RandomListNode("E");
            nodeA.next = nodeB;
            nodeB.next = nodeC;
            nodeC.next = nodeD;
            nodeD.next = nodeE;
            nodeA.random = nodeC;
            nodeB.random = nodeE;
            nodeD.random = nodeB;
            return nodeA;
        }
    }
}
