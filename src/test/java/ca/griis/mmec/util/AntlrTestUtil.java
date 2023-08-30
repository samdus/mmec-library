package ca.griis.mmec.util;

import ca.griis.mmec.antlr.gen.mMecLexer;
import ca.griis.mmec.antlr.gen.mMecParser;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

public class AntlrTestUtil {

  public static Boolean hasBeenParsedCompletely(File file, String rule)
      throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    final Lexer lexer = new mMecLexer(CharStreams.fromFileName(file.getAbsolutePath()));
    lexer.removeErrorListeners();
    final CommonTokenStream tokenStream = new CommonTokenStream(lexer);

    Parser parser = new mMecParser(tokenStream);
    parser.removeErrorListeners();

    ParserRuleContext parserRuleContext =
        (ParserRuleContext) parser.getClass().getMethod(rule).invoke(parser);

    final List<Token> realTokens = tokenStream.getTokens().stream().filter(
            token -> token.getChannel() == Lexer.DEFAULT_TOKEN_CHANNEL && token.getType() != Lexer.EOF)
        .collect(Collectors.toList());

    Integer indexOfStop = parserRuleContext.getStop().getTokenIndex();
    Integer lastRuleToken = rule.equals(parser.getRuleNames()[0]) ? indexOfStop : indexOfStop + 1;
    System.out.println("indexOfStop: " + indexOfStop);
    System.out.println("token stream size: " + realTokens.size());
    System.out.println(realTokens);

    return realTokens.size() == lastRuleToken;
  }
}
