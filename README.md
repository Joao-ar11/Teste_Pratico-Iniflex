# Teste_Pratico-Iniflex

Processo seletivo da Projedata. 

## Instruções:
Considerando que uma indústria possui as pessoas/funcionários abaixo:

![Tabela com nomes, datas de nascimento, salários e funções de funcionários](https://bucket-custom-test-images-prod.gupy.io/production/companies/17494/images/custom-test-102943-question-eee278f5-a195-4265-956e-dcfcef31bafb.png)

Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:

1. Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

2. Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

3. Deve conter uma classe Principal para executar as seguintes ações:
    1. Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
    2. Remover o funcionário “João” da lista.
    3. Imprimir todos os funcionários com todas suas informações, sendo que:
        - informação de data deve ser exibido no formato dd/mm/aaaa;
        - informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
    4. Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
    5. Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
    6. Imprimir os funcionários, agrupados por função.
    7. Imprimir os funcionários que fazem aniversário no mês 10 e 12.
    8. Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
    9. Imprimir a lista de funcionários por ordem alfabética.
    10. Imprimir o total dos salários dos funcionários.
    11. Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
