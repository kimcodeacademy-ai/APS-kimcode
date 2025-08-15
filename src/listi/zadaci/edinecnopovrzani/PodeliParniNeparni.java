package listi.zadaci.edinecnopovrzani;

public class PodeliParniNeparni {
    public static SLL<Integer> splitEven(SLL<Integer> lista) {
        SLL<Integer> evenList = new SLL<>();
        SLL<Integer> oddList = new SLL<>();

        SLLNode<Integer> current = lista.getFirst();

        while (current != null) {
            if (current.element % 2 == 0) {
                evenList.insertLast(current.element);
            } else {
                oddList.insertLast(current.element);
            }
            current = current.succ;
        }

        return evenList;
    }
    public static SLL<Integer> splitOdd(SLL<Integer> lista) {
        SLL<Integer> evenList = new SLL<>();
        SLL<Integer> oddList = new SLL<>();

        SLLNode<Integer> current = lista.getFirst();

        while (current != null) {
            if (current.element % 2 == 0) {
                evenList.insertLast(current.element);
            } else {
                oddList.insertLast(current.element);
            }
            current = current.succ;
        }

        return oddList;
    }

    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<>();
        lista.insertLast(1);
        lista.insertLast(4);
        lista.insertLast(7);
        lista.insertLast(2);
        lista.insertLast(5);
        lista.insertLast(8);

        System.out.println("Originalna lista:  " + lista);
        SLL<Integer> even = splitEven(lista);
        SLL<Integer> odd = splitOdd(lista);
        System.out.println("Parni:  " + even);
        System.out.println("Neparni:  " + odd);
    }
}
