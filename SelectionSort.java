public class SelectionSort implements Ordenador {

    @Override
    public void ordenar(ColecaoDeMusicas colecao) {
        //ordem de lançamento
        int quantidadeMusicas = colecao.obterTotalMusicas();

        for(int i = 0; i < quantidadeMusicas - 1; i++){
            int menorIndice = i;

            for (int j = i + 1; j < quantidadeMusicas - i - 0; j++) {
                if (Integer.parseInt(colecao.obterMusica(j).getYear()) < Integer.parseInt(colecao.obterMusica(j+1).getYear())) {
                    menorIndice = j;
                }
            }

            colecao.trocarPosicaoMusicas(i, menorIndice);
        }
    }
    
}
