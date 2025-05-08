    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
           Scanner entrada = new Scanner(System.in); // Cria objeto Scanner para leitura do teclado

           SistemaLoja sl = new SistemaLoja();
           int opcao = -1;


            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Buscar Produto por nome");
                System.out.println("2 - Adicionar Produto");
                System.out.println("3 - Deletar Produto");
                System.out.println("4 - Listar todos produtos");
                System.out.println("5 - Atualizar a quantidade do produto");
                System.out.println("0 - Sair");

                try {
                    System.out.print("Digite sua opção: ");
                    opcao = entrada.nextInt();
                    entrada.nextLine(); // limpa buffer
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido. Certifique-se de digitar apenas números.");
                    entrada.nextLine(); // limpa o lixo que ficou no buffer
                    opcao = -1; // volta para o início do loop
                }

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do produto: ");
                        String nomeProduto = entrada.nextLine().trim();

                        sl.buscarProduto(nomeProduto);
                        break;
                    case 2:
                        System.out.print("Nome do produto: ");
                        String nome = entrada.nextLine().trim();

                        try {
                            System.out.print("Preço: ");
                            double preco = entrada.nextDouble();

                            System.out.print("Quantidade: ");
                            int quantidade = entrada.nextInt();

                            Produto novoProduto = new Produto(nome, preco, quantidade);
                            sl.adicionarProduto(novoProduto);
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: preço e quantidade devem ser números.");
                            entrada.nextLine(); // limpa buffer
                        }
                        break;
                    case 3:
                        System.out.print("Nome do produto a ser removido: ");
                        String remocaoProduto = entrada.nextLine().trim();

                        sl.removerProduto(remocaoProduto);
                        break;
                    case 4:
                        sl.listarTodos();
                        break;
                    case 5:
                        System.out.print("Nome do produto a alterar quantidade: ");
                        String nomeAl = entrada.nextLine().trim();

                        if (sl.produtoExiste(nomeAl)) {
                            try {
                                System.out.println("Nova quantidade: ");
                                int quantidadeAl = entrada.nextInt();
                                sl.atualizarQuantidade(nomeAl, quantidadeAl);
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: quantidade deve ser um número inteiro.");
                                entrada.nextLine();
                            }
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
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