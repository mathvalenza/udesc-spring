# Curso de `Spring Boot`, 2018/2

Aplicação para gerenciamento de uma seguradora de veículos.

## Endpoints:

- Endpoint para requisições

```link
http://localhost:8081/swagger-ui.html
```

- Acesso à base de dados

```link
http://localhost:8081/h2
```

### Exemplo REST para a entidade Fornecedor

- Salvar

```sh
POST -X http://localhost:8081/fornecedor/salvar -param = {"nome": "salvar"}
```

- Buscar

```sh
GET http://localhost:8081/fornecedor/buscar/{id} -param = {"nome": "buscar"}
```

- Listar

```sh
GET http://localhost:8081/fornecedor/listar -param = {"nome": "listar"}
```

- Excluir

```sh
DELETE http://localhost:8081/fornecedor/excluir/{id} -param = {"nome": "excluir"}
```

## Dependências:

lombok

## Autor:

Matheus Vinícius Valenza