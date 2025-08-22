//Во рамки на една хуманитарна организациjа, потребно е да се направи статистика за крвните групи кои се на располагање за донациjа,
// и од кои донатори.
//Податочни структури
//Подгрупите А1+, А2+ припа´гаат на крвна група А+, додека А1- , А2- припа´гаат
//на група А-.
//Влез: Во првиот ред од влезот е даден броjот на парови 𝑁, а во секоj нареден
//ред се дадени паровите (донатор, крвна група).
//Излез: Да се испечати по колку донатори има од секоjа крвна група согласно
//внесените податоци.
//Пример:
//Влез:
//        5
//Alek A1+
//Dejan B−
//Sandra A+
//Trajce 0+
//Rebeka A1−
//Излез:
//A+=2
//B−=1
// 0+=1
//A−=1



package heshiranje.zadaci;

import heshiranje.MapEntry;
import heshiranje.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// kluc vednost
// kluc: krvna grupa
// vrednost: counter od krvnite grupi - grupirani spored (a+)
public class CrvenKrst {
    public static void main(String[] args) throws IOException {
        OBHT<String, Integer> hashtable = new OBHT<>(11);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String input;

        for(int i = 0; i < N; i++){
            // Dejan A1+
            input = br.readLine();
            String[] row= input.split(" ");
            String key = row[1];
            // A1+
            key = key.replaceAll("[1-2]", "");
            // A+

            // dali ne postoi takov element vo hash tabelata
            if(hashtable.search(key) == -1){
                // dodavam nov map key
                hashtable.insert(key, 1);
            }
            else{
                hashtable.insert(
                        key, hashtable.search(key) + 1
                );
            }
        }

        System.out.println(hashtable);
    }
}
