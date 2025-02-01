import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorMesas {

    public static Mesa[] lerMesasDoFicheiro(String caminho, String separador) {
        String filePath = caminho + "/Mesas.txt"; // Caminho do arquivo

        int maxMesas = 100; // Define o tamanho máximo do array
        Mesa[] listaMesas = new Mesa[maxMesas];
        int contador = 0; // Contador para acompanhar o número de mesas

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(separador);

                if (dados.length < 3) {
                    System.err.println("Linha inválida (campos insuficientes): " + linha);
                    continue; // Ignorar a linha inválida
                }

                try {
                    int id = Integer.parseInt(dados[0]);
                    int capacidade = Integer.parseInt(dados[1]);
                    boolean ocupada = false;

                    Mesa mesa = new Mesa(id, capacidade);
                    mesa.setOcupada(ocupada);

                    // Armazena a mesa no array
                    listaMesas[contador] = mesa;
                    contador++;
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter valores numéricos na linha: " + linha);
                }

                // Verifica se o limite do array foi atingido
                if (contador >= listaMesas.length) {
                    System.err.println("Array de mesas está cheio. Algumas mesas podem não ser carregadas.");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return truncarArray(listaMesas, contador);
    }

    private static Mesa[] truncarArray(Mesa[] listaMesas, int tamanho) {
        Mesa[] resultado = new Mesa[tamanho];
        System.arraycopy(listaMesas, 0, resultado, 0, tamanho);
        return resultado;
    }
}