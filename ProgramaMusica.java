import java.util.Scanner;

public class ProgramaMusica {
    public static void main(String args[]){
        Scanner inputData = new Scanner(System.in);
        String filePath = "A:\\Conteudo Faculdade\\3º Período\\Técnicas de programação\\leituraArquivos\\Song.csv";
        String newFilePath = "A:\\Conteudo Faculdade\\3º Período\\Técnicas de programação\\leituraArquivos\\musicasNovas.txt";
        
        // ColecaoDeMusicas vetorMusicas = new VetorDeMusicas(); //vetor de músicas
        ColecaoDeMusicas colecaoMusicas = new ListaDeMusicas(); //lista encadeada

        // Musica musica1 = new Musica("1", "primeira musica", "test", "test", "test", "test");
        // Musica musica2 = new Musica("2", "segunda musica", "test2", "test2", "test2", "test2");
        // Musica musica3 = new Musica("2", "terceira musica", "test2", "test2", "test2", "test2");

        // lista.adicionarMusica(musica1);
        // lista.adicionarMusica(musica2);
        // lista.adicionarMusica(musica3);

        // lista.alterarMusica(2, new Musica("Musica Alterada", "Musica Alterada", "Musica Alterada", "Musica Alterada", "Musica Alterada", "Musica Alterada"));
        // listar(lista);
        // System.out.println("\nDepois da exclusão:\n");
        // lista.excluirMusica("terceira musica");
        

        // lista.excluirMusica(lista.obterMusica(0));
        // System.out.println("\n***** Depois da exclusão *****\n");
        // listar(lista);

        ManipulaDataSet.lerDoArquivoCSV(colecaoMusicas, filePath);
        System.out.println(colecaoMusicas.obterMusica(500).getTitle());
        listarMenu();
        int funcionalidade = inputData.nextInt();
        
        switch (funcionalidade) {
            case 1:
                inputData.nextLine();
                System.out.println("Digite as informações da nova música a seguir:\n");
                System.out.printf("Digite nome do artista: ");
                String artist = inputData.nextLine();

                System.out.printf("Digite nome do título: ");
                String title = inputData.nextLine();

                System.out.printf("Digite nome do ano: ");
                String year = inputData.nextLine();

                System.out.printf("Digite número de vendas: ");
                String sales = inputData.nextLine();

                System.out.printf("Digite o rating da música: ");
                String rating = inputData.nextLine();

                System.out.printf("Digite o número de streams da música: ");
                String streams = inputData.nextLine();

                Musica novaMusica = new Musica(artist, title, year, sales, rating, streams);
                colecaoMusicas.adicionarMusica(novaMusica);

                System.out.printf("Música %s adicionada!", novaMusica.getTitle());
                break;
            
            case 2:
                inputData.nextLine();
                System.out.println(funcionalidade+" selecionada");
                System.out.println("Digite o nome da música que deseja excluir");
                String musicaSelecionada = inputData.nextLine();

                System.out.println("Antes da exclusão: "+ colecaoMusicas.obterTotalMusicas());

                colecaoMusicas.excluirMusica(musicaSelecionada);

                System.out.println("Depois da exclusão: "+colecaoMusicas.obterTotalMusicas());

                break;

            case 3:
                System.out.println("Quais as posições que gostaria de trocar?");
                int posicao1 = inputData.nextInt();
                int posicao2 = inputData.nextInt();
                System.out.println(colecaoMusicas.obterMusica(posicao1).getTitle());
                System.out.println(colecaoMusicas.obterMusica(posicao2).getTitle());
                colecaoMusicas.trocarPosicaoMusicas(posicao1, posicao2);
                System.out.println(colecaoMusicas.obterMusica(posicao1).getTitle());
                System.out.println(colecaoMusicas.obterMusica(posicao2).getTitle());
                break;

            case 4:
                System.out.println("Qual a posição da música a ser alterada?");
                int posicaoAlteracao = inputData.nextInt();

                System.out.println("Digite as informações atualizadas a seguir:\n");

                System.out.printf("Digite nome do artista: ");
                String newArtist = inputData.nextLine();

                System.out.printf("Digite nome do título: ");
                String newTitle = inputData.nextLine();

                System.out.printf("Digite nome do ano: ");
                String newYear = inputData.nextLine();

                System.out.printf("Digite número de vendas: ");
                String newSales = inputData.nextLine();

                System.out.printf("Digite o rating da música: ");
                String newRating = inputData.nextLine();

                System.out.printf("Digite o número de streams da música: ");
                String newStreams = inputData.nextLine();

                Musica musicaAlterada = new Musica(newArtist, newTitle, newYear, newSales, newRating, newStreams);
                
                colecaoMusicas.alterarMusica(posicaoAlteracao, musicaAlterada);
                break;
        
            case 5:
                System.out.println("Programa finalizado.");
                break;

            default:
                System.out.println("Opção não reconhecida");
                break;
        }
       
        inputData.close();
        // listar(vetorMusicas);
        // System.out.println(vetorMusicas.getQuantidadeMusicas());

        // System.out.println(vetorMusicas.obterMusica(vetorMusicas.obterTotalMusicas() - 1).getTitle());
        ManipulaDataSet.escreverNoArquivoCSV(colecaoMusicas, newFilePath);
        System.out.println("quantidade: "+colecaoMusicas.obterTotalMusicas());
       
    }

    public static void listar(ColecaoDeMusicas colecao){
        if(colecao.obterTotalMusicas() == 0){
            System.out.println("A lista está vazia");
            return;
        }

        for(int i = 0; i < colecao.obterTotalMusicas() ; i++){
            System.out.println(colecao.obterMusica(i).getTitle());
        }
        System.out.println("Total de músicas: "+colecao.obterTotalMusicas());
    }
    
    public static void listarMenu(){
        System.out.println("\n*********Qual funcionalidade gostaria de executar?*********\n");
        System.out.println("1- Adição de músicas\n2- Exclusão de músicas\n3- Troca de posição de músicas\n4- Alterar uma música\n5- Finalizar programa");
    }
}
