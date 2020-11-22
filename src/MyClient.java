import java.io.*;
import java.net.*;


public class MyClient {

//    public static void main(String[] args) {
//        Socket toserversocket;  // This is the phone for communication with server
//        int reply;       // ignore - for use in a later example
//
//        System.out.println("CLIENT is attempting connection....");
//
//        try {
//            // connect to the address (in this case “localhost”) at door # 7788
//            toserversocket = new Socket("localhost", 7788);
//            System.out.println("CONNECTION HAS BEEN MADE");
//        }
//        catch (IOException e) {
//            System.out.println(e);
//            e.printStackTrace();
//        }
//    }
//}

    private static DataInputStream instream;
    private static DataOutputStream outstream;
    public static Socket toserversocket = new Socket();     // This is the phone for communication with server


    public static void main( String[] args)
    {

        int reply;                 // ignore - for use in a later example




//        instream = new DataInputStream( toserversocket.getInputStream());
//        outstream = new DataOutputStream( toserversocket.getOutputStream());
//        PrintWriter   out = new PrintWriter(outstream, true);
//        BufferedReader  in = new BufferedReader(new InputStreamReader(instream));



        System.out.println("CLIENT is attempting connection....");
        try {
            instream = new DataInputStream(toserversocket.getInputStream());
            outstream = new DataOutputStream(toserversocket.getOutputStream());
            PrintWriter out = new PrintWriter(outstream, true);
            BufferedReader in = new BufferedReader(new InputStreamReader(instream));

            // connect to the address (in this case “localhost”) at door # 7788
            toserversocket = new Socket("localhost", 7788);
            System.out.println("CONNECTION HAS BEEN MADE");
        }
        catch (IOException  e) {
            System.out.println(e);
            e.printStackTrace();
        }


        System.out.println("CLIENT is attempting connection....");
        try {
            instream = new DataInputStream(toserversocket.getInputStream());
            outstream = new DataOutputStream(toserversocket.getOutputStream());
            PrintWriter out = new PrintWriter(outstream, true);
            BufferedReader in = new BufferedReader(new InputStreamReader(instream));

            // connect to the address (in this case “localhost”) at door # 4030
            toserversocket = new Socket("localhost", 7788);
            System.out.println("CONNECTION HAS BEEN MADE");
        }
        catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }


    }
}
