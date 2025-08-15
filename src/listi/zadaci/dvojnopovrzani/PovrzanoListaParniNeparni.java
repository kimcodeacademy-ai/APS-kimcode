package listi.zadaci.dvojnopovrzani;

import java.util.Scanner;

// da ja podelime dvojno povrzanata lista na neparni i parni broevi (dve dopolnitleni listi)
public class PovrzanoListaParniNeparni {

    public static DLL<Integer> podeliParna(DLL<Integer> lista) {
        DLL<Integer> listaParniBroevi =  new DLL<Integer>();
        // od nazad kon napred
        DLLNode<Integer> last = lista.getLast();
        while(last.pred != null) {
            if(last.element % 2 == 0) {
                listaParniBroevi.insertLast(last.element);
            }
            last = last.pred;
        }

        if(last != null) {
            listaParniBroevi.insertLast(last.element);
        }

        return listaParniBroevi;
    }

    public static DLL<Integer> podeliNeparna(DLL<Integer> lista) {
        DLL<Integer> listaParniBroevi =  new DLL<Integer>();
        // od napred kon nazad
        DLLNode<Integer> first = lista.getFirst();
        while(first != null) {
            if(first.element % 2 != 0) {
                listaParniBroevi.insertLast(first.element);
            }
            first = first.succ;
        }

        return listaParniBroevi;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DLL<Integer> lista = new DLL<>();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }

        System.out.println(lista);
        System.out.println(podeliNeparna(lista));
        System.out.println(podeliParna(lista));
    }
}
