import java.util.Scanner;


public class Lara {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! I'm Lara");
        System.out.println("What can I do for you?");

        while(true) {
            String message = scanner.nextLine();
            if (message.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else {
                System.out.println(message);
            }
        }
    }
}
