public class Date {
    public static Task Date(String input) {
        String[] parts = input.split(" /by ");
        String description = parts[0].substring(9).trim();
        String date = parts[1].trim();

        return new Deadline(description, date);
    }
}

