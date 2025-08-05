

public class student {

   private String name;
   private int id;
   private double marks;

   student(String name, int id, double marks) {
       this.name = name;
       this.id = id;
       this.marks = marks;
   }
    public String getName() {
         return name;
    }
    public int getid() {
         return id;
    }
    public double getMarks() {
         return marks;
    }

    public void setName(String name) {
         this.name = name;
    }

    public void setid(int id) {
         this.id = id;
    }
    public void setMarks(double marks) {
         this.marks = marks;

    }
}
