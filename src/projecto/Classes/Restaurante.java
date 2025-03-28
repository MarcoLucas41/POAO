package projecto.Classes;

/**
 * Classe abstrata para definir parâmetros de um restaurante
 */
public abstract class Restaurante extends Restauracao
{
    private int numDiasAberto;
    private int numMesasInterior;
    private float mediaFaturacaoMesaDia;

    /**
     * Construtor da classe Restaurante
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
     */
    public Restaurante(String categoria,String nome,String distrito,String coordenadas,
                       String numEmpregados,String numMedioClientesDia, String salarioMedioAnual,
                       String numDiasAberto,String numMesasInterior,String mediaFaturacaoMesaDia)
    {
        super(categoria,nome,distrito, coordenadas, numEmpregados,numMedioClientesDia, salarioMedioAnual);
        this.numDiasAberto = Integer.parseInt(numDiasAberto);
        this.numMesasInterior = Integer.parseInt(numMesasInterior);
        this.mediaFaturacaoMesaDia = Float.parseFloat(mediaFaturacaoMesaDia);
    }

    public int getNumDiasAberto()
    {
        return this.numDiasAberto;
    }

    public int getNumMesasInterior()
    {
        return this.numMesasInterior;
    }

    public float getMediaFaturacaoMesaDia()
    {
        return this.mediaFaturacaoMesaDia;
    }
}
