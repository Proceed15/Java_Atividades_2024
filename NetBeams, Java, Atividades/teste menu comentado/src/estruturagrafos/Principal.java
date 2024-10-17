package estruturagrafos;
import java.io.IOException;

public class Principal {

	public static void main(String args[]) throws IOException {
		String path = "/tmp/file.txt";

		ManipuladorArquivo.escritor(path);
		ManipuladorArquivo.leitor(path);
	}

}