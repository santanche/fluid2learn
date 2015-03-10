package pt.c02classes.s01knowledge.s01base.inter;


public interface IBaseConhecimento
{
	public void setScenario(String scenario);
    public String[] listaNomes();
	public IObjetoConhecimento recuperaObjeto(String nome);
}