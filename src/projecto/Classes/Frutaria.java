package projecto.Classes;

/**
 * Classe para definir parâmetros de uma Mercearia
 */

public class Frutaria extends Mercearia
{
    private int numProdutos;
    private float mediaFaturacaoAnualProduto;

    /**
     * Construtor da classe Frutaria
     * @param categoria Categoria/tipo de uma empresa
     * @param nome  Nome de uma empresa
     * @param distrito  Distrito de residência de uma empresa
     * @param coordenadas   Coordenadas da sede de uma empresa
     * @param custoLimpezaAnual Custo de limpeza anual de uma mercearia
     * @param numProdutos Número de produtos de uma frutaria
     * @param mediaFaturacaoAnualProduto Média de faturação anual por produto de uma Frutaria
     */
    public Frutaria(String categoria,String nome,String distrito, String coordenadas,String custoLimpezaAnual,String numProdutos,String mediaFaturacaoAnualProduto)
    {
        super(categoria,nome,distrito, coordenadas, custoLimpezaAnual);
        this.numProdutos = Integer.parseInt(numProdutos);
        this.mediaFaturacaoAnualProduto = Float.parseFloat(mediaFaturacaoAnualProduto);
    }

    public int getNumProdutos()
    {
        return numProdutos;
    }
    public float getMediaFaturacaoAnualProduto()
    {
        return mediaFaturacaoAnualProduto;
    }

    @Override
    public float getDespesaAnual()
    {
        return getCustoLimpezaAnual();
    }

    @Override
    public float getReceitaAnual()
    {
        return ( (this.numProdutos)*(this.mediaFaturacaoAnualProduto) );
    }

    @Override
    public int getNumEmpregados()
    {
        return 0;
    }

    @Override
    public float getSalarioMedioAnual()
    {
        return 0;
    }

    @Override
    public float getNumMedioClientesDia()
    {
        return 0;
    }

    @Override
    public float getMediaVendasCafesDia()
    {
        return 0;
    }

    @Override
    public float getMediaFaturacaoAnualCafesDia()
    {
        return 0;
    }

    @Override
    public float getMediaVendasBolosDia()
    {
        return 0;
    }

    @Override
    public float getMediaFaturacaoAnualBolosDia()
    {
        return 0;
    }

    @Override
    public int getNumDiasAberto()
    {
        return 0;
    }

    @Override
    public int getNumMesasInterior()
    {
        return 0;
    }

    @Override
    public float getMediaFaturacaoMesaDia()
    {
        return 0;
    }

    @Override
    public int getNumMesasEsplanada()
    {
        return 0;
    }

    @Override
    public float getCustoLicencaEsplanada()
    {
        return 0;
    }

    @Override
    public float getNumMedioClientesDriveDia()
    {
        return 0;
    }

    @Override
    public float getMediaFaturacaoClientesDriveDia()
    {
        return 0;
    }

    @Override
    public String getTipo()
    {
        return null;
    }

    @Override
    public float getMediaFaturacaoAnualM2()
    {
        return 0;
    }

    @Override
    public float getAreaCorredor()
    {
        return 0;
    }
}
