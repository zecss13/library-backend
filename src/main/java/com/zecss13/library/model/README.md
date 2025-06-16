# Models

Em models teremos todas as classes que representam os dados do sistema. Essas classes são usadas para mapear os dados do banco de dados e também podem ser usadas para transferir dados entre diferentes camadas da aplicação.

Models são escritos sem sufixo model, por exemplo:
`Book.java`  
Diferentemente de controllers, que são escritos com o sufixo Controller, por exemplo:
`BookController.java`

Isso porque os models são usados para representar os dados do sistema e seria redundante adicionar model nele, enquanto os controllers são usados para gerenciar as requisições e respostas da aplicação.

## Annotations

As annotations são usadas para definir as propriedades do modelo.

### @Entity

A annotation @Entity é usada para definir que a classe é uma entidade JPA. O que significa que ela é uma classe que representa uma tabela no banco de dados.

### @Table

A annotation @Table é usada para definir o nome da tabela no banco de dados.

##@NoArgsConstructor

A annotation @NoArgsConstructor é usada para criar um construtor sem argumentos.

@AllArgsConstructor

A annotation @AllArgsConstructor é usada para criar um construtor com todos os argumentos.

@Data

A annotation @Data é usada para criar getters e setters para todos os campos da classe.

@Id

A annotation @Id é usada para definir o id da classe.

@GeneratedValue

A annotation @GeneratedValue é usada para definir o valor do id da classe.

@Column

A annotation @Column é usada para definir o nome da coluna no banco de dados.

@OneToMany

A annotation @OneToMany é usada para definir que a classe tem uma relação com outra classe.
