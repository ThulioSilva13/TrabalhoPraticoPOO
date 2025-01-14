import Connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
class Endereco {
    public int id;
    public int numero;
    public String rua;
    public String bairro;
    public String cidade;
    public String estado;
    public String pais;
    public String CEP;
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
        String sql = "DELETE FROM endereco WHERE id_endereco = ?";
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
        String sql = "UPDATE endereco SET numero = ?, rua = ?, bairro = ?, cidade = ?, estado = ?, cidade = ?, pais = ?, cep = ?" +
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

    //GetAll
    public void printAll(){
        System.out.printf("Id:%d\nNumero:%d\nRua:%s\nBairro:%s\nCidade:%s\nEstado:%s\nPaís:%s\nCEP:%s\n ",this.id,this.numero,this.rua,this.bairro,this.cidade, this.estado, this.pais, this.CEP);
    }
}
