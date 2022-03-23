/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Model.Produto;
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
public class ProdutoTest {
    Produto produto1;
    Produto produto2;
    Produto produto3;
    
    void initBeforeAll(){
        produto1 = new Produto("Produto1", 10.00, 10,  "modelo1", "cor1");
        produto2 = new Produto("Produto2", 20.00, 20,  "modelo2", "cor2");
        produto3 = new Produto("Produto3", 30.00, 30,  "modelo3", "cor3");
    }
    
    @Test
    public void testInsere(){
        initBeforeAll();
        produto1.save(produto1);
        produto2.save(produto2);
        produto3.save(produto3);
    }
    
    @Test 
    public void testDelete(){
        initBeforeAll();
        produto1.removeById(produto1.getId());
        produto2.removeById(produto2.getId());
        produto3.removeById(produto3.getId());
    }
    
    @Test 
    public void testUpdate(){
        produto1.update(produto1);
        produto2.update(produto2);
        produto3.update(produto3);
    }
}
            
