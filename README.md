# 📚 Lista Ligada Simples em Java

Implementação de uma **Lista Ligada Simples (Singly Linked List)** em Java para armazenamento e manipulação de nomes, com interface interativa via terminal.

## 👨‍💻 Autor

Felipe Marin Silva,
Leonel Zaninelli,
Pedro Nakamura,
João Filipe Peralta,
Pedro Mantovani.

## 🧠 Descrição

Este projeto implementa uma estrutura de dados do tipo **Lista Ligada Simples**, onde cada elemento (nó) contém:

- Um nome (String)
- Uma referência para o próximo elemento da lista

O sistema permite ao usuário inserir, remover, buscar, mover e visualizar nomes através de um menu interativo no terminal.

## 🏗️ Estrutura do Projeto

O projeto é composto por três classes principais:

### 🔹 No

Representa um nó da lista.

**Atributos:**

- `String nome` → valor armazenado  
- `No proximo` → referência para o próximo nó  

---

### 🔹 ListaLigada

Responsável por toda a lógica da lista.

**Principais métodos:**

| Método | Descrição |
|--------|----------|
| `estaVazia()` | Verifica se a lista está vazia |
| `exibirlista()` | Mostra todos os elementos com suas posições |
| `inserirNoFinal(nome)` | Insere um nome no final |
| `inserirNaPosicao(nome, posicao)` | Insere em posição específica |
| `buscarNome(nome)` | Retorna a posição do nome |
| `removerNome(nome)` | Remove um nome da lista |
| `tamanho()` | Retorna a quantidade de elementos |
| `mover(nome, novaPosicao)` | Move um nome para nova posição |

---

### 🔹 Main

Classe principal responsável pela interação com o usuário.

**Funcionalidades:**

- ✔ Cadastro inicial de 5 nomes  
- ✔ Menu interativo até o usuário sair  
- ✔ Execução de todas as operações da lista  

---

## ⚙️ Funcionalidades do Sistema

O programa permite:

### ➕ Inserir nome em posição específica

Insere um novo elemento na posição desejada, ajustando os ponteiros da lista.

### 🔍 Buscar nome

Localiza um nome e informa sua posição na lista.

### 🔄 Mover nome

Remove o nome da posição atual e reinsere na nova posição indicada.

### ❌ Remover nome

Exclui um elemento da lista pelo nome.

### 📋 Exibir lista

Mostra todos os nomes armazenados com suas respectivas posições.

---

## 🧩 Como Funciona a Lista Ligada

Diferente de arrays, a lista ligada não usa posições contínuas de memória.

Cada nó aponta para o próximo:

```
[Nome1 | Próximo] → [Nome2 | Próximo] → [Nome3 | null]
```

---

## ▶️ Como Executar

### ✅ Pré-requisitos

- Java JDK 8 ou superior
- Terminal ou IDE (IntelliJ, Eclipse, VS Code, etc.)

### 💻 Compilação via terminal

```bash
javac Main.java ListaLigada.java No.java
```

### ▶️ Execução

```bash
java Main
```

---

## 🖥️ Exemplo de Uso

```
Informe 5 nomes para a lista:
Informe o 1° nome: Ana
Informe o 2° nome: Bruno
Informe o 3° nome: Carlos
Informe o 4° nome: Daniela
Informe o 5° nome: Eduardo

===== MENU =====
1 - Inserir nome em posição
2 - Buscar nome
3 - Mover nome
4 - Remover nome
5 - Exibir lista
0 - Sair
```

---

## 🎯 Objetivos Educacionais

Este trabalho demonstra:

- Estruturas de dados dinâmicas
- Manipulação de referências (ponteiros)
- Encadeamento de nós
- Programação orientada a objetos
- Interação com usuário via terminal

---

## 🚀 Possíveis Melhorias Futuras

- Interface gráfica (Java Swing ou JavaFX)
- Persistência em arquivo ou banco de dados
- Lista duplamente ligada
- Ordenação automática
- Validação de entradas do usuário
- Suporte a tipos genéricos (Generics)

---

## 📄 Licença

Projeto desenvolvido para fins acadêmicos.
