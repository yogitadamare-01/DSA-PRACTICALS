import java.util.Scanner;
import java.util.*;
public class GroupDBFSDFS {
    static final int max=20;
    static char[]names=new char[max];
    static int[][]adjmatrix=new int[max][max];
    static int [][]adjlist=new int[max][max];
    static int[]degree=new int[max];
    static int n;
    static void addedges(int u,int v)
    {
        adjmatrix[u][v]=1;
        adjmatrix[v][u]=1;
        adjlist[u][degree[u]++]=v;
        adjlist[v][degree[v]++]=u;
    }
    static void displayadjmatrix()
    {
        System.out.println("Adjancency materix :");
        System.out.println();
        for(int i=0;i<n;i++)
        {
            System.out.print(names[i]+" ");
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(names[i]+"|");
            for (int j=0;j<n;j++)
            {
                System.out.print(adjmatrix[i][j]+"");
            }
            System.out.println();
        }
    }
    static void displayadjlist()
    {
        System.out.println("Adjancency lists are");
        for(int i=0;i<n;i++)
        {
            System.out.print(names[i]+"->");
            for(int j=0;j<degree[i];j++)
            {
                System.out.print(adjlist[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void bfs(int start)
    {
        boolean[]visited=new boolean[n];
        int []queue=new int[n];
        int front=0,rear=0;
        visited[start]=true;
        queue[rear++]=start;
        System.out.print("the BFS starting from"+names[start]);
        while(front<rear)
        {
            int u=queue[front++];
            System.out.print(names[u]+" ");
            for(int i=0;i<degree[u];i++)
            {
                int v=adjlist[u][i];
                if(!visited[v])
                {
                    visited[v]=true;
                    queue[rear++]=v;
                }
            }
            System.out.println();

        }
    }
    public  static void  dfs(int start,boolean[]visited)
    {
        visited[start]=true;
        System.out.print(names[start]+" ");
        for(int i=0;i<n;i++)
        {
            if(adjmatrix[start][i]==1 && !visited[i])
            {
                dfs(i,visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of vertices");
         n=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the names of vertex like(A,B,C,D..)");
        String []temp=sc.nextLine().split(" ");
        for(int i=0;i<n;i++)
        {
            names[i]=temp[i].charAt(0);
        }
        System.out.print("Enter the no. of edges");
        int e=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the names of edges like(AB,AC)");
        for(int i=0;i<e;i++)
        {
            String []edge=sc.nextLine().split(" ");
            char a=edge[0].charAt(0);
            char b=edge[1].charAt(0);
            int u=-1,v=-1;
            for(int j=0;j<n;j++)
            {
             if(names[j]==a)
             {
                 u=j;
             }
             if(names[j]==b)
             {
                 v=j;
             }
            }
            addedges(u,v);
        }
       displayadjlist();;
        displayadjmatrix();
        System.out.print("enter the statring vertex for traversal:");
        char startchar=sc.next().charAt(0);
        int start=-1;
        for(int i=0;i<n;i++)
        {
            if(names[i]==startchar)
            {
                start=i;
            }
        }
        bfs(start);
        boolean[]visited=new boolean[n];
        System.out.print("Dfs starting from"+names[start]+":");
        dfs(start,visited);
        System.out.println();

    }
}
