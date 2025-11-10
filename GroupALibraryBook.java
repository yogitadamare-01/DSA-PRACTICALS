import java.util.Scanner;
public class GroupALibraryBook {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter number of members: ");
            int numMembers = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter number of books: ");
            int numBooks = sc.nextInt();
            sc.nextLine();

            String[] members = new String[numMembers];
            String[] books = new String[numBooks];
            int[][] borrowCounts = new int[numMembers][numBooks];


            for (int i = 0; i < numMembers; i++) {
                System.out.print("Enter name of member " + (i + 1) + ": ");
                members[i] = sc.nextLine();
            }


            for (int j = 0; j < numBooks; j++) {
                System.out.print("Enter name of book " + (j + 1) + ": ");
                books[j] = sc.nextLine();
            }


            System.out.println("Enter borrow counts for each member and book:");
            for (int i = 0; i < numMembers; i++) {
                for (int j = 0; j < numBooks; j++) {
                    System.out.print("How many times " + members[i] + " borrowed " + books[j] + "? ");
                    borrowCounts[i][j] = sc.nextInt();
                }
            }


            int totalBorrows = 0;
            for (int i = 0; i < numMembers; i++) {
                for (int j = 0; j < numBooks; j++) {
                    totalBorrows += borrowCounts[i][j];
                }
            }
            double average = (double) totalBorrows / (numMembers * numBooks);
            System.out.printf("Average number of books borrowed: %.2f\n", average);


            int[] totalPerBook = new int[numBooks];
            for (int j = 0; j < numBooks; j++) {
                for (int i = 0; i < numMembers; i++) {
                    totalPerBook[j] += borrowCounts[i][j];
                }
            }

            int highestIndex = 0, lowestIndex = 0;
            for (int j = 1; j < numBooks; j++) {
                if (totalPerBook[j] > totalPerBook[highestIndex]) highestIndex = j;
                if (totalPerBook[j] < totalPerBook[lowestIndex]) lowestIndex = j;
            }
            System.out.println("Book with highest borrowings: " + books[highestIndex]);
            System.out.println("Book with lowest borrowings: " + books[lowestIndex]);


            int noBorrowCount = 0;
            for (int i = 0; i < numMembers; i++) {
                int sum = 0;
                for (int j = 0; j < numBooks; j++) {
                    sum += borrowCounts[i][j];
                }
                if (sum == 0) noBorrowCount++;
            }
            System.out.println("Number of members with no borrows: " + noBorrowCount);


            int maxBorrow = totalPerBook[0];
            for (int j = 1; j < numBooks; j++) {
                if (totalPerBook[j] > maxBorrow) maxBorrow = totalPerBook[j];
            }

            System.out.print("Most frequently borrowed book(s): ");
            for (int j = 0; j < numBooks; j++) {
                if (totalPerBook[j] == maxBorrow) System.out.print(books[j] + " ");
            }
            System.out.println();
        }
    }


