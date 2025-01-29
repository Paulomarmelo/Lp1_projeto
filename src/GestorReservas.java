import java.util.Scanner;

public class GestorReservas {
    public static void listarReservas(Reservas[] reservas) {
        if (reservas.length == 0) {
            System.out.println("Nenhuma reserva encontrada.");
        } else {
            for (int i = 0; i < reservas.length; i++) {
                System.out.println("Reserva " + (i + 1) + ": " + reservas[i].toString());
            }
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
}
