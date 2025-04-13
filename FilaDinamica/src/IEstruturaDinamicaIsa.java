public interface IEstruturaDinamicaIsa {
    void inserirElemento(String elemento);
    void inserirSequencia(String elementos);
    boolean removerElemento();
    void removerSequencia(int elementos);
    void removerTodasOcorrencias(String elemento);
    boolean estaVazia();
    boolean buscarElemento(String elemento);
    void editarElemento(String elementoAntigo, String elementoNovo);

}
