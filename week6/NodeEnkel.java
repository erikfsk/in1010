class Test{
	public static void main(String[] args) {
		NodeEnkel<Integer> start = new NodeEnkel<Integer>(0);

		// FILO
		System.out.println(start.neste);
		for(int i = 1;i<5;i++){
			NodeEnkel<Integer> node_new = new NodeEnkel<Integer>(i);
			node_new.neste = start;
			start = node_new;
		}
		System.out.println(start.innhold);


		start = new NodeEnkel<Integer>(0);
		System.out.println(start.neste);
		NodeEnkel<Integer> current = start;

		for(int i = 1;i<5;i++){
			NodeEnkel<Integer> node_new = new NodeEnkel<Integer>(1);
			while (true){
				if (current.neste == null){
					current.neste = node_new;
					break;
				} else 	{
					current = current.neste;
				}
				
			}
		}
		System.out.println(start.innhold);
	}
}




class NodeEnkel <T>{
	public NodeEnkel<T> neste;
	public T innhold;
	public NodeEnkel(T input){
		innhold = input;
	}
}

