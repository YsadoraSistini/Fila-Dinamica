import java.util.ArrayList;
import java.util.List;

public class FilaDinamica implements IEstruturaDinamica {
    private No primeiro;
    private No ultimo;
    String SemElemento = "Não existe elementos na lista";


    public FilaDinamica(String elemento) {
        this.primeiro = new No(elemento);
        this.ultimo = this.primeiro;
    }

    @Override
    public void inserirElemento(String elemento) {
        No novo = new No(elemento);

        if (estaVazia()) {
            this.primeiro = novo;
        } else {
            No atual = primeiro;
            this.ultimo.setProx(novo);

//            while (atual.getProx() != null){
//                atual = atual.getProx();
//            }
//                atual.setProx(novo);
        }
        this.ultimo = novo;
        System.out.println("Conteudo Adicionado");
    }

    @Override
    public void inserirSequencia(String... elementos) {
        String[] listaElementos = elementos;

        //percorre
        for (String elemento : listaElementos) {//cria a variavel elemento, ai para cada elemento dentro de listaElementos, faça algo....
            inserirElemento(elemento);
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) {
            System.out.println(SemElemento);
            return false;
        } else {
            No nova = this.primeiro;
            this.primeiro = null;
            primeiro = nova.getProx();
            System.out.println("Conteudo removido");
            return true;
        }
    }

    @Override
    public void removerSequencia(Number... elementos) {
        Number[] listaElementos = elementos;
        if (estaVazia()) {
            System.out.println(SemElemento);
        } else {
            for (Number elemento : listaElementos) {
                removerElemento();
            }
        }
    }

    //Falta fazer
    @Override
    public void removerTodasOcorrencias(String elemento) {
        if (estaVazia()) {
            System.out.println("Lista vazia!");
        } else {

        }
    }

    @Override
    public boolean estaCheia() {
        if (!estaVazia()) {
            No atual = this.primeiro;
            while (atual != null) {
                atual = atual.getProx();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean estaVazia() {
        if (this.primeiro.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean buscarElemento(String elemento) {
        if (estaVazia()) {
            System.out.println(SemElemento);
            return false;
        } else {
            No atual = this.primeiro;

            while (atual != null) {
                if (atual.getConteudo().equals(elemento)) {
                    System.out.println("Elemento: " + atual.getConteudo() + " encontrado");
                    return true;
                }
                atual = atual.getProx();
            }
            System.out.println("Conteúdo não encontrado!");
            return false;

        }
    }

    @Override
    public void ordenarCrescente() {
        if (estaVazia() || this.primeiro.getProx() == null) return;

        boolean trocou;
        do {
            trocou = false;
            No atual = this.primeiro;

            while (atual.getProx() != null){
                No proximo = atual.getProx();

                if (atual.getConteudo().compareToIgnoreCase(proximo.getConteudo()) > 0){

                    String TrocaDeElementos = atual.getConteudo();
                    atual.setConteudo(proximo.getConteudo());
                    proximo.setConteudo(TrocaDeElementos);
                    trocou = true;

                }
                atual = atual.getProx();
            }
            
        }while (trocou);
    }

    @Override
    public void ordenarDecrescente() {
        if (estaVazia() || this.primeiro.getProx() == null) return;

        boolean trocou;
        do {
            trocou = false;
            No atual = this.primeiro;

            while (atual.getProx() != null){
                No proximo = atual.getProx();

                if (atual.getConteudo().compareToIgnoreCase(proximo.getConteudo()) < 0){

                    String TrocaDeElementos = atual.getConteudo();
                    atual.setConteudo(proximo.getConteudo());
                    proximo.setConteudo(TrocaDeElementos);
                    trocou = true;

                }
                atual = atual.getProx();
            }

        }while (trocou);
    }

    @Override
    public int quantidadeElementos() {
        No atual = this.primeiro;
        int contador = 0;
        while (atual != null) {
            contador++;
            atual = atual.getProx();
        }
        System.out.println("A lista contém " + contador + " elementos");
        return contador;
    }

    @Override
    public void editarElemento(String elementoAntigo, String elementoNovo) {
        if (buscarElemento(elementoAntigo)) {
            No atual = this.primeiro;
            while (atual != null) {
                if (atual.getConteudo() == elementoAntigo) {
                    atual.setConteudo(elementoNovo);
                    System.out.println("Atualizado para: " + atual.getConteudo());
                    return;
                }
                atual = atual.getProx();
            }
        }

    }


    @Override
    public void limpar() {
        if (estaVazia()) {
            System.out.println(SemElemento);
        } else {
            No atual = this.primeiro;
            while (atual != null) {
                atual.setConteudo(null);
                atual = atual.getProx();
            }
            System.out.println("Ocorrências apagadas");

        }
    }

    @Override
    public void exibir() {
        if (estaVazia()) {
            System.out.println(SemElemento);
        } else {
            No atual = this.primeiro;
            while (atual != null) {
                System.out.println(atual.getConteudo());
                atual = atual.getProx();
            }
        }
    }

    @Override
    public No obterPrimeiroElemento() {
        if (estaVazia()) {
            System.out.println(SemElemento);
        } else {
            System.out.println(this.primeiro.getConteudo());
        }
        return null;
    }

    @Override
    public No obterUltimoElemento() {
        if (estaVazia()) {
            System.out.println(SemElemento);
        } else {
            System.out.println(this.ultimo.getConteudo());
        }
        return ultimo;
    }
}