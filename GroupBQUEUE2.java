import java.util.Scanner;
class  Call1
{
    String customerID;
    int calltime;
    public Call1(String customerID,int calltime)
    {
        this.customerID=customerID;
        this.calltime=calltime;
    }
    @Override
    public String toString()
    {
       return "CustomerID "+customerID+"callTime "+calltime+"mins";
    }
}
class customercall
{
   private  final int max=100;
    int front=0,rear=-1,count=0;
    Call1 []queue=new Call1[max];
    public void addcall(String customerid,int calltime)
    {
        if(rear==max-1)
        {
            System.out.println("The queue is full cannot add another phone call");
        }
        else {
            Call1 call = new Call1(customerid, calltime);
            rear=(rear+1)%max;
            queue[rear]=call;
            System.out.println("call from the " + customerid  + " is added to the queue");
            count++;
        }
    }
    public void answercall()
    {
        if(count==0)
        {
            System.out.println("there is a no call present in the queue");
            return;
        }
       Call1 ans=queue[front];
        System.out.println("the call is answered from"+ans.customerID+"of time"+ans.calltime);
        front=(front+1)%max;
        count--;
    }
    public void viewQueue()
    {
     if(count==0)
     {
         System.out.println("there is no call present in the queue");
         return;
     }
        System.out.println("current calls in the queue");
     for(int i=0;i<count;i++)
     {
         int index=(front+i)%max;
         System.out.println(queue[index]+" ");
     }
    }
    public boolean isQueueEmpty()
    {
        return count==0;
    }
}

public class GroupBQUEUE2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        customercall c1=new customercall();
        int choice;
        boolean running=true;
        while(running){
            System.out.println("Welcome to call center---");
            System.out.println("1.add the call");
            System.out.println("2.answer the call");
            System.out.println("3.view the queue");
            System.out.println("4.is queue is empty");
            System.out.println("5.exit");
            System.out.println("Enter your choice");
             choice=sc.nextInt();
             sc.nextLine();
              switch(choice)
              {
                  case 1:
                      System.out.println("Enter the customerID");
                      String id=sc.nextLine();
                      System.out.println("Enter the calltime");
                      int time=sc.nextInt();
                      c1.addcall(id,time);
                      break;
                  case 2:
                      c1.answercall();
                      break;
                  case 3:
                      c1.viewQueue();
                      break;
                  case 4:
                     if( c1.isQueueEmpty())
                     {
                         System.out.println("the queue is full");
                     }
                     else {
                         System.out.println("the queue is not full");
                     }
                      break;
                  case 5:
                      running=false;
                      System.out.println("Exiting...");
                      break;
                  default:
                      System.out.println("Invalid choice");
              }


        }
    }
}
