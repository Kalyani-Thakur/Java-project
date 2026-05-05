package CarShowroom;

import java.util.Scanner;

public class Employee extends ShowRoom implements Utility {
    String emp_Name;
    int emp_age;
    String emp_id;
    String emp_dep;

    @Override
    public void setDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n++++++++++++ ENTER EMPLOYEE DETAILS ++++++++++++\n");

        System.out.print("ID : ");
        emp_id = sc.nextLine();

        System.out.print("Name : ");
        emp_Name = sc.nextLine();

        System.out.print("Age : ");
        emp_age = sc.nextInt();
        sc.nextLine();

        System.out.print("Department : ");
        emp_dep = sc.nextLine();

        System.out.print("Showroom: ");
        sName = sc.nextLine();

    }

    @Override
    public void getDetails() {
        System.out.println("EMPLOYEE ID   : " + emp_id);
        System.out.println("EMPLOYEE NAME : " + emp_Name);
        System.out.println("EMPLOYEE AGE  : " + emp_age);
        System.out.println("EMPLOYEE DEPARTMENT : " + emp_dep);
        System.out.println("EMPLOYEE SHOWROOM NAME : " + sName);
        
    }

}
