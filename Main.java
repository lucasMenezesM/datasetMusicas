import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;

class Main{
    public static void main(String[] args){
        String filePath = "A:\\Conteudo Faculdade\\3º Período\\Técnicas de programação\\leituraArquivos\\Song.csv";
        String newFilePath = "A:\\Conteudo Faculdade\\3º Período\\Técnicas de programação\\leituraArquivos\\musicas.txt";

        FileReader arquivoLeitura = null;
        int quantidadeMusicas = 0;
        BufferedReader leituraBufferizada = null;
        ArrayList<String[]> listaMusicas = new ArrayList<>();
        
        FileWriter novoArquivo;
        
        try{
            arquivoLeitura = new FileReader(filePath);
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
                    
                String musicaAtual[] = new String[6];
                
                musicaAtual[0] = elementosDaMusica.get(0);
                musicaAtual[1] = elementosDaMusica.get(1);
                musicaAtual[2] = elementosDaMusica.get(2);
                musicaAtual[3] = elementosDaMusica.get(3);
                musicaAtual[4] = elementosDaMusica.get(4);
                musicaAtual[5] = elementosDaMusica.get(7);
                
                listaMusicas.add(musicaAtual);
                quantidadeMusicas++;
                linhaArquivo = leituraBufferizada.readLine();
            }
            
            imprimirMusicas(listaMusicas);
            
            System.out.printf("a leitura foi finalizada com %d musicas\n", quantidadeMusicas);

        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }

        try{
            if(arquivoLeitura != null){
            arquivoLeitura.close();
            }
        }catch(IOException e){
            System.out.println("Falha no fechamento do arquivo. "+ e.getMessage());
        }

        //? ************ ESCRITA DO ARQUIVO **************
        try{
            novoArquivo = new FileWriter(newFilePath, true);
            novoArquivo.write("Listas de músicas: \n\n");
            for(String[] musica : listaMusicas){
                novoArquivo.write(musica[0]+" | ");
                novoArquivo.write(musica[1]+" | ");
                novoArquivo.write(musica[2]+" | ");
                novoArquivo.write(musica[3]+" | ");
                novoArquivo.write(musica[4]+" | ");
                novoArquivo.write(musica[5]+"\n");
            }

            novoArquivo.write("\n\n Total de musicas: "+quantidadeMusicas);
            
            novoArquivo.flush();
	        novoArquivo.close();

            System.out.println("Escrita realizada com sucesso. Número de músicas: "+quantidadeMusicas);
        }catch(IOException e){
            System.out.println("Falha na escrita do arquivo: "+e.getMessage());
        }
    }

    public static void imprimirMusicas(ArrayList<String[]> listaDeMusicas){
        for(String[] musica : listaDeMusicas){
            for(String item : musica){
                System.out.printf("%s | ", item);
            }
            System.out.println();
        }
    }
}