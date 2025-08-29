//Se vnesuva n i potoa se vnesuvaat N komandi.Komandite se UNDO sto go brise posledniot element ,ako nema posleden element se ignorira komandata.
// SHOW gi pecati vnesenite karakteri i TYPE X vesuva karakter x.
//
//        primer
//        4
//        TYPE H
//        TYPE S
//        UNDO
//        SHOW
//
//        output:H

// stack - LIFO
// prebrni ja recenicata naopaku, undo, proveri tocnost na matematicki izraz

package ispitni;

import java.util.Scanner;

public class stackispitna {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        LinkedStack<Character> stack = new LinkedStack<>();

        for(int i = 0; i < N; i++){
            String line = sc.nextLine();

            if(line.startsWith("TYPE")){
                char c = line.split(" ")[1].charAt(0);
                stack.push(c);
            }
            else if(line.startsWith("UNDO")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                LinkedStack<Character> stack2 = new LinkedStack<>();
                while(!stack.isEmpty()){
                    Character c = stack.pop();
                    stack2.push(c);
                    System.out.println(c);
                }
                while(!stack2.isEmpty()){
                    stack.push(stack2.pop());
                }
            }

        }

        //System.out.println(stack);
    }
}
