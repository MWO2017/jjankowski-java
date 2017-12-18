package JavaTwo.LabTwo.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private GameState currentGameState;
    private Seed currentPlayer;

    private static Scanner in = new Scanner(System.in);

    public TicTacToe() {
        board = new Board();
        initializeGame();
        board.paint();
        do {
            movePlayer(currentPlayer);
            board.paint();
            updateGame(currentPlayer);

            switch (currentGameState) {
                case PLAYING:
                    break;
                case DRAW:
                    System.out.println("Nobody wins, It's Draw!");
                    break;
                case CROSS_WON:
                    System.out.println("The player 'X' has won!");
                    break;
                case NOUGHT_WON:
                    System.out.println("The player 'O' has won!");
                    break;
            }
            currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
        } while (currentGameState == GameState.PLAYING);  // repeat until game-over
    }


    public void initializeGame() {
        board.init();
        currentPlayer = Seed.CROSS;
        currentGameState = GameState.PLAYING;
    }

    public void movePlayer(Seed theSeed) {
        boolean validInput = false;
        do {
            if (theSeed == Seed.CROSS) {
                System.out.print("Player 'X', please enter your move (row[1-3] column[1-3]): ");
            } else {
                System.out.print("Player 'O', please enter your move (row[1-3] column[1-3]): ");
            }
            int row = in.nextInt() - 1;
            int col = in.nextInt() - 1;
            if (row >= 0 && row < Board.ROWS && col >= 0 && col < Board.COLS
                    && board.cells[row][col].content == Seed.EMPTY) {
                board.cells[row][col].content = theSeed;
                board.currentRow = row;
                board.currentCol = col;
                validInput = true;
            } else {
                System.out.println("This move at (" + (row + 1) + "," + (col + 1)
                        + ") is not valid. Try again...");
            }
        } while (!validInput);
    }

    public void updateGame(Seed seed) {
        if (board.hasWon(seed)) {
            currentGameState = (seed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
        } else if (board.isDraw()) {
            currentGameState = GameState.DRAW;
        }

    }

}