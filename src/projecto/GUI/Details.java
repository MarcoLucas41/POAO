package projecto.GUI;

import projecto.Classes.Empresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Classe que cria uma frame para mostrar as informações principais de uma empresa
 */

public class Details extends JFrame
{
    private JButton editar,apagar,voltar;
    private Application app;
    private JPanel panel,buttonPanel;
    private JLabel nome, categoria,despesaAnual,receitaAnual,lucro;
    private JTextField[] arrayOfTexts;

    private JFrame frameAnterior;
    private Empresa empresa;

    /**
     * Construtor da classe Details
     * @param frameAnterior Frame anterior
     * @param app Aplicação
     * @param empresa Empresa cuja informação principal vai ser apresentada
     */

    public Details(JFrame frameAnterior, Application app, Empresa empresa)
    {
        ImageIcon image = new ImageIcon("/Users/marcolucas/IdeaProjects/Projeto/src/projecto/logo.png");
        this.setIconImage(image.getImage());
        this.frameAnterior = frameAnterior;
        this.app = app;
        this.empresa = empresa;
        arrayOfTexts = new JTextField[5];
        for(int i = 0; i < 5; i++)
        {
            arrayOfTexts[i] = new JTextField();
            arrayOfTexts[i].setEditable(false);
        }
        createPanelInfo();
    }

    /**
     * Definição do painel que apresenta as informações principais da empresa
     */
    private void createPanelInfo()
    {
        panel = new JPanel();
        buttonPanel = new JPanel();
        panel.setLayout(new GridLayout(7,2));
        buttonPanel.setLayout(new FlowLayout());
        nome = new JLabel("Nome");
        categoria = new JLabel("Categoria");
        despesaAnual = new JLabel("Despesa Anual");
        receitaAnual = new JLabel("Receita Anual");
        lucro = new JLabel("Lucro");

        arrayOfTexts[0].setText(empresa.getNome());
        arrayOfTexts[1].setText(empresa.getCategoria());
        arrayOfTexts[2].setText(String.format("%.2f",empresa.getDespesaAnual()));
        arrayOfTexts[3].setText(String.format("%.2f",empresa.getReceitaAnual()));
        arrayOfTexts[4].setText(String.format("%s",checkLucro(empresa.getReceitaAnual()-empresa.getDespesaAnual())));

        panel.add(nome);
        panel.add(arrayOfTexts[0]);
        panel.add(categoria);
        panel.add(arrayOfTexts[1]);
        panel.add(despesaAnual);
        panel.add(arrayOfTexts[2]);
        panel.add(receitaAnual);
        panel.add(arrayOfTexts[3]);
        panel.add(lucro);
        panel.add(arrayOfTexts[4]);
        this.add(panel,BorderLayout.NORTH);
        settingButtons();
    }

    /**
     * Método que devolve uma String com base no valor positivo ou negativo do parametro
     * @param lucro Lucro de uma empresa
     * @return  Sim ou Não
     */
    private String checkLucro(float lucro)
    {
        if(lucro > 0)
        {
            return "Sim";
        }
        else
        {
            return "Não";
        }
    }

    /**
     * Definição dos botões da JFrame de Details
     */
    private void settingButtons()
    {
        editar = new JButton("Editar");
        Details.ButtonListener btnActionListener = new Details.ButtonListener();
        editar.addActionListener(btnActionListener);
        apagar = new JButton("Apagar");
        apagar.addActionListener(btnActionListener);
        voltar = new JButton("Voltar");
        voltar.addActionListener(btnActionListener);
        buttonPanel.add(editar);
        buttonPanel.add(apagar);
        buttonPanel.add(voltar);
        this.add(buttonPanel,BorderLayout.SOUTH);
    }

    /**
     * Classe privada associada a ações nos botôes da JFrame desta classe
     */
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == editar)
            {
                Editar x = new Editar(empresa, Details.this,app,frameAnterior);
                x.setVisible(true);
                x.setSize(650,400);
                Details.this.setVisible(false);
            }
            else if(e.getSource() == apagar)
            {
                JanelasDialogo jan = new JanelasDialogo();
            }
            else if(e.getSource() == voltar)
            {
                frameAnterior.setVisible(true);
                Details.this.setVisible(false);
            }

        }

    }
    /**
     * Classe privada associada a uma janela de diálogo que é aberta quando o utilizador decide apagar uma empresa
     */
    private class JanelasDialogo extends JFrame
    {
        private int option;
        public JanelasDialogo()
        {
            option = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende apagar?", "Aviso", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
            {
                app.Apagar(empresa);
                try {
                    app.storeInObjectFile();
                } catch (IOException ex) {
                    System.out.println("Error: cannot save changes in 'starthrive.dat'!");
                }
                Starthrive f = new Starthrive(app,app.getListaEmpresas());
                frameAnterior.dispose();
                f.setVisible(true);
                Details.this.setVisible(false);
            }
            this.setVisible(false);
        }

    }



}
