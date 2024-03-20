package arquivos_texto;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscritaArquivoTextoPorString {

	public static void main(String[] args) throws IOException {
	    Scanner leitorDoTeclado = new Scanner(System.in);
	    int multiplicando, multiplicador;
	    String nomeDoArquivo = "/home/fabio/ownCloud/IFF/Disciplinas/Nova Técnicas de Programação - BSI/workspaceTP4_18/TP_BSI_2022_2/src/arquivos_texto/tabuada.txt";
	    FileWriter arquivoTextoEscrita = new FileWriter(nomeDoArquivo, true);
	    
	    System.out.printf("Informe o multiplicando para a formação da tabuada:\n");
	    multiplicando = leitorDoTeclado.nextInt();
	    arquivoTextoEscrita.write("+--Resultado--+\n");
	    for (multiplicador=1; multiplicador<=10; multiplicador++) {
	      arquivoTextoEscrita.write("| ");
	      arquivoTextoEscrita.write(Integer.toString(multiplicador));
	      arquivoTextoEscrita.write(" * ");
	      arquivoTextoEscrita.write(Integer.toString(multiplicando));
	      arquivoTextoEscrita.write(" = ");
	      arquivoTextoEscrita.write(Integer.toString(multiplicando *  multiplicador));
	      arquivoTextoEscrita.write("\n");
	    }
	    arquivoTextoEscrita.write("+-------------+\n");
	    System.out.printf("\nTabuada do %d foi gravada com sucesso em \"%s\".\n", multiplicando, nomeDoArquivo);
	    arquivoTextoEscrita.flush();
	    arquivoTextoEscrita.close();
	  }
}