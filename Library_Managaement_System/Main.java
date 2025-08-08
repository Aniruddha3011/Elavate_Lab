import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show Books");
            System.out.println("2. Add Book");
            System.out.println("3. Add User");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    String uid = sc.nextLine();
                    library.addUser(new User(uname, uid));
                    break;
                case 4:
                    System.out.print("Enter ISBN of book to issue: ");
                    String issueIsbn = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    String issueUid = sc.nextLine();
                    library.issueBook(issueIsbn, issueUid);
                    break;
                case 5:
                    System.out.print("Enter ISBN of book to return: ");
                    String returnIsbn = sc.nextLine();
                    library.returnBook(returnIsbn);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
