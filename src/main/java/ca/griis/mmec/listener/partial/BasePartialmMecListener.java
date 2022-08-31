/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe BasePartialDadagemListener.
 * @brief @~english BasePartialDadagemListener class implementation.
 */

package ca.griis.mmec.listener.partial;

import ca.griis.mmec.antlr.gen.mMecListener;
import ca.griis.mmec.antlr.gen.mMecParser;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details
 *      «Detailed description of the component (optional)»
 * @par Model
 *      «Model (Abstract, automation, etc.) (optional)»
 * @par Conception
 *      «Conception description (criteria and constraints) (optional)»
 * @par Limits
 *      «Limits description (optional)»
 *
 * @brief @~french Définit les fonctions de base d'un auditeur Dadagem.
 * @par Détails
 *      S.O.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2022-08-22 [CB] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public abstract class BasePartialmMecListener implements mMecListener {
    @Getter
    @Accessors(fluent = true)
    private Stack<Object> stack = new Stack<>();

    //  @Getter @Setter private DadagemDocument dadagemDocument;
    @Override
    public void enterMMec_document(mMecParser.MMec_documentContext ctx) {

    }

    @Override
    public void exitMMec_document(mMecParser.MMec_documentContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void enterBase(mMecParser.BaseContext ctx) {

    }

    @Override
    public void exitBase(mMecParser.BaseContext ctx) {

    }

    @Override
    public void enterHeader(mMecParser.HeaderContext ctx) {

    }

    @Override
    public void exitHeader(mMecParser.HeaderContext ctx) {

    }

    @Override
    public void enterOntorel_ref(mMecParser.Ontorel_refContext ctx) {

    }

    @Override
    public void exitOntorel_ref(mMecParser.Ontorel_refContext ctx) {

    }

    @Override
    public void enterSource_ref(mMecParser.Source_refContext ctx) {

    }

    @Override
    public void exitSource_ref(mMecParser.Source_refContext ctx) {

    }

    @Override
    public void enterOntorel_ref_id(mMecParser.Ontorel_ref_idContext ctx) {

    }

    @Override
    public void exitOntorel_ref_id(mMecParser.Ontorel_ref_idContext ctx) {

    }

    @Override
    public void enterSource_ref_id(mMecParser.Source_ref_idContext ctx) {

    }

    @Override
    public void exitSource_ref_id(mMecParser.Source_ref_idContext ctx) {

    }

    @Override
    public void enterExclusions(mMecParser.ExclusionsContext ctx) {

    }

    @Override
    public void exitExclusions(mMecParser.ExclusionsContext ctx) {

    }

    @Override
    public void enterExclusion_expression(mMecParser.Exclusion_expressionContext ctx) {

    }

    @Override
    public void exitExclusion_expression(mMecParser.Exclusion_expressionContext ctx) {

    }

    @Override
    public void enterExclusion_element(mMecParser.Exclusion_elementContext ctx) {

    }

    @Override
    public void exitExclusion_element(mMecParser.Exclusion_elementContext ctx) {

    }

    @Override
    public void enterExclusion_source(mMecParser.Exclusion_sourceContext ctx) {

    }

    @Override
    public void exitExclusion_source(mMecParser.Exclusion_sourceContext ctx) {

    }

    @Override
    public void enterExclusion_ontorel(mMecParser.Exclusion_ontorelContext ctx) {

    }

    @Override
    public void exitExclusion_ontorel(mMecParser.Exclusion_ontorelContext ctx) {

    }

    @Override
    public void enterExclusion_semantic(mMecParser.Exclusion_semanticContext ctx) {

    }

    @Override
    public void exitExclusion_semantic(mMecParser.Exclusion_semanticContext ctx) {

    }

    @Override
    public void enterExclusion_message(mMecParser.Exclusion_messageContext ctx) {

    }

    @Override
    public void exitExclusion_message(mMecParser.Exclusion_messageContext ctx) {

    }

    @Override
    public void enterMapping(mMecParser.MappingContext ctx) {

    }

    @Override
    public void exitMapping(mMecParser.MappingContext ctx) {

    }

    @Override
    public void enterMapping_def(mMecParser.Mapping_defContext ctx) {

    }

    @Override
    public void exitMapping_def(mMecParser.Mapping_defContext ctx) {

    }

    @Override
    public void enterDefinition_id(mMecParser.Definition_idContext ctx) {

    }

    @Override
    public void exitDefinition_id(mMecParser.Definition_idContext ctx) {

    }

    @Override
    public void enterPrelude(mMecParser.PreludeContext ctx) {

    }

    @Override
    public void exitPrelude(mMecParser.PreludeContext ctx) {

    }

    @Override
    public void enterExpression(mMecParser.ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(mMecParser.ExpressionContext ctx) {

    }

    @Override
    public void enterDefinition_id_list(mMecParser.Definition_id_listContext ctx) {

    }

    @Override
    public void exitDefinition_id_list(mMecParser.Definition_id_listContext ctx) {

    }

    @Override
    public void enterString_expression(mMecParser.String_expressionContext ctx) {

    }

    @Override
    public void exitString_expression(mMecParser.String_expressionContext ctx) {

    }

    @Override
    public void enterString_expression_selection_list(mMecParser.String_expression_selection_listContext ctx) {

    }

    @Override
    public void exitString_expression_selection_list(mMecParser.String_expression_selection_listContext ctx) {

    }

    @Override
    public void enterString_expression_used_symbol_list(mMecParser.String_expression_used_symbol_listContext ctx) {

    }

    @Override
    public void exitString_expression_used_symbol_list(mMecParser.String_expression_used_symbol_listContext ctx) {

    }

    @Override
    public void enterString_expression_dependency_symbol_list(mMecParser.String_expression_dependency_symbol_listContext ctx) {

    }

    @Override
    public void exitString_expression_dependency_symbol_list(mMecParser.String_expression_dependency_symbol_listContext ctx) {

    }

    @Override
    public void enterModifiers(mMecParser.ModifiersContext ctx) {

    }

    @Override
    public void exitModifiers(mMecParser.ModifiersContext ctx) {

    }

    @Override
    public void enterMapping_modifier(mMecParser.Mapping_modifierContext ctx) {

    }

    @Override
    public void exitMapping_modifier(mMecParser.Mapping_modifierContext ctx) {

    }

    @Override
    public void enterModifier_function(mMecParser.Modifier_functionContext ctx) {

    }

    @Override
    public void exitModifier_function(mMecParser.Modifier_functionContext ctx) {

    }

    @Override
    public void enterShared(mMecParser.SharedContext ctx) {

    }

    @Override
    public void exitShared(mMecParser.SharedContext ctx) {

    }

    @Override
    public void enterShared_definition_id_list(mMecParser.Shared_definition_id_listContext ctx) {

    }

    @Override
    public void exitShared_definition_id_list(mMecParser.Shared_definition_id_listContext ctx) {

    }

    @Override
    public void enterShadow(mMecParser.ShadowContext ctx) {

    }

    @Override
    public void exitShadow(mMecParser.ShadowContext ctx) {

    }

    @Override
    public void enterShadower_definition_id(mMecParser.Shadower_definition_idContext ctx) {

    }

    @Override
    public void exitShadower_definition_id(mMecParser.Shadower_definition_idContext ctx) {

    }

    @Override
    public void enterShadowed_definition_id(mMecParser.Shadowed_definition_idContext ctx) {

    }

    @Override
    public void exitShadowed_definition_id(mMecParser.Shadowed_definition_idContext ctx) {

    }

    @Override
    public void enterMRel_relation_identifier(mMecParser.MRel_relation_identifierContext ctx) {

    }

    @Override
    public void exitMRel_relation_identifier(mMecParser.MRel_relation_identifierContext ctx) {

    }

    @Override
    public void enterDiscipulus_expression(mMecParser.Discipulus_expressionContext ctx) {

    }

    @Override
    public void exitDiscipulus_expression(mMecParser.Discipulus_expressionContext ctx) {

    }

    @Override
    public void enterDiscipulus_attribute_list(mMecParser.Discipulus_attribute_listContext ctx) {

    }

    @Override
    public void exitDiscipulus_attribute_list(mMecParser.Discipulus_attribute_listContext ctx) {

    }

    @Override
    public void enterDiscipulus_qualified_attribute_list(mMecParser.Discipulus_qualified_attribute_listContext ctx) {

    }

    @Override
    public void exitDiscipulus_qualified_attribute_list(mMecParser.Discipulus_qualified_attribute_listContext ctx) {

    }

    @Override
    public void enterRel_query(mMecParser.Rel_queryContext ctx) {

    }

    @Override
    public void exitRel_query(mMecParser.Rel_queryContext ctx) {

    }

    @Override
    public void enterFrom_term(mMecParser.From_termContext ctx) {

    }

    @Override
    public void exitFrom_term(mMecParser.From_termContext ctx) {

    }

    @Override
    public void enterJoin_list(mMecParser.Join_listContext ctx) {

    }

    @Override
    public void exitJoin_list(mMecParser.Join_listContext ctx) {

    }

    @Override
    public void enterJoin_term(mMecParser.Join_termContext ctx) {

    }

    @Override
    public void exitJoin_term(mMecParser.Join_termContext ctx) {

    }

    @Override
    public void enterInner_join_term(mMecParser.Inner_join_termContext ctx) {

    }

    @Override
    public void exitInner_join_term(mMecParser.Inner_join_termContext ctx) {

    }

    @Override
    public void enterNatural_join_term(mMecParser.Natural_join_termContext ctx) {

    }

    @Override
    public void exitNatural_join_term(mMecParser.Natural_join_termContext ctx) {

    }

    @Override
    public void enterLeft_join_term(mMecParser.Left_join_termContext ctx) {

    }

    @Override
    public void exitLeft_join_term(mMecParser.Left_join_termContext ctx) {

    }

    @Override
    public void enterRight_join_term(mMecParser.Right_join_termContext ctx) {

    }

    @Override
    public void exitRight_join_term(mMecParser.Right_join_termContext ctx) {

    }

    @Override
    public void enterJoin_clause(mMecParser.Join_clauseContext ctx) {

    }

    @Override
    public void exitJoin_clause(mMecParser.Join_clauseContext ctx) {

    }

    @Override
    public void enterJoin_using_clause(mMecParser.Join_using_clauseContext ctx) {

    }

    @Override
    public void exitJoin_using_clause(mMecParser.Join_using_clauseContext ctx) {

    }

    @Override
    public void enterJoin_on_clause(mMecParser.Join_on_clauseContext ctx) {

    }

    @Override
    public void exitJoin_on_clause(mMecParser.Join_on_clauseContext ctx) {

    }

    @Override
    public void enterSelect_term(mMecParser.Select_termContext ctx) {

    }

    @Override
    public void exitSelect_term(mMecParser.Select_termContext ctx) {

    }

    @Override
    public void enterWhere_term(mMecParser.Where_termContext ctx) {

    }

    @Override
    public void exitWhere_term(mMecParser.Where_termContext ctx) {

    }

    @Override
    public void enterRelation_specification(mMecParser.Relation_specificationContext ctx) {

    }

    @Override
    public void exitRelation_specification(mMecParser.Relation_specificationContext ctx) {

    }

    @Override
    public void enterRename_expression(mMecParser.Rename_expressionContext ctx) {

    }

    @Override
    public void exitRename_expression(mMecParser.Rename_expressionContext ctx) {

    }

    @Override
    public void enterPredicate(mMecParser.PredicateContext ctx) {

    }

    @Override
    public void exitPredicate(mMecParser.PredicateContext ctx) {

    }

    @Override
    public void enterBoolean_parenthesis(mMecParser.Boolean_parenthesisContext ctx) {

    }

    @Override
    public void exitBoolean_parenthesis(mMecParser.Boolean_parenthesisContext ctx) {

    }

    @Override
    public void enterBoolean_expression_list(mMecParser.Boolean_expression_listContext ctx) {

    }

    @Override
    public void exitBoolean_expression_list(mMecParser.Boolean_expression_listContext ctx) {

    }

    @Override
    public void enterBoolean_expression(mMecParser.Boolean_expressionContext ctx) {

    }

    @Override
    public void exitBoolean_expression(mMecParser.Boolean_expressionContext ctx) {

    }

    @Override
    public void enterUnary_boolean_expression(mMecParser.Unary_boolean_expressionContext ctx) {

    }

    @Override
    public void exitUnary_boolean_expression(mMecParser.Unary_boolean_expressionContext ctx) {

    }

    @Override
    public void enterNary_boolean_expression(mMecParser.Nary_boolean_expressionContext ctx) {

    }

    @Override
    public void exitNary_boolean_expression(mMecParser.Nary_boolean_expressionContext ctx) {

    }

    @Override
    public void enterComposition_operator(mMecParser.Composition_operatorContext ctx) {

    }

    @Override
    public void exitComposition_operator(mMecParser.Composition_operatorContext ctx) {

    }

    @Override
    public void enterBoolean_operator(mMecParser.Boolean_operatorContext ctx) {

    }

    @Override
    public void exitBoolean_operator(mMecParser.Boolean_operatorContext ctx) {

    }

    @Override
    public void enterUnary_boolean_operator(mMecParser.Unary_boolean_operatorContext ctx) {

    }

    @Override
    public void exitUnary_boolean_operator(mMecParser.Unary_boolean_operatorContext ctx) {

    }

    @Override
    public void enterFunction_call(mMecParser.Function_callContext ctx) {

    }

    @Override
    public void exitFunction_call(mMecParser.Function_callContext ctx) {

    }

    @Override
    public void enterFunction_name(mMecParser.Function_nameContext ctx) {

    }

    @Override
    public void exitFunction_name(mMecParser.Function_nameContext ctx) {

    }

    @Override
    public void enterArgument_list(mMecParser.Argument_listContext ctx) {

    }

    @Override
    public void exitArgument_list(mMecParser.Argument_listContext ctx) {

    }

    @Override
    public void enterArgument(mMecParser.ArgumentContext ctx) {

    }

    @Override
    public void exitArgument(mMecParser.ArgumentContext ctx) {

    }

    @Override
    public void enterSchema_name(mMecParser.Schema_nameContext ctx) {

    }

    @Override
    public void exitSchema_name(mMecParser.Schema_nameContext ctx) {

    }

    @Override
    public void enterRelation_name(mMecParser.Relation_nameContext ctx) {

    }

    @Override
    public void exitRelation_name(mMecParser.Relation_nameContext ctx) {

    }

    @Override
    public void enterAttribute_name(mMecParser.Attribute_nameContext ctx) {

    }

    @Override
    public void exitAttribute_name(mMecParser.Attribute_nameContext ctx) {

    }

    @Override
    public void enterAttribute_list(mMecParser.Attribute_listContext ctx) {

    }

    @Override
    public void exitAttribute_list(mMecParser.Attribute_listContext ctx) {

    }

    @Override
    public void enterQualified_attribute_list(mMecParser.Qualified_attribute_listContext ctx) {

    }

    @Override
    public void exitQualified_attribute_list(mMecParser.Qualified_attribute_listContext ctx) {

    }

    @Override
    public void enterQualified_attribute_name(mMecParser.Qualified_attribute_nameContext ctx) {

    }

    @Override
    public void exitQualified_attribute_name(mMecParser.Qualified_attribute_nameContext ctx) {

    }

    @Override
    public void enterIdent_list(mMecParser.Ident_listContext ctx) {

    }

    @Override
    public void exitIdent_list(mMecParser.Ident_listContext ctx) {

    }

    @Override
    public void enterConst_argument(mMecParser.Const_argumentContext ctx) {

    }

    @Override
    public void exitConst_argument(mMecParser.Const_argumentContext ctx) {

    }

    @Override
    public void enterEntity_relation(mMecParser.Entity_relationContext ctx) {

    }

    @Override
    public void exitEntity_relation(mMecParser.Entity_relationContext ctx) {

    }

    @Override
    public void enterEntity_identifier(mMecParser.Entity_identifierContext ctx) {

    }

    @Override
    public void exitEntity_identifier(mMecParser.Entity_identifierContext ctx) {

    }

    @Override
    public void enterOntology_def(mMecParser.Ontology_defContext ctx) {

    }

    @Override
    public void exitOntology_def(mMecParser.Ontology_defContext ctx) {

    }

    @Override
    public void enterPrefix_def(mMecParser.Prefix_defContext ctx) {

    }

    @Override
    public void exitPrefix_def(mMecParser.Prefix_defContext ctx) {

    }

    @Override
    public void enterEntity_def(mMecParser.Entity_defContext ctx) {

    }

    @Override
    public void exitEntity_def(mMecParser.Entity_defContext ctx) {

    }

    @Override
    public void enterClass_def(mMecParser.Class_defContext ctx) {

    }

    @Override
    public void exitClass_def(mMecParser.Class_defContext ctx) {

    }

    @Override
    public void enterProperty_def(mMecParser.Property_defContext ctx) {

    }

    @Override
    public void exitProperty_def(mMecParser.Property_defContext ctx) {

    }

    @Override
    public void enterDataProperty_def(mMecParser.DataProperty_defContext ctx) {

    }

    @Override
    public void exitDataProperty_def(mMecParser.DataProperty_defContext ctx) {

    }

    @Override
    public void enterObjectProperty_def(mMecParser.ObjectProperty_defContext ctx) {

    }

    @Override
    public void exitObjectProperty_def(mMecParser.ObjectProperty_defContext ctx) {

    }

    @Override
    public void enterType_def(mMecParser.Type_defContext ctx) {

    }

    @Override
    public void exitType_def(mMecParser.Type_defContext ctx) {

    }

    @Override
    public void enterInheritance(mMecParser.InheritanceContext ctx) {

    }

    @Override
    public void exitInheritance(mMecParser.InheritanceContext ctx) {

    }

    @Override
    public void enterInverse_def(mMecParser.Inverse_defContext ctx) {

    }

    @Override
    public void exitInverse_def(mMecParser.Inverse_defContext ctx) {

    }

    @Override
    public void enterOntology_dec(mMecParser.Ontology_decContext ctx) {

    }

    @Override
    public void exitOntology_dec(mMecParser.Ontology_decContext ctx) {

    }

    @Override
    public void enterClass_dec(mMecParser.Class_decContext ctx) {

    }

    @Override
    public void exitClass_dec(mMecParser.Class_decContext ctx) {

    }

    @Override
    public void enterProperty_dec(mMecParser.Property_decContext ctx) {

    }

    @Override
    public void exitProperty_dec(mMecParser.Property_decContext ctx) {

    }

    @Override
    public void enterType_dec(mMecParser.Type_decContext ctx) {

    }

    @Override
    public void exitType_dec(mMecParser.Type_decContext ctx) {

    }

    @Override
    public void enterDeclaration(mMecParser.DeclarationContext ctx) {

    }

    @Override
    public void exitDeclaration(mMecParser.DeclarationContext ctx) {

    }

    @Override
    public void enterLabel(mMecParser.LabelContext ctx) {

    }

    @Override
    public void exitLabel(mMecParser.LabelContext ctx) {

    }

    @Override
    public void enterDescription(mMecParser.DescriptionContext ctx) {

    }

    @Override
    public void exitDescription(mMecParser.DescriptionContext ctx) {

    }

    @Override
    public void enterAnnotation(mMecParser.AnnotationContext ctx) {

    }

    @Override
    public void exitAnnotation(mMecParser.AnnotationContext ctx) {

    }

    @Override
    public void enterAxiom(mMecParser.AxiomContext ctx) {

    }

    @Override
    public void exitAxiom(mMecParser.AxiomContext ctx) {

    }

    @Override
    public void enterAssociation_exp(mMecParser.Association_expContext ctx) {

    }

    @Override
    public void exitAssociation_exp(mMecParser.Association_expContext ctx) {

    }

    @Override
    public void enterOntoClass(mMecParser.OntoClassContext ctx) {

    }

    @Override
    public void exitOntoClass(mMecParser.OntoClassContext ctx) {

    }

    @Override
    public void enterType(mMecParser.TypeContext ctx) {

    }

    @Override
    public void exitType(mMecParser.TypeContext ctx) {

    }

    @Override
    public void enterProperty(mMecParser.PropertyContext ctx) {

    }

    @Override
    public void exitProperty(mMecParser.PropertyContext ctx) {

    }

    @Override
    public void enterReference(mMecParser.ReferenceContext ctx) {

    }

    @Override
    public void exitReference(mMecParser.ReferenceContext ctx) {

    }

    @Override
    public void enterIri(mMecParser.IriContext ctx) {

    }

    @Override
    public void exitIri(mMecParser.IriContext ctx) {

    }

    @Override
    public void enterAlias(mMecParser.AliasContext ctx) {

    }

    @Override
    public void exitAlias(mMecParser.AliasContext ctx) {

    }

    @Override
    public void enterIri_local(mMecParser.Iri_localContext ctx) {

    }

    @Override
    public void exitIri_local(mMecParser.Iri_localContext ctx) {

    }

    @Override
    public void enterParticipation(mMecParser.ParticipationContext ctx) {

    }

    @Override
    public void exitParticipation(mMecParser.ParticipationContext ctx) {

    }

    @Override
    public void enterMin(mMecParser.MinContext ctx) {

    }

    @Override
    public void exitMin(mMecParser.MinContext ctx) {

    }

    @Override
    public void enterMax(mMecParser.MaxContext ctx) {

    }

    @Override
    public void exitMax(mMecParser.MaxContext ctx) {

    }
}
