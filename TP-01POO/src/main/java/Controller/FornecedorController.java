package Controller;

import Model.Fornecedor;

public class FornecedorController {
    public void addFornecedor(Fornecedor fornecedor){
        fornecedor.save(fornecedor);
    }
    public void getAll(){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.getFornecedores();
    }
    public void DeleteFornecedor(int idFornecedor){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.removeById(idFornecedor);
    }
    public void Update(Fornecedor fornecedor){
        fornecedor.update(fornecedor);
    }
}
