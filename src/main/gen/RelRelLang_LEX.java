// Generated from /Users/duss2503/Documents/Projets/arot/hephaistos/RelRelLang/src/main/antlr/ca/griis/relrellang/mRel_LEX.g4 by ANTLR 4.9.1

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
public class RelRelLang_LEX extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VERSION=1, ONTOREL=2, SOURCE=3, DIALECT=4, SIGNATURE=5, OBJECTPROPERTIES=6, 
		DATAPROPERTIES=7, SELECT=8, FROM=9, FROM_EXP=10, WHERE=11, NA=12, IDENT=13, 
		STRING=14, INTEGER=15, FLOAT=16, ESPACES=17, COMMENTAIRE_LIGNE=18, COMMENTAIRE_MULTI=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VERSION", "ONTOREL", "SOURCE", "DIALECT", "SIGNATURE", "OBJECTPROPERTIES", 
			"DATAPROPERTIES", "SELECT", "FROM", "FROM_EXP", "WHERE", "NA", "IDENT", 
			"STRING", "INTEGER", "FLOAT", "ESPACES", "COMMENTAIRE_LIGNE", "COMMENTAIRE_MULTI", 
			"A", "B", "C", "D", "E", "Eé", "F", "G", "H", "I", "J", "K", "L", "M", 
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "IDENT0", 
			"STRING0", "STRING1", "STRING2", "STRING3", "UNICODE_H0", "UNICODE_H1", 
			"ESC_SEQ", "UNICODE_ESC", "EXPONENT", "HEX_DIGITS", "HEX_DIGIT", "DEC_DIGITS", 
			"DEC_DIGIT", "OCT_DIGITS", "OCT_DIGIT", "BIN_DIGITS", "BIN_DIGIT"
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
			null, "VERSION", "ONTOREL", "SOURCE", "DIALECT", "SIGNATURE", "OBJECTPROPERTIES", 
			"DATAPROPERTIES", "SELECT", "FROM", "FROM_EXP", "WHERE", "NA", "IDENT", 
			"STRING", "INTEGER", "FLOAT", "ESPACES", "COMMENTAIRE_LIGNE", "COMMENTAIRE_MULTI"
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


	public RelRelLang_LEX(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "mRel_LEX.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u01eb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\3\2\5\2\u0085\n\2\3\2\3\2\3\2\7\2\u008a\n\2"+
		"\f\2\16\2\u008d\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\5\16\u00f7\n\16\3\17\3\17\3\17\5\17"+
		"\u00fc\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0108"+
		"\n\20\3\21\3\21\3\21\3\21\5\21\u010e\n\21\3\21\3\21\3\21\5\21\u0113\n"+
		"\21\3\22\6\22\u0116\n\22\r\22\16\22\u0117\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\7\23\u0120\n\23\f\23\16\23\u0123\13\23\3\23\6\23\u0126\n\23\r\23\16\23"+
		"\u0127\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u0130\n\24\f\24\16\24\u0133"+
		"\13\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\7\60\u0172\n\60\f\60\16\60\u0175"+
		"\13\60\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u017d\n\61\f\61\16\61\u0180"+
		"\13\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\7\62\u018b\n\62\f"+
		"\62\16\62\u018e\13\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\7\63"+
		"\u0199\n\63\f\63\16\63\u019c\13\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\7\64\u01a7\n\64\f\64\16\64\u01aa\13\64\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\5\67\u01b4\n\67\38\38\38\38\39\39\59\u01bc\n9\39"+
		"\39\3:\3:\3:\3:\7:\u01c4\n:\f:\16:\u01c7\13:\3;\3;\3<\3<\3<\3<\7<\u01cf"+
		"\n<\f<\16<\u01d2\13<\3=\3=\3>\3>\3>\3>\7>\u01da\n>\f>\16>\u01dd\13>\3"+
		"?\3?\3@\3@\3@\3@\7@\u01e5\n@\f@\16@\u01e8\13@\3A\3A\3\u0131\2B\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2"+
		"I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2o\2q\2s\2u\2"+
		"w\2y\2{\2}\2\177\2\u0081\2\3\2)\4\2DDdd\4\2EEee\4\2ZZzz\5\2\13\f\16\17"+
		"\"\"\4\2\f\f\17\17\4\2CCcc\4\2FFff\4\2GGgg\4\2\u00cb\u00cb\u00eb\u00eb"+
		"\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2P"+
		"Ppp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4"+
		"\2YYyy\4\2[[{{\4\2\\\\||\4\2C\\c|\7\2//\62;C\\aac|\4\2\"#%&\4\2((*\u0080"+
		"\4\2(ac\u0080\4\2\u00a2\u0871\u08a2\1\5\2\u00a2\u00bc\u00be\u0871\u08a2"+
		"\1\17\2$$\'\')+>>@@CFHHJJLLNNPPSXbb\4\2--//\5\2\62;CHch\2\u01e9\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\3\u0084\3\2\2\2\5\u008e\3\2\2\2\7\u0096\3\2\2\2"+
		"\t\u009d\3\2\2\2\13\u00a5\3\2\2\2\r\u00af\3\2\2\2\17\u00c0\3\2\2\2\21"+
		"\u00cf\3\2\2\2\23\u00d6\3\2\2\2\25\u00db\3\2\2\2\27\u00eb\3\2\2\2\31\u00f1"+
		"\3\2\2\2\33\u00f6\3\2\2\2\35\u00fb\3\2\2\2\37\u0107\3\2\2\2!\u0112\3\2"+
		"\2\2#\u0115\3\2\2\2%\u011b\3\2\2\2\'\u012b\3\2\2\2)\u0139\3\2\2\2+\u013b"+
		"\3\2\2\2-\u013d\3\2\2\2/\u013f\3\2\2\2\61\u0141\3\2\2\2\63\u0143\3\2\2"+
		"\2\65\u0145\3\2\2\2\67\u0147\3\2\2\29\u0149\3\2\2\2;\u014b\3\2\2\2=\u014d"+
		"\3\2\2\2?\u014f\3\2\2\2A\u0151\3\2\2\2C\u0153\3\2\2\2E\u0155\3\2\2\2G"+
		"\u0157\3\2\2\2I\u0159\3\2\2\2K\u015b\3\2\2\2M\u015d\3\2\2\2O\u015f\3\2"+
		"\2\2Q\u0161\3\2\2\2S\u0163\3\2\2\2U\u0165\3\2\2\2W\u0167\3\2\2\2Y\u0169"+
		"\3\2\2\2[\u016b\3\2\2\2]\u016d\3\2\2\2_\u016f\3\2\2\2a\u0176\3\2\2\2c"+
		"\u0183\3\2\2\2e\u0191\3\2\2\2g\u019f\3\2\2\2i\u01ad\3\2\2\2k\u01af\3\2"+
		"\2\2m\u01b3\3\2\2\2o\u01b5\3\2\2\2q\u01b9\3\2\2\2s\u01bf\3\2\2\2u\u01c8"+
		"\3\2\2\2w\u01ca\3\2\2\2y\u01d3\3\2\2\2{\u01d5\3\2\2\2}\u01de\3\2\2\2\177"+
		"\u01e0\3\2\2\2\u0081\u01e9\3\2\2\2\u0083\u0085\5U+\2\u0084\u0083\3\2\2"+
		"\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008b\5\37\20\2\u0087"+
		"\u0088\7\60\2\2\u0088\u008a\5\37\20\2\u0089\u0087\3\2\2\2\u008a\u008d"+
		"\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\4\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008e\u008f\5G$\2\u008f\u0090\5E#\2\u0090\u0091\5Q)\2\u0091"+
		"\u0092\5G$\2\u0092\u0093\5M\'\2\u0093\u0094\5\61\31\2\u0094\u0095\5A!"+
		"\2\u0095\6\3\2\2\2\u0096\u0097\5O(\2\u0097\u0098\5G$\2\u0098\u0099\5S"+
		"*\2\u0099\u009a\5M\'\2\u009a\u009b\5-\27\2\u009b\u009c\5\61\31\2\u009c"+
		"\b\3\2\2\2\u009d\u009e\5/\30\2\u009e\u009f\5;\36\2\u009f\u00a0\5)\25\2"+
		"\u00a0\u00a1\5A!\2\u00a1\u00a2\5\61\31\2\u00a2\u00a3\5-\27\2\u00a3\u00a4"+
		"\5Q)\2\u00a4\n\3\2\2\2\u00a5\u00a6\5O(\2\u00a6\u00a7\5;\36\2\u00a7\u00a8"+
		"\5\67\34\2\u00a8\u00a9\5E#\2\u00a9\u00aa\5)\25\2\u00aa\u00ab\5Q)\2\u00ab"+
		"\u00ac\5S*\2\u00ac\u00ad\5M\'\2\u00ad\u00ae\5\61\31\2\u00ae\f\3\2\2\2"+
		"\u00af\u00b0\5G$\2\u00b0\u00b1\5+\26\2\u00b1\u00b2\5=\37\2\u00b2\u00b3"+
		"\5\61\31\2\u00b3\u00b4\5-\27\2\u00b4\u00b5\5Q)\2\u00b5\u00b6\5I%\2\u00b6"+
		"\u00b7\5M\'\2\u00b7\u00b8\5G$\2\u00b8\u00b9\5I%\2\u00b9\u00ba\5\61\31"+
		"\2\u00ba\u00bb\5M\'\2\u00bb\u00bc\5Q)\2\u00bc\u00bd\5;\36\2\u00bd\u00be"+
		"\5\61\31\2\u00be\u00bf\5O(\2\u00bf\16\3\2\2\2\u00c0\u00c1\5/\30\2\u00c1"+
		"\u00c2\5)\25\2\u00c2\u00c3\5Q)\2\u00c3\u00c4\5)\25\2\u00c4\u00c5\5I%\2"+
		"\u00c5\u00c6\5M\'\2\u00c6\u00c7\5G$\2\u00c7\u00c8\5I%\2\u00c8\u00c9\5"+
		"\61\31\2\u00c9\u00ca\5M\'\2\u00ca\u00cb\5Q)\2\u00cb\u00cc\5;\36\2\u00cc"+
		"\u00cd\5\61\31\2\u00cd\u00ce\5O(\2\u00ce\20\3\2\2\2\u00cf\u00d0\5O(\2"+
		"\u00d0\u00d1\5\61\31\2\u00d1\u00d2\5A!\2\u00d2\u00d3\5\61\31\2\u00d3\u00d4"+
		"\5-\27\2\u00d4\u00d5\5Q)\2\u00d5\22\3\2\2\2\u00d6\u00d7\5\65\33\2\u00d7"+
		"\u00d8\5M\'\2\u00d8\u00d9\5G$\2\u00d9\u00da\5C\"\2\u00da\24\3\2\2\2\u00db"+
		"\u00dc\5\65\33\2\u00dc\u00dd\5M\'\2\u00dd\u00de\5G$\2\u00de\u00df\5C\""+
		"\2\u00df\u00e0\7\"\2\2\u00e0\u00e1\5\61\31\2\u00e1\u00e2\5Y-\2\u00e2\u00e3"+
		"\5I%\2\u00e3\u00e4\5M\'\2\u00e4\u00e5\5\61\31\2\u00e5\u00e6\5O(\2\u00e6"+
		"\u00e7\5O(\2\u00e7\u00e8\5;\36\2\u00e8\u00e9\5G$\2\u00e9\u00ea\5E#\2\u00ea"+
		"\26\3\2\2\2\u00eb\u00ec\5W,\2\u00ec\u00ed\59\35\2\u00ed\u00ee\5\61\31"+
		"\2\u00ee\u00ef\5M\'\2\u00ef\u00f0\5\61\31\2\u00f0\30\3\2\2\2\u00f1\u00f2"+
		"\5E#\2\u00f2\u00f3\5)\25\2\u00f3\32\3\2\2\2\u00f4\u00f7\5_\60\2\u00f5"+
		"\u00f7\5a\61\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7\34\3\2\2"+
		"\2\u00f8\u00fc\5c\62\2\u00f9\u00fc\5e\63\2\u00fa\u00fc\5g\64\2\u00fb\u00f8"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\36\3\2\2\2\u00fd"+
		"\u0108\5w<\2\u00fe\u00ff\7\62\2\2\u00ff\u0100\t\2\2\2\u0100\u0108\5\177"+
		"@\2\u0101\u0102\7\62\2\2\u0102\u0103\t\3\2\2\u0103\u0108\5{>\2\u0104\u0105"+
		"\7\62\2\2\u0105\u0106\t\4\2\2\u0106\u0108\5s:\2\u0107\u00fd\3\2\2\2\u0107"+
		"\u00fe\3\2\2\2\u0107\u0101\3\2\2\2\u0107\u0104\3\2\2\2\u0108 \3\2\2\2"+
		"\u0109\u010a\5w<\2\u010a\u010b\7\60\2\2\u010b\u010d\5w<\2\u010c\u010e"+
		"\5q9\2\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0113\3\2\2\2\u010f"+
		"\u0110\5w<\2\u0110\u0111\5q9\2\u0111\u0113\3\2\2\2\u0112\u0109\3\2\2\2"+
		"\u0112\u010f\3\2\2\2\u0113\"\3\2\2\2\u0114\u0116\t\5\2\2\u0115\u0114\3"+
		"\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"\u0119\3\2\2\2\u0119\u011a\b\22\2\2\u011a$\3\2\2\2\u011b\u011c\7\61\2"+
		"\2\u011c\u011d\7\61\2\2\u011d\u0121\3\2\2\2\u011e\u0120\n\6\2\2\u011f"+
		"\u011e\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0124\u0126\t\6\2\2\u0125"+
		"\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128\3\2"+
		"\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b\23\2\2\u012a&\3\2\2\2\u012b\u012c"+
		"\7\61\2\2\u012c\u012d\7,\2\2\u012d\u0131\3\2\2\2\u012e\u0130\13\2\2\2"+
		"\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u0132\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\7,\2\2\u0135"+
		"\u0136\7\61\2\2\u0136\u0137\3\2\2\2\u0137\u0138\b\24\2\2\u0138(\3\2\2"+
		"\2\u0139\u013a\t\7\2\2\u013a*\3\2\2\2\u013b\u013c\t\2\2\2\u013c,\3\2\2"+
		"\2\u013d\u013e\t\3\2\2\u013e.\3\2\2\2\u013f\u0140\t\b\2\2\u0140\60\3\2"+
		"\2\2\u0141\u0142\t\t\2\2\u0142\62\3\2\2\2\u0143\u0144\t\n\2\2\u0144\64"+
		"\3\2\2\2\u0145\u0146\t\13\2\2\u0146\66\3\2\2\2\u0147\u0148\t\f\2\2\u0148"+
		"8\3\2\2\2\u0149\u014a\t\r\2\2\u014a:\3\2\2\2\u014b\u014c\t\16\2\2\u014c"+
		"<\3\2\2\2\u014d\u014e\t\17\2\2\u014e>\3\2\2\2\u014f\u0150\t\20\2\2\u0150"+
		"@\3\2\2\2\u0151\u0152\t\21\2\2\u0152B\3\2\2\2\u0153\u0154\t\22\2\2\u0154"+
		"D\3\2\2\2\u0155\u0156\t\23\2\2\u0156F\3\2\2\2\u0157\u0158\t\24\2\2\u0158"+
		"H\3\2\2\2\u0159\u015a\t\25\2\2\u015aJ\3\2\2\2\u015b\u015c\t\26\2\2\u015c"+
		"L\3\2\2\2\u015d\u015e\t\27\2\2\u015eN\3\2\2\2\u015f\u0160\t\30\2\2\u0160"+
		"P\3\2\2\2\u0161\u0162\t\31\2\2\u0162R\3\2\2\2\u0163\u0164\t\32\2\2\u0164"+
		"T\3\2\2\2\u0165\u0166\t\33\2\2\u0166V\3\2\2\2\u0167\u0168\t\34\2\2\u0168"+
		"X\3\2\2\2\u0169\u016a\t\4\2\2\u016aZ\3\2\2\2\u016b\u016c\t\35\2\2\u016c"+
		"\\\3\2\2\2\u016d\u016e\t\36\2\2\u016e^\3\2\2\2\u016f\u0173\t\37\2\2\u0170"+
		"\u0172\t \2\2\u0171\u0170\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0173\u0174\3\2\2\2\u0174`\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u017e"+
		"\7$\2\2\u0177\u017d\t!\2\2\u0178\u0179\7\'\2\2\u0179\u017d\5m\67\2\u017a"+
		"\u017d\4(\u0080\2\u017b\u017d\5i\65\2\u017c\u0177\3\2\2\2\u017c\u0178"+
		"\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017d\u0180\3\2\2\2\u017e"+
		"\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180\u017e\3\2"+
		"\2\2\u0181\u0182\7$\2\2\u0182b\3\2\2\2\u0183\u018c\7)\2\2\u0184\u018b"+
		"\4\"&\2\u0185\u0186\7\'\2\2\u0186\u018b\5m\67\2\u0187\u018b\t\"\2\2\u0188"+
		"\u018b\5i\65\2\u0189\u018b\7\f\2\2\u018a\u0184\3\2\2\2\u018a\u0185\3\2"+
		"\2\2\u018a\u0187\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u0189\3\2\2\2\u018b"+
		"\u018e\3\2\2\2\u018c\u018a\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u018f\3\2"+
		"\2\2\u018e\u018c\3\2\2\2\u018f\u0190\7)\2\2\u0190d\3\2\2\2\u0191\u019a"+
		"\7b\2\2\u0192\u0199\4\"&\2\u0193\u0194\7\'\2\2\u0194\u0199\5m\67\2\u0195"+
		"\u0199\t#\2\2\u0196\u0199\5i\65\2\u0197\u0199\7\f\2\2\u0198\u0192\3\2"+
		"\2\2\u0198\u0193\3\2\2\2\u0198\u0195\3\2\2\2\u0198\u0196\3\2\2\2\u0198"+
		"\u0197\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2"+
		"\2\2\u019b\u019d\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\7b\2\2\u019e"+
		"f\3\2\2\2\u019f\u01a8\7\u00ad\2\2\u01a0\u01a7\4\"&\2\u01a1\u01a2\7\'\2"+
		"\2\u01a2\u01a7\5m\67\2\u01a3\u01a7\4(\u0080\2\u01a4\u01a7\5k\66\2\u01a5"+
		"\u01a7\7\f\2\2\u01a6\u01a0\3\2\2\2\u01a6\u01a1\3\2\2\2\u01a6\u01a3\3\2"+
		"\2\2\u01a6\u01a4\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7\u01aa\3\2\2\2\u01a8"+
		"\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a8\3\2"+
		"\2\2\u01ab\u01ac\7\u00bd\2\2\u01ach\3\2\2\2\u01ad\u01ae\t$\2\2\u01aej"+
		"\3\2\2\2\u01af\u01b0\t%\2\2\u01b0l\3\2\2\2\u01b1\u01b4\t&\2\2\u01b2\u01b4"+
		"\5o8\2\u01b3\u01b1\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4n\3\2\2\2\u01b5\u01b6"+
		"\7\61\2\2\u01b6\u01b7\5\37\20\2\u01b7\u01b8\7\61\2\2\u01b8p\3\2\2\2\u01b9"+
		"\u01bb\t\t\2\2\u01ba\u01bc\t\'\2\2\u01bb\u01ba\3\2\2\2\u01bb\u01bc\3\2"+
		"\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be\5w<\2\u01ber\3\2\2\2\u01bf\u01c5"+
		"\5u;\2\u01c0\u01c4\5u;\2\u01c1\u01c2\7a\2\2\u01c2\u01c4\5u;\2\u01c3\u01c0"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c7\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c5"+
		"\u01c6\3\2\2\2\u01c6t\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01c9\t(\2\2\u01c9"+
		"v\3\2\2\2\u01ca\u01d0\5y=\2\u01cb\u01cf\5y=\2\u01cc\u01cd\7a\2\2\u01cd"+
		"\u01cf\5y=\2\u01ce\u01cb\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d2\3\2\2"+
		"\2\u01d0\u01ce\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1x\3\2\2\2\u01d2\u01d0"+
		"\3\2\2\2\u01d3\u01d4\4\62;\2\u01d4z\3\2\2\2\u01d5\u01db\5}?\2\u01d6\u01da"+
		"\5}?\2\u01d7\u01d8\7a\2\2\u01d8\u01da\5}?\2\u01d9\u01d6\3\2\2\2\u01d9"+
		"\u01d7\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01d9\3\2\2\2\u01db\u01dc\3\2"+
		"\2\2\u01dc|\3\2\2\2\u01dd\u01db\3\2\2\2\u01de\u01df\4\629\2\u01df~\3\2"+
		"\2\2\u01e0\u01e6\5\u0081A\2\u01e1\u01e5\5\u0081A\2\u01e2\u01e3\7a\2\2"+
		"\u01e3\u01e5\5\u0081A\2\u01e4\u01e1\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5"+
		"\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u0080\3\2"+
		"\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ea\4\62\63\2\u01ea\u0082\3\2\2\2!\2"+
		"\u0084\u008b\u00f6\u00fb\u0107\u010d\u0112\u0117\u0121\u0127\u0131\u0173"+
		"\u017c\u017e\u018a\u018c\u0198\u019a\u01a6\u01a8\u01b3\u01bb\u01c3\u01c5"+
		"\u01ce\u01d0\u01d9\u01db\u01e4\u01e6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
