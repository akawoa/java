
public class TestPuzzle {
    public static void main(String[] args) {
        Puzzle appTest = new Puzzle();

        appTest.getTenRolls();

        System.out.println(appTest.getRandomLetter());

        System.out.println(appTest.generatePassword());
        System.out.println(appTest.getNewPasswordSet(4));
        System.out.println(appTest.getNewPasswordSet(20));
        System.out.println(appTest.getNewPasswordSet(2));
    }
    
}