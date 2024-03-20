public interface ColecaoDeMusicas {

  public void adicionarMusica(Musica musica);  
  public void excluirMusica(String nomeDaMusica);
  public Musica obterMusica(int posicao);
  public int obterTotalMusicas();
  public void trocarPosicaoMusicas(int posicao1, int posicao2);
  public void alterarMusica(int posicaoMusica, Musica novaMusica);
} 
