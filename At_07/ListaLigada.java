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
     *
     * @return true se a lista não possui elementos,
     *         false caso contrário.
     */
    public Boolean estaVazia() {
        return this.inicio == null;
    }

    /**
     * Exibe todos os elementos da lista com suas posições.
     * Percorre a lista do início até o final.
     */
    public void exibirlista() {

        // Se a lista estiver vazia, exibe mensagem
        if (this.estaVazia()) {
            System.out.println("Lista vazia");
            return;
        }

        // Ponteiro auxiliar para percorrer a lista
        No atual = inicio;
        int posicao = 0;

        System.out.println("Lista atual: ");

        // Percorre todos os nós até chegar ao final (null)
        while(atual != null) {
            System.out.println("Posição "+ posicao + ": "+ atual.nome);

            atual = atual.proximo; // Avança para o próximo nó
            posicao++;
        }

        System.out.println("--------------");
    }

    /**
     * Insere um novo nome no final da lista.
     *
     * @param Nome Nome a ser inserido
     */
    public void inserirNoFinal(String Nome){

        // Cria um novo nó com o nome informado
        No novo = new No(nome);

        // Se a lista estiver vazia, o novo nó vira o primeiro
        if (inicio == null) {
            inicio = novo;
        }
        else {

            // Percorre até o último nó
            No atual = inicio;
            while(atual.proximo != null){
                atual = atual.proximo;
            }

            // Liga o último nó ao novo nó
            atual.proximo = novo
        }
    }

    /**
     * Insere um nome em uma posição específica da lista.
     *
     * @param nome Nome a ser inserido
     * @param posicao Posição desejada (começando em 0)
     */
    public void inserirNaPosicao(String nome, int posicao){

        // Cria o novo nó
        No novo = new No(nome);

        // Caso especial: inserir na posição 0 (início)
        if(posicao == 0){
            novo.proximo = inicio;
            inicio = novo;
            return;
        }

        // Percorre até o nó anterior à posição desejada
        No atual = inicio;
        int i = 0;

        while(atual != null && i < posicao - 1){
            atual = atual.proximo;
            i++
        }

        // Se chegou ao final antes da posição, é inválida
        if(atual == null){
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
     * @param nome Nome a ser buscado
     * @return posição onde o nome foi encontrado
     */
    public String buscarNome(String nome){

        No atual = inicio;
        int posicao = 0;

        // Se a lista estiver vazia
        if(atual == null){
            System.out.println("Nome não encontrado. ");
            return;
        }

        // Percorre a lista procurando o nome
        while (atual != null){

            // Compara ignorando maiúsculas/minúsculas
            if(atual.nome.equalsIgnoreCase(nome)){
                return posicao;
            }

            atual = atual.proximo
            posicao++;
        }

    }

    /**
     * Remove um nome da lista.
     *
     * @param nome Nome a ser removido
     * @return true se removido com sucesso,
     *         false se não encontrado
     */
    public boolean removerNome(String nome){

        No atual = inicio;
        No anterior = null;

        // Lista vazia
        if(atual == null){
            System.out.println("Nome não encontrado. ");
            return false;
        }

        // Percorre a lista
        while(atual != null){

            // Se encontrou o nome
            if(atual.nome.equalsIgnoreCase(nome)){

                // Caso seja o primeiro elemento
                if(anterior == null){
                    inicio = atual.proximo;
                }
                else{
                    // Remove ajustando o ponteiro do anterior
                    anterior.proximo = atual.proximo
                }

                return true;
            }

            // Avança os ponteiros
            anterior = atual;
            atual = atual.proximo;
        }

        return false;
    }

    /**
     * Calcula o tamanho da lista.
     *
     * @return quantidade de elementos na lista
     */
    public int tamanho() {

        int count = 0;
        No atual = inicio;

        // Conta todos os nós até o final
        while (atual != null) {
            count++;
            atual = atual.proximo;
        }

        return count;
    }

    /**
     * Move um nome para uma nova posição na lista.
     *
     * @param nome Nome a ser movido
     * @param novaPosicao Nova posição desejada
     */
    public void mover(String nome, int novaPosicao) {

        // Busca a posição atual do nome
        int pos = buscar(nome);

        // Se não encontrou, não faz nada
        if (pos == -1) return;

        // Remove o elemento da posição atual
        remover(nome);

        // Insere novamente na nova posição
        inserirPosicao(nome, novaPosicao);
    }

}