package cod;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class Ej5 {


	public static void main(String[] args) {
		System.out.println("Conexión con www.vitoria-gasteiz.com");
		System.out.println("==========================");
		try {
			HttpClient client= HttpClient.newHttpClient();
			HttpRequest request=HttpRequest.newBuilder(new URI("http://www.vitoria-gasteiz.com")).build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			VisualizarConexión(response);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	

	private static void VisualizarConexión(HttpResponse<String> response) {
		System.out.println("\tMétodo toString():"+response);
		System.out.println("\tMétodo getStatusCode():"+response.statusCode());
		System.out.println("\tMétodo getContentType():"+response.headers().firstValue("Content-Type").orElse("N/A"));
	}

}
