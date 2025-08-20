//На еден светски познат предавач секоjдневно му пристигнуваат понуди да држи
//        предавања. За секоjа понуда се дадени датуми, време на почеток, градот и износот на хонорарот за предавањето (во долари). Ваша задача е за даден датум да
//        го прикажете предавањето кое би му донело наjголема заработка на предавачот.
//        Доколку нема понуди за дадениот датум да се испечати „No offers”.
//        Влез: Во првиот ред од влезот е даден броjот на понуди, а во секоj нареден
//        ред се дадени: датумот и времето на предавањето (формат dd/mm/yyyyhh:mm),
//        градот во коj ´ке се одржува предавањето и износот на хонорарот. Во последниот
//        ред е даден датумот за коj треба да испечатите коjа понуда е наjдобра за тоj
//        датум.
//        Излез: Деталите на понудата за тоj датум.
//        Пример:
//        Влез:
//        7
//        27/01/2016 14:00 NewYork 6000
//        28/01/2016 08:00 Paris 3000
//        28/01/2016 14:00 Munich 5000
//        27/01/2016 09:00 Beijing 8000
//        27/01/2016 08:00 Seattle 4000
//        28/01/2016 09:00 SaltLakeCity 10000
//        28/01/2016 09:00 Lagos 12000
//        27/01/2016
//        Излез:
//        09:00 Beijing 8000

package heshiranje.zadaci;


import heshiranje.CBHT;
import heshiranje.MapEntry;
import heshiranje.SLLNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// kluc ke ni bide datum
// element ke ni bide nekoja klasa za lekcija
class Lecture implements Comparable<Lecture> {
    String date;
    String time;
    String place;
    Integer fee;

    public Lecture(String date, String time, String place, Integer fee) {
        this.date = date;
        this.time = time;
        this.place = place;
        this.fee = fee;
    }

    @Override
    public int compareTo (Lecture obj){
        return this.fee.compareTo(obj.fee);
    }

    public String getTime(){return time;}
    public String getPlace(){return place;}
    public Integer getFee(){return fee;}

}
public class PoznatPozdravac {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CBHT<String, ArrayList<Lecture>> hashtable = new CBHT<>(2*N);

        for(int i = 0; i < N; i++){
            String []input = br.readLine().split(" ");
            Lecture p = new Lecture(input[0], input[1], input[2], Integer.parseInt(input[3]));

            SLLNode<MapEntry<String, ArrayList<Lecture>>> node = hashtable.search(input[0]);
            if(node == null){
                ArrayList<Lecture> list = new ArrayList<>();
                list.add(p);
                hashtable.insert(input[0], list);
            }
            else{
                ArrayList<Lecture> lectures = node.element.value;
                lectures.add(p);
                // so ova ja sortirame listata i lekcijata sto cini najmnogu pari sekogas ke bide prva
                Collections.sort(lectures, Collections.reverseOrder());
                hashtable.insert(input[0], lectures);
            }
        }

        //System.out.println(hashtable.toString());

        String date = br.readLine();
        SLLNode<MapEntry<String, ArrayList<Lecture>>> node = hashtable.search(date);

        if(node != null){
            Lecture best = node.element.value.get(0);
            System.out.println(best.getTime() + " " + best.getPlace() + " " +  best.getFee());
        }
        else{
            System.out.println("Empty");
        }
    }
}
