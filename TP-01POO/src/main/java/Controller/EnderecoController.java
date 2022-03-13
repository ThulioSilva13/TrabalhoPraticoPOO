package Controller;
import Connection.Conexao;
import Model.Endereco;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class EnderecoController {
    
    public void addEndereco(Endereco endereco){
        Connection conn = null;
        conn = Conexao.getConexao();
        endereco.save(endereco);
        
    }
    public void getAll(){
        Endereco endereco = new Endereco();
        endereco.getEndereco();
        JOptionPane.showMessageDialog(null, endereco);
    }
    public void DeleteEndereco(int idEndereco){
        Endereco endereco = new Endereco();
        endereco.removeById(idEndereco);
    }
    public void Update(Endereco endereco){
        endereco.update(endereco);
    }
}
