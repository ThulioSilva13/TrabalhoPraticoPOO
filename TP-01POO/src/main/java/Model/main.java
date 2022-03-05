package Model;

import Model.Endereco;
import javax.swing.JOptionPane;
public class main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        int id = Integer.parseInt(JOptionPane.showInputDialog("digite o id"));
        endereco.removeById(id);
    }
}
