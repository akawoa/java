import java.util.Date;
public class CafeUtil {

// (void) militaryHoursTest
// Write a method that prints all the numbers from 0 to 23.
    public void militaryHoursTest() {
        int[] militaryHours = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int i = 0;
        while (i < 24) {
            System.out.println(militaryHours[i]);
            i++;
        }
    }

// (void) coffeeNotification
// Starting at 0 and ending after 23, for every hour in the day, print out each hour as a string like so: "It's 4:00 hours, do you need a coffee break?". Hint: Use String.format() to put the hour integer in the string. Note: you do not need to include any leading zeros.
    public void coffeeNotification() {
        Date currentDate = new Date();
        System.out.println(String.format("It's " + currentDate.getHours() + ":00 hours, do you need a coffee break?"));
    }

// (void) specialsAlert
// Starting at 6 and ending at 15, iterate through each number, representing an hour, if the hour is a multiple of 3, print "Buy one get one free for the next 15 minutes!" Otherwise, print "Stay tuned for deals announced throughout the day."
    public void specialsAlert() {
        int[] militaryHours = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int i = 0;
        while (i < 24) {
            if (militaryHours[i] >= 6 && militaryHours[i] <= 15){
                if (militaryHours[i] % 3 == 0) {
                System.out.println("Buy one get one free for the next 15 minutes!");
                } else {
                    
                System.out.println("Stay tuned for deals announced throughout the day.");
                }
            } 
            i++;
        }
    }

// (int) leadsAtDay10
// The sales reps at Cafe Java have a competitive rewards system in place. Each day, they must increase their leads to 1 more than the day before. Or net the same amount at the end of 10 days.

// Starting with 1, sum together all the numbers from 1 to 10. This will calculate how many leads a sales rep needs to have after 10 days to get the reward for that period. Return the sum after it has been calculated.

public int leadsAtDay10() {
    int leads = 1;
    int days = 1;
    while (days < 11) {
        leads ++;
        days ++;
    }
    return leads;
}



// (void) displayMenu
// Given an array of menu item names (strings), iterate through the array and print all the menu items in the array.
    public void displayMenu(String[] menu) {
                System.out.println("Menu:");
        int j = 0;
        while (j < menu.length) {
            System.out.println(menu[j]);
            j++;
        }

    }

// (double) getOrderTotal
// Given an array of the prices from the items in a customer order, iterate over the array to sum each item price and to return the total
    public double getOrderTotal(double[] lineitems) {
                System.out.println("Total:");
        int j = 0;
        double total = 0;
        while (j < lineitems.length) {
            total += lineitems[j];
            j++;
        }
        return total;
    }
// (double) getHighestPrice
// Given an array of all the item prices, find the highest price for any item

// (ArrayList<String>) getRaffleWinners
// In your method, create an empty array,  winners . Iterate over a given array of customers and add every 4th customer to the winners array. Return the winners array, when you've added all the winners.


}