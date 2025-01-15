

import java.io.*;

public class LeitorClientes {

    /**
     * Lê os dados de um ficheiro e retorna um array de objetos Clientes.
     * @param filePath O caminho para o ficheiro.
     * @return Um array contendo os clientes lidos do ficheiro.
     */
    public static Clientes[] lerClientesDoFicheiro(String filePath) {
        int maxClientes = 100; // Define o tamanho máximo do array
        Clientes[] listaClientes = new Clientes[maxClientes];
        int contador = 0; // Contador para acompanhar o número de clientes

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Divide a linha usando vírgulas como delimitadores
                String[] dados = linha.split(",");

                // Cria um objeto Clientes a partir dos dados lidos
                Clientes cliente = new Clientes(
                        dados[0], // nomeReserva
                        Integer.parseInt(dados[1]), // numPessoas
                        Integer.parseInt(dados[2]), // pedidosEntrada
                        Integer.parseInt(dados[3]), // pedidosSobremesa
                        Integer.parseInt(dados[4]), // maxUTentrar
                        Integer.parseInt(dados[5]), // maxUTatendimento
                        Integer.parseInt(dados[6])  // chegadaUT
                );

                // Armazena o cliente no array
                listaClientes[contador] = cliente;
                contador++;

                // Verifica se o limite do array foi atingido
                if (contador >= listaClientes.length) {
                    System.err.println("Array de clientes está cheio. Alguns clientes podem não ser carregados.");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Retorna o array até o número de clientes carregados
        return truncarArray(listaClientes, contador);
    }

    /**
     * Trunca o array para conter apenas os clientes carregados.
     * @param listaClientes O array original.
     * @param tamanho O número de clientes carregados.
     * @return Um array novo contendo apenas os clientes carregados.
     */
    private static Clientes[] truncarArray(Clientes[] listaClientes, int tamanho) {
        Clientes[] resultado = new Clientes[tamanho];
        System.arraycopy(listaClientes, 0, resultado, 0, tamanho);
        return resultado;
    }
}






