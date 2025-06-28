public class Compra implements Comparable<Compra>{
    private String descricao;  // descrição do produto
    private double valor;  // valor da compra

    // Construtor: inicializa a descrição e o valor da compra
    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    // Método que define a ordernação de compras pelo valor (crescente)
    @Override
    public int compareTo(Compra outraCompra) {
        return Double.compare(this.valor, outraCompra.valor);
    }

    // Representação textual de uma compra
    @Override
    public String toString() {
        return "Compra: descricao = " + this.getDescricao() +
                "valor = " + this.getValor();
    }
}
