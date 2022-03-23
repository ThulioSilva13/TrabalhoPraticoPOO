/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import Model.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thuli
 */
public class UsuarioTest {
    Usuario usuario1;
    Usuario usuario2;
    Usuario usuario3;
    
    void initBeforeAll(){
        usuario1 = new Usuario("Cliente1", "cliente1@email.com", "senha1", 3, false);
        usuario2 = new Usuario("Cliente2", "cliente2@email.com", "senha2", 3, true);
        usuario3 = new Usuario("Cliente3", "cliente3@email.com", "senha3", 3, false);
    }
    
    @Test
    public void testInsere(){
        initBeforeAll();
        usuario1.save(usuario1);
        usuario2.save(usuario2);
        usuario3.save(usuario3);
    }
    
    @Test 
    public void testDelete(){
        initBeforeAll();
        usuario1.removeById(usuario1.getId());
        usuario2.removeById(usuario2.getId());
        usuario3.removeById(usuario3.getId());
    }
    
    @Test 
    public void testUpdate(){
        usuario1.update(usuario1);
        usuario2.update(usuario2);
        usuario3.update(usuario3);
    }
}
            
