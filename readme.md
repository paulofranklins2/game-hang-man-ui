# HangMan Game

Welcome to the HangMan game! This simple Java Swing application allows you to play the classic word-guessing game. Try to guess the hidden word by entering letters, but be careful—you have limited attempts!

## How to Play

1. **Guess the Word**: You are presented with a word with missing letters represented by underscores. Enter a single letter in the text field and click the "Submit" button to guess.

2. **Winning**: Fill in all the missing letters before running out of attempts to win the game.

3. **Restart**: Click the "Restart" button to start a new game.

## Getting Started

To run the HangMan game, follow these steps:

1. Compile the Java file:
    ```bash
    javac HangMan.java
    ```

2. Run the compiled program:
    ```bash
    java HangMan
    ```

## Game Controls

- **Submit Button**: Submit your letter guess.
- **Restart Button**: Start a new game.

## Game Logic

The game randomly selects a word from a predefined list. You must guess the missing letters to complete the word. Each incorrect guess reduces the number of attempts.

## Word List

The game includes a variety of words for you to guess. The word list can be customized in the `listOfWords` array in the code.

```java
// Example word list
listOfWords = new ArrayList<>(Arrays.asList("chair", "table", "plant", ...));
```

Feel free to modify the word list to tailor the game to your preferences.

## Dependencies

The game is built using Java and the Swing library for the graphical user interface.

## Author

This HangMan game was created by Paulo Cunha.

Enjoy playing the game, and may the odds be in your favor!