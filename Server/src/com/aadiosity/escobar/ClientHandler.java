package com.aadiosity.escobar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private ArrayList<ClientHandler> clients;
    public ClientHandler(Socket socket, ArrayList<ClientHandler> clients) throws IOException{
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        this.clients = clients;
    }


    @Override
    public void run(){
        try {
            System.out.println(socket.getInetAddress() + "Connected\n");
            while (true){
                String request = in.readLine();
                String[] req = request.split(",");
                if (req[0].equals("1"))
                    out.println(capitalizer(req[1]));
                else if(req[0].equals("2")){
                    if (isNumber(req[1]))
                        out.println(factorial(Integer.parseInt(req[1])));
                }
            }
        }catch (IOException e){
            System.out.println("Exception Raised " + e.getMessage());
        }finally {
            try {
                socket.close();in.close();out.close();
            }catch (IOException e){
                System.out.println("OOPS " + e.getMessage());
            }
        }
    }

    private String capitalizer(String msg) {
        return msg.toUpperCase();
    }
    private BigInteger factorial(int number){
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 1; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    private boolean isNumber(String regex){
        return regex.matches("[0-9]+");
    }
}
