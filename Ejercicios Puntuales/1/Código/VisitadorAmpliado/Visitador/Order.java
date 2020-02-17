package Visitador;
public interface Order {
  public void accept(OrderVisitor v);
}
