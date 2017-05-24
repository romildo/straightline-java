package lexer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;


public class Test {
   public static void main(String[] args) {
      try {
         Reader input = args.length > 0 ?
                        new FileReader(args[0]) :
                        new InputStreamReader(System.in);
         testLexer(new BufferedReader(input));
      }
      catch (IOException e) {
         System.err.println(e);
      }
   }

   private static void testLexer(Reader input) throws IOException {
      Lexer lex = new Lexer(input);
      Token tok;
      do {
         tok = lex.get();
         System.out.println(tok);
      }
      while (tok.type != Token.T.EOF);
   }
}
