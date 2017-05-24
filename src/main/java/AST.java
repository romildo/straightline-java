import javaslang.render.ToTree;

public abstract class AST implements ToTree<String> {

   public abstract int maxargs();

}
