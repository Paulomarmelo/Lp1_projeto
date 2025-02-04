public class Pedidos {
    private int id;
    private int mesa;
    private Prato prato;
    private int quantidade;
    private Clientes cliente; // Alterado para o objeto Clientes




    public Pedidos(int id, int mesa, Prato prato, int quantidade, Clientes cliente) {
        this.id = id;
        this.mesa = mesa;
        this.prato = prato;
        this.quantidade = quantidade;
        this.cliente = cliente;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido [ID=" + id +
                ", Mesa=" + mesa +
                ", Cliente=" + cliente.getNomeReserva() + // Acessa o nome do cliente
                ", Prato=" + prato.getNomePrato() +
                " (Categoria: " + prato.getCategoria() +
                ", Preço: " + prato.getPrecoVenda() +
                "), Quantidade=" + quantidade +
                "), Disponibilidade="+ prato.isDisponivel() +
                "]";
    }
}

