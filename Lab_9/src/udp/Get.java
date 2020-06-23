package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Get {
    DatagramSocket socket = new DatagramSocket();
    byte[] bytes = new byte[10];

    public Get(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void getMEssages() throws IOException {
        socket.receive(new DatagramPacket(bytes,10));
        String line  = new String(bytes);
        System.out.println(line);
    }

    public static void main(String[] args) throws IOException {
        Get udpGet = new Get(6666);
        while(true) {
            udpGet.getMEssages();
        }
    }
}
