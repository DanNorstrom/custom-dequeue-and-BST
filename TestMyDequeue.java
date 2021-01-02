
public class TestMyDequeue {

	public static void main(String[] args) throws Exception {
		System.out.println("1. Creating new Empty MyDequeue"+"\n");
		MyDequeue<String> que = new MyDequeue<>();
		
		System.out.println("2. Testing illigal left(), right(), removeLeft() and removeRight() on Empty MyDequeue:");
		try {que.left();}
		catch (
				MyDequeueException e) {e.printStackTrace();
				Thread.sleep(1);}
		try {que.right();}
		catch (
				MyDequeueException e) {e.printStackTrace();
				Thread.sleep(1);}
		try {que.removeLeft();}
		catch (
				MyDequeueException e) {e.printStackTrace();
				Thread.sleep(1);}
		try {que.removeRight();}
		catch (
				MyDequeueException e) {e.printStackTrace();
				Thread.sleep(1);}
		
		System.out.println("\n3. Adding Left: Lovely");
		que.addLeft("Lovely");
		System.out.println("Queue contents: "+que+"\n");
		
		System.out.println("4. Adding right: Weather");
		que.addRight("Weather");
		System.out.println("Queue contents: "+que+"\n");
		
		System.out.println("5. Adding right: We've");
		que.addRight("We've");
		System.out.println("Queue contents: "+que+"\n");
		
		System.out.println("6. Adding right: Been");
		que.addRight("Been");
		System.out.println("Queue contents: "+que+"\n");
		
		System.out.println("7. Adding right: Blessed!");
		que.addRight("Blessed!");
		System.out.println("Queue contents: "+que+"\n");
		
		System.out.println("8. Removing left.");
		que.removeLeft();
		System.out.println("Queue contents: "+que+"\n");
		
		System.out.println("9. Removing right.");
		que.removeRight();
		System.out.println("Queue contents: "+que+"\n");
		
		System.out.println("10. Returning left.");
		System.out.println(que.left()+"\n");
		
		System.out.println("11. Returning right.");
		System.out.println(que.right()+"\n");	
		
		System.out.println("12. Checking empty array.");
		System.out.println(que.isEmpty()+"\n");
		
		System.out.println("13. Emptying and Checking empty array.");
		que.removeRight();
		System.out.println("Queue contents: "+que);
		que.removeRight();
		System.out.println("Queue contents: "+que);
		que.removeRight();
		System.out.println("Queue contents: "+que);
		System.out.println(que.isEmpty()+"\n");
	}
}
