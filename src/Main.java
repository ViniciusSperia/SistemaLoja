    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
           Scanner entrada = new Scanner(System.in); // Cria objeto Scanner para leitura do teclado

           SistemaLoja sl = new SistemaLoja();
           int opcao;


            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Buscar Produto por nome");
                System.out.println("2 - Adicionar Produto");
                System.out.println("3 - Deletar Produto");
                System.out.println("4 - Listar todos produtos");
                System.out.println("5 - Atualizar a quantidade do produto");
                System.out.println("0 - Sair");

                System.out.println("Digite sua opção: ");
                opcao = entrada.nextInt();
                entrada.nextLine(); // limpa o buffer do nextInt anterior

                switch (opcao) {
                    case 1:
                        System.out.println("Nome do produto: ");
                        String nomeProduto = entrada.nextLine().trim();

                        sl.buscarProduto(nomeProduto);
                        break;
                    case 2:
                        System.out.println("Nome do produto: ");
                        String nome = entrada.nextLine().trim();

                        System.out.println("Preço: ");
                        double preco = entrada.nextDouble();

                        System.out.println("Quantidade: ");
                        int quantidade = entrada.nextInt();

                        Produto novoProduto = new Produto(nome, preco, quantidade);
                        sl.adicionarProduto(novoProduto);
                        ArquivoUtil.salvarLinha("produtos.txt", "Café;12.5;3");
                        break;
                    case 3:
                        System.out.println("Nome do produto a ser removido: ");
                        String remocaoProduto = entrada.nextLine().trim();

                        sl.deletarProduto(remocaoProduto);
                        break;
                    case 4:
                        sl.listarTodos();
                        break;
                    case 5:
                        System.out.println("Nome do produto a alterar quantidade: ");
                        String nomeAl = entrada.nextLine().trim();

                        System.out.println("Quantidade: ");
                        int quantidadeAl = entrada.nextInt();

                        sl.atualizarQuantidade(nomeAl, quantidadeAl);
                        break;
                    case 0:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 0); // Condição correta para manter o menu

            entrada.close(); // Libera recurso do Scanner
        }

    }