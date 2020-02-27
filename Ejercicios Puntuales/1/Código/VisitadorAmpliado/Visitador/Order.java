package Visitador;
public interface Order {
  public void accept(VisitorInterface v);
  public void setID(int ID);
}
