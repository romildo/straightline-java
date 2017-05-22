import javaslang.collection.List;
import javaslang.collection.Tree;
import javaslang.render.ToTree;

import java.util.Map;

public class PrintStm extends Stm {

   public final List<Exp> exps;

   public PrintStm(List<Exp> exps) {
      this.exps = exps;
   }

   @Override
   public String toString() {
      return "PrintStm{" +
             "exps=" + exps +
             '}';
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("PrintStm", exps.map(Exp::toTree));
   }

   @Override
   public int maxargs() {
       int aux = exps.length();

       for(Exp e : exps)
           aux = Math.max(e.maxargs(), aux);

       return exps.length();
   }

    @Override
    public void interp(Map<String, Integer> mem) {
        exps.forEach(e -> System.out.println(e.eval(mem) + " "));
        System.out.println();
    }
}
