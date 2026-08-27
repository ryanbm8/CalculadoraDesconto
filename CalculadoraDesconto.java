package calculadoradesconto;

public class CalculadoraDesconto {

    double[] historico = new double[10];
    int contador = 0;

    public double calcular(double valorCompra, char tipoCliente) {
        double desconto;

        if (tipoCliente == 'V' || tipoCliente == 'v') {
            desconto = valorCompra * 0.10;
        } else {
            desconto = valorCompra * 0.05;
        }

        armazenarNoHistorico(desconto);
        return desconto;
    }

    void armazenarNoHistorico(double desconto) {
        historico[contador % 10] = desconto;
        contador++;
    }

    void mostrarHistorico() {
        System.out.println("\n[HISTÓRICO]");

        int inicio = 0;
        if (inicio < 0){
            inicio = 0;
        }

        for (int i = inicio; i < contador; i++) {
            System.out.printf("%d. R$ %.2f%n", i + 1, historico[i % 10]);
        }
        System.out.println();
    }

    void mostrarEstatisticas() {
        if (contador == 0) {
            System.out.println("Nenhum desconto aplicado ainda.");
            return;
        }

        double total = 0;
        double maior = 0;
        double menor = 0;

       int inicio = contador - 10;
            if (inicio < 0) {
                inicio = 0;
            }

        for (int i = inicio; i < contador; i++) {
            double desconto = historico[i % 10];
            total += desconto;
            if (desconto > maior) {
                maior = desconto;
            }
            if (desconto < menor) {
                menor = desconto;
            }
        }

        double media;
        if (contador < 10) {
            media = total / contador;
        }else{
            media = total / 10;
        }
        

        System.out.println("\n[ESTATÍSTICA]");
        System.out.printf("Total de descontos: R$ %.2f\n" , total);
        System.out.printf("Maior desconto: R$ %.2f\n" , maior);
        System.out.printf("Menor desconto: R$ %.2f\n" ,  menor);
        System.out.printf("Média de desconto: R$ %.2f\n", media);
        System.out.println();
    }
}