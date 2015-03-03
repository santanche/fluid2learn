package pt.c01interfaces.s01knowledge.s01base.impl;

import pt.c01interfaces.s01knowledge.s01base.inter.IDeclaracao;

public class Declaracao implements IDeclaracao
{
    private String propriedade;
    private String valor;
    
    public Declaracao(String propriedade, String valor)
    {
    	this.propriedade = propriedade;
    	this.valor = valor;
    }
    
    public String getPropriedade()
    {
    	return propriedade;
    }
    
    public String getValor()
    {
    	return valor;
    }
    
    public String toString()
    {
    	return "(propriedade: " + propriedade + ", valor: " + valor + ")";
    }
}
