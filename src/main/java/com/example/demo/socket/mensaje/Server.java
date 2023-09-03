package com.example.demo.socket.mensaje;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
				
				System.out.println("----------------1 Iniciando server socket--->>>CARBAJAL<<<< ------------");
				System.out.println("----------------2 A la espera del clientSocket----------");
				clienteSocket=serverSocket.accept(); //La espera a un cliente
				System.out.println("----------------3 Llegó el clienteSocket----------");
				
				
				//Flujos de comunicacion
				BufferedReader entrada= new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
				PrintWriter salida=new PrintWriter(clienteSocket.getOutputStream(),true);
				
				String opcion= entrada.readLine();
				System.out.println("-----3 Llego la opcion "+opcion+"--------------");
				switch (opcion) {
				case "Platea":salida.println("PEN 50");break;
				case "Vip": salida.println("PEN 100");break;
				case "Platinium":salida.println("PEN 150");break;
				}
				
				
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
