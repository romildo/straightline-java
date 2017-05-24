import java.util.Map;

public abstract class Exp extends AST {

   public abstract Integer eval(Map<String, Integer> mem);
}
