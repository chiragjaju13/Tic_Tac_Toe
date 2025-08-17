//Tic Tac Toe game

import java.util.*;

public class TicTacToe {
  static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    char currentPlayer = 'X';
    int moves = 0;

    while (true) {
      printBoard();
      System.out.println("Player " + currentPlayer + " move. Enter row & column (0-2); ");
      int row = sc.nextInt();
      int col = sc.nextInt();

      // check for invald conditions
      if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
        System.out.println("Invalid move");
        continue;
      }

      board[row][col] = currentPlayer;
      moves++;

      // check for win
      if (checkWin(currentPlayer)) {
        printBoard();
        System.out.println("Player " + currentPlayer + " wins!");
        break;
      } else if (moves == 9) {
        System.out.println("Draw!");
        break;
      }

      // current player changes after each moves
      currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    sc.close();
  }

  static void printBoard() {
    System.out.println("Board");
    for (char[] row : board) {
      for (char cell : row) {
        System.out.print("|" + cell + " ");
      }
      System.out.println("|");
    }
  }

  static boolean checkWin(char Player) {

    for (int i = 0; i < 3; i++) {
      // Checks rows & columns
      if ((board[0][i] == Player && board[1][i] == Player && board[2][i] == Player)
          || (board[i][0] == Player && board[i][1] == Player && board[i][2] == Player))
        return true;
    }

    // check diagonal conditions
    if ((board[0][0] == Player && board[1][1] == Player && board[2][2] == Player)
        || (board[2][0] == Player && board[1][1] == Player && board[0][2] == Player))
      return true;

    return false;
  }
}