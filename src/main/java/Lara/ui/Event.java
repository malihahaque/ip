/**
 * The Event class represents a task that occurs at a specific time.
 * It is a subclass of Task and includes a date/time field.
 *
 * Example: "Team meeting /at Monday 2pm"
 *
 * @author Maliha Haque
 * @version 1.0
 */
package Lara.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Event extends Task {

    protected LocalDateTime start;
    protected LocalDateTime end;


    public Event(String description, String start, String end) {
        super(description);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        this.start = LocalDateTime.parse(start, formatter);;
        this.end = LocalDateTime.parse(end, formatter);
    }

    @Override
    public String toString() {
        DateTimeFormatter console = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mma");
        return "[E]" + super.toString() + " (from: " + start.format(console) + " to: " + end.format(console) + ")";

    }

    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + start + " | " + end;

    }
}

