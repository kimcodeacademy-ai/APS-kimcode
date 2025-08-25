// da se pronajde sumata na celo drvo


// dopolnitelno: da se presmeta sumata na jazlite koi sto imaat samo levi deca
package drva;

public class SumaNaDrvo {

    public static void main(String[] args) {
        BTree<Integer> intBTree = new BTree<>();
        intBTree.makeRoot(10);   // root node

        BNode<Integer> left1  = intBTree.addChild(intBTree.root, 1, 5);
        BNode<Integer> right1 = intBTree.addChild(intBTree.root, 2, 20);

        BNode<Integer> left2a = intBTree.addChild(left1, 1, 3);
        BNode<Integer> left2b = intBTree.addChild(left1, 2, 7);

        BNode<Integer> right2a = intBTree.addChild(right1, 1, 15);
        BNode<Integer> right2b = intBTree.addChild(right1, 2, 25);

        intBTree.addChild(left2a, 1, 2);
        //intBTree.addChild(left2a, 2, 4);
        intBTree.addChild(right2a, 1, 13);
        //intBTree.addChild(right2a, 2, 17);

        intBTree.preorder();

        System.out.println(intBTree.presmetajSumaR(intBTree.root));

        System.out.println(intBTree.presmetajSumaLeviDecaR(intBTree.root));

    }
}
