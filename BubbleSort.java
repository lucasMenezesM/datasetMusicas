public class BubbleSort implements Ordenador {

    @Override
    public void ordenar(ColecaoDeMusicas colecao) {
        //por vendas
        int quantidadeMusicas = colecao.obterTotalMusicas();

        for(int i = 0 ; i< quantidadeMusicas - 1 ; i++){
            for(int j = 0; j < quantidadeMusicas - i - 1; j++){
                Musica musicaEsquerda = colecao.obterMusica(j);
                Musica musicaDireita = colecao.obterMusica(j + 1);

                if(Integer.valueOf(musicaEsquerda.getSales()) > Integer.valueOf(musicaDireita.getSales())){
                    colecao.trocarPosicaoMusicas(i, i+1);
                }
            }
        }
    }
}
