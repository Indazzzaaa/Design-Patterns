package Core.Oops.Other;

public class OppsTest {
    public static void test(){
        Student student = new Student("Sumant",24);
        Student student1 = new Student("Sumant",24);
        Student student2 = new Student("Rahul",24);
        System.out.println(student);
        System.out.println(student2);
        System.out.println(student.equals(student2));
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
//        note: below method does not call hashcode instead it checks there memory address.
        System.out.println(student == student1);
        System.out.println(student.equals(null));
        System.out.println(student.getClass());
    }
}
