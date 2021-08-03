// Generated from /Users/duss2503/Documents/Projets/arot/hephaistos/mMEC/src/main/antlr/ca/griis/relrellang/mDiscipulus.g4 by ANTLR 4.9.1

//package ca.griis.lex;
/**
 * Le lexique.
 *
 * @version 0.1.0 2018-04-08 
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mDiscipulusParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mDiscipulusVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mDiscipulusParser#rel_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_expression(mDiscipulusParser.Rel_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mDiscipulusParser#boolean_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_expression(mDiscipulusParser.Boolean_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mDiscipulusParser#schema_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema_name(mDiscipulusParser.Schema_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link mDiscipulusParser#rel_var_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel_var_name(mDiscipulusParser.Rel_var_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link mDiscipulusParser#attribute_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute_name(mDiscipulusParser.Attribute_nameContext ctx);
}