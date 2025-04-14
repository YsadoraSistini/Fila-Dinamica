import java.util.ArrayList;
import java.util.List;

public class FilaDinamica implements IEstruturaDinamica {
    private No primeiro;
    private No ultimo;
    String SemElemento = "Não existe pacientes na lista";


    public FilaDinamica() {
        this.primeiro = null;
        this.ultimo = null;
    }

    @Override
    public void inserirElemento(String elemento) {
        No novo = new No(elemento);

        if (estaVazia()) {
            this.primeiro = novo;
            this.ultimo = novo;

        } else {
//            No atual = primeiro;
//            while (atual.getProx() != null){
//                atual = atual.getProx();
//            }
//                atual.setProx(novo);
            this.ultimo.setProx(novo);
            novo.setAnterior(this.ultimo);
            this.ultimo = novo;

        }

        System.out.println("Paciente "+ultimo.getConteudo() +" agendada");
    }

//    @Override
//    public void inserirSequencia(String... elementos) {
//        String[] listaElementos = elementos;
//
//        //percorre
//        for (String elemento : listaElementos) {//cria a variavel elemento, ai para cada elemento dentro de listaElementos, faça algo....
//            inserirElemento(elemento);
//        }
//    }

    @Override
    public void inserirSequencia(String elementos) {//"isa,bely,joao"

        int indiceInicioProxString = 0; // Marca o início de cada palavra dentro da string | 	Índice de onde começa a próxima palavra

        // Percorre a string inteira, caractere por caractere
        //i - indice atual
        //Ex: foi passado uma string com 13 elementos
        //ent vai do 0 ao 12
        for (int i = 0; i < elementos.length(); i++) {
            //Percorre até achar uma virgula
            if (elementos.charAt(i) == ',') { // Se achar uma vírgula

                String elemento = ""; // Variável temporária para montar a palavra | String montada

                // Percorre do início até a vírgula, montando a palavra manualmente
                for (int j = indiceInicioProxString; j < i; j++) {
                    // Esse for pega cada letra da posição inicioSubstring até i
                    // (onde está a vírgula) e vai montando a palavra caractere por caractere.
                    //: se inicioSubstring = 0 e i = 3
                    //→ ele monta "isa" (letras de 0 a 2)
                    elemento += elementos.charAt(j); // Vai somando letra por letra
                }

                elemento = removerEspacosLaterais(elemento);

                //Chama o método que insere a palavra montada na fila. (O metodo de cima)
                inserirElemento(elemento); // Insere a palavra na fila

                indiceInicioProxString = i + 1; // Move o início para depois da vírgula
                //ou seja, Se i = 3, agora indiceInicioProxString = 4
                //Próxima palavra começará a ser capturada a partir de elementos.charAt(4) = 'b'
            }
        }

        // Após o loop, ainda falta o último elemento (que não termina com vírgula)
        String ultimo = ""; //Vai captura a ultima palavra

        //Pega as letras do final da última vírgula até o fim da string
        for (int j = indiceInicioProxString; j < elementos.length(); j++) {
            //Exemplo (inicioSubstring = 9)
            ultimo += elementos.charAt(j);//então vai montar joao
        }

        // Se o último não estiver vazio, insere também
        if (ultimo.length() > 0) {
            ultimo = removerEspacosLaterais(ultimo); // remove os espaços antes de inserir
            inserirElemento(ultimo);
        }
    }

    public String removerEspacosLaterais(String texto) {
        int inicio = 0;
        int fim = texto.length() - 1;

        // Avança o índice de início até o primeiro caractere não-espaço
        while (inicio <= fim && texto.charAt(inicio) == ' ') {
            inicio++;
        }

        // Regride o índice de fim até o último caractere não-espaço
        while (fim >= inicio && texto.charAt(fim) == ' ') {
            fim--;
        }

        // Constrói a nova string "limpa"
        String resultado = "";
        for (int i = inicio; i <= fim; i++) {
            resultado += texto.charAt(i);
        }

        return resultado;
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) {
            System.out.println(SemElemento);
            return false;
        } else {
            No nova = this.primeiro;
            // Se só tem UM paciente na fila
            if (this.primeiro == this.ultimo) {
                this.primeiro = null;
                this.ultimo = null;
                System.out.println("Paciente chamado para consulta");

            } else {
                System.out.println("Paciente chamado para consulta: " + primeiro.getConteudo());

                // Caso tenha mais de um paciente
                this.primeiro = nova.getProx();
                this.primeiro.setAnterior(null);
            }

            return true;
        }
    }

    @Override
    public void removerSequencia(int elementos) {

        int removidos = 0;

        // Enquanto houver pacientes na fila e não atingiu a quantidade desejada
        while (removidos < elementos && !estaVazia()) {
            removerElemento(); // Remove o primeiro da fila
            removidos++;
        }

        // Caso o usuário peça para remover mais do que há na fila
        if (removidos < elementos) {
            System.out.println(removidos + " pacientes estavam na fila.");
        } else {
            System.out.println("Todos os " + elementos + " pacientes foram chamados.");
        }
    }

    //Falta fazer
    @Override
    public void removerTodasOcorrencias(String elemento) {
        if (estaVazia()) {
            System.out.println(SemElemento);
            return;
        }
            No atual = this.primeiro;

            while (atual != null) {//enquanto tiver elemento na lista
                No proximo = atual.getProx();


                if (atual.getConteudo().equalsIgnoreCase(elemento)) {//verifica se o conteudo atual é igual ao passado
//                    System.out.println("Executando..");
                    No anterior = atual.getAnterior();


                    // Se o elemento passado for o primeiro nó da lista
                    if (anterior == null) {
                        this.primeiro = proximo;//O novo primeiro se torna o proximo

                        if (proximo != null) { //se o prox conter conteudo
                            proximo.setAnterior(null);//então o anterior dele recebe null
                        }else { //se for o ultimo elemento da lista
                            this.ultimo = null; // Lista fica vazia após remoção do único elemento
                        }
                    }

                    // Se for o último nó da lista
                    else if (proximo == null) {
                        this.ultimo = anterior;//o ultimo vai se tornar o anterior do atual porque o atual vai ser removido
                        //se o anterior do atual tiver conteudo
                            anterior.setProx(null);//o no atual se torna null
                    }
                    // Nó do meio
                    else {
                        anterior.setProx(proximo);
                        proximo.setAnterior(anterior);
                    }

                    System.out.println("Paciente chamado para consulta: " + atual.getConteudo());

//                    atual = proximo; // Faz o apontamento do próximo após remoção
                }
                    atual = proximo; // Continua se não for para remover
//                if (atual != null) {
//                    System.out.println("Novo atual " + atual.getConteudo());
//                }else {
//                    System.out.println("Novo atual " + atual);
//
//                }

        }
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
    public boolean buscarElemento(String elemento) {
        if (estaVazia()) {
            System.out.println(SemElemento);
            return false;
        } else {
            No atual = this.primeiro;

            while (atual != null) {
                if (atual.getConteudo().equalsIgnoreCase(elemento)) {
                    System.out.println("Paciente: " + atual.getConteudo() + " encontrado(a)");
                    return true;
                }
                atual = atual.getProx();
            }
            System.out.println("Paciente não encontrado!");
            return false;

        }
    }



    @Override
    public void editarElemento(String elementoAntigo, String elementoNovo) {
        if (buscarElemento(elementoAntigo)) {
            No atual = this.primeiro;
            while (atual != null) {
                if (atual.getConteudo().equalsIgnoreCase(elementoAntigo)) {
                    atual.setConteudo(elementoNovo);
                    System.out.println("Atualizado para: " + atual.getConteudo());
                    return;
                }
                atual = atual.getProx();
            }
        }

    }


    // IMPLEMENTAÇÕES YSADORA

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
        System.out.println("Fila em ordenação crescente:");
        exibir();
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
        System.out.println("Fila em ordenação decrescente:");
        exibir();
    }

}

