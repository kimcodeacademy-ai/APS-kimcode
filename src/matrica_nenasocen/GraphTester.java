package matrica_nenasocen;

import java.util.Random;

public class GraphTester {

	public static void main(String[] args) {
        Character niza[] = new Character[10];
        for(int i = 0; i < 10; i++){
            niza[i] = (char)((int)'A' + i);
        }
        Graph<Character> g = new Graph<Character>(10, niza);

        int x, y;
        Random r = new Random();
        for(int i = 0; i < 15; i++){
            x = r.nextInt(10);
            y = r.nextInt(10);
            if(x!=y){
                if(g.adjacent(x, y) != 1){
                    g.addEdge(x, y);
                    System.out.println("Dodavam nekoe rebro pomegju " + niza[x] + " i " + niza[y]);
                }
                else{
                    i--;
                }
            }
            else{
                i--;
            }
        }

        System.out.println(g);

        System.out.println("Printaj DFS rekurzivno: ");
        g.dfsSearch(0);

        System.out.println("Printaj DFS iterativno: ");
        g.dfsNonrecursive(0);

        System.out.println("Printaj BFS");
        g.bfs(0);
	}

}
