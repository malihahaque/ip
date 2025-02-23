# **Lara Chatbot - User Guide**

Lara is a **task management chatbot** that helps you track your daily tasks, deadlines, and events. This guide will help you set up and use Lara effectively.

---

## **🚀 Getting Started**

### **Installation**
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/malihahaque/Lara-Chatbot.git

🚀 Features
1️⃣ Task Management
Lara allows users to efficiently add, delete, update, and view tasks.

➤ Add a To-Do Task
Adds a new item to your to-do list.

Command Format:
nginx
Copy
Edit
todo DESCRIPTION
Example:
nginx
Copy
Edit
todo Buy groceries
Expected Output:
css
Copy
Edit
Buy groceries is added to your list.
[T][] Buy groceries
Now you have 1 task in your list.
➤ Add a Deadline Task
Adds a task with a specific deadline.

Command Format:
bash
Copy
Edit
deadline DESCRIPTION /by DATE_TIME
Example:
kotlin
Copy
Edit
deadline return books /by 2024-09-23 23:59
Expected Output:
vbnet
Copy
Edit
Return books is added to your list.
[D][] Return books (by: Sept 23 2024 11:59 pm)
Now you have 2 tasks in your list.
➤ Add an Event Task
Schedules an event with a start and end time.

Command Format:
vbnet
Copy
Edit
event DESCRIPTION /from DATE_TIME /to DATE_TIME
Example:
vbnet
Copy
Edit
event team meeting /from 2024-09-30 14:00 /to 2024-09-30 16:00
Expected Output:
css
Copy
Edit
Team meeting is added to your list.
[E][] Team meeting (from: Sept 30 2024 02:00 pm to: Sept 30 2024 04:00 pm)
Now you have 3 tasks in your list.
➤ Delete a Task
Removes a task from your to-do list.

Command Format:
cpp
Copy
Edit
delete TASK_NUMBER
Example:
cpp
Copy
Edit
delete 2
➤ Mark a Task as Done
Marks a task as completed.

Command Format:
css
Copy
Edit
mark TASK_NUMBER
Example:
css
Copy
Edit
mark 5
➤ Mark a Task as Not Done
Unmarks a completed task.

Command Format:
nginx
Copy
Edit
unmark TASK_NUMBER
Example:
nginx
Copy
Edit
unmark 3
➤ View All Tasks
Displays all tasks in your list.

Command Format:
nginx
Copy
Edit
list
➤ Find a Task
Searches for a task by keyword.

Command Format:
arduino
Copy
Edit
find KEYWORD
Example:
arduino
Copy
Edit
find books

2️⃣ Sorting & Advanced Features
➤ Sort Tasks
Sorts all tasks chronologically.

Command Format:
bash
Copy
Edit
sort
➤ Change Storage File
Switch to a different storage file.

Command Format:
nginx
Copy
Edit
changeFile FILE_PATH
Example:
bash
Copy
Edit
changeFile data/new_tasks.txt

2️⃣ Sorting & Advanced Features
➤ Sort Tasks
Sorts all tasks chronologically.

Command Format:
bash
Copy
Edit
sort
➤ Change Storage File
Switch to a different storage file.

3️⃣ Help & Support
➤ Get Help
Displays a list of all commands.

Command Format:
bash
Copy
Edit
help
✅ You can now easily manage your tasks using Lara! 🚀
