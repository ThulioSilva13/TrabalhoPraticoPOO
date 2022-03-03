import Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
class Produto{
    private int id;
    private String nome;
    private Double preco;
    private int quantidade;
    private String tamanho;
    private String categoria;
    private String modelo;
    private String cor;
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
        String sql = "INSERT INTO contatos(nome,idade,dataCadastro)" +
        " VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produto.id);
        pstm.setString(2,produto.nome);
        pstm.setDouble(3, produto.preco);
        pstm.setInt(4, produto.quantidade);
        pstm.setString(5,produto.tamanho);
        pstm.setString(6, produto.categoria);
        pstm.setString(7, produto.modelo);
        pstm.setString(8,produto.cor);
        pstm.execute();
        } catch (Exception e) {
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
        String sql = "DELETE FROM contatos WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            }catch (Exception e) {
                // TODO Auto-generated catch block
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
        String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?" +
        " WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produto.id);
        pstm.setString(2,produto.nome);
        pstm.setDouble(3, produto.preco);
        pstm.setInt(4, produto.quantidade);
        pstm.setString(5,produto.tamanho);
        pstm.setString(6, produto.categoria);
        pstm.setString(7, produto.modelo);
        pstm.setString(8,produto.cor);
        //Executa a sql para inserção dos dados
        pstm.execute();
        } catch (Exception e) {
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


    //GetAll
    public void printAll(){
        System.out.printf("Id:%d\nNome:%s\nPreco:%f\nQuantidade:%d\nTamanho:%s\nCategoria:%s\nModelo:%s\nCor:%s\n",this.id,this.nome,this.preco,this.quantidade,this.tamanho,this.categoria,this.modelo,this.cor);
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