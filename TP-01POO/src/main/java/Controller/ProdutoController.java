
package Controller;

import Model.Produto;

public class ProdutoController {
    public void addProduto(Produto produto){
        produto.save(produto);
    }
    public void getAll(){
        Produto produto = new Produto();
        produto.getProdutos();
    }
    public void DeleteProduto(int idProduto){
        Produto produto = new Produto();
        produto.removeById(idProduto);
    }
    public void Update(Produto produto){
        produto.update(produto);
    }
}
