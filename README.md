# Gerenciamento de Aluguel de Veículos

## Descrição do Projeto
Este projeto é uma aplicação em Java que gerencia o aluguel de veículos, seguindo os princípios do SOLID. A aplicação permite cadastrar, alterar, buscar veículos e agências, além de gerenciar clientes e realizar operações de aluguel e devolução de veículos.

## Funcionalidades
### Funcionalidades Obrigatórias
- Cadastrar veículos
- Alterar um veículo cadastrado
- Buscar um veículo por parte da placa
- Cadastrar a agência onde o veículo será alugado/devolvido
- Alterar a agência onde o veículo será alugado/devolvido
- Buscar uma agência por parte do nome ou do logradouro do endereço
- Cadastrar o cliente (pessoa física/jurídica)
- Alterar o cliente (pessoa física/jurídica)
- Alugar um veículo para pessoa física
- Alugar um veículo para pessoa jurídica
- Devolver um veículo para pessoa física
- Devolver um veículo para pessoa jurídica
- Gerar um comprovante com todos os dados do aluguel
- Gerar um comprovante com todos os dados da devolução

### Funcionalidades Bônus
- Paginar as listas envolvidas
- Dados sendo gravados em arquivos, simulando uma base de dados

## Regras de Negócio
- RN1: Os veículos não podem ser repetidos
- RN2: Tipos de veículos considerados: Carro, Moto, Caminhões
- RN3: Os aluguéis e devoluções terão o local, data e horário
- RN4: Os veículos que estiverem alugados não poderão estar disponíveis
- RN5: Agências não podem estar duplicadas
- RN6: Clientes não podem estar duplicados
- RN7: Regras de devolução:
    - Caso pessoa física tenha ficado com o carro mais que 5 dias terá direito a 5% de desconto
    - Caso pessoa jurídica tenha ficado com o carro mais que 3 dias terá direito a 10% de desconto

## Estrutura do Projeto
### Diagrama de Classes
!Diagrama de Classes

### Pacotes Principais
- `Model`: Contém as classes de modelo, como `Veiculo`, `Cliente`, `Agencia`, `Aluguel`, `Devolucao`.
- `Service`: Contém as classes de serviço que implementam a lógica de negócios, como `AluguelService`, `DevolucaoService`, `VeiculoService` e `AgenciaService`.
- `View`: Contém as classes responsáveis pela interface com o usuário.
- `Util`: Contém utilitários, como `ScannerUtil`.

## Desafios e Soluções
### Desafios
- Chamar todos os métodos necessários no menu do pacote `view`.
- Simular um banco de dados através de um arquivo TXT, utilizando o `Scanner` através do método utilitário criado para simular informações passadas por um usuário.

### Soluções
- Utilização de uma classe utilitária `ScannerUtil` para facilitar a leitura de dados do usuário.
- Enums com os tipos dos veiculos para estipular alores distintos das diarias de aluguel de cada tipo.

### Pontos Interessantes
- Aplicação dos princípios SOLID para criar um código mais modular e fácil de manter.
- Implementação de regras de negócio específicas para o aluguel e devolução de veículos.

### Melhorias Futuras
- Implementar uma interface gráfica para melhorar a interação com o usuário.
- Integrar com um banco de dados real para maior robustez e escalabilidade.

## Princípios SOLID Aplicados
- **S**ingle Responsibility Principle (SRP): Cada classe tem uma única responsabilidade.
- **O**pen/Closed Principle (OCP): As classes estão abertas para extensão, mas fechadas para modificação.
- **L**iskov Substitution Principle (LSP): As subclasses podem ser substituídas por suas superclasses.
- **I**nterface Segregation Principle (ISP): Interfaces específicas foram criadas para diferentes funcionalidades.
- **D**ependency Inversion Principle (DIP): As classes de alto nível não dependem de classes de baixo nível, mas de abstrações.

## Apresentação
### Pontos Desafiadores
- Implementação das regras de negócio específicas.
- Manutenção da modularidade e flexibilidade do código.

### Resumo do Projeto
- **Entregue**: Funcionalidades obrigatórias e bônus, seguindo os princípios SOLID.
- **Não Entregue**: Integração com um banco de dados real.

### Aprendizados
- Aplicação prática dos princípios SOLID.
- Desafios na implementação de regras de negócio complexas.

## Realizadores do Projeto
- [`Priscila Santos`](https://github.com/Priscila-Santos)
- [`Matheus Gomes`](https://github.com/mthbgomes)
- [`Lucas Alecsander`](https://github.com/LucasAlec)
- [`Lucas Salvador do Carmo`](https://github.com/lucksc2805)



