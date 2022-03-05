package Controller;
import Model.Endereco;

public class EnderecoController {
    
    public void addEndereco(Endereco endereco){
        endereco.save(endereco);
    }
    public void getAll(){
        Endereco endereco = new Endereco();
        endereco.getEndereco();
    }
    public void DeleteEndereco(int idEndereco){
        Endereco endereco = new Endereco();
        endereco.removeById(idEndereco);
    }
    public void Update(Endereco endereco){
        endereco.update(endereco);
    }
}
