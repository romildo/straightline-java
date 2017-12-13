package absyn;

import io.vavr.collection.Tree;

import java.util.Map;

public class OpExp extends Exp {

   public enum Op { PLUS, MINUS, TIMES, DIV }

   public final Exp left;
   public final Exp right;
   public final Op op;

   public OpExp(Exp left, Exp right, Op op) {
      this.left = left;
      this.right = right;
      this.op = op;
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("OpExp " + op, left.toTree(), right.toTree());
   }

   @Override
   public int maxargs() {
      return Math.max(left.maxargs(), right.maxargs());
   }

   @Override
   public Double eval(Map<String, Double> mem) {
      Double x = left.eval(mem);
      Double y = right.eval(mem);
      switch (op) {
         case PLUS: return x + y;
         case MINUS: return x - y;
         case TIMES: return x * y;
         case DIV: return x / y;
         default: return 0.0;
      }
   }
}
