/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Model.Endereco;
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
public class EnderecoTest {
    Endereco endereco1;
    Endereco endereco2;
    Endereco endereco3;
    
    void initBeforeAll(){
        endereco1 = new Endereco(35, "rua1", "bairro1", "cidade1", "estado1", "pais1", "CEP1");
        endereco2 = new Endereco(45, "rua2", "bairro2", "cidade2", "estado2", "pais2", "CEP2");
        endereco3 = new Endereco(12, "rua3", "bairro3", "cidade3", "estado3", "pais3", "CEP3");
    }
    
    @Test
    public void testInsere(){
        initBeforeAll();
        endereco1.save(endereco1);
        endereco2.save(endereco2);
        endereco3.save(endereco3);
    }
    
    @Test 
    public void testDelete(){
        initBeforeAll();
        endereco1.removeById(endereco1.getId());
        endereco2.removeById(endereco2.getId());
        endereco3.removeById(endereco3.getId());
    }
    
    @Test 
    public void testUpdate(){
        endereco1.update(endereco1);
        endereco2.update(endereco2);
        endereco3.update(endereco3);
    }
}
            
