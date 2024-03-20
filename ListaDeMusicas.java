public class ListaDeMusicas implements ColecaoDeMusicas  {
    int quantidadeMusicas;
    No noInicial;

    public ListaDeMusicas(){
        this.quantidadeMusicas = 0;
        noInicial = null;
    }

    @Override
    public void adicionarMusica(Musica musica) {
        No novoNo = new No(musica);
        if(this.noInicial == null){
            this.noInicial = novoNo;
            quantidadeMusicas++;
            return;
        }

        novoNo.setProximo(this.noInicial);
        this.noInicial = novoNo;
        quantidadeMusicas++;
    }

    @Override
    public void alterarMusica(int posicaoMusica, Musica novaMusica) {
        if(!validarPosicao(posicaoMusica)){
            System.out.println("Posição inválida");
            return;
        }

        this.obterMusica(posicaoMusica).setArtist(novaMusica.getArtist());
        this.obterMusica(posicaoMusica).setTitle(novaMusica.getTitle());
        this.obterMusica(posicaoMusica).setStreams(novaMusica.getStreams());
        this.obterMusica(posicaoMusica).setSales(novaMusica.getSales());
        this.obterMusica(posicaoMusica).setRating(novaMusica.getRating());
        this.obterMusica(posicaoMusica).setYear(novaMusica.getYear());
    }

    @Override
    public void excluirMusica(String nomeMusica) {
        // if(this.noInicial.getMusica().getTitle().equalsIgnoreCase(nomeMusica)){
        //     this.noInicial = this.noInicial.getProximo();
        //     this.quantidadeMusicas--;
        //     return;
        // }

        // No noAnterior = null;
        // No noAtual = noInicial;
        // Boolean musicaEncontrada = false;

        // while(!noAtual.getMusica().getTitle().toLowerCase().equalsIgnoreCase(nomeMusica)){
        //     noAnterior = noAtual;
        //     noAtual = noAtual.getProximo();
        //     if(noAtual.getMusica().getTitle().toLowerCase().equalsIgnoreCase(nomeMusica)){
        //         musicaEncontrada = true;
        //     }
        // }

        // if(!musicaEncontrada){
        //     System.out.println("Musica não encontrada");
        //     return;
        // }

        // this.quantidadeMusicas--;
        // noAnterior.setProximo(noAtual.getProximo());
        // noAtual.setProximo(null);

        if (this.noInicial.getMusica().getTitle().equalsIgnoreCase(nomeMusica)) {
            this.noInicial = this.noInicial.getProximo();
            this.quantidadeMusicas--;
            return;
        }
    
        No noAnterior = null;
        No noAtual = this.noInicial;
        Boolean musicaEncontrada = false;
    
        while (noAtual != null && !noAtual.getMusica().getTitle().equalsIgnoreCase(nomeMusica)) {
            noAnterior = noAtual;
            noAtual = noAtual.getProximo();
            if (noAtual != null && noAtual.getMusica().getTitle().equalsIgnoreCase(nomeMusica)) {
                musicaEncontrada = true;
            }
        }
    
        if (!musicaEncontrada || noAtual == null) {
            System.out.println("Música não encontrada");
            return;
        }
    
        this.quantidadeMusicas--;
        if (noAnterior != null) {
            noAnterior.setProximo(noAtual.getProximo());
            noAtual.setProximo(null);
        }
    }

    @Override
    public Musica obterMusica(int posicao) {
        if(this.noInicial == null){
            System.out.println("A lista está vazia");
            return null;
        }
        if(posicao == 0){
            return noInicial.getMusica();
        }
        if(posicao > quantidadeMusicas || posicao < 0){
            System.out.println("Posição inválida.");
            return null;
        }

        No novoNo = noInicial;
        for(int i = 0; i < posicao; i++){
            novoNo = novoNo.getProximo();
        }

        return novoNo.getMusica();
    }

    @Override
    public int obterTotalMusicas() {
        return this.quantidadeMusicas;
    }

    @Override
    public void trocarPosicaoMusicas(int posicao1, int posicao2) {
        if (posicao1 == posicao2) {
            return;
        }
    
        No noAnterior1 = null;
        No noAtual1 = this.noInicial;
        for (int i = 0; i < posicao1 && noAtual1 != null; i++) {
            noAnterior1 = noAtual1;
            noAtual1 = noAtual1.getProximo();
        }
    
        No noAnterior2 = null;
        No noAtual2 = this.noInicial;
        for (int i = 0; i < posicao2 && noAtual2 != null; i++) {
            noAnterior2 = noAtual2;
            noAtual2 = noAtual2.getProximo();
        }
    
        if (noAtual1 == null || noAtual2 == null) {
            System.out.println("Posições inválidas");
            return;
        }
    
        Musica musicaTemp = noAtual1.getMusica();
        noAtual1.setMusica(noAtual2.getMusica());
        noAtual2.setMusica(musicaTemp);
    }

    public No obterNo(int posicao){
        if(this.noInicial == null){
            System.out.println("A lista está vazia");
            return null;
        }
        if(posicao == 0){
            return noInicial;
        }
        if(posicao > quantidadeMusicas || posicao < 0){
            System.out.println("Posição inválida.");
            return null;
        }

        No novoNo = noInicial;
        for(int i = 0; i < posicao; i++){
            novoNo = novoNo.getProximo();
        }

        return novoNo;
    }
    
    public boolean validarPosicao(int posicao){
        return !(posicao > this.quantidadeMusicas || posicao < 0);
    }
}
