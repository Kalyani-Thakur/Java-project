import java.util.ArrayList;
import java.util.Scanner;

public class To_Do_List {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n=== To-Do-List Menu ===");
            System.out.println("1. View Tasks");
            System.out.println("2. Add Tasks");
            System.out.println("3. Delete Tasks");
            System.out.println("4. Exit");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if(tasks.isEmpty()){
                        System.out.println("No tasks yet.");
                    }
                    else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". "+tasks.get(i));
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter task: ");
                    String task = sc.nextLine();
                    tasks.add(task);
                    System.out.println("Task added.");
                    break;
                case 3:
                    if(tasks.isEmpty()){
                        System.out.println("No task to delete");
                    }
                    else {
                        for(int i=0; i<tasks.size(); i++){
                            System.out.println((i + 1) + ". "+tasks.get(i));
                        }
                        System.out.print("Enter task number: ");
                        int index = sc.nextInt();
                        sc.nextLine();

                        if(index > 0 && index <= tasks.size()){
                            String removed = tasks.remove(index-1);
                            System.out.println("Deleted: "+removed);
                        }
                        else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("GoodBye!");
                    break;
                default:
                System.out.println("Invalid option");
                    break;
            }
        }
        while (choice != 4);
            sc.close();
        
    }
}

