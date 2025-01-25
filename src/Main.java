import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Definicoes definicoes = new Definicoes(
                "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\Clientes.txt",
                "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\Pratos.txt",
                "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\Reservas.txt",
                ",",
                20,
                2,
                5.0,
                "admin123"
        );

        // Leitura inicial de clientes e pratos
        Clientes[] clientes = LeitorClientes.lerClientesDoFicheiro(definicoes.getCaminhoClientes(), definicoes.getSeparadorFicheiros());
        Prato[] pratos = LeitorPratos.lerPratosDoFicheiro(definicoes.getCaminhoPratos(), definicoes.getSeparadorFicheiros());
        Reservas[] reservas = LeitorReservas.lerReservasDoFicheiro(definicoes.getCaminhoReservas(), definicoes.getSeparadorFicheiros());


        Scanner scanner = new Scanner(System.in); // Scanner único para o programa
        boolean sair = false;

        // Menu inicial
        while (!sair) {
            System.out.println("\n====== Ritotech ======");
            System.out.println("1. Começar o Dia");
            System.out.println("2. Definições");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcaoInicial = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcaoInicial) {
                case 1:
                    menuPratos(scanner, pratos, pratos.length);
                    break;

                case 2:
                    menuDefinicoes(scanner, definicoes);
                    // Atualizar leitura de clientes e pratos após mudanças
                    clientes = LeitorClientes.lerClientesDoFicheiro(definicoes.getCaminhoClientes(), definicoes.getSeparadorFicheiros());
                    pratos = LeitorPratos.lerPratosDoFicheiro(definicoes.getCaminhoPratos(), definicoes.getSeparadorFicheiros());
                    break;

                case 3:
                    System.out.println("Encerrando o sistema. Até logo!");
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }

        scanner.close(); // Scanner fechado aqui, uma única vez
    }

    private static void exibirMenuPrincipal(Scanner scanner, Prato[] pratos, int numeroPratos, GestaoMesas gestaoMesas) {
        while (true) {
            System.out.println("\nGestão de Restaurante");
            System.out.println("1. Gerir Mesas");
            System.out.println("2. Gerir Menus");
            System.out.println("3. Gerir Dia-a-Dia");
            System.out.println("4. Consultar Estatísticas");
            System.out.println("5. Configurações");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    gestaoMesas.exibirMenuMesas(scanner);
                    break;
                case 2:
                    menuPratos(scanner, pratos, numeroPratos);
                    break;
                case 3:
                    System.out.println("Gerenciamento do Dia-a-Dia ainda não implementado.");
                    break;
                case 4:
                    System.out.println("Consulta de Estatísticas ainda não implementada.");
                    break;
                case 5:
                    System.out.println("Configurações ainda não implementadas.");
                    break;
                case 6:
                    System.out.println("Saindo do sistema. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
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
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    listarPratos(pratos, numeroPratos);
                    break;
                case 2:
                    alterarDisponibilidadePrato(scanner, pratos, numeroPratos);
                    break;
                case 3:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private static void listarPratos(Prato[] pratos, int numeroPratos) {
        if (numeroPratos == 0) {
            System.out.println("Nenhum prato cadastrado.");
        } else {
            System.out.println("\nLista de Pratos:");
            for (int i = 0; i < numeroPratos; i++) {
                Prato prato = pratos[i];
                System.out.printf("Prato %d: Nome: %s | Categoria: %s | Preço de Custo: %.2f | Preço de Venda: %.2f | Tempo de Preparo: %d minutos | Disponível: %s\n",
                        i + 1, prato.getNomePrato(), prato.getCategoria(),
                        prato.getPrecoCusto(), prato.getPrecoVenda(),
                        prato.getTempoPreparo(), (prato.isDisponivel() ? "Sim" : "Não"));
            }
        }
    }

 Definições+Leitura_de_clientes_e_pratos
              
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
    }

    public static void menuDefinicoes(Scanner scanner, Definicoes definicoes) {
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
                    System.out.print("Digite o caminho para os pratos: ");
                    String novoCaminho = scanner.nextLine();
                    definicoes.setCaminhoPratos(novoCaminho);
                    System.out.println("Digite o caminho para os clientes: ");
                    String novoCamminho2 = scanner.nextLine();
                    definicoes.setCaminhoClientes(novoCamminho2);

                    System.out.println("Caminho dos ficheiros atualizado.");
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
}



    private static void alterarDisponibilidadePrato(Scanner scanner, Prato[] pratos, int numeroPratos) {
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
    }
}

