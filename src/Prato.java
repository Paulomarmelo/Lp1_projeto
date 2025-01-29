public class Prato {
    private String nomePrato;
    private String categoria;
    private double precoCusto;
    private double precoVenda;
    private int tempoPreparo;
    private boolean disponivel;


    public Prato(String nomePrato, double precoCusto, String categoria, double precoVenda, int tempoPreparo, boolean disponivel) {
        this.nomePrato = nomePrato;
        this.precoCusto = precoCusto;
        this.categoria = categoria;
        this.precoVenda = precoVenda;
        this.tempoPreparo = tempoPreparo;
        this.disponivel = disponivel;
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
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
