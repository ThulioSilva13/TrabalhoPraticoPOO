import Connection.Conexao;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

class Usuario {
    private int id;
    private String nome;
    private String email;
    private String password;
    private String telefone;
    private Endereco endereço;
    private boolean isAdmin;
    private Date creationDate;
    private Date exclusionDate;


    //Constructor
    public Usuario(){}
    public Usuario(int id, String nome, String email, String password, String telefone, Endereco endereço, boolean isAdmin){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.telefone = telefone;
        this.endereço = endereço;
        this.isAdmin = isAdmin;
        this.creationDate = new Date();

    }

    public void save(Usuario usuario){
        String sql = "INSERT INTO contatos(nome,email,password,isAdmin,telefone,endereco)" +
        " VALUES(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        pstm.setString(1, usuario.nome);
        pstm.setString(2, usuario.email);
        pstm.setString(3, usuario.password);
        pstm.setBoolean(4, usuario.isAdmin);
        pstm.setString(5, usuario.telefone);
        pstm.setObject(6, usuario.endereço);
        usuario.creationDate = new Date();
        usuario.exclusionDate = null;
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
    public void update(Usuario usuario){
        String sql = "UPDATE contatos SET nome = ?, email = ?, password = ?, isAdmin = ?, telefone = ?, endereco =?" +
        " WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        pstm.setString(1,usuario.nome);
        pstm.setString(2, usuario.email);
        pstm.setString(3, usuario.password);
        pstm.setString(4, usuario.telefone);
        pstm.setObject(5, usuario.endereço);
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
    public List<Usuario> getContatos(){
        String sql = "SELECT * FROM contatos";
        List<Usuario> enderecos = new ArrayList<Usuario>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
        conn = Conexao.getConexao();
        pstm = conn.prepareStatement(sql);
        rset = pstm.executeQuery();
        while(rset.next()){
        Usuario usuario = new Usuario();
        pstm.setObject(5, usuario.endereço);
        usuario.setId(rset.getInt("id"));
        usuario.setNome(rset.getString("nome"));
        usuario.setEmail(rset.getString("email"));
        usuario.setPassword(rset.getString("password"));
        usuario.setTelefone(rset.getString("telefone"));
        usuario.setAdmin(rset.getBoolean("isAdmin"));
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
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

    //GetAll
    public void printAll(){
        System.out.printf("Id:%d\nNome:%s\nEmail:%s\nIsAdmin:%s\nTelefone:%s\n ",this.id,this.nome,this.email,this.isAdmin, this.telefone);
        this.endereço.printAll();
    }

}
