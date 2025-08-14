package nizi.zadaci;

import nizi.Array;

/**
 Користејќи ја класата Array<E>, напиши програма што ќе внесе цели броеви во низа и ќе го најде најголемиот број.
 */
public class NajgolemBrojVoNiza {

    public static void main(String[] args) {
        Array<Integer> novaNiza = new Array<Integer>(8);

        novaNiza.insertLast(-1);
        novaNiza.insertLast(-3);

        novaNiza.insertLast(-10);
        novaNiza.insertLast(-22);
        novaNiza.insertLast(-1);
        novaNiza.insertLast(-3);
        novaNiza.insertLast(-3);

        int najgolemBroj = 0;

        for(int i = 0; i < novaNiza.getSize(); i++){
            if(i == 0){
                najgolemBroj = novaNiza.get(i);
            }
            if(novaNiza.get(i) > najgolemBroj){
                najgolemBroj = novaNiza.get(i);
            }
        }

        System.out.println(najgolemBroj);

    }
}
