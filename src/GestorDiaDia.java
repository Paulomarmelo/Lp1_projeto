public class GestorDiaDia {
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

    private int numClientes = clientes.length;
    private  int tempoAtual;
    private int unidadesTempoDia = definicoes.getUnidadesTempoDia();

    public GestorDiaDia(Clientes[] clientes, int numClientes, int tempoAtual, int unidadesTempoDia) {

        this.numClientes = 0;
        this.tempoAtual = 0;
        this.unidadesTempoDia = unidadesTempoDia;
    }

    public void avancarTempo() {
        if (tempoAtual < unidadesTempoDia) {
            tempoAtual++;
            System.out.println("Tempo atual: " + tempoAtual);

            // Verificar se há clientes que chegaram
            for (int i = 0; i < numClientes; i++) {
                Clientes cliente = clientes[i];
                if (cliente.getChegadaUT() == tempoAtual) {
                    System.out.println("Cliente " + cliente.getNomeReserva() + " chegou ao restaurante.");
                }
            }
        } else {
            System.out.println("O dia terminou.");
        }
    }


    public void atribuirMesa(String nomeReserva, int numeroMesa) {
        for (int i = 0; i < numClientes; i++) {
            if (clientes[i].getNomeReserva().equals(nomeReserva)) {
                System.out.println("Mesa " + numeroMesa + " atribuída ao cliente " + nomeReserva);
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }


    public void adicionarCliente(String nomeReserva, int numPessoas, int numEntradas, int numSobremesas, int tempoMaxEsperaMesa, int tempoMaxEsperaAtendimento) {
        if (numClientes < clientes.length) {
            Clientes cliente = new Clientes(nomeReserva, numPessoas, numEntradas, numSobremesas, tempoMaxEsperaMesa, tempoMaxEsperaAtendimento, tempoAtual);
            clientes[numClientes++] = cliente;
            System.out.println("Cliente " + nomeReserva + " adicionado com sucesso.");
        } else {
            System.out.println("Capacidade máxima de clientes atingida.");
        }
    }

}
