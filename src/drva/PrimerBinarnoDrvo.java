package drva;

public class PrimerBinarnoDrvo {

    public static void main(String[] args) {
        System.out.println("Vnesi 5 jazli vo drvoto: ");

        BTree<String> stringBtree = new BTree<String>();

        stringBtree.makeRoot("crvena");

        BNode<String> violetova = stringBtree.addChild(stringBtree.root, 1, "violetova");

        BNode<String> zolta = stringBtree.addChild(violetova, 2, "zolta");
        BNode<String> crna = stringBtree.addChild(violetova, 1, "crna");

        BNode<String> sina = stringBtree.addChild(stringBtree.root, 2, "sina");

        stringBtree.preorder();
        stringBtree.inorder();
        stringBtree.postorder();
    }
}
