import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorReservas {

    public static Reservas[] lerReservasDoFicheiro(String caminho, String separador) {
        String filePath = caminho + "/Reservas.txt"; // Caminho do arquivo

        int maxReservas = 100; // Define o tamanho máximo do array
        Reservas[] listaReservas = new Reservas[maxReservas];
        int contador = 0; // Contador para acompanhar o número de reservas

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(separador);

                if (dados.length < 3) {
                    System.err.println("Linha inválida (campos insuficientes): " + linha);
                    continue; // Ignorar a linha inválida
                }

                try {
                    String nomeReserva = dados[0];
                    int numPessoas = Integer.parseInt(dados[1]);
                    int chegadaUT = Integer.parseInt(dados[2]);

                    Reservas reserva = new Reservas(nomeReserva, numPessoas, chegadaUT);

                    // Armazena a reserva no array
                    listaReservas[contador] = reserva;
                    contador++;
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter valores numéricos na linha: " + linha);
                }

                // Verifica se o limite do array foi atingido
                if (contador >= listaReservas.length) {
                    System.err.println("Array de reservas está cheio. Algumas reservas podem não ser carregadas.");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return truncarArray(listaReservas, contador);
    }

    private static Reservas[] truncarArray(Reservas[] listaReservas, int tamanho) {
        Reservas[] resultado = new Reservas[tamanho];
        System.arraycopy(listaReservas, 0, resultado, 0, tamanho);
        return resultado;
    }
}

