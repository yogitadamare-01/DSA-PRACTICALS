class Queue1
{
    int maxsize;
    int count;
    int front;
    int rear;
    String a[];
    Queue1(int size)
    {
        maxsize=size;
        count=0;
        front=0;
        rear=-1;
        a=new String[size];
    }
    public void enqueue(String val)
    {
        if(rear==maxsize-1)
        {
            System.out.println("The queue is full You can't add any event");
        }
        else {
            rear=(rear+1)%maxsize;
            a[rear]=val;
            count++;
        }
    }
    public void dequeue() {
        if (count == 0) {
            System.out.println("there is no event in the queue");
        } else {
            System.out.println("Removing the event" + a[front] + "that has been longest in queue");
            front = (front + 1) % maxsize;
            count--;
        }
    }
    public void display()
    {
        if(count==0) {
            System.out.println("There is no any pending event");
        }
        else
        {
            System.out.println("The pending events are");
            for(int i=0;i<count;i++)
            {
                int index=(front+i)%maxsize;
                System.out.println(a[index]);
            }
        }
    }

}

public class GroupBQueue {
    public static void main(String[] args) {
        Queue1 q1=new Queue1(5);
        q1.enqueue("Dancing");
        q1.enqueue("Singing");
        q1.enqueue("Art");
        q1.enqueue("Mimickry");
        q1.enqueue("Reading");
        q1.display();
        q1.dequeue();
        q1.dequeue();
        q1.dequeue();
        q1.display();
        q1.dequeue();
        q1.dequeue();
        q1.display();
    }

}
