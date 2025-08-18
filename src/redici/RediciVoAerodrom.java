//На аеродром патниците чекаат ред за чек-ин. Имаме две авиокомпании: „AirMacedonia“ и „FlyBalkan“.
//Правила:
//
//Патниците доаѓаат мешано во еден главен ред.
//
//Секој се префрла во редот на својата компанија.
//
//На крај се прикажува кој патник е услужен по ред за секоја компанија

package redici;

import java.util.Scanner;

public class RediciVoAerodrom {

    public static void main(String[] args) {
        LinkedQueue<String> arrivals = new LinkedQueue<>();
        LinkedQueue<String> airMacedonia = new LinkedQueue<>();
        LinkedQueue<String> flyBalkan = new LinkedQueue<>();

        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();

        for(int i = 0; i <= n; i++){
            arrivals.enqueue(sc.nextLine());
        }

        // podelba spored aviokompanija
        while(!arrivals.isEmpty()){
            String s =  arrivals.dequeue();
            if(s.contains("AirMacedonia")){
                airMacedonia.enqueue(s);
            }
            else{
                flyBalkan.enqueue(s);
            }
        }

        System.out.println("Check-in AirMacedonia");
        while(!airMacedonia.isEmpty()){
            System.out.println(" - " + airMacedonia.dequeue());
        }

        System.out.println("Check-in FlyBalkan");
        while(!flyBalkan.isEmpty()){
            System.out.println(" - " + flyBalkan.dequeue());
        }

    }
}
