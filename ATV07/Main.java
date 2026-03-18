import java.util.*;

/**
 * Classe principal do sistema.
 * Responsável por interagir com o usuário e utilizar a ListaLigada.
 *
 * Funcionalidades:
 * - Cadastrar 5 nomes iniciais
 * - Exibir lista
 * - Inserir nome em posição específica
 * - Buscar nome
 * - Mover nome
 * - Remover nome
 * - Menu interativo até o usuário encerrar
 */
public class Main {

    /**
     * Método principal que inicia o programa.
     *
     * @param args Argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaLigada lista = new ListaLigada();

        // Cadastro inicial de 5 nomes
        System.out.println("Informe 5 nomes para a lista:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Informe o " + (i + 1) + "° nome: ");
            String nome = sc.nextLine();
            lista.inserirNoFinal(nome);
        }

        // Exibe a lista inicial
        lista.exibirlista();

        int opcao;

        // Menu interativo
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Inserir nome em posição");
            System.out.println("2 - Buscar nome");
            System.out.println("3 - Mover nome");
            System.out.println("4 - Remover nome");
            System.out.println("5 - Exibir lista");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

            switch (opcao) {

                // Inserir nome em posição
                case 1:
                    System.out.print("Digite a posição: ");
                    int posicao = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite o nome: ");
                    String nomeInserir = sc.nextLine();

                    lista.inserirNaPosicao(nomeInserir, posicao);
                    lista.exibirlista();
                    break;

                // Buscar nome
                case 2:
                    System.out.print("Digite o nome para buscar: ");
                    String buscar = sc.nextLine();

                    int pos = lista.buscarNome(buscar);

                    if (pos != -1) {
                        System.out.println("Nome encontrado na posição: " + pos);
                    } else {
                        System.out.println("Nome não encontrado.");
                    }

                    lista.exibirlista();
                    break;

                // Mover nome
                case 3:
                    System.out.print("Digite o nome que deseja mover: ");
                    String nomeMover = sc.nextLine();

                    System.out.print("Digite a nova posição: ");
                    int novaPos = sc.nextInt();
                    sc.nextLine();

                    lista.mover(nomeMover, novaPos);
                    lista.exibirlista();
                    break;

                // Remover nome
                case 4:
                    System.out.print("Digite o nome que deseja remover: ");
                    String nomeRemover = sc.nextLine();

                    boolean removido = lista.removerNome(nomeRemover);

                    if (removido) {
                        System.out.println("Nome removido com sucesso.");
                    } else {
                        System.out.println("Nome não encontrado.");
                    }

                    lista.exibirlista();
                    break;

                // Exibir lista
                case 5:
                    lista.exibirlista();
                    break;

                // Sair
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                // Opção inválida
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}