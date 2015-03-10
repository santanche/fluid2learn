package pt.c02classes.s01knowledge.s01base.inter;


public interface IResponder
{
    public String scenario();
	public String ask(String question);
	public boolean move(String direction);
    public boolean finalAnswer(String answer);
}
