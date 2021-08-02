import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
public class Puzzle {
// // To use methods from the Random library you will need to create an instance of Random
Random randMachine = new Random();
// // From there you can use any of the methods listed in the documentation. For example:
// randMachine.setSeed(35679); // <--- you won't need to use this method.

// getTenRolls
// Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive. 
    public ArrayList<Integer> getTenRolls () {
        int i = 1;
        ArrayList<Integer> random = new ArrayList<Integer>(); 
        while (i <= 10) {
            int randomNum = randMachine.nextInt(20)+1;
            random.add(randomNum);
            i++;
        }
        System.out.println(random);
        return random;
    }

// getRandomLetter
// Write a method that will:
// Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values). 
// Generate a random index between 0-25, and use it to pull a random letter out of the array.
// Return the random letter.
    public String getRandomLetter () {
        int i = 1;
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        System.out.println(Arrays.toString(letters));
        int randomNum = randMachine.nextInt(25)+1;
        return "Your random letter is: " + letters[randomNum];
    }



// generatePassword
// Write a method that uses the previous method to create a random string of eight characters, and return that string.
    public String generatePassword () {
        int i = 0;
        String[] password = new String[8];
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        System.out.println(Arrays.toString(letters));
        while (i <= 7) {
            int randomNum = randMachine.nextInt(25)+1;
            String randomLetter = letters[randomNum];
            password[i] = (randomLetter);
            i++;
        }
        System.out.println(Arrays.toString(password));
        String newPassword = Arrays.toString(password);
        return "Your password is: " + newPassword;
    }

// getNewPasswordSet
// Write a method that takes an int length as an argument and creates an array of random eight character words. The array should be the length passed in as an int.
    public String getNewPasswordSet (int length) {
        System.out.println(length);
        int j = 0;
        int passwordLength = length-1;
        String[] passwordSet = new String[length];
        String[] letters = {"a","b","c","d","e","f","g","h","j","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        System.out.println(Arrays.toString(letters));
        while (j <= passwordLength) {
            int randomNum = randMachine.nextInt(25)+1;
            String randomLetter = letters[randomNum];
            passwordSet[j] = (randomLetter);
            j++;
        }
        System.out.println(Arrays.toString(passwordSet));
        String newPassword = Arrays.toString(passwordSet);
        return "Your password is: " + newPassword;
    }


}