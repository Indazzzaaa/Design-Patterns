public class User {

    private String name;
    private int age;

     User(String name,int age){
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return  String.format("{ Name: %s , Age: %d }",this.name,this.age);
    }
}
