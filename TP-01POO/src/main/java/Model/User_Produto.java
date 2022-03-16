/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;

public class User_Produto {
     public int id_user;
     public int id_produto;
     public Date dataCompra;
     
     public User_Produto(int id_user, int id_produtom, Date dataCompra){
         this.id_user = id_user;
         this.id_produto = id_produto;
         this.dataCompra = new Date();
     }
     
     public void compra(){
         String sql = "INSERT INTO compra(id_user, id_produto, dataCompra)" +
        " VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        Produto produto = new Produto();
        int estoque  = produto.getEstoque(this.id_produto);
        produto.setEstoque(this.id_produto, estoque-1);
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,this.id_user);
            pstm.setInt(2, this.id_produto);
            pstm.setDate(3, (java.sql.Date) this.dataCompra);
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
     
        
}
