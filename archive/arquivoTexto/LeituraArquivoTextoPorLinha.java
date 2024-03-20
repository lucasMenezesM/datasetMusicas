package arquivos_texto;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeituraArquivoTextoPorLinha {
	public static void main(String[] args) {

		FileReader arquivoTextoLeitura = null;
		BufferedReader leituraBufferizada = null;

		System.out.printf("\nConteúdo do arquivo texto:\n");
		try {
			arquivoTextoLeitura = new FileReader("/home/fabio/ownCloud/IFF/Disciplinas/Nova Técnicas de Programação - BSI/workspaceTP4_18/Tp_Bsi_2021_2/src/arquivos_texto/tabuada7.txt");
			leituraBufferizada = new BufferedReader(arquivoTextoLeitura);
			String linhaLidaDoArquivo = leituraBufferizada.readLine(); // lê a primeira linha
			while (linhaLidaDoArquivo != null) {
				System.out.printf("%s\n", linhaLidaDoArquivo);
				linhaLidaDoArquivo = leituraBufferizada.readLine(); // lê da segunda até a última linha
			}
		} catch (FileNotFoundException e) {
			System.out.printf("Erro no nome do arquivo: %s.\n", e.getMessage());
		} catch (IOException e) {
			System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		System.out.println();	
		try {
			arquivoTextoLeitura.close();
		} catch (IOException e) {
			System.out.printf("Erro de E/S no fechamento do arquivo: %s.\n", e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.printf("Erro de apontamento para null: %s.\n", e.getMessage());
		}
	}
}
