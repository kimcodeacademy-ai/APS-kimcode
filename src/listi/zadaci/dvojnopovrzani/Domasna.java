// Дадена е двострано поврзана листа коjа содржи природни броеви. Ваша задача
//е да jа преуредите влезната листата, т.ш. ме´гу секои два соседни jазли од влезната листа ´ке додадете нов jазел коj ´ке jа содржи средната вредност од двата
//соседни jазли. Доколку средната вредност е децимална, тогаш броjот треба да
//биде заокружен на поголемиот (пр. Ако соседните jазли имаат вредност 1 и 2,
//нивната средна вредност е 1,5 и оваа вредност се заокружува на 2).
//Влез: Од стандарден влез во првиот ред се дава цел броj N, коj го претставува броjот на елементи во листата, а во вториот се даваат броевите во листата
//одделени со празно место.
//Излез: Ваша задача е да jа испечатите резултантната листа.
//Пример.
//Влез:
//3
//1 2 4
//Излез:
//1 2 2 3 4

package listi.zadaci.dvojnopovrzani;

import java.util.Scanner;

public class Domasna {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        DLL<Integer> lista = new DLL<>();

        for (int i = 0; i < N; i++) {
            lista.insertLast(sc.nextInt());
        }

        DLLNode<Integer> current = lista.getFirst();
        while (current != null && current.succ != null) {
            int a = current.element;
            int b = current.succ.element;

            int sredna = (int) Math.ceil((a + b) / 2.0);

            lista.insertAfter(sredna, current);

            current = current.succ.succ;
        }

        DLLNode<Integer> tmp = lista.getFirst();
        while (tmp != null) {
            System.out.print(tmp.element + " ");
            tmp = tmp.succ;
        }
    }
}
