package hyperGraphs;

import java.util.ArrayList;
import java.util.List;

public class HyperRelation extends RelationHE {
	
	// Incidence  matrics -  Macierz  incydencji
	private ArrayList<Node> incidents = new ArrayList<Node>(); 
	

	public HyperRelation(ObjectHE parent, Node source, Node target,
			String relKind) {
		incidents.add(source);
		incidents.add(target);
		this.setParentEdge(parent);
		this.setAttribute(HLH.KIND, relKind);

		source.addRelation(this);
		target.addRelation(this);
		parent.addChildElement(this);
	}

	public void addNodeToRelation(Node newNode) {
		incidents.add(newNode);

		newNode.addRelation(this);
	}

	void remove() {
		getParentEdge().removeRelation(this);
		incidents.clear();
	}

	public Node getFirstNode() {
		return incidents.get(0);
	}

	public Node getSecondNode() {
		return incidents.get(1);
	}

	public List<Node> getIncidentNodes() {
		return incidents;
	}

	/**
	 * check if this hyper rel contains in its connected node a node from both
	 * of given floors
	 * 
	 * @param floor1
	 * @param floor2
	 * @return
	 */
	public boolean containsNodeFromFloor(int floor) {
		for (Node node : incidents) {
			if (node.getFloor() == floor) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isLinkingNodes(Node node1, Node node2) {

		return (incidents.contains(node1) && incidents.contains(node2));

	}
}