package absyn;

import io.vavr.collection.Tree;

import java.util.Map;

public class EseqExp extends Exp {

   public final Stm stm;
   public final Exp exp;

   public EseqExp(Stm stm, Exp exp) {
      this.stm = stm;
      this.exp = exp;
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("EseqExp", stm.toTree(), exp.toTree());
   }

   @Override
   public int maxargs() {
      return Math.max(stm.maxargs(), exp.maxargs());
   }

   @Override
   public Double eval(Map<String, Double> mem) {
      stm.interp(mem);
      return exp.eval(mem);
   }
}
