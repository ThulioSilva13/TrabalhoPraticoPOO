package Model;

import Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class Produto{
    public int id;
    public String nome;
    public Double preco;
    public int quantidade;
    public String tamanho;
    public String categoria;
    public String modelo;
    public String cor;
    
    //Constructor
    /*public enum Categoria{
        CALCA ("Calça"),
        TENIS ("Tenis"),
        MEIA ("Meia"),
        CAMISA ("Camisa");
        private String Descricao;
        Categoria(String descricao){
            this.Descricao = descricao;
        }
    }*/
    public Produto(){}
    public Produto(int Id, String Nome, Double Preco, int Quantidade, String Tamanho,String categoria, String Modelo, String Cor){
        this.id = Id;
        this.nome = Nome;
        this.preco = Preco;
        this.quantidade = Quantidade;
        this.tamanho = Tamanho;
        this.categoria = categoria;
        this.modelo = Modelo;
        this.cor = Cor;
    }
    public void save(Produto produto){
        String sql = "INSERT INTO produto(nome,preco,quantidade,modelo,cor)" +
        " VALUES(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,produto.nome);
            pstm.setDouble(2, produto.preco);
            pstm.setInt(3, produto.quantidade);
            pstm.setString(4, produto.modelo);
            pstm.setString(5,produto.cor);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir produto");
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
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao remover produto");
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
    public void update(Produto produto){
        String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade = ?, modelo = ?, cor = ?" +
        " WHERE id_produto = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        pstm.setString(1,produto.getNome());
        pstm.setDouble(2, produto.getPreco());
        pstm.setInt(3, produto.getQuantidade());
        pstm.setString(4, produto.getModelo());
        pstm.setString(5,produto.getCor());
        pstm.setInt(6, produto.getId());
        //Executa a sql para inserção dos dados
        pstm.execute();
        JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Produto");
            
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
    
    public int getEstoque(int id){
        String sql = "SELECT quantidade FROM produto WHERE id_produto = ?";
        int quantidade = 0;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try{
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            rset.next();
            quantidade = rset.getInt("quantidade");
            JOptionPane.showMessageDialog(null, "A quantidade é: " +quantidade);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter quantidade");
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
        return quantidade;
    }
    
   public void setEstoque(int id, int qntd){
       String sql = "UPDATE produto SET quantidade = ? WHERE id_produto = ?";
       Connection conn = null;
       PreparedStatement pstm = null;
       try{
           conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,qntd);
            pstm.setInt(2,id);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso");
       }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar estoque\n"+e);
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
    
  public List<Produto> getProdutos(){
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<Produto>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
                Produto produto = new Produto();
                produto.setNome(rset.getString("nome"));
                produto.setPreco(rset.getDouble("preco"));
                produto.setQuantidade(rset.getInt("quantidade"));
                produto.setModelo(rset.getString("modelo"));
                produto.setCor(rset.getString("cor"));
                produtos.add(produto);
            }
            for(int i = 0; i < produtos.size(); i++){
                JOptionPane.showMessageDialog(null, produtos.get(i).ToString());
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
          return produtos;
 }
  
   public String ToString(){
        return "Nome: "+ this.nome+ "\nPreço: R$"+ this.preco+ "\nQuantidade: "
                + this.quantidade+ "\nModelo: "+ this.modelo+ 
                "\nCor: "+ this.cor;
    }
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}