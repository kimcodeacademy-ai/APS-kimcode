//Задача: CPU Scheduling со Round Robin и приоритети

//Опис:
//Имаме неколку задачи што треба да се извршат на CPU. Секоја задача има:
//Име (String)
//Траење (во секунди, int)
//Приоритет (1 = највисок, 2 = среден, 3 = низок)
//CPU работи според Round Robin алгоритам со временски квантум = 3 секунди.
//Правила:

//Секогаш прво се извршуваат задачи од највисокиот достапен приоритет.
//Ако задачата трае повеќе од 3 секунди, се извршуваат 3 секунди и задачата се враќа во редицата со преостанато време.
//Ако задачата трае ≤ 3 секунди, целата задача се завршува и се брише од редицата.
//        Влез:
//Job1 8 1
//Job2 4 2
//Job3 9 1
//Job4 5 3
//Job5 2 2
//(Формат: Име Траење Приоритет)
//Излез (пример):
//CPU Scheduling (Round Robin со приоритет):
//Job1 работи 3 секунди (останува 5)
//Job3 работи 3 секунди (останува 6)
//Job1 работи 3 секунди (останува 2)
//Job3 работи 3 секунди (останува 3)
//Job1 завршува (2 секунди)
//Job3 завршува (3 секунди)
//Job2 работи 3 секунди (останува 1)
//Job5 завршува (2 секунди)
//Job2 завршува (1 секунди)
//Job4 работи 3 секунди (останува 2)
//Job4 завршува (2 секунди)

package redici;

public class RoundRobin {
    public static void main(String[] args) {
        LinkedQueue<String> prio1 = new LinkedQueue<>();
        LinkedQueue<String> prio2 = new LinkedQueue<>();
        LinkedQueue<String> prio3 = new LinkedQueue<>();

        int quantum = 3;

        // Влезни задачи (Име|Траење|Приоритет)
        String[] jobs = {
                "Job1|8|1",
                "Job2|4|2",
                "Job3|9|1",
                "Job4|5|3",
                "Job5|2|2"
        };

        // Додавање во редиците според приоритет
        for (String job : jobs) {
            String[] parts = job.split("\\|");
            String name = parts[0];
            int time = Integer.parseInt(parts[1]);
            int prio = Integer.parseInt(parts[2]);
            String j = name + "|" + time;
            if (prio == 1) prio1.enqueue(j);
            else if (prio == 2) prio2.enqueue(j);
            else prio3.enqueue(j);
        }

        System.out.println("CPU Scheduling (Round Robin со приоритет):");

        while (!prio1.isEmpty() || !prio2.isEmpty() || !prio3.isEmpty()) {
            LinkedQueue<String> currentQueue;

            if (!prio1.isEmpty()) currentQueue = prio1;
            else if (!prio2.isEmpty()) currentQueue = prio2;
            else currentQueue = prio3;

            String job = currentQueue.dequeue();
            int sep = job.indexOf('|');
            String name = job.substring(0, sep);
            int time = Integer.parseInt(job.substring(sep + 1));

            if (time > quantum) {
                System.out.println(name + " работи " + quantum + " секунди (останува " + (time - quantum) + ")");
                currentQueue.enqueue(name + "|" + (time - quantum));
            } else {
                System.out.println(name + " завршува (" + time + " секунди)");
            }
        }
    }
}
