public class Prato {
    private String nomePrato;
    private String categoria;
    private double precoCusto;
    private double precoVenda;
    private int tempoConsumo;
    private int tempoPreparo;
    private int tempoEstrago;
    private boolean disponivel;


    public Prato(String nomePrato, String categoria, double precoCusto, double precoVenda, int tempoConsumo, int tempoPreparo, int tempoEstrago, boolean disponivel) {
        this.nomePrato = nomePrato;
        this.categoria = categoria;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.tempoConsumo = tempoConsumo;
        this.tempoPreparo = tempoPreparo;
        this.tempoEstrago = tempoEstrago;
        this.disponivel = disponivel;
    }

    public int getTempoEstrago() {
        return tempoEstrago;
    }

    public void setTempoEstrago(int tempoEstrago) {
        this.tempoEstrago = tempoEstrago;
    }

    public int getTempoConsumo() {
        return tempoConsumo;
    }

    public void setTempoConsumo(int tempoConsumo) {
        this.tempoConsumo = tempoConsumo;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public boolean isDisponivel() {
        return true;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
