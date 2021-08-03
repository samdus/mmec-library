// Generated from /Users/duss2503/Documents/Projets/arot/hephaistos/mMEC/src/main/antlr/ca/griis/relrellang/mDiscipulus_LEX.g4 by ANTLR 4.9.1

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
public class mDiscipulus_LEX extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHERE=1, IDENT=2, STRING=3, INTEGER=4, FLOAT=5, ESPACES=6, COMMENTAIRE_LIGNE=7, 
		COMMENTAIRE_MULTI=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHERE", "IDENT", "STRING", "INTEGER", "FLOAT", "ESPACES", "COMMENTAIRE_LIGNE", 
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
			null, "WHERE", "IDENT", "STRING", "INTEGER", "FLOAT", "ESPACES", "COMMENTAIRE_LIGNE", 
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


	public mDiscipulus_LEX(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "mDiscipulus_LEX.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u016e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\5\3"+
		"x\n\3\3\4\3\4\3\4\5\4}\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"\u0089\n\5\3\6\3\6\3\6\3\6\5\6\u008f\n\6\3\6\3\6\3\6\5\6\u0094\n\6\3\7"+
		"\6\7\u0097\n\7\r\7\16\7\u0098\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u00a1\n\b\f"+
		"\b\16\b\u00a4\13\b\3\b\6\b\u00a7\n\b\r\b\16\b\u00a8\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\7\t\u00b1\n\t\f\t\16\t\u00b4\13\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\7%\u00f3\n%\f%\16%\u00f6\13%\3&\3&\3"+
		"&\3&\3&\3&\7&\u00fe\n&\f&\16&\u0101\13&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\7\'\u010c\n\'\f\'\16\'\u010f\13\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\7"+
		"(\u011a\n(\f(\16(\u011d\13(\3(\3(\3)\3)\3)\3)\3)\3)\3)\7)\u0128\n)\f)"+
		"\16)\u012b\13)\3)\3)\3*\3*\3+\3+\3,\3,\5,\u0135\n,\3-\3-\3-\3-\3.\3.\5"+
		".\u013d\n.\3.\3.\3/\3/\3/\3/\7/\u0145\n/\f/\16/\u0148\13/\3\60\3\60\3"+
		"\61\3\61\3\61\3\61\7\61\u0150\n\61\f\61\16\61\u0153\13\61\3\62\3\62\3"+
		"\63\3\63\3\63\3\63\7\63\u015b\n\63\f\63\16\63\u015e\13\63\3\64\3\64\3"+
		"\65\3\65\3\65\3\65\7\65\u0166\n\65\f\65\16\65\u0169\13\65\3\66\3\66\3"+
		"\67\3\67\3\u00b2\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\25\2\27\2"+
		"\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;"+
		"\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i"+
		"\2k\2m\2\3\2)\4\2DDdd\4\2EEee\4\2ZZzz\5\2\13\f\16\17\"\"\4\2\f\f\17\17"+
		"\4\2CCcc\4\2FFff\4\2GGgg\4\2\u00cb\u00cb\u00eb\u00eb\4\2HHhh\4\2IIii\4"+
		"\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRr"+
		"r\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2[[{{\4\2"+
		"\\\\||\4\2C\\c|\7\2//\62;C\\aac|\4\2\"#%&\4\2((*\u0080\4\2(ac\u0080\4"+
		"\2\u00a2\u0871\u08a2\1\5\2\u00a2\u00bc\u00be\u0871\u08a2\1\17\2$$\'\'"+
		")+>>@@CFHHJJLLNNPPSXbb\4\2--//\5\2\62;CHch\2\u0169\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\3o\3\2\2\2\5w\3\2\2\2\7|\3\2\2\2\t\u0088\3\2\2\2\13\u0093\3\2"+
		"\2\2\r\u0096\3\2\2\2\17\u009c\3\2\2\2\21\u00ac\3\2\2\2\23\u00ba\3\2\2"+
		"\2\25\u00bc\3\2\2\2\27\u00be\3\2\2\2\31\u00c0\3\2\2\2\33\u00c2\3\2\2\2"+
		"\35\u00c4\3\2\2\2\37\u00c6\3\2\2\2!\u00c8\3\2\2\2#\u00ca\3\2\2\2%\u00cc"+
		"\3\2\2\2\'\u00ce\3\2\2\2)\u00d0\3\2\2\2+\u00d2\3\2\2\2-\u00d4\3\2\2\2"+
		"/\u00d6\3\2\2\2\61\u00d8\3\2\2\2\63\u00da\3\2\2\2\65\u00dc\3\2\2\2\67"+
		"\u00de\3\2\2\29\u00e0\3\2\2\2;\u00e2\3\2\2\2=\u00e4\3\2\2\2?\u00e6\3\2"+
		"\2\2A\u00e8\3\2\2\2C\u00ea\3\2\2\2E\u00ec\3\2\2\2G\u00ee\3\2\2\2I\u00f0"+
		"\3\2\2\2K\u00f7\3\2\2\2M\u0104\3\2\2\2O\u0112\3\2\2\2Q\u0120\3\2\2\2S"+
		"\u012e\3\2\2\2U\u0130\3\2\2\2W\u0134\3\2\2\2Y\u0136\3\2\2\2[\u013a\3\2"+
		"\2\2]\u0140\3\2\2\2_\u0149\3\2\2\2a\u014b\3\2\2\2c\u0154\3\2\2\2e\u0156"+
		"\3\2\2\2g\u015f\3\2\2\2i\u0161\3\2\2\2k\u016a\3\2\2\2m\u016c\3\2\2\2o"+
		"p\5A!\2pq\5#\22\2qr\5\33\16\2rs\5\67\34\2st\5\33\16\2t\4\3\2\2\2ux\5I"+
		"%\2vx\5K&\2wu\3\2\2\2wv\3\2\2\2x\6\3\2\2\2y}\5M\'\2z}\5O(\2{}\5Q)\2|y"+
		"\3\2\2\2|z\3\2\2\2|{\3\2\2\2}\b\3\2\2\2~\u0089\5a\61\2\177\u0080\7\62"+
		"\2\2\u0080\u0081\t\2\2\2\u0081\u0089\5i\65\2\u0082\u0083\7\62\2\2\u0083"+
		"\u0084\t\3\2\2\u0084\u0089\5e\63\2\u0085\u0086\7\62\2\2\u0086\u0087\t"+
		"\4\2\2\u0087\u0089\5]/\2\u0088~\3\2\2\2\u0088\177\3\2\2\2\u0088\u0082"+
		"\3\2\2\2\u0088\u0085\3\2\2\2\u0089\n\3\2\2\2\u008a\u008b\5a\61\2\u008b"+
		"\u008c\7\60\2\2\u008c\u008e\5a\61\2\u008d\u008f\5[.\2\u008e\u008d\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0094\3\2\2\2\u0090\u0091\5a\61\2\u0091"+
		"\u0092\5[.\2\u0092\u0094\3\2\2\2\u0093\u008a\3\2\2\2\u0093\u0090\3\2\2"+
		"\2\u0094\f\3\2\2\2\u0095\u0097\t\5\2\2\u0096\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009b\b\7\2\2\u009b\16\3\2\2\2\u009c\u009d\7\61\2\2\u009d\u009e\7\61"+
		"\2\2\u009e\u00a2\3\2\2\2\u009f\u00a1\n\6\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\t\6\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ab\b\b\2\2\u00ab\20\3\2\2\2\u00ac\u00ad\7\61\2\2\u00ad\u00ae"+
		"\7,\2\2\u00ae\u00b2\3\2\2\2\u00af\u00b1\13\2\2\2\u00b0\u00af\3\2\2\2\u00b1"+
		"\u00b4\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7,\2\2\u00b6\u00b7\7\61\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00b9\b\t\2\2\u00b9\22\3\2\2\2\u00ba\u00bb\t\7\2"+
		"\2\u00bb\24\3\2\2\2\u00bc\u00bd\t\2\2\2\u00bd\26\3\2\2\2\u00be\u00bf\t"+
		"\3\2\2\u00bf\30\3\2\2\2\u00c0\u00c1\t\b\2\2\u00c1\32\3\2\2\2\u00c2\u00c3"+
		"\t\t\2\2\u00c3\34\3\2\2\2\u00c4\u00c5\t\n\2\2\u00c5\36\3\2\2\2\u00c6\u00c7"+
		"\t\13\2\2\u00c7 \3\2\2\2\u00c8\u00c9\t\f\2\2\u00c9\"\3\2\2\2\u00ca\u00cb"+
		"\t\r\2\2\u00cb$\3\2\2\2\u00cc\u00cd\t\16\2\2\u00cd&\3\2\2\2\u00ce\u00cf"+
		"\t\17\2\2\u00cf(\3\2\2\2\u00d0\u00d1\t\20\2\2\u00d1*\3\2\2\2\u00d2\u00d3"+
		"\t\21\2\2\u00d3,\3\2\2\2\u00d4\u00d5\t\22\2\2\u00d5.\3\2\2\2\u00d6\u00d7"+
		"\t\23\2\2\u00d7\60\3\2\2\2\u00d8\u00d9\t\24\2\2\u00d9\62\3\2\2\2\u00da"+
		"\u00db\t\25\2\2\u00db\64\3\2\2\2\u00dc\u00dd\t\26\2\2\u00dd\66\3\2\2\2"+
		"\u00de\u00df\t\27\2\2\u00df8\3\2\2\2\u00e0\u00e1\t\30\2\2\u00e1:\3\2\2"+
		"\2\u00e2\u00e3\t\31\2\2\u00e3<\3\2\2\2\u00e4\u00e5\t\32\2\2\u00e5>\3\2"+
		"\2\2\u00e6\u00e7\t\33\2\2\u00e7@\3\2\2\2\u00e8\u00e9\t\34\2\2\u00e9B\3"+
		"\2\2\2\u00ea\u00eb\t\4\2\2\u00ebD\3\2\2\2\u00ec\u00ed\t\35\2\2\u00edF"+
		"\3\2\2\2\u00ee\u00ef\t\36\2\2\u00efH\3\2\2\2\u00f0\u00f4\t\37\2\2\u00f1"+
		"\u00f3\t \2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2"+
		"\2\2\u00f4\u00f5\3\2\2\2\u00f5J\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00ff"+
		"\7$\2\2\u00f8\u00fe\t!\2\2\u00f9\u00fa\7\'\2\2\u00fa\u00fe\5W,\2\u00fb"+
		"\u00fe\4(\u0080\2\u00fc\u00fe\5S*\2\u00fd\u00f8\3\2\2\2\u00fd\u00f9\3"+
		"\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0102\3\2\2\2\u0101\u00ff\3\2"+
		"\2\2\u0102\u0103\7$\2\2\u0103L\3\2\2\2\u0104\u010d\7)\2\2\u0105\u010c"+
		"\4\"&\2\u0106\u0107\7\'\2\2\u0107\u010c\5W,\2\u0108\u010c\t\"\2\2\u0109"+
		"\u010c\5S*\2\u010a\u010c\7\f\2\2\u010b\u0105\3\2\2\2\u010b\u0106\3\2\2"+
		"\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0111\7)\2\2\u0111N\3\2\2\2\u0112\u011b\7b\2\2\u0113"+
		"\u011a\4\"&\2\u0114\u0115\7\'\2\2\u0115\u011a\5W,\2\u0116\u011a\t#\2\2"+
		"\u0117\u011a\5S*\2\u0118\u011a\7\f\2\2\u0119\u0113\3\2\2\2\u0119\u0114"+
		"\3\2\2\2\u0119\u0116\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a"+
		"\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2"+
		"\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7b\2\2\u011fP\3\2\2\2\u0120\u0129"+
		"\7\u00ad\2\2\u0121\u0128\4\"&\2\u0122\u0123\7\'\2\2\u0123\u0128\5W,\2"+
		"\u0124\u0128\4(\u0080\2\u0125\u0128\5U+\2\u0126\u0128\7\f\2\2\u0127\u0121"+
		"\3\2\2\2\u0127\u0122\3\2\2\2\u0127\u0124\3\2\2\2\u0127\u0125\3\2\2\2\u0127"+
		"\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2"+
		"\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7\u00bd\2\2\u012d"+
		"R\3\2\2\2\u012e\u012f\t$\2\2\u012fT\3\2\2\2\u0130\u0131\t%\2\2\u0131V"+
		"\3\2\2\2\u0132\u0135\t&\2\2\u0133\u0135\5Y-\2\u0134\u0132\3\2\2\2\u0134"+
		"\u0133\3\2\2\2\u0135X\3\2\2\2\u0136\u0137\7\61\2\2\u0137\u0138\5\t\5\2"+
		"\u0138\u0139\7\61\2\2\u0139Z\3\2\2\2\u013a\u013c\t\t\2\2\u013b\u013d\t"+
		"\'\2\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u013f\5a\61\2\u013f\\\3\2\2\2\u0140\u0146\5_\60\2\u0141\u0145\5_\60\2"+
		"\u0142\u0143\7a\2\2\u0143\u0145\5_\60\2\u0144\u0141\3\2\2\2\u0144\u0142"+
		"\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147"+
		"^\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\t(\2\2\u014a`\3\2\2\2\u014b"+
		"\u0151\5c\62\2\u014c\u0150\5c\62\2\u014d\u014e\7a\2\2\u014e\u0150\5c\62"+
		"\2\u014f\u014c\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f"+
		"\3\2\2\2\u0151\u0152\3\2\2\2\u0152b\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0155\4\62;\2\u0155d\3\2\2\2\u0156\u015c\5g\64\2\u0157\u015b\5g\64\2"+
		"\u0158\u0159\7a\2\2\u0159\u015b\5g\64\2\u015a\u0157\3\2\2\2\u015a\u0158"+
		"\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\4\629\2\u0160h\3\2\2\2\u0161"+
		"\u0167\5k\66\2\u0162\u0166\5k\66\2\u0163\u0164\7a\2\2\u0164\u0166\5k\66"+
		"\2\u0165\u0162\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165"+
		"\3\2\2\2\u0167\u0168\3\2\2\2\u0168j\3\2\2\2\u0169\u0167\3\2\2\2\u016a"+
		"\u016b\4\62\63\2\u016bl\3\2\2\2\u016c\u016d\t\37\2\2\u016dn\3\2\2\2\37"+
		"\2w|\u0088\u008e\u0093\u0098\u00a2\u00a8\u00b2\u00f4\u00fd\u00ff\u010b"+
		"\u010d\u0119\u011b\u0127\u0129\u0134\u013c\u0144\u0146\u014f\u0151\u015a"+
		"\u015c\u0165\u0167\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}