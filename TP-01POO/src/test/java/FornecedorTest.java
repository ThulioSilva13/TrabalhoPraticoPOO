/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Model.Fornecedor;
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
public class FornecedorTest {
    Fornecedor fornecedor1;
    Fornecedor fornecedor2;
    Fornecedor fornecedor3;
    
    void initBeforeAll(){
        fornecedor1 = new Fornecedor("Categoria1", "99812-5858", 3, "Fornecedor1");
        fornecedor2 = new Fornecedor("Categoria2", "99812-5858", 3, "Fornecedor2");
        fornecedor3 = new Fornecedor("Categoria3", "99812-5858", 3, "Fornecedor3");
    }
    
    @Test
    public void testInsere(){
        initBeforeAll();
        fornecedor1.save(fornecedor1);
        fornecedor2.save(fornecedor2);
        fornecedor3.save(fornecedor3);
    }
    
    @Test 
    public void testDelete(){
        initBeforeAll();
        fornecedor1.removeById(fornecedor1.getId());
        fornecedor2.removeById(fornecedor2.getId());
        fornecedor3.removeById(fornecedor3.getId());
    }
    
    @Test 
    public void testUpdate(){
        fornecedor1.update(fornecedor1);
        fornecedor2.update(fornecedor2);
        fornecedor3.update(fornecedor3);
    }
}
            
