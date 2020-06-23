package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Send {
    DatagramSocket socket =  new DatagramSocket();
    public Send(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    public void sendMessages(String messages,int port) throws IOException {
        DatagramPacket packet = new DatagramPacket(messages.getBytes(),messages.getBytes().length, InetAddress.getLocalHost(),port);
        socket.send(packet);
    }

    public static void main(String[] args) throws IOException {
        Send udp = new Send(1414);
        udp.sendMessages("hello",6666);
    }
}
