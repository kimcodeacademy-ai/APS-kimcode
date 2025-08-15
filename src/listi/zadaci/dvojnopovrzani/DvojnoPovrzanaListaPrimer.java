package listi.zadaci.dvojnopovrzani;

public class DvojnoPovrzanaListaPrimer {
    public static void main(String[] args) {
        DLL<Integer> lista  = new DLL<Integer>();
        lista.insertLast(5);
        lista.insertLast(2);
        lista.insertLast(5);
        lista.insertLast(2);
        lista.insertLast(6);
        lista.insertLast(100);
        lista.insertLast(4);
        System.out.println(lista);

        System.out.println("listata po vmetnuvanje na prv element");
        lista.insertFirst(10);

        System.out.println(lista);

        DLLNode<Integer> brisi = null;
        DLLNode<Integer> prv = lista.getFirst();
        for(int i = 0; i <= 3; i++){
            brisi = prv;
            prv = prv.succ;
        }

        lista.insertBefore(100, prv);
        System.out.println("Listata po brisenje na 2kata sto se naogja na 3 pozicija");
        System.out.println(lista);

        DLLNode<Integer> pozicija = lista.find(100);


        // namesto prvoto naogjanje na 100 sakama poslednoto da go izbriseme
        DLLNode<Integer> last = lista.getLast();

        DLLNode<Integer> tmp = last;
        while (!tmp.element.equals(100) && tmp.pred != null)
            tmp = tmp.pred;
        if (tmp.element.equals(100)) {
            pozicija = tmp;
        }


        // od kraj kon pocetok
        lista.delete(pozicija);
        System.out.println(lista);


        System.out.println(lista.getSize());

    }
}
