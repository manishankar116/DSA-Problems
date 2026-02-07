
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Transversals {
    
    private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public void addVertex(int vertex){
       if(graph.get(vertex) == null){
            graph.put(vertex, new ArrayList<>());
       }
    }

    public void addEdge(int source, int destination){
        if(graph.get(source) != null && graph.get(destination) != null){
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        else{
            System.out.println("No source or destination found");
        }
    }

    public void removeEdge(int source, int destination){
        if(graph.containsKey(source)  && graph.containsKey(destination)){
            graph.get(source).remove(destination);
            graph.get(source).remove(destination);

            System.out.println("Edge removed");
        }

        else System.out.println("Failed to remove");
    }

    public void DFS(int vertex){
        HashSet<Integer> hs = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        st.push(vertex);

        while(!st.isEmpty()){
            int current = st.pop();
            System.out.print(current + " ");
            hs.add(current);
            for(int neighbour : graph.getOrDefault(current, new ArrayList<>())){
                if(!hs.contains(neighbour)){
                    st.push(neighbour);
                }
            }
        }

    }

    public void BFS(int vertex){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();

        q.add(vertex);
        hs.add(vertex);

        while(!q.isEmpty()){
            int current = q.poll();

            System.out.print(current + " ");

            hs.add(current);

            for(int neighbor : graph.getOrDefault(current, new ArrayList<>())){
                if(!hs.contains(neighbor)){
                    q.add(neighbor);
                }
            }

        }

        

    }

    void printGraph(){
        System.out.println(graph);
    }

    public static void main(String[] args) {
        
        Transversals t = new Transversals();

        t.addVertex(1);
        t.addVertex(2);
        t.addVertex(3);
        t.addVertex(4);

        t.addEdge(1, 2);
        t.addEdge(2, 3);
        t.addEdge(2, 4);

        t.DFS(1);
        System.out.println();
        t.BFS(1);
    }


    
}
