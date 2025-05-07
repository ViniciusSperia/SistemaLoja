import java.util.ArrayList;

public class SistemaLoja {

    private ArrayList<Produto> produtos;

    public SistemaLoja() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto p){ // Adicionar produto
        for (Produto existente : produtos) {
            if (existente.getNome().trim().equalsIgnoreCase(p.getNome().trim())) {
                System.out.println("Produto já existe.");
                return;
            }
            produtos.add(p);
            System.out.println("Produto adicionado com sucesso.");
        }
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

    public void deletarProduto(String nome){
        for (Produto p : produtos) {
            if (p.getNome().trim().equalsIgnoreCase(nome)) {
                produtos.remove(p);
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
                System.out.print("Produto alterado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}
