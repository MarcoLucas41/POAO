package projecto.GUI;

import projecto.Classes.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Classe que gere a leitura e escrita nos ficheiros de texto e de objetos
 */


public class Application
{
    private String linhaTexto;
    private File txt, dat;
    private FileReader fr;
    private BufferedReader br;
    private FileInputStream fis;
    private FileOutputStream fos;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private ArrayList<Empresa> listaEmpresas,listaCafes,listaPastelarias,listaLocal,listaFastFood,listaMercado,listaFrutaria;

    /**
     * Construtor da classe Application
     */

    public Application()
    {
        listaEmpresas = new ArrayList<>();
        listaCafes = new ArrayList<>();
        listaPastelarias = new ArrayList<>();
        listaLocal = new ArrayList<>();
        listaFastFood = new ArrayList<>();
        listaMercado = new ArrayList<>();
        listaFrutaria = new ArrayList<>();

        dat = new File("/Users/marcolucas/IdeaProjects/Projeto/Ficheiros/starthrive.dat");
        getFromObject(dat);
        Starthrive f = new Starthrive(this,listaEmpresas);
    }

    /**
     * Método de retorno de ArrayList de todas as empresas
     * @return ArrayList de todas as empresas
     */

    public ArrayList<Empresa> getListaEmpresas()
    {
        return listaEmpresas;
    }
    /**
     * Método de retorno de ArrayList de todas as empresas de Café
     * @return ArrayList de todas as empresas de Café
     */
    public ArrayList<Empresa> getListaCafes(){return listaCafes;}
    /**
     * Método de retorno de ArrayList de todas as empresas de Pastelaria
     * @return ArrayList de todas as empresas de Pastelaria
     */
    public ArrayList<Empresa> getListaPastelarias(){return listaPastelarias;}
    /**
     * Método de retorno de ArrayList de todas os restaurantes locais
     * @return ArrayList de todas os restaurantes locais
     */
    public ArrayList<Empresa> getListaLocal(){return listaLocal;}
    /**
     * Método de retorno de ArrayList de todas os restaurantes fast-food
     * @return ArrayList de todas os restaurantes fast-food
     */
    public ArrayList<Empresa> getListaFastFood(){return listaFastFood;}
    /**
     * Método de retorno de ArrayList de todas os mercados
     * @return ArrayList de todas os mercados
     */
    public ArrayList<Empresa> getListaMercado(){return listaMercado;}
    /**
     * Método de retorno de ArrayList de todas as frutarias
     * @return ArrayList de todas as frutarias
     */
    public ArrayList<Empresa> getListaFrutaria(){return listaFrutaria;}


    /**
     * Método de retorno de um objeto de tipo Empresa
     * @param nome Nome da empresa
     * @return  Empresa com o nome passado como argumento
     */


    public Empresa getEmpresaByNome(String nome)
    {
        for(Empresa e: listaEmpresas)
        {
            if(e.getNome().equals(nome))
            {
                return e;
            }
        }
        return null;
    }

    /**
     * Método que escreve a lista de todas as empresas no ficheiro de objetos
     * @throws IOException
     */
    public void storeInObjectFile() throws IOException
    {
        fos = new FileOutputStream(dat);
        oos = new ObjectOutputStream(fos);
        oos.writeObject(listaEmpresas);
        fos.close();
        oos.close();

    }

    /**
     * Método de leitura do ficheiro de objetos "starthrive.dat"
     * @param dat Ficheiro de objetos
     */


    private void getFromObject(File dat)
    {
        if (dat.exists()) {
            System.out.println("exists");
            if (dat.canRead() && dat.isFile()) {
                try {
                    System.out.println("read");
                    fis = new FileInputStream(dat);
                    ois = new ObjectInputStream(fis);
                    listaEmpresas = (ArrayList<Empresa>)ois.readObject();
                    System.out.println(listaEmpresas);
                    for(Empresa empresa: listaEmpresas)
                    {
                        switch(empresa.getCategoria())
                        {
                            case "cafe":
                                listaCafes.add(empresa);
                                break;
                            case "pastelaria":
                                listaPastelarias.add(empresa);
                                break;
                            case "local":
                                listaLocal.add(empresa);
                                break;
                            case "fast-food":
                                listaFastFood.add(empresa);
                                break;
                            case "mercado":
                                listaMercado.add(empresa);
                                break;
                            case "frutaria":
                                listaFrutaria.add(empresa);
                                break;
                        }
                    }
                    System.out.println(listaLocal);
                    ois.close();
                } catch (EOFException e) {
                    System.out.println("GREAT SUCESS!\n");
                } catch (IOException e) {
                    System.out.println("Error: cannot read file 'starthrive.dat'!\n");
                } catch (ClassNotFoundException e) {
                    System.out.println("Error: class 'empresa' not found in 'starthrive.dat'!\n");
                }
            }
        } else {
            System.out.println("Warning: file 'starthrive.dat' does not exist!\nCreating new file...");
            getFromText(dat);
        }

    }

    /**
     * Método de leitura do ficheiro de texto para preencher a lista de empresas da aplicação, no cenário em que não existe um ficheiro de objetos
     * @param dat Ficheiro de objetos
     */

    private void getFromText(File dat)
    {
        ArrayList<Empresa>temp = new ArrayList<>();
        Empresa empresa;
        txt = new File("/Users/marcolucas/IdeaProjects/Projeto/Ficheiros/starthrive.txt");
        if (txt.exists() && txt.canRead() && txt.isFile())//get data from starthrive.txt and create a new file named "starthrive.dat"
        {
            try
            {
                fos = new FileOutputStream(dat);
                oos = new ObjectOutputStream(fos);
                fr = new FileReader(txt);
                br = new BufferedReader(fr);
                while ((linhaTexto = br.readLine()) != null)
                {
                    empresa = createObjectFromText(linhaTexto);
                    temp.add(empresa);
                }
                oos.writeObject(temp);
                oos.close();
                br.close();
                getFromObject(dat);
            } catch (FileNotFoundException e) {
                System.out.println("File starthrive.txt does not exit!\n");
            } catch (IOException e) {
                System.out.println("Error: cannot set data in object file! File may not have been created.\n");
            }
        }
    }

    /**
     * Método de criação de um objeto de tipo "Empresa" usando,passada como parâmetro, uma linha de texto do ficheiro de texto.
     * Também é utilizado na criação de novas empresas na aplicação, desde que o formato da linha de texto seja o adequado para um certo construtor de uma categoria de Empresa
     * @param line Linha do ficheiro de texto
     * @return Nova empresa
     */
    public Empresa createObjectFromText(String line)
    {
        String[] blocks = line.split(";");
        System.out.println(blocks[0]);
        switch (blocks[0]) {
            case "cafe": {
                System.out.println("Cafe");
                return new Cafe(blocks[0], blocks[1], blocks[2], blocks[3], blocks[4], blocks[5], blocks[6], blocks[7], blocks[8]);
            }
            case "pastelaria": {
                System.out.println("Pastelaria");
                return new Pastelaria(blocks[0], blocks[1], blocks[2], blocks[3], blocks[4], blocks[5], blocks[6], blocks[7], blocks[8]);
            }
            case "local": {
                System.out.println("Restaurante Local");
                return new Local(blocks[0], blocks[1], blocks[2], blocks[3], blocks[4], blocks[5], blocks[6], blocks[7], blocks[8], blocks[9], blocks[10], blocks[11]);

            }
            case "fast-food": {
                System.out.println("Restaurante Fast-food");
                return new FastFood(blocks[0], blocks[1], blocks[2], blocks[3], blocks[4], blocks[5], blocks[6], blocks[7], blocks[8], blocks[9], blocks[10], blocks[11]);
            }
            case "mercado": {
                System.out.println("Mercado");
                return new Mercado(blocks[0], blocks[1], blocks[2], blocks[3], blocks[4], blocks[5], blocks[6], blocks[7]);
            }
            case "frutaria": {
                System.out.println("Frutaria");
                return new Frutaria(blocks[0], blocks[1], blocks[2], blocks[3], blocks[4], blocks[5], blocks[6]);
            }
            default: {
                System.out.println("Categoria Desconhecida");
                return null;
            }
        }

    }

    /**
     * Método que apaga uma empresa de todas as listas de empresas
     * @param e Empresa que vai ser apagada
     */
    public void Apagar(Empresa e)
    {
        listaEmpresas.remove(e);
        listaCafes.remove(e);
        listaPastelarias.remove(e);
        listaLocal.remove(e);
        listaFastFood.remove(e);
        listaMercado.remove(e);
        listaFrutaria.remove(e);
    }







}






