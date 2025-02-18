/**
 * The Deadline class represents a task that has a specific due date/time.
 * It is a subclass of Task and includes a deadline field.
 *
 * Example: "Submit assignment /by Sunday"
 *
 * @author Maliha Haque
 * @version 1.0
 */

package Lara.ui;

import Lara.ui.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Deadline extends Task {

    protected LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.by = LocalDateTime.parse(by, formatter);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma")) + ")";

    }
    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;

    }
}
