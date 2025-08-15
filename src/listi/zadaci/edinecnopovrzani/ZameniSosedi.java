package listi.zadaci.edinecnopovrzani;

public class ZameniSosedi {

    public static SLL<Integer> swapPairs(SLL<Integer> lista) {
        SLLNode<Integer> first = lista.getFirst();
        if (first == null || first.succ == null) {
            return lista;
        }

        SLLNode<Integer> prev = null;
        SLLNode<Integer> current = first;
        SLLNode<Integer> newFirst = current.succ;

        while (current != null && current.succ != null) {
            SLLNode<Integer> next = current.succ;
            SLLNode<Integer> nextPair = next.succ;

            next.succ = current;
            current.succ = nextPair;

            if (prev != null) {
                prev.succ = next;
            }

            prev = current;
            current = nextPair;
        }

        lista.insertFirst(newFirst.element);

        return lista;
    }

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<>();
        lista.insertLast(1);
        lista.insertLast(2);
        lista.insertLast(3);
        lista.insertLast(4);
        lista.insertLast(5);

        System.out.println("Originalna lista:  " + lista);
        lista = swapPairs(lista);
        System.out.println("Posle zamenuvanje na mestata:  " + lista);
    }
}