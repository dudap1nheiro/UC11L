/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoquejava;

/**
 *
 * @author EDUARDAPINHEIRODESOU
 */
 import java.util.ArrayList;
public class estoque {
   
    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(String nome, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                produto.adicionarQuantidade(quantidade);
                return;
            }
        }
        produtos.add(new Produto(nome, quantidade));
    }

    public void removerProduto(String nome, int quantidade) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getNome().equals(nome)) {
                produto.removerQuantidade(quantidade);
                if (produto.getQuantidade() == 0) {
                    produtos.remove(i); // Removendo pelo índice
                }
                return;
            }
        }
        throw new IllegalArgumentException("O produto solicitado não foi encontrado.");
    }

    public int consultarQuantidade(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto.getQuantidade();
            }
        }
        return 0;
    }

    public Object produtoMaisEstocado() {
        if (produtos.isEmpty()) {
            return null;
        }
        Produto maisEstocado = produtos.get(0);
        for (Produto produto : produtos) {
            if (produto.getQuantidade() > maisEstocado.getQuantidade()) {
                maisEstocado = produto;
            }
        }
        return maisEstocado.getNome();
    }

    public void limparEstoque() {
        produtos.clear();
    }
}
}
