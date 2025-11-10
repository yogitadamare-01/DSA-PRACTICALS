import java.sql.SQLOutput;

class Node1 {
    int rollno;
    int marks;
    String name;
    Node1 next;

    Node1(int rollno, String name, int marks) {
        this.rollno = rollno;
        this.marks = marks;
        this.name = name;
        this.next = null;
    }
}

class LinkedList1 {
    Node1 head;

    public void insert(int rollno, String name, int marks) {
        Node1 n1 = new Node1(rollno, name, marks);
        if (head == null) {
            head = n1;
            return;
        }
        Node1 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n1;
    }

    public void search(int key) {
           Node1 temp = head;
        int flag = 0;
        while (temp != null) {
            if (temp.rollno == key) {
                flag = 1;
            }
            temp=temp.next;
        }
        if (flag == 0) {
            System.out.println("The" + key + "roll no is not found");
        } else {
            System.out.println("The" + key + "roll no is  found");
        }
    }

    public void sort() {
        if(head==null)
        {
            return;
        }
        Node1 i, j;
        for (i = head; i.next != null; i = i.next) {
            for (j = head; j.next != null; j = j.next) {
                if (j.rollno > j.next.rollno) {
                    int temprollno = j.rollno;
                    String tempname = j.name;
                    int tempmarks = j.marks;

                    j.rollno = j.next.rollno;
                    j.name = j.next.name;
                    j.marks = j.next.marks;

                    j.next.rollno = temprollno;
                    j.next.name = tempname;
                    j.next.marks = tempmarks;


                }
            }
        }
    }
    public void delete(int val)
    {
        if(head==null)
        {
            System.out.println("There is no student record is present");
            return;
        }
        if(head.rollno==val)
        {
            System.out.println("Deleting the node having roll no"+val);
            head=head.next;
            return;
        }
        Node1 temp=head;
        Node1 prev=null;
        while(temp!=null && temp.rollno!=val)
        {
            prev=temp;
            temp=temp.next;
        }
        if(temp==null)
        {
            System.out.println("the roll no is not present in linkedlist");
            return;
        }
        System.out.println("the node is deleting with roll no"+val);
        prev.next=temp.next;

    }

    public void display() {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.rollno + ":" + temp.name + ":" + temp.marks + "->");
            temp = temp.next;
        }
        System.out.print("Null");

    }


}

public class GroupBLinkedList {
    public static void main(String[] args) {

        LinkedList1 l1 = new LinkedList1();
        l1.insert(3, "ram", 89);
        l1.insert(5, "Sham", 79);
        l1.insert(4, "sam", 35);
        l1.insert(6, "naksh", 67);
        l1.insert(10, "Yash", 88);
        System.out.println("\n Before Sorting");
        l1.display();
        l1.sort();
        System.out.println("\n after sorting");
        l1.display();
        l1.search(5);
        l1.delete(6);
        l1.display();
    }


}
