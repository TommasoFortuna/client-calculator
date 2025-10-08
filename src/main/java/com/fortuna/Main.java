package com.fortuna;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client avviato");

        System.out.println("Inserisci ip del server");
        Scanner scan = new Scanner(System.in);

        String ip = scan.nextLine();
        System.out.println("Inserisci porta del server");
        int port = Integer.parseInt(scan.nextLine());

        Socket mioSocket = new Socket(ip, port);

        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(), true);

        System.out.println(in.readLine());
        out.println("Versione client: 0.9");

        System.out.println("Inserisci primo numero");
        out.println(scan.nextLine());

        System.out.println("Inserisci secondo numero");
        out.println(scan.nextLine());

        System.out.println("Inserisci operazione (1=+,2=-,3=/,4=*)");
        out.println(scan.nextLine());

        System.out.println("Risultato: " + in.readLine());

        mioSocket.close();
        scan.close();
    }
}
