package projecto.Classes;

/**
 * Classe para definir parâmetros de uma mercado
 */
public class Mercado extends Mercearia
{
    private String tipo;
    private float areaCorredor;
    private float mediaFaturacaoAnualM2;

    /**
     *
     * @param categoria Categoria/tipo de uma empresa
     * @param nome  Nome de uma empresa
     * @param distrito  Distrito de residência de uma empresa
     * @param coordenadas   Coordenadas da sede de uma empresa
     * @param custoLimpezaAnual Custo de limpeza anual de uma mercearia
     * @param tipo Tipo de mercado
     * @param areaCorredor Área dos corredores de mercado
     * @param mediaFaturacaoAnualM2 Média de faturação anual por área de metro quadrado dos corredores de um mercado
     */
    public Mercado(String categoria,String nome,String distrito, String coordenadas,
                   String custoLimpezaAnual,String tipo, String areaCorredor,String mediaFaturacaoAnualM2)
    {
        super(categoria,nome, distrito, coordenadas, custoLimpezaAnual);
        this.tipo = tipo;
        this.areaCorredor = Float.parseFloat(areaCorredor);
        this.mediaFaturacaoAnualM2 = Float.parseFloat(mediaFaturacaoAnualM2);
    }
    public String getTipo()
    {
        return this.tipo;
    }

    public float getMediaFaturacaoAnualM2()
    {
        return this.mediaFaturacaoAnualM2;
    }

    public float getAreaCorredor()
    {
        return this.areaCorredor;
    }

    @Override
    public int getNumProdutos()
    {
        return 0;
    }

    @Override
    public float getMediaFaturacaoAnualProduto()
    {
        return 0;
    }

    @Override
    public float getDespesaAnual()
    {
        return getCustoLimpezaAnual();
    }

    @Override
    public float getReceitaAnual()
    {
        return getAreaCorredor()*getMediaFaturacaoAnualM2();
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

}
