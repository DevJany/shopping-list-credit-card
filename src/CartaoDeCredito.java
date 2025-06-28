import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private double limite; // limite inicial do cartão
    private double saldo; // saldo disponível atual
    private List<Compra> compras; // lista de compras realizadas

    // Construtor: recebe o limite e inicializa o saldo e lista de compras
    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    // Método que tenta registrar uma compra no cartão
    public boolean lancaCompra (Compra compra) {
        // verifica se há saldo suficiente para a compra
        if (this.saldo > compra.getValor()) {
            this.saldo -= compra.getValor();  // reduz o saldo pelo valor da compra
            this.compras.add(compra);  // adiciona a compra à lista de compras
            return true;  // compra aprovada
        } else {
            return false;  // compra negada por falta de saldo
        }
    }

    // Getters
    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
