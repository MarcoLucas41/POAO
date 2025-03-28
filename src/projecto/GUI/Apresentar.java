package projecto.GUI;

import projecto.Classes.Empresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe que constrói a JFrame que apresenta as listagens de maior receita anual, menor despesa anual,...
 */
public class Apresentar extends JFrame
{
    private JLabel[] arrayOfLabels;

    private JButton button;
    private JPanel panel,buttonPanel;
    private String tipoListagem;
    private JFrame frameAnterior,frameInicial;
    private JTextField[] arrayOfTexts;
    private ArrayList<Empresa>[] al;
    private Application app;

    /**
     * Construtor da classe Apresentar
     * @param tipoListagem String que vai definir o tipo de listagem na frame
     * @param frameAnterior JFrame anterior à definida em Apresentar
     * @param frameInicial  Primeira JFrame da aplicação
     * @param app   Aplicação
     */
    public Apresentar(String tipoListagem,JFrame frameAnterior,JFrame frameInicial,Application app)
    {
        ImageIcon image = new ImageIcon("/Users/marcolucas/IdeaProjects/Projeto/src/projecto/logo.png");
        this.setIconImage(image.getImage());
        this.tipoListagem = tipoListagem;
        this.frameAnterior = frameAnterior;
        this.frameInicial = frameInicial;
        this.setLayout(new BorderLayout());
        this.setSize(400, 300);
        panel = new JPanel();
        buttonPanel = new JPanel();
        panel.setLayout(new GridLayout(6,2));
        buttonPanel.setLayout(new FlowLayout());
        ButtonListener btnListener = new ButtonListener();

        button = new JButton("Voltar");
        button.addActionListener(btnListener);
        buttonPanel.add(button);
        this.add(buttonPanel,BorderLayout.SOUTH);
        arrayOfTexts = new JTextField[6];
        arrayOfLabels = new JLabel[6];

        for(int i = 0; i < arrayOfTexts.length; i++)
        {
            arrayOfLabels[i] = new JLabel();
            arrayOfTexts[i] = new JTextField();
            arrayOfTexts[i].setEditable(false);
        }
        arrayOfLabels[0].setText("Café");
        arrayOfLabels[1].setText("Pastelaria");
        arrayOfLabels[2].setText("Restaurante Local");
        arrayOfLabels[3].setText("Restaurante Fast-Food");
        arrayOfLabels[4].setText("Mercado");
        arrayOfLabels[5].setText("Frutaria");
        this.app = app;

        al = new ArrayList[6];
        al[0] = app.getListaCafes();
        al[1] = app.getListaPastelarias();
        al[2] = app.getListaLocal();
        al[3] = app.getListaFastFood();
        al[4] = app.getListaMercado();
        al[5] = app.getListaFrutaria();
        apresentacao();
    }

    /**
     * Método de definição das labels e textfields incluídos na JFrame
     */
    private void apresentacao()
    {
        if(tipoListagem.equals("Maior Receita Anual"))
        {
            this.setTitle("Empresas com Maior Receita Anual");
            for (int i = 0; i < arrayOfTexts.length; i++) {
                panel.add(arrayOfLabels[i]);
                if(getArrayEmpresasMaiorReceitaAnual()[i] != null)
                {
                    arrayOfTexts[i].setText(String.format("%s -> %.2f", getArrayEmpresasMaiorReceitaAnual()[i].getNome(), getArrayEmpresasMaiorReceitaAnual()[i].getReceitaAnual()));
                }
                panel.add(arrayOfTexts[i]);
            }
        }

        else if(tipoListagem.equals("Menor Despesa Anual"))
        {
            this.setTitle("Empresas com Menor Despesa Anual");
            for (int i = 0; i < arrayOfTexts.length; i++) {
                panel.add(arrayOfLabels[i]);
                if(getArrayEmpresasMenorDespesaAnual()[i] != null)
                {
                    arrayOfTexts[i].setText(String.format("%s -> %.2f", getArrayEmpresasMenorDespesaAnual()[i].getNome(), getArrayEmpresasMenorDespesaAnual()[i].getDespesaAnual()));
                }
                panel.add(arrayOfTexts[i]);
            }

        }
        else if(tipoListagem.equals("Maior Lucro Anual"))
        {
            this.setTitle("Empresas com Maior Lucro Anual");
            for (int i = 0; i < arrayOfTexts.length; i++) {
                panel.add(arrayOfLabels[i]);
                if(getArrayEmpresasMaiorLucroAnual()[i] != null)
                {
                    float lucro = getArrayEmpresasMaiorLucroAnual()[i].getReceitaAnual()-getArrayEmpresasMaiorLucroAnual()[i].getDespesaAnual();
                    arrayOfTexts[i].setText(String.format("%s -> %.2f", getArrayEmpresasMaiorLucroAnual()[i].getNome(),lucro));
                }
                panel.add(arrayOfTexts[i]);
            }

        }
        else if(tipoListagem.equals("Maior Capacidade de Clientes"))
        {
            int capacidade;
            panel.setLayout(new GridLayout(2,2));
            this.setTitle("Empresas de Restauração com Maior Capacidade de Clientes");
            for(int i = 0; i < 2; i++)
            {
                arrayOfLabels[i].setText(String.format("%dºLugar",i+1));
                panel.add(arrayOfLabels[i]);
                if(getArrayEmpresasMaiorCapacidadeClientes()[i] != null)
                {
                    capacidade = getArrayEmpresasMaiorCapacidadeClientes()[i].getNumMesasEsplanada()+getArrayEmpresasMaiorCapacidadeClientes()[i].getNumMesasInterior();
                    arrayOfTexts[i].setText(String.format("%s -> %d",getArrayEmpresasMaiorCapacidadeClientes()[i].getNome(),capacidade));
                }
                panel.add(arrayOfTexts[i]);
            }
        }
        this.add(panel, BorderLayout.NORTH);
        this.setVisible(true);



    }
    /**
     * Classe privada associada a ações nos botôes da JFrame desta classe
     */


    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Apresentar.this.setVisible(false);
            frameAnterior.setVisible(true);
            Apresentar.this.dispose();
        }

    }

    /**
     * Método que retorna um array que contém as empresas com maior receita anual de todas as categorias
     * @return Array de empresas com maior receita anual de todas as categorias
     */
    private Empresa[] getArrayEmpresasMaiorReceitaAnual()
    {
        Empresa maxim;
        Empresa[] arrayEmpresas = new Empresa[6];

        for(int i = 0; i < 6; i++)
        {
            if(al[i].isEmpty())
            {
                arrayEmpresas[i] = null;
                continue;
            }
            maxim = al[i].get(0);
            for(Empresa e: al[i])
            {
                if(e.getReceitaAnual() > maxim.getReceitaAnual())
                {
                    maxim = e;
                }
            }
            arrayEmpresas[i] = maxim;
        }
        return arrayEmpresas;
    }
    /**
     * Método que retorna um array que contém as empresas com menor despesa anual de todas as categorias
     * @return Array de empresas com menor despesa anual de todas as categorias
     */
    private Empresa[] getArrayEmpresasMenorDespesaAnual()
    {
        Empresa minim;
        Empresa[] arrayEmpresas = new Empresa[6];

        for(int i = 0; i < 6; i++)
        {
            if(al[i].isEmpty())
            {
                arrayEmpresas[i] = null;
                continue;
            }
            minim = al[i].get(0);
            for(Empresa e: al[i])
            {
                if(e.getDespesaAnual() < minim.getReceitaAnual())
                {
                    minim = e;
                }
            }
            arrayEmpresas[i] = minim;
        }
        return arrayEmpresas;
    }

    /**
     * Método que retorna um array que contém as empresas com maior lucro anual de todas as categorias
     * @return Array de empresas com maior lucro anual de todas as categorias
     */
    private Empresa[] getArrayEmpresasMaiorLucroAnual()
    {
        Empresa maxim;
        Empresa[] arrayEmpresas = new Empresa[6];
        float lucro,lucromaxim;

        for(int i = 0; i < 6; i++)
        {
            if(al[i].isEmpty())
            {
                arrayEmpresas[i] = null;
                continue;
            }
            maxim = al[i].get(0);
            for(Empresa e: al[i])
            {
                lucro = e.getReceitaAnual()-e.getDespesaAnual();
                lucromaxim = maxim.getReceitaAnual()-maxim.getDespesaAnual();
                if(lucro > lucromaxim)
                {
                    maxim = e;
                }
            }
            arrayEmpresas[i] = maxim;
        }
        return arrayEmpresas;
    }
    /**
     * Método que retorna um array que contém as empresas de restauração com maior capacidade de clientes
     * @return Array de empresas de restauração com maior capacidade de clientes
     */
    private Empresa[] getArrayEmpresasMaiorCapacidadeClientes()
    {
        Empresa cap;
        ArrayList<Empresa> restauracao = new ArrayList<>();
        restauracao.addAll(al[2]);
        restauracao.addAll(al[3]);
        int capacidade1,capacidade2;
        Empresa[] arrayEmpresas = new Empresa[2];
        if(restauracao.isEmpty())
        {
            arrayEmpresas[0] = null;
            arrayEmpresas[1] = null;
            return arrayEmpresas;
        }
        Empresa temp;
        for(int i =0 ; i < restauracao.size(); i++) {
            for (int j = 1; j < (restauracao.size() - i); j++) {
                capacidade1 = restauracao.get(j-1).getNumMesasEsplanada() + restauracao.get(j - 1).getNumMesasInterior();
                capacidade2 = restauracao.get(j).getNumMesasEsplanada() + restauracao.get(j).getNumMesasInterior();
                if (capacidade1 > capacidade2) {
                    temp = restauracao.get(j - 1);
                    restauracao.set(j - 1, restauracao.get(j));
                    restauracao.set(j, temp);
                }
            }
        }
        arrayEmpresas[0] = restauracao.get(restauracao.size()-1);
        arrayEmpresas[1] = restauracao.get(restauracao.size()-2);

        return arrayEmpresas;
    }
}
