package projecto.Classes;

import java.io.Serializable;

/**
 * Classe abstrata para definir parâmetros independentes da categoria de uma empresa.
 * É a superclasse de todas as classes neste pacote.
 */
public abstract class Empresa implements Serializable
{

    private String categoria,nome,distrito,coordenadas;
    private float despesaAnual;
    private float receitaAnual;

    /**
     * Construtor da classe Empresa
     * @param categoria Categoria/tipo de uma empresa
     * @param nome  Nome de uma empresa
     * @param distrito  Distrito de residência de uma empresa
     * @param coordenadas   Coordenadas da sede de uma empresa
     */

    public Empresa(String categoria,String nome,String distrito,String coordenadas)
    {
        this.categoria = categoria.toLowerCase();
        this.nome = nome;
        this.distrito = distrito;
        this.coordenadas = coordenadas;
    }

    /**
     * Método de retorno do parâmetro 'nome' de uma empresa
     * @return Nome de uma empresa
     */
    public String getNome()
    {
        return this.nome;
    }
    /**
     * Método de retorno do parâmetro 'categoria' de uma empresa
     * @return Categoria de uma empresa
     */
    public String getCategoria()
    {
        return this.categoria;
    }
    /**
     * Método de retorno do parâmetro 'distrito' de uma empresa
     * @return Distrito de uma empresa
     */
    public String getDistrito()
    {
        return this.distrito;
    }
    /**
     * Método de retorno do parâmetro 'coordenadas' de uma empresa
     * @return Coordenadas de uma empresa
     */
    public String getCoordenadas()
    {
        return this.coordenadas;
    }

    /**
     * Os seguintes métodos abstratos devolvem atributos definidos nas subclasses; a sua inicialização na super
     * classe permite um fácil acesso de dados na aplicação.
     */




    /**
     * Método abstrato de retorno da despesa anual de uma empresa
     * @return Despesa anual de uma empresa
     */

    public abstract float getDespesaAnual();
    /**
     * Método abstrato de retorno da receita anual de uma empresa
     * @return Receita anual de uma empresa
     */
    public abstract float getReceitaAnual();
    /**
     * Método abstrato de retorno do número de empregados de uma empresa de restauração
     * @return Despesa anual de uma empresa
     */
    public abstract int getNumEmpregados();
    /**
     * Método abstrato de retorno do salário médio anual de um empregado de uma empresa de restauração
     * @return Salário médio anualde uma empresa
     */
    public abstract float getSalarioMedioAnual();
    /**
     * Método abstrato de retorno do número médio diário de clientes de uma empresa de restauração
     * @return Número médio diário de clientes de uma empresa de restauração
     */
    public abstract float getNumMedioClientesDia();
    /**
     * Método abstrato de retorno do número médio diário de vendas de cafés de um Café
     * @return Número médio diário de vendas de cafés de um Café
     */
    public abstract float getMediaVendasCafesDia();
    /**
     * Método abstrato de retorno da média da faturação anual da venda diária de cafés de um Café
     * @return média da faturação anual da venda diária de cafés de um Café
     */
    public abstract float getMediaFaturacaoAnualCafesDia();
    /**
     * Método abstrato de retorno do número médio diário de vendas de bolos de uma Pastelaria
     * @return Número médio diário de vendas de bolos de uma Pastelaria
     */
    public abstract float getMediaVendasBolosDia();
    /**
     * Método abstrato de retorno da média da faturação anual da venda diária de bolos de uma Pastelaria
     * @return Média da faturação anual da venda diária de bolos de uma Pastelaria
     */
    public abstract float getMediaFaturacaoAnualBolosDia();
    /**
     * Método abstrato de retorno da número de dias de funcionamento anual de um restaurante
     * @return Número de dias de funcionamento anual de um restaurante
     */
    public abstract int getNumDiasAberto();
    /**
     * Método abstrato de retorno da número de mesas interiores de um restaurante
     * @return Número de mesas interiores de um restaurante
     */
    public abstract int getNumMesasInterior();
    /**
     * Método abstrato de retorno da média de faturação diária das mesas de um restaurante
     * @return Média de faturação diária de uma mesa
     */
    public abstract float getMediaFaturacaoMesaDia();
    /**
     * Método abstrato de retorno do número de mesas de uma esplanada de um restaurante Local
     * @return Número de mesas de uma esplanada de um restaurante Local
     */
    public abstract int getNumMesasEsplanada();
    /**
     * Método abstrato de retorno do custo de licença de esplanada de um restaurante Local
     * @return Custo de licença de esplanada de um restaurante Local
     */
    public abstract float getCustoLicencaEsplanada();

    /**
     * Método abstrato de retorno do número médio de clientes drive-through de um restaurante Fast-Food
     * @return Número médio de clientes drive-through de um restaurante Fast-Food
     */
    public abstract float getNumMedioClientesDriveDia();
    /**
     * Método abstrato de retorno da média de faturação de clientes drive-through diários de um restaurante Fast-Food
     * @return Média de faturação de clientes drive-through diários de um restaurante Fast-Food
     */
    public abstract float getMediaFaturacaoClientesDriveDia();

    /**
     * Método abstrato de retorno do custo de limpeza anual de uma Mercearia
     * @return Custo de limpeza anual de uma Mercearia
     */
    public abstract float getCustoLimpezaAnual();
    /**
     * Método abstrato de retorno do tipo de um Mercado
     * @return Tipo de um Mercado
     */
    public abstract String getTipo();
    /**
     * Método abstrato de retorno da faturação média anual por área de metro quadrado dos corredores de um Mercado
     * @return Tipo de um Mercado
     */
    public abstract float getMediaFaturacaoAnualM2();

    /**
     * Método abstrato de retorno da área dos corredores de um Mercado
     * @return Área dos corredores de um Mercado
     */
    public abstract float getAreaCorredor();

    /**
     * Método abstrato de retorno do número de produtos de uma Frutaria
     * @return Número de produtos de uma Frutaria
     */
    public abstract int getNumProdutos();
    /**
     * Método abstrato de retorno da média de faturação anual por produto de uma Frutaria
     * @return Média de faturação anual por produto de uma Frutaria
     */
    public abstract float getMediaFaturacaoAnualProduto();




}
