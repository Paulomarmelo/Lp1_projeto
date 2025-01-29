public class Definicoes {

    private String caminhoClientes;
    private String caminhoPratos;
    private String caminhoReservas;  // Novo campo adicionado
    private String separadorFicheiros;
    private int unidadesTempoDia;
    private int tempoEsperaCliente;
    private double custoClienteNaoAtendido;
    private String senha;

    public Definicoes(String caminhoClientes, String caminhoPratos, String caminhoReservas, String separadorFicheiros,
                      int unidadesTempoDia, int tempoEsperaCliente, double custoClienteNaoAtendido, String senha) {
        this.caminhoClientes = caminhoClientes;
        this.caminhoPratos = caminhoPratos;
        this.caminhoReservas = caminhoReservas;
        this.separadorFicheiros = separadorFicheiros;
        this.unidadesTempoDia = unidadesTempoDia;
        this.tempoEsperaCliente = tempoEsperaCliente;
        this.custoClienteNaoAtendido = custoClienteNaoAtendido;
        this.senha = senha;
    }

    // Getters e Setters para clientes, pratos e reservas
    public String getCaminhoClientes() { return caminhoClientes; }

    public void setCaminhoClientes(String caminhoClientes) { this.caminhoClientes = caminhoClientes; }

    public String getCaminhoPratos() { return caminhoPratos; }

    public void setCaminhoPratos(String caminhoPratos) { this.caminhoPratos = caminhoPratos; }

    public String getCaminhoReservas() { return caminhoReservas; }  // Getter para o novo campo

    public void setCaminhoReservas(String caminhoReservas) { this.caminhoReservas = caminhoReservas; }  // Setter para o novo campo

    public String getSeparadorFicheiros() {
        return separadorFicheiros;
    }

    public void setSeparadorFicheiros(String separadorFicheiros) {
        this.separadorFicheiros = separadorFicheiros;
    }

    public int getUnidadesTempoDia() {
        return unidadesTempoDia;
    }

    public void setUnidadesTempoDia(int unidadesTempoDia) {
        if (unidadesTempoDia > 0) {
            this.unidadesTempoDia = unidadesTempoDia;
        } else {
            throw new IllegalArgumentException("Unidades de tempo do dia devem ser maiores que zero.");
        }
    }

    public int getTempoEsperaCliente() {
        return tempoEsperaCliente;
    }

    public void setTempoEsperaCliente(int tempoEsperaCliente) {
        if (tempoEsperaCliente > 0) {
            this.tempoEsperaCliente = tempoEsperaCliente;
        } else {
            throw new IllegalArgumentException("O tempo de espera do cliente deve ser maior que zero.");
        }
    }

    public double getCustoClienteNaoAtendido() {
        return custoClienteNaoAtendido;
    }

    public void setCustoClienteNaoAtendido(double custoClienteNaoAtendido) {
        if (custoClienteNaoAtendido >= 0) {
            this.custoClienteNaoAtendido = custoClienteNaoAtendido;
        } else {
            throw new IllegalArgumentException("O custo por cliente não atendido não pode ser negativo.");
        }
    }

    public boolean alterarPassword(String senhaAtual, String novaSenha) {
        if (validarSenha(senhaAtual)) {
            this.senha = novaSenha;
            return true;
        } else {
            return false;
        }
    }

    public boolean validarSenha(String senha) {
        char[] senhaArray = senha.toCharArray();
        char[] senhaConfigurada = this.senha.toCharArray();

        if (senhaArray.length != senhaConfigurada.length) {
            return false;
        }
        for (int i = 0; i < senhaArray.length; i++) {
            if (senhaArray[i] != senhaConfigurada[i]) {
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString() {
        return "Definicoes{" +
                "caminhoClientes='" + caminhoClientes + '\'' +
                ", caminhoPratos='" + caminhoPratos + '\'' +
                ", caminhoReservas='" + caminhoReservas + '\'' +
                ", separadorFicheiros='" + separadorFicheiros + '\'' +
                ", unidadesTempoDia=" + unidadesTempoDia +
                ", tempoEsperaCliente=" + tempoEsperaCliente +
                ", custoClienteNaoAtendido=" + custoClienteNaoAtendido +
                '}';
    }
}