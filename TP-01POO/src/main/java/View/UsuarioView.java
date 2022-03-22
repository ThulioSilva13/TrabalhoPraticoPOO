/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Endereco;
import Model.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author thuli
 */
public class UsuarioView extends javax.swing.JFrame {
    public UsuarioView() {
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
                        .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(129, 129, 129)
                        .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Insert)
                        .addGap(133, 133, 133)
                        .addComponent(GetAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                    .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        Usuario usuario = new Usuario();
        int id = Integer.parseInt(JOptionPane.showInputDialog("digite o id"));
        usuario.removeById(id);
    }//GEN-LAST:event_DeleteActionPerformed

    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        Usuario usuario = new Usuario();
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
        usuario.nome = JOptionPane.showInputDialog("Digite o nome");
        usuario.email = (JOptionPane.showInputDialog("Digite o email"));
        usuario.password = JOptionPane.showInputDialog("Digite a senha");
        usuario.isAdmin = Boolean.parseBoolean(JOptionPane.showInputDialog("Digite 1 para admin e 0 para comum"));
        usuario.endereco = id_endereco;
        usuario.save(usuario);
    }//GEN-LAST:event_InsertActionPerformed

    private void GetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetAllActionPerformed
        Usuario usuario = new Usuario();
        usuario.getUsuario();
    }//GEN-LAST:event_GetAllActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
       Usuario usuario = new Usuario();
       usuario.id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuario que quer editar"));
       usuario.nome = JOptionPane.showInputDialog("Digite o nome");
       usuario.email = (JOptionPane.showInputDialog("Digite o email"));
       usuario.password = JOptionPane.showInputDialog("Digite a senha");
       usuario.isAdmin = Boolean.parseBoolean(JOptionPane.showInputDialog("Digite 1 para admin e 0 para comum"));
       usuario.endereco = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do endereço"));
       usuario.update(usuario);
    }//GEN-LAST:event_UpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JButton GetAll;
    private javax.swing.JButton Insert;
    private javax.swing.JButton Update;
    // End of variables declaration//GEN-END:variables
}
