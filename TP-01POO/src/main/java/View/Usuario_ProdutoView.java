/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Endereco;
import Model.Produto;
import Model.Usuario;
import Model.Usuario_Produto;
import javax.swing.JOptionPane;

/**
 *
 * @author thuli
 */
public class Usuario_ProdutoView extends javax.swing.JFrame {
    public Usuario_ProdutoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Compra = new javax.swing.JButton();
        MinhasCompras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Compra.setText("Comprar");
        Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompraActionPerformed(evt);
            }
        });

        MinhasCompras.setText("Minhas Compras");
        MinhasCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinhasComprasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Compra)
                    .addComponent(MinhasCompras))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(Compra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(MinhasCompras)
                .addGap(135, 135, 135))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompraActionPerformed
        Produto produto = new Produto();
        Usuario usuario = new Usuario();
        JOptionPane.showMessageDialog(null,"Escolha o id do porduto que queira comprar");
        produto.getProdutos();
        int id_produto = Integer.parseInt(JOptionPane.showInputDialog("Insira o ID do produto"));
        String email = JOptionPane.showInputDialog("Para confirmar sua compra, digite seu email abaixo");
        int id_user = usuario.getIdPorEmail(email);
        Usuario_Produto usuario_produto = new Usuario_Produto(id_user, id_produto);
        usuario_produto.compra();
        
    
        
    }//GEN-LAST:event_CompraActionPerformed

    private void MinhasComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinhasComprasActionPerformed
        Usuario_Produto usuario_produto = new Usuario_Produto();
        Usuario usuario = new Usuario();
        String email = JOptionPane.showInputDialog(null, "Digite seu email");
        int id_user = usuario.getIdPorEmail(email);
        usuario_produto.getComprasPorUser(id_user);
    }//GEN-LAST:event_MinhasComprasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Compra;
    private javax.swing.JButton MinhasCompras;
    // End of variables declaration//GEN-END:variables
}
