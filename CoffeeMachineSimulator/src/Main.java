import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {

            System.out.println("Enter a command (buy/fill/take/show/exit/analytics):");
            String userInput = scanner.nextLine();


            switch (userInput) {
                case "buy":
                    System.out.println("Enter the coffee type (Espresso/Latte/Cappuccino):");
                    String coffeeType = scanner.nextLine();
                    coffeeMachine.buyCoffee(coffeeType);
                    break;
                case "fill":
                    System.out.println("Enter the amount of water (ml):");
                    int addedWater = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the amount of milk (ml):");
                    int addedMilk = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the amount of beans (units):");
                    int addedBeans = Integer.parseInt(scanner.nextLine());
                    coffeeMachine.fillIngredients(addedWater, addedMilk, addedBeans);
                    break;
                case "take":
                    coffeeMachine.takeMoney();
                    break;
                case "show":
                    coffeeMachine.showIngredients();
                    break;
                case "exit":
                    isRunning = false;
                    break;
                case "analytics":
                    coffeeMachine.showAnalytics();
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}