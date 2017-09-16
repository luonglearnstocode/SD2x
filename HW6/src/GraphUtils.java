

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
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
	
	/*
	 * Given a Graph, this method returns a Set of the values of all nodes within the specified distance
	 * (in terms of number of edges) of the node labeled src, i.e. for which the minimum number of edges 
	 * from src to that node is less than or equal to the specified distance. 
	 *  
	 * The value of the node itself should not be in the Set, even if there is an edge from the node to itself. 
	 *  
	 * The method should return null for any invalid inputs, including: 
	 *  	null values for the Graph or src; 
	 *  	there is no node labeled src in the graph; 
	 *  	distance less than 1. 
	 *  
	 * However, if distance is greater than or equal to 1 
	 * and there are no nodes within that distance (meaning: src is the only node in the graph), 
	 * the method should return an empty Set.
	 */
	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		if (graph == null || src == null ||
				!graph.containsElement(src) || 
				distance < 1) {
			return null;
		}
		
		Set<String> result = new HashSet<String>();
		
		if (graph.getNumNodes() == 1) {
			return result;
		}
		
		/*
		 * traverse using BFS 
		 * instead of searching for an element, 
		 * we check if the distance is still within distance
		 */
		
		Map<Node, Integer> distances = new HashMap<>();				
		Queue<Node> toExplore = new LinkedList<>();
		Set<Node> marked = new HashSet<>();
		
		marked.add(graph.getNode(src));		
		toExplore.add(graph.getNode(src));
		distances.put(graph.getNode(src), 0);

		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					distances.put(neighbor, distances.get(current) + 1);
					if (distances.get(neighbor) <= distance) { // check distance from 'src'
						result.add(neighbor.getElement());
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
				
		return result;
	}

	/*
	 * Given a Graph, this method indicates whether the List of node values represents a Hamiltonian Path. 
	 * A Hamiltonian Path is a valid path through the graph in which every node in the graph is visited exactly once, 
	 * except for the start and end nodes, which are the same, so that it is a cycle. 
	 * 
	 * If the values in the input List represent a Hamiltonian Path, the method should return true, 
	 * but the method should return false otherwise, e.g. if the path is not a cycle, 
	 * 		if some nodes are not visited, 
	 * 		if some nodes are visited more than once, 
	 * 		if some values do not have corresponding nodes in the graph, 
	 * 		if the input is not a valid path (i.e., there is a sequence of nodes in the List that are not connected by an edge), etc. 
	 * 
	 * The method should also return false if the input Graph or List is null.
	 */
	public static boolean isHamiltonianPath(Graph g, List<String> values) {
		if (g == null || values == null || values.isEmpty()) {
			return false;
		}
		
		String src = values.get(0);
		Set<String> marked = new HashSet<>();
		marked.add(src);
		
		if (!src.equals(values.get(values.size() - 1))) // not a cycle - start and end should be the same
			return false;
		
		for (int i = 1; i < values.size(); i++) {
			if (!g.containsElement(values.get(i)))  // not a node
				return false;
			
			if (marked.contains(values.get(i)) // already visited
					&& i != (values.size() - 1))  // except for the last node
				return false;
			
			if (!g.getNodeNeighbors(g.getNode(values.get(i-1))).contains(g.getNode(values.get(i)))) { // not connected
				return false;
			}
			marked.add(values.get(i));
		}
				
		
		return marked.size() == g.getNumNodes(); 
	}
	
}
