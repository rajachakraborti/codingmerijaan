package backtracking;

public class LinkedListReverse {

    public static void main(String[] args) {
        LinkedListReverse llr =  new LinkedListReverse();
        Node head = llr.create(8, null);
        System.out.println(head);

        head = llr.reverseSubList(head, 1, 2);
        System.out.println(head);
    }

    private Node reverseSubList(Node<Integer> head, int start, int end) {
        Node<Integer> dummyHead = new Node<>(0);
        dummyHead.next = head;

        Node<Integer> subListHead = dummyHead;
        int k = 1;
        while(k++ < start)
            subListHead = subListHead.next;

        //Reverse Sublist
        Node<Integer> subListItr = subListHead.next;
        while(start++ < end) {
            Node<Integer> t = subListItr.next;
            subListItr.next = t.next;
            t.next = subListHead.next;
            subListHead.next =  t;
        }
        return dummyHead.next;
    }


    private Node<Integer> create(int noOfNodes, Node<Integer> head) {
        if(head == null) {
            head = new Node(noOfNodes--);
        }
        Node curr = head;
        while(noOfNodes > 0) {
            curr.next = new Node(noOfNodes--);
            curr = curr.next;

        }
        return head;
    }


    class Node<T> {
         final T val;
         Node next;

        public Node(T val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
