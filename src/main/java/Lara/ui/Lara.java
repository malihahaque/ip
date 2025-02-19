/**
 * Lara is the main entry point of the chatbot application.
 * It initializes the necessary components and runs the program.
 *
 * @author Maliha Haque
 * @version 1.0
 */

package Lara.ui;

import Lara.exception.LaraException;
import Lara.parser.Parser;
import Lara.storage.Storage;
import java.util.ArrayList;
import java.util.Scanner;

public class Lara {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    public Lara(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();

        try {
            ArrayList<Task> loadedTasks = storage.load();
            tasks = new TaskList(loadedTasks);
        } catch (LaraException e) {
            ui.errorMessage("Error loading tasks: " + e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.welcomeMessage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String command = scanner.nextLine().trim();
            parser.handleCommand(command, tasks, ui, storage);
        }
    }

    public static void main(String[] args) {
        new Lara("tasks.txt").run();
    }
}