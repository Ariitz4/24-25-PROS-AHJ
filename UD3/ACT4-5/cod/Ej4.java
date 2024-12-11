package cod;


import java.net.URI;
import java.net.URISyntaxException;

public class Ej4 {


	public static void main(String[] args) {
		try {
			Visualizar(new URI("http://docs.oracle.com"));
			Visualizar(new URI("http://docs.oracle.com/javase/7"));
			Visualizar(new URI("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html"));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
	

	private static void Visualizar(URI uri) {
		System.out.println("URI: "+uri);
		System.out.println("\tHost: "+uri.getHost());
		System.out.println("\tPort: "+uri.getPort());
		System.out.println("\tPath: "+uri.getPath());
		System.out.println("\tScheme: "+uri.getScheme());
		System.out.println("\tAuthority: "+uri.getAuthority());
	}

}
