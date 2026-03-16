public class ListaLigada {

    No inicio;


    public ListaLigada() {
        this.inicio = null;
    }

    public Boolean estaVazia() {
        return this.inicio == null;
    }

    public void exibirlista() {
        if (this.estaVazia()) {
            System.out.println("Lista vazia");
            return;
        }

        No atual = inicio;
        int posicao = 0;

        System.out.println("Lista atual: ");
        while(atual != null) {
            System.out.println("Posição "+ posicao + ": "+ atual.nome);

            atual = atual.proximo;
            posicao++;
        }
        System.out.println("--------------");
    }

    public void inserirNoFinal(String Nome){
        No novo = new No(nome);

        if (inicio == null) {
            inicio = novo;
        }
        else {
            No atual = inicio;
            while(atual.proximo != null){
                atual = atual.proximo;
            }
            atual.proximo = novo
        }
    }

    public void inserirNaPosicao(String nome, int posicao){
        No novo = new No(nome);

        if(posicao == 0){
            novo.proximo = inicio;
            inicio = novo;
            return;
        }
        No atual = inicio;
        int i = 0;
        while(atual != null && i < posicao - 1){
            atual = atual.proximo;
            i++
        }
        if(atual == null){
            System.out.println("Posição inválida");
            return;
        }
        novo.proximo = atual.proximo;
        atual.proximo = novo;
    }

    public String buscarNome(String nome){
        No atual = inicio;
        int posicao = 0;

        if(atual == null){
            System.out.println("Nome não encontrado. ");
            return;
        }

        while (atual != null){
            if(atual.nome.equalsIgnoreCase(nome)){
                return posicao;
            }

            atual = atual.proximo
            posicao++;
        }

    }

    public boolean removerNome(String nome){
        No atual = inicio;
        No anterior = null;

        if(atual == null){
            System.out.println("Nome não encontrado. ");
            return false;
        }

        while(atual != null){
            if(atual.nome.equalsIgnoreCase(nome)){
                if(anterior == null){
                    inicio = atual.proximo;
                }
                else{
                    anterior.proximo = atual.proximo
                }
                return true;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return false;
    }
    
}