import java.util.Scanner;

public class Lab1_b {

    // Constructor (no specific initialization needed here)
    public Lab1_b() {}

    // Single-word battle where both players enter one word each
    public void singleWordBattle(String player1Word, String player2Word) {
        // Calculate score for Player 1's word, using left-side character strengths
        int player1Score = calculateScore(player1Word, true);
        // Calculate score for Player 2's word, using right-side character strengths
        int player2Score = calculateScore(player2Word, false);

        // Display each player's score
        System.out.println("Player 1 score: " + player1Score);
        System.out.println("Player 2 score: " + player2Score);

        // Determine the winner based on scores
        if (player1Score > player2Score) {
            System.out.println("Player 1 wins with word \"" + player1Word + "\"!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 wins with word \"" + player2Word + "\"!");
        } else {
            System.out.println("It's a tie! Let's fight again!");
        }
    }

    // Two-word battle where both players enter two words each
    public void twoWordBattle(String player1Word1, String player1Word2, String player2Word1, String player2Word2) {
        // Calculate combined score for Player 1's two words
        int player1Score = calculateScore(player1Word1, true) + calculateScore(player1Word2, true);
        // Calculate combined score for Player 2's two words
        int player2Score = calculateScore(player2Word1, false) + calculateScore(player2Word2, false);

        // Display each player's combined score
        System.out.println("Player 1 score: " + player1Score);
        System.out.println("Player 2 score: " + player2Score);

        // Determine the winner based on combined scores
        if (player1Score > player2Score) {
            System.out.println("Player 1 wins with words \"" + player1Word1 + "\" and \"" + player1Word2 + "\"!");
        } else if (player2Score > player1Score) {
            System.out.println("Player 2 wins with words \"" + player2Word1 + "\" and \"" + player2Word2 + "\"!");
        } else {
            System.out.println("It's a tie! Let's fight again!");
        }
    }

    // Method to calculate the score for a word based on character strengths
    private int calculateScore(String word, boolean isLeftSide) {
        int score = 0; // Initialize score for the word
        // Loop through each character in the word
        for (char c : word.toCharArray()) {
            // Add score based on whether the word is for Player 1 (left-side) or Player 2 (right-side)
            if (isLeftSide) {
                score += getLeftStrength(c);
            } else {
                score += getRightStrength(c);
            }
        }
        return score;
    }

    // Strength values for left-side characters (Player 1's strengths)
    private int getLeftStrength(char c) {
        switch (c) {
            case 'w': return 4;
            case 'p': return 3;
            case 'b': return 2;
            case 's': return 1;
            default: return 0; // No score for other characters
        }
    }

    // Strength values for right-side characters (Player 2's strengths)
    private int getRightStrength(char c) {
        switch (c) {
            case 'm': return 4;
            case 'q': return 3;
            case 'd': return 2;
            case 'z': return 1;
            default: return 0; // No score for other characters
        }
    }

    public static void main(String[] args) {
        Lab1_b game = new Lab1_b(); // Create a new instance of the game
        Scanner scanner = new Scanner(System.in); // Initialize scanner for user input

        // Main game loop
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Single-word battle (one word from each player)");
            System.out.println("2. Two-word battle (two words from each player)");
            System.out.println("3. Exit");

            int choice = scanner.nextInt(); // Read user's menu choice
            scanner.nextLine();  // Consume the newline character

            if (choice == 1) {
                // Single-word battle: prompt each player for their word
                System.out.print("Player 1, enter your word: ");
                String player1Word = scanner.nextLine();

                System.out.print("Player 2, enter your word: ");
                String player2Word = scanner.nextLine();

                // Start the single-word battle
                game.singleWordBattle(player1Word, player2Word);
            } else if (choice == 2) {
                // Two-word battle: prompt each player for their two words
                System.out.print("Player 1, enter your first word: ");
                String player1Word1 = scanner.nextLine();

                System.out.print("Player 1, enter your second word: ");
                String player1Word2 = scanner.nextLine();

                System.out.print("Player 2, enter your first word: ");
                String player2Word1 = scanner.nextLine();

                System.out.print("Player 2, enter your second word: ");
                String player2Word2 = scanner.nextLine();

                // Start the two-word battle
                game.twoWordBattle(player1Word1, player1Word2, player2Word1, player2Word2);
            } else if (choice == 3) {
                // Exit the game
                System.out.println("Exiting the game. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again."); // Handle invalid choices
            }
        }

        scanner.close(); // Close the scanner when done
    }
}

/* DESCRIPTION
Implements an interactive game where users engage in battles based on character strengths in words. 
The Lab1_b class features two battle methods: one for a single word and another for two separate words. 
Each character contributes to a score based on predefined strength values for characters from the 
left (e.g., 'w', 'p') and right (e.g., 'm', 'q') sides of the alphabet. Users can choose between a single-word battle, 
a two-word battle, or exiting the game. The program calculates scores and announces the winner, continuing until the user 
decides to exit, providing an engaging experience. 
*/

/* OUTPUT
Choose an option:
1. Single-word battle (one word from each player)
2. Two-word battle (two words from each player)
3. Exit
1
Player 1, enter your word: w
Player 2, enter your word: z
Player 1 score: 4
Player 2 score: 1
Player 1 wins with word "w"!

Choose an option:
1. Single-word battle (one word from each player)
2. Two-word battle (two words from each player)
3. Exit
2
Player 1, enter your first word: sdfkjshdkf
Player 1, enter your second word: shqwh
Player 2, enter your first word: hshdgfh
Player 2, enter your second word: shdsh
Player 1 score: 7
Player 2 score: 4
Player 1 wins with words "sdfkjshdkf" and "shqwh"!

Choose an option:
1. Single-word battle (one word from each player)
2. Two-word battle (two words from each player)
3. Exit
3
Exiting the game. Goodbye!
*/