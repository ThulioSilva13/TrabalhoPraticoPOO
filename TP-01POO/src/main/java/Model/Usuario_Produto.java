/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario_Produto {
     private int id_user;
     private int id_produto;
     private Date dataCompra;
     
     public Usuario_Produto(){}
     
     public Usuario_Produto(int id_user, int id_produto){
         this.id_user = id_user;
         this.id_produto = id_produto;
         this.dataCompra = new Date(System.currentTimeMillis()); SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
     }
     
     public void compra(){
         String sql = "INSERT INTO compra(id_user, id_produto, dataCompra)" +
        " VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        Produto produto = new Produto();
        int estoque  = produto.getEstoque(this.getId_produto());
        produto.setEstoque(this.getId_produto(), estoque-1);
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, this.getId_user());
            pstm.setInt(2, this.getId_produto());
            pstm.setDate(3, (java.sql.Date) this.getDataCompra());
            //Executa a sql para inserção dos dados
            JOptionPane.showMessageDialog(null, "Compra Realizada com sucesso");
        pstm.execute();
        
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
     
     public List<Usuario_Produto> getComprasPorUser(int id_user){
        String sql = "SELECT * FROM compra WHERE id_user = ?";
        List<Usuario_Produto> compras = new ArrayList<Usuario_Produto>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try{
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id_user);
            rset = pstm.executeQuery();
            while(rset.next()){
                Usuario_Produto usuario_produto = new Usuario_Produto();
                usuario_produto.setId_user(rset.getInt("id_user"));
                usuario_produto.setId_produto(rset.getInt("id_produto"));
                usuario_produto.setDataCompra(rset.getDate("dataCompra"));
                compras.add(usuario_produto);
            }
            
            JOptionPane.showMessageDialog(null, compras.toString());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter compras");
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
        return compras;
    }
     @Override
     public String toString(){
        return """
               --------------
               Comprou o produto com id: """+ this.id_user+ "\nNo dia: "+ this.dataCompra+ "\n--------------";
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the dataCompra
     */
    public Date getDataCompra() {
        return dataCompra;
    }

    /**
     * @param dataCompra the dataCompra to set
     */
    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
     
        
}
