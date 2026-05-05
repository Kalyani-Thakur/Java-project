package CarShowroom;

import java.util.Scanner;

interface Utility {
    public void getDetails();

    public void setDetails();

}

public class Main {

    public static void mainMenu() {
        System.out.println("\n___________ WELCOME TO CAR SHOWROOM MANAGEMENT SYSTEM ______________");
        System.out.println("|                                                                  |");
        System.out.println("|     1].ADDSHOWROOM\t   2].ADDEMPLOYEE\t 3].ADDCAR         |");          
        System.out.println("|                                                                  |");
        System.out.println("|     4].GETSHOWROOM\t   5].GETEMPLOYEE\t 6].GETCAR         |");
        System.out.println("|                                                                  |");
        System.out.println("|________________________ ENTER 0 FOR EXIT ________________________|");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ShowRoom[] showroom = new ShowRoom[5];
        Employee[] employee = new Employee[5];
        Car[] car = new Car[5];

        int showroom_counter = 0;
        int employee_counter = 0;
        int car_counter = 0;

        int choice = 100;
        while (choice != 0) {
            mainMenu();
            System.out.print("\nENTER CHOICE ");
            choice = sc.nextInt();

            while (choice != 9 && choice != 0) {
                switch (choice) {
                    case 1:
                        showroom[showroom_counter] = new ShowRoom();
                        showroom[showroom_counter].setDetails();
                        showroom_counter++;
                        System.out.println();
                        System.out.println("\n1] ADD MORE SHOWROOM");
                        System.out.println("9] GO BACK TO MENU");
                        choice = sc.nextInt();
                        break;

                    case 2:
                        employee[employee_counter] = new Employee();
                        employee[employee_counter].setDetails();
                        employee_counter++;
                        System.out.println("\n2] ADD MORE EMPLOYEE");
                        System.out.println("9] GO BACK TO MENU");
                        choice = sc.nextInt();
                        break;

                    case 3:
                        car[car_counter] = new Car();
                        car[car_counter].setDetails();
                        car_counter++;
                        System.out.println("\n3] ADD MORE CARS");
                        System.out.println("9] GO BACK TO MENU");
                        choice = sc.nextInt();
                        break;

                    case 4:
                        for (int i = 0; i < showroom_counter; i++) {
                            showroom[i].getDetails();
                            System.out.println("\n");
                        }
                        System.out.println("\n9] GO BACK TO MENU");
                        System.out.println("0] EXIT");
                        choice = sc.nextInt();
                        break;

                    case 5:
                        for (int i = 0; i < employee_counter; i++) {
                            employee[i].getDetails();
                            System.out.println("\n");
                        }
                        System.out.println("\n9] GO BACK TO MENU");
                        System.out.println("0] EXIT");
                        choice = sc.nextInt();
                        break;

                    case 6:
                        for (int i = 0; i < car_counter; i++) {
                            car[i].getDetails();
                            System.out.println("\n");
                        }
                        System.out.println("\n9] GO BACK TO MENU");
                        System.out.println("0] EXIT");
                        choice = sc.nextInt();
                        break;

                    default:
                        System.out.println("Enter Valid choice");
                        break;
                }
            }

        }

    }

}
