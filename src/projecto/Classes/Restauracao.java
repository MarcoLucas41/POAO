package projecto.Classes;

/**
 * Classe para definir parâmetros de uma empresa de restauração
 */

public abstract class Restauracao extends Empresa
{
    private int numEmpregados;
    private float numMedioClientesDia,salarioMedioAnual;

    /**
     * Construtor da classe Restauração
     * @param categoria Categoria de uma empresa
     * @param nome  Nome de uma empresa
     * @param distrito  Distrito de uma empreas
     * @param coordenadas   Coordenadas de uma empresa
     * @param numEmpregados Número de empregados de uma empresa de restauração
     * @param numMedioClientesDia Número médio de clientes diário de uma empresa de restauração
     * @param salarioMedioAnual Salário médio anual numa empresa de restauração
     */
    public Restauracao(String categoria,String nome,String distrito,String coordenadas,
                       String numEmpregados,String numMedioClientesDia,String salarioMedioAnual)
    {
        super(categoria,nome, distrito, coordenadas);
        this.numEmpregados = Integer.parseInt(numEmpregados);
        this.numMedioClientesDia = Float.parseFloat(numMedioClientesDia);
        this.salarioMedioAnual = Float.parseFloat(salarioMedioAnual);
    }
    public int getNumEmpregados()
    {
        return this.numEmpregados;
    }
    public float getSalarioMedioAnual()
    {
        return this.salarioMedioAnual;
    }
    public float getNumMedioClientesDia()
    {
        return this.numMedioClientesDia;
    }


}
