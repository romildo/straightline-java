import javaslang.collection.List;
import javaslang.collection.Tree;

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
      for (Exp e : exps)
         aux = Math.max(aux, e.maxargs());
      return aux;
   }

   @Override
   public void interp(Map<String, Integer> mem) {
      exps.forEach(e -> System.out.print(e.eval(mem) + " "));
      System.out.println();
   }
}
