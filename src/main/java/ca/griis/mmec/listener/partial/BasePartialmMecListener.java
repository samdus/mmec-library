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
import ca.griis.mmec.jooq.gen.tables.pojos.Mmec;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Optional;
import java.util.Stack;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details
 * «Detailed description of the component (optional)»
 * @par Model
 * «Model (Abstract, automation, etc.) (optional)»
 * @par Conception
 * «Conception description (criteria and constraints) (optional)»
 * @par Limits
 * «Limits description (optional)»
 * @brief @~french Définit les fonctions de base d'un auditeur Dadagem.
 * @par Détails
 * S.O.
 * @par Modèle
 * S.O.
 * @par Conception
 * S.O.
 * @par Limites
 * S.O.
 * @par Historique
 * 2022-08-22 [CB] - Implémentation initiale<br>
 * @par Tâches
 * S.O.
 */
public abstract class BasePartialMMecListener implements mMecListener {
    @Getter
    @Accessors(fluent = true)
    private final Stack<Object> stack = new Stack<>();

    public Optional<Mmec> getMMec(){
        if (stack().empty() || !stack().peek().getClass().equals(Mmec.class))
        {
            return Optional.empty();
        }
        else {
            return Optional.of((Mmec) stack().peek());
        }
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
}
