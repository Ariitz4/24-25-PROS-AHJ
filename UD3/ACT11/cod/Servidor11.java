package cod;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor11 {


	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(6000);
			while(true) {
				Socket s=new Socket();
				s=server.accept();
				HiloServidor hilo=new HiloServidor(s);
				hilo.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
