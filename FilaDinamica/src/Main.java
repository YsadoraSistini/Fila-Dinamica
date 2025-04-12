public class Main {
    public static void main(String[] args) {

        IEstruturaDinamica fila = new FilaDinamica("Livia");

        fila.inserirElemento("Roberto");
        fila.inserirSequencia("Cristiane", "Vinicius");
        fila.inserirElemento("Ana");
        System.out.println("Antes da ordenação decrescente");
        fila.exibir();

        fila.ordenarDecrescente();
        System.out.println("Depois da ordenação decrescente");
        fila.exibir();
        fila.removerElemento();
        fila.removerSequencia(1,2);
        fila.exibir();
        fila.inserirSequencia("Lucas", "Jorge", "Zé", "Douglas", "Maria", "Ana");
        fila.exibir();



        fila.editarElemento("Douglas", "Ana");
        fila.exibir();

//        System.out.println("Ordenação Crescente");
//        fila.ordenarCrescente();
//        fila.exibir();

        fila.removerTodasOcorrencias("ana");
        fila.exibir();

        fila.buscarElemento("zé");
        fila.quantidadeElementos();
        fila.obterPrimeiroElemento();
        fila.obterUltimoElemento();
//        fila.exibir();
//        fila.exibir();

//


        fila.limpar();
        fila.exibir();

    }
}