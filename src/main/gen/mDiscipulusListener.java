// Generated from /Users/duss2503/Documents/Projets/arot/hephaistos/mMEC/src/main/antlr/ca/griis/relrellang/mDiscipulus.g4 by ANTLR 4.9.1

//package ca.griis.lex;
/**
 * Le lexique.
 *
 * @version 0.1.0 2018-04-08 
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mDiscipulusParser}.
 */
public interface mDiscipulusListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mDiscipulusParser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void enterRel_expression(mDiscipulusParser.Rel_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mDiscipulusParser#rel_expression}.
	 * @param ctx the parse tree
	 */
	void exitRel_expression(mDiscipulusParser.Rel_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mDiscipulusParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_expression(mDiscipulusParser.Boolean_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mDiscipulusParser#boolean_expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_expression(mDiscipulusParser.Boolean_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mDiscipulusParser#schema_name}.
	 * @param ctx the parse tree
	 */
	void enterSchema_name(mDiscipulusParser.Schema_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mDiscipulusParser#schema_name}.
	 * @param ctx the parse tree
	 */
	void exitSchema_name(mDiscipulusParser.Schema_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link mDiscipulusParser#rel_var_name}.
	 * @param ctx the parse tree
	 */
	void enterRel_var_name(mDiscipulusParser.Rel_var_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mDiscipulusParser#rel_var_name}.
	 * @param ctx the parse tree
	 */
	void exitRel_var_name(mDiscipulusParser.Rel_var_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link mDiscipulusParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void enterAttribute_name(mDiscipulusParser.Attribute_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link mDiscipulusParser#attribute_name}.
	 * @param ctx the parse tree
	 */
	void exitAttribute_name(mDiscipulusParser.Attribute_nameContext ctx);
}