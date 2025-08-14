package nizi.zadaci;

import nizi.Array;
import java.util.Scanner;
//    Scanner scanner = new Scanner(System.in);
//        String zbor = scanner.nextLine();


/**
 * Напиши програма што ќе креира низа од стрингови со помош на класата Array<E> и ќе ги избрише сите појави на даден збор.
 */
public class IzbrisiZborVoNiza {
    public static void main(String[] args) {
        Array<String> novaNiza = new Array<String>(10);

        novaNiza.insertLast("algoritmi");
        novaNiza.insertLast("sadasddas");
        novaNiza.insertLast("algoritmi");
        novaNiza.insertLast("algoritmi");
        novaNiza.insertLast("algoritmi");
        novaNiza.insertLast("sadasddas");
        novaNiza.insertLast("algoritmi");
        novaNiza.insertLast("sadasddas");
        novaNiza.insertLast("sadasddas");
        novaNiza.insertLast("sadasddas");

        // procitime od konzola
        Scanner scanner = new Scanner(System.in);
        String zborce = scanner.nextLine();

        for(int i = 0; i < novaNiza.getSize(); i++){
            if(novaNiza.get(i).equals(zborce)){
                novaNiza.delete(i);
                i--;
            }
        }

        System.out.println(novaNiza);
    }
}
