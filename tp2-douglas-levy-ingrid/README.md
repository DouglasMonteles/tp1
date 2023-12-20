# Trabalho Prático 2

## 👥 Grupo

| Matrícula | Aluno                                                      | 
| --------- | ---------------------------------------------------------- |
| 190012200	| [Douglas Monteles](https://github.com/DouglasMonteles)  |
| 180016067	| [Erik Levy](https://github.com/Eric-chagas)  |
| 190029731 | [Ingrid Carvalho](https://github.com/IngridSCarvalho)      |

## Enunciado

[Enunciado do trabalho 2](https://github.com/andrelanna/fga0242/blob/master/tp2/README.md)

# Características trabalhadas

## Douglas

### Modularidade (baixo acoplamento e alta coesão);

#### Descrição
Modularidade no desenvolvimento de software se refere à prática de dividir o sistema em partes independentes e interconectadas, chamadas de módulos. Dois conceitos-chave associados à modularidade são o baixo acoplamento e a alta coesão.

- Estrutura do Código:

  *Baixo Acoplamento*: Quando os módulos têm baixo acoplamento, o código é estruturado de forma que as dependências entre os diferentes componentes são minimizadas.
  
  *Alta Coesão*: A alta coesão cria módulos bem definidos e focados em tarefas específicas. 

- Clareza e Legibilidade:

  *Baixo Acoplamento*: Reduzir as dependências entre módulos aumenta a clareza do código.

  *Alta Coesão*: Módulos altamente coesos têm um propósito bem definido, o que torna mais fácil para os desenvolvedores entenderem o que cada parte do código faz.

- Coesão e Acoplamento:

  *Baixo Acoplamento*: Reduzir o acoplamento entre os módulos ajuda a diminuir os riscos de efeitos colaterais ao modificar ou atualizar partes do sistema.

  *Alta Coesão*: A alta coesão permite que cada módulo realize suas tarefas sem depender excessivamente de outros módulos.

- Facilidade de Manutenção e Testabilidade:

  *Baixo Acoplamento*: Módulos com baixo acoplamento são mais fáceis de manter, pois as mudanças em um módulo têm menos impacto no resto do sistema.

  *Alta Coesão*: Módulos altamente coesos são mais fáceis de manter, pois suas funcionalidades estão logicamente agrupadas.


#### Relação com os meus-cheiros

O Baixo acoplamento definido pela modularização é o oposto do acoplamento excessivo. Quando os módulos estão altamente acoplados, mudanças em um componente afetam fortemente outros componentes, o que torna o código mais frágil e difícil de manter. 

Também podemos aplicar a modularização nos casos de duplicação de código, que é muitas vezes um sinal de falta de modularidade, onde funcionalidades similares não estão encapsuladas em módulos reutilizáveis.

#### Operação de Refatoração
No projeto entregue no [tp1](https://github.com/douglasMonteles/tp1), temos a classe [Produto](https://github.com/DouglasMonteles/tp1/blob/main/tp1/src/main/java/com/fga/tppe/tp1/models/Produto.java). Nela, podemos observar vários métodos de validação:

- private void validarEntradas(String nome, String codigoBarras, Double precoCompra, Double precoVenda, Integer quantidadeEstoque);
- private void validarQuantidadeNegativa(int quantidade);

Podemos separar estes métodos em um módulo de `validação` e permitir que estes métodos sejam reutilizados por outras partes da aplicação que também realizam a mesmas validações.

Todas os operações dessa refatoração foram registradas na branch: [refatoracao-modularidade](https://github.com/DouglasMonteles/tp1/tree/refatoracao-modularidade)

```java
package com.fga.tppe.tp1.services;

import com.fga.tppe.tp1.exceptions.DescricaoEmBrancoException;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;

public class Validacao {

    public static void validarEntradas(String nome, String codigoBarras, Double precoCompra, Double precoVenda, Integer quantidadeEstoque)
            throws DescricaoEmBrancoException, ValorInvalidoException {
        if (nome == null || codigoBarras == null || nome.isEmpty() || codigoBarras.isEmpty() ||
                precoCompra == null || precoVenda == null || quantidadeEstoque == null){
            throw new DescricaoEmBrancoException("Os campos não pode estar em branco");
        }
        if (precoCompra <= 0 || precoVenda <= 0 || quantidadeEstoque <= 0){
            throw new ValorInvalidoException("Valores de compra, venda e quantidade devem ser maiores que zero");
        }
    }

    // Método para validar se a quantidade fornecida para a transacao eh negativa e lancar a excecao nesses casos
    public static void validarQuantidadeNegativa(int quantidade) {
        if (quantidade < 0) {
            throw new ValorInvalidoException("Quantidade não pode ser negativa.");
        }
    }

}
```

Todos os testes continuam passando:

![image](https://github.com/DouglasMonteles/tp1/assets/54580766/0b48e6ee-78fa-4688-9beb-c338c64b421e)

Commit da aplicação dessa funcionalidade: [commit de interface](https://github.com/DouglasMonteles/tp1/commit/071e9b6737656a02fb77b1a29fff6dea07fe47db)

<br/>

### Boas interfaces

#### Descrição

Uma boa interface em programação é crucial para criar um código claro, coeso e modular. Abaixo estão alguns dos principais efeitos positivos de uma boa interface no código:

- Estrutura clara e organizada: Uma interface bem definida proporciona uma estrutura clara para o código. 

- Coesão e separação de responsabilidades: Interfaces ajudam a separar as responsabilidades dentro do código. 

- Redução do acoplamento: Interfaces reduzem o acoplamento entre diferentes partes do código, permitindo que diferentes componentes interajam através de contratos bem definidos.

- Facilidade de testes: Interfaces permitem a criação de mocks e simulações para testes unitários.

- Reusabilidade de código: Interfaces promovem a reutilização de código.

- Legibilidade e documentação: Interfaces bem nomeadas e descritivas servem como documentação do código.

#### Relação com os meus-cheiros

- Código Duplicado: A falta de interfaces claras e reutilizáveis pode levar à duplicação de código. Se várias classes têm funcionalidades semelhantes, mas não implementam uma interface comum, é provável que haja repetição de código para essas funcionalidades.
- Feature Envy (Inveja de Funcionalidade): Quando uma classe está excessivamente interessada nos detalhes internos de outra classe (e, portanto, "inveja" sua funcionalidade), pode ser porque não há uma interface apropriada que defina claramente como interagir com essa classe. A falta de uma interface pode levar a dependências diretas excessivas entre classes, resultando em feature envy.

#### Operação de Refatoração

Ainda na classe [Produto](https://github.com/DouglasMonteles/tp1/blob/main/tp1/src/main/java/com/fga/tppe/tp1/models/Produto.java), temos alguns métodos relacionados ao controle de estoque (recebimento, venda, devolução, ajuste, transferência), que podem ser transferidos para um novo módulo, a fim de tornar mais claro e coeso o propósito desses métodos. Ao transferir estes métodos para um serviço, precisaremos criar uma interface para garantir que a especificação destes métodos não sofrerá duplicação e para que possamos fazer com que a nossa aplicação dependa somente de abstrações e não de implementações.

```java
package com.fga.tppe.tp1.services;

import com.fga.tppe.tp1.models.Produto;

public interface ProdutoService {

    public boolean confereValidade(Produto produto);

    public Produto cadastroProduto(String nome, String codigoBarras, double precoCompra, double precoVenda, int quantidadeEstoque);

}
```

```java
package com.fga.tppe.tp1.services.impl;

import com.fga.tppe.tp1.exceptions.DescricaoEmBrancoException;
import com.fga.tppe.tp1.exceptions.ValorInvalidoException;
import com.fga.tppe.tp1.models.Lote;
import com.fga.tppe.tp1.models.Produto;
import com.fga.tppe.tp1.services.ProdutoService;
import com.fga.tppe.tp1.services.Validacao;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    public Produto cadastroProduto(String nome, String codigoBarras, double precoCompra, double precoVenda, int quantidadeEstoque)
            throws DescricaoEmBrancoException, ValorInvalidoException {
        Produto produto = new Produto();
        Validacao.validarEntradas(nome, codigoBarras, precoCompra, precoVenda, quantidadeEstoque);
        produto.setNome(nome);
        produto.setCodigoBarras(codigoBarras);
        produto.setPrecoCompra(precoCompra);
        produto.setPrecoVenda(precoVenda);
        produto.setQuantidadeEstoque(quantidadeEstoque);

        System.out.println("Produto cadastrado com sucesso!");
        return produto;
    }

    public boolean confereValidade(Produto produto){

        Date dataAtual = new Date();
        Lote lote = produto.getLote();
        double precoVenda = produto.getPrecoVenda();

        long tresDiasMillis = 3 * 24 * 60 * 60 * 1000L;
        Date dataAtualMenos3Dias = new Date(dataAtual.getTime() - tresDiasMillis);

        if (lote.getValidade().before(dataAtualMenos3Dias)) {
            System.out.println("A data de validade é anterior a 3 dias atrás da data atual.");
            precoVenda = precoVenda - (precoVenda * 0.2);
            return true;
        } else if (lote.getValidade().equals(dataAtualMenos3Dias)) {
            System.out.println("A data de validade é exatamente 3 dias atrás da data atual.");
            return false;
        } else {
            System.out.println("A data de validade é posterior a 3 dias atrás da data atual.");
            return false;
        }
    }

}

```

Todos os testes continuam passando:

![image](https://github.com/DouglasMonteles/tp1/assets/54580766/fa26d213-e9ed-4539-a670-2892c9b8385c)

Commit da aplicação dessa funcionalidade: [commit de interface](https://github.com/DouglasMonteles/tp1/commit/274aa6657c809d704eb7e2028a95044668f67f3e)

## Levy

### Nome da característica

#### Descrição
Uma descrição da característica, mostrando claramente quais são os seus efeitos no código (em termo de estrutura, claridade, coesão, acoplamento dentre outros efeitos aplicáveis)

#### Relação com os meus-cheiros
uma relação da característica com os maus-cheiros de código definidos por Fowler. Uma descrição dos maus cheiros está disponível nos slides sobre o conteúdo de refatoração;

#### Operação de Refatoração
pelo menos uma operação de refatoração capaz de levar o projeto de código a ter a característica em análise

<br/>

### Nome da característica

#### Descrição
Uma descrição da característica, mostrando claramente quais são os seus efeitos no código (em termo de estrutura, claridade, coesão, acoplamento dentre outros efeitos aplicáveis)

#### Relação com os meus-cheiros
uma relação da característica com os maus-cheiros de código definidos por Fowler. Uma descrição dos maus cheiros está disponível nos slides sobre o conteúdo de refatoração;

#### Operação de Refatoração
pelo menos uma operação de refatoração capaz de levar o projeto de código a ter a característica em análise


## Ingrid

### Nome da característica

#### Descrição
Uma descrição da característica, mostrando claramente quais são os seus efeitos no código (em termo de estrutura, claridade, coesão, acoplamento dentre outros efeitos aplicáveis)

#### Relação com os meus-cheiros
uma relação da característica com os maus-cheiros de código definidos por Fowler. Uma descrição dos maus cheiros está disponível nos slides sobre o conteúdo de refatoração;

#### Operação de Refatoração
pelo menos uma operação de refatoração capaz de levar o projeto de código a ter a característica em análise

<br/>

### Nome da característica

#### Descrição
Uma descrição da característica, mostrando claramente quais são os seus efeitos no código (em termo de estrutura, claridade, coesão, acoplamento dentre outros efeitos aplicáveis)

#### Relação com os meus-cheiros
uma relação da característica com os maus-cheiros de código definidos por Fowler. Uma descrição dos maus cheiros está disponível nos slides sobre o conteúdo de refatoração;

#### Operação de Refatoração
pelo menos uma operação de refatoração capaz de levar o projeto de código a ter a característica em análise

