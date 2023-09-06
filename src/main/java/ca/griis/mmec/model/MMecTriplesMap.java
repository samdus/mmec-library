package ca.griis.mmec.model;

import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import it.unibz.inf.ontop.spec.mapping.pp.impl.R2RMLSQLPPtriplesMap;

import java.util.ArrayList;
import java.util.List;

public class MMecTriplesMap extends R2RMLSQLPPtriplesMap {
    private final List<SQLPPTriplesMap> subSetList = new ArrayList<>();

    public MMecTriplesMap(SQLPPTriplesMap sqlppTriplesMap) {
        super(sqlppTriplesMap.getId(), sqlppTriplesMap.getSourceQuery(), sqlppTriplesMap.getTargetAtoms());
    }

    public List<SQLPPTriplesMap> getSubsetList() {
        return subSetList;
    }

    public void addSubset(SQLPPTriplesMap subset) {
        subSetList.add(subset);
    }
}
