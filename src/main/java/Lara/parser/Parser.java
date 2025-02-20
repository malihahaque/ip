/**
 * The Parser class is responsible for interpreting user input commands
 * and converting them into executable program actions.
 *
 * Methods include:
 * - handleCommand(String, TaskList, Ui, Storage) : Processes input and returns the appropriate command.
 * @author Maliha Haque
 * @version 1.0
 */

package Lara.parser;

import Lara.ui.Task;
import Lara.storage.Storage;
import Lara.ui.TaskList;
import Lara.ui.Ui;
import Lara.exception.LaraException;

public class Parser {
    public String handleCommandAndReturn(String command, TaskList tasks, Ui ui, Storage storage) throws LaraException {
        StringBuilder response = new StringBuilder();

        try {
            String[] words = command.split(" ", 2);
            String action = words[0];

            switch (action) {
                case "hello":
                    return "How can I help you?";
                case "bye":
                    return "Goodbye! Have a great day!";
                case "list":
                    return tasks.getTaskList(tasks);
                case "mark":
                    String ans = tasks.markTask(words[1]);
                    storage.save(tasks.getTasks());
                    return ans;
                case "unmark":
                    String notDone= tasks.unmarkTask(words[1]);
                    storage.save(tasks.getTasks());
                    return notDone;
                case "delete":
                    String delete = tasks.deleteTask(words[1]);
                    storage.save(tasks.getTasks());
                    return delete;
                case "todo":
                case "deadline":
                case "event":
                    String answer= tasks.addTask(command);
                    storage.save(tasks.getTasks());
                    return answer;
                case "find":
                    if (words.length < 2) {
                        throw new LaraException("Please provide a keyword to search for:");
                    }
                    return tasks.findTasks(tasks, words[1].trim());
                default:
                    throw new LaraException("I do not understand what you mean! Please try again!");
            }
        } catch (LaraException e) {
            return "Error: " + e.getMessage();
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Error: Invalid command format!";
        }
    }

}



