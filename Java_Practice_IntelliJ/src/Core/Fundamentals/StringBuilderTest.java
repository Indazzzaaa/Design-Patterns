package Core.Fundamentals;

public class StringBuilderTest {
    public static void show(){
//        StringBuilder in Java is a mutable sequence of characters, and it's often used when you need to perform a series of operations
//        (create, read, update, delete) on a string without creating a new object each time

        // Create a StringBuilder
        StringBuilder stringBuilder = new StringBuilder("Hello");

        // Append: Concatenate at the end
        stringBuilder.append(" World");
        stringBuilder.append(10);
        stringBuilder.append(true);
        stringBuilder.append(42.19);

        // Print the current state
        System.out.println("After Append: " + stringBuilder);

        // Insert: Insert at a specific position
        stringBuilder.insert(5, " Java");

        // Print the current state
        System.out.println("After Insert: " + stringBuilder);

        // Update (Replace): Replace characters
        stringBuilder.replace(0, 5, "Greetings");

        // Print the current state
        System.out.println("After Replace: " + stringBuilder);

        // Delete: Remove characters
        stringBuilder.delete(8, 13);

        // Print the current state
        System.out.println("After Delete: " + stringBuilder);
        System.out.println(stringBuilder.indexOf("Greetinga"));
        System.out.println(stringBuilder.capacity());

//        All these operations are performed on the same StringBuilder instance, and each operation modifies the content in place. This is in contrast to the immutable String class, where each operation creates a new String object.
//        The mutability of StringBuilder makes it more efficient for scenarios involving frequent modifications to the content




    }
}
