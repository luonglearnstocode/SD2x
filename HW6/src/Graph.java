


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class Graph {
	protected Map<Node, Set<Edge>> adjacencySets;
	protected int numNodes;
	protected int numEdges;
	protected Map<String, Node> elementToNode;

	/*
	 * These methods need to be overridden by subclasses.
	 */
	public abstract boolean addEdge(Node node1, Node node2);
	public abstract boolean removeEdge(Node node1, Node node2);

	public Graph() {
		adjacencySets = new HashMap<Node, Set<Edge>>();
		elementToNode = new HashMap<String, Node>();
		numNodes = 0;
		numEdges = 0;
	}
	
	
	public boolean addNode(Node newNode) {
		if (newNode == null || containsNode(newNode)) {
			return false;
		}
		Set<Edge> newAdjacencySet = new HashSet<Edge>();
		adjacencySets.put(newNode, newAdjacencySet);
		elementToNode.put(newNode.getElement(), newNode);
		numNodes++;
		return true;
	}
	
	public Set<Node> getNodeNeighbors(Node node) {
		if (!containsNode(node)) {
			return null;
		}
		Set<Edge> nodeEdges = adjacencySets.get(node);
		Set<Node> nodeNeighbors= new HashSet<Node>();
		for (Edge e : nodeEdges) {
			Node neighbor = e.getDestination();
			nodeNeighbors.add(neighbor);
		}
		return nodeNeighbors;
	}
	
		
	protected boolean addEdgeFromTo(Node source,
			Node destination) {
		Edge newEdge = new Edge(source, destination);
		Set<Edge> sourceEdges = adjacencySets.get(source);
		if (!sourceEdges.contains(newEdge)) {
			sourceEdges.add(newEdge);
			return true;
		}
		return false;
	}
	
	protected boolean removeEdgeFromTo(Node source,
			Node destination) {
		Edge toRemove = new Edge(source, destination);
		Set<Edge> sourceEdges = adjacencySets.get(source);
		if (sourceEdges.contains(toRemove)) {
			sourceEdges.remove(toRemove);
			return true;
		}
		return false;
	}
	
	
	public int getNumNodes() {
		return numNodes;
	}
	
	public int getNumEdges() {
		return numEdges;
	}
	
	public Node getStartingNode() {
		Iterator<Node> iter = adjacencySets.keySet().iterator();
		if (iter.hasNext()) {
			return iter.next();
		}
		return null;
	}
	
	public Set<Node> getAllNodes() {
		return adjacencySets.keySet();
	}
	
	public Set<Edge> getNodeEdges(Node node) {
		if (!containsNode(node)) {
			return null;
		}
		return adjacencySets.get(node);
	}
	
	public boolean containsNode(Node node) {
		return adjacencySets.containsKey(node);
	}
	
	public Node getNode(String element) {
		
		if (!elementToNode.containsKey(element)) {
    		Node newNode = new Node(element);
    		elementToNode.put(element, newNode);
    		return newNode;
    	}
    	
		return elementToNode.get(element);
	}
	
	public boolean containsElement(String element) {
		return elementToNode.containsKey(element);
	}
}
