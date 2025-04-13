import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IEstruturaDinamica fila = new FilaDinamica();
        Scanner scanner = new Scanner(System.in);

        int resp;

//        "1-Inserir" +
//                "\n2-Inserir elementos sequencialmente" +
//                "\n3-Remover" +
//                "\n4-Remover elementos sequencialmente" +
//                "\n5-Remover Ocorrências" +
//                "\n6-Realizar busca" +
//                "\n7-Realizar edição" +
//                "\n8-Realizar ordenação crescente" +
//                "\n9-Realizar ordenação decrescente" +
//                "\n10-Verificar a quantidade de elemento" +
//                "\n11-Verificar o primeiro elemento" +
//                "\n12-Verificar o segundo elemento" +
//                "\n13-Limpar lista" +
//                "\n14-Exibir lista" +
//                "\n15-Sair");

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
                            + "\n8 - Organizar agendamentos em ordem alfabética (A-Z)"
                            + "\n9 - Organizar agendamentos em ordem alfabética (Z-A)"
                            + "\n10 - Verificar quantidade de pacientes agendados"
                            + "\n11 - Ver primeiro paciente da fila"
                            + "\n12 - Ver último paciente da fila"
                            + "\n13 - Cancelar todos os agendamentos"
                            + "\n14 - Exibir lista completa de agendamentos"
                            + "\n15 - Encerrar expediente"
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
                    System.out.println("Organizando agendamentos em ordem alfabética (A-Z)...");
                    fila.ordenarCrescente();
                    break;

                case 9:
                    System.out.println("Organizando agendamentos em ordem alfabética (Z-A)...");
                    fila.ordenarDecrescente();
                    break;

                case 10:
                    System.out.println("Verificando quantidade de pacientes agendados...");
                    fila.quantidadeElementos();
                    break;

                case 11:
                    System.out.println("Primeiro paciente da fila:");
                    fila.obterPrimeiroElemento();
                    break;

                case 12:
                    System.out.println("Último paciente da fila:");
                    fila.obterUltimoElemento();
                    break;

                case 13:
                    System.out.println("Cancelando todos os agendamentos...");
                    fila.limpar();
                    break;

                case 14:
                    System.out.println("Exibindo lista completa de pacientes agendados:");
                    fila.exibir();
                    break;

                case 15:
                    System.out.println("Encerrando expediente. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma das opções do menu.");
                    break;

            }
        }while (resp != 15);

    }
}