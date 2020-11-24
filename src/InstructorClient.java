import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class InstructorClient {
    private static Socket toserver;
    private static char[][] board;
    private static int row;
    private static int col;
    private static DataInputStream instream;
    private static DataOutputStream outstream;
    private static PrintWriter out;
    private static BufferedReader in;

    public InstructorClient() {
    }

    public static void main(String[] args) throws IOException {
        toserver = new Socket("localhost", 7788);
        instream = new DataInputStream(toserver.getInputStream());
        outstream = new DataOutputStream(toserver.getOutputStream());
        PrintWriter out = new PrintWriter(outstream, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(instream));
        board = new char[3][3];

        for(int rowSpaceToFill = 0; rowSpaceToFill <= 2; ++rowSpaceToFill) {
            for(int columnSpaceToFill = 0; columnSpaceToFill <= 2; ++columnSpaceToFill) {
                board[rowSpaceToFill][columnSpaceToFill] = ' ';
            }
        }

        row = -1;
        col = -1;
        playgame(in, out);
    }

    public static void playgame(BufferedReader in, PrintWriter out) throws IOException {
        Scanner scannerInput = new Scanner(System.in);
        boolean gameOver = false;

        for(boolean computerTurn = false; !computerTurn; gameOver = !gameOver) {
            if (!gameOver) {
                String str = in.readLine();
                if (!str.equals("NONE")) {
                    String[] data = str.split("\\s+");
                    if (data.length > 3) {
                        row = Integer.parseInt(data[1]);
                        col = Integer.parseInt(data[2]);
                        if (!data[3].equals("WIN") && row != -1) {
                            board[row][col] = 'X';
                        }

                        String result = data[3];
                        byte resultMessageOption = -1;
                        switch(result.hashCode()) {
                            case 83056:
                                if (result.equals("TIE")) {
                                    resultMessageOption = 1;
                                }
                                break;
                            case 85948:
                                if (result.equals("WIN")) {
                                    resultMessageOption = 0;
                                }
                                break;
                            case 2342691:
                                if (result.equals("LOSS")) {
                                    resultMessageOption = 2;
                                }
                        }

                        switch(resultMessageOption) {
                            case 0:
                                System.out.println("\n\nCongratulations!!! You WON the game!");
                                break;
                            case 1:
                                System.out.println("\nThe game was a TIE!");
                                break;
                            case 2:
                                System.out.println("\nSORRY! You LOST the game!");
                        }

                        computerTurn = true;
                    } else {
                        row = Integer.parseInt(data[1]);
                        col = Integer.parseInt(data[2]);
                        board[row][col] = 'X';
                    }
                } else {
                    System.out.println("\nYOU MOVE FIRST");
                }
            } else {
                while(true) {
                    do {
                        System.out.print("\nEnter Row : ");
                        row = scannerInput.nextInt();
                        System.out.print("Enter Column : ");
                        col = scannerInput.nextInt();
                    } while(row < 0);

                    if (row <= 2 && col <= 2 && col >= 0 && board[row][col] == ' ') {
                        board[row][col] = 'O';
                        out.println("MOVE " + row + " " + col);
                        break;
                    }
                }
            }

            printboard();
        }

        System.out.println("\n\nHere is the final game board");
        printboard();
    }

    public static void printboard() {
        System.out.println("\n\nCLIENT PRINT");

        for(int r = 0; r <= 2; ++r) {
            System.out.println(board[r][0] + " | " + board[r][1] + " | " + board[r][2]);
            if (r != 2) {
                System.out.println("----------");
            }
        }

    }
}
