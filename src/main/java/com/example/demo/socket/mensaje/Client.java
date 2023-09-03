package com.example.demo.socket.mensaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
		
	private final Integer PORT=13;
	private final String  IP="localhost";
	
	public Client() {
		// TODO Auto-generated constructor stub
		
	try {
		Socket clientSeSocket=new Socket(IP,PORT);
		System.out.println("-----------1 Iniciando la comunicación--------");
		
		//Flujos de comunicacion
		BufferedReader entrada= new BufferedReader(new InputStreamReader(clientSeSocket.getInputStream()));
		PrintWriter salida=new PrintWriter(clientSeSocket.getOutputStream(),true);
		
		salida.println("Platinium");
		
		String precio=entrada.readLine();
		System.out.println("El precio es ==> "+precio);
		
		System.out.println("-----------2 Finalizando comunicación--------");
		clientSeSocket.close();
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	
	public static void main(String[] args) {
		new Client();
		
	}
}	
