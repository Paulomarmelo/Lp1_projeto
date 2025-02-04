import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorRestaurante {

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
    Reservas[] reservas = LeitorReservas.lerReservasDoFicheiro(definicoes.getCaminhoReservas(), definicoes.getSeparadorFicheiros());
    Mesa[] mesas = LeitorMesas.lerMesasDoFicheiro(definicoes.getCaminhoMesas(), definicoes.getSeparadorFicheiros());
    Prato[] prato = LeitorPratos.lerPratosDoFicheiro(definicoes.getCaminhoPratos(), definicoes.getSeparadorFicheiros());




    public static void listarClientes(Clientes[] clientes, Mesa[] mesas, int tempoAtual) {
        System.out.println("\n--- Lista de Clientes ---");
        for (Clientes cliente : clientes) {
            // Verifica se o cliente chegou ao restaurante
            if (cliente.getChegadaUT() <= tempoAtual) {
                boolean mesaAtribuida = false;
                for (Mesa mesa : mesas) {
                    // Verifica se a mesa está ocupada e se corresponde ao cliente
                    if (mesa.isOcupada() && mesa.getId() == cliente.getNumPessoas()) { // Supondo que o ID da mesa corresponda ao número de pessoas
                        mesaAtribuida = true;
                        break;
                    }
                }
                String estado = mesaAtribuida ? "Atendido" : "À espera";
                System.out.println("Cliente: " + cliente.getNomeReserva() + " | Estado: " + estado);
            }
        }
    }

    public static void avancarTempo(Definicoes definicoes, Clientes[] clientes, Mesa[] mesas, Prato[] pratos, int[] tempoAtual) {
        // Incrementa o tempo atual
        if (tempoAtual[0] < definicoes.getUnidadesTempoDia()) {
            tempoAtual[0]++;
            System.out.println("Tempo atual: " + tempoAtual[0]);

            // Notificar clientes que chegaram
            for (Clientes cliente : clientes) {
                if (cliente.getChegadaUT() == tempoAtual[0]) {
                    System.out.println("Notificação: Cliente " + cliente.getNomeReserva() + " chegou ao restaurante.");
                }
            }
        } else {
            System.out.println("O dia terminou.");
        }
    }



    public static void atribuirMesa(Clientes[] clientes, Mesa[] mesas, String nomeReserva, int numeroMesa, int tempoAtual) {
        // Encontra o cliente pelo nome da reserva
        for (Clientes cliente : clientes) {
            if (cliente.getNomeReserva().equals(nomeReserva)) {
                // Verifica se o tempo de espera excedeu o máximo permitido
                if (tempoAtual > cliente.getChegadaUT() + cliente.getMaxUTatendimento()) {
                    System.out.println("Não é possível atribuir a mesa ao cliente " + nomeReserva + " porque o tempo máximo de espera foi excedido.");
                    return;
                }

                // Encontra a mesa pelo número
                for (Mesa mesa : mesas) {
                    if (mesa.getId() == numeroMesa) {
                        // Verifica se a mesa está ocupada
                        if (!mesa.isOcupada()) {
                            // Verifica se a ação pode ser realizada
                            if (tempoAtual > mesa.getUltimaAcaoTempo()) {
                                mesa.setOcupada(true); // Marca a mesa como ocupada
                                mesa.setUltimaAcaoTempo(tempoAtual); // Atualiza o tempo da última ação
                                System.out.println("Mesa " + numeroMesa + " atribuída ao cliente " + nomeReserva);
                            } else {
                                System.out.println("A mesa " + numeroMesa + " não pode ser atribuída ainda. A última ação foi realizada na unidade de tempo " + mesa.getUltimaAcaoTempo());
                            }
                        } else {
                            System.out.println("Mesa " + numeroMesa + " já está ocupada.");
                        }
                        return;
                    }
                }
                System.out.println("Mesa " + numeroMesa + " não encontrada.");
                return;
            }
        }
        System.out.println("Cliente " + nomeReserva + " não encontrado.");
    }



    public static Clientes[] adicionarCliente(Clientes[] clientes, String nomeReserva, int numPessoas, int numEntradas, int numSobremesas, int tempoMaxEsperaMesa, int tempoMaxEsperaAtendimento, int tempoAtual) {
        // Cria um novo array com tamanho aumentado em 1
        Clientes[] novosClientes = new Clientes[clientes.length + 1];
        System.arraycopy(clientes, 0, novosClientes, 0, clientes.length);

        // Cria o novo cliente
        Clientes novoCliente = new Clientes(nomeReserva, numPessoas, numEntradas, numSobremesas, tempoMaxEsperaMesa, tempoMaxEsperaAtendimento, tempoAtual);
        novosClientes[clientes.length] = novoCliente;

        System.out.println("Cliente " + nomeReserva + " adicionado com sucesso.");
        return novosClientes;
    }

    public static void listarMesas(Mesa[] mesas) {
        System.out.println("\n--- Lista de Mesas ---");
        for (Mesa mesa : mesas) {
            String estado = mesa.isOcupada() ? "Ocupada" : "Livre";
            System.out.println("Mesa " + mesa.getId() + " | Capacidade: " + mesa.getCapacidade() + " | Estado: " + estado);
        }
    }

    public static Mesa[] adicionarMesa(Scanner scanner, Mesa[] mesas) {
        System.out.print("Digite o ID da nova mesa: ");
        int id = scanner.nextInt();
        System.out.print("Digite a capacidade da nova mesa: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Mesa novaMesa = new Mesa(id, capacidade);
        Mesa[] novasMesas = new Mesa[mesas.length + 1];
        System.arraycopy(mesas, 0, novasMesas, 0, mesas.length);
        novasMesas[mesas.length] = novaMesa;

        System.out.println("Mesa adicionada com sucesso.");
        return novasMesas;
    }

    public static Mesa[] removerMesa(Scanner scanner, Mesa[] mesas) {
        System.out.print("Digite o ID da mesa a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        Mesa[] novasMesas = new Mesa[mesas.length - 1];
        int index = 0;
        for (Mesa mesa : mesas) {
            if (mesa.getId() != id) {
                novasMesas[index++] = mesa;
            }
        }

        System.out.println("Mesa removida com sucesso.");
        return novasMesas;
    }

    public static void alterarEstadoMesa(Scanner scanner, Mesa[] mesas) {
        System.out.print("Digite o ID da mesa para alterar o estado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        for (Mesa mesa : mesas) {
            if (mesa.getId() == id) {
                mesa.setOcupada(!mesa.isOcupada());
                System.out.println("Estado da mesa " + id + " alterado para " + (mesa.isOcupada() ? "ocupada" : "livre"));
                return;
            }
        }
        System.out.println("Mesa não encontrada.");
    }

    public void liberarMesa(int idMesa) {
            for (Mesa mesa : mesas) {
                if (mesa.getId() == idMesa) {
                    mesa.setOcupada(false);
                    System.out.println("Mesa " + idMesa + " liberada.");
                    return;
                }
            }
            System.out.println("Mesa " + idMesa + " não encontrada.");
        }


    public static void listarPratos(Prato[] pratos, int numeroPratos) {
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

    // Define the alterarDisponibilidadePrato method
    public static void alterarDisponibilidadePrato(Scanner scanner, Prato[] pratos, int numeroPratos) {
        System.out.print("Digite o número do prato para alterar a disponibilidade: ");
        int numeroPrato = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (numeroPrato > 0 && numeroPrato <= numeroPratos) {
            Prato prato = pratos[numeroPrato - 1];
            prato.setDisponivel(!prato.isDisponivel()); // Toggle availability
            System.out.println("Disponibilidade do prato " + prato.getNomePrato() + " alterada com sucesso.");
        } else {
            System.out.println("Número de prato inválido.");
        }
    }



        public static void adicionarReserva(Scanner scanner, Reservas[] reservas) {
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o horário da reserva: ");
            String horario = scanner.nextLine();
            System.out.println("Reserva adicionada para " + nome + " às " + horario);
        }

        public static void removerReserva(Scanner scanner, Reservas[] reservas) {
            System.out.print("Digite o número da reserva a ser removida: ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            if (numero > 0 && numero <= reservas.length) {
                System.out.println("Reserva " + numero + " removida com sucesso.");
            } else {
                System.out.println("Número de reserva inválido.");
            }
        }

    public static Pedidos[] registarPedido(Pedidos[] pedidos, int id, int mesa, Prato prato, int quantidade, Clientes cliente) {
        // Cria um novo array com tamanho aumentado em 1
        Pedidos[] novosPedidos = new Pedidos[pedidos.length + 1];
        System.arraycopy(pedidos, 0, novosPedidos, 0, pedidos.length);

        // Cria o novo pedido
        Pedidos novoPedido = new Pedidos(id, mesa, prato, quantidade, cliente); // Passa o objeto Clientes
        novosPedidos[pedidos.length] = novoPedido;

        // Calcular o tempo total para o cliente
        int tempoPreparo = prato.getTempoPreparo(); // Tempo de preparo do prato
        int tempoConsumo = prato.getTempoConsumo(); // Tempo de consumo do prato
        int tempoEstrago = prato.getTempoEstrago(); // Tempo de estrago do prato

        // Calcular o tempo total que o cliente levará para consumir o prato
        int tempoTotal = tempoPreparo + tempoConsumo;

        // Atualizar o cliente com o tempo total
        cliente.setMaxUTatendimento(tempoTotal); // Atualiza o tempo máximo de atendimento

        System.out.println("Pedido registado com sucesso: " + novoPedido);
        return novosPedidos;
    }

    public static void consultarEstatisticas(Pedidos[] pedidos, Prato[] pratos) {
        if (pedidos.length == 0) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        int[] contagemPratos = new int[pratos.length]; // Array para contar os pedidos de cada prato
        int pratoMaisPedidoIndex = -1;
        int maxPedidos = 0;

        // Contar os pedidos
        for (Pedidos pedido : pedidos) {
            int pratoIndex = encontrarPratoIndex(pratos, pedido.getPrato().getNomePrato());
            if (pratoIndex != -1) {
                contagemPratos[pratoIndex]++; // Incrementa a contagem do prato
                // Verifica se é o prato mais pedido
                if (contagemPratos[pratoIndex] > maxPedidos) {
                    maxPedidos = contagemPratos[pratoIndex];
                    pratoMaisPedidoIndex = pratoIndex;
                }
            }
        }

        // Exibir resultados
        System.out.println("Estatísticas dos Pedidos:");
        System.out.println("Total de Pedidos: " + pedidos.length);
        if (pratoMaisPedidoIndex != -1) {
            System.out.println("Prato Mais Pedido: " + pratos[pratoMaisPedidoIndex].getNomePrato() + " (Quantidade: " + maxPedidos + ")");
        } else {
            System.out.println("Nenhum prato foi pedido.");
        }
    }

    public static Pedidos[] registarPedidos(Scanner scanner, Pedidos[] pedidos, Mesa[] mesas, Prato[] pratos, Clientes[] clientes, int dia) {
        System.out.println("\n--- Registar Pedido ---");

        // Listar todas as mesas com suas disponibilidades
        System.out.println("Mesas disponíveis:");
        boolean mesasDisponiveis = false;
        for (Mesa mesa : mesas) {
            String estado = mesa.isOcupada() ? "Ocupada" : "Livre"; // Verifica se a mesa está ocupada
            System.out.println("Mesa " + mesa.getId() + " (Capacidade: " + mesa.getCapacidade() + ", Estado: " + estado + ")");
            if (!mesa.isOcupada()) {
                mesasDisponiveis = true; // Marca que há mesas disponíveis
            }
        }
        if (!mesasDisponiveis) {
            System.out.println("Não há mesas disponíveis.");
            return pedidos; // Retorna sem registrar pedido se não houver mesas disponíveis
        }

        // Coletar dados do pedido
        System.out.print("Digite o ID da mesa: ");
        int mesaId = scanner.nextInt();
        scanner.nextLine();

        // Verificar se a mesa existe e se está ocupada
        Mesa mesaSelecionada = null;
        for (Mesa mesa : mesas) {
            if (mesa.getId() == mesaId) {
                mesaSelecionada = mesa;
                break;
            }
        }
        if (mesaSelecionada == null) {
            System.out.println("Mesa inválida.");
            return pedidos;
        }

        // Verificar se a mesa está ocupada
        if (!mesaSelecionada.isOcupada()) {
            System.out.println("A mesa não está ocupada. Não é possível registrar pedidos.");
            return pedidos;
        }

        // Listar pratos disponíveis
        System.out.println("Pratos disponíveis:");
        boolean pratosDisponiveis = false;
        for (int i = 0; i < pratos.length; i++) {
            if (pratos[i].isDisponivel()) {
                System.out.println((i + 1) + ". " + pratos[i].getNomePrato() + " (Categoria: " + pratos[i].getCategoria() + ")");
                pratosDisponiveis = true;
            }
        }
        if (!pratosDisponiveis) {
            System.out.println("Não há pratos disponíveis.");
            return pedidos; // Retorna sem registrar pedido se não houver pratos disponíveis
        }

        // Definir um tamanho máximo para o pedido
        final int MAX_PRATOS = 10; // Por exemplo, um pedido pode ter no máximo 10 pratos
        Prato[] pratosSelecionados = new Prato[MAX_PRATOS];
        int[] quantidadesSelecionadas = new int[MAX_PRATOS];
        int contador = 0;

        boolean continuar = true;
        while (continuar && contador < MAX_PRATOS) {
            System.out.print("Digite o número do prato: ");
            int pratoIndex = scanner.nextInt() - 1; scanner.nextLine(); // Consumir a nova linha

            // Verificar se o índice do prato é válido
            if (pratoIndex < 0 || pratoIndex >= pratos.length || !pratos[pratoIndex].isDisponivel()) {
                System.out.println("Prato inválido ou indisponível.");
                continue; // Volta para o início do loop
            }

            Prato pratoSelecionado = pratos[pratoIndex];

            System.out.print("Digite a quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            // Adiciona o prato e a quantidade às arrays
            pratosSelecionados[contador] = pratoSelecionado;
            quantidadesSelecionadas[contador] = quantidade;
            contador++;

            // Pergunta se o usuário deseja adicionar mais pratos
            System.out.print("Deseja adicionar outro prato? (s/n): ");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                continuar = false; // Sai do loop
            }
        }

        // Gerar um ID único para o pedido
        int id = pedidos.length + 1;

        // Encontrar o cliente correspondente ao nome da reserva
        System.out.print("Digite o nome da reserva: ");
        String nomeReserva = scanner.nextLine();
        Clientes clienteSelecionado = null;
        for (Clientes cliente : clientes) {
            if (cliente.getNomeReserva().equals(nomeReserva)) {
                clienteSelecionado = cliente;
                break;
            }
        }

        if (clienteSelecionado == null) {
            System.out.println("Cliente não encontrado.");
            return pedidos;
        }

        // Registrar o pedido para cada prato selecionado
        for (int i = 0; i < contador; i++) {
            Prato prato = pratosSelecionados[i];
            int quantidade = quantidadesSelecionadas[i];
            pedidos = GestorRestaurante.registarPedido(pedidos, id, mesaId, prato, quantidade, clienteSelecionado);

            // Gravar log do pedido
            String logMensagem = clienteSelecionado.getNomeReserva() + "," + prato.getNomePrato() + "," + (prato.getPrecoCusto() * quantidade);
            gravarLog(logMensagem, dia);
        }

        System.out.println("Pedido registado com sucesso com " + contador + " pratos.");
        return pedidos;
    }

    private static void gravarLog(String mensagem, int dia) {
        String filename = "logs_dia_" + dia + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) { // 'true' para anexar ao arquivo
            bw.write(mensagem);
            bw.newLine(); // Adiciona uma nova linha
        } catch (IOException e) {
            System.out.println("Erro ao gravar log: " + e.getMessage());
        }
    }
    // Método para encontrar o índice de um prato pelo nome
    private static int encontrarPratoIndex(Prato[] pratos, String nomePrato) {
        for (int i = 0; i < pratos.length; i++) {
            if (pratos[i].getNomePrato().equals(nomePrato)) {
                return i; // Retorna o índice se o prato for encontrado
            }
        }
        return -1; // Retorna -1 se não encontrar o prato
    }





}
