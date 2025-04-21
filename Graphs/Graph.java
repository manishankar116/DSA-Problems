
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	private HashMap<String, ArrayList<String>> graph = new HashMap<>();
	
	public boolean addVertex(String vertex) {
		if(graph.get(vertex) == null) {
				graph.put(vertex, new ArrayList<String>());
				return true;
		}
		return false;
	}
	
	public boolean addEdge(String vertex1, String vertex2) {
		if(graph.get(vertex1) != null && graph.get(vertex2) != null){
			graph.get(vertex1).add(vertex2);
			graph.get(vertex2).add(vertex1);
			return true;
		}
		return false;
	}
	           
	public boolean removeEdge(String vertex1, String vertex2) {
		if(graph.get(vertex1) != null && graph.get(vertex2) != null) {
			graph.get(vertex1).remove(vertex2);
			graph.get(vertex2).remove(vertex1);
			return true;
		}
		return false;
	}
	
	public boolean removeVertex(String vertex) {
		if(graph.get(vertex) == null) return false;
		
		for(String vert : graph.get(vertex)) {
			graph.get(vert).remove(vertex);
		}
		
		graph.remove(vertex);
		return true;
	}
	
	public void printGraph() {
		System.out.println(graph);
	}
	
	public static void main(String[] args) {
		Graph obj = new Graph();
		obj.addVertex("A");
		obj.addVertex("B");
		obj.addVertex("C");
		
		obj.printGraph();
		
		obj.addEdge("A", "B");
		obj.addEdge("B", "C");
		obj.addEdge("C", "A");
		
		obj.printGraph();
		
		obj.removeEdge("A", "B");
		
		obj.printGraph();
		
		obj.removeVertex("B");
		
		obj.printGraph();
		
	}
}
