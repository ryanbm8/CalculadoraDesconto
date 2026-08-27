package loja;

import java.util.Scanner;

public class Loja {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] historico = new double[10];
        int posicao = 0;
        double totalDescontos = 0;
        int numDescontos = 0;

        while (true) {

            System.out.println("=== CALCULADORA DE DESCONTOS ===");
            System.out.println("1. Calcular desconto");
            System.out.println("2. Ver histórico");
            System.out.println("3. Ver estatísticas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            int calculadoraDesconto;
            double verEstatistica, verHistorico;

            switch (opcao) {
                case 1:
                    System.out.println("[NOVA COMPRA]");
                    System.out.print("Digite o valor da compra: ");
                    double valorCompra = scanner.nextDouble();

                    if (valorCompra <= 0) {
                        System.out.println("Valor da compra não pode ser menor que zero!");
                        break;
                    }
                    scanner.nextLine();
                    System.out.print("Tipo de Cliente (Regular= R) ou (VIP=V): ");
                    String tipoCliente = scanner.nextLine();
                    double desconto = 0;
                    double valorDesconto = 0;
                    double valorFinal = 0;

                    if (tipoCliente.equals("V")) {

                        desconto = 0.10;
                        valorDesconto = valorCompra * desconto;
                        valorFinal = valorCompra - valorDesconto;
                    } else if (tipoCliente.equals("R")) {

                        desconto = 0.05;
                        valorDesconto = valorCompra * desconto;
                        valorFinal = valorCompra - valorDesconto;
                    } else {
                        System.out.println("Tipo de cliente inválido!");
                        break;
                    }

                    historico[posicao] = valorDesconto;
                    posicao = (posicao + 1) % 10;

                    totalDescontos += valorDesconto;
                    numDescontos++;

                    System.out.println("[RESULTADO]");
                    System.out.printf("Valor da Compra: R$ %.2f\n", valorCompra);
                    System.out.printf("Desconto de %.0f%%: R$ %.2f\n", desconto * 100, valorDesconto);
                    System.out.printf("Valor final: R$ %.2f\n", valorFinal);
                    break;

                case 2:
                    System.out.println("[HISTÓRICO]");
                    for (int i = 0; i < 10; i++) {
                        if (historico[i] != 0) {
                            System.out.printf("%d. R$ %.2f\n", i + 1, historico[i]);
                        }
                    }
                    break;
                case 3:
                    if (numDescontos == 0) {
                        System.out.println("Nenhum desconto aplicado!");
                    } else {
                        double maiorDesconto = historico[0];
                        double menorDesconto = historico[0];

                        for (int i = 1; i < historico.length; i++) {
                            // Verifica o maior desconto
                            if (historico[i] > maiorDesconto) {
                                maiorDesconto = historico[i];
                            }

                            if (historico[i] < menorDesconto && historico[i] != 0) {
                                menorDesconto = historico[i];
                            }
                            double mediaDescontos = totalDescontos / numDescontos;

                            System.out.println("[ESTATÍSTICAS]");
                            System.out.printf("Total de descontos: R$ %.2f\n", totalDescontos);
                            System.out.printf("Maior desconto: R$ %.2f\n", maiorDesconto);
                            System.out.printf("Menor desconto: R$ %.2f\n", menorDesconto);
                            System.out.printf("Média dos descontos: R$ %.2f\n", mediaDescontos);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Opção escolhida (4), programa finalizado!");
                    return;
            }
        }
    }
}
