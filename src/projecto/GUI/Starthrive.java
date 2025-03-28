package projecto.GUI;

import projecto.Classes.Empresa;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Classe que cria a frame inicial da aplicação
 */



public class Starthrive extends JFrame
{
    private JFrame starthrive;
    private JList lista;
    private Application app;
    private JButton button1,button2,button3;
    private ArrayList<Empresa> listaEmpresas;
    private Empresa e;

    /**
     * Construtor da classe Starthrive
     * @param app Aplicação
     * @param listaEmpresas Lista de empresas na aplicação
     */
    public Starthrive(Application app,ArrayList<Empresa> listaEmpresas)
    {
        starthrive = this;
        this.listaEmpresas = listaEmpresas;
        this.app = app;
        //Colocação de um logótipo
        ImageIcon image = new ImageIcon("/Users/marcolucas/IdeaProjects/Projeto/src/projecto/logo.png");
        this.setIconImage(image.getImage());
        this.setTitle("\uD835\uDE82\uD835\uDE9D\uD835\uDE8A\uD835\uDE9B\uD835\uDE83\uD835\uDE91\uD835\uDE9B\uD835\uDE92\uD835\uDE9F\uD835\uDE8E");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Criação de uma JList
        JLabel label = new JLabel("Lista de Empresas");
        label.setBounds(50, 10, 300, 25);
        DefaultListModel listValues = new DefaultListModel();
        System.out.println(app.getListaEmpresas());
        for (Empresa empresa : app.getListaEmpresas()) {
            listValues.addElement(empresa.getNome());
        }
        lista = new JList(listValues);
        JScrollPane listScroller = new JScrollPane(lista);
        listScroller.setBounds(50, 35, 300, 150);
        button1 = new JButton("Adicionar Nova Empresa");
        button2 = new JButton("Outras listagens");
        button3 = new JButton("Sair");
        ButtonListener btnActionListener = new ButtonListener();
        button1.addActionListener(btnActionListener);
        button2.addActionListener(btnActionListener);
        button3.addActionListener(btnActionListener);
        button1.setBounds(40, 200, 200, 25);
        button2.setBounds(250,200,150,25);
        button3.setBounds(250,225,150,25);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(label);
        panel.add(listScroller);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        this.add(panel);
        this.setVisible(true);

        MouseListener mouseListener = new MouseAdapter()
        {
            public void mouseClicked(MouseEvent mouseEvent)
            {
                JList<String> theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        String nome = theList.getModel().getElementAt(index);
                        e = app.getEmpresaByNome(nome);

                        JPanel P = new JPanel();
                        Details x = new Details(starthrive,app,e);
                        x.setSize(650,300);
                        x.setVisible(true);
                    }
                }
            }
        };
        lista.addMouseListener(mouseListener);
    }

    /**
     * Classe privada associada a ações nos botôes da JFrame desta classe
     */

    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == button1)
            {
                starthrive.setVisible(false);
                Adicionar frame = new Adicionar(starthrive, app);
            }
            else if(e.getSource() == button2)
            {
                starthrive.setVisible(false);
                Listagens frame = new Listagens(starthrive, app);
            }
            else if(e.getSource() == button3)
            {
                starthrive.setVisible(false);
                starthrive.dispose();
            }

        }
    }
}
