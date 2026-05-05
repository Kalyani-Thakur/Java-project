import java.util.Scanner;

public class UnitConveter {

    public static double kmTOmiles(double km) {
        return km * 0.621371;
    }

    public static double milesTOkm(double miles) {
        return miles / 0.621371;
    }

    public static double cTOf(double C) {
        return (C * 9 / 5) + 32;
    }

    public static double fTOc(double F) {
        return (F - 32) * 5 / 9;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Kilometers to miles");
        System.out.println("2. Miles to kilometers");
        System.out.println("3. Celsius to Fahrenheit");
        System.out.println("4. Fahrenheit to celsius");

        System.out.print("Enter your choice: ");
        int input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Enter kilometer: ");
                    double km = sc.nextDouble();
                    System.out.printf("%.2f km = %.2f miles\n", km, kmTOmiles(km));
                    break;
                case 2:
                    System.out.print("Enter Miles: ");
                    double miles = sc.nextDouble();
                    System.out.printf("%.2f miles = %.2f km\n", miles, milesTOkm(miles));
                    break;
                case 3:
                    System.out.print("Enter Celsius: ");
                    double C = sc.nextDouble();
                    System.out.printf("%.2f celsius = %.2f km\n", C, cTOf(C));
                    break;
                case 4:
                    System.out.print("Enter Fahrenheit: ");
                    double F = sc.nextDouble();
                    System.out.printf("%.2f Fahrenheit = %.2f Celsius\n", F, milesTOkm(F));
                    break;
    
                default:
                    System.out.println("Invalid input! try again");
                    break;
            }
        
    }
}

