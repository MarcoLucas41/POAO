package projecto.Classes;

/**
 * Classe abstrata para definir parâmetros de uma Mercearia
 */
public abstract class Mercearia extends Empresa
{
    private float custoLimpezaAnual;

    /**
     * @param categoria Categoria/tipo de uma empresa
     * @param nome  Nome de uma empresa
     * @param distrito  Distrito de residência de uma empresa
     * @param coordenadas   Coordenadas da sede de uma empresa
     * @param custoLimpezaAnual Custo de limpeza anual de uma mercearia
     */
    public Mercearia(String categoria,String nome,String distrito,String coordenadas,String custoLimpezaAnual)
    {
        super(categoria,nome,distrito, coordenadas);
        this.custoLimpezaAnual = Float.parseFloat(custoLimpezaAnual);
    }

    public float getCustoLimpezaAnual()
    {
        return this.custoLimpezaAnual;
    }
}
