package com.example.demo.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private final Integer PORT=13;
	
	public Server() {
		Socket clienteSocket;
		
		try {
			ServerSocket serverSocket= new ServerSocket(PORT);
			while(true) {
			//Bucle infinito
				
				System.out.println("----------------1 Iniciando server socket------------");
				System.out.println("----------------2 A la espera del clientSocket----------");
				clienteSocket=serverSocket.accept(); //La espera a un cliente
				System.out.println("----------------3 Llegó el clienteSocket----------");
				
				Thread.sleep(3000);//3 segundos
				
				clienteSocket.close();
				System.out.println("----------------4 Finalizar la atención clienteSocket----------");
			}
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}

}
