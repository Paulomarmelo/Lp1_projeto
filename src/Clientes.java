public class Clientes  {
    private String nomeReserva;
    private int numPessoas;
    private int pedidosEntrada;
    private int pedidosSobremesa;
    private int maxUTentrar;
    private int maxUTatendimento;
    private int chegadaUT;


    public Clientes(String nomeReserva, int numPessoas, int pedidosEntrada, int pedidosSobremesa, int maxUTentrar, int maxUTatendimento, int chegadaUT) {
        this.nomeReserva = nomeReserva;
        this.numPessoas = numPessoas;
        this.pedidosEntrada = pedidosEntrada;
        this.pedidosSobremesa = pedidosSobremesa;
        this.maxUTentrar = maxUTentrar;
        this.maxUTatendimento = maxUTatendimento;
        this.chegadaUT = chegadaUT;
    }

    public String getNomeReserva() {
        return nomeReserva;
    }

    public void setNomeReserva(String nomeReserva) {
        this.nomeReserva = nomeReserva;
    }

    public int getNumPessoas() {
        return numPessoas;
    }

    public void setNumPessoas(int numPessoas) {
        this.numPessoas = numPessoas;
    }

    public int getPedidosEntrada() {
        return pedidosEntrada;
    }

    public void setPedidosEntrada(int pedidosEntrada) {
        this.pedidosEntrada = pedidosEntrada;
    }

    public int getPedidosSobremesa() {
        return pedidosSobremesa;
    }

    public void setPedidosSobremesa(int pedidosSobremesa) {
        this.pedidosSobremesa = pedidosSobremesa;
    }

    public int getMaxUTentrar() {
        return maxUTentrar;
    }

    public void setMaxUTentrar(int maxUTentrar) {
        this.maxUTentrar = maxUTentrar;
    }

    public int getMaxUTatendimento() {
        return maxUTatendimento;
    }

    public void setMaxUTatendimento(int maxUTatendimento) {
        this.maxUTatendimento = maxUTatendimento;
    }

    public int getChegadaUT() {
        return chegadaUT;
    }

    public void setChegadaUT(int chegadaUT) {
        this.chegadaUT = chegadaUT;
    }



}
