import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Caminho do ficheiro
        String filePath = "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\Clientes.txt";

        String filePath1 = "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\Pratos.txt";

        // Carregar os clientes do ficheiro usando a classe LeitorClientes
        Clientes[] clientes = LeitorClientes.lerClientesDoFicheiro(filePath);
        int numeroClientes = clientes.length;

        Prato[] pratos = LeitorPratos.lerPratosDoFicheiro(filePath1);
        int numeroPratos  = pratos.length;

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

        String[] nomePrato = new String[numeroPratos];
        double[] precosCusto = new double[numeroPratos];
        String[] categorias = new String[numeroPratos];
        double[] precosVenda = new double[numeroPratos];
        int[] temposPreparo = new int[numeroPratos];
        boolean[] disponiveis = new boolean[numeroPratos];

        for (int i = 0; i < numeroPratos; i++) {
            Prato prato = pratos[i]; // Obtemos o prato atual do array

            nomePrato[i] = prato.getNomePrato();
            precosCusto[i] = prato.getPrecoCusto();
            categorias[i] = prato.getCategoria();
            precosVenda[i] = prato.getPrecoVenda();
            temposPreparo[i] = prato.getTempoPreparo();
            disponiveis[i] = prato.isDisponivel();
        }




        Scanner scanner = new Scanner(System.in);
                boolean sair = false;

                while (!sair) {
                    System.out.println("\n====== Menu de Pratos ======");
                    System.out.println("1. Listar Pratos.txt");
                    System.out.println("2. Alterar Disponibilidade de um Prato");
                    System.out.println("3. Sair");
                    System.out.print("Escolha uma opção: ");

                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            if (numeroPratos == 0) {
                                System.out.println("Nenhum prato cadastrado.");
                            } else {
                                System.out.println("\nLista de Pratos.txt:");
                                for (int i = 0; i < numeroPratos; i++) {
                                    Prato prato = pratos[i];
                                    System.out.printf("Prato %d: Nome: %s | Categoria: %s | Preço de Custo: %.2f | Preço de Venda: %.2f | Tempo de Preparo: %d minutos | Disponível: %s\n",
                                            i + 1, prato.getNomePrato(), prato.getCategoria(),
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
