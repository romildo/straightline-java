import javaslang.collection.Tree;

public class CompoundStm extends Stm {

   public final Stm stm1;
   public final Stm stm2;

   public CompoundStm(Stm stm1, Stm stm2) {
      this.stm1 = stm1;
      this.stm2 = stm2;
   }

   @Override
   public String toString() {
      return "CompoundStm{" +
             "stm1=" + stm1 +
             ", stm2=" + stm2 +
             '}';
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("CompoundStm", stm1.toTree(), stm2.toTree());
   }
}
