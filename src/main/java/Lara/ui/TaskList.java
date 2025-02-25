package Lara.ui;

import Lara.exception.LaraException;
import Lara.parser.Date;
import Lara.storage.Storage;
import java.util.Comparator;
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

    public String addTask(String command) throws LaraException {
        String[] words = command.split(" ", 2);
        if (words.length < 2) {
            throw new LaraException("Please describe the task you want to add!");
        }

        String type = words[0];
        String details = words[1];

        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(details)) {
                throw new LaraException("Duplicate task detected! This task already exists.");
            }
        }

        Task newTask;

        if (type.equals("todo")) {
            newTask = new Todo(details);
        } else if (type.equals("deadline")) {
            String[] by = details.split(" /by ", 2);
            if (!Date.isValidDateTime(by[0])) {
                throw new LaraException("Invalid deadline format! Please specify a deadline with /by, the date and time format has to be DD/MM/YYYY HHMM");
            }
            newTask = new Deadline(by[0], by[1]);
        } else {
            String[] parts = details.split(" /from | /to ", 3);
            if (!Date.isValidDateTime(parts[0]) || !Date.isValidDateTime(parts[2])) {
                throw new LaraException("Invalid event format! Please specify an event with /from and /to, the date and time format has to be DD/MM/YYYY HHMM");
            }
            newTask = new Event(parts[0], parts[1], parts[2]);
        }

        tasks.add(newTask);
        return "Got it. I've added this task:\n" + newTask +
                "\nNow you have " + tasks.size() + " task" + (tasks.size() == 1 ? "" : "s") + " in the list.";
    }

    public String deleteTask(String indexStr) throws LaraException {
        try {
            int index = Integer.parseInt(indexStr) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new LaraException("Please input a valid task number!");
            }
            Task removedTask = tasks.remove(index);
            return "Noted. I've removed this task:\n" + removedTask +
                    "\nNow you have " + tasks.size() + " task" + (tasks.size() == 1 ? "" : "s") + " in the list.";
        } catch (NumberFormatException e) {
            throw new LaraException("Please input a valid task number!");
        }
    }

    public String markTask(String indexStr) throws LaraException {
        try {
            int index = Integer.parseInt(indexStr) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new LaraException("Please input a valid task number!");
            }
            tasks.get(index).markAsDone();
            return "Well done! I've marked this task as done:\n" + tasks.get(index);
        } catch (NumberFormatException e) {
            throw new LaraException("Please input a valid task number!");
        }
    }

    public String unmarkTask(String indexStr) throws LaraException {
        try {
            int index = Integer.parseInt(indexStr) - 1;
            if (index < 0 || index >= tasks.size()) {
                throw new LaraException("Please input a valid task number!");
            }
            tasks.get(index).markAsUndone();
            return "OK, I've marked this task as not done yet:\n" + tasks.get(index);

        } catch (NumberFormatException e) {
            throw new LaraException("Please input a valid task number!");
        }
    }

    public String getTaskList(TaskList tasks) {
        if (tasks.getTasks().isEmpty()) {
            return "Your task list is empty.";
        }
        StringBuilder response = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.getTasks().size(); i++) {
            response.append(i + 1).append(". ").append(tasks.getTasks().get(i)).append("\n");
        }
        return response.toString();
    }

    public String findTasks(TaskList tasks, String keyword) {
        StringBuilder response = new StringBuilder("Here are the matching tasks:\n");
        int count = 1;
        for (Task task : tasks.getTasks()) {
            if (task.getDescription().contains(keyword)) {
                response.append(count).append(". ").append(task).append("\n");
                count++;
            }
        }
        if (count == 1) {
            response.append("No matching tasks found.");
        }
        return response.toString();
    }

    public String sortTasks() {
        tasks.sort(Comparator.comparing(Task::getComparableDate, Comparator.nullsLast(Comparator.naturalOrder())));
        return "Your task list has been sorted by deadline or start time.";
    }

}



