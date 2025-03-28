package projecto.Classes;

/**
 * Classe para definir parâmetros de um restaurante local
 */
public class Local extends Restaurante
{
    private int numMesasEsplanada;
    private float custoLicencaEsplanada;

    /**
     * Construtor da classe Local
     * @param categoria Categoria de uma empresa
     * @param nome  Nome de uma empresa
     * @param distrito  Distrito de uma empreas
     * @param coordenadas   Coordenadas de uma empresa
     * @param numEmpregados Número de empregados de uma empresa de restauração
     * @param numMedioClientesDia Número médio de clientes diário de uma empresa de restauração
     * @param salarioMedioAnual Salário médio anual numa empresa de restauração
     * @param numDiasAberto Número de dias de funcionamento anual de uma empresa de restauração
     * @param numMesasInterior  Número de mesas interiores de um restaurante
     * @param mediaFaturacaoMesaDia Média de faturação diária de mesas de um restaurante
     * @param numMesasEsplanada Número de mesas de esplanada de um restaurante local
     * @param custoLicencaEsplanada Custo de licença de esplanda de um restaurante local
     */
    public Local(String categoria,String nome,String distrito,String coordenadas,
                 String numEmpregados,String numMedioClientesDia, String salarioMedioAnual,
                 String numDiasAberto,String numMesasInterior,
                 String mediaFaturacaoMesaDia,String numMesasEsplanada,String custoLicencaEsplanada)
    {
        super(categoria,nome, distrito, coordenadas, numEmpregados,numMedioClientesDia,salarioMedioAnual, numDiasAberto, numMesasInterior, mediaFaturacaoMesaDia);
        this.numMesasEsplanada = Integer.parseInt(numMesasEsplanada);
        this.custoLicencaEsplanada = Float.parseFloat(custoLicencaEsplanada);
    }

    public int getNumMesasEsplanada()
    {
        return this.numMesasEsplanada;
    }

    public float getCustoLicencaEsplanada()
    {
        return this.custoLicencaEsplanada;
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
        return (getNumEmpregados())*(getSalarioMedioAnual()) + (getNumMesasEsplanada())*(getCustoLicencaEsplanada());
    }

    @Override
    public float getReceitaAnual()
    {
        return ( (getNumMesasInterior())+(getNumMesasEsplanada()) )*(getMediaFaturacaoMesaDia())*(getNumDiasAberto());
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
}
