//За даден jазел во нетежински граф, да се наjдат наjкратките патишта до сите
//други jазли


package matrica_nenasocen;

public class NajkratokPatiNetezinski {
    public static void main(String[] args) {
        Graph<String> g = new Graph<String>(6);

        g.set_node_value(0, "A");
        g.set_node_value(1, "B");
        g.set_node_value(2, "C");
        g.set_node_value(3, "D");
        g.set_node_value(4, "E");
        g.set_node_value(5, "F");

        // dodaj rebra
        g.addEdge(0, 1); // A-B
        g.addEdge(0, 2); // A-C
        g.addEdge(1, 2); // B-C
        g.addEdge(1, 3); // B-D
        g.addEdge(0, 3); // A-D
        g.adjacent(2, 4); //C-E
        g.addEdge(3, 5); // D-F
        g.addEdge(4, 5); // E-F

        System.out.println("Pecati matrica: ");
        System.out.println(g);

        System.out.println("Najktratok pat od A: ");
        int [] dist = g.shortestPathFromVertex(0);

        for(int i = 0; i < dist.length; i++){
            System.out.println("A -> " +  g.get_node_value(i) + " = " + dist[i]);
        }
    }
}
