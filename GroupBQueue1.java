import java.util.Scanner;

class Call {
    String customerID;
    int callTime;

    public Call(String customerID, int callTime) {
        this.customerID = customerID;
        this.callTime = callTime;
    }
    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Call Time: " + callTime + " mins";
    }
}
class CallQueue {
    private final int MAX = 100;
    private Call[] queue = new Call[MAX];
    private int front = 0, rear = -1 ,count=0;

    public void addCall(String customerID, int callTime) {
        if (rear == MAX - 1) {
            System.out.println(" Queue is full. Cannot add more calls.");
            return;
        }
        Call call = new Call(customerID, callTime);
        rear=(rear+1)%MAX;
        queue[rear] = call;
        count++;
        System.out.println("Call from " + customerID + " added to the queue.");
    }

    public void answerCall() {
        if (isQueueEmpty()) {
            System.out.println("No calls in the queue to answer.");
            return;
        }

        Call answered = queue[front];
        System.out.println("Answered call from " + answered.customerID +
                " (" + answered.callTime + " mins).");

        front=(front+1%MAX);
        count--;
    }

    // View all calls
    public void viewQueue() {
        if (isQueueEmpty()) {
            System.out.println("📭 The call queue is empty.");
            return;
        }

        System.out.println("\n Current Calls in Queue:");
        for (int i = front; i <= rear; i++) {
            System.out.println(" - " + queue[i]);
        }
    }

    // Check if queue is empty
    public boolean isQueueEmpty() {
        return front == -1;
    }
}



        class GroupBQueueDemo1
        {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                CallQueue callQueue = new CallQueue();

                int choice;
                do {
                    System.out.println("\n--- Call Center Queue Menu ---");
                    System.out.println("1. Add Call");
                    System.out.println("2. Answer Call");
                    System.out.println("3. View Queue");
                    System.out.println("4. Check if Queue is Empty");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    choice = sc.nextInt();
                    sc.nextLine(); // consume newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter Customer ID: ");
                            String id = sc.nextLine();
                            System.out.print("Enter Call Time (in minutes): ");
                            int time = sc.nextInt();
                            callQueue.addCall(id, time);
                            break;

                        case 2:
                            callQueue.answerCall();
                            break;

                        case 3:
                            callQueue.viewQueue();
                            break;

                        case 4:
                            if (callQueue.isQueueEmpty())
                                System.out.println(" The queue is empty.");
                            else
                                System.out.println("⏳ The queue is not empty.");
                            break;

                        case 5:
                            System.out.println("Exiting Call Center System.");
                            break;

                        default:
                            System.out.println(" Invalid choice! Please try again.");
                    }
                } while (choice != 5);

                sc.close();
            }
        }

