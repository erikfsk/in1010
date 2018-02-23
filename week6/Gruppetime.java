class Node1{
	public Node neste;
	public String value;
}

class Node2{
	private Node neste;
	private String value;

	public Node2(String i){
		value = i;
	}

	public String hentData(){
		return value;
	}

	public Node hentNeste(){
		return neste;
	}

	public void settNeste(Node neste_Node){
		neste = neste_Node;
	}
}

class Node <T>{
	private Node neste;
	private T value;

	public Node(T i){
		value = i;
	}

	public T hentData(){
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
		Node node_1 = new Node<Integer>(10);
		Node node_2 = new Node<Integer>(11);
		node_1.settNeste(node_2);
		Node node_3 = new Node<Integer>(12);
		node_2.settNeste(node_3);

		Node current = node_1;
		while(current != null){
			System.out.println(current.hentData());
			current = current.hentNeste();
		}
	}
}


interface Par <K,V> {
	public abstract K hentNokkel();
	public abstract V hentVerdi();
}



class OrdnetPar<K,V> implements Par<K,V>{
	private K nokkel;
	private V verdi;

	public OrdnetPar(K nokkel_,V verdi_){
		this.nokkel = nokkel_;
		this.verdi = verdi_;
	}

	public K hentNokkel(){
		return nokkel;
	}

	public V hentVerdi(){
		return verdi;
	}
}






















