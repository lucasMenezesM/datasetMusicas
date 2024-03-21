public class VetorDeMusicas implements ColecaoDeMusicas{
    private int quantidadeMusicas;
    private Musica[] musicas;

    public VetorDeMusicas(){
        this.quantidadeMusicas = 0;
        this.musicas = new Musica[quantidadeMusicas];
    }

    public void setQuantidadeMusicas(int quantidadeMusicas) {
        this.quantidadeMusicas = quantidadeMusicas;
    }

    public Musica[] getMusicas() {
        return musicas;
    }

    public void setMusicas(Musica[] musicas) {
        this.musicas = musicas;
    }

    @Override
    public void adicionarMusica(Musica musica) {
        Musica[] novoArray = new Musica[quantidadeMusicas + 1];
        for(int i = 0; i < quantidadeMusicas; i++){
            novoArray[i] = musicas[i];
        }
        novoArray[quantidadeMusicas] = musica;
        musicas = novoArray;
        quantidadeMusicas++;
    }

    @Override
    public void alterarMusica(int posicaoMusica, Musica novaMusica) {
        if(posicaoMusica < 0 || posicaoMusica > this.quantidadeMusicas){
            System.out.println("Posição invalida");
            return;
        }
        this.musicas[posicaoMusica] = novaMusica;
    }
    
    @Override
    public void excluirMusica(String nomeMusica) {
        Musica[] novasMusicas = new Musica[this.quantidadeMusicas - 1];
        Boolean excluida = false;
        for(int i = 0; i< quantidadeMusicas; i++){
            if(this.musicas[i].getTitle().toLowerCase() == nomeMusica.toLowerCase()){
                excluida = true;
                this.quantidadeMusicas--;
                continue;
            }
            if(i == quantidadeMusicas - 1){
                break;
            }
            novasMusicas[i] = this.musicas[i];
        }
        
        if(excluida){
            System.out.printf("A música %s foi excluída com sucesso.\n", nomeMusica);
            this.musicas = novasMusicas;
        }else{
            System.out.printf("A música %s não foi encontrada\n", nomeMusica);
        }
    }
    
    @Override
    public Musica obterMusica(int posicao) {
        return this.musicas[posicao];
    }
    
    @Override
    public int obterTotalMusicas() {
        return quantidadeMusicas;
    }
    
    @Override
    public void trocarPosicaoMusicas(int posicao1, int posicao2) {
        if(posicao1 < 0 || posicao2 <0 || posicao1 > this.quantidadeMusicas || posicao2 > this.quantidadeMusicas){
            System.out.println("Posição inválida.");
            return;
        }
        Musica aux;
        aux = this.musicas[posicao1];
        this.musicas[posicao1] = this.musicas[posicao2];
        this.musicas[posicao2] = aux;
    }

    @Override
    public void ordenar(Ordenador ordenador) {
        ordenador.ordenar(this);
    }

    
}
