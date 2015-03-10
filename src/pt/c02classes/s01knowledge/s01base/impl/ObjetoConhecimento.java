package pt.c02classes.s01knowledge.s01base.impl;

import pt.c02classes.s01knowledge.s01base.inter.IDeclaracao;
import pt.c02classes.s01knowledge.s01base.inter.IObjetoConhecimento;

public class ObjetoConhecimento implements IObjetoConhecimento
{
    private IDeclaracao declaracoes[];
    private int corrente = 0;
    
    public ObjetoConhecimento(IDeclaracao declaracoes[])
    {
    	this.declaracoes = declaracoes;
    }
    
    /* (non-Javadoc)
	 * @see pt.c03casochave.s01base.impl.IObjetoConhecimento#primeira()
	 */
    public IDeclaracao primeira()
    {
    	IDeclaracao priDecl = null;
    	
    	corrente = 0;
    	
    	if (declaracoes != null && declaracoes.length > 0)
    		priDecl = declaracoes[0];
    	
    	return priDecl;
    }
    
    /* (non-Javadoc)
	 * @see pt.c03casochave.s01base.impl.IObjetoConhecimento#proxima()
	 */
    public IDeclaracao proxima()
    {
    	IDeclaracao proxDecl = null;
    	
    	if (declaracoes != null && corrente < declaracoes.length-1) {
    		corrente++;
    		proxDecl = declaracoes[corrente];
    	}
    	
    	return proxDecl;
    }
}
