import java .util.Arrays;
import java .util.Scanner;
    class LinearProbing1 {
        private int[] table;
        private int size;

        public LinearProbing1(int size) {
            this.size = size;
            this.table = new int[size];
            Arrays.fill(table, -1);
        }

        public int hashkey(int key) {
            return key % size;
        }

        public void insert(int key) {
            int index = hashkey(key);
            if (table[index] == -1) {
                table[index] = key;
            } else {
                int start = index;
                do {
                    index = (index + 1) % size;
                } while (table[index] != -1 && start != index);
                if (table[index] == -1) {
                    table[index] = key;
                    return;
                }
            }
            System.out.println("There is no space for key" + key);

        }

        public boolean search(int key) {
            int index = hashkey(key);
            int start = index;
            while (table[index] != -1) {
                if (table[index] == key) {
                    System.out.println("The key " + key + "is found");
                    return true;
                }
                index = (index + 1) % size;
                if (start == index) {
                    break;
                }
            }

            System.out.println("the key " + key + "is not found");
            return false;
        }

        public boolean delete(int key) {
            int index = hashkey(key);
            int start = index;
            while (table[index] != -1) {
                if (table[index] == key) {
                    table[index] = -1;
                    System.out.println("The key" + key + "is delete from the table");
                    return true;

                }
                index = (index + 1) % size;
                if (start == index) {
                    break;
                }
            }

            System.out.println("the key " + key + "is not found for deletion");
            return false;
        }

        public void display() {
            System.out.println("index \t key \t comparision");
            for (int i = 0; i < size; i++) {
                if (table[i] != -1) {
                    System.out.println(i + "\t" + table[i]);
                } else {
                    System.out.println(i + "\t empty");
                }
            }
        }
    }
    public class GroupCLinearProbing
    {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the size of the table");
            int size=sc.nextInt();
            LinearProbing1 l1=new LinearProbing1(size);
            boolean running =true;
            while(running)
            {
                System.out.println("\n 1.Insert");
                System.out.println(" 2.Search");
                System.out.println(" 3.Delete");
                System.out.println(" 4.Display");
                System.out.println(" 5.Exit");
                System.out.println("Enter your choice");
                int choice=sc.nextInt();
                switch (choice)
                {
                    case 1:
                    System.out.println("insert the key");
                    int key=sc.nextInt();
                    l1.insert(key);
                    break;
                    case 2:
                        System.out.println("Enter the key to search");
                        int s=sc.nextInt();
                        l1.search(s);
                        break;
                    case 3:
                        System.out.println("Enter the key to delete");
                        int d=sc.nextInt();
                        l1.delete(d);
                        break;
                    case 4:
                        l1.display();
                        break;
                    case 5:
                        running=false;
                        System.out.println("Exiting....");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }

            }

        }


}
