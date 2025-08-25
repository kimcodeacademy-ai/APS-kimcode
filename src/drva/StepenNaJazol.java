//Да се напише функциjа коjа што го вра´ка нивото на соодветен jазел во дрвото
//(сметаj´ки дека коренот се нао´га на ниво 1) или 0 ако не постои во дрвото. Потоа,
//да се тестира истата за бинарното дрво  и jазол за коj се вчитува
//податочниот елемент од тастатура.

package drva;

public class StepenNaJazol {

    public static void main(String[] args) {
        BTree<String> stringBtree = new BTree<String>();

        stringBtree.makeRoot("crvena");

        BNode<String> violetova = stringBtree.addChild(stringBtree.root, 1, "violetova");

        BNode<String> zolta = stringBtree.addChild(violetova, 2, "zolta");
        BNode<String> crna = stringBtree.addChild(violetova, 1, "crna");

        BNode<String> sina = stringBtree.addChild(stringBtree.root, 2, "sina");
        BNode<String> kafena = stringBtree.addChild(sina, 1, "kafena");

        stringBtree.findStepen("violetova");
        stringBtree.findStepen("zolta");

    }
}
