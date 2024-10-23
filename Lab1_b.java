public class Lab1_b {

    public Lab1_b() {}

    public void battle(String word) {
        int leftScore = 0;
        int rightScore = 0;

        for (char c : word.toCharArray()) {
            leftScore += getLeftStrength(c);
            rightScore += getRightStrength(c);
        }

        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    public void battle(String leftWord, String rightWord) {
        int leftScore = 0;
        int rightScore = 0;

        for (char c : leftWord.toCharArray()) {
            leftScore += getLeftStrength(c);
        }

        for (char c : rightWord.toCharArray()) {
            rightScore += getRightStrength(c);
        }

        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }

    private int getLeftStrength(char c) {
        switch (c) {
            case 'w': return 4;
            case 'p': return 3;
            case 'b': return 2;
            case 's': return 1;
            default: return 0;
        }
    }

    private int getRightStrength(char c) {
        switch (c) {
            case 'm': return 4;
            case 'q': return 3;
            case 'd': return 2;
            case 'z': return 1;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Lab1_b game = new Lab1_b();

        System.out.println("Test 1 (Word: 'z'):");
        game.battle("z");

        System.out.println("Test 2 (Word: 'zdqmwpbs'):");
        game.battle("zdqmwpbs");

        System.out.println("Test 3 (Word: 'wwwwwwz'):");
        game.battle("wwwwwwz");

        System.out.println("Test 4 (Left Word: 'wbp', Right Word: 'mqdz'):");
        game.battle("wbp", "mqdz");
    }
}
