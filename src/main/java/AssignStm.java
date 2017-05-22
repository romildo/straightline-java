import javaslang.collection.Tree;

public class AssignStm extends Stm {

   public final String id;
   public final Exp exp;

   public AssignStm(String id, Exp exp) {
      this.id = id;
      this.exp = exp;
   }

   @Override
   public String toString() {
      return "AssignStm{" +
             "id='" + id + '\'' +
             ", exp=" + exp +
             '}';
   }

   @Override
   public Tree.Node<String> toTree() {
      return Tree.of("AssignStm", Tree.of(id), exp.toTree());
   }
}
