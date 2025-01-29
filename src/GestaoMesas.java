import java.util.Scanner;

public class GestaoMesas {

    private Mesa[] mesas;
    private int numeroMesas;

    public GestaoMesas(int capacidadeMaxima) {
        this.mesas = new Mesa[capacidadeMaxima];
        this.numeroMesas = 0;
    }

    private void listarMesas() {
        if (numeroMesas == 0) {
            System.out.println("Nenhuma mesa cadastrada.");
        } else {
            System.out.println("\nLista de Mesas:");
            for (int i = 0; i < numeroMesas; i++) {
                Mesa mesa = mesas[i];
                System.out.printf("Mesa %d: Estado: %s | Capacidade: %d lugares\n",
                        mesa.getId(), mesa.isOcupada() ? "Ocupada" : "Livre", mesa.getCapacidade());
            }
        }
    }

    private void adicionarMesa(Scanner scanner) {
        if (numeroMesas >= mesas.length) {
            System.out.println("Capacidade máxima de mesas atingida.");
            return;
        }

        System.out.print("Digite o ID da nova mesa: ");
        int id = scanner.nextInt();
        System.out.print("Digite a capacidade da nova mesa: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        mesas[numeroMesas] = new Mesa(id, capacidade);
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
                System.out.println("O estado atual da mesa é: " + (mesa.isOcupada() ? "Ocupada" : "Livre"));
                System.out.print("Digite o novo estado (true para ocupada, false para livre): ");
                boolean novoEstado = scanner.nextBoolean();
                mesa.setOcupada(novoEstado);
                System.out.println("Estado da mesa alterado com sucesso!");
            }
        }
    }
}


