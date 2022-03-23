/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Model.Usuario_Produto;
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
public class Usuario_ProdutoTest {
    Usuario_Produto usuario_produto1;
    Usuario_Produto usuario_produto2;
    Usuario_Produto usuario_produto3;
    
    void initBeforeAll(){
        usuario_produto1 = new Usuario_Produto(1, 2);
        usuario_produto2 = new Usuario_Produto(3, 1);
        usuario_produto3 = new Usuario_Produto(4, 1);
    }
    
    @Test
    public void testCompra(){
        initBeforeAll();
        usuario_produto1.compra();
        usuario_produto2.compra();
        usuario_produto3.compra();
    }
    
    @Test 
    public void testListar(){
        initBeforeAll();
        usuario_produto1.getComprasPorUser(usuario_produto1.getId_user());
        usuario_produto2.getComprasPorUser(usuario_produto2.getId_user());
        usuario_produto3.getComprasPorUser(usuario_produto3.getId_user());
    }
}
            
