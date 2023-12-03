 ##  💻 Visão Geral

Seja o cenário descrito a seguir:

Um sistema de estoque e inventário é uma aplicação de software projetada para ajudar as empresas a gerenciar eficientemente o controle de estoque e o acompanhamento de mercadorias. Esses sistemas são essenciais para empresas que mantêm um inventário de produtos físicos, sejam eles materiais para produção, produtos acabados para venda ou componentes diversos.

O trabalho prático 1 consiste na implementação de parte dessa aplicação com o emprego das técnicas de TDD. As 5 primeiras funcionalidades deverão ser implementadas pelos grupos, utilizando linguagens (e os conceitos) de Orientação por Objetos, e frameworks de testes unitários adequados para a linguagem adotada para o desenvolvimento da aplicação. Para cada funcionalidade deverão ser implementados testes que asseguram o resultado final desejável para a funcionalidade e os testes para os casos de exceção. As funcionalidades e as descrições dos testes estão listados a seguir:

Cadastro de Produtos:

- Garantir que o produto está cadastrado no sistema informando obrigatoriamente o nome do produto, seu código de barras, preço de compra, preço de venda e quantidade inicial em estoque.
  - Se algum desses itens acima não for informando, garantir que o produto não seja cadastrado através do lançamento da exceção DescricaoEmBrancoException.
  - Se os valores de compra e venda e a quantidade de itens inicial em estoque for menor ou igual a zero, garantir que o item não seja cadastrado através do lançamento da exceção ValorInvalidoException.

Consulta de Estoque:

- Garantir que o produto seja recuperado toda vez que ele for recuperado em buscas pelo seu nome ou pelo seu código de barras.

Gestão de Transações:

- Garantir que os seguintes tipos de transações sejam realizadas e os estoques dos produtos sejam atualizados: recebimento de mercadoria, vendas, transferências entre filiais, devoluções, ajustes de estoque.
Garantir que não serão informadas quantidades negativas para as transações, exceto para ajustes de estoque. Nos outros casos, lançar exceções do tipo ValorInvalidoException.

Alertas de Estoque Baixo:

- Garantir que um alerta de estoque mínimo seja emitido sempre que um produto atingir uma quantidade igual ou inferior ao seu limite pré-definido.
Esse alerta deverá informar os dados do produto, a quantidade atual em estoque e os dados do fornecedor do produto.
Nos casos em que o estoque for menor do que zero após a movimentação do produto, deverá ser lançada uma exceção do tipo EstoqueNegativoException que deverá atribuir 0 (zero) à quantidade de itens em estoque do produto.

Rastreamento de lotes e validade:

- Garantir que o sistema informe corretamente a quantidade total de itens para um determinado produto;
- Garantir que o sistema informe corretamente a quantidade total de itens de cada lote para um determinado produto;
- Garantir que o sistema emita um alerta de lotes próximos à data de validade e atualize o preço de venda daqueles produtos em -20%.

### Diagrama de Classes

![Imagem do WhatsApp de 2023-12-03 à(s) 18 53 38_019c3b95](https://github.com/DouglasMonteles/tp1/assets/54143767/46205e3b-3fac-46ee-8c8c-f03f1b0e14a4)


| Aluno | Funcionalidade                                                      |
| --------- | ---------------------------------------------------------- |
| Douglas Monteles	| Alerta de Estoque Baixo  |
| Eric Chagas	| Gestão de Transações  |
| Erik Levy	| Consulta de Estoque  |
| Giulia Alcantara | Cadastro de Produtos  |
| Ingrid Carvalho | Rastreamento de Lotes e Validade  |
