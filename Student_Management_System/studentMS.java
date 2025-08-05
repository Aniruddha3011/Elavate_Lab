
import java.util.*;

public class studentMS {   
    
     ArrayList<student> obj = new ArrayList<>();

    public void addStudent() {
        System.out.println("Enter Student Name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter Student ID:");
        int Id=sc.nextInt();
        System.out.println("Enter Student Marks");
        double marks = sc.nextDouble();

        student newStudent = new student(name, Id, marks);
        obj.add(newStudent);
        System.out.println("Student Added Successfully");
    } 

    public void display() {
        if (obj.isEmpty()) {
            System.out.println("No students found");
            return;
        }
        for (student s : obj) {
            System.out.println("Name: " + s.getName() + "\nID: " + s.getid() + "\nMarks: " + s.getMarks());
        }
    }

    public void deleteStudent() {
        Scanner ic = new Scanner(System.in);
        System.out.println("Enter Student ID to delete:");
        int ID = ic.nextInt();

        for (student s : obj) {
            if (s.getid() == ID) {
                obj.remove(s);
                System.out.println("Student deleted successfully");
                return;
            }
        }
        System.out.println("Student with ID " + ID + " no found");
    }

    
    public void updateStudent() {
        Scanner ic = new Scanner(System.in);
        System.out.println("Enter Student ID to update:");
        int ID = ic.nextInt();

        for (student s : obj) {
            if (s.getid() == ID) {
                System.out.println("Enter new name:");
                String newName = ic.next();
                System.out.println("Enter new marks:");
                double newMarks = ic.nextDouble();
                
        
                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("Student updated successfully");
                return;
            }
        }
        System.out.println("Student with ID " + ID + " not found.");
    }
    public static void main(String[] args){
       Scanner oc = new Scanner(System.in);
       int choice;
       studentMS sm = new studentMS();
       do{
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = oc.nextInt();

            switch (choice) {
                case 1:
                    sm.addStudent();
                    break;
                case 2:
                    sm.display();
                    break;
                case 3:
                    sm.deleteStudent();
                    break;
                case 4:
                    sm.updateStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);
       }


    
}
