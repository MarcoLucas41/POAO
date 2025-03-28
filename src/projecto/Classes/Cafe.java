package projecto.Classes;

/**
 * Classe para definir parâmetros de um café
 */

public class Cafe extends Restauracao
{
    private float mediaVendasCafesDia,mediaFaturacaoAnualCafesDia;

    /**
     * Construtor da classe Cafe
     * @param categoria Categoria de uma empresa
     * @param nome  Nome de uma empresa
     * @param distrito  Distrito de uma empreas
     * @param coordenadas   Coordenadas de uma empresa
     * @param numEmpregados Número de empregados de uma empresa de restauração
     * @param numMedioClientesDia Número médio de clientes diário de uma empresa de restauração
     * @param salarioMedioAnual Salário médio anual numa empresa de restauração
     * @param mediaVendasCafesDia Média de cafés vendidos por dia num café
     * @param mediaFaturacaoAnualCafesDia Média de faturação anual por cafés vendidos diariamente num café
     */
    public Cafe(String categoria,String nome,String distrito,String coordenadas,
                String numEmpregados,String numMedioClientesDia, String salarioMedioAnual,
                String mediaVendasCafesDia,String mediaFaturacaoAnualCafesDia)
    {
        super(categoria,nome,distrito, coordenadas, numEmpregados, numMedioClientesDia,salarioMedioAnual);
        this.mediaVendasCafesDia = Float.parseFloat(mediaVendasCafesDia);
        this.mediaFaturacaoAnualCafesDia = Float.parseFloat(mediaFaturacaoAnualCafesDia);
    }

    public float getMediaVendasCafesDia()
    {
        return this.mediaVendasCafesDia;
    }
    public float getMediaFaturacaoAnualCafesDia()
    {
        return this.mediaFaturacaoAnualCafesDia;
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
    public float getCustoLimpezaAnual()
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
        return getNumEmpregados()*getSalarioMedioAnual();
    }
    @Override
    public float getReceitaAnual()
    {
        return getMediaVendasCafesDia()*getMediaFaturacaoAnualCafesDia();
    }




}

