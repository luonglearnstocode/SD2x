


public class Edge {
	private final Node source;
	private final Node destination;
	
	public Edge(Node source, Node destination) {
		this.source = source;
		this.destination = destination;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Edge)) {
			return false;
		}
		Edge otherEdge = (Edge) obj;
		Node otherSource = otherEdge.getSource();
		Node otherDest = otherEdge.getDestination();

		return (otherSource.equals(source)
			 && otherDest.equals(destination));
	}
	
	@Override
	public int hashCode() {
		return source.hashCode() + destination.hashCode();
	}
	
	public Node getSource() {
		return source;
	}
	
	public Node getDestination() {
		return destination;
	}
	

}
