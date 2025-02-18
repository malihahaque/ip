/**
 * The Parser class is responsible for interpreting user input commands
 * and converting them into executable program actions.
 *
 * Methods include:
 * - handleCommand(String, TaskList, Ui, Storage) : Processes input and returns the appropriate command.
 *
 * @author Maliha Haque
 * @version 1.0
 */

package Lara.parser;

import Lara.storage.Storage;
import Lara.ui.TaskList;
import Lara.ui.Ui;
import Lara.exception.LaraException;
public class Parser {
    public void handleCommand(String command, TaskList tasks, Ui ui, Storage storage) {
        try {
            String[] words = command.split(" ", 2);
            String action = words[0];

            switch (action) {
                case "bye":
                    ui.farewellMessage();
                    System.exit(0);
                    break;
                case "list":
                    tasks.printList();
                    break;
                case "mark":
                    tasks.markTask(words[1]);
                    storage.save(tasks.getTasks());
                    break;
                case "unmark":
                    tasks.unmarkTask(words[1]);
                    storage.save(tasks.getTasks());
                    break;
                case "delete":
                    tasks.deleteTask(words[1]);
                    storage.save(tasks.getTasks());
                    break;
                case "todo":
                case "deadline":
                case "event":
                    tasks.addTask(command);
                    storage.save(tasks.getTasks());
                    break;
                default:
                    throw new LaraException("I do not understand what you mean! Please try again!");
            }
        } catch (LaraException e) {
            ui.errorMessage(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            ui.errorMessage("Invalid command format!");
        }
    }
}



