//Задача 1. Епидемиjа
//Поради епидемиjа на сезонски грип при секое тестирање на даден пациент се
//зачувува општината во коjа живее, неговото презиме и информациjа дали е позитивен или негативен на вирусот. Потребни се статистички податоци за да се
//одреди ризик факторот за дадена општина. Ваша задача е за дадена општина на
//излез да го испечатите ризик факторот во дадената општина. Ризик факторот
//се пресметува на следниот начин:
//Ризик фактор =
//        броj на позитивни пациенти /
//броj на негативни пациенти + броj на позитивни пациенти
//Забелешка: Можно е да се поjават пациенти со исто презиме. Истите треба
//да се земат како посебни вредности во статистиката.
//Влез: На влез наjпрво е даден броjот на пациенти 𝑁, а потоа секоj пациент е
//даден во нов ред во форматот: „Општина во коjа живее” „Презиме на пациент”
//        „Резултати од тестот(positive/negative)”. На краj е дадена општината за коjа
//треба да се пресмета ризик факторот.
//Излез: Децимален броj заокружен на две децимали коj го претставува ризик
//факторот за дадената општина.
//Пример:
//Влез:
//        182
//Податочни структури
//6
//Centar Stojanoski negative
//Centar Trajkovski positive
//Centar Petkovski positive
//Karpos Stojanoski positive
//Karpos Trajkovski negative
//Centar Trajkovski positive
//        Centar
//Излез:
//        0.75


//6
//Centar Stojanoski negative
//Centar Trajkovski positive
//Centar Petkovski positive
//Karpos Stojanoski positive
//Karpos Trajkovski negative
//Centar Trajkovski positive



package ispitni;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// key:String(Naselba) , value: Integer (Broj na pacienti zarazeni po opstina)
public class HashIspitna {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, Integer> positivePatients = new CBHT<>(2*N);
        CBHT<String, Integer> negativePatients = new CBHT<>(2*N);

        for(int i = 0; i < N; i++){
            String input [] = br.readLine().split(" ");
            if(input[2].equals("positive")){
                SLLNode<MapEntry<String, Integer>> pozPaci = positivePatients.search(input[0]);
                if(pozPaci != null){
                    Integer numPositive = pozPaci.element.value+1;
                    positivePatients.insert(input[0], numPositive);
                }
                else{
                    positivePatients.insert(input[0], 1);
                }
            }
            else{
                SLLNode<MapEntry<String, Integer>> negPaci = negativePatients.search(input[0]);
                if(negPaci != null){
                    Integer numNegative = negPaci.element.value+1;
                    negativePatients.insert(input[0], numNegative);
                }
                else{
                    negativePatients.insert(input[0], 1);
                }
            }
        }

//        System.out.println(positivePatients.toString());
//        System.out.println(negativePatients.toString());

        String opstina = br.readLine();
        SLLNode<MapEntry<String, Integer>> pozPaci = positivePatients.search(opstina);
        SLLNode<MapEntry<String, Integer>> negPaci = negativePatients.search(opstina);

        Integer pozitivni = pozPaci.element.value;
        Integer negativni = negPaci.element.value;

        System.out.println(String.format("%.2f", pozitivni * 1.00 / (negativni+pozitivni)));

    }
}
