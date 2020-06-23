package cross;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    TBoard board = new TBoard();
    ServerSocket providerSocket;
    Socket connection1 = null, connection2 = null;
    ObjectOutputStream out, out2;
    ObjectInputStream in, in2;
    String message;
    Boolean done = false;
    int row;
    int col;

    Server(){
    }

    public void run() {
        try {
            providerSocket = new ServerSocket(7071);
            System.out.println("Waiting for connection...");
            connection1 = providerSocket.accept();
            System.out.println("Connection received from Player 1 "
                    + connection1.getInetAddress().getHostName());
            connection2 = providerSocket.accept();
            System.out.println("Connection received from Player 2 "
                    );

            out = new ObjectOutputStream(connection1.getOutputStream());
            out2 = new ObjectOutputStream(connection2.getOutputStream());

            in = new ObjectInputStream(connection1.getInputStream());
            in2 = new ObjectInputStream(connection2.getInputStream());

            out.writeObject("Game start");
            out2.writeObject("Game start");

            do {
                if (board.getPlayer() == 1) {
                    out.writeObject(board.getPlayer());
                    out.flush();
                    out.writeObject(board.getTable());
                    out.flush();
                }
                else {
                    out2.writeObject(board.getPlayer());
                    out2.flush();
                    out2.writeObject(board.getTable());
                    out2.flush();
                }
                sendMessage(board.getPlayer(),
                        "Please enter a row, press Enter, then enter a column: ");

                if (board.getPlayer() == 1) {
                    int[][] c_array = (int[][]) in.readObject();
                    board.setTable(c_array);
                }
                else {
                    int[][] c_array = (int[][]) in2.readObject();
                    board.setTable(c_array);
                }
                if (board.getPlayer() == 1) {
                    board.setPlayer(2);
                }
                else {
                    board.setPlayer(1);
                }
                if (board.winner() != 0) {
                    out.writeObject(-1);
                    out.flush();
                    out2.writeObject(-1);
                    out2.flush();
                    System.out.print("The winner is...");
                    if (board.getPlayer() == 1) {
                        System.out.println("Player 2!");
                        out2.writeObject("You win");
                        out2.flush();
                    }
                    else {
                        System.out.println("Player 1!");
                        out.writeObject("You win");
                        out.flush();
                    }

                    done = true;
                }
                else {
                    if(board.getPlayer() == 2){
                        out.writeObject(0);
                        out.flush();
                    }
                    else{
                        out2.writeObject(0);
                        out2.flush();
                    }
                }
            } while (done != true);

        } catch (IOException | ClassNotFoundException e) {
            try {
                if (out == null) {
                    out2.writeObject("win because you opponent had disconnected");
                } else if (out2 == null) {
                    out.writeObject("win because you opponent had disconnected");
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    void sendMessage(int player, String msg) {
        try {
            if (player == 1) {
                out.writeObject(msg);
                out.flush();
            }
            else {
                out2.writeObject(msg);
                out2.flush();
            }
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
            server.run();
    }
}