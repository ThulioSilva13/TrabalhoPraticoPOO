/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Endereco;
import Model.Fornecedor;
import Model.Produto;
import javax.swing.JOptionPane;

/**
 *
 * @author thuli
 */
public class FornecedorView extends javax.swing.JFrame {
    public FornecedorView() {
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
                        .addComponent(Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(GetAll))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Delete)))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Insert)
                    .addComponent(GetAll))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(Delete))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        Fornecedor fornecedor = new Fornecedor();
        int id = Integer.parseInt(JOptionPane.showInputDialog("digite o id"));
        fornecedor.removeById(id);
    }//GEN-LAST:event_DeleteActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        Fornecedor fornecedor = new Fornecedor();
        Endereco endereco = new Endereco();
        JOptionPane.showMessageDialog(null, "Para concluir o cadastro do fornecedor, cadastre seu endereço!");
        endereco.rua = JOptionPane.showInputDialog("Digite a rua");
        endereco.numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero"));
        endereco.bairro = JOptionPane.showInputDialog("Digite o bairro");
        endereco.cidade = JOptionPane.showInputDialog("Digite a cidade");
        endereco.estado = JOptionPane.showInputDialog("Digite o estado");
        endereco.pais = JOptionPane.showInputDialog("Digite o país");
        endereco.CEP = JOptionPane.showInputDialog("Digite o CEP");
        endereco.save(endereco);
        int id_endereco = endereco.getIdEndereco();
        fornecedor.nome = JOptionPane.showInputDialog("Digite o nome do fornecedor");
        fornecedor.categoria = (JOptionPane.showInputDialog("Digite a categoria"));
        fornecedor.telefone = JOptionPane.showInputDialog("Digite o telefone");
        fornecedor.endereco = id_endereco;
        fornecedor.save(fornecedor);
    }//GEN-LAST:event_InsertActionPerformed

    private void GetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetAllActionPerformed
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.getFornecedores();
    }//GEN-LAST:event_GetAllActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor que deseja editar"));
        fornecedor.nome = JOptionPane.showInputDialog("Digite o nome");
        fornecedor.categoria = (JOptionPane.showInputDialog("Digite a categoria"));
        fornecedor.telefone = JOptionPane.showInputDialog("Digite o telefone");
        fornecedor.endereco = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do endereco"));
        fornecedor.update(fornecedor);
    }//GEN-LAST:event_UpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton GetAll;
    private javax.swing.JButton Insert;
    private javax.swing.JButton Update;
    // End of variables declaration//GEN-END:variables
}
