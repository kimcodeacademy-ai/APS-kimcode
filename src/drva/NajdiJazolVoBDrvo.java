//За дадено бинарното дрво и jазел за коj се вчитува податочниот елемент од
//тастатура, да се провери дали вредноста на jазелот постои во бинарното дрво.


package drva;

public class NajdiJazolVoBDrvo {

    public static void main(String[] args) {
        System.out.println("Vnesi 5 jazli vo drvoto: ");

        BTree<String> stringBtree = new BTree<String>();

        stringBtree.makeRoot("crvena");

        BNode<String> violetova = stringBtree.addChild(stringBtree.root, 1, "violetova");

        BNode<String> zolta = stringBtree.addChild(violetova, 2, "zolta");
        BNode<String> crna = stringBtree.addChild(violetova, 1, "crna");

        BNode<String> sina = stringBtree.addChild(stringBtree.root, 2, "sina");
        BNode<String> kafena = stringBtree.addChild(sina, 1, "kafena");

        stringBtree.findJazol("portokalova");
        stringBtree.findJazol("zolta");

    }
}
