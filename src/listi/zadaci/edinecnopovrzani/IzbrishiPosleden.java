package listi.zadaci.edinecnopovrzani;

//Дадена е еднострано поврзана листа чии што jазли содржат цели броеви. За
//даден броj од тастатура, потребно е да се отстрани неговото последно поjавување
//        (да се избрише jазолот што го содржи броjот).
//Влез: Во првата линиjа е даден броjот на елементи n. Во следните n линии
//се дадени елементите на листата. Во последната линиjа е даден броjот коj треба
//да се отстрани (неговото последно поjавување).
//Излез: На излез треба да се испечатат jазлите на резултантната листа.
//Пример.

import java.util.Scanner;

public class IzbrishiPosleden {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        SLL<Integer> lista = new SLL<Integer>();

        for(int i = 0; i < n; i++){
            int el = sc.nextInt();
            lista.insertLast(el);
        }

        int todelete = sc.nextInt();

        SLLNode<Integer> node = lista.getFirst();
        SLLNode<Integer> hasToBeDeleted = null;

        while(node!=null){
            if(node.element == todelete){
                hasToBeDeleted = node;
                break;
            }
            node = node.succ;
        }
        if(hasToBeDeleted != null){
            lista.delete(hasToBeDeleted);
        }

        System.out.println(lista);

    }
}
