package projecto.Classes;

/**
 * Classe para definir parâmetros de um restaurante fast-food
 */

public class FastFood extends Restaurante
{
    private float numMedioClientesDriveDia;
    private float mediaFaturacaoClientesDriveDia;

    /**
     * Construtor da classe FastFood
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
     * @param numMedioClientesDriveDia Número médio diário de clientes drive-through
     * @param mediaFaturacaoClientesDriveDia Média de faturação diária por clientes-through
     */
    public FastFood(String categoria,String nome,String distrito,String coordenadas,
                    String numEmpregados,String numMedioClientesDia, String salarioMedioAnual,
                    String numDiasAberto,String numMesasInterior,
                    String mediaFaturacaoMesaDia,String numMedioClientesDriveDia, String mediaFaturacaoClientesDriveDia)

    {
        super(categoria,nome,distrito, coordenadas,
                 numEmpregados,numMedioClientesDia, salarioMedioAnual,
                numDiasAberto, numMesasInterior, mediaFaturacaoMesaDia);
        this.numMedioClientesDriveDia = Float.parseFloat(numMedioClientesDriveDia);
        this.mediaFaturacaoClientesDriveDia = Float.parseFloat(mediaFaturacaoClientesDriveDia);
    }

    public float getNumMedioClientesDriveDia()
    {
        return this.numMedioClientesDriveDia;
    }
    public float getMediaFaturacaoClientesDriveDia()
    {
        return this.mediaFaturacaoClientesDriveDia;
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
        return (getNumEmpregados()*getSalarioMedioAnual());
    }

    @Override
    public float getReceitaAnual()
    {
        return ( (getNumMesasInterior())*(getMediaFaturacaoMesaDia()) );
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
    public int getNumMesasEsplanada()
    {
        return 0;
    }

    @Override
    public float getCustoLicencaEsplanada()
    {
        return 0;
    }
}
