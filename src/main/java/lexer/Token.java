package lexer;

public class Token {
   public enum T {
      EOF, COMMA, PRINT, ID, INT,
      // ... definir os outros tipos de símbolos léxicos
   }

   public final T type;
   public final Object val;

   public Token(T type, Object val) {
      this.type = type;
      this.val = val;
   }

   public Token(T type) {
      this(type, null);
   }

   @Override
   public String toString() {
      return "Token[type=" + type + ", val=" + val + "]";
   }
}
