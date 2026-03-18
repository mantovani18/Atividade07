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

        if (this.estaVazia()) {
            System.out.println("Lista vazia");
            return;
        }

        No atual = inicio;
        int posicao = 0;

        System.out.println("Lista atual: ");

        while (atual != null) {
            System.out.println("Posição " + posicao + ": " + atual.nome);
            atual = atual.proximo;
            posicao++;
        }

        System.out.println("--------------");
    }

    /**
     * Insere um novo nome no final da lista.
     */
    public void inserirNoFinal(String nome) {

        No novo = new No(nome);

        if (inicio == null) {
            inicio = novo;
        } else {

            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }

            atual.proximo = novo;
        }
    }

    /**
     * Insere um nome em uma posição específica da lista.
     */
    public void inserirNaPosicao(String nome, int posicao) {

        No novo = new No(nome);

        if (posicao == 0) {
            novo.proximo = inicio;
            inicio = novo;
            return;
        }

        No atual = inicio;
        int i = 0;

        while (atual != null && i < posicao - 1) {
            atual = atual.proximo;
            i++;
        }

        if (atual == null) {
            System.out.println("Posição inválida");
            return;
        }

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

        while (atual != null) {

            if (atual.nome.equalsIgnoreCase(nome)) {
                return posicao;
            }

            atual = atual.proximo;
            posicao++;
        }

        System.out.println("Nome não encontrado.");
        return -1;
    }

    /**
     * Remove um nome da lista.
     */
    public boolean removerNome(String nome) {

        No atual = inicio;
        No anterior = null;

        while (atual != null) {

            if (atual.nome.equalsIgnoreCase(nome)) {

                if (anterior == null) {
                    inicio = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }

                return true;
            }

            anterior = atual;
            atual = atual.proximo;
        }

        System.out.println("Nome não encontrado.");
        return false;
    }

    /**
     * Retorna o tamanho da lista.
     */
    public int tamanho() {

        int count = 0;
        No atual = inicio;

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

        int pos = buscarNome(nome);

        if (pos == -1) return;

        removerNome(nome);
        inserirNaPosicao(nome, novaPosicao);
    }

}
