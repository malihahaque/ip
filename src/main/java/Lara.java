import java.util.Scanner;
import java.util.ArrayList;

public class Lara {
    private static final ArrayList<Task> list = new ArrayList<>();
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! I'm Lara");
        System.out.println("What can I do for you?");

        while(true) {
            String message = scanner.nextLine();
            String firstWord= message.split(" ")[0];

            if (message.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (message.equals("list")) {
                printList();
            } else if (firstWord.equals("mark")) {
                markTask(message);
            } else if (firstWord.equals("unmark")) {
                unmarkTask(message);
            } else {
                addTask(message);
            }
        }
    }

    private static void printList() {
        for (int i=1; i<=list.size(); i++) {
            System.out.println(i+ ". " + list.get(i-1));
        }
    }

    private static void addTask(String description) {
        Task task = new Task(description);
        list.add(task);
        System.out.println("added: " + description);
    }

    private static void markTask(String command) {
        int taskNumber = Integer.parseInt(command.split(" ")[1]) - 1;
        list.get(taskNumber).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("[X] " + list.get(taskNumber).getDescription());
    }

    private static void unmarkTask(String command) {
        int taskNumber = Integer.parseInt(command.split(" ")[1]) - 1;
        list.get(taskNumber).markAsUndone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println("[ ] " + list.get(taskNumber).getDescription());
    }
}




