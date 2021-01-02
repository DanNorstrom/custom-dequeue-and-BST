// base recursive structure
class Qnode<T> {
	T data;
	Qnode<T> next;

	public Qnode(T o, Qnode<T> n){
		this.data = o;
		this.next = n;

	}
}

// Class Exception
class MyDequeueException extends RuntimeException {
	public MyDequeueException(String s) {
		super(s);
	}
}

public class MyDequeue<T> {

	// left and right is start and end of list
	// we're using left as Head and right as tail as to not confuse with methods left() and right()
	private Qnode<T> head, tail;

	public MyDequeue() {
		this.head = this.tail = null;
	}
	
	public boolean isEmpty() {
		if (head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public T left() { // access data at start
		if (head == null) {
			throw new MyDequeueException("Nullpointer, empty MyDequeue");
		}
		else {
			return this.head.data;
		}
	}
	
	public T right() { // access data at end
		if (head == null) {
			throw new MyDequeueException("Nullpointer, empty MyDequeue");
		}
		else {
			return this.tail.data;
		}
	}

	public void addLeft(T x) { // add data to start
		this.head  = new Qnode<T>(x, head);
		if (tail == null) {
			this.tail = this.head;
		}
	}
	
	public void addRight(T x) { // add data to end
		if (head == null) {
			this.head = this.tail = new Qnode<T>(x, null); // first add is both first and last item
		}
		else {
			this.tail.next = new Qnode<T>(x, null);
			tail = tail.next;
		}
	}
	
	public void removeLeft() {
		if (head == null) {
			throw new MyDequeueException("Nullpointer, empty MyDequeue");
		}
		else {
			this.head = head.next;
		}
	}
	
	public void removeRight() {
		if (head == null) { // if empty MyDequeue
			throw new MyDequeueException("Nullpointer, empty MyDequeue");
		}
		else { // if last element set null
			Qnode<T> q = head;
			if (q.next == null) {
				this.tail = this.head = null;
			}
			else { // otherwise set tail to second last value
			    while (q.next.next != null) {
			    	 q = q.next;
			     }
			     q.next = null;
			     this.tail = q;
				}
		    }
	}
	
	public String toString() {
		if (head == null) { // empty MyDequeue
			//throw new MyDequeueException("Nullpointer, empty MyDequeue");
			return "< >";
		}
		else {
			String out = "<";
			Qnode<T> q = head;
			out += q.data+", ";
		    while (q.next != null) {
		    	q = q.next;
		    	out += q.data+", ";
		     }
		    out = out.substring(0,out.length()-2);
		    out += ">";
		    return out;
		}
	}
}
