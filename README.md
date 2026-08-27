# Calculadora de Descontos
Projeto do 2 Semestre da ETB em LTP I

Projeto desenvolvido em Java para calcular descontos em compras de acordo com o tipo de cliente. O sistema também permite consultar o histórico dos descontos aplicados e visualizar estatísticas das operações realizadas.

## Sobre o projeto

A aplicação possui dois componentes principais:

* `Loja.java`: responsável pela interação com o usuário, menu principal, entrada de dados e apresentação dos resultados.
* `CalculadoraDesconto.java`: responsável pelo cálculo e armazenamento do histórico dos descontos.

A classe `CalculadoraDesconto` possui um histórico com capacidade para armazenar até 10 descontos, utilizando um array e controle de posição.

## Funcionalidades

O programa possui quatro opções principais:

1. **Calcular desconto**
2. **Ver histórico**
3. **Ver estatísticas**
4. **Sair**

Essas opções são apresentadas por meio de um menu executado continuamente enquanto o usuário não escolher sair.

### Cálculo de desconto

O usuário informa o valor da compra e o tipo de cliente.

Existem dois tipos:

* **Cliente VIP (`V`)**: recebe **10% de desconto**.
* **Cliente Regular (`R`)**: recebe **5% de desconto**.

O sistema calcula o valor do desconto e, em seguida, calcula o valor final da compra.

A classe `CalculadoraDesconto` também implementa essa regra de desconto, considerando `V` ou `v` como cliente VIP e aplicando 10%; para os demais casos, aplica 5%.

### Histórico

Os descontos aplicados são armazenados em um array com capacidade para 10 valores.

Quando o limite é atingido, a posição de armazenamento volta ao início do array, permitindo que o histórico seja reutilizado de forma circular.

O usuário pode selecionar a opção **2 - Ver histórico** para visualizar os descontos armazenados.

### Estatísticas

O sistema apresenta:

* Total dos descontos;
* Maior desconto;
* Menor desconto;
* Média dos descontos.

A média é calculada utilizando o total de descontos dividido pela quantidade de descontos realizados.

## Validações

O programa verifica se o valor da compra é válido. Caso o valor seja menor ou igual a zero, uma mensagem de erro é exibida e a operação é interrompida.

Também existe uma validação do tipo de cliente. Caso o usuário informe algo diferente de `R` ou `V`, o sistema informa que o tipo de cliente é inválido.

## Tecnologias utilizadas

* Java
* `Scanner` para entrada de dados
* Arrays (`double[]`)
* Estruturas condicionais (`if`, `else if`, `else`)
* Estrutura de repetição (`while`)
* Estrutura de seleção (`switch`)
* Métodos
* Classes e objetos
* Formatação de saída com `printf`

## Estrutura do projeto

```text
src/
├── calculadoradesconto/
│   └── CalculadoraDesconto.java
│
└── loja/
    └── Loja.java
```

## Como executar

1. Tenha o **Java JDK** instalado.
2. Abra o projeto em uma IDE, como IntelliJ IDEA, NetBeans ou Eclipse.
3. Compile os arquivos Java.
4. Execute a classe `Loja`.
5. Utilize o menu apresentado no terminal.

A classe `Loja` contém o método `main`, sendo o ponto de entrada da aplicação.

## Exemplo de funcionamento

```text
=== CALCULADORA DE DESCONTOS ===
1. Calcular desconto
2. Ver histórico
3. Ver estatísticas
4. Sair
Escolha uma opção: 1

[NOVA COMPRA]
Digite o valor da compra: 100
Tipo de Cliente (Regular= R) ou (VIP=V): V

[RESULTADO]
Valor da Compra: R$ 100.00
Desconto de 10%: R$ 10.00
Valor final: R$ 90.00
```

## Objetivo

O projeto tem como objetivo praticar conceitos fundamentais da programação em Java, principalmente:

* Manipulação de dados;
* Estruturas de controle;
* Arrays;
* Métodos;
* Organização de classes;
* Entrada e saída de dados;
* Cálculos matemáticos;
* Armazenamento e consulta de informações.

## Autor

Projeto acadêmico desenvolvido para prática de programação em Java.
