# Repository

A camada repository é responsável por interagir com a fonte de dados, que pode ser um banco de dados, uma API externa ou qualquer outra forma de armazenamento. Ela contém métodos para realizar operações de CRUD (Create, Read, Update, Delete) e outras consultas específicas.

Nesse caso é o banco de dados em memória H2, que é utilizado para testes e desenvolvimento. A camada repository é responsável por fornecer uma abstração sobre a fonte de dados, permitindo que a camada de serviço interaja com os dados sem se preocupar com os detalhes de implementação.

## Annotations

@Repository: Anotação que indica que a classe é um repositório Spring, permitindo que o Spring a detecte e registre como um bean.

## interfaces

- `{Entity}Repository`: Interface que estende `JpaRepository` para operações CRUD relacionadas a entidade.

JpaRepository: Interface do Spring Data JPA que fornece métodos para operações CRUD e consultas personalizadas. Ela é parametrizada com a entidade e o tipo do identificador (ID) da entidade.

Precisamos declarar como parametro a entidade e o tipo do ID, que é um Long.

## Métodos personalizados

Conseguimos criar métodos personalizados na interface do repositório para consultas específicas. Esses métodos podem ser definidos usando a convenção de nomenclatura do Spring Data JPA, que permite que o Spring gere automaticamente as consultas SQL correspondentes.

Exemplo de método personalizado:

```java
List<Book> findByTitleContainingIgnoreCase(String title);
```