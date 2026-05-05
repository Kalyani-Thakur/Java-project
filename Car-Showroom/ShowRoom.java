package CarShowroom;

import java.util.Scanner;

public class ShowRoom implements Utility {
    String sName;
    String address;
    String managerName;
    int total_no_of_Cars=0;
    int Total_Employee;

    @Override
    public void getDetails() {
        System.out.println("SHOWROOM NAME    : "+sName);
        System.out.println("SHOWROOM ADDRESS : "+address);
        System.out.println("SHOWROOM MANAGER NAME     : "+managerName);
        System.out.println("SHOWROOM Total_No_Of_Cars : "+total_no_of_Cars);
        System.out.println("SHOWROOM Total_Employee   : "+Total_Employee);
    }
    
    @Override
    public void setDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n++++++++++++ ENTER SHOWROOM DETAILS ++++++++++++\n");
        System.out.print("Name   : ");
        sName = sc.nextLine();
        System.out.print("Enter Address   : ");
        address = sc.nextLine();
        System.out.print("Manager Name    : ");
        managerName = sc.nextLine();
        System.out.print("Total no of Cars: ");
        total_no_of_Cars = sc.nextInt();
        System.out.print("No of Employee  : ");
        Total_Employee = sc.nextInt();
    }


}
