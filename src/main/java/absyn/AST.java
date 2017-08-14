package absyn;

import io.vavr.render.ToTree;

public abstract class AST implements ToTree<String> {

   public abstract int maxargs();

}
