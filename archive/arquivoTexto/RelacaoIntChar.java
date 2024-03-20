package arquivos_texto;

public class RelacaoIntChar {
	public static void main(String[] args) {
		int valorDoPrimeiroCaractere = 65;
		char primeiroCaractere = (char)valorDoPrimeiroCaractere;

		System.out.println(valorDoPrimeiroCaractere);
		System.out.println(primeiroCaractere);

		int valorDoSegundoCaractere = 'B';
		char segundoCaractere = (char)valorDoSegundoCaractere;
				
		System.out.println(valorDoSegundoCaractere);
		System.out.println(segundoCaractere);
		
		System.out.printf("Segundo caractere: %c\n", valorDoSegundoCaractere);
		System.out.printf("Segundo caractere: %d\n", valorDoSegundoCaractere);
		
		System.out.printf("Segundo caractere: %c\n", segundoCaractere);
		System.out.printf("Segundo caractere: %d\n", (int)segundoCaractere);
	}
}
