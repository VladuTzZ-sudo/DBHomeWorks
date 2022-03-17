package DeutscheBank.Day3.Linked;

public class Lista {
    private Node start;

    public Lista() {

    }

    public void printList() {
        for (Node node = start; node != null; node = node.getNext()) {
            System.out.println(node);
        }
    }

    public void add(int val) {
        /*Node node = new Node(val);
        node.setNext(start);
        start = node;*/
        Node aux = new Node(val);

        if (start == null) {
            start = aux;
        } else {
            for (Node node = start; node != null; node = node.getNext()) {
                if (node.getNext() == null) {
                    node.setNext(aux);
                }
            }
        }
    }

    public int size() {
        int n = 0;

        for (Node node = start; node != null; node = node.getNext()) {
            n++;
        }
        return n;
    }

    public void addAtPosition(int val, int position) {
        if (position > size()) {
            return;
        }

        int i = 0;
        for (Node node = start; node != null; node = node.getNext()) {
            if (i + 1 == position) {
                Node next = node.next;
                Node nou = new Node(val);
                nou.setNext(next);
                node.setNext(nou);
                break;
            }
            i++;
        }
    }

    public void inspectPosition(int position) {
        if (position > size()) {
            return;
        }

        int i = 0;
        for (Node node = start; node != null; node = node.getNext()) {
            if (i == position) {
                System.out.println(node);
            }
            i++;
        }
    }

    public void removePosition(int position) {
        if (position > size()) {
            return;
        }

        int i = 0;
        for (Node node = start; node != null; node = node.getNext()) {
            if (i + 1 == position) {
                node = node.getNext().getNext();
                break;
            }
            i++;
        }
    }

    public void setAtPosition(int val, int position) {
        int i = 0;
        for (Node node = start; node != null; node = node.getNext()) {
            if (i == position) {
                node.setVal(val);
            }
            i++;
        }
    }

    private class Node {
        private int val;
        private Node next = null;

        public Node(int val) {
            this.val = val;
            next = null;
        }

        public Node() {
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
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

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getStart() {
        return start;
    }
}
