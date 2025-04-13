import java.util.Scanner;

public class MainYsa {
    public static void main(String[] args) {

        IEstruturaDinamica fila = new FilaDinamica();
        Scanner scanner = new Scanner(System.in);
        int respostaUsuario;

        System.out.println("Bem-vindo à Clínica Saúde Viva!");
        System.out.println("Escolha uma das opções para gerenciar a fila de pacientes:");
        do {
            System.out.println();
            System.out.println(
                    "1 - Organizar agendamentos em ordem alfabética (A-Z)"
                            + "\n2 - Organizar agendamentos em ordem alfabética (Z-A)"
                            + "\n3 - Verificar quantidade de pacientes agendados"
                            + "\n4 - Ver primeiro paciente da fila"
                            + "\n5 - Ver último paciente da fila"
                            + "\n6 - Cancelar todos os agendamentos"
                            + "\n7 - Exibir lista completa de agendamentos"
                            + "\n8 - Encerrar expediente"
            );
            //Validação para verificar se o usuário colocará o tipo de variável correta (Valor inteiro)
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                scanner.next(); // consome o texto errado
                System.out.print("Digite uma opção: ");
            }

            respostaUsuario = scanner.nextInt();
            scanner.nextLine();

            switch(respostaUsuario){
                case 1:
                    System.out.println("Organizando agendamentos em ordem alfabética (A-Z)...");
                    fila.ordenarCrescente();
                    break;

                case 2:
                    System.out.println("Organizando agendamentos em ordem alfabética (Z-A)...");
                    fila.ordenarDecrescente();
                    break;

                case 3:
                    System.out.println("Verificando quantidade de pacientes agendados...");
                    fila.quantidadeElementos();
                    break;

                case 4:
                    System.out.println("Primeiro paciente da fila:");
                    fila.obterPrimeiroElemento();
                    break;

                case 5:
                    System.out.println("Último paciente da fila:");
                    fila.obterUltimoElemento();
                    break;

                case 6:
                    System.out.println("Cancelando todos os agendamentos...");
                    fila.limpar();
                    break;

                case 7:
                    System.out.println("Exibindo lista completa de pacientes agendados:");
                    fila.exibir();
                    break;

                case 8:
                    System.out.println("Encerrando expediente. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma das opções do menu.");
                    break;

            }
        }while (respostaUsuario != 8);

    }
}