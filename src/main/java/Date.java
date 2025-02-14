public class Date {
    public static Task Date(String input) {
        if (input.startsWith("deadline")) {
            String[] parts = input.split(" /by ");
            String description = parts[0].substring(9).trim();
            String dateTime = parts[1].trim();
            return new Deadline(description, dateTime);
        } else if (input.startsWith("event")) {
            String[] parts = input.split(" /from | /to ");
            String description = parts[0].substring(6).trim();
            String fromDateTime = parts[1].trim();
            String toDateTime = parts[2].trim();
            return new Event(description, fromDateTime, toDateTime);
        }
        return null;
    }
}

