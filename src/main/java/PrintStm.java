import javaslang.collection.List;

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
}
