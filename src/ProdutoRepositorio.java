import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorio {
    private static final String CAMINHO_ARQUIVO = "produtos.txt";

    public static List<Produto> carregarTodos() {
        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String nome = partes[0].trim();
                    double preco = Double.parseDouble(partes[1].trim());
                    int quantidade = Integer.parseInt(partes[2].trim());
                    produtos.add(new Produto(nome, preco, quantidade));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar produtos: " + e.getMessage());
        }

        return produtos;
    }

    public static void salvar(Produto p) {
        try (FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, true)) {
            String linha = p.getNome() + ";" + p.getPreco() + ";" + p.getQuantidade();
            fw.write(linha + "\n");
        } catch (IOException e) {
            System.out.println("Erro interno ao salvar o produto. Tente novamente.");
        }
    }

    public static void sobrescrever(List<Produto> produtos) {
        try (FileWriter fw = new FileWriter(CAMINHO_ARQUIVO, false)) {
            for (Produto p : produtos) {
                String linha = p.getNome() + ";" + p.getPreco() + ";" + p.getQuantidade();
                fw.write(linha + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao sobrescrever arquivo: " + e.getMessage());
        }
    }
}
