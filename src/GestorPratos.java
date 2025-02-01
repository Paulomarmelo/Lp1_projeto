import java.util.Scanner;

public class GestorPratos {

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
}
