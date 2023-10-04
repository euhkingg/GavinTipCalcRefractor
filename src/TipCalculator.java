public class TipCalculator {
    private double foodPrice;
    private String foodName;
    private int people;
    private double tip;
    private double totalBeforeTip;
    public TipCalculator(String food, double price) { //Creating a constructor to store food and price
        foodName = food;
        foodPrice = price;
    }

    public TipCalculator(int numPeople, double tipPercent) {
        people = numPeople;
        tip = tipPercent;
        totalBeforeTip = 0;
    }

    //Getters
    public double getFoodPrice() {
        return foodPrice;
    }
    public String getFoodName() {
        return foodName;
    }
    public double getTipPercent() {
        return tip;
    }
    public double getTotalBeforeTip() {
        return totalBeforeTip;
    }

    public void addMeal(double cost) {
        totalBeforeTip += cost;
    }
    public double tipAmount() {
        return totalBeforeTip * (tip / 100);
    }
    public double totalBill() {
        return tipAmount() + totalBeforeTip;
    }
    public double perPersonBeforeTip() {
        return totalBeforeTip / people;
    }
    public double perPersonTip() {
        return tipAmount() / people;
    }
    public double perPersonTotalCost() {
        return totalBill() / people;
    }

}
