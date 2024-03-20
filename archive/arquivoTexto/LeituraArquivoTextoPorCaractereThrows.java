package arquivos_texto;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LeituraArquivoTextoPorCaractereThrows  {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.printf("\nConteúdo do arquivo texto:\n");
		FileReader arquivoTexto = new FileReader("/home/fabio/ownCloud/IFF/Disciplinas/Nova Técnicas de Programação - BSI/workspaceTP4_18/TP_BSI_2022_2/src/arquivos_texto/tabuada.txt");		
		int caractere = arquivoTexto.read();
		while (caractere != -1) {
			System.out.printf("%c", caractere);
			caractere = arquivoTexto.read();
		}
		System.out.println();	
		arquivoTexto.close();
	}
}
