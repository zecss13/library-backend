# Controllers

Os controllers são responsáveis por receber as requisições HTTP, processar os dados e retornar as respostas. Eles atuam como intermediários entre as rotas definidas e os serviços que contêm a lógica de negócio.

Usamos Lombok para reduzir o código boilerplate usado.

## Anotações

- `@RestController`: Indica que a classe é um controlador REST.
- `@RequestMapping`: Define a URL base para acessar o controlador.
- `@GetMapping`: Define a rota para acessar um método GET.
- `@PostMapping`: Define a rota para acessar um método POST.
- `@PutMapping`: Define a rota para acessar um método PUT.
- `@DeleteMapping`: Define a rota para acessar um método DELETE.
- `@PathVariable`: Define o parâmetro da rota.

## ResponseEntity

O Objeto responseEntity é uma classe que representa uma resposta HTTP. Ele contém o status code e o corpo da resposta.

- `ResponseEntity.ok()`: Retorna uma resposta com o status 200.
- `ResponseEntity.notFound()`: Retorna uma resposta com o status 404.
- `ResponseEntity.noContent()`: Retorna uma resposta com o status 204.

## Fluxo

Essa camada se comunica diretamente com o cliente, ou seja, é a camada que recebe as requisições e retorna as respostas.

Além disso, ela é responsável por validar os dados recebidos, chamar a próxima camada que é a de serviço e retornar a resposta ao cliente.
