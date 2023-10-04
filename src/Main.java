import java.util.*;
import java.text.*;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
        ArrayList<TipCalculator> fullOrder = new ArrayList<>();

        //list variables
        double itemCost;
        String food = "0";

        //printing info
        System.out.println("Welcome to a Restaurant!");
        System.out.print("How many people are you dining with?: ");
        int people = scan.nextInt();
        System.out.print("What percentage would you like to tip? (0 - 100): ");
        double tipPercentage = scan.nextDouble();
        System.out.println("------------------------");
        System.out.println("Instructions: \n1. Enter the name of the item you would like to order (Type 'Done' if you are finished ordering)");
        System.out.println("2. Enter the cost of the item you are ordering");
        TipCalculator calculator = new TipCalculator(people, tipPercentage);
        scan.nextLine(); //clearing scanner

        while (!food.equals("Stop") && !food.equals("Done")) { //while loop that asks for food
            System.out.print("What would you like to order?: ");
            food = scan.nextLine();
            if (!food.equals("Stop") && !food.equals("Done")) {
                System.out.print("How much is the item you are ordering?: ");
                itemCost = scan.nextDouble();
                TipCalculator newFood = new TipCalculator(food,itemCost); //creates a new object
                fullOrder.add(newFood); //adds object
                calculator.addMeal(itemCost); //calculates total
                scan.nextLine(); //clears scanner
            }
        }
        System.out.println("------------------------");
        //printing items ordered
        for (int i = 0; i < fullOrder.size(); i++) { //iterates through list
            TipCalculator newFood = fullOrder.get(i);
            System.out.println("Item #" + (i + 1) + ": " + newFood.getFoodName() + " - $" + df.format(newFood.getFoodPrice()));
        }
        //printing statements
        System.out.println("------------------------");
        System.out.println("Total bill before tip: $" + df.format(calculator.getTotalBeforeTip()));
        System.out.println("Total tip percentage: " + df.format(calculator.getTipPercent()) + "%");
        System.out.println("Total tip: $" + df.format(calculator.tipAmount()));
        System.out.println("Total bill with tip: $" + df.format(calculator.totalBill()));
        System.out.println("Cost per person before tip: $" + df.format(calculator.perPersonBeforeTip()));
        System.out.println("Tip per person: $" + df.format(calculator.perPersonTip()));
        System.out.println("Total cost per person: $" + df.format(calculator.perPersonTotalCost()));
        System.out.println("------------------------");
    }
}
