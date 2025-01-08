public class Prato {
    private String nome;
    private String categoria;
    private double precoCusto;
    private double precoVenda;
    private int tempoPreparo;
    private boolean disponivel;


    public Prato(String nome, double precoCusto, String categoria, double precoVenda, int tempoPreparo, boolean disponivel) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.categoria = categoria;
        this.precoVenda = precoVenda;
        this.tempoPreparo = tempoPreparo;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
