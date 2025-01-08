public class Pedidos {
    private int id;
    private Mesa mesa;
    private Prato prato;
    private int quantidade;

    public Pedidos(int quantidade, int id, Mesa mesa, Prato prato) {
        this.quantidade = quantidade;
        this.id = id;
        this.mesa = mesa;
        this.prato = prato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
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
}
