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
    public String endereço;
    public String nome;

    //Constructor
    public Fornecedor(){}
    public Fornecedor(int id, String categoria, String telefone, String endereço, String nome){
        this.id = id;
        this.categoria = categoria;
        this.telefone = telefone;
        this.nome = nome;
    }

    public void save(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedor(categoria,telefone,nome)" +
        " VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,fornecedor.categoria);
            pstm.setString(2, fornecedor.telefone);
            pstm.setString(3, fornecedor.nome);
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
        String sql = "DELETE FROM contatos WHERE id = ?";
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
        String sql = "UPDATE contatos SET categoria = ?, telefone = ?, nome = ?" +
        " WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, fornecedor.id);
            pstm.setString(2,fornecedor.categoria);
            pstm.setString(3, fornecedor.telefone);
            pstm.setString(4, fornecedor.nome);
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
        List<Fornecedor> enderecos = new ArrayList<Fornecedor>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        rset = pstm.executeQuery();
        while(rset.next()){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(rset.getInt("id"));
        fornecedor.setCategoria(rset.getString("categoria"));
        fornecedor.setTelefone(rset.getString("telefone"));
        fornecedor.setNome(rset.getString("nome"));
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
        
            return enderecos;
        }

    public int getId() {
        return id;
    }

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

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //GetAll
    public void printAll(){
        System.out.printf("Id:%d\nNome:%s\nCategoria:%s\nEndereço:%s\nTelefone:%s\n ",this.id,this.nome,this.categoria,this.endereço,this.telefone);
    }

    static class Produto{
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
            String sql = "INSERT INTO contatos(nome,preco,quantidade,tamanho,categoria,modelo,cor)" +
            " VALUES(?,?,?,?,?,?,?)";
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = Conexao.getConexao();
                pstm = conn.prepareStatement(sql);
                pstm.setString(1,produto.nome);
                pstm.setDouble(2, produto.preco);
                pstm.setInt(3, produto.quantidade);
                pstm.setString(4,produto.tamanho);
                pstm.setString(5, produto.categoria);
                pstm.setString(6, produto.modelo);
                pstm.setString(7,produto.cor);
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
            String sql = "UPDATE contatos SET nome = ?, preco = ?, quantidade = ?, tamanho = ?, categoria = ?, modelo = ?, cor = ?" +
            " WHERE id = ?";
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = Conexao.getConexao();
                pstm = conn.prepareStatement(sql);
                pstm.setString(1,produto.nome);
                pstm.setDouble(2, produto.preco);
                pstm.setInt(3, produto.quantidade);
                pstm.setString(4,produto.tamanho);
                pstm.setString(5, produto.categoria);
                pstm.setString(6, produto.modelo);
                pstm.setString(7,produto.cor);
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
            System.out.printf("Id:%d\nNome:%s\nPreco:%f\nQuantidade:%d\nTamanho:%s\nModelo:%s\nCor:%s\n",this.id,this.nome,this.preco,this.quantidade,this.tamanho,this.modelo,this.cor);
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

    static class Endereco {
        private int id;
        private int numero;
        private String rua;
        private String bairro;
        private String cidade;
        private String estado;
        private String pais;
        private String CEP;

        //Constructor
        public Endereco(){}
        public Endereco(int id, int numero, String rua, String bairro, String cidade, String estado, String pais, String CEP){
            this.id = id;
            this.numero = numero;
            this.rua = rua;
            this.bairro = bairro;
            this.cidade = cidade;
            this.estado = estado;
            this.pais = pais;
            this.CEP = CEP;
        }

        public void save(Endereco endereco){
            String sql = "INSERT INTO endereco(numero,rua,bairro,cidade,estado,pais,cep)" +
            " VALUES(?,?,?,?,?,?,?)";
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
                conn = Conexao.getConexao();
                pstm = conn.prepareStatement(sql);
                pstm.setInt(1,endereco.numero);
                pstm.setString(2, endereco.rua);
                pstm.setString(3, endereco.bairro);
                pstm.setString(4, endereco.cidade);
                pstm.setString(5, endereco.estado);
                pstm.setString(6, endereco.pais);
                pstm.setString(7, endereco.CEP);
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
            String sql = "DELETE FROM endereco WHERE id = ?";
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
        public void update(Endereco endereco){
            String sql = "UPDATE endereco SET numero = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, pais = ?, CEP = ?" +
            " WHERE id = ?";
            Connection conn = null;
            PreparedStatement pstm = null;
            try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, endereco.getNumero());
            pstm.setString(2, endereco.getRua());
            pstm.setString(3,endereco.getBairro());
            pstm.setString(4, endereco.getCidade());
            pstm.setString(5, endereco.getEstado());
            pstm.setString(6, endereco.getPais());
            pstm.setString(7, endereco.getCEP());
            pstm.setInt(8, endereco.getId());
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
        public List<Endereco> getEndereco(){
            String sql = "SELECT * FROM contatos";
            List<Endereco> enderecos = new ArrayList<Endereco>();
            Connection conn = null;
            PreparedStatement pstm = null;
            ResultSet rset = null;
            try {
            conn = Conexao.getConexao();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while(rset.next()){
            Endereco endereco = new Endereco();
            endereco.setId(rset.getInt("id"));
            endereco.setNumero(rset.getInt("numero"));
            endereco.setBairro(rset.getString("bairro"));
            endereco.setCidade(rset.getString("cidade"));
            endereco.setEstado(rset.getString("estado"));
            endereco.setPais(rset.getString("pais"));
            endereco.setCEP(rset.getString("cep"));
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

                return enderecos;
            }



        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getRua() {
            return rua;
        }

        public void setRua(String rua) {
            this.rua = rua;
        }

        public String getBairro() {
            return bairro;
        }

        public void setBairro(String bairro) {
            this.bairro = bairro;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getCEP() {
            return CEP;
        }

        public void setCEP(String CEP) {
            this.CEP = CEP;
        }
    }
}
