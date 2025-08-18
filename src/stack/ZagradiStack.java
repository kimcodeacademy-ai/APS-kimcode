//Да се провери коректноста на заградите во еден израз. Еден израз има коректни
//загради ако:
//- За секоjа лева заграда, подоцна следува соодветна десна заграда - За секоjа
//десна заграда претходно постои лева заграда
//- Секоj под-израз ме´гу пар од две загради содржи коректен броj на загради.
//Примери на изрази со коректни и некоректни загради:
//s x (s – a) x (s – b) x(s - c) коректни
//(– b + sqrt[b2 – 4ac]) / 2a коректни
//s x (s – a) x (s – b x (s – c) некоректни
//s x (s – a) x s – b) x (s – c) некоректни
//(– b + sqrt[b2 – 4ac)] / 2a некоректни
//Влез: Во влезот е даден изразот коj се внесува.
//Излез: На излез треба да се испечати дали заградите во изразот се коректни
//или не.
//Пример:
//Влез: s x (s - a) x (s - b) x (s - c)
//Излез: s x (s - a) x (s - b) x (s - c) ima korektni zagradi.

package stack;

import java.util.Scanner;

public class ZagradiStack {

    public static boolean daliSeKorektni(String izraz){
        ArrayStack<Character> izrazStack = new ArrayStack<>(100);

        // chekame na bojana
        // nekoj ciklus za da zimame karakter po karakter
        // da proverime dali karakterot vo ciklusot e zagrada
        // da go vmetnee vo stekot ako e zagrada
        for(int i = 0; i < izraz.length(); i++){
            char current = izraz.charAt(i);
            if (current == '(' || current == '{' || current == '[') {
                izrazStack.push(current);
            }
            else if(current == ')' || current == '}' || current == ']'){
                if(izrazStack.isEmpty())
                    return false;
                char left = izrazStack.pop();
                if(!daliSeSovpagjaatZagradite(left, current))
                    return false;
            }
        }

        return (izrazStack.isEmpty());
    }

    public static boolean daliSeSovpagjaatZagradite(char left, char right){

        switch (left){
            case '(':
                return right == ')';
                case '[':
                    return right == ']';
            case '{':
                return right == '}';
        }

        return false;
    }


    public static void main(String[] args) {
        String izraz;
        Scanner sc = new Scanner(System.in);
        izraz = sc.nextLine();

        System.out.println("Izrazot: " + izraz + " ima " + (daliSeKorektni(izraz) ? "korektni" : "nekorektni") + " zagradi");
    }
}
