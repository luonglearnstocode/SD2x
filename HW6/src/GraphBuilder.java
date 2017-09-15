


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GraphBuilder {
		
	public static DirectedGraph buildDirectedGraph(String filename) {
		DirectedGraph dg = new DirectedGraph();
		try {
			buildGraph(dg, filename);
		}
		catch (Exception e) {
			System.out.println("An exception occurred while trying to read " + filename + ": " + e);
			return null;
		}
		return dg;
	}
	
	public static UndirectedGraph buildUndirectedGraph(String filename) {
		UndirectedGraph ug = new UndirectedGraph();
		try {
			buildGraph(ug, filename);
		}
		catch (Exception e) {
			System.out.println("An exception occurred while trying to read " + filename + ": " + e);
			return null;
		}
		return ug;
	}
	
	protected static void buildGraph(Graph graph, String filename) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] edge = line.split(" ");
		    	if (edge.length < 2) 
		    		continue;
		    	String source = edge[0];
		    	String destination = edge[1];

		    	Node sourceNode = graph.getNode(source);
		    	Node destinationNode = graph.getNode(destination);
		    	graph.addEdge(
		    			sourceNode, destinationNode);
		    }
		}
	}
	


}
