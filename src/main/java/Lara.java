import java.util.Scanner;
import java.util.ArrayList;

public class Lara {
    private static final ArrayList<Task> list = new ArrayList<>();
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! I'm Lara");
        System.out.println("What can I do for you?");

        try {
            while (true) {
                String message = scanner.nextLine();
                String firstWord = message.split(" ")[0];

                if (message.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (message.equals("list")) {
                    printList();
                } else if (firstWord.equals("mark")) {
                    markTask(message);
                } else if (firstWord.equals("unmark")) {
                    unmarkTask(message);
                } else if (firstWord.equals("delete")) {
                  deleteTask(message);
                } else if (firstWord.equals("todo") || firstWord.equals("deadline") || firstWord.equals("event")){
                    addTask(message);
                } else {
                    throw new LaraException("I do not understand what you mean! Please try again!");
                }
            }
        } catch (LaraException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int i=1; i<=list.size(); i++) {
            System.out.println(i+ ". " + list.get(i-1));
        }
    }

    private static void addTask(String description) {
        try {
            String[] words= description.split(" ",2);
            if (words.length <2) {
                throw new LaraException("Please describe the task you want to add!");
            }
            String type = words[0];
            String date = words[1];
            System.out.println("Got it. I've added this task:");

            if (type.equals("todo")) {
                Task todo= new Todo(description);
                list.add(todo);
                System.out.println(todo);
            } else if (type.equals("deadline")) {
                String[] by= date.split(" /by ",2);
                Task deadline= new Deadline(by[0], by[1]);
                list.add(deadline);
                System.out.println(deadline);
            } else {
                String[] parts= date.split(" /from | /to ", 3);
                Task event = new Event(parts[0], parts[1], parts[2]);
                list.add(event);
                System.out.println(event);
            }
            System.out.println("Now you have " + list.size() + " tasks in the list.");
        } catch (LaraException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteTask(String command) {
        try {
            int taskNumber = Integer.parseInt(command.split(" ")[1]) - 1;
            if (taskNumber < 0 || taskNumber >  list.size()) {
                throw new LaraException("Please input a valid task number!");
            }
            Task removedTask = list.remove(taskNumber);
            System.out.println("Noted. I've removed this task:");
            System.out.println(removedTask);
            System.out.println("Now you have " + list.size() + " tasks in the list.");
        } catch (LaraException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void markTask(String command) {
        try {
            int taskNumber = Integer.parseInt(command.split(" ")[1]) - 1;
            if (taskNumber < 0 || taskNumber >  list.size()) {
                throw new LaraException("Please input a valid task number!");
            }
                list.get(taskNumber).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[X] " + list.get(taskNumber).getDescription());
            } catch (LaraException e) {
                System.out.println(e.getMessage());
            }
    }
    private static void unmarkTask(String command) {
        try {
            int taskNumber = Integer.parseInt(command.split(" ")[1]) - 1;
            if (taskNumber < 0 || taskNumber >  list.size()) {
                throw new LaraException("Please input a valid task number!");
            }
                list.get(taskNumber).markAsUndone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println("[ ] " + list.get(taskNumber).getDescription());
            } catch (LaraException e) {
            System.out.println(e.getMessage());
            }
    }
}




