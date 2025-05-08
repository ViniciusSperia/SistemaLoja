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
                System.out.println("Erro: já existe um produto com esse nome. Escolha outro nome ou edite o existente.");
                return;
            }
        }

        produtos.add(p); // adiciona na lista em memória
        ProdutoRepositorio.salvar(p);
        System.out.println("Produto adicionado com sucesso.");
    }

    public void buscarProduto(String nome) {
        Produto p = encontrarProdutoPorNome(nome);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Nenhum produto encontrado com o nome \"" + nome + "\". Verifique se digitou corretamente.");
        }
    }

    public void removerProduto(String nome) {
        Produto p = encontrarProdutoPorNome(nome);
        if (p != null) {
            produtos.remove(p);
            ProdutoRepositorio.sobrescrever(produtos);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void listarTodos(){
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p);
            System.out.println("---------------");
        }
    }
    public void atualizarQuantidade(String nome, int quantidade) {
        Produto p = encontrarProdutoPorNome(nome);
        if (p != null) {
            p.setQuantidade(quantidade);
            ProdutoRepositorio.sobrescrever(produtos);
            System.out.println("Produto alterado com sucesso!");
        } else {
            System.out.println("Produto não encontrado. Verifique o nome informado.");
        }
    }

    public Produto encontrarProdutoPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().trim().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public boolean produtoExiste(String nome) {
        return encontrarProdutoPorNome(nome) != null;
    }

}
