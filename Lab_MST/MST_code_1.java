// Q1
package z_random;
import java.util.ArrayList;

class EmptyListException extends Exception {
    public EmptyListException() {
        System.out.println("List empty");
    }
}
public class MST_code_1 {
    public ArrayList<String> names = new ArrayList<>();

    public void addStudent(String name) {
        names.add(name);
    }
    public void removeStudent(String n) throws EmptyListException {
        if (names.isEmpty()) {
            throw new EmptyListException();
        }
        names.remove(n);
    }

    public static void main(String[] args) {
        MST_code_1 obj = new MST_code_1();

        try {
            obj.addStudent("A");
            obj.addStudent("B");
            System.out.println(obj.names);

            obj.removeStudent("A");
            System.out.println(obj.names);

            obj.removeStudent("B");
            obj.removeStudent("C");

            System.out.println(obj.names);

        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
}

