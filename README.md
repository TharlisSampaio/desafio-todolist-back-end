<h1 align="center">
  TODO List
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar tarefas (CRUD) que faz parte [desse desafio](https://github.com/simplify-liferay/desafio-junior-backend-simplify) para pessoas desenvolvedoras backend júnior, que se candidatam para a Simplify.

## Instalação

```todo
```

## Tarefa

Modelo que represnta a Tarefa

```
{
    "nome": "String",
    "descricao": "String",
    "realizado": Boolean,
    "prioridade": Integer
}
```

## API Endpoint
## Métodos:

### `GET`: Retorna uma tarefa ao passar um id válido

```
http://127.0.0.1:8000/todos/{id}
```

```
{
    "id": Long,
    "nome": "String",
    "descricao": "String",
    "realizado": Boolean,
    "prioridade": Integer
}
```

### `GET`: Retorna uma lista de tarefas
```
http://127.0.0.1:8000/todos
```

```
[
    {
        "id": Long,
        "nome": "String",
        "descricao": "String",
        "realizado": Boolean,
        "prioridade": Integer
    },
    {
        "id": Long,
        "nome": "String",
        "descricao": "String",
        "realizado": Boolean,
        "prioridade": Integer
    }
]
```

### `POST`: Salva uma lista de tarefas, e após salvar retorna a lista de tarefas
```
http://127.0.0.1:8000/todos
```

```
[
    {
        "nome": "Tarefa 1",
        "descricao": "Descrição da tarefa 1",
        "realizado": false,
        "prioridade": 2
    },
    {
        "nome": "Tarefa 2",
        "descricao": "Descrição da Tarefa 2",
        "realizado": true,
        "prioridade": 1
    }
]
```

### `PUT`: Atualiza um tarefa, e após atualizar, retorna lista de tarefas atualizada
```
http://127.0.0.1:8000/todos/{id}
```
```
{
    "id": Long,
    "nome": "String",
    "descricao": "String",
    "realizado": Boolean,
    "prioridade": Integer
}
```

### `DELETE`: Deleta uma tarefa atreves do id, após deletar retorna uma lista de tarefas
```
http://127.0.0.1:8000/todos/{id}
```
```
[
    {
        "id": Long,
        "nome": "String",
        "descricao": "String",
        "realizado": Boolean,
        "prioridade": Integer
    },
    {
        "id": Long,
        "nome": "String",
        "descricao": "String",
        "realizado": Boolean,
        "prioridade": Integer
    }
]
```