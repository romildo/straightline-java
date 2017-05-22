import javaslang.collection.List;
import javaslang.collection.Tree;

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
}
