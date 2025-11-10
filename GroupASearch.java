import java.util.Scanner;
public class GroupASearch {
    static void bubbleSort(int a[])
    {
        int temp;
        for(int k=0;k<a.length;k++)
        {
            for(int i=k+1;i<a.length;i++)
            {
                if(a[k]>a[i])
                {
                    temp=a[k];
                    a[k]=a[i];
                    a[i]=temp;
                }
            }
        }
    }
    static int binarySearch(int a[],int left,int right,int key)
    {
        int mid=0;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(a[mid]==key)
            {
                return mid;
            }
            else if(a[mid]>key)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        int a[]=new int[5];
        System.out.println("Enter the account IDs");
        for(int i=0;i<a.length;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("Your entred customer IDs are");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
        bubbleSort(a);
        System.out.println("Sorted customer IDs are");
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }
        int n=a.length;
        System.out.println("Enter the customerId which have to find");
        int key=sc.nextInt();
      int  result= binarySearch(a,0,n-1,key);
        if(result==-1)

        {
            System.out.println("The"+key+"Is not found in list");
        }
        else
        {
            System.out.println("The"+key+"Is found in list");
        }
        //Linear Search
        int flag=0;
        int val=111;
        for(int i=0;i<a.length;i++)
        {
           if(a[i]==val)
           {
               flag=1;
            }
        }
        if(flag==0)
        {
            System.out.println("The"+key+"Is not found in list");
        }
        else
            System.out.println("The"+key+"Is  found in list");



    }

}
