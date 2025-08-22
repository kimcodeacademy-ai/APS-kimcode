//Дадени се мерења на PM10 честички за населбите во Скопjе. Ваша задача е за
//дадена населба да jа наjдете просечната концентрациjа на PM10 честички.
//Влез: Во првиот ред од влезот е даден броjот на мерења, а во секоj нареден ред се дадени населбата и концентрациjата на PM10 честички разделени со
//празно место. Во последниот ред е дадена населбата за коjа треба да наjдете
//просечна концентрациjа на PM10 честички.
//        Излез: Просечната концентрациjа на PM10 честички за дадената населба
//220
//Податочни структури
//        (заокружена на 2 децимали, притоа прво нао´гате просечна концентрациjа, па
//                заокружувате).
//Пример:
//Влез:
//        8
//Centar 319.61
//Karposh 296.74
//Centar 531.98
//Karposh 316.44
//GaziBaba 384.05
//GaziBaba 319.3
//Karposh 393.37
//GaziBaba 326.42
//Karposh
//Излез:
// 355.52


package heshiranje.zadaci;

import heshiranje.OBHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// kluc: Naselbata
// vrednost: ArrayList<Double> - merenjata vmetnati vo lista
public class KvalitetNaVozduh {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        OBHT<String, ArrayList<Double>>  hashtable = new OBHT<>(2*n);

        String input;

        for(int i = 0; i < n; i++){
            input = br.readLine();
            String[] row = input.split(" ");
            String naselba = row[0];
            Double pm10 = Double.parseDouble(row[1]);
            ArrayList<Double> list = new ArrayList<>();

            if(hashtable.search(naselba) == -1){
                list.add(pm10);
                hashtable.insert(naselba, list);
            }
            else{
                list = hashtable.getLista(hashtable.search(naselba)).value;
                list.add(pm10);
                hashtable.insert(naselba, list);
            }
        }

        String naselbaCitaj = br.readLine();
        ArrayList<Double> result = hashtable.getLista(hashtable.search(naselbaCitaj)).value;

        double sum = 0;
        if(result.size()>0){
            for(int i = 0; i < result.size(); i++) {
                sum += result.get(i);
            }

            System.out.printf("%.2f ", sum/result.size());
        }
        else{
            System.out.println("Ne postoi element so taa naselba");
        }

    }
}
