package cod;

import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;


public class Actividad2 {


	private final static int PORT = 21;
	

	private final static String USER = "dinux";
	

	private final static String PASSWORD = "dinux";
	

	private final static String SERVIDOR = "172.20.14.137";
	

	public static void main(String[] args) {
		FTPClient ftpClient = new FTPClient();
		try {
            System.out.println("Nos conectamos a " + SERVIDOR);
            ftpClient.connect(SERVIDOR, PORT);
            if (ftpClient.login(USER, PASSWORD)) {
                System.out.println("Login correcto");
                System.out.println("Directorio actual: " + ftpClient.printWorkingDirectory());


                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);


                String baseFolder = "aplicacionwebgonzalezrey";
                boolean createdBase = ftpClient.makeDirectory(baseFolder);
                boolean createdHtml = ftpClient.makeDirectory(baseFolder + "/html");
                boolean createdImagenes = ftpClient.makeDirectory(baseFolder + "/imagenes");
                boolean createdCss = ftpClient.makeDirectory(baseFolder + "/css");

                if (createdBase && createdHtml && createdImagenes && createdCss) {
                    System.out.println("Directorios creados...");
                } else {
                    System.out.println("NO SE HAN PODIDO CREAR LOS DIRECTORIOS");
                }

                if (ftpClient.logout()) {
                    System.out.println("Logout del servidor FTP....");
                } else {
                    System.out.println("Error al hacer logout");
                }
            } else {
                System.out.println("Login incorrecto...");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Desconectado...");
                }
            } catch (IOException e) {
                System.out.println("Error al desconectar: " + e.getMessage());
                e.printStackTrace();
            }
        }
	}
}
