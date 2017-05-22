import javaslang.collection.Tree;

public class NumExp extends Exp {
   public final int num;

   public NumExp(int num) {
      this.num = num;
   }

   @Override
   public String toString() {
      return "NumExp{" +
             "num=" + num +
             '}';
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("NumExp " + num);
   }
}
