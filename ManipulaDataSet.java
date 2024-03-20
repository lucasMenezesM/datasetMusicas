import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.io.FileWriter;

public class ManipulaDataSet {

    // MÉTODO DE LEITURA DO ARQUIVO
    public static void lerDoArquivoCSV(ColecaoDeMusicas colecao, String caminhoArquivoCsv){
        FileReader arquivoLeitura = null;
        int quantidadeMusicas = 0;
        BufferedReader leituraBufferizada = null;

        try{
            arquivoLeitura = new FileReader(caminhoArquivoCsv);
            leituraBufferizada = new BufferedReader(arquivoLeitura);

            String linhaArquivo = leituraBufferizada.readLine();
            
            //? ************** ADIÇÃO DAS MÚSICAS ********************
            Boolean skip;
            while(linhaArquivo != null){
                skip = false;
                ArrayList<String> elementosDaMusica = new ArrayList<>(Arrays.asList(linhaArquivo.split(",\"")));
                if(elementosDaMusica.size() < 8){
                    skip = true;
                }
                
                for(String elemento : elementosDaMusica){
                    if(elemento.trim().equals("\"0\"") || elemento.trim().equals("0\"")){
                        skip = true;
                        break;
                    }
                }

                if(skip == true){
                    linhaArquivo = leituraBufferizada.readLine();
                    continue;
                }
                    
                Musica novaMusica = new Musica(elementosDaMusica.get(0), elementosDaMusica.get(1), elementosDaMusica.get(2), elementosDaMusica.get(3), elementosDaMusica.get(4), elementosDaMusica.get(7));
                
                colecao.adicionarMusica(novaMusica);

                quantidadeMusicas++;
                linhaArquivo = leituraBufferizada.readLine();
            }
            
            System.out.printf("a leitura foi finalizada com %d musicas\n", quantidadeMusicas);

        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    // MÉTODO DE ESCRITA NO ARQUIVO
    public static void escreverNoArquivoCSV(ColecaoDeMusicas colecao, String caminho){
        FileWriter novoArquivo;
        
        ArrayList<Musica> listaMusicas = new ArrayList<>();

        for(int i =0; i < colecao.obterTotalMusicas(); i++){
            listaMusicas.add(colecao.obterMusica(i));
        }
        // System.out.println("Musica aleatória: "+colecao.obterMusica(50).getTitle());
        System.out.println("Quantidade de músicas adicionadas: "+ listaMusicas.size());

        try{
            novoArquivo = new FileWriter(caminho, true);
            novoArquivo.write("Listas de músicas: \n\n");
            for(Musica musica : listaMusicas){
                novoArquivo.write(musica.getArtist()+" | ");
                novoArquivo.write(musica.getTitle()+" | ");
                novoArquivo.write(musica.getYear()+" | ");
                novoArquivo.write(musica.getSales()+" | ");
                novoArquivo.write(musica.getRating()+" | ");
                novoArquivo.write(musica.getStreams()+"\n");
            }

            novoArquivo.flush();
	        novoArquivo.close();

            System.out.println("Escrita realizada com sucesso.");
        }catch(IOException e){
            System.out.println("Falha na escrita do arquivo: "+e.getMessage());
        }
    }
}


