Exercício: Criando uma Classe "Carro"

Objetivo: Este exercício tem como objetivo introduzir os conceitos de classe, objeto, atributos e métodos.

Descrição
Você vai criar uma classe chamada Carro que representa um carro com alguns atributos e comportamentos simples. Um carro possui placa, modelo, ano, velocidade, quantidade de combustível no tanque e capacidade máxima do tanque. Um carro pode realizar as seguintes ações:

acelerar(valor): recebe um valor e acrescenta 10% na velocidade atual. Ao acelerar, diminui a 1% do valor recebido da quantidade de combustível no tanque. A velocidade não pode passar de 150 unidades. Não é possível acelerar sem combustível no tanque.
frear(valor): recebe um valor e diminui 10% na velocidade atual. Só freia se a velocidade for maior que 0.
abastecer(valor): recebe um valor e adiciona na quantidade de combustível no tanque. Não é possível abastecer além da capacidade máxima do tanque.
toString(): mostra os dados do carro.
Na classe Main, declare e instancie um objeto da classe Carro. Inicialize os atributos do carro de acordo com os dados informados pelo usuário. O usuário também pode escolher as ações que o carro irá realizar.