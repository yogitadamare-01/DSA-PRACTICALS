import java .util.LinkedList;
import java .util.*;
public class GroupCChaining {
    private class HashNode1
    {
        int key;
        String value;
        HashNode1 next;
        public HashNode1(int key,String value)
        {
            this.value=value;
            this.key=key;
            this .next=null;
        }
    }
    private LinkedList<HashNode1>[] buckets;
    private int capacity;
    public GroupCChaining(int capacity)
    {
        this.capacity=capacity;
        buckets= new LinkedList[capacity];
        for(int i=0;i<capacity;i++)
        {
            buckets[i]=new LinkedList<>();
        }
    }
    public int hashFunction(int key)
    {
        return key%capacity;
    }
    public void insert(int key, String value) {
        int index = hashFunction(key);
        for (HashNode1 node : buckets[index]) {
            if (node.key == key) {
                node.value = value;
            }
        }
        buckets[index].add(new HashNode1(key, value));
    }
        public String search(int key)
        {
            int index = hashFunction(key);
            for (HashNode1 node : buckets[index]) {
                if (node.key == key) {

                    return node.value;
                }
        }
        return null;
    }
    public void delete(int key)
    {
        int index = hashFunction(key);
        Iterator <HashNode1>it=buckets[index].iterator();
        while(it.hasNext())
        {
            HashNode1 node=it.next();
            if(node.key==key)
            {
                it.remove();
                return;
            }
        }

    }
    public void display()
    {
        for(int i=0;i<capacity;i++)
        {
            System.out.print("Bucket"+i+":");
            for(HashNode1 node:buckets[i])
            {
                System.out.print("["+node.key+":"+node.value+"]"+"->");

            }
            System.out.println("Null");
        }
        }



    public static void main(String[] args) {
        GroupCChaining g1= new GroupCChaining(10);
        g1.insert(7,"banana");
        g1.insert(2,"mango");
        g1.insert(3,"cheery");
        g1.insert(12,"guava");
        g1.insert(5,"fig");
        System.out.println("Hash Table");
        g1.display();
        System.out.println("Search key 3"+g1.search(3));
        g1.delete(2);
        System.out.println("After deleting key 2 ");
        g1.display();



    }
}
