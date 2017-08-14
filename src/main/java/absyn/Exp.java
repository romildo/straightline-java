package absyn;

import java.util.Map;

public abstract class Exp extends AST {

   public abstract Double eval(Map<String, Double> mem);
}
