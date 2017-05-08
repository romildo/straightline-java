public class AssignStm extends Stm {
   public final String id;
   public final Stm stm2;

   public AssignStm(String id, Stm stm2) {
      this.id = id;
      this.stm2 = stm2;
   }

   @Override
   public String toString() {
      return "AssignStm{" +
             "id='" + id + '\'' +
             ", stm2=" + stm2 +
             '}';
   }
}
