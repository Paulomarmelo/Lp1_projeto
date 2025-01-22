import java.util.Scanner;

public class GestaoMesas {

    private Mesa[] mesas;
    private int numeroMesas;

    public GestaoMesas(int capacidadeMaxima) {
        this.mesas = new Mesa[capacidadeMaxima];
        this.numeroMesas = 0;
    }

    public void exibirMenuMesas(Scanner scanner) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n====== Gestão de Mesas ======");
            System.out.println("1. Listar Mesas");
            System.out.println("2. Adicionar Mesa");
            System.out.println("3. Remover Mesa");
            System.out.println("4. Alterar Estado de Mesa");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    listarMesas();
                    break;
                case 2:
                    adicionarMesa(scanner);
                    break;
                case 3:
                    removerMesa(scanner);
                    break;
                case 4:
                    alterarEstadoMesa(scanner);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private void listarMesas() {
        if (numeroMesas == 0) {
            System.out.println("Nenhuma mesa cadastrada.");
        } else {
            System.out.println("\nLista de Mesas:");
            for (int i = 0; i < numeroMesas; i++) {
                Mesa mesa = mesas[i];
                System.out.printf("Mesa %d: Estado: %s | Capacidade: %d lugares\n",
                        i + 1, mesa.getMesa(), mesa.getCapacidadeMesa());
            }
        }
    }

    private void adicionarMesa(Scanner scanner) {
        if (numeroMesas >= mesas.length) {
            System.out.println("Capacidade máxima de mesas atingida.");
            return;
        }

        System.out.print("Digite a capacidade da nova mesa: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        mesas[numeroMesas] = new Mesa(capacidade);
        numeroMesas++;
        System.out.println("Mesa adicionada com sucesso!");
    }

    private void removerMesa(Scanner scanner) {
        listarMesas();

        if (numeroMesas > 0) {
            System.out.print("Digite o número da mesa que deseja remover: ");
            int numero = scanner.nextInt();

            if (numero < 1 || numero > numeroMesas) {
                System.out.println("Número inválido.");
            } else {
                for (int i = numero - 1; i < numeroMesas - 1; i++) {
                    mesas[i] = mesas[i + 1];
                }
                mesas[--numeroMesas] = null;
                System.out.println("Mesa removida com sucesso!");
            }
        }
    }

    private void alterarEstadoMesa(Scanner scanner) {
        listarMesas();

        if (numeroMesas > 0) {
            System.out.print("Digite o número da mesa para alterar o estado: ");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (numero < 1 || numero > numeroMesas) {
                System.out.println("Número inválido.");
            } else {
                Mesa mesa = mesas[numero - 1];
                System.out.println("O estado atual da mesa é: " + mesa.getEstadoMesa());
                System.out.print("Digite o novo estado (livre/ocupada/reservada): ");
                String novoEstado = scanner.nextLine();

                if (novoEstado.equalsIgnoreCase("livre") ||
                        novoEstado.equalsIgnoreCase("ocupada") ||
                        novoEstado.equalsIgnoreCase("reservada")) {
                    mesa.setEstadoMesa(novoEstado);
                    System.out.println("Estado da mesa alterado com sucesso!");
                } else {
                    System.out.println("Estado inválido. Operação cancelada.");
                }
            }
        }
    }
}



