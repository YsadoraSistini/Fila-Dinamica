public class MetodosYsa implements IEstruturaDinamicaYsa{
    private No primeiro;
    private No ultimo;
    String SemElemento = "Não existe pacientes na lista";


    public MetodosYsa() {
        this.primeiro = null;
        this.ultimo = null;
    }

    @Override
    public boolean estaVazia() {
        if (this.primeiro == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean estaCheia(){
        if (!estaVazia()){
            No atual = this.primeiro;
            while (atual != null){
                atual = atual.getProx();
            }
            System.out.println("A Fila esta cheia!");
            return true;
        } return false;
    }

    @Override
    public void limpar(){
        if (estaVazia()){
            System.out.println(SemElemento);
        } else {
            No atual = this.primeiro; //Atual recebe o primeiro elemento (Para percorrer a fila corretamente)
            while (atual != null) {
                No proximo = atual.getProx(); // Guarda o próximo nó
                atual.setAnterior(null);      // Remove ligação com o anterior
                atual.setProx(null);          // Remove ligação com o próximo
                atual = proximo;              // Avança na lista
            }
            // Zera os ponteiros principais da fila
            this.primeiro = null;
            this.ultimo = null;
        }
        System.out.println("A Fila foi limpa");
    }

    @Override
    public void exibir(){
        if (estaVazia()){
            System.out.println(SemElemento);
        }else {
            No atual = this.primeiro;
            while (atual != null){
                System.out.println(atual.getConteudo());
                atual = atual.getProx();
            }
        }
    }

    @Override
    public int quantidadeElementos() {
        No atual = this.primeiro;
        int contador = 0;
        while (atual != null){
            contador++;
            atual = atual.getProx();
        }
        System.out.println("A fila contem " + contador + " elementos");
        return contador;
    }

    @Override
    public No obterPrimeiroElemento(){
        if (estaVazia()){
            System.out.println(SemElemento);
            return  null;
        } else {
            System.out.println("O primeiro elemento da fila é: " + this.primeiro.getConteudo());
            return this.primeiro;
        }
    }

    @Override
    public No obterUltimoElemento(){
        if(estaVazia()){
            System.out.println(SemElemento);
            return null;
        } else {
            System.out.println("O ultimo elemento da fila é: " + this.ultimo.getConteudo());
            return ultimo;
        }
    }

    @Override
    public void ordenarCrescente() {
        if (estaVazia() || this.primeiro.getProx() == null) return;

        boolean troca;
        do {
            //Variavel para verificar se a troca de elementantos para a ordenação crescente foi realizada
            troca = false;
            No atual = this.primeiro;

            while (atual.getProx() != null){
                No proximo = atual.getProx();
                // Compara se o conteúdo do nó atual é maior que o conteudo do proximo nó
                if (atual.getConteudo().compareToIgnoreCase(proximo.getConteudo()) > 0){

                    String TrocaDeElementos = atual.getConteudo(); //É usado uma varivael temporária para armazenar o conteúdo ndo nó atual
                    atual.setConteudo(proximo.getConteudo()); // O conteúdo do nó atual atualiza para o próximo nó
                    proximo.setConteudo(TrocaDeElementos); //O próximo nó recebe o conteúdo da variavel temporária que estava com o conteúdo do nó atual
                    troca = true; //Significa que houve a troca de elementos para ordenação

                }
                atual = atual.getProx();
            }

        }while (troca);
    }

    @Override
    public void ordenarDecrescente() {
        if (estaVazia() || this.primeiro.getProx() == null) return;

        boolean troca;
        do {
            troca = false;
            No atual = this.primeiro;

            while (atual.getProx() != null){
                No proximo = atual.getProx();
                // Compara se o conteúdo do nó atual é menor que o conteudo do proximo nó
                if (atual.getConteudo().compareToIgnoreCase(proximo.getConteudo()) < 0){

                    String TrocaDeElementos = atual.getConteudo();
                    atual.setConteudo(proximo.getConteudo());
                    proximo.setConteudo(TrocaDeElementos);
                    troca = true;

                }
                atual = atual.getProx();
            }

        }while (troca);
    }

}
