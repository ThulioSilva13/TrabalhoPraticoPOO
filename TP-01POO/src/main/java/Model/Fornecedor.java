package Model;

import Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Fornecedor {
    public int id;
    public String categoria;
    public String telefone;
    public int endereco;
    public String nome;

    //Constructor
    public Fornecedor(){}
    public Fornecedor(String categoria, String telefone, int endereco, String nome){
        this.categoria = categoria;
        this.telefone = telefone;
        this.endereco = endereco;
        this.nome = nome;
    }

    public void save(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor(categoria,telefone,nome,id_endereco)" +
        " VALUES(?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,fornecedor.categoria);
            pstm.setString(2, fornecedor.telefone);
            pstm.setString(3, fornecedor.nome);
            pstm.setInt(4,fornecedor.endereco);
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Fornecedor inserido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir fornecedor");
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void removeById(int id){
        String sql = "DELETE FROM fornecedor WHERE id_fornecedor = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Fornecedor removido com sucesso");
            }catch (Exception e) {
                // TODO Auto-generated catch block
                JOptionPane.showMessageDialog(null, "Erro ao remover fornecedor");
                e.printStackTrace();
            }finally{
                try{
                    if(pstm != null){
                    pstm.close();
                    }
                    if(conn != null){
                    conn.close();
                    }
                }catch(Exception e){ 
                    e.printStackTrace();
                }
            }
    }
    public void update(Fornecedor fornecedor){
        String sql = "UPDATE fornecedor SET categoria = ?, telefone = ?, nome = ?" +
        " WHERE id_fornecedor = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, fornecedor.getCategoria());
            pstm.setString(2,fornecedor.getTelefone());
            pstm.setString(3, fornecedor.getNome());
            pstm.setInt(4, fornecedor.getId());
            //Executa a sql para inserção dos dados
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover fornecedor");
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){
                pstm.close();
                }
                
                if(conn != null){
                conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public List<Fornecedor> getFornecedores(){
        String sql = "SELECT * FROM fornecedor";
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rset.getInt("id_fornecedor"));
                fornecedor.setCategoria(rset.getString("categoria"));
                fornecedor.setTelefone(rset.getString("telefone"));
                fornecedor.setNome(rset.getString("nome"));
                fornecedor.setEndereço(rset.getInt("id_endereco"));
                fornecedores.add(fornecedor);
            }
            JOptionPane.showMessageDialog(null, fornecedores.toString());
        } catch (Exception e) {
             e.printStackTrace();
        }finally{
            try{
            if(rset != null){
            rset.close();
            }
            if(pstm != null){
            pstm.close();
            }
            if(conn != null){
            conn.close();
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
            return fornecedores;
        }

    @Override
    public String toString(){
        return """
               --------------
               Nome: """+ this.nome+ "\nCategoria: "+ this.categoria+ "\nTelefone: "
                + this.telefone+ "\nEndereco: "+ this.endereco+"\n--------------";
    }
    
    public int getId() {
        return id;
    }
//"--------------\n" + 
    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getEndereço() {
        return endereco;
    }

    public void setEndereço(int endereço) {
        this.endereco = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
