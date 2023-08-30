package ca.griis.mmec.listener.partial;

import ca.griis.mmec.antlr.gen.mMecListener;
import ca.griis.mmec.antlr.gen.mMecParser;
import ca.griis.mmec.jooq.gen.tables.pojos.Mmec;

public abstract class DocumentPartialMMecListener extends BasePartialMMecListener implements mMecListener {

    @Override
    public void enterMMec_document(mMecParser.MMec_documentContext ctx) {
        stack().push(Mmec.builder());
    }

    @Override
    public void exitMMec_document(mMecParser.MMec_documentContext ctx) {
        Mmec.MmecBuilder mmecBuilder = (Mmec.MmecBuilder) stack().pop();
        stack().push(mmecBuilder.build());
    }

    @Override
    public void enterBase(mMecParser.BaseContext ctx) {}

    @Override
    public void exitBase(mMecParser.BaseContext ctx) {}

    @Override
    public void enterHeader(mMecParser.HeaderContext ctx) {}

    @Override
    public void exitHeader(mMecParser.HeaderContext ctx) {}

    @Override
    public void enterOntorel_ref(mMecParser.Ontorel_refContext ctx) {

    }

    @Override
    public void exitOntorel_ref(mMecParser.Ontorel_refContext ctx) {}

    @Override
    public void enterSource_ref(mMecParser.Source_refContext ctx) {}

    @Override
    public void exitSource_ref(mMecParser.Source_refContext ctx) {}

    @Override
    public void enterOntorel_ref_id(mMecParser.Ontorel_ref_idContext ctx) {

    }

    @Override
    public void exitOntorel_ref_id(mMecParser.Ontorel_ref_idContext ctx) {
        Mmec.MmecBuilder mmecBuilder = (Mmec.MmecBuilder) stack().pop();
        mmecBuilder.ontorelRefId(ctx.STRING().getText());

        stack().push(mmecBuilder);
    }

    @Override
    public void enterSource_ref_id(mMecParser.Source_ref_idContext ctx) {}

    @Override
    public void exitSource_ref_id(mMecParser.Source_ref_idContext ctx) {
        Mmec.MmecBuilder mmecBuilder = (Mmec.MmecBuilder) stack().pop();
        mmecBuilder.sourceRefId(ctx.STRING().getText());

        stack().push(mmecBuilder);
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
}
