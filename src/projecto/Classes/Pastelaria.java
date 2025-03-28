package projecto.Classes;

/**
 * Classe para definir parâmetros de uma pastelaria
 */
public class Pastelaria extends Restauracao
{
    private float mediaVendasBolosDia,mediaFaturacaoAnualBolosDia;

    /**
     * Construtor da classe Pastelaria
     * @param categoria Categoria de uma empresa
     * @param nome  Nome de uma empresa
     * @param distrito  Distrito de uma empreas
     * @param coordenadas   Coordenadas de uma empresa
     * @param numEmpregados Número de empregados de uma empresa de restauração
     * @param numMedioClientesDia Número médio de clientes diário de uma empresa de restauração
     * @param salarioMedioAnual Salário médio anual numa empresa de restauração
     * @param mediaVendasBolosDia Média de bolos vendidos por dia numa pastelaria
     * @param mediaFaturacaoAnualBolosDia Média de faturação anual por bolos vendidos por dia numa pastelaria
     */
    public Pastelaria(String categoria,String nome,String distrito,String coordenadas,
                          String numEmpregados,String numMedioClientesDia, String salarioMedioAnual,
                          String mediaVendasBolosDia,String mediaFaturacaoAnualBolosDia)
    {
        super(categoria,nome,distrito, coordenadas, numEmpregados, numMedioClientesDia,salarioMedioAnual);
        this.mediaVendasBolosDia = Float.parseFloat(mediaVendasBolosDia);
        this.mediaFaturacaoAnualBolosDia = Float.parseFloat(mediaFaturacaoAnualBolosDia);
    }

    public float getMediaVendasBolosDia()
    {
        return this.mediaVendasBolosDia;
    }
    public float getMediaFaturacaoAnualBolosDia()
    {
        return this.mediaFaturacaoAnualBolosDia;
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
        return getMediaVendasBolosDia()*getMediaFaturacaoAnualBolosDia();
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
}
