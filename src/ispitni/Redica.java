//Da se napravi working printer. Se vnesuva n naredbi. Naredbite se:
//        ADD Dokument x -> dodaj x dokumenta so status waiting
//        STATUS -> ispecati go statusot na printerot
//        PRINT x -> printaj gi prvite x dokumenta koi se vo sostojba waiting, stavi ja nivnata sostojba vo printed.
//
//        Test case:
//        10
//
//        ADD Dokument 3
//        STATUS
//        ADD Sostanok 2
//        STATUS
//        PRINT 2
//        STATUS
//        PRINT 2
//        STATUS
//        PRINT 1
//        STATUS
//
//        Output:
//        Current status:
//        Dokument waiting
//        Dokument waiting
//        Dokument waiting
//
//        Current status:
//        Dokument waiting
//        Dokument waiting
//        Dokument waiting
//        Sostanok waiting
//        Sostanok waiting
//
//        Current status:
//        Dokument printed
//        Dokument printed
//        Dokument waiting
//        Sostanok waiting
//        Sostanok waiting
//
//        Current status:
//        Dokument printed
//        Dokument printed
//        Dokument printed
//        Sostanok printed
//        Sostanok waiting
//
//        Current status:
//        Dokument printed
//        Dokument printed
//        Dokument printed
//        Sostanok printed
//        Sostanok printed



// redica - FIFO princip
// analogija: redica na shalter

//10
//ADD Dokument 3
//STATUS
//ADD Sostanok 2
//STATUS
//PRINT 2
//STATUS
//PRINT 2
//STATUS
//PRINT 1
//STATUS

package ispitni;

import java.util.Scanner;

class Document {
    String name;
    String status;

    Document(String name){
        this.name=name;
        this.status="waiting";
    }

    @Override
    public String toString(){
        return this.name + " " + this.status;
    }
}
public class Redica {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();

        ArrayQueue<Document> queue = new ArrayQueue<>(n);

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            String [] parts = line.split(" ");
            if(parts[0].equals("ADD")){
                String docName = parts[1];
                int count = Integer.parseInt(parts[2]);
                for(int j = 0; j < count; j++){
                    queue.enqueue(new Document(docName));
                }
            }
            else if(parts[0].equals("PRINT")){
                int toPrint = Integer.parseInt(parts[1]);
                int printed = 0;
                int size = queue.size();
                for(int j = 0; j < size; j++){
                    Document d = queue.dequeue();
                    if(d.status.equals("waiting") && printed < toPrint){
                        d.status = "printed";
                        printed++;
                    }
                    queue.enqueue(d);
                }
            }
            else{
                System.out.println("Current status: ");
                int golemina = queue.size();
                for (int j = 0; j < golemina; j++){
                    Document d = queue.dequeue();
                    System.out.println(d.toString());
                    queue.enqueue(d);
                }
                System.out.println();
            }
        }

        sc.close();
//        while (!queue.isEmpty()){
//            System.out.println(queue.dequeue().toString());
//        }
        //System.out.println(queue);


    }
}
