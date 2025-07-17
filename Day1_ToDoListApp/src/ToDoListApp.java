package Day1_ToDoListApp.src;

import java.util.ArrayList;
import java.util.Scanner;

class Task{
    String name;
    boolean isDone;

    Task(String name){
        this.name = name;
        this.isDone = false;
    }

    void markDone(){
        isDone = true;
    }

    @Override
    public String toString() {
         return (isDone ? "[✔] " : "[ ] ") + name;
    }
}

public class ToDoListApp {
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int choice;
        do{
            System.out.println("\n--- ToDo List ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice(1 to 4):");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskDone();
                case 4 -> deleteTask();
                case 5 -> System.out.println("Thank you!");
                default -> System.out.println("Invalid choice...!");
            }
        } while( choice !=0);
}

static void addTask() {
    System.out.print("Enter task name: ");
    String name = sc.nextLine();
    tasks.add(new Task(name));
    System.out.println("Task added.");
}

static void viewTasks(){
    System.out.print("\nYour Tasks:");
    if(tasks.isEmpty())
        System.out.println("No tasks added.");
    else{
        for(int i=0; i < tasks.size(); i++){
            System.out.println((i + 1) +". " + tasks.get(i));
        }
    }
}

static void markTaskDone(){
    viewTasks();
    System.out.print("Enter task number to mark as done.");
    int index = sc.nextInt() - 1;
    if(index >= 0 && index < tasks.size()){
        tasks.get(index).markDone();
        System.out.println("Task marked as done.");
    } else
       System.out.println("Invalid task number.");
}

static void deleteTask() {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int index = sc.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else
            System.out.println("Invalid task number.");
        
    }
}