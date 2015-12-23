package test.connect;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.*;

/**
 * Created by Administrator on 2015/12/17.
 */
public class Client {
    public static String word = "Hello";

    public static void main(String[] args) {

        tcp();
    }

    public static void udp() {
        try {
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket packet = new DatagramPacket(word.getBytes(), word.length(), InetAddress.getByName("192.100.1.251"), 12345);
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tcp() {
        try {
            Socket socket = new Socket("192.100.1.251", 12345);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("Hi!");
//            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
