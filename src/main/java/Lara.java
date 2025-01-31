import java.util.Scanner;
import java.util.ArrayList;

public class Lara {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Hello! I'm Lara");
        System.out.println("What can I do for you?");

        while(true) {
            String message = scanner.nextLine();
            if (message.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (message.equals("list")) {
                for (int i=1; i<=list.size(); i++) {
                    System.out.println(i+ ". " + list.get(i-1));
                }
            } else {
                list.add(message);
                    System.out.println("added: " + message);
            }
        }

    }
}
