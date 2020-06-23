package cross;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client extends Thread {
    TBoard board = new TBoard();

    Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    String endmessagestr = "";
    Integer endmessage ;
    int row, col, currentPlayer;

    Scanner scan = new Scanner(System.in);

    Client() {
    }

    public void run() {
        try {
            requestSocket = new Socket( InetAddress.getLocalHost(),7071);
            System.out.println("Connected to localhost in port 7071");
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            in = new ObjectInputStream(requestSocket.getInputStream());
            do {
                endmessagestr = (String) in.readObject();
            }while(!endmessagestr.equals("Game start"));
            System.out.println("Game start");
            System.out.println("the first player to go is number " + board.getPlayer());
            do {
                try {

                    currentPlayer = (Integer) in.readObject();
                    if(currentPlayer == -1) {
                        System.out.println("You lost");
                        break;
                    }
                    board.setPlayer(currentPlayer);

                    int[][] b_array = (int[][]) in.readObject();
                    board.setTable(b_array);

                    for (int i = 0; i < 3; i++) {
                        System.out.println("");
                        for (int j = 0; j < 3; j++) {
                            if (b_array[i][j] == 1) {
                                System.out.print(" X");
                            }
                            else if (b_array[i][j] == 2) {
                                System.out.print(" O");
                            }
                            else {
                                System.out.print(" -");
                            }
                        }
                    }

                    System.out.println();

                    message = (String) in.readObject();
                    System.out.print(message);

                    row = scan.nextInt();
                    while (row < 0 || row > 2) {
                        System.out
                                .print("Row is invalid, please choose again (0-2): ");
                        row = scan.nextInt();
                    }

                    col = scan.nextInt();
                    while (col < 0 || col > 2) {
                        System.out
                                .print("Column is invalid, please choose again (0-2): ");
                        col = scan.nextInt();
                    }

                    while (!board.make_move(row, col)) {
                        System.out
                                .print("The move is not valid. Please choose another row (0-2): ");
                        row = scan.nextInt();

                        while (row < 0 || row > 2) {
                            System.out
                                    .print("Row is invalid, please choose again (0-2): ");
                            row = scan.nextInt();
                        }

                        System.out.print("Please choose a column (0-2): ");
                        col = scan.nextInt();

                        while (col < 0 || col > 2) {
                            System.out
                                    .print("Column is invalid, please choose again (0-2): ");
                            row = scan.nextInt();
                        }
                    }

                    for (int i = 0; i < 3; i++) {
                        System.out.println("");
                        for (int j = 0; j < 3; j++) {
                            if (b_array[i][j] == 1) {
                                System.out.print(" X");
                            }
                            else if (b_array[i][j] == 2) {
                                System.out.print(" O");
                            }
                            else {
                                System.out.print(" -");
                            }
                        }
                    }

                    System.out.println();

                    out.writeObject(board.getTable());
                    out.flush();

                    endmessage = (Integer) in.readObject();
                    if(endmessage == -1) {
                        message = (String) in.readObject();
                        System.out.print(message);
                    }


                }
                catch (ClassNotFoundException classNot) {
                    System.err.println("data received in unknown format");
                }
            } while (endmessage != -1);
        }
        catch (UnknownHostException unknownHost) {
            System.err.println("You are trying to connect to an unknown host!");
        }
        catch (IOException ioException) {
            ioException.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                requestSocket.close();
            }
            catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    void sendMessage(int msg) {
        try {
            out.writeObject(msg);
            out.flush();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String args[]) {
        Client client = new Client();
        client.run();
    }
}
