//Задача 1. Родендени
//        Во заводот на статистика се прави ново истражување каде што се открива броjот
//        на лу´ге родени во секоj месец. Ваша задача е за даден месец да прикажете колку
//        лу´ге се родени во тоj месец.
//        Влез: Во првиот ред од влезот е даден броjот на лу´ге 𝑁, а во секоj нареден
//        ред е даден датумот на ра´гање. Во последниот ред е даден месецот за коj треба
//        да се прикаже броjот на лу´ге родени во тоj месец.
//        Излез: Броj на лу´ге кои се родени во тоj месец. Доколку нема лу´ге родени
//        во тоj месец да се испечати „Empty”.
//        Пример:
//        Влез:
//        4
//        20.7.1976
//        16.7.1988
//        18.7.1966
//        5.6.1988
//        7
//        Излез: 3

package heshiranje;

import java.io.InputStreamReader;
import java.util.Scanner;

public class rodenden{
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.nextLine());

        CBHT<String, Integer> birthDays = new CBHT<>(23);

        for(int i = 0; i < N; i++){
            String p[] = sc.nextLine().split("\\.");
            String month = p[1];

            SLLNode<MapEntry<String, Integer>> node = birthDays.search(month);
            if(node == null){
                birthDays.insert(month, 1);
            }
            else{
                birthDays.insert(month, node.element.value + 1);
            }
        }

        String monthToSearch = sc.nextLine();

        SLLNode<MapEntry<String, Integer>> result = birthDays.search(monthToSearch);

        if(result == null){
            System.out.println("Empty");
        }
        else{
            System.out.println(result.element.value);
        }

        System.out.println(birthDays.toString());

    }
}
