package projecto.GUI;

import projecto.Classes.Cafe;
import projecto.Classes.Empresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Subclasse de Attributes especifíca para editar os atributos de uma empresa
 */

public class Editar extends Attributes
{
    private JFrame editar;
    private Empresa empresa;

    /**
     * Construtor da classe Editar
     * @param empresa Empresa a ser editada
     * @param frameAnterior Frame anterior à atual
     * @param app   Aplicação
     * @param frameInicial  Frame inicial da aplicação
     */
    public Editar(Empresa empresa, JFrame frameAnterior, Application app, JFrame frameInicial)
    {
        super(empresa.getCategoria(), frameAnterior, app, frameInicial);
        editar = this;
        this.empresa = empresa;
        fillTextFields();
    }

    /**
     * Método que preenche os textfields de uma JFrame de Attributes com os dados de uma empresa
     */
    private void fillTextFields()
    {
            if(empresa.getCategoria().equals("cafe"))
            {
                textsEmpresa();
                textsRestauracao();
                getArrayOfTexts()[7].setText(String.format("%.2f", empresa.getMediaVendasCafesDia()));
                getArrayOfTexts()[8].setText(String.format("%.2f", empresa.getMediaFaturacaoAnualCafesDia()));
            }
            else if(empresa.getCategoria().equals("pastelaria"))
            {
                textsEmpresa();
                textsRestauracao();
                getArrayOfTexts()[7].setText(String.format("%.2f", empresa.getMediaVendasBolosDia()));
                getArrayOfTexts()[8].setText(String.format("%.2f", empresa.getMediaFaturacaoAnualBolosDia()));
            }
            else if(empresa.getCategoria().equals("local")) {
                textsEmpresa();
                textsRestauracao();
                textsRestaurante();
                getArrayOfTexts()[10].setText(String.format("%d", empresa.getNumMesasEsplanada()));
                getArrayOfTexts()[11].setText(String.format("%.2f", empresa.getCustoLicencaEsplanada()));
            }
            else if(empresa.getCategoria().equals("fast-food")) {
                textsEmpresa();
                textsRestauracao();
                textsRestaurante();
                getArrayOfTexts()[10].setText(String.format("%.2f", empresa.getNumMedioClientesDriveDia()));
                getArrayOfTexts()[11].setText(String.format("%.2f", empresa.getMediaFaturacaoClientesDriveDia()));
            }
            else if(empresa.getCategoria().equals("mercado")) {
                textsEmpresa();
                getArrayOfTexts()[4].setText(String.format("%.2f", empresa.getCustoLimpezaAnual()));
                getArrayOfTexts()[5].setText(empresa.getTipo());
                getArrayOfTexts()[6].setText(String.format("%.2f", empresa.getAreaCorredor()));
                getArrayOfTexts()[7].setText(String.format("%.2f", empresa.getMediaFaturacaoAnualM2()));
            }

            else if(empresa.getCategoria().equals("frutaria"))
            {
                textsEmpresa();
                getArrayOfTexts()[4].setText(String.format("%.2f",empresa.getCustoLimpezaAnual()));
                getArrayOfTexts()[5].setText(String.format("%d",empresa.getNumProdutos()));
                getArrayOfTexts()[6].setText(String.format("%.2f",empresa.getMediaFaturacaoAnualProduto()));

            }


        getRegistar().removeAll();
        getRegistar().setText("Guardar Alterações");
        getVoltar().removeAll();
        getVoltar().setText("Voltar");
        getRegistar().addActionListener(new ButtonListener());
        getVoltar().addActionListener(new ButtonListener());


    }

    /**
     * Método de preenchimento dos textfields destinados para dados de empresa independentes de categoria
     */
    private void textsEmpresa()
    {
        getArrayOfTexts()[0].setText(empresa.getCategoria());
        getArrayOfTexts()[1].setText(empresa.getNome());
        getArrayOfTexts()[2].setText(empresa.getDistrito());
        getArrayOfTexts()[3].setText(empresa.getCoordenadas());
    }
    /**
     * Método de preenchimento dos textfields destinados para dados de empresa de restauração
     */
    private void textsRestauracao()
    {
        getArrayOfTexts()[4].setText(String.format("%d",empresa.getNumEmpregados()));
        getArrayOfTexts()[5].setText(String.format("%.2f",empresa.getNumMedioClientesDia()));
        getArrayOfTexts()[6].setText(String.format("%.2f",empresa.getSalarioMedioAnual()));
    }
    /**
     * Método de preenchimento dos textfields destinados para dados de restaurantes
     */
    private void textsRestaurante()
    {
        getArrayOfTexts()[7].setText(String.format("%d",empresa.getNumDiasAberto()));
        getArrayOfTexts()[8].setText(String.format("%.2f",empresa.getMediaFaturacaoMesaDia()));
        getArrayOfTexts()[9].setText(String.format("%d",empresa.getNumMesasInterior()));
    }
    /**
     * Classe privada associada a ações nos botôes da JFrame desta classe
     */
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == getRegistar())
            {
                String s = "";
                for(int i = 0; i < getArrayOfTexts().length; i++)
                {
                    if(getArrayOfTexts()[i].getText().equals(null))
                    {
                        getArrayOfTexts()[i].setText("");
                        continue;
                    }
                    if(i == (getArrayOfTexts().length)-1)
                    {
                        s = s.concat(getArrayOfTexts()[i].getText());
                        System.out.println(s+"\n");
                    }
                    else
                    {
                        s = s.concat(getArrayOfTexts()[i].getText()+";");
                        System.out.println(s+"\n");
                    }
                }
                int i = getApp().getListaEmpresas().indexOf(empresa);
                System.out.printf("%d\n",i);
                getApp().Apagar(empresa);
                Empresa y = getApp().createObjectFromText(s);
                getApp().getListaEmpresas().add(i,y);
                try
                {
                    getApp().storeInObjectFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                Starthrive f = new Starthrive(getApp(),getApp().getListaEmpresas());
                f.setVisible(true);
                getFrameInicial().dispose();
                getFrameAnterior().dispose();
            }
            else if(e.getSource() == getVoltar())
            {
                getFrameAnterior().setVisible(true);
            }
            editar.setVisible(false);
        }

    }


}
