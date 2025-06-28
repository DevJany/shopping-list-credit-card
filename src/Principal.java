import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        // Solicita o limite inicial do cartão de crédito
        System.out.println("Informe o limite do seu cartão de crédito: ");
        double limite = leitura.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        int sair = 1;
        while (sair != 0) {
            // Solicita a descrição da compra
            System.out.println("Qual produto você deseja compra? ");
            leitura.nextLine();
            String descricao = leitura.nextLine();

            // Solicita o valor do produto
            System.out.println("Qual o valor do produto? ");
            double valor = leitura.nextDouble();

            // Cria uma nova compra no cartão de crédito
            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartao.lancaCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada com sucesso!");
                // Pergunta se o usuário deseja realizar outra compra
                System.out.println("Deseja realizar outra compra? (1 - Sim, 0 - Não)");
                sair = leitura.nextInt();
            } else {
                System.out.println("Saldo insuficiente para realizar a compra.");
                sair = 0; // Encerra o loop se a compra for negada
            }
        }

        // Exibe as compras realizadas, ordenadas pelo valor
        System.out.println("------------------------------");
        System.out.println("Compras Realizadas:\n");
        Collections.sort(cartao.getCompras());
        for (Compra c : cartao.getCompras()) {
            System.out.println(c.getDescricao() + " - " + c.getValor()
            + "\n");
        }

        // Exibe o saldo restante do cartão de crédito
        System.out.println("\n------------------------------");
        System.out.println("\nSaldo do cartão: R$" + cartao.getSaldo());

    }
}
