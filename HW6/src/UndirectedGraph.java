


public class UndirectedGraph extends Graph {
	
	public UndirectedGraph() {
		super();
	}
	
	@Override
	public boolean addEdge(Node node1, Node node2) {
		addNode(node1); // only adds if node not already in graph.
		addNode(node2);
		boolean addEdgeSuccess = (
           addEdgeFromTo(node1, node2)
        && addEdgeFromTo(node2, node1));
		if (addEdgeSuccess) {
			numEdges++;
		}
		return addEdgeSuccess;	
	}

	@Override
	public boolean removeEdge(Node node1, Node node2) {
		if (!containsNode(node1) || !containsNode(node2)) {
			return false;
		}
		boolean removeEdgeSuccess = (
           removeEdgeFromTo(node1, node2)
        && removeEdgeFromTo(node2, node1));
		if (removeEdgeSuccess) {
			numEdges--;
		}
		return removeEdgeSuccess;	
	}
	

}
