package Core.Oops.Other;

import java.util.Objects;
import java.util.UUID;

public class Student {
    private String name;
    private int age;

    private final UUID uuid;

    public Student(String name, int age){
        setName(name);
        setAge(age);
        uuid = UUID.randomUUID();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        if(age<0)
            throw new  IllegalArgumentException("Age can't be negative");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object obj) {
       if(this==obj) return true;

//       if(this == null || getClass() != obj.getClass()) return false;
       if(!(obj instanceof Student )) return false;

       Student otherStudent = (Student) obj;

       return  name.compareTo(otherStudent.name)==0 && age== otherStudent.age;

    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    @Override
    public String toString() {

        return String.format("Student (Name : %s, age: %d, UUID : %s)",name,age,uuid);

    }

}
