import java.util.*;

public class Client {
  public static void main(String[] args) {
    //Create an appropriate implementer object
    MessageLogger logger = new ConsoleLogger();

    //Choose required interface object and
    // configure it with the implementer object
    Message msg = new TextMessage(logger);

    msg.log("Test Message");

  }
}
