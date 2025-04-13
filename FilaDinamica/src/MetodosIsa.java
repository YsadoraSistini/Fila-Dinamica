public class MetodosIsa implements IEstruturaDinamicaIsa {
    private No primeiro;
    private No ultimo;
    String SemElemento = "Não existe pacientes na lista";


    public MetodosIsa() {
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
            this.ultimo.setProx(novo);
            novo.setAnterior(this.ultimo);
            this.ultimo = novo;

        }

        System.out.println("Paciente "+ultimo.getConteudo() +" agendada");
    }

    @Override
    public void inserirSequencia(String elementos) {//"isa,bely,joao"

        int indiceInicioProxString = 0;

        for (int i = 0; i < elementos.length(); i++) {
            if (elementos.charAt(i) == ',') {

                String elemento = "";


                for (int j = indiceInicioProxString; j < i; j++) {
                    elemento += elementos.charAt(j);
                }

                elemento = removerEspacosLaterais(elemento);
                inserirElemento(elemento);
                indiceInicioProxString = i + 1;
            }
        }

        String ultimo = "";

        for (int j = indiceInicioProxString; j < elementos.length(); j++) {
            ultimo += elementos.charAt(j);
        }

        if (ultimo.length() > 0) {
            ultimo = removerEspacosLaterais(ultimo);
            inserirElemento(ultimo);
        }
    }

    public String removerEspacosLaterais(String texto) {
        int inicio = 0;
        int fim = texto.length() - 1;

        while (inicio <= fim && texto.charAt(inicio) == ' ') {
            inicio++;
        }

        while (fim >= inicio && texto.charAt(fim) == ' ') {
            fim--;
        }

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
            if (this.primeiro == this.ultimo) {
                this.primeiro = null;
                this.ultimo = null;
                System.out.println("Paciente chamado para consulta");

            } else {
                System.out.println("Paciente chamado para consulta: " + primeiro.getConteudo());
                this.primeiro = nova.getProx();
                this.primeiro.setAnterior(null);
            }

            return true;
        }
    }

    @Override
    public void removerSequencia(int elementos) {

        int removidos = 0;

        while (removidos < elementos && !estaVazia()) {
            removerElemento();
            removidos++;
        }
        if (removidos < elementos) {
            System.out.println(removidos + " pacientes estavam na fila.");
        } else {
            System.out.println("Todos os " + elementos + " pacientes foram chamados.");
        }
    }

    @Override
    public void removerTodasOcorrencias(String elemento) {
        if (estaVazia()) {
            System.out.println(SemElemento);
            return;
        }
        No atual = this.primeiro;

        while (atual != null) {
            No proximo = atual.getProx();


            if (atual.getConteudo().equalsIgnoreCase(elemento)) {
                No anterior = atual.getAnterior();


                if (anterior == null) {
                    this.primeiro = proximo;

                    if (proximo != null) {
                        proximo.setAnterior(null);
                    }else {
                        this.ultimo = null;
                    }
                }
                else if (proximo == null) {
                    this.ultimo = anterior;
                    anterior.setProx(null);
                }
                else {
                    anterior.setProx(proximo);
                    proximo.setAnterior(anterior);
                }

                System.out.println("Paciente chamado para consulta: " + atual.getConteudo());
            }
            atual = proximo;
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
}
