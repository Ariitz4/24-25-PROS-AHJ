package cod;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class Cliente10 {
	
	final static int puertCli=12348;
	
	final static int puertServ=34567;
	

	public static void main(String[] args) {
		try {
			Tenista t=new Tenista("del Potro", 198);
			DatagramSocket clientSocket=new DatagramSocket(puertCli);
			InetAddress serverAddress = InetAddress.getByName("localhost");
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(byteOut);
			oos.writeObject(t);
			byte[] dataToSend = byteOut.toByteArray();
			DatagramPacket paqueteManda = new DatagramPacket(dataToSend, dataToSend.length, serverAddress, 12348);
			clientSocket.send(paqueteManda);
			System.out.println("Envío el objeto: "+t.getApellido()+" "+t.getAltura());
			System.out.println("Esperando datagrama.......");
			byte[] buffer = new byte[1024];
	        DatagramPacket paqueteRecibe = new DatagramPacket(buffer, buffer.length);
	        clientSocket.receive(paqueteRecibe);
	        ByteArrayInputStream byteIn = new ByteArrayInputStream(paqueteRecibe.getData());
            ObjectInputStream objectIn = new ObjectInputStream(byteIn);
            t=(Tenista) objectIn.readObject();
            System.out.println("He recibido el objeto: "+t.getApellido()+" "+t.getAltura());
            System.out.println("Fin del cliente");
            clientSocket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
