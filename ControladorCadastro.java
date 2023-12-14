/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno.v.oliveira
 */
public class ControladorCadastro {

    private Agenda agenda;
    private TelaCadastro tela;

    public ControladorCadastro(Agenda agenda) {
        this.agenda = agenda;
        tela = new TelaCadastro();

        //registrando ouvinte do botão salvar contato
        tela.getBtnSalvarContato().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = tela.getTxtNome().getText();
                String telefone = tela.getTxtTelefone().getText();
                boolean sucesso = agenda.add(new Contato(nome, telefone));
                tela.getTxtNome().setText("");
                tela.getTxtTelefone().setText("");
                if (sucesso) {
                    JOptionPane.showMessageDialog(tela, "Contato salvo com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao inserir o contato!", "Erro na inserção.", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton btnBuscar = tela.getBtnBuscar();

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nomeBusca = tela.getTxtNomeBusca().getText();
                if (!nomeBusca.isEmpty()) {
                    Contato c = agenda.buscar(nomeBusca);
                    if (c != null) {
                        tela.getTxtASaida().setText(c.getNome() + " " + c.getTelefone());
                    } else {
                        JOptionPane.showMessageDialog(tela, "Contato " + nomeBusca + " não localizado na agenda!", nomeBusca, JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(tela, "O campo de nome para busca não pode estar vazio!", "Erro ao tentar excluir um contato.", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        tela.getBtnExcluirContato().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeExcluir = tela.getTxtNomeBusca().getText();
                if (!nomeExcluir.isEmpty()) {
                    if (agenda.excluirContato(nomeExcluir)) {
                        JOptionPane.showMessageDialog(tela, "Contato " + nomeExcluir + " excluído com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(tela, "Contato " + nomeExcluir + " não localizado na agenda!", "Erro ao tentar excluir um contato.", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(tela, "O campo de nome para busca não pode estar vazio\nao selecionar excluir contato!", "Erro ao tentar excluir um contato.", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        tela.getBtnListarTodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String listaContatos = agenda.getListaContatosComoString();
                if (listaContatos == null) {
                    JOptionPane.showMessageDialog(tela, "A agenda está vazia!", "Agenda vazia.", JOptionPane.ERROR_MESSAGE);
                } else {
                    tela.getTxtASaida().setText(listaContatos);
                }
            }
        });

        tela.setVisible(true);

    }

}
