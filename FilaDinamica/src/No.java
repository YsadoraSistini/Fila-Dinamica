public class No implements INo{
        private No prox;
        private No anterior;
        private String conteudo;

        public No (String conteudo){
            this.conteudo = conteudo;
            this.prox = null;
            this.anterior = null; // Inicialmente não há nó anterior, pq o nó anterior aponte para o novo nó como próximo.(Novo no NULL)
        }


    @Override
    public No getProx() {
        return prox;
    }

    @Override
    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public String getConteudo() {
        return conteudo;
    }

    @Override
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public No getAnterior() {
        return anterior;
    }

    @Override
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
}
