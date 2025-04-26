## Objetivo

Desenvolver um sistema que simule o controle de veículos em uma garagem, organizando informações sobre os carros, seus motores e os condutores responsáveis.

## Instruções

Você deve criar **exatamente 3 classes** principais para compor o sistema:

### 🔹 Classe 1: `Carro`
  - Representa um veículo.
  - Deve conter os atributos:
  - Marca
  - Modelo
  - Placa
  - Motor (objeto da classe `Motor`)
  - Condutor (objeto da classe `Condutor`)
  - O sistema deve permitir criar um carro com diferentes combinações de dados (ex: com ou sem condutor) utilizando **sobrecarga de construtores ou métodos**.
  - Deve permitir atualizar os dados do carro, como trocar o condutor ou alterar o motor.

### 🔹 Classe 2: `Motor`
  - Representa o motor do carro.
  - Deve conter:
  - Tipo (ex: gasolina, elétrico, diesel)
  - Potência
  - Deve estar associado ao carro no momento do cadastro ou após.

### 🔹 Classe 3: `Condutor`
  - Representa o motorista responsável por dirigir o carro.
  - Deve conter:
  - Nome
  - Número da CNH
  - A associação de um condutor a um carro pode ser feita no cadastro ou depois, via método específico.

## Requisitos Técnicos
  - Utilize **encapsulamento**: todos os atributos devem ser privados, com acesso controlado por **getters e setters**.
  - Utilize **sobrecarga de métodos ou construtores** em pelo menos **2 situações**.
  - Relacione as classes por **composição**:
  - Um `Carro` possui um `Motor`
  - Um `Carro` pode ter um `Condutor`
  - O sistema pode ser testado com uma classe com `main`, simulando os seguintes fluxos:
  - Criação de objetos `Motor`, `Condutor` e `Carro`
  - Atribuição de condutor e motor ao carro
  - Troca de condutor ou motor
  - Exibição dos dados do carro