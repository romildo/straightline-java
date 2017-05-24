import java.util.Map;

public abstract class Stm extends AST {

   public abstract void interp(Map<String, Integer> mem);

}
