package listi.zadaci.dvojnopovrzani;

//Дадена е двоjно поврзана листа со N jазли каде секоj jазел содржи по еден броj.
//Да се провери дали двоjно поврзаната листа е палиндром: односно ако jа изминете од почеток до краj и од краj до почеток, дали ´ке добиете ист збор.
// Влез: Во првиот ред од влезот даден е броjот на jазли во листата N, а во
//вториот ред се дадени броевите.
//Излез: На излез треба да се испечати 1 ако листата е палиндром, -1 ако не е.
//Пример.
//Влез 1:
//5
//1 2 3 1 2
//Излез:
//-1
//Влез 2:
//5
//1 2 3 2 1
//Излез:
//1


import java.util.Scanner;

public class Palindrom {

    public static int isItPalindrome(DLL<Integer> lista){
        DLLNode<Integer> first = lista.getFirst();
        DLLNode<Integer> last = lista.getLast();

        while((first != last) && (first.pred != last)){
            if(!first.element.equals(last.element))
                return -1;
            first = first.succ;
            last = last.pred;
        }

        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DLL<Integer> lista = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            lista.insertLast(sc.nextInt());
        }
        sc.close();

        System.out.println(isItPalindrome(lista));

    }
}
