package de.shashwat.xtext.homeauto.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.shashwat.xtext.homeauto.services.RuleDSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRuleDSLParser extends AbstractInternalContentAssistParser {
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

    	public void setGrammarAccess(RuleDSLGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalRuleDSL.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalRuleDSL.g:54:1: ( ruleModel EOF )
            // InternalRuleDSL.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalRuleDSL.g:62:1: ruleModel : ( ( rule__Model__DeclaractionsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:66:2: ( ( ( rule__Model__DeclaractionsAssignment )* ) )
            // InternalRuleDSL.g:67:2: ( ( rule__Model__DeclaractionsAssignment )* )
            {
            // InternalRuleDSL.g:67:2: ( ( rule__Model__DeclaractionsAssignment )* )
            // InternalRuleDSL.g:68:3: ( rule__Model__DeclaractionsAssignment )*
            {
             before(grammarAccess.getModelAccess().getDeclaractionsAssignment()); 
            // InternalRuleDSL.g:69:3: ( rule__Model__DeclaractionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRuleDSL.g:69:4: rule__Model__DeclaractionsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__DeclaractionsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getDeclaractionsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDeclaration"
    // InternalRuleDSL.g:78:1: entryRuleDeclaration : ruleDeclaration EOF ;
    public final void entryRuleDeclaration() throws RecognitionException {
        try {
            // InternalRuleDSL.g:79:1: ( ruleDeclaration EOF )
            // InternalRuleDSL.g:80:1: ruleDeclaration EOF
            {
             before(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalRuleDSL.g:87:1: ruleDeclaration : ( ( rule__Declaration__Alternatives ) ) ;
    public final void ruleDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:91:2: ( ( ( rule__Declaration__Alternatives ) ) )
            // InternalRuleDSL.g:92:2: ( ( rule__Declaration__Alternatives ) )
            {
            // InternalRuleDSL.g:92:2: ( ( rule__Declaration__Alternatives ) )
            // InternalRuleDSL.g:93:3: ( rule__Declaration__Alternatives )
            {
             before(grammarAccess.getDeclarationAccess().getAlternatives()); 
            // InternalRuleDSL.g:94:3: ( rule__Declaration__Alternatives )
            // InternalRuleDSL.g:94:4: rule__Declaration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDeclarationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleDevice"
    // InternalRuleDSL.g:103:1: entryRuleDevice : ruleDevice EOF ;
    public final void entryRuleDevice() throws RecognitionException {
        try {
            // InternalRuleDSL.g:104:1: ( ruleDevice EOF )
            // InternalRuleDSL.g:105:1: ruleDevice EOF
            {
             before(grammarAccess.getDeviceRule()); 
            pushFollow(FOLLOW_1);
            ruleDevice();

            state._fsp--;

             after(grammarAccess.getDeviceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDevice"


    // $ANTLR start "ruleDevice"
    // InternalRuleDSL.g:112:1: ruleDevice : ( ( rule__Device__Group__0 ) ) ;
    public final void ruleDevice() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:116:2: ( ( ( rule__Device__Group__0 ) ) )
            // InternalRuleDSL.g:117:2: ( ( rule__Device__Group__0 ) )
            {
            // InternalRuleDSL.g:117:2: ( ( rule__Device__Group__0 ) )
            // InternalRuleDSL.g:118:3: ( rule__Device__Group__0 )
            {
             before(grammarAccess.getDeviceAccess().getGroup()); 
            // InternalRuleDSL.g:119:3: ( rule__Device__Group__0 )
            // InternalRuleDSL.g:119:4: rule__Device__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Device__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeviceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDevice"


    // $ANTLR start "entryRuleState"
    // InternalRuleDSL.g:128:1: entryRuleState : ruleState EOF ;
    public final void entryRuleState() throws RecognitionException {
        try {
            // InternalRuleDSL.g:129:1: ( ruleState EOF )
            // InternalRuleDSL.g:130:1: ruleState EOF
            {
             before(grammarAccess.getStateRule()); 
            pushFollow(FOLLOW_1);
            ruleState();

            state._fsp--;

             after(grammarAccess.getStateRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalRuleDSL.g:137:1: ruleState : ( ( rule__State__NameAssignment ) ) ;
    public final void ruleState() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:141:2: ( ( ( rule__State__NameAssignment ) ) )
            // InternalRuleDSL.g:142:2: ( ( rule__State__NameAssignment ) )
            {
            // InternalRuleDSL.g:142:2: ( ( rule__State__NameAssignment ) )
            // InternalRuleDSL.g:143:3: ( rule__State__NameAssignment )
            {
             before(grammarAccess.getStateAccess().getNameAssignment()); 
            // InternalRuleDSL.g:144:3: ( rule__State__NameAssignment )
            // InternalRuleDSL.g:144:4: rule__State__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__State__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStateAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleRule"
    // InternalRuleDSL.g:153:1: entryRuleRule : ruleRule EOF ;
    public final void entryRuleRule() throws RecognitionException {
        try {
            // InternalRuleDSL.g:154:1: ( ruleRule EOF )
            // InternalRuleDSL.g:155:1: ruleRule EOF
            {
             before(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleRule();

            state._fsp--;

             after(grammarAccess.getRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalRuleDSL.g:162:1: ruleRule : ( ( rule__Rule__Group__0 ) ) ;
    public final void ruleRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:166:2: ( ( ( rule__Rule__Group__0 ) ) )
            // InternalRuleDSL.g:167:2: ( ( rule__Rule__Group__0 ) )
            {
            // InternalRuleDSL.g:167:2: ( ( rule__Rule__Group__0 ) )
            // InternalRuleDSL.g:168:3: ( rule__Rule__Group__0 )
            {
             before(grammarAccess.getRuleAccess().getGroup()); 
            // InternalRuleDSL.g:169:3: ( rule__Rule__Group__0 )
            // InternalRuleDSL.g:169:4: rule__Rule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalRuleDSL.g:178:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalRuleDSL.g:179:1: ( ruleQualifiedName EOF )
            // InternalRuleDSL.g:180:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalRuleDSL.g:187:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:191:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalRuleDSL.g:192:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalRuleDSL.g:192:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalRuleDSL.g:193:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalRuleDSL.g:194:3: ( rule__QualifiedName__Group__0 )
            // InternalRuleDSL.g:194:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "rule__Declaration__Alternatives"
    // InternalRuleDSL.g:202:1: rule__Declaration__Alternatives : ( ( ruleDevice ) | ( ruleRule ) );
    public final void rule__Declaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:206:1: ( ( ruleDevice ) | ( ruleRule ) )
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
                    // InternalRuleDSL.g:207:2: ( ruleDevice )
                    {
                    // InternalRuleDSL.g:207:2: ( ruleDevice )
                    // InternalRuleDSL.g:208:3: ruleDevice
                    {
                     before(grammarAccess.getDeclarationAccess().getDeviceParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleDevice();

                    state._fsp--;

                     after(grammarAccess.getDeclarationAccess().getDeviceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalRuleDSL.g:213:2: ( ruleRule )
                    {
                    // InternalRuleDSL.g:213:2: ( ruleRule )
                    // InternalRuleDSL.g:214:3: ruleRule
                    {
                     before(grammarAccess.getDeclarationAccess().getRuleParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRule();

                    state._fsp--;

                     after(grammarAccess.getDeclarationAccess().getRuleParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Alternatives"


    // $ANTLR start "rule__Device__Group__0"
    // InternalRuleDSL.g:223:1: rule__Device__Group__0 : rule__Device__Group__0__Impl rule__Device__Group__1 ;
    public final void rule__Device__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:227:1: ( rule__Device__Group__0__Impl rule__Device__Group__1 )
            // InternalRuleDSL.g:228:2: rule__Device__Group__0__Impl rule__Device__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Device__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Device__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__0"


    // $ANTLR start "rule__Device__Group__0__Impl"
    // InternalRuleDSL.g:235:1: rule__Device__Group__0__Impl : ( 'Device' ) ;
    public final void rule__Device__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:239:1: ( ( 'Device' ) )
            // InternalRuleDSL.g:240:1: ( 'Device' )
            {
            // InternalRuleDSL.g:240:1: ( 'Device' )
            // InternalRuleDSL.g:241:2: 'Device'
            {
             before(grammarAccess.getDeviceAccess().getDeviceKeyword_0()); 
            match(input,11,FOLLOW_2); 
             after(grammarAccess.getDeviceAccess().getDeviceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__0__Impl"


    // $ANTLR start "rule__Device__Group__1"
    // InternalRuleDSL.g:250:1: rule__Device__Group__1 : rule__Device__Group__1__Impl rule__Device__Group__2 ;
    public final void rule__Device__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:254:1: ( rule__Device__Group__1__Impl rule__Device__Group__2 )
            // InternalRuleDSL.g:255:2: rule__Device__Group__1__Impl rule__Device__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Device__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Device__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__1"


    // $ANTLR start "rule__Device__Group__1__Impl"
    // InternalRuleDSL.g:262:1: rule__Device__Group__1__Impl : ( ( rule__Device__NameAssignment_1 ) ) ;
    public final void rule__Device__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:266:1: ( ( ( rule__Device__NameAssignment_1 ) ) )
            // InternalRuleDSL.g:267:1: ( ( rule__Device__NameAssignment_1 ) )
            {
            // InternalRuleDSL.g:267:1: ( ( rule__Device__NameAssignment_1 ) )
            // InternalRuleDSL.g:268:2: ( rule__Device__NameAssignment_1 )
            {
             before(grammarAccess.getDeviceAccess().getNameAssignment_1()); 
            // InternalRuleDSL.g:269:2: ( rule__Device__NameAssignment_1 )
            // InternalRuleDSL.g:269:3: rule__Device__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Device__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDeviceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__1__Impl"


    // $ANTLR start "rule__Device__Group__2"
    // InternalRuleDSL.g:277:1: rule__Device__Group__2 : rule__Device__Group__2__Impl rule__Device__Group__3 ;
    public final void rule__Device__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:281:1: ( rule__Device__Group__2__Impl rule__Device__Group__3 )
            // InternalRuleDSL.g:282:2: rule__Device__Group__2__Impl rule__Device__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Device__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Device__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__2"


    // $ANTLR start "rule__Device__Group__2__Impl"
    // InternalRuleDSL.g:289:1: rule__Device__Group__2__Impl : ( 'can' ) ;
    public final void rule__Device__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:293:1: ( ( 'can' ) )
            // InternalRuleDSL.g:294:1: ( 'can' )
            {
            // InternalRuleDSL.g:294:1: ( 'can' )
            // InternalRuleDSL.g:295:2: 'can'
            {
             before(grammarAccess.getDeviceAccess().getCanKeyword_2()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getDeviceAccess().getCanKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__2__Impl"


    // $ANTLR start "rule__Device__Group__3"
    // InternalRuleDSL.g:304:1: rule__Device__Group__3 : rule__Device__Group__3__Impl rule__Device__Group__4 ;
    public final void rule__Device__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:308:1: ( rule__Device__Group__3__Impl rule__Device__Group__4 )
            // InternalRuleDSL.g:309:2: rule__Device__Group__3__Impl rule__Device__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Device__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Device__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__3"


    // $ANTLR start "rule__Device__Group__3__Impl"
    // InternalRuleDSL.g:316:1: rule__Device__Group__3__Impl : ( 'be' ) ;
    public final void rule__Device__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:320:1: ( ( 'be' ) )
            // InternalRuleDSL.g:321:1: ( 'be' )
            {
            // InternalRuleDSL.g:321:1: ( 'be' )
            // InternalRuleDSL.g:322:2: 'be'
            {
             before(grammarAccess.getDeviceAccess().getBeKeyword_3()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getDeviceAccess().getBeKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__3__Impl"


    // $ANTLR start "rule__Device__Group__4"
    // InternalRuleDSL.g:331:1: rule__Device__Group__4 : rule__Device__Group__4__Impl rule__Device__Group__5 ;
    public final void rule__Device__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:335:1: ( rule__Device__Group__4__Impl rule__Device__Group__5 )
            // InternalRuleDSL.g:336:2: rule__Device__Group__4__Impl rule__Device__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Device__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Device__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__4"


    // $ANTLR start "rule__Device__Group__4__Impl"
    // InternalRuleDSL.g:343:1: rule__Device__Group__4__Impl : ( ( rule__Device__StatesAssignment_4 ) ) ;
    public final void rule__Device__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:347:1: ( ( ( rule__Device__StatesAssignment_4 ) ) )
            // InternalRuleDSL.g:348:1: ( ( rule__Device__StatesAssignment_4 ) )
            {
            // InternalRuleDSL.g:348:1: ( ( rule__Device__StatesAssignment_4 ) )
            // InternalRuleDSL.g:349:2: ( rule__Device__StatesAssignment_4 )
            {
             before(grammarAccess.getDeviceAccess().getStatesAssignment_4()); 
            // InternalRuleDSL.g:350:2: ( rule__Device__StatesAssignment_4 )
            // InternalRuleDSL.g:350:3: rule__Device__StatesAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Device__StatesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getDeviceAccess().getStatesAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__4__Impl"


    // $ANTLR start "rule__Device__Group__5"
    // InternalRuleDSL.g:358:1: rule__Device__Group__5 : rule__Device__Group__5__Impl ;
    public final void rule__Device__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:362:1: ( rule__Device__Group__5__Impl )
            // InternalRuleDSL.g:363:2: rule__Device__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Device__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__5"


    // $ANTLR start "rule__Device__Group__5__Impl"
    // InternalRuleDSL.g:369:1: rule__Device__Group__5__Impl : ( ( rule__Device__Group_5__0 )* ) ;
    public final void rule__Device__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:373:1: ( ( ( rule__Device__Group_5__0 )* ) )
            // InternalRuleDSL.g:374:1: ( ( rule__Device__Group_5__0 )* )
            {
            // InternalRuleDSL.g:374:1: ( ( rule__Device__Group_5__0 )* )
            // InternalRuleDSL.g:375:2: ( rule__Device__Group_5__0 )*
            {
             before(grammarAccess.getDeviceAccess().getGroup_5()); 
            // InternalRuleDSL.g:376:2: ( rule__Device__Group_5__0 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==14) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalRuleDSL.g:376:3: rule__Device__Group_5__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Device__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getDeviceAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group__5__Impl"


    // $ANTLR start "rule__Device__Group_5__0"
    // InternalRuleDSL.g:385:1: rule__Device__Group_5__0 : rule__Device__Group_5__0__Impl rule__Device__Group_5__1 ;
    public final void rule__Device__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:389:1: ( rule__Device__Group_5__0__Impl rule__Device__Group_5__1 )
            // InternalRuleDSL.g:390:2: rule__Device__Group_5__0__Impl rule__Device__Group_5__1
            {
            pushFollow(FOLLOW_4);
            rule__Device__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Device__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group_5__0"


    // $ANTLR start "rule__Device__Group_5__0__Impl"
    // InternalRuleDSL.g:397:1: rule__Device__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Device__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:401:1: ( ( ',' ) )
            // InternalRuleDSL.g:402:1: ( ',' )
            {
            // InternalRuleDSL.g:402:1: ( ',' )
            // InternalRuleDSL.g:403:2: ','
            {
             before(grammarAccess.getDeviceAccess().getCommaKeyword_5_0()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getDeviceAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group_5__0__Impl"


    // $ANTLR start "rule__Device__Group_5__1"
    // InternalRuleDSL.g:412:1: rule__Device__Group_5__1 : rule__Device__Group_5__1__Impl ;
    public final void rule__Device__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:416:1: ( rule__Device__Group_5__1__Impl )
            // InternalRuleDSL.g:417:2: rule__Device__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Device__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group_5__1"


    // $ANTLR start "rule__Device__Group_5__1__Impl"
    // InternalRuleDSL.g:423:1: rule__Device__Group_5__1__Impl : ( ( rule__Device__StatesAssignment_5_1 ) ) ;
    public final void rule__Device__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:427:1: ( ( ( rule__Device__StatesAssignment_5_1 ) ) )
            // InternalRuleDSL.g:428:1: ( ( rule__Device__StatesAssignment_5_1 ) )
            {
            // InternalRuleDSL.g:428:1: ( ( rule__Device__StatesAssignment_5_1 ) )
            // InternalRuleDSL.g:429:2: ( rule__Device__StatesAssignment_5_1 )
            {
             before(grammarAccess.getDeviceAccess().getStatesAssignment_5_1()); 
            // InternalRuleDSL.g:430:2: ( rule__Device__StatesAssignment_5_1 )
            // InternalRuleDSL.g:430:3: rule__Device__StatesAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Device__StatesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getDeviceAccess().getStatesAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__Group_5__1__Impl"


    // $ANTLR start "rule__Rule__Group__0"
    // InternalRuleDSL.g:439:1: rule__Rule__Group__0 : rule__Rule__Group__0__Impl rule__Rule__Group__1 ;
    public final void rule__Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:443:1: ( rule__Rule__Group__0__Impl rule__Rule__Group__1 )
            // InternalRuleDSL.g:444:2: rule__Rule__Group__0__Impl rule__Rule__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Rule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__0"


    // $ANTLR start "rule__Rule__Group__0__Impl"
    // InternalRuleDSL.g:451:1: rule__Rule__Group__0__Impl : ( 'Rule' ) ;
    public final void rule__Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:455:1: ( ( 'Rule' ) )
            // InternalRuleDSL.g:456:1: ( 'Rule' )
            {
            // InternalRuleDSL.g:456:1: ( 'Rule' )
            // InternalRuleDSL.g:457:2: 'Rule'
            {
             before(grammarAccess.getRuleAccess().getRuleKeyword_0()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getRuleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__0__Impl"


    // $ANTLR start "rule__Rule__Group__1"
    // InternalRuleDSL.g:466:1: rule__Rule__Group__1 : rule__Rule__Group__1__Impl rule__Rule__Group__2 ;
    public final void rule__Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:470:1: ( rule__Rule__Group__1__Impl rule__Rule__Group__2 )
            // InternalRuleDSL.g:471:2: rule__Rule__Group__1__Impl rule__Rule__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Rule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__1"


    // $ANTLR start "rule__Rule__Group__1__Impl"
    // InternalRuleDSL.g:478:1: rule__Rule__Group__1__Impl : ( ( rule__Rule__DescriptionAssignment_1 ) ) ;
    public final void rule__Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:482:1: ( ( ( rule__Rule__DescriptionAssignment_1 ) ) )
            // InternalRuleDSL.g:483:1: ( ( rule__Rule__DescriptionAssignment_1 ) )
            {
            // InternalRuleDSL.g:483:1: ( ( rule__Rule__DescriptionAssignment_1 ) )
            // InternalRuleDSL.g:484:2: ( rule__Rule__DescriptionAssignment_1 )
            {
             before(grammarAccess.getRuleAccess().getDescriptionAssignment_1()); 
            // InternalRuleDSL.g:485:2: ( rule__Rule__DescriptionAssignment_1 )
            // InternalRuleDSL.g:485:3: rule__Rule__DescriptionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Rule__DescriptionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getDescriptionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__1__Impl"


    // $ANTLR start "rule__Rule__Group__2"
    // InternalRuleDSL.g:493:1: rule__Rule__Group__2 : rule__Rule__Group__2__Impl rule__Rule__Group__3 ;
    public final void rule__Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:497:1: ( rule__Rule__Group__2__Impl rule__Rule__Group__3 )
            // InternalRuleDSL.g:498:2: rule__Rule__Group__2__Impl rule__Rule__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Rule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__2"


    // $ANTLR start "rule__Rule__Group__2__Impl"
    // InternalRuleDSL.g:505:1: rule__Rule__Group__2__Impl : ( 'when' ) ;
    public final void rule__Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:509:1: ( ( 'when' ) )
            // InternalRuleDSL.g:510:1: ( 'when' )
            {
            // InternalRuleDSL.g:510:1: ( 'when' )
            // InternalRuleDSL.g:511:2: 'when'
            {
             before(grammarAccess.getRuleAccess().getWhenKeyword_2()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getWhenKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__2__Impl"


    // $ANTLR start "rule__Rule__Group__3"
    // InternalRuleDSL.g:520:1: rule__Rule__Group__3 : rule__Rule__Group__3__Impl rule__Rule__Group__4 ;
    public final void rule__Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:524:1: ( rule__Rule__Group__3__Impl rule__Rule__Group__4 )
            // InternalRuleDSL.g:525:2: rule__Rule__Group__3__Impl rule__Rule__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__Rule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__3"


    // $ANTLR start "rule__Rule__Group__3__Impl"
    // InternalRuleDSL.g:532:1: rule__Rule__Group__3__Impl : ( ( rule__Rule__WhenAssignment_3 ) ) ;
    public final void rule__Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:536:1: ( ( ( rule__Rule__WhenAssignment_3 ) ) )
            // InternalRuleDSL.g:537:1: ( ( rule__Rule__WhenAssignment_3 ) )
            {
            // InternalRuleDSL.g:537:1: ( ( rule__Rule__WhenAssignment_3 ) )
            // InternalRuleDSL.g:538:2: ( rule__Rule__WhenAssignment_3 )
            {
             before(grammarAccess.getRuleAccess().getWhenAssignment_3()); 
            // InternalRuleDSL.g:539:2: ( rule__Rule__WhenAssignment_3 )
            // InternalRuleDSL.g:539:3: rule__Rule__WhenAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Rule__WhenAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getWhenAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__3__Impl"


    // $ANTLR start "rule__Rule__Group__4"
    // InternalRuleDSL.g:547:1: rule__Rule__Group__4 : rule__Rule__Group__4__Impl rule__Rule__Group__5 ;
    public final void rule__Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:551:1: ( rule__Rule__Group__4__Impl rule__Rule__Group__5 )
            // InternalRuleDSL.g:552:2: rule__Rule__Group__4__Impl rule__Rule__Group__5
            {
            pushFollow(FOLLOW_4);
            rule__Rule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__4"


    // $ANTLR start "rule__Rule__Group__4__Impl"
    // InternalRuleDSL.g:559:1: rule__Rule__Group__4__Impl : ( 'then' ) ;
    public final void rule__Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:563:1: ( ( 'then' ) )
            // InternalRuleDSL.g:564:1: ( 'then' )
            {
            // InternalRuleDSL.g:564:1: ( 'then' )
            // InternalRuleDSL.g:565:2: 'then'
            {
             before(grammarAccess.getRuleAccess().getThenKeyword_4()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getThenKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__4__Impl"


    // $ANTLR start "rule__Rule__Group__5"
    // InternalRuleDSL.g:574:1: rule__Rule__Group__5 : rule__Rule__Group__5__Impl ;
    public final void rule__Rule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:578:1: ( rule__Rule__Group__5__Impl )
            // InternalRuleDSL.g:579:2: rule__Rule__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__5"


    // $ANTLR start "rule__Rule__Group__5__Impl"
    // InternalRuleDSL.g:585:1: rule__Rule__Group__5__Impl : ( ( rule__Rule__ThenAssignment_5 ) ) ;
    public final void rule__Rule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:589:1: ( ( ( rule__Rule__ThenAssignment_5 ) ) )
            // InternalRuleDSL.g:590:1: ( ( rule__Rule__ThenAssignment_5 ) )
            {
            // InternalRuleDSL.g:590:1: ( ( rule__Rule__ThenAssignment_5 ) )
            // InternalRuleDSL.g:591:2: ( rule__Rule__ThenAssignment_5 )
            {
             before(grammarAccess.getRuleAccess().getThenAssignment_5()); 
            // InternalRuleDSL.g:592:2: ( rule__Rule__ThenAssignment_5 )
            // InternalRuleDSL.g:592:3: rule__Rule__ThenAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Rule__ThenAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getThenAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__5__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalRuleDSL.g:601:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:605:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalRuleDSL.g:606:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalRuleDSL.g:613:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:617:1: ( ( RULE_ID ) )
            // InternalRuleDSL.g:618:1: ( RULE_ID )
            {
            // InternalRuleDSL.g:618:1: ( RULE_ID )
            // InternalRuleDSL.g:619:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalRuleDSL.g:628:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:632:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalRuleDSL.g:633:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalRuleDSL.g:639:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:643:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalRuleDSL.g:644:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalRuleDSL.g:644:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalRuleDSL.g:645:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalRuleDSL.g:646:2: ( rule__QualifiedName__Group_1__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalRuleDSL.g:646:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalRuleDSL.g:655:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:659:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalRuleDSL.g:660:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalRuleDSL.g:667:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:671:1: ( ( '.' ) )
            // InternalRuleDSL.g:672:1: ( '.' )
            {
            // InternalRuleDSL.g:672:1: ( '.' )
            // InternalRuleDSL.g:673:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalRuleDSL.g:682:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:686:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalRuleDSL.g:687:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalRuleDSL.g:693:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:697:1: ( ( RULE_ID ) )
            // InternalRuleDSL.g:698:1: ( RULE_ID )
            {
            // InternalRuleDSL.g:698:1: ( RULE_ID )
            // InternalRuleDSL.g:699:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Model__DeclaractionsAssignment"
    // InternalRuleDSL.g:709:1: rule__Model__DeclaractionsAssignment : ( ruleDeclaration ) ;
    public final void rule__Model__DeclaractionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:713:1: ( ( ruleDeclaration ) )
            // InternalRuleDSL.g:714:2: ( ruleDeclaration )
            {
            // InternalRuleDSL.g:714:2: ( ruleDeclaration )
            // InternalRuleDSL.g:715:3: ruleDeclaration
            {
             before(grammarAccess.getModelAccess().getDeclaractionsDeclarationParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getModelAccess().getDeclaractionsDeclarationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__DeclaractionsAssignment"


    // $ANTLR start "rule__Device__NameAssignment_1"
    // InternalRuleDSL.g:724:1: rule__Device__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Device__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:728:1: ( ( RULE_ID ) )
            // InternalRuleDSL.g:729:2: ( RULE_ID )
            {
            // InternalRuleDSL.g:729:2: ( RULE_ID )
            // InternalRuleDSL.g:730:3: RULE_ID
            {
             before(grammarAccess.getDeviceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDeviceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__NameAssignment_1"


    // $ANTLR start "rule__Device__StatesAssignment_4"
    // InternalRuleDSL.g:739:1: rule__Device__StatesAssignment_4 : ( ruleState ) ;
    public final void rule__Device__StatesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:743:1: ( ( ruleState ) )
            // InternalRuleDSL.g:744:2: ( ruleState )
            {
            // InternalRuleDSL.g:744:2: ( ruleState )
            // InternalRuleDSL.g:745:3: ruleState
            {
             before(grammarAccess.getDeviceAccess().getStatesStateParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleState();

            state._fsp--;

             after(grammarAccess.getDeviceAccess().getStatesStateParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__StatesAssignment_4"


    // $ANTLR start "rule__Device__StatesAssignment_5_1"
    // InternalRuleDSL.g:754:1: rule__Device__StatesAssignment_5_1 : ( ruleState ) ;
    public final void rule__Device__StatesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:758:1: ( ( ruleState ) )
            // InternalRuleDSL.g:759:2: ( ruleState )
            {
            // InternalRuleDSL.g:759:2: ( ruleState )
            // InternalRuleDSL.g:760:3: ruleState
            {
             before(grammarAccess.getDeviceAccess().getStatesStateParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_2);
            ruleState();

            state._fsp--;

             after(grammarAccess.getDeviceAccess().getStatesStateParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Device__StatesAssignment_5_1"


    // $ANTLR start "rule__State__NameAssignment"
    // InternalRuleDSL.g:769:1: rule__State__NameAssignment : ( RULE_ID ) ;
    public final void rule__State__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:773:1: ( ( RULE_ID ) )
            // InternalRuleDSL.g:774:2: ( RULE_ID )
            {
            // InternalRuleDSL.g:774:2: ( RULE_ID )
            // InternalRuleDSL.g:775:3: RULE_ID
            {
             before(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getStateAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__State__NameAssignment"


    // $ANTLR start "rule__Rule__DescriptionAssignment_1"
    // InternalRuleDSL.g:784:1: rule__Rule__DescriptionAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Rule__DescriptionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:788:1: ( ( RULE_STRING ) )
            // InternalRuleDSL.g:789:2: ( RULE_STRING )
            {
            // InternalRuleDSL.g:789:2: ( RULE_STRING )
            // InternalRuleDSL.g:790:3: RULE_STRING
            {
             before(grammarAccess.getRuleAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getDescriptionSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__DescriptionAssignment_1"


    // $ANTLR start "rule__Rule__WhenAssignment_3"
    // InternalRuleDSL.g:799:1: rule__Rule__WhenAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Rule__WhenAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:803:1: ( ( ( ruleQualifiedName ) ) )
            // InternalRuleDSL.g:804:2: ( ( ruleQualifiedName ) )
            {
            // InternalRuleDSL.g:804:2: ( ( ruleQualifiedName ) )
            // InternalRuleDSL.g:805:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getRuleAccess().getWhenStateCrossReference_3_0()); 
            // InternalRuleDSL.g:806:3: ( ruleQualifiedName )
            // InternalRuleDSL.g:807:4: ruleQualifiedName
            {
             before(grammarAccess.getRuleAccess().getWhenStateQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getWhenStateQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getRuleAccess().getWhenStateCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__WhenAssignment_3"


    // $ANTLR start "rule__Rule__ThenAssignment_5"
    // InternalRuleDSL.g:818:1: rule__Rule__ThenAssignment_5 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Rule__ThenAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalRuleDSL.g:822:1: ( ( ( ruleQualifiedName ) ) )
            // InternalRuleDSL.g:823:2: ( ( ruleQualifiedName ) )
            {
            // InternalRuleDSL.g:823:2: ( ( ruleQualifiedName ) )
            // InternalRuleDSL.g:824:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getRuleAccess().getThenStateCrossReference_5_0()); 
            // InternalRuleDSL.g:825:3: ( ruleQualifiedName )
            // InternalRuleDSL.g:826:4: ruleQualifiedName
            {
             before(grammarAccess.getRuleAccess().getThenStateQualifiedNameParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getThenStateQualifiedNameParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getRuleAccess().getThenStateCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__ThenAssignment_5"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040002L});

}