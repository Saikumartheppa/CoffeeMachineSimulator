public class CoffeeMachine {
    private int milk;
    private int water;
    private int beans;
    private int moneyEarned;
    private int espressoPrice = 4;
    private int lattePrice = 7;
    private int cappuccinoPrice = 6;
    private int espressoWater = 250;
    private int latteWater = 350;
    private int cappuccinoWater = 200;
    private int latteMilk = 75;
    private int cappuccinoMilk = 100;
    private int espressoBeans = 16;
    private int latteBeans = 20;
    private int cappuccinoBeans = 12;
    private int espressoCount;
    private int latteCount;
    private int cappuccinoCount;

    public CoffeeMachine() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
        this.moneyEarned = 0;
        this.espressoCount = 0;
        this.latteCount = 0;
        this.cappuccinoCount = 0;
    }
    public void buyCoffee(String coffeeType) {
        // Check if there are enough ingredients
        if (coffeeType.equals("Espresso") && canMakeCoffee(espressoWater, 0, espressoBeans)) {
            // Deduct ingredients and add money
            water -= espressoWater;
            milk -= 0;  // Espresso doesn't require milk
            beans -= espressoBeans;
            moneyEarned += espressoPrice;
            espressoCount++;
            System.out.println("Enjoy your Espresso!");
        } else if (coffeeType.equals("Latte") && canMakeCoffee(latteWater, latteMilk, latteBeans)) {
            // Deduct ingredients and add money
            water -= latteWater;
            milk -= latteMilk;
            beans -= latteBeans;
            moneyEarned += lattePrice;
            latteCount++;
            System.out.println("Enjoy your Latte!");
        } else if (coffeeType.equals("Cappuccino") && canMakeCoffee(cappuccinoWater, cappuccinoMilk, cappuccinoBeans)) {
            // Deduct ingredients and add money
            water -= cappuccinoWater;
            milk -= cappuccinoMilk;
            beans -= cappuccinoBeans;
            moneyEarned += cappuccinoPrice;
            cappuccinoCount++;
            System.out.println("Enjoy your Cappuccino!");
        } else {
            System.out.println("Sorry, not enough ingredients for your choice.");
        }
    }
    private boolean canMakeCoffee(int requiredWater, int requiredMilk, int requiredBeans) {
        return water >= requiredWater && milk >= requiredMilk && beans >= requiredBeans;
    }


    public void fillIngredients(int addedWater, int addedMilk, int addedBeans) {
        water += addedWater;
        milk += addedMilk;
        beans += addedBeans;
    }


    public void takeMoney() {
        System.out.println("You took $" + moneyEarned + " from the money box.");
        moneyEarned = 0;
    }


    public void showIngredients() {
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Beans: " + beans + " units");
    }


    public void showAnalytics() {
        System.out.println("Espresso sold: " + espressoCount);
        System.out.println("Latte sold: " + latteCount);
        System.out.println("Cappuccino sold: " + cappuccinoCount);
        System.out.println("Total money earned: $" + moneyEarned);
        System.out.println("Ingredients consumed:");
        System.out.println("Water: " + (espressoCount * espressoWater + latteCount * latteWater + cappuccinoCount * cappuccinoWater) + " ml");
        System.out.println("Milk: " + (latteCount * latteMilk + cappuccinoCount * cappuccinoMilk) + " ml");
        System.out.println("Beans: " + (espressoCount * espressoBeans + latteCount * latteBeans + cappuccinoCount * cappuccinoBeans) + " units");
    }
}
