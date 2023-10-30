import java.util.LinkedList;
import java.util.List;

public class BlockingQueue{

    private List<Integer> queue = new LinkedList<>();

    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }
//producer adding operation

    public synchronized void enqueue(int data) throws InterruptedException {
        while(this.queue.size() == this.limit) {
            wait();
        }
        if(this.queue.size() == 0) {
            notifyAll();
        }
        this.queue.add(data);
    }
//consumer deleting operation

    public synchronized Integer dequeue()
            throws InterruptedException
    {
        while (this.queue.size() == 0) {
            wait();
        }
        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }




    public static void main(String[] args) throws InterruptedException {

        BlockingQueue bqueue = new BlockingQueue(5);

        Thread producer = new Thread(()->{
            try {
                for(int i=1;i<=20;i++) {
                    //queue.add(i);
                    bqueue.enqueue(i);
                    System.out.println("Produced: "+i);
                    Thread.sleep(500);
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(()->{
            try {
                for(int i=1;i<=20;i++) {
                    //int value = queue.remove();
                    int value = bqueue.dequeue();
                    System.out.println("Consumed: "+value);
                    Thread.sleep(1000);
                }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();


    }

}