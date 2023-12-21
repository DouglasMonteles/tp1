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


#### Relação com os maus-cheiros

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

#### Relação com os maus-cheiros

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

### Portabilidade 

#### Descrição

Descrição

A portabilidade é a capacidade de um código ser executado em diferentes plataformas, ambientes ou linguagens. Um código portátil é aquele que não depende de recursos específicos de uma plataforma ou ambiente, e que pode ser facilmente adaptado para funcionar em outros contextos.

A portabilidade pode ser obtida de várias maneiras, incluindo:

- Uso de padrões e APIs padrão: O uso de padrões e APIs padrão ajuda a garantir que o código seja independente de uma plataforma ou linguagem específica.
- Uso de abstrações: O uso de abstrações permite que o código seja escrito de forma genérica, sem depender de implementações específicas.
- Uso de testes automatizados: Os testes automatizados podem ajudar a garantir que o código funcione corretamente em diferentes plataformas e ambientes.
Efeitos no código

A portabilidade tem vários efeitos positivos no código, incluindo:

- Melhora a estrutura do código: O código portátil é geralmente mais estruturado e organizado, o que o torna mais fácil de entender e manter.
- Melhora a claridade do código: O código portátil é geralmente mais claro e conciso, o que o torna mais fácil de ler e entender.
- Melhora a coesão do código: O código portátil é geralmente mais coeso, o que o torna mais fácil de testar e depurar.
Reduz o acoplamento do código: O código portátil é geralmente menos acoplado, o que o torna mais fácil de modificar e estender.
#### Relação com os maus-cheiros
- Codigo acoplado: O código portátil é geralmente menos acoplado, o que ajuda a reduzir o risco de alterações em um componente afetarem outros componentes.
- Codigo redundante: O código portátil pode ajudar a reduzir a redundância, o que pode tornar o código mais fácil de entender e manter.
- Codigo centralizado: O código portátil pode ajudar a distribuir o controle do código, o que pode ajudar a melhorar a flexibilidade e a resiliência do sistema.

#### Operação de Refatoração
```java

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto: estoqueProdutos) {
            if(produto.getNome().equalsIgnoreCase(nome)){
                produto.buscaNome();
                return produto;
            }
        }

        return null;
    }

    public Produto buscarProdutoPorCodigoDeBarra(String codigoBarra){
        for(Produto produto: estoqueProdutos){
            if(produto.getCodigoBarras().equals(codigoBarra)){
                produto.buscaNome();
                return produto;
            }
        }

        return null;
    }


    public void adicionarProduto(Produto produto){
        this.estoqueProdutos.add(produto);
    }

    public void listarProdutos(){
        for(Produto produto: estoqueProdutos){
            System.out.println("Produto{" +
                    "nome=" + produto.getNome() +
                    ",  quantidadeDisponivel=" + produto.getQuantidadeDisponivel() +
                    '}');
        }

    }

```




<br/>

### Elegancia

#### Descrição
Elegância é uma característica de um código que o torna agradável de ler, entender e manter. Ela é uma combinação de vários fatores, incluindo:


- Estrutura: O código deve ser bem estruturado, com uma organização lógica e clara.
- Claridade: O código deve ser claro e fácil de entender, mesmo para pessoas que não estão familiarizadas com ele.
- Coesão: As diferentes partes do código devem estar relacionadas entre si de forma significativa.
- Acoplamento: As diferentes partes do código devem estar acopladas de forma fraca, de modo que possam ser facilmente alteradas ou substituídas.

- Facilidade de compreensão: O código elegante é mais fácil de entender, mesmo para pessoas que não estão familiarizadas com ele. Isso torna mais fácil para os desenvolvedores trabalharem com o código, para os QAs testarem o código e para os usuários usarem o software.
- Facilidade de manutenção: O código elegante é mais fácil de manter, pois as mudanças são mais fáceis de serem feitas sem afetar outras partes do código. Isso reduz o custo de manutenção do software.
- Redução de erros: O código elegante é menos propenso a erros, pois é mais fácil de entender e manter. Isso melhora a qualidade do software.

#### Relação com os maus-cheiros
- Coesão fraca: O código elegante tem uma coesão forte, o que significa que as diferentes partes do código estão relacionadas entre si de forma significativa. Isso ajuda a evitar o mau cheiro de coesão fraca.
- Acoplamento forte: O código elegante tem um acoplamento fraco, o que significa que as diferentes partes do código estão acopladas de forma fraca. Isso ajuda a evitar o mau cheiro de acoplamento forte.
- Duplicação: O código elegante evita a duplicação, o que significa que o código não é repetido em diferentes partes do código. Isso ajuda a evitar o mau cheiro de duplicação.
- Codigo acoplado a interfaces externas: O código elegante não deve estar acoplado a interfaces externas, o que significa que o código não deve depender de bibliotecas ou frameworks externos. Isso ajuda a evitar o mau cheiro de código acoplado a interfaces externas.

#### Operação de Refatoração
```java
public TestesConsultaEstoque(String nome, String codigoBarra, double custo, double precoVenda, Integer quantidadeDisponivel) {
        this.nome = nome;
        this.codigoBarra = codigoBarra;
        this.custo = new BigDecimal(custo);
        this.precoVenda = new BigDecimal(precoVenda);
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    @Test
    public void testBuscarProdutoPorNomeCorreto() {
        Produto produtoNome = new Produto(nome, codigoBarra, custo.doubleValue(), precoVenda.doubleValue(), quantidadeDisponivel);
        estoque.adicionarProduto(produtoNome);

        Produto comparar = estoque.buscarProdutoPorNome("Sasami");

        assertEquals(comparar.getNome(), produtoNome.getNome());
        assertEquals(comparar.getCodigoBarras(), produtoNome.getCodigoBarras());
        assertEquals(comparar.getPrecoCompra(), produtoNome.getPrecoCompra());
        assertEquals(comparar.getPrecoVenda(), produtoNome.getPrecoVenda());
        assertEquals(comparar.getQuantidadeDisponivel(), produtoNome.getQuantidadeDisponivel());
    }

    @Test
    public void testBuscarProdutoPorNomeInexistente() {
        Produto compararInexistente = estoque.buscarProdutoPorNome("leite");
        assertNull(compararInexistente);
    }

    @Test
    public void testBuscarProdutoPorCodigoDeBarraCorreto() {
        Produto produtoCodigoBarra = new Produto(nome, codigoBarra, custo.doubleValue(), precoVenda.doubleValue(), quantidadeDisponivel);
        estoque.adicionarProduto(produtoCodigoBarra);

        Produto comparar = estoque.buscarProdutoPorCodigoDeBarra("2023");

        assertEquals(comparar.getNome(), produtoCodigoBarra.getNome());
        assertEquals(comparar.getCodigoBarras(), produtoCodigoBarra.getCodigoBarras());
        assertEquals(comparar.getPrecoCompra(), produtoCodigoBarra.getPrecoCompra());
        assertEquals(comparar.getPrecoVenda(), produtoCodigoBarra.getPrecoVenda());
        assertEquals(comparar.getQuantidadeDisponivel(), produtoCodigoBarra.getQuantidadeDisponivel());
    }

    @Test
    public void testBuscarProdutoPorCodigoDeBarraInexistente() {
        Produto compararInexistente = estoque.buscarProdutoPorCodigoDeBarra("2000");
        assertNull(compararInexistente);
    }

    @Test
    public void testListarEstoque() {
        Produto produtoCodigoBarra = new Produto(nome, codigoBarra, custo.doubleValue(), precoVenda.doubleValue(), quantidadeDisponivel);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        estoque.adicionarProduto(produtoCodigoBarra);

        estoque.listarProdutos();
        String mensagemDeSaida = outputStream.toString().trim();

        System.out.println(mensagemDeSaida);
        assertEquals("Produto{nome=Sasami,  quantidadeDisponivel=50}", mensagemDeSaida);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> obterParametros() {
        Object[][] parametros = new Object[][] {
                {"Sasami", "2023", 17.80, 26.99, 50}
        };

        return Arrays.asList(parametros);
    }
}


```


## Ingrid


### Simplicidade

#### Descrição
A simplicidade é uma característica fundamental no desenvolvimento de software, e quando aplicada a um projeto Java, ela pode ter impactos significativos na estrutura, claridade, coesão, acoplamento e outros aspectos relacionados ao código. Aqui estão alguns dos efeitos aplicáveis:

- Estrutura Clara e Concisa: Projetos Java que priorizam a simplicidade tendem a ter uma estrutura mais clara e concisa. Classes e métodos são organizados de forma lógica e fácil de entender, facilitando a navegação e manutenção do código.

- Clareza de Propósito: A simplicidade no código Java geralmente resulta em métodos e classes que têm um propósito claro e específico. Cada componente realiza uma função bem definida, tornando o código mais compreensível para desenvolvedores que o mantêm ou trabalham nele pela primeira vez.
    
- Facilidade de Manutenção: Projetos simples são mais fáceis de manter. As alterações e correções podem ser feitas com menos esforço, pois não há complexidade desnecessária a ser compreendida. Isso contribui para a agilidade no desenvolvimento e reduz a probabilidade de introduzir erros durante as atualizações.

- Coesão Aprimorada: A simplicidade promove a coesão, ou seja, a medida em que os elementos de um módulo estão relacionados entre si. Métodos e classes simples geralmente têm uma responsabilidade única, o que melhora a coesão. Isso facilita a compreensão do código e a manutenção futura.
  
- Facilidade de Testes: Projetos simples são mais fáceis de testar, pois as funcionalidades são divididas em partes pequenas e isoladas. Isso facilita a criação de testes unitários eficazes, garantindo que cada parte do código funcione conforme o esperado.

- Menor Custo de Aprendizado: Desenvolvedores novos ou externos ao projeto podem compreender mais rapidamente um código simples. Isso reduz o tempo necessário para se familiarizar com o sistema e aumenta a eficiência da equipe de desenvolvimento.

#### Relação com os maus-cheiros
Existem diferentes tipos de maus-cheiros de código, e a busca pela simplicidade pode ajudar a combater vários deles. Vamos examinar como a simplicidade está relacionada a alguns maus-cheiros comuns identificados por Fowler:

- Má Nomenclatura (Bad Smell - Nomes Ruins):
    Nomes de variáveis, métodos ou classes pouco descritivos são considerados um mau-cheiro de código. A simplicidade promove o uso de nomes claros e significativos, facilitando a compreensão do código sem a necessidade de comentários excessivos.
     
    *Exemplo*: Como podemos ver na classe PedidoCodeSmells, podemos ver abaixo o uso da simplicidade que resultaria em mau cheiro, pois causaria confusão os atributos com nomes não explicativos.

    ``` java
    public class PedidoCodeSmells {
        private String nome;
        private int qty;
        private double p;

        public PedidoCodeSmells(String n, int q, double p) {
            this.nome = n;
            this.qty = q;
            this.p = calcularPreco(p);
        }

        private double calcularPreco(double precoUnitario) {
            return qty * precoUnitario;
        }

        public double obterPreco() {
            return p;
        }

        public String getProduto() {
            return nome;
        }

        public int getQuantidade() {
            return qty;
        }
    }
 
    ```



#### Operação de Refatoração
Aqui podemos ver o codigo com simplicidade, nomes descritivos e consistência contribuindo para um código mais limpo e fácil de entender.

``` java
public class PedidoSimples {
    private String produto;
    private int quantidade;
    private double precoTotal;

    public PedidoSimples(String produto, int quantidade, double precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTotal = calcularPrecoTotal(precoUnitario);
    }

    private double calcularPrecoTotal(double precoUnitario) {
        return quantidade * precoUnitario;
    }

    // Getters...
}
```

<br/>

### Nome da característica

#### Descrição
A ausência de duplicidade, também conhecida como "Don't Repeat Yourself" (DRY), é uma característica de design de software que enfatiza a eliminação de redundâncias no código. Isso implica que cada pedaço de conhecimento ou lógica no sistema deve ser expresso em apenas um lugar. Aqui estão alguns efeitos dessa característica no código de um projeto:

- Estrutura Mais Clara: Quando a duplicidade é evitada, a estrutura do código tende a ser mais clara e organizada. Módulos, classes e métodos podem ser projetados de forma mais concisa, facilitando a compreensão do código global.
- Facilidade de Manutenção:
    Código sem duplicidade é mais fácil de manter, pois as alterações e atualizações precisam ser feitas apenas em um local. Isso reduz o risco de inconsistências e erros decorrentes de alterações não sincronizadas em diferentes partes do código.

- Reusabilidade Aprimorada: A ausência de duplicidade promove a reusabilidade do código. Lógicas específicas podem ser encapsuladas em funções ou classes, e essas abstrações podem ser facilmente reutilizadas em diferentes partes do projeto, aumentando a eficiência do desenvolvimento.

- Coesão Reforçada: Evitar duplicidade geralmente leva a uma maior coesão. Módulos e classes têm responsabilidades mais claras e específicas, pois não estão ocupadas repetindo lógicas existentes em outros lugares. Isso contribui para um design mais coeso e modular.
  
- Baixo Acoplamento: A ausência de duplicidade pode reduzir o acoplamento entre diferentes partes do sistema. Se um mesmo trecho de lógica é usado em várias partes do código, alterações em um local podem afetar inesperadamente outros locais. Evitar duplicidade diminui esse risco.

- Clareza e Legibilidade: Código sem duplicidade tende a ser mais claro e legível. Desenvolvedores podem entender mais facilmente o propósito de uma parte do código, pois não há variações ou redundâncias confusas.

- Manutenção Menos Propensa a Erros: A ausência de duplicidade reduz a propensão a erros de manutenção. Alterações em um local não exigem a busca por todos os lugares onde um trecho de lógica está duplicado, minimizando o risco de esquecimentos ou inconsistências.
  
- Facilidade de Testes: Código sem duplicidade é mais fácil de testar. Uma vez que a lógica é centralizada, os testes podem ser aplicados de maneira mais eficiente e abrangente, garantindo que a funcionalidade seja consistente em todos os usos.

#### Relação com os maus-cheiros
O código com duplicidade repete estruturas de loop e operações similares em duas funções diferentes, o que torna o código mais difícil de manter e aumenta a chance de inconsistências. Por exemplo: 

``` java
public class CarrinhoCompraDuplicidade {

    public double calcularPrecoTotal(List<Produto> produtos) {
        double precoTotal = 0;

        for (Produto produto : produtos) {
            precoTotal += produto.getPreco();
        }

        return precoTotal;
    }

    public double calcularDescontoTotal(List<Produto> produtos) {
        double descontoTotal = 0;

        for (Produto produto : produtos) {
            descontoTotal += produto.getDesconto();
        }

        return descontoTotal;
    }
}

```

#### Operação de Refatoração

Manutenibilidade:

Nesta refatoração, introduzimos uma interface Calculadora que define um método calcular, permitindo diferentes estratégias de cálculo. Criamos duas implementações específicas dessa interface: CalculadoraPreco e CalculadoraDesconto, cada uma responsável por um tipo específico de cálculo.

A classe CarrinhoCompra agora aceita uma instância de Calculadora como parâmetro, tornando o código mais flexível e extensível. Você pode facilmente adicionar novos tipos de cálculos sem modificar o código existente.

Essa abordagem elimina a duplicidade ao separar as responsabilidades de cálculo e permite uma extensibilidade fácil para futuros tipos de cálculos. Além disso, é mais alinhada com os princípios de orientação a objetos, facilitando a manutenção e compreensão do código


```java
import java.util.List;

public class CarrinhoCompra {

    public double calcularTotal(List<Produto> produtos, Calculadora calculadora) {
        double resultado = 0;

        for (Produto produto : produtos) {
            resultado += calculadora.calcular(produto);
        }

        return resultado;
    }
}

interface Calculadora {
    double calcular(Produto produto);
}

class CalculadoraPreco implements Calculadora {
    @Override
    public double calcular(Produto produto) {
        return produto.getPreco();
    }
}

class CalculadoraDesconto implements Calculadora {
    @Override
    public double calcular(Produto produto) {
        return produto.getDesconto();
    }
}

```


```java
public class Main {
    public static void main(String[] args) {
        CarrinhoCompra carrinho = new CarrinhoCompra();
        List<Produto> produtos = // Obtenha a lista de produtos

        Calculadora calculadoraPreco = new CalculadoraPreco();
        double totalPreco = carrinho.calcularTotal(produtos, calculadoraPreco);
        System.out.println("Total Preço: " + totalPreco);

        Calculadora calculadoraDesconto = new CalculadoraDesconto();
        double totalDesconto = carrinho.calcularTotal(produtos, calculadoraDesconto);
        System.out.println("Total Desconto: " + totalDesconto);
    }
}

```



