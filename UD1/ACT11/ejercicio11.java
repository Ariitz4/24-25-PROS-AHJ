
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejercicio11 {
	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		//  String comando="Notepad"; // en windows
		String comando="java code.Ejemplo2"; // en linux
		Process p;
		try {
			p = r.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader (new InputStreamReader(is));
			String linea;
			while((linea = br.readLine()) != null) // lee una linea
				System.out.println(linea);
			br.close();
		}catch (Exception e){
			
			System.out.println("error en:"+comando);
			e.printStackTrace();			
		}
	}	
}
