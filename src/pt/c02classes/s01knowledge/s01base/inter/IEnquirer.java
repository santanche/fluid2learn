package pt.c02classes.s01knowledge.s01base.inter;

public interface IEnquirer
{
    public void connect(IResponder responder);
    public boolean discover();
}
