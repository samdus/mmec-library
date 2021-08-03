// Generated from /Users/duss2503/Documents/Projets/arot/hephaistos/mMEC/src/main/antlr/ca/griis/relrellang/LEX.g4 by ANTLR 4.9.1

//package ca.griis.lex;
/**
 * Le lexique.
 *
 * @version 0.1.0 2018-04-08 
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LEX extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IDENT=1, STRING=2, INTEGER=3, FLOAT=4, ESPACES=5, COMMENTAIRE_LIGNE=6, 
		COMMENTAIRE_MULTI=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IDENT", "STRING", "INTEGER", "FLOAT", "ESPACES", "COMMENTAIRE_LIGNE", 
			"COMMENTAIRE_MULTI", "A", "B", "C", "D", "E", "Eé", "F", "G", "H", "I", 
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", 
			"X", "Y", "Z", "IDENT0", "STRING0", "STRING1", "STRING2", "STRING3", 
			"UNICODE_H0", "UNICODE_H1", "ESC_SEQ", "UNICODE_ESC", "EXPONENT", "HEX_DIGITS", 
			"HEX_DIGIT", "DEC_DIGITS", "DEC_DIGIT", "OCT_DIGITS", "OCT_DIGIT", "BIN_DIGITS", 
			"BIN_DIGIT", "ALPHA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IDENT", "STRING", "INTEGER", "FLOAT", "ESPACES", "COMMENTAIRE_LIGNE", 
			"COMMENTAIRE_MULTI"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public LEX(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LEX.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u0166\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\3\2\3\2\5\2p\n\2\3\3\3\3\3\3\5\3u\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0081\n\4\3\5\3\5\3\5\3\5\5\5\u0087"+
		"\n\5\3\5\3\5\3\5\5\5\u008c\n\5\3\6\6\6\u008f\n\6\r\6\16\6\u0090\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\7\7\u0099\n\7\f\7\16\7\u009c\13\7\3\7\6\7\u009f\n\7"+
		"\r\7\16\7\u00a0\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00a9\n\b\f\b\16\b\u00ac\13"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\7"+
		"$\u00eb\n$\f$\16$\u00ee\13$\3%\3%\3%\3%\3%\3%\7%\u00f6\n%\f%\16%\u00f9"+
		"\13%\3%\3%\3&\3&\3&\3&\3&\3&\3&\7&\u0104\n&\f&\16&\u0107\13&\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0112\n\'\f\'\16\'\u0115\13\'\3\'\3\'\3("+
		"\3(\3(\3(\3(\3(\3(\7(\u0120\n(\f(\16(\u0123\13(\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\5+\u012d\n+\3,\3,\3,\3,\3-\3-\5-\u0135\n-\3-\3-\3.\3.\3.\3.\7.\u013d"+
		"\n.\f.\16.\u0140\13.\3/\3/\3\60\3\60\3\60\3\60\7\60\u0148\n\60\f\60\16"+
		"\60\u014b\13\60\3\61\3\61\3\62\3\62\3\62\3\62\7\62\u0153\n\62\f\62\16"+
		"\62\u0156\13\62\3\63\3\63\3\64\3\64\3\64\3\64\7\64\u015e\n\64\f\64\16"+
		"\64\u0161\13\64\3\65\3\65\3\66\3\66\3\u00aa\2\67\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\2\23\2\25\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-"+
		"\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2"+
		"W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2\3\2)\4\2DDdd\4\2EEee\4\2ZZzz\5\2\13"+
		"\f\16\17\"\"\4\2\f\f\17\17\4\2CCcc\4\2FFff\4\2GGgg\4\2\u00cb\u00cb\u00eb"+
		"\u00eb\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOo"+
		"o\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2"+
		"XXxx\4\2YYyy\4\2[[{{\4\2\\\\||\4\2C\\c|\7\2//\62;C\\aac|\4\2\"#%&\4\2"+
		"((*\u0080\4\2(ac\u0080\4\2\u00a2\u0871\u08a2\1\5\2\u00a2\u00bc\u00be\u0871"+
		"\u08a2\1\17\2$$\'\')+>>@@CFHHJJLLNNPPSXbb\4\2--//\5\2\62;CHch\2\u0161"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\3o\3\2\2\2\5t\3\2\2\2\7\u0080\3\2\2\2\t\u008b\3\2\2"+
		"\2\13\u008e\3\2\2\2\r\u0094\3\2\2\2\17\u00a4\3\2\2\2\21\u00b2\3\2\2\2"+
		"\23\u00b4\3\2\2\2\25\u00b6\3\2\2\2\27\u00b8\3\2\2\2\31\u00ba\3\2\2\2\33"+
		"\u00bc\3\2\2\2\35\u00be\3\2\2\2\37\u00c0\3\2\2\2!\u00c2\3\2\2\2#\u00c4"+
		"\3\2\2\2%\u00c6\3\2\2\2\'\u00c8\3\2\2\2)\u00ca\3\2\2\2+\u00cc\3\2\2\2"+
		"-\u00ce\3\2\2\2/\u00d0\3\2\2\2\61\u00d2\3\2\2\2\63\u00d4\3\2\2\2\65\u00d6"+
		"\3\2\2\2\67\u00d8\3\2\2\29\u00da\3\2\2\2;\u00dc\3\2\2\2=\u00de\3\2\2\2"+
		"?\u00e0\3\2\2\2A\u00e2\3\2\2\2C\u00e4\3\2\2\2E\u00e6\3\2\2\2G\u00e8\3"+
		"\2\2\2I\u00ef\3\2\2\2K\u00fc\3\2\2\2M\u010a\3\2\2\2O\u0118\3\2\2\2Q\u0126"+
		"\3\2\2\2S\u0128\3\2\2\2U\u012c\3\2\2\2W\u012e\3\2\2\2Y\u0132\3\2\2\2["+
		"\u0138\3\2\2\2]\u0141\3\2\2\2_\u0143\3\2\2\2a\u014c\3\2\2\2c\u014e\3\2"+
		"\2\2e\u0157\3\2\2\2g\u0159\3\2\2\2i\u0162\3\2\2\2k\u0164\3\2\2\2mp\5G"+
		"$\2np\5I%\2om\3\2\2\2on\3\2\2\2p\4\3\2\2\2qu\5K&\2ru\5M\'\2su\5O(\2tq"+
		"\3\2\2\2tr\3\2\2\2ts\3\2\2\2u\6\3\2\2\2v\u0081\5_\60\2wx\7\62\2\2xy\t"+
		"\2\2\2y\u0081\5g\64\2z{\7\62\2\2{|\t\3\2\2|\u0081\5c\62\2}~\7\62\2\2~"+
		"\177\t\4\2\2\177\u0081\5[.\2\u0080v\3\2\2\2\u0080w\3\2\2\2\u0080z\3\2"+
		"\2\2\u0080}\3\2\2\2\u0081\b\3\2\2\2\u0082\u0083\5_\60\2\u0083\u0084\7"+
		"\60\2\2\u0084\u0086\5_\60\2\u0085\u0087\5Y-\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u008c\3\2\2\2\u0088\u0089\5_\60\2\u0089\u008a\5Y"+
		"-\2\u008a\u008c\3\2\2\2\u008b\u0082\3\2\2\2\u008b\u0088\3\2\2\2\u008c"+
		"\n\3\2\2\2\u008d\u008f\t\5\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2"+
		"\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\b\6\2\2\u0093\f\3\2\2\2\u0094\u0095\7\61\2\2\u0095\u0096\7\61\2\2\u0096"+
		"\u009a\3\2\2\2\u0097\u0099\n\6\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009e\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009d\u009f\t\6\2\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\b\7\2\2\u00a3\16\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5\u00a6\7,\2"+
		"\2\u00a6\u00aa\3\2\2\2\u00a7\u00a9\13\2\2\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ad\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae\u00af\7\61\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\b\b\2\2\u00b1\20\3\2\2\2\u00b2\u00b3\t\7\2"+
		"\2\u00b3\22\3\2\2\2\u00b4\u00b5\t\2\2\2\u00b5\24\3\2\2\2\u00b6\u00b7\t"+
		"\3\2\2\u00b7\26\3\2\2\2\u00b8\u00b9\t\b\2\2\u00b9\30\3\2\2\2\u00ba\u00bb"+
		"\t\t\2\2\u00bb\32\3\2\2\2\u00bc\u00bd\t\n\2\2\u00bd\34\3\2\2\2\u00be\u00bf"+
		"\t\13\2\2\u00bf\36\3\2\2\2\u00c0\u00c1\t\f\2\2\u00c1 \3\2\2\2\u00c2\u00c3"+
		"\t\r\2\2\u00c3\"\3\2\2\2\u00c4\u00c5\t\16\2\2\u00c5$\3\2\2\2\u00c6\u00c7"+
		"\t\17\2\2\u00c7&\3\2\2\2\u00c8\u00c9\t\20\2\2\u00c9(\3\2\2\2\u00ca\u00cb"+
		"\t\21\2\2\u00cb*\3\2\2\2\u00cc\u00cd\t\22\2\2\u00cd,\3\2\2\2\u00ce\u00cf"+
		"\t\23\2\2\u00cf.\3\2\2\2\u00d0\u00d1\t\24\2\2\u00d1\60\3\2\2\2\u00d2\u00d3"+
		"\t\25\2\2\u00d3\62\3\2\2\2\u00d4\u00d5\t\26\2\2\u00d5\64\3\2\2\2\u00d6"+
		"\u00d7\t\27\2\2\u00d7\66\3\2\2\2\u00d8\u00d9\t\30\2\2\u00d98\3\2\2\2\u00da"+
		"\u00db\t\31\2\2\u00db:\3\2\2\2\u00dc\u00dd\t\32\2\2\u00dd<\3\2\2\2\u00de"+
		"\u00df\t\33\2\2\u00df>\3\2\2\2\u00e0\u00e1\t\34\2\2\u00e1@\3\2\2\2\u00e2"+
		"\u00e3\t\4\2\2\u00e3B\3\2\2\2\u00e4\u00e5\t\35\2\2\u00e5D\3\2\2\2\u00e6"+
		"\u00e7\t\36\2\2\u00e7F\3\2\2\2\u00e8\u00ec\t\37\2\2\u00e9\u00eb\t \2\2"+
		"\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed"+
		"\3\2\2\2\u00edH\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f7\7$\2\2\u00f0\u00f6"+
		"\t!\2\2\u00f1\u00f2\7\'\2\2\u00f2\u00f6\5U+\2\u00f3\u00f6\4(\u0080\2\u00f4"+
		"\u00f6\5Q)\2\u00f5\u00f0\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f3\3\2\2"+
		"\2\u00f5\u00f4\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7$\2\2\u00fb"+
		"J\3\2\2\2\u00fc\u0105\7)\2\2\u00fd\u0104\4\"&\2\u00fe\u00ff\7\'\2\2\u00ff"+
		"\u0104\5U+\2\u0100\u0104\t\"\2\2\u0101\u0104\5Q)\2\u0102\u0104\7\f\2\2"+
		"\u0103\u00fd\3\2\2\2\u0103\u00fe\3\2\2\2\u0103\u0100\3\2\2\2\u0103\u0101"+
		"\3\2\2\2\u0103\u0102\3\2\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0108\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7)"+
		"\2\2\u0109L\3\2\2\2\u010a\u0113\7b\2\2\u010b\u0112\4\"&\2\u010c\u010d"+
		"\7\'\2\2\u010d\u0112\5U+\2\u010e\u0112\t#\2\2\u010f\u0112\5Q)\2\u0110"+
		"\u0112\7\f\2\2\u0111\u010b\3\2\2\2\u0111\u010c\3\2\2\2\u0111\u010e\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113"+
		"\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0116\u0117\7b\2\2\u0117N\3\2\2\2\u0118\u0121\7\u00ad\2\2\u0119\u0120"+
		"\4\"&\2\u011a\u011b\7\'\2\2\u011b\u0120\5U+\2\u011c\u0120\4(\u0080\2\u011d"+
		"\u0120\5S*\2\u011e\u0120\7\f\2\2\u011f\u0119\3\2\2\2\u011f\u011a\3\2\2"+
		"\2\u011f\u011c\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u011e\3\2\2\2\u0120\u0123"+
		"\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123"+
		"\u0121\3\2\2\2\u0124\u0125\7\u00bd\2\2\u0125P\3\2\2\2\u0126\u0127\t$\2"+
		"\2\u0127R\3\2\2\2\u0128\u0129\t%\2\2\u0129T\3\2\2\2\u012a\u012d\t&\2\2"+
		"\u012b\u012d\5W,\2\u012c\u012a\3\2\2\2\u012c\u012b\3\2\2\2\u012dV\3\2"+
		"\2\2\u012e\u012f\7\61\2\2\u012f\u0130\5\7\4\2\u0130\u0131\7\61\2\2\u0131"+
		"X\3\2\2\2\u0132\u0134\t\t\2\2\u0133\u0135\t\'\2\2\u0134\u0133\3\2\2\2"+
		"\u0134\u0135\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0137\5_\60\2\u0137Z\3"+
		"\2\2\2\u0138\u013e\5]/\2\u0139\u013d\5]/\2\u013a\u013b\7a\2\2\u013b\u013d"+
		"\5]/\2\u013c\u0139\3\2\2\2\u013c\u013a\3\2\2\2\u013d\u0140\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\\\3\2\2\2\u0140\u013e\3\2\2\2"+
		"\u0141\u0142\t(\2\2\u0142^\3\2\2\2\u0143\u0149\5a\61\2\u0144\u0148\5a"+
		"\61\2\u0145\u0146\7a\2\2\u0146\u0148\5a\61\2\u0147\u0144\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2"+
		"\2\2\u014a`\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\4\62;\2\u014db\3\2"+
		"\2\2\u014e\u0154\5e\63\2\u014f\u0153\5e\63\2\u0150\u0151\7a\2\2\u0151"+
		"\u0153\5e\63\2\u0152\u014f\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0156\3\2"+
		"\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155d\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0157\u0158\4\629\2\u0158f\3\2\2\2\u0159\u015f\5i\65\2\u015a"+
		"\u015e\5i\65\2\u015b\u015c\7a\2\2\u015c\u015e\5i\65\2\u015d\u015a\3\2"+
		"\2\2\u015d\u015b\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160h\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\4\62\63"+
		"\2\u0163j\3\2\2\2\u0164\u0165\t\37\2\2\u0165l\3\2\2\2\37\2ot\u0080\u0086"+
		"\u008b\u0090\u009a\u00a0\u00aa\u00ec\u00f5\u00f7\u0103\u0105\u0111\u0113"+
		"\u011f\u0121\u012c\u0134\u013c\u013e\u0147\u0149\u0152\u0154\u015d\u015f"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}