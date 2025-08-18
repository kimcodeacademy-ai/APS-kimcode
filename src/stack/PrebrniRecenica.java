// vnesi recenica od konzola i so koristenje na stack istata prebrni ja naopaku

package stack;

import java.util.Scanner;

public class PrebrniRecenica {

    public static void main(String[] args) {
        LinkedStack<Character> listaStack = new LinkedStack<>();

        String recenica, prebrnataRecenica = "";
        Scanner sc = new Scanner(System.in);
        recenica = sc.nextLine();

        for(int i = 0; i < recenica.length(); i++) {
            Character c = recenica.charAt(i);
            listaStack.push(c);
        }

        while(!listaStack.isEmpty()){
            prebrnataRecenica = prebrnataRecenica + listaStack.pop();
        }

        System.out.println(prebrnataRecenica);
    }
}
