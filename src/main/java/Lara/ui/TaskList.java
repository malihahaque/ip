package Lara.ui;

import Lara.exception.LaraException;
import Lara.ui.Deadline;
import Lara.ui.Event;
import Lara.ui.Task;
import Lara.ui.Todo;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void printList() {
        if (tasks.isEmpty()) {
            System.out.println("Your task list is empty.");
            return;
        }

        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void addTask(String command) throws LaraException {
        String[] words = command.split(" ", 2);
        if (words.length < 2) {
            throw new LaraException("Please describe the task you want to add!");
        }

        String type = words[0];
        String details = words[1];
        Task newTask;

        if (type.equals("todo")) {
            newTask = new Todo(details);
        } else if (type.equals("deadline")) {
            String[] by = details.split(" /by ", 2);
            if (by.length < 2) throw new LaraException("Please specify a deadline with /by");
            newTask = new Deadline(by[0], by[1]);
        } else {
            String[] parts = details.split(" /from | /to ", 3);
            if (parts.length < 3) throw new LaraException("Please specify an event with /from and /to");
            newTask = new Event(parts[0], parts[1], parts[2]);
        }

        tasks.add(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println(newTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void deleteTask(String indexStr) throws LaraException {
        try {
            int index = Integer.parseInt(indexStr) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new LaraException("Please input a valid task number!");
            }
            Task removedTask = tasks.remove(index);
            System.out.println("Noted. I've removed this task:");
            System.out.println(removedTask);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        } catch (NumberFormatException e) {
            throw new LaraException("Invalid task number.");
        }
    }

    public void markTask(String indexStr) throws LaraException {
        try {
            int index = Integer.parseInt(indexStr) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new LaraException("Please input a valid task number!");
            }
            tasks.get(index).markAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(tasks.get(index));
        } catch (NumberFormatException e) {
            throw new LaraException("Invalid task number.");
        }
    }

    public void unmarkTask(String indexStr) throws LaraException {
        try {
            int index = Integer.parseInt(indexStr) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new LaraException("Please input a valid task number!");
            }
            tasks.get(index).markAsUndone();
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println(tasks.get(index));
        } catch (NumberFormatException e) {
            throw new LaraException("Invalid task number.");
        }
    }

    public void findTasks(String keyword) {
        System.out.println("Here are the tasks with the word " + keyword + " in your list:");

        int count = 1;
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                System.out.println(count + "." + task);
                count++;
            }
        }

        if (count == 1) {
            System.out.println("Sorry! It seems like no matching tasks have been found. Please try again");
        }
    }

}



