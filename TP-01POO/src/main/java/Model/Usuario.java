package Model;

import Model.Endereco;
import Connection.Conexao;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario {
    public int id;
    public String nome;
    public String email;
    public String password;
    public int endereco;
    public boolean isAdmin;
    public Date creationDate;
    public Date exclusionDate;


    //Constructor
    public Usuario(){}
    public Usuario(int id, String nome, String email, String password, int endereço, boolean isAdmin){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.endereco = endereco;
        this.isAdmin = isAdmin;
        this.creationDate = new Date();

    }

    public void save(Usuario usuario){
        String sql = "INSERT INTO user (nome,email,password,isAdmin,endereco)" +
        " VALUES(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.nome);
            pstm.setString(2, usuario.email);
            pstm.setString(3, usuario.password);
            pstm.setBoolean(4, usuario.isAdmin);
            pstm.setInt(6, usuario.endereco);
                       
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Usuario inserido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuario");
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
        String sql = "DELETE FROM user WHERE id_user = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Usuario removido com sucesso");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao remover usuario");
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
    public void update(Usuario usuario){
        String sql = "UPDATE user SET nome = ?, email = ?, password = ?, "
                + "isAdmin = ?, id_endereco = ?" +
        " WHERE id_user = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getPassword());
            pstm.setBoolean(4, usuario.getIsAdmin());
            pstm.setInt(5, usuario.getEndereco());
            pstm.setInt(6,usuario.getId());
            //Executa a sql para inserção dos dados
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuario");
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
    
    public List<Usuario> getUsuario(){
        String sql = "SELECT * FROM user";
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        rset = pstm.executeQuery();
        while(rset.next()){
        Usuario usuario = new Usuario();
        usuario.setId(rset.getInt("id_user"));
        usuario.setNome(rset.getString("nome"));
        usuario.setEmail(rset.getString("email"));
        usuario.setPassword(rset.getString("password"));
        usuario.setIsAdmin(rset.getBoolean("isAdmin"));
        usuario.setEndereco(rset.getInt("id_endereco"));
        usuario.setCreationDate(rset.getDate("creatinDate"));
        usuario.setExclusionDate(rset.getDate("exclusionDate"));
        usuarios.add(usuario);
        }
        for(int i = 0; i < usuarios.size(); i++){
                JOptionPane.showMessageDialog(null, usuarios.get(i).ToString());
            }
        
        
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
        
            return usuarios;
    }

     public String ToString(){
        return "Nome: "+ this.nome+ "\nEmail: "+ this.email
                + "\nÉ admin?: "+ this.isAdmin+ 
                "\nData cadastro: "+ this.creationDate;
    }


    //getters setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }


    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExclusionDate() {
        return exclusionDate;
    }

    public void setExclusionDate(Date exclusionDate) {
        this.exclusionDate = exclusionDate;
    }

}
