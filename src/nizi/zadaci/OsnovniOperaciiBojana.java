package nizi.zadaci;

import nizi.Array;

public class OsnovniOperaciiBojana {
    public static void main(String[] args) {
        Array<Integer> novaNiza = new Array<Integer>(10);

        novaNiza.insertLast(13);
        novaNiza.insertLast(8);
        novaNiza.insertLast(10);
        novaNiza.insertLast(15);

        System.out.println(novaNiza);
        System.out.println(novaNiza.getSize());

        novaNiza.insert(1, 111);
        System.out.println(novaNiza);
        System.out.println(novaNiza.getSize());

        System.out.println(novaNiza.get(3));

        System.out.println("Brisenje");
        novaNiza.delete(3);
        System.out.println(novaNiza);

        for(int i = 0; i < 20; i++){
            novaNiza.insertLast(i);
        }
        System.out.println(novaNiza);

        novaNiza.set(2, 1110);
        System.out.println(novaNiza);

        System.out.println(novaNiza.toString());

    }
}
