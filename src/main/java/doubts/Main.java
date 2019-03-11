package doubts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final Set<String> oRuleTypesThatOnlyCareAboutEntryCode = new HashSet ( Arrays.asList(new String[] {
            "Rule-Access-When","Rule-Declare-CaseMatch","Rule-Decision-AdaptiveModel" }));

    public static final String propertyInvalidationFilter;
    private static final Set<String> oRulePackagesThatOnlyCareAboutEntryCode = new HashSet<String>();


    static {
        StringBuilder sb = new StringBuilder();
        for (String val : oRuleTypesThatOnlyCareAboutEntryCode) {
            sb.append(",'").append(val).append("'");
        }
        propertyInvalidationFilter = sb.toString().substring(1);

        oRulePackagesThatOnlyCareAboutEntryCode.add("when"); // RULE-ACCESS-WHEN
        oRulePackagesThatOnlyCareAboutEntryCode.add("casematch"); // RULE-DECLARE-CASEMATCH
        oRulePackagesThatOnlyCareAboutEntryCode.add("constraints"); // RULE-DECLARE-CONSTRAINTS
        oRulePackagesThatOnlyCareAboutEntryCode.add("decisiontable"); // RULE-DECLARE-DECISIONTABLE
        oRulePackagesThatOnlyCareAboutEntryCode.add("decisiontree"); // RULE-DECLARE-DECISIONTREE
        oRulePackagesThatOnlyCareAboutEntryCode.add("expressions"); // RULE-DECLARE-EXPRESSIONS
        oRulePackagesThatOnlyCareAboutEntryCode.add("trigger"); // RULE-DECLARE-TRIGGER
        oRulePackagesThatOnlyCareAboutEntryCode.add("activity"); // RULE-OBJ-ACTIVITY
        oRulePackagesThatOnlyCareAboutEntryCode.add("flow"); // RULE-OBJ-FLOW
        oRulePackagesThatOnlyCareAboutEntryCode.add("mapvalue"); // RULE-OBJ-MAPVALUE
        oRulePackagesThatOnlyCareAboutEntryCode.add("model"); // RULE-OBJ-MODEL
        oRulePackagesThatOnlyCareAboutEntryCode.add("when"); // RULE-OBJ-WHEN
        oRulePackagesThatOnlyCareAboutEntryCode.add("xml"); // RULE-OBJ-XML


        System.out.println("Property invalidation will skip invalidation of the following types: " + oRulePackagesThatOnlyCareAboutEntryCode);

    }
    public static void main(String[] args) {

    }
}
