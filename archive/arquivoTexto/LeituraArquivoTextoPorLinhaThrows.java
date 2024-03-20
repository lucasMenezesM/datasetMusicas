package arquivos_texto;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeituraArquivoTextoPorLinhaThrows {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.printf("\nConteúdo do arquivo texto:\n");
		FileReader arquivoTextoLeitura = new FileReader("/home/fabio/ownCloud/IFF/Disciplinas/Nova Técnicas de Programação - BSI/workspaceTP4_18/TP_BSI_2022_2/src/arquivos_texto/tabuada.txt");
		BufferedReader leituraBufferizada = new BufferedReader(arquivoTextoLeitura);
		String linhaLidaDoArquivo = leituraBufferizada.readLine(); // lê a primeira linha
		while (linhaLidaDoArquivo != null) {
			System.out.printf("%s\n", linhaLidaDoArquivo);
			linhaLidaDoArquivo = leituraBufferizada.readLine(); // lê da segunda até a última linha
		}
		System.out.println();	
		arquivoTextoLeitura.close();
	}
}
