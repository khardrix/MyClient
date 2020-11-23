import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {

    private static Scanner input = new Scanner(System.in);
    private static DataInputStream instream;
    private static DataOutputStream outstream;
    private static PrintWriter out;
    private static BufferedReader in;
    private static int row = -1, col = -1, serverRow = -1, serverCol = -1;
    private static boolean turn = false;
    private static char [][] board;


    public static void main(String[] args) {

        Socket toserversocket;  // This is the phone for communication with server
        int reply;       // ignore - for use in a later example

        System.out.println("CLIENT is attempting connection....");
        try {
            // connect to the address (in this case “localhost”) at door # 7788
            toserversocket = new Socket("localhost", 7788);
            System.out.println("CLIENT CONNECTION HAS BEEN MADE");

            instream = new DataInputStream(toserversocket.getInputStream());
            outstream = new DataOutputStream(toserversocket.getOutputStream());
            out = new PrintWriter(outstream, true);
            in = new BufferedReader(new InputStreamReader(instream));

            row = -1;
            col = -1;

            board = new char[3][3];


            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < board[i].length; j++) {
                    board[i][j] = ' ';
                }
            }
        }
        catch (IOException  e) {
            System.out.println(e);
        }
    }


    public static void playGame(BufferedReader intake, PrintWriter output) throws IOException {
        if(in.readLine().equals("NONE")){
            turn = true;     // player's turn
        }
        else {
            turn = false;    // computer's turn
        }

        boolean continueGame = true;
        boolean validRow = false;
        boolean validColumn = false;
        boolean validSquare = false;

        while(continueGame) {
            if (turn) {
                while(validSquare) {
                    while (!validRow) {
                        System.out.println("Enter the row of the place you want to put a mark: ");
                        String userInput = input.nextLine();
                        while (!userInput.matches("[012]")) {
                            System.out.print("Invalid Input(numbers 0 - 2). Enter " +
                                    "a row number between 0 - 2 (only): ");
                            userInput = input.nextLine();
                        }
                        row = Integer.parseInt(userInput);

                        System.out.println("Enter the column of the place you want to put a mark: ");
                        userInput = input.nextLine();
                        while (!validColumn) {
                            System.out.print("Invalid Input(numbers 0 - 2). Enter " +
                                    "a column number between 0 - 2 (only): ");
                            userInput = input.nextLine();
                        }
                        col = Integer.parseInt(userInput);
                    }
                    if(board[row][col] == ' ') {
                        validSquare = true;
                    }
                }
                // board[row][col] = 'O';

                // out.println("MOVE " + row + " " + col);

                // printBoard();
            }
        }
    }


    public static void printBoard() {
        int x = 8;
    }
}

