import java. util.Scanner;
public class GroupASort {

    public void bubbleSort(int a[]) {
        int temp;
        for (int i = 0; i < a.length; i++) {
            for (int k = i + 1; k < a.length; k++) {
                if (a[i] > a[k]) {
                    temp = a[i];
                    a[i] = a[k];
                    a[k] = temp;
                }
            }
        }
    }
        public void selectionSort(int a[]) {
            int tempa;
            for (int i = 0; i < a.length - 1; i++) {
                int min = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[min] > a[j]) {
                        min = j;
                    }
                }
                if (min != i) {
                    tempa = a[min];
                    a[min] = a[i];
                    a[i] = tempa;
                }
            }
        }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[]=new int[10];
        System.out.println("Enter the Salaries of the employee");
        for(int i=0;i<a.length;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("Your entered the Salaries of the employee");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
        GroupASort s1=new GroupASort();
        s1.bubbleSort(a);
        System.out.println(" the Salaries of the employee after bubble sort");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
        s1.selectionSort(a);
        System.out.println(" the Salaries of the employee after selection sort");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
        System.out.println("The top five salaries are");
        for(int i=a.length-1;i>=a.length-5;i--)
        {
            System.out.println(a[i]);
        }





    }
}
