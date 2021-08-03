// Generated from /Users/duss2503/Documents/Projets/arot/hephaistos/mMEC/src/main/antlr/ca/griis/relrellang/mDiscipulus.g4 by ANTLR 4.9.1

//package ca.griis.lex;
/**
 * Le lexique.
 *
 * @version 0.1.0 2018-04-08 
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mDiscipulusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, IDENT=2, STRING=3, INTEGER=4, FLOAT=5, ESPACES=6, COMMENTAIRE_LIGNE=7, 
		COMMENTAIRE_MULTI=8, WHERE=9;
	public static final int
		RULE_rel_expression = 0, RULE_boolean_expression = 1, RULE_schema_name = 2, 
		RULE_rel_var_name = 3, RULE_attribute_name = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"rel_expression", "boolean_expression", "schema_name", "rel_var_name", 
			"attribute_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "IDENT", "STRING", "INTEGER", "FLOAT", "ESPACES", "COMMENTAIRE_LIGNE", 
			"COMMENTAIRE_MULTI", "WHERE"
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

	@Override
	public String getGrammarFileName() { return "mDiscipulus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mDiscipulusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Rel_expressionContext extends ParserRuleContext {
		public Rel_var_nameContext rel_var_name() {
			return getRuleContext(Rel_var_nameContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(mDiscipulusParser.WHERE, 0); }
		public Boolean_expressionContext boolean_expression() {
			return getRuleContext(Boolean_expressionContext.class,0);
		}
		public Rel_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).enterRel_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).exitRel_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mDiscipulusVisitor ) return ((mDiscipulusVisitor<? extends T>)visitor).visitRel_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_expressionContext rel_expression() throws RecognitionException {
		Rel_expressionContext _localctx = new Rel_expressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rel_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			rel_var_name();
			setState(11);
			match(WHERE);
			setState(12);
			boolean_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_expressionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(mDiscipulusParser.STRING, 0); }
		public Boolean_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).enterBoolean_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).exitBoolean_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mDiscipulusVisitor ) return ((mDiscipulusVisitor<? extends T>)visitor).visitBoolean_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_expressionContext boolean_expression() throws RecognitionException {
		Boolean_expressionContext _localctx = new Boolean_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_boolean_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_nameContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(mDiscipulusParser.IDENT, 0); }
		public Schema_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).enterSchema_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).exitSchema_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mDiscipulusVisitor ) return ((mDiscipulusVisitor<? extends T>)visitor).visitSchema_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Schema_nameContext schema_name() throws RecognitionException {
		Schema_nameContext _localctx = new Schema_nameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_schema_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rel_var_nameContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(mDiscipulusParser.IDENT, 0); }
		public Schema_nameContext schema_name() {
			return getRuleContext(Schema_nameContext.class,0);
		}
		public Rel_var_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_var_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).enterRel_var_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).exitRel_var_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mDiscipulusVisitor ) return ((mDiscipulusVisitor<? extends T>)visitor).visitRel_var_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_var_nameContext rel_var_name() throws RecognitionException {
		Rel_var_nameContext _localctx = new Rel_var_nameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rel_var_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(18);
				schema_name();
				setState(19);
				match(T__0);
				}
				break;
			}
			setState(23);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attribute_nameContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(mDiscipulusParser.IDENT, 0); }
		public Rel_var_nameContext rel_var_name() {
			return getRuleContext(Rel_var_nameContext.class,0);
		}
		public Attribute_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).enterAttribute_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mDiscipulusListener ) ((mDiscipulusListener)listener).exitAttribute_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mDiscipulusVisitor ) return ((mDiscipulusVisitor<? extends T>)visitor).visitAttribute_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribute_nameContext attribute_name() throws RecognitionException {
		Attribute_nameContext _localctx = new Attribute_nameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attribute_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(25);
				rel_var_name();
				setState(26);
				match(T__0);
				}
				break;
			}
			setState(30);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13#\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5"+
		"\5\5\30\n\5\3\5\3\5\3\6\3\6\3\6\5\6\37\n\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n"+
		"\2\2\2\37\2\f\3\2\2\2\4\20\3\2\2\2\6\22\3\2\2\2\b\27\3\2\2\2\n\36\3\2"+
		"\2\2\f\r\5\b\5\2\r\16\7\13\2\2\16\17\5\4\3\2\17\3\3\2\2\2\20\21\7\5\2"+
		"\2\21\5\3\2\2\2\22\23\7\4\2\2\23\7\3\2\2\2\24\25\5\6\4\2\25\26\7\3\2\2"+
		"\26\30\3\2\2\2\27\24\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\32\7\4\2\2"+
		"\32\t\3\2\2\2\33\34\5\b\5\2\34\35\7\3\2\2\35\37\3\2\2\2\36\33\3\2\2\2"+
		"\36\37\3\2\2\2\37 \3\2\2\2 !\7\4\2\2!\13\3\2\2\2\4\27\36";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}