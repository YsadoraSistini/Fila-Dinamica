public interface IEstruturaDinamica {

    void inserirElemento(String elemento);
    void inserirSequencia(String elementos);
    boolean removerElemento();
    void removerSequencia(int elementos);
    void removerTodasOcorrencias(String elemento);
    boolean estaVazia();
    boolean buscarElemento(String elemento);
    void editarElemento(String elementoAntigo, String elementoNovo);

    boolean estaCheia();
    void ordenarCrescente();
    void ordenarDecrescente();
    int quantidadeElementos();
    void limpar();
    void exibir();
    No obterPrimeiroElemento();
    No obterUltimoElemento();
}