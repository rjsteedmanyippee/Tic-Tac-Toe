import java.util.Scanner;
class ticky {
    static String[] board = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
    static void printBoard() {
        for (int i = 1; i<=9; i++) {
            if (i == 1 || i == 4 || i == 7 || i == 9) {
                System.out.println("      |       |      "); }
            else if (i == 3 || i == 6) {
                System.out.println("_____ | _____ | _____ "); }
            else {
                System.out.println("  " + board[i-2] + "   |   " + board[i-1] + "   |   " + board[i] + "  ");
            }
        }
    }
    static void change(int i, String s) {
        if (i<1 || i>9) {
            System.out.println("Invalid position"); 
            return; }
        if (!s.equals("X") && !s.equals("O")) {
            System.out.println("Invalid symbol"); 
            return; }
        if (!board[i-1].equals(" ")) {
            System.out.println("Position already taken"); 
            return; }
        board[i-1]=s;
    }
    static void checkGameOver() {
        for (int i = 0; i < 3; i++) {
            if (board[i].equals(board[i+3]) && board[i].equals(board[i+6]) && !board[i].equals(" ")) {
                System.out.println(board[i] + " wins!"); return; } 
            if (board[i*3].equals(board[i*3+1]) && board[i*3].equals(board[i*3+2]) && !board[i*3].equals(" ")) {
                System.out.println(board[i*3] + " wins!"); return; }
        }
        if (board[0].equals(board[4]) && board[0].equals(board[8]) && !board[0].equals(" ")) {
            System.out.println(board[0] + " wins!"); return; }
        if (board[2].equals(board[4]) && board[2].equals(board[6]) && !board[2].equals(" ")) {
            System.out.println(board[2] + " wins!"); return; }
        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (board[i].equals(" ")) {
                draw = false; break; }
        }
        if (draw) {
            System.out.println("It's a draw!"); return; }
    }
}
class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ticky.printBoard();
    boolean gameOver = false;
    while (gameOver == false) {
    System.out.println();
    System.out.println("Enter position (1-9): ");
    int pos = sc.nextInt();
    System.out.println("Enter X or O: ");
    String sym = sc.next();
    ticky.change(pos, sym);
    ticky.printBoard();
    ticky.checkGameOver();
    }
    sc.close();
  
    }
}
