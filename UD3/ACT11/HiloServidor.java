package cod;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class HiloServidor extends Thread{
	

	private Socket s;
	

	public HiloServidor(Socket s) {
		this.s=s;
	}
	

	@Override
	public void run() {
		System.out.println("Cliente Conectado.....");
		try {
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			while(true) {
				String input=dis.readUTF();
				System.out.println("Comunico con: Socket[addr="+s.getInetAddress()+",port="+s.getPort()+",localport="+s.getLocalPort()+"]");
				input=input.toUpperCase();
				dos.writeUTF(input);
				if(input.equals("*")) {
					System.out.println("Fin de la conexión con: Socket[addr="+s.getInetAddress()+",port="+s.getPort()+",localport="+s.getLocalPort()+"]");
					break;
				}
			}
			dis.close();
			dos.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
