import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {
    public static void salvarLinha(String caminho, String linha) {
        try (FileWriter fw = new FileWriter(caminho, true)) {
            fw.write(linha + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }


    public static List<Produto> carregarProdutos(String caminho) {
        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
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

    public static void sobrescreverArquivo(String caminho, List<Produto> produtos) {
        try (FileWriter fw = new FileWriter(caminho, false)) { // false = sobrescreve
            for (Produto p : produtos) {
                String linha = p.getNome() + ";" + p.getPreco() + ";" + p.getQuantidade();
                fw.write(linha + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao sobrescrever arquivo: " + e.getMessage());
        }
    }

}