package cod;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class Servidor10 {
	

	final static int puertoServ = 12348;


	public static void main(String[] args) {
		try {
			DatagramSocket socket=new DatagramSocket(puertoServ);
			System.out.println("Esperando datagrama.......");
			byte[] buffer = new byte[1024];
            DatagramPacket paqueteRecibe = new DatagramPacket(buffer, buffer.length);
            socket.receive(paqueteRecibe);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(paqueteRecibe.getData());
            ObjectInputStream objectIn = new ObjectInputStream(byteIn);
            Tenista t = (Tenista) objectIn.readObject();
            System.out.println("Recibo el objeto: "+t.getApellido()+" "+t.getAltura());
            System.out.println("IP de origen: "+paqueteRecibe.getAddress());
            System.out.println("Puerto de origen: "+paqueteRecibe.getPort());
            t.setApellido("Karlovic");
            t.setAltura(208);
            System.out.println("Envío el objeto: "+t.getApellido()+" "+t.getAltura());
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream objectOut = new ObjectOutputStream(byteOut);
            objectOut.writeObject(t);
            byte[] dataToSend = byteOut.toByteArray();
            DatagramPacket paqueteManda = new DatagramPacket(dataToSend, dataToSend.length, paqueteRecibe.getAddress(), paqueteRecibe.getPort());
            socket.send(paqueteManda);
            System.out.println("Fin del servidor");
            socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}

