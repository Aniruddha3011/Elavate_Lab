import  java.util.*;

public class task1ElavateLab {

    public double Addition(double a, double b) {
        return a + b;
    }

    public double Subtraction(double a, double b) {
        return a - b;
    }

    public double Multiplication(double a, double b) {
        return a * b;
    }

    public double Division(double a, double b) {
            if (b == 0) {
                System.out.println("Cant Divide by Zero");
                return 0;
            }
       return a/b;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count;
        task1ElavateLab obj = new task1ElavateLab();

        do{
            System.out.println("1.Addition");
            System.out.println("2.Subtraction");
            System.out.println("3.Multiplication");
            System.out.println("4.Division");
            System.out.println("5.Exit");
            System.out.print("Enter your choice:");
            count = sc.nextInt();

            switch(count){
                case 1:
                    System.out.print("Enter a First Number:");
                    double a = sc.nextDouble();
                    System.out.print("Enter a Second Number:");
                    double b = sc.nextDouble();
                    System.out.println("Addition is: " + obj.Addition(a, b)+"\n");
                    break;
                case 2:
                    System.out.print("Enter a First Number:");     
                    a = sc.nextDouble();
                    System.out.print("Enter a Second Number:");
                    b = sc.nextDouble();
                    System.out.println("Subtraction is: " + obj.Subtraction(a, b)+"\n");
                    break;

                case 3:
                    System.out.print("Enter a First Number:");
                    a = sc.nextDouble();
                    System.out.print("Enter a Second Number:");
                    b = sc.nextDouble();
                    System.out.println("Multiplication is: " + obj.Multiplication(a, b)+"\n");
                    break;

                case 4:
                    System.out.print("Enter a First Number:");
                    a = sc.nextDouble();
                    System.out.print("Enter a Second Number:");
                    b = sc.nextDouble();
                    System.out.println("Division is: " + obj.Division(a, b)+"\n");
                    break;

                case 5:
                    System.out.println("Thank you");
                    break;

            }

        }while(count != 0);


    }
}
