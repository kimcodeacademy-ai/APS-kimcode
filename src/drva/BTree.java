package drva;
public class BTree<E> {
    
    public BNode<E> root;
    
    public BTree() {
        root = null;
    }
    
    public BTree(E info) {
        root = new BNode<E>(info);
    }
    
    public void makeRoot(E elem) {
        root = new BNode<E>(elem);
    }
    
    public BNode<E> addChild(BNode<E> node, int where, E elem) {
        
        BNode<E> tmp = new BNode<E>(elem);
        
        if (where == BNode.LEFT) {
            if (node.left != null)  // veke postoi element
                return null;
            node.left = tmp;
        } else {
            if (node.right != null) // veke postoi element
                return null;
            node.right = tmp;
        }
        
        return tmp;
    }
    
    public void inorder() {
        System.out.print("INORDER: ");
        inorderR(root);
        System.out.println();
    }
    
    public void inorderR(BNode<E> n) {
        if (n != null) {
            inorderR(n.left);
            System.out.print(n.info.toString()+" ");
            inorderR(n.right);
        }
    }

    public void preorder() {
        System.out.print("PREORDER: ");
        preorderR(root);
        System.out.println();
    }
    
    public void preorderR(BNode<E> n) {
        if (n != null) {
            System.out.print(n.info.toString()+" ");
            preorderR(n.left);
            preorderR(n.right);
        }
    }
    
    public void postorder() {
        System.out.print("POSTORDER: ");
        postorderR(root);
        System.out.println();
    }
    
    public void postorderR(BNode<E> n) {
        if (n != null) {
            postorderR(n.left);
            postorderR(n.right);
            System.out.print(n.info.toString()+" ");
        }
    }


    public BNode<E> findJazolR(BNode<E> node, E elem){
        // kaj rekurzivnite funkcii najbitno e da se najde granicniot slucaj
        // i funkcijata se povikuva samata sebesi
        if (node == null) return null;

        if(node.info.equals(elem)){
            return node;
        }

        BNode<E> findLeft = findJazolR(node.left, elem);
        if(findLeft != null){
            return findLeft;
        }

        BNode<E> findRight = findJazolR(node.right, elem);
        return findRight;
    }

    public void findJazol(E elem){
        BNode<E> jazol = findJazolR(root, elem);
        if(jazol != null){
            System.out.println("Jazol so element: " + elem + " e najden vo drvoto");
        }
        else{
            System.out.println("NE POSTOI TAKOV JAZOL VO DROVOTO");
        }
    }

    public int findStepenR(BNode<E> node, E elem, int stepen)
    {
        if (node == null)
            return -1;

        if(node.info.equals(elem)){
            return stepen;
        }

        int findLeft = findStepenR(node.left, elem, stepen+1);
        if(findLeft != -1){
            return findLeft;
        }

        int findRight = findStepenR(node.right, elem, stepen+1);
        return findRight;
    }

    public void findStepen(E elem){
        int findStepen = findStepenR(root, elem, 1);
        if(findStepen > 0){
            System.out.println("Stepenot na baraniot jazol so vrednost " + elem.toString() + " iznesuvua: " + findStepen);
        }
    }

    public int presmetajSumaLeviDecaR(BNode<Integer> node){
        if (node == null) return 0;

        int sum = 0;
        if(node.left != null && node.right == null){
            sum += node.info;
        }

        sum += presmetajSumaLeviDecaR(node.left);
        sum += presmetajSumaLeviDecaR(node.right);

        return sum;
    }

    public int presmetajSumaR(BNode<Integer> node){
        if (node == null) return 0;

        return (node.info + presmetajSumaR(node.left) + presmetajSumaR(node.right));
    }
}
