import javaslang.collection.Tree;

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
   public String toString() {
      return "OpExp{" +
             "left=" + left +
             ", right=" + right +
             ", op=" + op +
             '}';
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
   public Integer eval(Map<String, Integer> mem) {
      Integer x = left.eval(mem);
      Integer y = right.eval(mem);
      switch (op) {
         case PLUS: return x + y;
         case MINUS: return x - y;
         case TIMES: return x * y;
         case DIV: return x / y;
         default: return 0;
      }
   }
}
