public class Definicoes {


    private String caminhoClientes;
    private String caminhoPratos;
    private String separadorFicheiros;
    private int unidadesTempoDia;
    private int tempoEsperaCliente;
    private double custoClienteNaoAtendido;
    private String senha;

    public Definicoes(String caminhoClientes, String caminhoPratos, String separadorFicheiros,
                      int unidadesTempoDia, int tempoEsperaCliente, double custoClienteNaoAtendido, String senha) {
        this.caminhoClientes = caminhoClientes;
        this.caminhoPratos = caminhoPratos;
        this.separadorFicheiros = separadorFicheiros;
        this.unidadesTempoDia = unidadesTempoDia;
        this.tempoEsperaCliente = tempoEsperaCliente;
        this.custoClienteNaoAtendido = custoClienteNaoAtendido;
        this.senha = senha;
    }

    // Getters e Setters para clientes e pratos
    public String getCaminhoClientes() { return caminhoClientes; }

    public void setCaminhoClientes(String caminhoClientes) { this.caminhoClientes = caminhoClientes; }

    public String getCaminhoPratos() { return caminhoPratos; }

    public void setCaminhoPratos(String caminhoPratos) { this.caminhoPratos = caminhoPratos; }

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
                this.passwordConfiguracoes = novaSenha.toCharArray();
                return true;
            } else {
                return false;
            }
        }


        public boolean validarSenha(String senha) {
            char[] senhaArray = senha.toCharArray();
            if (senhaArray.length != passwordConfiguracoes.length) {
                return false;
            }
            for (int i = 0; i < senhaArray.length; i++) {
                if (senhaArray[i] != passwordConfiguracoes[i]) {
                    return false;
                }
            }
            return true;
        }


        @Override
        public String toString() {
            return "Definicoes{" +
                    "caminhoFicheiros='" + caminhoFicheiros + '\'' +
                    ", separadorFicheiros='" + separadorFicheiros + '\'' +
                    ", unidadesTempoDia=" + unidadesTempoDia +
                    ", tempoEsperaCliente=" + tempoEsperaCliente +
                    ", custoClienteNaoAtendido=" + custoClienteNaoAtendido +
                    '}';

    }



}
