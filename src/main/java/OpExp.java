import javaslang.collection.Tree;

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
}
