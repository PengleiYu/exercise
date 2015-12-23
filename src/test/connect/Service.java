package test.connect;

import java.io.*;
import java.net.*;

/**
 * Created by Administrator on 2015/12/17.
 */
public class Service {
    public static int len = 1024;

    public static void main(String[] args) {

        tcp();
    }

    public static void udp() {
        try {
            DatagramSocket socket = new DatagramSocket(12345);
            while (true) {
                byte[] buffer = new byte[len];
                DatagramPacket packet = new DatagramPacket(buffer, len);
                socket.receive(packet);
                System.out.println(new String(packet.getData()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tcp() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(reader.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
