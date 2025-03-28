package projecto.GUI;

import projecto.Classes.Empresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe que cria uma JFrame para o utilizador introduzir os dados necessários para a criação de uma Empresa
 */

public class Attributes extends JFrame
{
    private JFrame Attributes,frameInicial,frameAnterior;
    private String type;
    private Application app;
    private JPanel panel,buttonPanel;
    private JLabel categoria,nome,distrito,coordenadas;
    private JLabel numEmpregados,numMedioClientesDia,salarioMedioAnual;
    private JLabel mediaVendasCafesDia,mediaVendasBolosDia,mediaFaturacaoAnualCafesDia,mediaFaturacaoAnualBolosDia;
    private JLabel numDiasAberto,numMesasInterior,mediaFaturacaoMesaDia;
    private JLabel numMesasEsplanada,custoLicencaEsplanada,numMedioClientesDriveDia,mediaFaturacaoClientesDriveDia;
    private JLabel custoLimpezaAnual;
    private JLabel tipo,areaCorredor,mediaFaturacaoAnualM2,numProdutos,mediaFaturacaoAnualProduto;

    private JButton registar,voltar;
    private JTextField[] arrayOfTexts;

    /**
     * Construtor da classe Attributes
     * @param type  String que vai definir o formato da frame com base na categoria da empresa a ser criada
     * @param frameAnterior Frame anterior a que é criada em Attributes
     * @param app Aplicação
     * @param frameInicial Frame inicial da aplicação
     */

    public Attributes(String type, JFrame frameAnterior,Application app,JFrame frameInicial)
    {
        ImageIcon image = new ImageIcon("/Users/marcolucas/IdeaProjects/Projeto/src/projecto/logo.png");
        this.setIconImage(image.getImage());
        this.Attributes = this;
        panel = new JPanel();
        buttonPanel = new JPanel(new FlowLayout());

        registar = new JButton("Registar");
        voltar = new JButton("Voltar");

        this.frameAnterior = frameAnterior;
        this.frameInicial = frameInicial;
        this.app = app;
        this.type = type;
        this.setLayout(new BorderLayout());

        arrayOfTexts = new JTextField[12];
        for(int i = 0; i < 12; i++)
        {
            arrayOfTexts[i] = new JTextField();
        }
        arrayOfTexts[0].setEditable(false);
        setAttributes(type);
    }

    /**
     * Método que retorna a categoria da empresa a ser criada
     * @return Categoria da empresa a ser criada
     */
    public String getCategoria(){return type;};

    /**
     * Método que retorna a frame anterior a que è criada em Attributes
     * @return Frame anterior à de Attributes
     */
    public JFrame getFrameAnterior()
    {
        return frameAnterior;
    }

    /**
     * Método que retorna a frame inicial da aplicação
     * @return Frame inicial da aplicação
     */
    public JFrame getFrameInicial(){return frameInicial;}

    /**
     * Método de retorno da aplicação
     * @return Aplicação
     */
    public Application getApp()
    {
        return app;
    }

    /**
     * Método de retorno do array de textfields colocados na frame de Attributes
     * @return
     */
    public JTextField[] getArrayOfTexts()
    {
        return arrayOfTexts;
    }

    /**
     * Método que constrói um panel personalizado para as informações de uma empresa Café
     */
    private void createPanelCafe()
    {
        arrayOfTexts[0].setText("cafe");
        settingEmpresaLabels();
        settingRestauracaoLabels();
        mediaVendasCafesDia = new JLabel("Média de Cafés Vendidos por Dia");
        mediaFaturacaoAnualCafesDia = new JLabel("Média Anual de Faturação de Cafés Vendidos por Dia");
        panel.setLayout(new GridLayout(11,2));

        panel.add(mediaVendasCafesDia);panel.add(arrayOfTexts[7]);
        panel.add(mediaFaturacaoAnualCafesDia);panel.add(arrayOfTexts[8]);


    }
    /**
     * Método que constrói um panel personalizado para as informações de uma empresa Pastelaria
     */
    private void createPanelPastelaria()
    {
        arrayOfTexts[0].setText("pastelaria");
        settingEmpresaLabels();
        settingRestauracaoLabels();
        mediaVendasBolosDia = new JLabel("Média de Bolos Vendidos por Dia");
        mediaFaturacaoAnualBolosDia = new JLabel("Média Anual de Faturação de Bolos Vendidos por Dia");
        panel.setLayout(new GridLayout(11,2));

        panel.add(mediaVendasBolosDia);panel.add(arrayOfTexts[7]);
        panel.add(mediaFaturacaoAnualBolosDia);panel.add(arrayOfTexts[8]);

    }
    /**
     * Método que constrói um panel personalizado para as informações de uma empresa Restaurante Local
     */
    private void createPanelLocal()
    {
        arrayOfTexts[0].setText("local");
        settingEmpresaLabels();
        settingRestauracaoLabels();
        settingRestauranteLabels();

        numMesasEsplanada = new JLabel("Número de Mesas de Esplanada");
        custoLicencaEsplanada = new JLabel("Custo de Licença de Esplanada");
        panel.setLayout(new GridLayout(14,2));

        panel.add(numMesasEsplanada);panel.add(arrayOfTexts[10]);
        panel.add(custoLicencaEsplanada);panel.add(arrayOfTexts[11]);


    }
    /**
     * Método que constrói um panel personalizado para as informações de uma empresa Restaurante Fast-Food
     */
    private void createPanelFastFood()
    {
        arrayOfTexts[0].setText("fast-food");
        settingEmpresaLabels();
        settingRestauracaoLabels();
        settingRestauranteLabels();

        numMedioClientesDriveDia = new JLabel("Número Médio Diário de Clientes Drive-Through");
        mediaFaturacaoClientesDriveDia = new JLabel("Média de Faturação Diária de Clientes Drive-Through");
        panel.setLayout(new GridLayout(14,2));

        panel.add(numMedioClientesDriveDia);panel.add(arrayOfTexts[10]);
        panel.add(mediaFaturacaoClientesDriveDia);panel.add(arrayOfTexts[11]);


    }
    /**
     * Método que constrói um panel personalizado para as informações de uma empresa Mercado
     */
    private void createPanelMercado()
    {
        arrayOfTexts[0].setText("mercado");
        settingEmpresaLabels();
        settingMerceariaLabels();
        tipo = new JLabel("Tipo");
        areaCorredor = new JLabel("Área dos Corredores");
        mediaFaturacaoAnualM2 = new JLabel("Faturação Média Anual por Metro Quadrado");
        panel.setLayout(new GridLayout(10,2));
        panel.add(tipo);panel.add(arrayOfTexts[5]);
        panel.add(areaCorredor);panel.add(arrayOfTexts[6]);
        panel.add(mediaFaturacaoAnualM2);panel.add(arrayOfTexts[7]);

    }
    /**
     * Método que constrói um panel personalizado para as informações de uma empresa Frutaria
     */
    private void createPanelFrutaria()
    {
        arrayOfTexts[0].setText("frutaria");
        settingEmpresaLabels();
        settingMerceariaLabels();
        numProdutos = new JLabel("Número de Produtos");
        mediaFaturacaoAnualProduto = new JLabel("Média de Faturação Anual por Produto");
        panel.setLayout(new GridLayout(9,2));
        panel.add(numProdutos);panel.add(arrayOfTexts[5]);
        panel.add(mediaFaturacaoAnualProduto);panel.add(arrayOfTexts[6]);

    }

    /**
     * Método que verifica o tipo de painel que vai ser construído para a frame de Attributes e inicia esse processo
     * @param categoria Categoria da empresa que vai ser construída
     */
    private void setAttributes(String categoria)
    {
        if(categoria.equals("cafe"))
        {
            createPanelCafe();
        }
        else if(categoria.equals("pastelaria"))
        {
            createPanelPastelaria();
        }
        else if(categoria.equals("local"))
        {
            createPanelLocal();
        }
        else if(categoria.equals("fast-food"))
        {
            createPanelFastFood();
        }
        else if(categoria.equals("local"))
        {
            createPanelLocal();
        }
        else if(categoria.equals("mercado"))
        {
            createPanelMercado();
        }
        else if(categoria.equals("frutaria"))
        {
            createPanelFrutaria();
        }

        this.add(panel,BorderLayout.NORTH);
        ArrayList<JButton> listaBotoes = new ArrayList<>();
        listaBotoes.add(registar);
        listaBotoes.add(voltar);
        settingButtons(listaBotoes);
    }

    /**
     * Métodos que definem as labels da frame
     */
    private void settingEmpresaLabels()
    {
        categoria = new JLabel("Categoria");
        nome = new JLabel("Nome");
        distrito = new JLabel("Distrito");
        coordenadas = new JLabel("Coordenadas");
        panel.add(categoria);panel.add(arrayOfTexts[0]);
        panel.add(nome);panel.add(arrayOfTexts[1]);
        panel.add(distrito);panel.add(arrayOfTexts[2]);
        panel.add(coordenadas);panel.add(arrayOfTexts[3]);
    }
    private void settingRestauracaoLabels()
    {
        numEmpregados = new JLabel("Número de Empregados");
        numMedioClientesDia = new JLabel("Número Médio de Clientes por Dia");
        salarioMedioAnual = new JLabel("Salário Médio Anual");
        panel.add(numEmpregados);panel.add(arrayOfTexts[4]);
        panel.add(numMedioClientesDia);panel.add(arrayOfTexts[5]);
        panel.add(salarioMedioAnual);panel.add(arrayOfTexts[6]);

    }
    private void settingRestauranteLabels()
    {
        numDiasAberto = new JLabel("Número de Dias Aberto");
        mediaFaturacaoMesaDia = new JLabel("Média de Faturação de Mesa por Dia");
        numMesasInterior = new JLabel("Número de Mesas Interiores");
        panel.add(numDiasAberto);panel.add(arrayOfTexts[7]);
        panel.add(mediaFaturacaoMesaDia);panel.add(arrayOfTexts[8]);
        panel.add(numMesasInterior);panel.add(arrayOfTexts[9]);
    }
    private void settingMerceariaLabels()
    {
        custoLimpezaAnual = new JLabel("Custo de Limpeza Anual");
        panel.add(custoLimpezaAnual);panel.add(arrayOfTexts[4]);

    }

    /**
     * Definição de botões
     * @param listaBotoes Lista de botões
     */
    private void settingButtons(ArrayList<JButton> listaBotoes)
    {
        ButtonListener btnActionListener = new ButtonListener();
        for(JButton button: listaBotoes)
        {
            button.addActionListener(btnActionListener);
            buttonPanel.add(button);
        }
        this.add(buttonPanel,BorderLayout.SOUTH);
    }

    /**
     * Método que retorna o botão que permite guardar a empresa na aplicação
     * @return Botão
     */
    public JButton getRegistar()
    {
        return registar;
    }

    /**
     * Método que retorna o botão que permite voltar para a frame anterior
     * @return
     */
    public JButton getVoltar(){return voltar;}

    /**
     * Classe privada associada a ações nos botôes da JFrame desta classe
     */
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == registar)
            {
                String s = "";
                for(int i = 0; i < arrayOfTexts.length; i++)
                {
                    if(arrayOfTexts[i].getText().equals(null))
                    {
                        arrayOfTexts[i].setText("");
                        continue;
                    }
                    System.out.printf("%s\n",arrayOfTexts[i].getText());
                    if(i == (arrayOfTexts.length)-1)
                    {
                        s = s.concat(arrayOfTexts[i].getText());
                        System.out.println(s+"\n");
                    }
                    else
                    {
                        s = s.concat(arrayOfTexts[i].getText()+";");
                        System.out.println(s+"\n");
                    }
                }

                Empresa y = app.createObjectFromText(s);
                Empresa z = app.getEmpresaByNome(y.getNome());
                if(z == null)
                {
                    app.getListaEmpresas().add(y);
                    try
                    {
                        app.storeInObjectFile();
                    } catch (IOException ex) {
                    throw new RuntimeException(ex);
                    }
                }
                else
                {
                    int i = app.getListaEmpresas().indexOf(z);
                    app.getListaEmpresas().remove(z);
                    app.getListaEmpresas().add(i,y);
                }


                Starthrive f = new Starthrive(app,app.getListaEmpresas());
                f.setVisible(true);
                frameInicial.dispose();
                frameAnterior.dispose();
            }
            else if(e.getSource() == voltar)
            {
                frameAnterior.setVisible(true);
            }
            Attributes.setVisible(false);
        }

    }

}
