import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Definicoes definicoes = new Definicoes(
                "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\",
                "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\",
                "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\",
                "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\",
                ",",
                20,
                2,
                5.0,
                "admin123"
        );

        Clientes[] clientes = LeitorClientes.lerClientesDoFicheiro(definicoes.getCaminhoClientes(), definicoes.getSeparadorFicheiros());
        Prato[] pratos = LeitorPratos.lerPratosDoFicheiro(definicoes.getCaminhoPratos(), definicoes.getSeparadorFicheiros());
        Reservas[] reservas = LeitorReservas.lerReservasDoFicheiro(definicoes.getCaminhoReservas(), definicoes.getSeparadorFicheiros());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Array de opções do menu
        String[] opcoesMenu = {
                "1. Gerir Mesas",
                "2. Gerir Menus",
                "3. Registar Pedidos",
                "4. Consultar Estatísticas",
                "5. Configurações",
                "6. Iniciar Novo Dia",
                "7. Consultar Logs",
                "8. Sair"
        };

        while (running) {
            // Exibir o menu
            System.out.println("\n--- Menu Principal ---");
            for (String opcao : opcoesMenu) {
                System.out.println(opcao);
            }

            // Ler a escolha do usuário
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            // Executar a funcionalidade correspondente
            switch (escolha) {
                case 1:
                    gerirMesas(scanner);
                    break;
                case 2:
                    gerirMenus(scanner, pratos);
                    break;
                case 3:
                    registarPedidos(scanner);
                    break;
                case 4:
                    consultarEstatisticas();
                    break;
                case 5:
                    configurarAplicacao(scanner, definicoes);
                    break;
                case 6:
                    iniciarDia();
                    break;
                case 7:
                    consultarLogs();
                    break;
                case 8:
                    sair();
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void gerirMesas(Scanner scanner) {
        System.out.println("Gestão de Mesas ainda não implementada.");
    }

    private static void gerirMenus(Scanner scanner, Prato[] pratos) {
        menuPratos(scanner, pratos, pratos.length);
    }

    private static void registarPedidos(Scanner scanner) {
        System.out.println("Registo de Pedidos ainda não implementado.");
    }

    private static void consultarEstatisticas() {
        System.out.println("Consulta de Estatísticas ainda não implementada.");
    }

    private static void configurarAplicacao(Scanner scanner, Definicoes definicoes) {
        menuDefinicoes(scanner, definicoes);
    }

    private static void iniciarDia() {
        System.out.println("Iniciar Novo Dia ainda não implementado.");
    }

    private static void consultarLogs() {
        System.out.println("Consulta de Logs ainda não implementada.");
    }

    private static void sair() {
        System.out.println("Encerrando o sistema. Até logo!");
    }

    private static void menuDefinicoes(Scanner scanner, Definicoes definicoes) {
        System.out.print("Insira a senha para acessar as configurações: ");
        String senha = scanner.nextLine();

        if (!definicoes.validarSenha(senha)) {
            System.out.println("Senha incorreta! Retornando ao menu principal.");
            return;
        }
        boolean sair = false;

        while (!sair) {
            System.out.println("\n====== Menu de Definições ======");
            System.out.println("1. Alterar Caminho dos Ficheiros");
            System.out.println("2. Alterar Separador dos Ficheiros");
            System.out.println("3. Alterar Unidades de Tempo do Dia");
            System.out.println("4. Alterar Tempo de Espera do Cliente");
            System.out.println("5. Alterar Custo por Cliente Não Atendido");
            System.out.println("6. Alterar Senha");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Alterar caminho dos ficheiros
                    System.out.println("Escolha o ficheiro para alterar o caminho:");
                    System.out.println("1. Caminho dos Clientes");
                    System.out.println("2. Caminho dos Pratos");
                    System.out.println("3. Caminho das Reservas");
                    System.out.print("Escolha uma opção: ");
                    int escolhaFicheiro = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    switch (escolhaFicheiro) {
                        case 1:
                            System.out.print("Digite o novo caminho para os clientes: ");
                            String novoCaminhoClientes = scanner.nextLine();
                            definicoes.setCaminhoClientes(novoCaminhoClientes);
                            System.out.println("Caminho dos clientes atualizado.");
                            break;
                        case 2:
                            System.out.print("Digite o novo caminho para os pratos: ");
                            String novoCaminhoPratos = scanner.nextLine();
                            definicoes.setCaminhoPratos(novoCaminhoPratos);
                            System.out.println("Caminho dos pratos atualizado.");
                            break;
                        case 3:
                            System.out.print("Digite o novo caminho para as reservas: ");
                            String novoCaminhoReservas = scanner.nextLine();
                            definicoes.setCaminhoReservas(novoCaminhoReservas);
                            System.out.println("Caminho das reservas atualizado.");
                            break;
                        default:
                            System.out.println("Opção inválida. Retornando ao menu de definições.");
                    }
                    break;

                case 2:
                    System.out.print("Digite o novo separador dos ficheiros: ");
                    String novoSeparador = scanner.nextLine();  // Leitura do novo separador
                    definicoes.setSeparadorFicheiros(novoSeparador);  // Atualiza o separador
                    System.out.println("Separador dos ficheiros atualizado.");
                    break;

                case 3:
                    System.out.print("Digite as novas unidades de tempo do dia: ");
                    int novasUnidadesTempo = scanner.nextInt();  // Leitura do novo número de unidades de tempo
                    scanner.nextLine(); // Consumir a nova linha
                    definicoes.setUnidadesTempoDia(novasUnidadesTempo);  // Atualiza as unidades de tempo
                    System.out.println("Unidades de tempo do dia atualizadas.");
                    break;

                case 4:
                    System.out.print("Digite o novo tempo de espera do cliente: ");
                    int novoTempoEspera = scanner.nextInt();  // Leitura do novo tempo de espera
                    scanner.nextLine(); // Consumir a nova linha
                    definicoes.setTempoEsperaCliente(novoTempoEspera);  // Atualiza o tempo de espera
                    System.out.println("Tempo de espera do cliente atualizado.");
                    break;

                case 5:
                    System.out.print("Digite o novo custo por cliente não atendido: ");
                    double novoCusto = scanner.nextDouble();  // Leitura do novo custo
                    scanner.nextLine(); // Consumir a nova linha
                    definicoes.setCustoClienteNaoAtendido(novoCusto);  // Atualiza o custo por cliente não atendido
                    System.out.println("Custo por cliente não atendido atualizado.");
                    break;

                case 6:
                    System.out.print("Digite a senha atual: ");
                    String senhaAtual = scanner.nextLine();  // Leitura da senha atual
                    System.out.print("Digite a nova senha: ");
                    String novaSenha = scanner.nextLine();  // Leitura da nova senha

                    if (definicoes.alterarPassword(senhaAtual, novaSenha)) {  // Verifica se a senha foi alterada com sucesso
                        System.out.println("Senha alterada com sucesso.");
                    } else {
                        System.out.println("Senha atual incorreta. Não foi possível alterar.");
                    }
                    break;

                case 7:
                    System.out.println("Saindo do menu de definições.");
                    sair = true;  // Sai do menu de configurações
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }
    }

    private static void menuPratos(Scanner scanner, Prato[] pratos, int numeroPratos) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n====== Gerir Menus ======");
            System.out.println("1. Listar Pratos");
            System.out.println("2. Alterar Disponibilidade de um Prato");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    GestorPratos.listarPratos(pratos, numeroPratos);
                    break;
                case 2:
                    GestorPratos.alterarDisponibilidadePrato(scanner, pratos, numeroPratos); // Ensure this method is defined
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
