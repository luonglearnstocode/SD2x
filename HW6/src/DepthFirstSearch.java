

import java.util.HashSet;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Depth First Search (DFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class DepthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	
	public DepthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}
	
	public boolean dfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
			return false;
		}	
	
		if (start.getElement().equals(elementToFind)) {
			return true;
		} else {
			marked.add(start);
			for (Node neighbor : graph.getNodeNeighbors(start)) {
				if (!marked.contains(neighbor) && 
				    dfs(neighbor, elementToFind))
	             return true;
			}
			return false;
		}
	}
	

}
