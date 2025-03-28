package projecto.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe para construir uma frame para a funcionalidade "Adicionar uma empresa"
 */

public class Adicionar extends JFrame
{
    private JFrame frameAnterior;
    private Application app;
    private JPanel panel1,panel2;
    private JLabel label;
    private String[] types;
    private JComboBox jComboBoxAction;


    private JButton continuar,voltar;

    /**
     * Construtor da classe Adicionar
     * @param frameAnterior JFrame anterior à que é criada em Adicionar
     * @param app Aplicação
     */
    public Adicionar(JFrame frameAnterior, Application app)
    {
        ImageIcon image = new ImageIcon("/Users/marcolucas/IdeaProjects/Projeto/src/projecto/logo.png");
        this.setIconImage(image.getImage());
        this.app = app;
        this.frameAnterior = frameAnterior;
        this.setTitle("Adicionar Empresa");
        this.setSize(400,100);
        this.setLayout(new BorderLayout());
        createCompany();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Método de preenchimento da JFrame criada em Adicionar.
     * @return void
     */
    private void createCompany()
    {
        panel1 = new JPanel();
        panel2 = new JPanel();

        label = new JLabel("Selecione categoria");
        types = new String[]{"cafe", "pastelaria", "local", "fast-food", "mercado", "frutaria"};
        jComboBoxAction = new JComboBox(types);

        continuar = new JButton("Continuar");
        voltar = new JButton("Voltar");
        ButtonListener btnActionListener = new ButtonListener();
        continuar.addActionListener(btnActionListener);
        voltar.addActionListener(btnActionListener);

        panel1.add(label);
        panel1.add(jComboBoxAction);

        panel2.add(continuar);
        panel2.add(voltar);

        this.add(panel1,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.SOUTH);


    }
    /**
     * Classe privada associada a ações nos botôes da JFrame desta classe
     */

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == continuar)
            {
                String categoria = (String)jComboBoxAction.getSelectedItem();
                Attributes x = new Attributes(categoria,Adicionar.this,app,frameAnterior);
                x.setSize(650,300);
                x.setVisible(true);
            }
            else if(e.getSource() == voltar)
            {
                frameAnterior.setVisible(true);
            }
            Adicionar.this.setVisible(false);
        }

    }




}
