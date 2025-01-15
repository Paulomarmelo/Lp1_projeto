import java.io.*;

public class LeitorPratos {

    /**
     * Lê os dados de um ficheiro e retorna um array de objetos Prato.
     * @param filePath1 O caminho para o ficheiro.
     * @return Um array contendo os pratos lidos do ficheiro.
     */
    public static Prato[] lerPratosDoFicheiro(String filePath1) {
        int maxPratos = 100;
        Prato[] listaPratos = new Prato[maxPratos];
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath1))) {
            String linha;
            while ((linha = br.readLine()) != null) {


                String[] dados = linha.split(";,");


                Prato prato = new Prato(
                        dados[0], // nome
                        Double.parseDouble(dados[1]), // precoCusto
                        dados[2], // categoria
                        Double.parseDouble(dados[3]), // precoVenda
                        Integer.parseInt(dados[4]), // tempoPreparo
                        Boolean.parseBoolean(dados[5]) // disponivel
                );

                // Armazena o prato no array
                listaPratos[contador] = prato;
                contador++;

                // Verifica se o limite do array foi atingido
                if (contador >= listaPratos.length) {
                    System.err.println("Array de pratos está cheio. Alguns pratos podem não ser carregados.");
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        // Retorna o array até o número de pratos carregados
        return truncarArray(listaPratos, contador);
    }

    /**
     * Trunca o array para conter apenas os pratos carregados.
     * @param listaPratos O array original.
     * @param tamanho O número de pratos carregados.
     * @return Um array novo contendo apenas os pratos carregados.
     */
    private static Prato[] truncarArray(Prato[] listaPratos, int tamanho) {
        Prato[] resultado = new Prato[tamanho];
        System.arraycopy(listaPratos, 0, resultado, 0, tamanho);
        return resultado;
    }

    // Conversões importantes
    //Double.parseDouble para converter valores monetários.
    //Integer.parseInt para inteiros.
    //Boolean.parseBoolean para o campo booleano.
}
