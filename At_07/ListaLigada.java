package B1.at_07;

/**
 * Classe que representa uma Lista Ligada Simples de nomes.
 * Cada elemento da lista é um nó (No) que contém um nome e
 * uma referência para o próximo nó.
 */
public class ListaLigada {

    /** Referência para o primeiro nó da lista */
    No inicio;

    /**
     * Construtor da lista.
     * Inicializa a lista como vazia (sem nós).
     */
    public ListaLigada() {
        this.inicio = null;
    }

    /**
     * Verifica se a lista está vazia.
     */
    public Boolean estaVazia() {
        return this.inicio == null;
    }

    /**
     * Exibe todos os elementos da lista com suas posições.
     */
    public void exibirlista() {

        // Condição: verifica se a lista não possui elementos
        if (this.estaVazia()) {
            System.out.println("Lista vazia");
            return; // Encerra o método
        }

        No atual = inicio; // Ponteiro para percorrer a lista
        int posicao = 0;

        System.out.println("Lista atual: ");

        /**
         * Laço de repetição:
         * Percorre a lista do primeiro nó até o último.
         * Continua enquanto existir um nó válido (≠ null).
         */
        while (atual != null) {

            // Exibe a posição e o nome do nó atual
            System.out.println("Posição " + posicao + ": " + atual.nome);

            // Avança para o próximo nó da lista
            atual = atual.proximo;

            // Incrementa o contador de posição
            posicao++;
        }

        System.out.println("--------------");
    }

    /**
     * Insere um novo nome no final da lista.
     */
    public void inserirNoFinal(String nome) {

        No novo = new No(nome);

        /**
         * Condição:
         * Se a lista estiver vazia, o novo nó será o primeiro.
         */
        if (inicio == null) {
            inicio = novo;
        } else {

            No atual = inicio;

            /**
             * Laço de repetição:
             * Percorre a lista até encontrar o último nó
             * (aquele cujo próximo é null).
             */
            while (atual.proximo != null) {
                atual = atual.proximo; // Avança na lista
            }

            // Liga o último nó ao novo nó
            atual.proximo = novo;
        }
    }

    /**
     * Insere um nome em uma posição específica da lista.
     */
    public void inserirNaPosicao(String nome, int posicao) {

        No novo = new No(nome);

        /**
         * Condição especial:
         * Inserção na posição 0 (início da lista)
         */
        if (posicao == 0) {
            novo.proximo = inicio; // Novo aponta para o antigo início
            inicio = novo;         // Atualiza o início da lista
            return;
        }

        No atual = inicio;
        int i = 0;

        /**
         * Laço de repetição:
         * Percorre a lista até o nó anterior à posição desejada.
         *
         * Condições para continuar:
         * - Ainda não chegou ao final (atual != null)
         * - Ainda não atingiu a posição anterior (i < posicao - 1)
         */
        while (atual != null && i < posicao - 1) {
            atual = atual.proximo;
            i++;
        }

        /**
         * Condição:
         * Se chegou ao final antes da posição desejada,
         * a posição é inválida.
         */
        if (atual == null) {
            System.out.println("Posição inválida");
            return;
        }

        // Ajusta os ponteiros para inserir o novo nó
        novo.proximo = atual.proximo;
        atual.proximo = novo;
    }

    /**
     * Busca um nome na lista.
     *
     * @return posição onde foi encontrado ou -1 se não existir
     */
    public int buscarNome(String nome) {

        No atual = inicio;
        int posicao = 0;

        /**
         * Laço de repetição:
         * Percorre toda a lista procurando o nome.
         */
        while (atual != null) {

            /**
             * Condição:
             * Verifica se o nome do nó atual é igual ao procurado
             * (ignorando maiúsculas/minúsculas).
             */
            if (atual.nome.equalsIgnoreCase(nome)) {
                return posicao; // Retorna a posição encontrada
            }

            // Avança para o próximo nó
            atual = atual.proximo;

            // Atualiza a posição
            posicao++;
        }

        // Caso percorra toda a lista e não encontre
        System.out.println("Nome não encontrado.");
        return -1;
    }

    /**
     * Remove um nome da lista.
     */
    public boolean removerNome(String nome) {

        No atual = inicio;
        No anterior = null; // Guarda o nó anterior ao atual

        /**
         * Laço de repetição:
         * Percorre toda a lista procurando o nome a remover.
         */
        while (atual != null) {

            /**
             * Condição:
             * Verifica se encontrou o nome desejado.
             */
            if (atual.nome.equalsIgnoreCase(nome)) {

                /**
                 * Caso especial:
                 * Se anterior é null, significa que o nó atual
                 * é o primeiro da lista.
                 */
                if (anterior == null) {
                    inicio = atual.proximo; // Remove o primeiro nó
                } else {
                    /**
                     * Caso geral:
                     * Remove o nó ajustando o ponteiro do anterior.
                     */
                    anterior.proximo = atual.proximo;
                }

                return true; // Remoção realizada
            }

            // Avança os ponteiros
            anterior = atual;
            atual = atual.proximo;
        }

        // Caso não encontre o nome
        System.out.println("Nome não encontrado.");
        return false;
    }

    /**
     * Retorna o tamanho da lista.
     */
    public int tamanho() {

        int count = 0;
        No atual = inicio;

        /**
         * Laço de repetição:
         * Conta todos os nós até chegar ao final da lista.
         */
        while (atual != null) {
            count++;
            atual = atual.proximo;
        }

        return count;
    }

    /**
     * Move um nome para uma nova posição na lista.
     */
    public void mover(String nome, int novaPosicao) {

        // Busca a posição atual do nome
        int pos = buscarNome(nome);

        /**
         * Condição:
         * Se o nome não existir na lista, encerra o método.
         */
        if (pos == -1) return;

        // Remove o nó da posição atual
        removerNome(nome);

        // Insere novamente na nova posição
        inserirNaPosicao(nome, novaPosicao);
    }

}
