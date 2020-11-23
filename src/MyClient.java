import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {

    private static Scanner input = new Scanner(System.in);
    private static DataInputStream instream;
    private static DataOutputStream outstream;
    private static int row = -1, col = -1, serverRow = -1, serverCol = -1;


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
            PrintWriter out = new PrintWriter(outstream, true);
            BufferedReader in = new BufferedReader(new InputStreamReader(instream));

            row = -1;
            col = -1;


        }
        catch (IOException  e) {
            System.out.println(e);
        }
    }
}

