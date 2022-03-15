/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Produto;
import javax.swing.JOptionPane;

/**
 *
 * @author thuli
 */
public class ProdutoView extends javax.swing.JFrame {
    public ProdutoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Insert = new javax.swing.JButton();
        GetAll = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Insert.setText("Cadastrar");
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });

        GetAll.setText("Listar");
        GetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetAllActionPerformed(evt);
            }
        });

        Update.setText("Atualizar");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Deletar");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(Delete))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GetAll)))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insert)
                    .addComponent(GetAll))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(Delete))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        Produto produto = new Produto();
        int id = Integer.parseInt(JOptionPane.showInputDialog("digite o id"));
        produto.removeById(id);
    }//GEN-LAST:event_DeleteActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        Produto produto = new Produto();
        produto.nome = JOptionPane.showInputDialog("Digite o nome do Produto");
        produto.preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o Preço"));
        produto.cor = JOptionPane.showInputDialog("Digite a cor");
        produto.modelo = JOptionPane.showInputDialog("Digite o modelo");
        produto.quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade"));
        produto.save(produto);
    }//GEN-LAST:event_InsertActionPerformed

    private void GetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetAllActionPerformed
        Produto produto = new Produto();
        produto.getProdutos();
    }//GEN-LAST:event_GetAllActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
       Produto produto = new Produto();
       produto.id =  Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto que quer editar"));
       produto.nome = JOptionPane.showInputDialog("Digite o nome do Produto");
       produto.preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o Preço"));
       produto.cor = JOptionPane.showInputDialog("Digite a cor");
       produto.modelo = JOptionPane.showInputDialog("Digite o modelo");
       produto.quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade"));
       produto.update(produto);
    }//GEN-LAST:event_UpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton GetAll;
    private javax.swing.JButton Insert;
    private javax.swing.JButton Update;
    // End of variables declaration//GEN-END:variables
}
