package projecto.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe que cria uma JFrame em que o utilizador escolhe um tipo de listagem especial das empresas na aplicação
 */

public class Listagens extends JFrame
{
    private JFrame listagens,frameAnterior;
    private Application app;
    private JPanel panel1,panel2;
    private JLabel label;
    private String[] types;
    private JComboBox jComboBoxAction;


    private JButton continuar,voltar;

    /**
     * Construtor da classe Listagens
     * @param frameAnterior Frame anterior à de Listagens
     * @param app   Aplicação
     */
    public Listagens(JFrame frameAnterior, Application app)
    {
        ImageIcon image = new ImageIcon("/Users/marcolucas/IdeaProjects/Projeto/src/projecto/logo.png");
        this.setIconImage(image.getImage());
        listagens = this;
        this.app = app;
        this.frameAnterior = frameAnterior;
        this.setTitle("Outras listagens");
        this.setSize(400,100);
        this.setLayout(new BorderLayout());
        createListing();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Definição dos elementos da JFrame
     **/
    private void createListing()
    {
        panel1 = new JPanel();
        panel2 = new JPanel();

        label = new JLabel("Selecione opção");
        types = new String[]{"Maior Receita Anual","Menor Despesa Anual","Maior Lucro Anual","Maior Capacidade de Clientes"};
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
                String listagem = (String)jComboBoxAction.getSelectedItem();
                Apresentar x = new Apresentar(listagem,listagens,frameAnterior,app);
                x.setSize(650,300);
                x.setVisible(true);
            }
            else if(e.getSource() == voltar)
            {
                frameAnterior.setVisible(true);
            }
            listagens.setVisible(false);
        }

    }


}
