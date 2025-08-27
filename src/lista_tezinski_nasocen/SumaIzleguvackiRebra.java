// lista tezinski nasocen
// suma na izleguvacki rebra za celiot graf

package lista_tezinski_nasocen;

class Neighbor<E>{
    GraphNode<E> node;
    float weight;

    public Neighbor(GraphNode<E> node, float weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class SumaIzleguvackiRebra {
    public static void main(String[] args) {
        Graph<String> g = new Graph<>(4);
        g.adjList[0] = new GraphNode<>(0 , "A");
        g.adjList[1] = new GraphNode<>(0 , "B");
        g.adjList[2] = new GraphNode<>(0 , "C");
        g.adjList[3] = new GraphNode<>(0 , "D");

        // dodavam rebra nasoceni so nekoja tezina
        g.addEdge(0, 1, 3); // A -> B so tezina 3
        g.addEdge(0, 2, 4); // A -> C so 4
        g.addEdge(1, 3, 4); // B -> D so 4
        g.addEdge(2, 3, 4); // C -> D so 4

        System.out.println("Ispecati go grafot: ");
        System.out.println(g);

        System.out.println("Vkupnata suma na izleguvackite rebra inzesuva: ");
        for(int i = 0; i < g.num_nodes; i++){
            float sum = totalOutgoingWeight(g, i);
            System.out.println(g.adjList[i].getInfo() + " nadvoresnata suma iznesuva: " + sum);
        }
    }

    static float totalOutgoingWeight(Graph<String> g, int nodeIndex){
        float sum = 0;
        for(GraphNodeNeighbor<String> neighbor : g.adjList[nodeIndex].getNeighbors()){
            sum+= neighbor.weight;
        }
        return sum;
    }

}
