

import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {
	/*
	 * Given a Graph, this method returns the shortest distance (in terms of number of edges)
	 * from the node labeled src to the node labeled dest. 
	 * 
	 * The method should return -1 for any invalid inputs, including: 
	 * 		null values for the Graph, src, or dest; 
	 * 		there is no node labeled src or dest in the graph; 
	 * 		there is no path from src to dest. 
	 * 
	 */
	public static int minDistance(Graph graph, String src, String dest) {
		if (graph == null || src == null || dest == null ||
				!graph.containsElement(src) || !graph.containsElement(dest)) {
			return -1;
		}

		return new BreadthFirstSearch(graph).bfsDistance(graph.getNode(src), dest);
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		/* IMPLEMENT THIS METHOD! */
		
		return null; // this line is here only so this code will compile if you don't modify it
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it
	}
	
}
