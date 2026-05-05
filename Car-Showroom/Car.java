package CarShowroom;

import java.util.Scanner;

class Car extends ShowRoom implements Utility {
    String carName;
    String carColor;
    String fuleType;
    int price;
    String car_type;
    String car_transmission;

    @Override
    public void getDetails() {
        System.out.println("CAR NAME: "+carName);
        System.out.println("CAR FULETYPE: "+fuleType);
        System.out.println("CAR PRICE: "+price);
        System.out.println("CAR COLOR: "+carColor);
        System.out.println("CAR TYPE: "+car_type);
        System.out.println("CAR TRANSMISSION: "+car_transmission);
    }
    
    @Override
    public void setDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n++++++++++++ ENTER CAR DETAILS ++++++++++++\n");

        System.out.print("Name: ");
        carName = sc.nextLine();

        System.out.print("Fule type: ");
        fuleType = sc.nextLine();

        System.out.print("Price: ");
        price = sc.nextInt();

        System.out.print(("Car color: "));
        carColor = sc.nextLine();
        sc.nextLine();

        System.out.print("CAR TYPE(SEDAN/SUV/HATCHBACK): ");
        car_type = sc.nextLine();

        System.out.print("TRANSMISSION TYPE(AUTOMATIC/MANUAL): ");
        car_transmission = sc.nextLine();

        total_no_of_Cars++;
    }

    
}
