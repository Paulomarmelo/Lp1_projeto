import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Caminho do ficheiro
        String filePath = "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\Clientes.txt";

        // Carregar os clientes do ficheiro usando a classe LeitorClientes
        Clientes[] clientes = LeitorClientes.lerClientesDoFicheiro(filePath);
        int numeroClientes = clientes.length;

        String[] nomes = new String[numeroClientes];
        int[] numPessoas = new int[numeroClientes];
        int[] pedidosEntrada = new int[numeroClientes];
        int[] pedidosSobremesa = new int[numeroClientes];
        int[] maxUTentrar = new int[numeroClientes];
        int[] maxUTatendimento = new int[numeroClientes];
        int[] chegadaUT = new int[numeroClientes];


        for (int i = 0; i < numeroClientes; i++) {
            Clientes cliente = clientes[i];
            nomes[i] = cliente.getNomeReserva();
            numPessoas[i] = cliente.getNumPessoas();
            pedidosEntrada[i] = cliente.getPedidosEntrada();
            pedidosSobremesa[i] = cliente.getPedidosSobremesa();
            maxUTentrar[i] = cliente.getMaxUTentrar();
            maxUTatendimento[i] = cliente.getMaxUTatendimento();
            chegadaUT[i] = cliente.getChegadaUT();
        }


                Scanner scanner = new Scanner(System.in);
                Prato[] pratos = new Prato[10]; // Array fixo para até 10 pratos

                // Pré-carregar pratos
                pratos[0] = new Prato("Pão de alho", 1.40, "Entrada", 3.00, 1, true);
                pratos[1] = new Prato("Bacalhau com natas", 3.40, "Principal", 9.99, 3, true);
                pratos[2] = new Prato("Francesinha de frango", 4.50, "Principal", 11.00, 2, false);
                pratos[3] = new Prato("Francesinha de porco com ovo", 5.90, "Principal", 12.50, 2, true);
                pratos[4] = new Prato("Gelado de nata", 1.10, "Sobremesa", 3.00, 1, true);
                pratos[5] = new Prato("Bolo de bolacha", 2.10, "Sobremesa", 3.50, 2, true);
                int numeroPratos = 6; // Número inicial de pratos carregados

                boolean sair = false;

                while (!sair) {
                    System.out.println("\n====== Menu de Pratos ======");
                    System.out.println("1. Listar Pratos");
                    System.out.println("2. Alterar Disponibilidade de um Prato");
                    System.out.println("3. Sair");
                    System.out.print("Escolha uma opção: ");

                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    switch (opcao) {
                        case 1:
                            if (numeroPratos == 0) {
                                System.out.println("Nenhum prato cadastrado.");
                            } else {
                                System.out.println("\nLista de Pratos:");
                                for (int i = 0; i < numeroPratos; i++) {
                                    Prato prato = pratos[i];
                                    System.out.printf("Prato %d: Nome: %s | Categoria: %s | Preço de Custo: %.2f | Preço de Venda: %.2f | Tempo de Preparo: %d minutos | Disponível: %s\n",
                                            i + 1, prato.getNome(), prato.getCategoria(),
                                            prato.getPrecoCusto(), prato.getPrecoVenda(),
                                            prato.getTempoPreparo(), (prato.isDisponivel() ? "Sim" : "Não"));
                                }
                            }
                            break;

                        case 2:
                            if (numeroPratos == 0) {
                                System.out.println("Nenhum prato cadastrado.");
                            } else {
                                System.out.print("Digite o número do prato para alterar disponibilidade (1 a " + numeroPratos + "): ");
                                int numero = scanner.nextInt();

                                if (numero < 1 || numero > numeroPratos) {
                                    System.out.println("Número inválido.");
                                } else {
                                    Prato prato = pratos[numero - 1];
                                    System.out.println("O prato atualmente está " + (prato.isDisponivel() ? "disponível" : "indisponível") + ".");
                                    System.out.print("Digite a nova disponibilidade (true/false): ");
                                    boolean novaDisponibilidade = scanner.nextBoolean();
                                    prato.setDisponivel(novaDisponibilidade);
                                    System.out.println("Disponibilidade alterada com sucesso!");
                                }
                            }
                            break;

                        case 3:
                            System.out.println("Saindo do menu de pratos. Até logo!");
                            sair = true;
                            break;

                        default:
                            System.out.println("Opção inválida. Por favor, tente novamente.");
                            break;
                    }
                }

                scanner.close();
            }
        }
