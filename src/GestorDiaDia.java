public class GestorDiaDia {
    public void getClientes(){

        String caminho = "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\Clientes.txt";
        String separador = "C:\\Users\\pjtug\\Desktop\\GIT_repos\\ProjetoLp1\\src\\";

        Clientes[] clientes = LeitorClientes.lerClientesDoFicheiro(caminho, separador);
        int numeroClientes = clientes.length;

        String[] nomes = new String[numeroClientes];
        int[] numPessoas = new int[numeroClientes];
        int[] pedidosEntrada = new int[numeroClientes];
        int[] pedidosSobremesa = new int[numeroClientes];
        int[] maxUTentrar = new int[numeroClientes];
        int[] maxUTatendimento = new int[numeroClientes];
        int[] chegadaUT = new int[numeroClientes];


        for (int i = 0; i < numeroClientes; i++) {
            Clientes cliente = clientes[i];
            nomes[i] = cliente.getNomeReserva();
            numPessoas[i] = cliente.getNumPessoas();
            pedidosEntrada[i] = cliente.getPedidosEntrada();
            pedidosSobremesa[i] = cliente.getPedidosSobremesa();
            maxUTentrar[i] = cliente.getMaxUTentrar();
            maxUTatendimento[i] = cliente.getMaxUTatendimento();
            chegadaUT[i] = cliente.getChegadaUT();
    }

    }
}
