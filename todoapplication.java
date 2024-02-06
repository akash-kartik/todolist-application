import java.util.Scanner;

class ToDoList {
    private static final int MAX_TASKS = 100;
    private String[] tasks;
    private boolean[] completed;
    private int taskCount;

    public ToDoList() {
        tasks = new String[MAX_TASKS];
        completed = new boolean[MAX_TASKS];
        taskCount = 0;
    }

    public void addTask(String description) {
        if (taskCount < MAX_TASKS) {
            tasks[taskCount] = description;
            completed[taskCount] = false;
            taskCount++;
            System.out.println("Task added: " + description);
        } else {
            System.out.println("Task limit reached. Cannot add more tasks.");
        }
    }

    public void markAsCompleted(int index) {
        if (index >= 0 && index < taskCount) {
            completed[index] = true;
            System.out.println("Task marked as completed: " + tasks[index]);
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void displayTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < taskCount; i++) {
                String status = completed[i] ? "[X]" : "[ ]";
                System.out.println(i + ". " + status + " " + tasks[i]);
            }
        }
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task index to mark as completed: ");
                    int index = scanner.nextInt();
                    toDoList.markAsCompleted(index);
                    break;
                case 3:
                    toDoList.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
