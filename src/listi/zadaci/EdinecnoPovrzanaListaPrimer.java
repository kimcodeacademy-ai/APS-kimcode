package listi.zadaci;

public class EdinecnoPovrzanaListaPrimer {
    public static void main(String[] args) {
        SLL<Integer> lista = new SLL<Integer>();

        lista.insertFirst(4);
        lista.insertLast(5);
        lista.insertLast(6);
        for(int i = 0; i < 10;i++){
            lista.insertLast(i);
        }

        SLLNode<Integer> prviotElement = lista.getFirst();
        lista.insertAfter(100, prviotElement);
        System.out.println(lista);
        lista.deleteFirst();
        System.out.println(lista);

        SLLNode<Integer> temp =  lista.getFirst();
        while(temp.succ.element != 6){
            temp = temp.succ;
        }

        temp.succ = temp.succ.succ;

//        while(temp.succ != null){
//            if(temp.element == 6){
//                lista.delete(temp);
//            }
//            temp = temp.succ;
//        }

        // 100->5->6->0->1->2->3->4->5->6->7->8->9
        System.out.println(lista);
//        System.out.println(lista.toString());
    }
}
