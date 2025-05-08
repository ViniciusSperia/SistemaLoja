import java.util.ArrayList;

public class SistemaLoja {

    private ArrayList<Produto> produtos;

    public SistemaLoja() {
        this.produtos = new ArrayList<>();
        this.produtos.addAll(ProdutoRepositorio.carregarTodos());
    }


    public void adicionarProduto(Produto p){ // Adicionar produto
        for (Produto existente : produtos) {
            if (existente.getNome().trim().equalsIgnoreCase(p.getNome().trim())) {
                System.out.println("Produto já existe.");
                return;
            }
        }

        produtos.add(p); // adiciona na lista em memória
        ProdutoRepositorio.salvar(p);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void buscarProduto(String nome){ //Buscar Produto por nome
        for (Produto p : produtos) {
            if (p.getNome().trim().equalsIgnoreCase(nome)) {
                p.exibirInformacoes();
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void removerProduto(String nome){
        for (Produto p : produtos) {
            if (p.getNome().trim().equalsIgnoreCase(nome)) {
                produtos.remove(p);
                ProdutoRepositorio.sobrescrever(produtos);
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void listarTodos(){
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            p.exibirInformacoes();
            System.out.println("---------------");
        }
    }

    public void atualizarQuantidade(String nome, int quantidade) {
        for (Produto p : produtos) {
            if (p.getNome().trim().equalsIgnoreCase(nome)) {
                p.setQuantidade(quantidade);
                ProdutoRepositorio.sobrescrever(produtos);
                System.out.println("Produto alterado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}
