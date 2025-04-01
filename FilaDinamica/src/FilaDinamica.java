import java.util.List;

public class FilaDinamica implements IEstruturaDinamica{
    private No primeiro;
    Object[] elementos;

    public FilaDinamica(Object elemento){
        this.primeiro = new No(elemento);
    }

    @Override
    public void inserirElemento(Object elemento) {
        No novo = new No(elemento);

        if (estaVazia()){
            this.primeiro = novo;
        }else {
            No atual = primeiro;
            while (atual.getProx() != null){
                atual = atual.getProx();
            }
                atual.setProx(novo);
        }
        System.out.println("Conteudo Adicionado");
    }

    @Override
    public void inserirSequencia(Object elementos) {
        Object[] listaElementos = (Object[]) elementos;

        //percorre
        for (Object elemento : listaElementos){//cria a variavel elemento, ai para cada elemento dentro de elementoS, faça algo....
            inserirElemento(elemento);
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()){
            System.out.println("Fila Vazia");
            return false;
        }else{
            this.primeiro = null;
            primeiro = primeiro.getProx();
            System.out.println("Conteudo removido");
            return true;
        }
    }

    @Override
    public void removerSequencia(Object elementos) {
        List<Object> listaElementos = (List<Object>) elementos;

        for(Object elemento : listaElementos){
            removerElemento();
        }

    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {

    }

    @Override
    public boolean estaCheia() {
        return false;
    }

    @Override
    public boolean estaVazia() {
        if(this.primeiro == null){
            return true;

        }else {
            return false;
        }
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        return false;
    }

    @Override
    public void ordenarCrescente() {

    }

    @Override
    public void ordenarDecrescente() {

    }

    @Override
    public int quantidadeElementos() {
        return 0;
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {

    }

    @Override
    public void limpar() {

    }

    @Override
    public void exibir() {

    }

    @Override
    public No obterPrimeiroElemento() {
        return null;
    }

    @Override
    public No obterUltimoElemento() {
        return null;
    }
}
