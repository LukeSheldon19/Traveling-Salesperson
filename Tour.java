public class Tour {

    public class Node {
        private Point p;
        private Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public Tour() {
        head = null;
        size = 0;
    }

    public Tour(Point a, Point b, Point c, Point d) {
        size = 4;

        head = new Node();
        head.p = a;
        Node b_node = new Node();
        b_node.p = b;
        Node c_node = new Node();
        c_node.p = c;
        Node d_node = new Node();
        d_node.p = d;

        head.next = b_node;
        b_node.next = c_node;
        c_node.next = d_node;
        d_node.next = head;
    }

    public int size() {

        int c = 0;

        if (size == 0) {
            return c;
        }
        Node current = head;
        do {
            c++;
            current = current.next;
        } while (current != head);

        return c;
    }

    public double length() {
        double ret = 0.0;

        if (size == 0) {
            return ret;
        }

        Node current = head;
        do {
            ret += current.p.distanceTo(current.next.p);
            current = current.next;
        } while (current != head);

        return ret;
    }

    public String toString() {


        String output = "";

        if (head == null) {
            return output;
        }

        Node current = head;
        do {
            output += current.p + "\n";
            current = current.next;
        } while (current != head);

        return output;
    }

    public void draw() {

        if (head == null) {
            return;
        }

        Node current = head;
        do {
            current.p.drawTo(current.next.p);
            current = current.next;
        } while (current != head);
    }

    public void insertNearest(Point p) {

        Node newNode = new Node();
        newNode.p = p;

        if (head == null) {
            head = newNode;
            head.next = head;
            size = 1;
            return;
        }

        if (head.next == head) {
            head.next = newNode;
            newNode.next = head;
            size = 2;
            return;
        }

        Node ref = head;
        Node current = head;

        do {
            if (current.p.distanceTo(p) < ref.p.distanceTo(p)) {
                ref = current;
            }
            current = current.next;
        } while (current != head);

        Node ref_neb = ref.next;

        ref.next = newNode;

        newNode.next = ref_neb;

        size++;

    }


    public void insertSmallest(Point p) {

        Node newNode = new Node();
        newNode.p = p;

        if (head == null) {
            head = newNode;
            head.next = head;
            size = 1;
            return;
        }

        if (head.next == head) {
            Node secondNode = new Node();
            secondNode.p = p;
            head.next = secondNode;
            secondNode.next = head;
            size = 2;
            return;
        }

        Node ref = head;
        Node current = head;

        double d3 = head.p.distanceTo(p) + p.distanceTo(head.next.p);
        double d2 = head.p.distanceTo(head.next.p);

        double delta_ref = d3 - d2;

        do {
            double d33 = current.p.distanceTo(p) + p.distanceTo(current.next.p);
            double d22 = current.p.distanceTo(current.next.p);

            double deltadelta = d33 - d22;

            if (deltadelta < delta_ref) {
                delta_ref = deltadelta;
                ref = current;
            }

            current = current.next;

        } while (current != head);

        Node ref_neb = ref.next;

        ref.next = newNode;

        newNode.next = ref_neb;

        size++;

    }

    public static void main(String[] args) {

        // define 4 points as corners of a square
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);

        // create the tour a -> b -> c -> d -> a
        Tour squareTour = new Tour(a, b, c, d);

        //Tour squareTour = new Tour(a, b, c);

        int size = squareTour.size();
        StdOut.println("# of points = " + size);

        double length = squareTour.length();
        StdOut.println("Tour length = " + length);

        StdOut.println(squareTour);

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);

        Point e = new Point(5.0, 6.0);
        squareTour.insertNearest(e);

        //Point e = new Point(5.0, 6.0);
        //squareTour.insertSmallest(e);
        squareTour.draw();

        int size2 = squareTour.size();
        StdOut.println("# of points = " + size2);

        double length2 = squareTour.length();
        StdOut.println("Tour length = " + length2);

    }
}
