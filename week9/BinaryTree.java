class Test{
    public static void main(String[] args) {
        BinaryTree testTre = new BinaryTree(10);
        testTre.settInn(7);
        testTre.settInn(17);
        testTre.settInn(5);
        testTre.settInn(15);
        testTre.settInn(8);
        testTre.settInn(18);
        testTre.skrivUt();//skriv ut alle verdiene, i synkende rekkefølge
        // System.out.println(fakultet(0));
        // System.out.println(fakultet(1));
        // System.out.println(fakultet(2));
        // System.out.println(fakultet(3));
        // System.out.println(fakultet(4));
        // System.out.println(fakultet(10));
    }

    public static int fakultet(int i){
        if (i < 0){
            return 0;
        }
        if (i == 0) {
            return 1;
        } return fakultet(i-1)*i;
    }
}

class BinaryTree{
    private Node head;

    BinaryTree(int input){
        head = new Node(input);
    }
    private class Node{
        Node right;
        Node left;
        int value;

        Node(int input){
            this.value = input;
        }
    }

    public boolean settInn(int input){
         return settInn(head,input);
    }

    public boolean settInn(Node currentNode,int input){
        if (currentNode.value > input) {
            if (currentNode.left != null){
                return settInn(currentNode.left,input);
            }
            currentNode.left = new Node(input);
            return true;
        } else if (currentNode.value < input){
            if (currentNode.right != null) {
                return settInn(currentNode.right,input);
            }
            currentNode.right = new Node(input);
            return true;
        } return false;
    }

    public void skrivUt(){
        skrivUt(head);
    }

    public void skrivUt(Node currentNode){
        if (currentNode.right != null){
            skrivUt(currentNode.right);
        }System.out.println(currentNode.value);
        if (currentNode.left != null){
            skrivUt(currentNode.left);
        }
    }
}


// if (currentNode.right != null){
//     System.out.println(currentNode.value);
// }System.out.println(currentNode.value);
// if (currentNode.left != null){
//     skrivUt(currentNode.left);
// }
