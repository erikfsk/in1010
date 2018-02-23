class Node {
	public Node neste;
	public int value;

	public Node(int i){
		value = i;
	}

	public int hentData(){
		return value;
	}

	public Node hentNeste(){
		return neste;
	}

	public void settNeste(Node neste_Node){
		neste = neste_Node;
	}
}


class Tester{
	public static void main(String[] args) {
		Node node_ = new Node(10);
		node_.value = 10;
		Node node_2 = new Node(11);
		node_.settNeste(node_2);
		System.out.println(node_.hentData());
		Node node_3 = new Node(12);
		node_2.settNeste(node_3);
	}
}