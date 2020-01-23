package de.shashwat.xtext.homeauto.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.shashwat.xtext.homeauto.services.RuleDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRuleDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Device'", "'can'", "'be'", "','", "'Rule'", "'when'", "'then'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=6;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalRuleDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRuleDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRuleDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRuleDSL.g"; }



     	private RuleDSLGrammarAccess grammarAccess;

        public InternalRuleDSLParser(TokenStream input, RuleDSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected RuleDSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalRuleDSL.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalRuleDSL.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalRuleDSL.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalRuleDSL.g:71:1: ruleModel returns [EObject current=null] : ( (lv_declaractions_0_0= ruleDeclaration ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_declaractions_0_0 = null;



        	enterRule();

        try {
            // InternalRuleDSL.g:77:2: ( ( (lv_declaractions_0_0= ruleDeclaration ) )* )
            // InternalRuleDSL.g:78:2: ( (lv_declaractions_0_0= ruleDeclaration ) )*
            {
            // InternalRuleDSL.g:78:2: ( (lv_declaractions_0_0= ruleDeclaration ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRuleDSL.g:79:3: (lv_declaractions_0_0= ruleDeclaration )
            	    {
            	    // InternalRuleDSL.g:79:3: (lv_declaractions_0_0= ruleDeclaration )
            	    // InternalRuleDSL.g:80:4: lv_declaractions_0_0= ruleDeclaration
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getDeclaractionsDeclarationParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_declaractions_0_0=ruleDeclaration();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"declaractions",
            	    					lv_declaractions_0_0,
            	    					"de.shashwat.xtext.homeauto.RuleDSL.Declaration");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDeclaration"
    // InternalRuleDSL.g:100:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalRuleDSL.g:100:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalRuleDSL.g:101:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;

             current =iv_ruleDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalRuleDSL.g:107:1: ruleDeclaration returns [EObject current=null] : (this_Device_0= ruleDevice | this_Rule_1= ruleRule ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_Device_0 = null;

        EObject this_Rule_1 = null;



        	enterRule();

        try {
            // InternalRuleDSL.g:113:2: ( (this_Device_0= ruleDevice | this_Rule_1= ruleRule ) )
            // InternalRuleDSL.g:114:2: (this_Device_0= ruleDevice | this_Rule_1= ruleRule )
            {
            // InternalRuleDSL.g:114:2: (this_Device_0= ruleDevice | this_Rule_1= ruleRule )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalRuleDSL.g:115:3: this_Device_0= ruleDevice
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getDeviceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Device_0=ruleDevice();

                    state._fsp--;


                    			current = this_Device_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRuleDSL.g:124:3: this_Rule_1= ruleRule
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Rule_1=ruleRule();

                    state._fsp--;


                    			current = this_Rule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleDevice"
    // InternalRuleDSL.g:136:1: entryRuleDevice returns [EObject current=null] : iv_ruleDevice= ruleDevice EOF ;
    public final EObject entryRuleDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevice = null;


        try {
            // InternalRuleDSL.g:136:47: (iv_ruleDevice= ruleDevice EOF )
            // InternalRuleDSL.g:137:2: iv_ruleDevice= ruleDevice EOF
            {
             newCompositeNode(grammarAccess.getDeviceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDevice=ruleDevice();

            state._fsp--;

             current =iv_ruleDevice; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDevice"


    // $ANTLR start "ruleDevice"
    // InternalRuleDSL.g:143:1: ruleDevice returns [EObject current=null] : (otherlv_0= 'Device' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'can' otherlv_3= 'be' ( (lv_states_4_0= ruleState ) ) (otherlv_5= ',' ( (lv_states_6_0= ruleState ) ) )* ) ;
    public final EObject ruleDevice() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_states_4_0 = null;

        EObject lv_states_6_0 = null;



        	enterRule();

        try {
            // InternalRuleDSL.g:149:2: ( (otherlv_0= 'Device' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'can' otherlv_3= 'be' ( (lv_states_4_0= ruleState ) ) (otherlv_5= ',' ( (lv_states_6_0= ruleState ) ) )* ) )
            // InternalRuleDSL.g:150:2: (otherlv_0= 'Device' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'can' otherlv_3= 'be' ( (lv_states_4_0= ruleState ) ) (otherlv_5= ',' ( (lv_states_6_0= ruleState ) ) )* )
            {
            // InternalRuleDSL.g:150:2: (otherlv_0= 'Device' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'can' otherlv_3= 'be' ( (lv_states_4_0= ruleState ) ) (otherlv_5= ',' ( (lv_states_6_0= ruleState ) ) )* )
            // InternalRuleDSL.g:151:3: otherlv_0= 'Device' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'can' otherlv_3= 'be' ( (lv_states_4_0= ruleState ) ) (otherlv_5= ',' ( (lv_states_6_0= ruleState ) ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getDeviceAccess().getDeviceKeyword_0());
            		
            // InternalRuleDSL.g:155:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRuleDSL.g:156:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRuleDSL.g:156:4: (lv_name_1_0= RULE_ID )
            // InternalRuleDSL.g:157:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getDeviceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeviceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getDeviceAccess().getCanKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_3, grammarAccess.getDeviceAccess().getBeKeyword_3());
            		
            // InternalRuleDSL.g:181:3: ( (lv_states_4_0= ruleState ) )
            // InternalRuleDSL.g:182:4: (lv_states_4_0= ruleState )
            {
            // InternalRuleDSL.g:182:4: (lv_states_4_0= ruleState )
            // InternalRuleDSL.g:183:5: lv_states_4_0= ruleState
            {

            					newCompositeNode(grammarAccess.getDeviceAccess().getStatesStateParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_7);
            lv_states_4_0=ruleState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDeviceRule());
            					}
            					add(
            						current,
            						"states",
            						lv_states_4_0,
            						"de.shashwat.xtext.homeauto.RuleDSL.State");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRuleDSL.g:200:3: (otherlv_5= ',' ( (lv_states_6_0= ruleState ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRuleDSL.g:201:4: otherlv_5= ',' ( (lv_states_6_0= ruleState ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_4); 

            	    				newLeafNode(otherlv_5, grammarAccess.getDeviceAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalRuleDSL.g:205:4: ( (lv_states_6_0= ruleState ) )
            	    // InternalRuleDSL.g:206:5: (lv_states_6_0= ruleState )
            	    {
            	    // InternalRuleDSL.g:206:5: (lv_states_6_0= ruleState )
            	    // InternalRuleDSL.g:207:6: lv_states_6_0= ruleState
            	    {

            	    						newCompositeNode(grammarAccess.getDeviceAccess().getStatesStateParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_7);
            	    lv_states_6_0=ruleState();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getDeviceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"states",
            	    							lv_states_6_0,
            	    							"de.shashwat.xtext.homeauto.RuleDSL.State");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDevice"


    // $ANTLR start "entryRuleState"
    // InternalRuleDSL.g:229:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalRuleDSL.g:229:46: (iv_ruleState= ruleState EOF )
            // InternalRuleDSL.g:230:2: iv_ruleState= ruleState EOF
            {
             newCompositeNode(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;

             current =iv_ruleState; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalRuleDSL.g:236:1: ruleState returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalRuleDSL.g:242:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalRuleDSL.g:243:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalRuleDSL.g:243:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalRuleDSL.g:244:3: (lv_name_0_0= RULE_ID )
            {
            // InternalRuleDSL.g:244:3: (lv_name_0_0= RULE_ID )
            // InternalRuleDSL.g:245:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStateRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleRule"
    // InternalRuleDSL.g:264:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalRuleDSL.g:264:45: (iv_ruleRule= ruleRule EOF )
            // InternalRuleDSL.g:265:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalRuleDSL.g:271:1: ruleRule returns [EObject current=null] : (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'when' ( ( ruleQualifiedName ) ) otherlv_4= 'then' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalRuleDSL.g:277:2: ( (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'when' ( ( ruleQualifiedName ) ) otherlv_4= 'then' ( ( ruleQualifiedName ) ) ) )
            // InternalRuleDSL.g:278:2: (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'when' ( ( ruleQualifiedName ) ) otherlv_4= 'then' ( ( ruleQualifiedName ) ) )
            {
            // InternalRuleDSL.g:278:2: (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'when' ( ( ruleQualifiedName ) ) otherlv_4= 'then' ( ( ruleQualifiedName ) ) )
            // InternalRuleDSL.g:279:3: otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'when' ( ( ruleQualifiedName ) ) otherlv_4= 'then' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
            		
            // InternalRuleDSL.g:283:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalRuleDSL.g:284:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalRuleDSL.g:284:4: (lv_description_1_0= RULE_STRING )
            // InternalRuleDSL.g:285:5: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_description_1_0, grammarAccess.getRuleAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getWhenKeyword_2());
            		
            // InternalRuleDSL.g:305:3: ( ( ruleQualifiedName ) )
            // InternalRuleDSL.g:306:4: ( ruleQualifiedName )
            {
            // InternalRuleDSL.g:306:4: ( ruleQualifiedName )
            // InternalRuleDSL.g:307:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRuleAccess().getWhenStateCrossReference_3_0());
            				
            pushFollow(FOLLOW_10);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getThenKeyword_4());
            		
            // InternalRuleDSL.g:325:3: ( ( ruleQualifiedName ) )
            // InternalRuleDSL.g:326:4: ( ruleQualifiedName )
            {
            // InternalRuleDSL.g:326:4: ( ruleQualifiedName )
            // InternalRuleDSL.g:327:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            				

            					newCompositeNode(grammarAccess.getRuleAccess().getThenStateCrossReference_5_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalRuleDSL.g:345:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalRuleDSL.g:345:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalRuleDSL.g:346:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalRuleDSL.g:352:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalRuleDSL.g:358:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalRuleDSL.g:359:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalRuleDSL.g:359:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalRuleDSL.g:360:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_11); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalRuleDSL.g:367:3: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalRuleDSL.g:368:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,18,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_11); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040002L});

}