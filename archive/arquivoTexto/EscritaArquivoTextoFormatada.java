package arquivos_texto;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class EscritaArquivoTextoFormatada {

	public static void main(String[] args) throws IOException {
	    Scanner leitorDoTeclado = new Scanner(System.in);
	    int multiplicando, multiplicador;
	    String nomeDoArquivo = "/home/fabio/ownCloud/IFF/Disciplinas/Nova Técnicas de Programação - BSI/workspaceTP4_18/TP_BSI_2022_2/src/arquivos_texto/tabuada.txt";
	    FileWriter arquivoTextoEscrita = new FileWriter(nomeDoArquivo, true);
	    PrintWriter fluxoDeSaidaFormatado = new PrintWriter(arquivoTextoEscrita);

	    System.out.printf("Informe o multiplicando para a formação da tabuada:\n");
	    multiplicando = leitorDoTeclado.nextInt();
	    fluxoDeSaidaFormatado.printf("+--Resultado--+%n");
	    for (multiplicador=1; multiplicador<=10; multiplicador++) {
	      fluxoDeSaidaFormatado.printf("| %2d * %d = %2d |%n", multiplicador, multiplicando, (multiplicando *  multiplicador));
	    }
	    fluxoDeSaidaFormatado.printf("+-------------+%n");
	    System.out.printf("\nTabuada do %d foi gravada com sucesso em \"%s\".\n", multiplicando, nomeDoArquivo);
	    
	    fluxoDeSaidaFormatado.flush();
	    fluxoDeSaidaFormatado.close();
	  }
}