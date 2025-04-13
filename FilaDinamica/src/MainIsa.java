import java.util.Scanner;

public class MainIsa {
    public static void main(String[] args) {

        IEstruturaDinamica fila = new FilaDinamica();
        Scanner scanner = new Scanner(System.in);
        int resp;

        System.out.println("Bem-vindo à Clínica Saúde Viva!");
        System.out.println("Escolha uma das opções para gerenciar a fila de pacientes:");
        do {
            System.out.println();
            System.out.println(
                    "1 - Agendar novo paciente"
                            + "\n2 - Agendar lista de pacientes"
                            + "\n3 - Chamar próximo paciente para consulta"
                            + "\n4 - Chamar vários pacientes para consulta"
                            + "\n5 - Remover paciente específico da lista"
                            + "\n6 - Verificar se um paciente está agendado"
                            + "\n7 - Atualizar nome de um paciente"
                            + "\n8 - Exibir lista completa de agendamentos"
                            + "\n9 - Encerrar expediente"
            );

            // Validação: verifica se é um número inteiro
            //caso a pessoa digite uma string, etc
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                scanner.next(); // consome o texto errado
                System.out.print("Digite uma opção: ");
            }

            resp = scanner.nextInt();
            scanner.nextLine();

            switch(resp){
                case 1:
                    System.out.println("Agendando novo paciente...");
                    String elemento = scanner.next();
                    fila.inserirElemento(elemento);
                    break;

                case 2:
                    System.out.println("Agendando lista de pacientes..." +
                            "\nLembre-se de separar por vírgula");
                    String elementos = scanner.nextLine();
                    fila.inserirSequencia(elementos);
                    break;

                case 3:
                    System.out.println("Chamando o próximo paciente para consulta... ");
                    fila.removerElemento();
                    break;

                case 4:
                    System.out.println("Chamando vários pacientes para consulta..." +
                            "\nInforme quantos serão chamados");
                    int numElementos = scanner.nextInt();
                    fila.removerSequencia(numElementos);
                    break;

                case 5:
                    System.out.println("Removendo paciente específico da lista de agendamentos..." +
                            "\nPaciente: ");
                    String ocorrencia = scanner.next();
                    fila.removerTodasOcorrencias(ocorrencia);
                    break;

                case 6:
                    System.out.println("Verificando se o paciente está agendado...");
                    String buscar = scanner.next();
                    fila.buscarElemento(buscar);
                    break;

                case 7:
                    System.out.println("Atualizando cadastro do paciente..." +
                            "\nNome do paciente atual: ");
                    String pacAtual = scanner.next();
                    System.out.println("Atualizar paciente para: ");
                    String pacNovo = scanner.next();

                    fila.editarElemento(pacAtual,pacNovo);
                    break;

                case 8:
                    System.out.println("Exibindo lista completa de pacientes agendados:");
                    fila.exibir();
                    break;

                case 9:
                    System.out.println("Encerrando expediente. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma das opções do menu.");
                    break;

            }
        }while (resp != 9);

    }
}
