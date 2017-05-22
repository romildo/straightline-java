import javaslang.collection.Tree;

public class IdExp extends Exp {
   public final String id;

   public IdExp(String id) {
      this.id = id;
   }

   @Override
   public String toString() {
      return "IdExp{" +
             "id='" + id + '\'' +
             '}';
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("IdExp " + id);
   }
}
