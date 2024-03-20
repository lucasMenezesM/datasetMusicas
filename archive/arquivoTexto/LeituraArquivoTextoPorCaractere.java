package arquivos_texto;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeituraArquivoTextoPorCaractere {
	public static void main(String[] args) {

		FileReader arquivoTexto = null;
		

		System.out.printf("\nConteúdo do arquivo texto:\n");
		try {
			arquivoTexto = new FileReader("/home/fabio/ownCloud/IFF/Disciplinas/Nova Técnicas de Programação - BSI/workspaceTP4_18/Tp_Bsi_2021_2/src/arquivos_texto/tabuada2.txt");		
			int caractere = arquivoTexto.read();
			while (caractere != -1) {
				System.out.printf("%c", caractere);
				caractere = arquivoTexto.read(); // lê da segunda até a última linha
			}
		} catch (FileNotFoundException e) {
			System.out.printf("Erro no nome do arquivo: %s.\n", e.getMessage());
		} catch (IOException e) {
			System.out.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		
		System.out.println();	
		try {
			arquivoTexto.close();
		} catch (IOException e) {
			System.out.printf("Erro de E/S no fechamento do arquivo: %s.\n", e.getMessage());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.printf("Erro de apontamento para null: %s.\n", e.getMessage());
		}
	}
}
