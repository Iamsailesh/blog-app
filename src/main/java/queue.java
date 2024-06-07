
 class queue1 {
	int[] queue= new int[5];
	int size;
	int rear;
	int front;
	
	public void enQueue(int data) {
		queue[rear]=data;
		rear++;
		size++;
	}
	
	public void deQueue() {
		front=front+1;
		size--;
		
	}
	
	public void show() {
		for(int i=0; i<=size-1; i++) {
			System.out.println(queue[front+i]);
		}
	}

}

public class queue{
	public static void main(String[] args) {
		queue1 q= new queue1();
		q.enQueue(5);
		q.enQueue(4);
		q.enQueue(7);
		q.deQueue();
		q.show();
		
	}
}
