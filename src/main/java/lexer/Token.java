package lexer;

public class Token {
   public enum T {
      COMMA,
      PRINT,
      ID,
      INT,
      // ... definir os outros tipos de símbolos léxicos
      EOF
   }

   public T type;
   public Object val;

   public Token(T type, Object val) {
      this.type = type;
      this.val = val;
   }

   public Token(T type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return "Token[type=" + type + ", val=" + val + "]";
   }
}
