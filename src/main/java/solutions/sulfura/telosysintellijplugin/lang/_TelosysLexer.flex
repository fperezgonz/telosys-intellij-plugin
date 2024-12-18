package solutions.sulfura.telosysintellijplugin.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysTypes;import solutions.sulfura.telosysintellijplugin.lang.psi.TelosysElementType;import solutions.sulfura.telosysintellijplugin.lang.psi.TelosysTokenType;


import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static solutions.sulfura.telosysintellijplugin.lang.parser.TelosysTypes.*;

%%

%{
    ArrayList<Integer> stateStack = new ArrayList<>();

    public _TelosysLexer() {
      this((java.io.Reader)null);
    }

    public void pushCurrentState(){
        stateStack.add(yystate());
    }

    public Integer popState(){
        return stateStack.remove(stateStack.size()-1);
    }

    public void logText(){
        //System.out.println("State: " + yystate() + ", Matched Input: " + yytext());
    }
%}

%public
%class _TelosysLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL = \r|\n
WHITE_SPACE=\s+
ELEMENT_NAME=\w+
ATTRIBUTE_TYPE=(binary
                | boolean
                | byte
                | date
                | decimal
                | double
                | float
                | int
                | long
                | short
                | string
                | time
                | timestamp)
ANNOTATION_NAME=(Abstract
               | AggregateRoot
               | AutoIncremented
               | Cascade
               | Context
               | DbCatalog
               | DbComment
               | DbDefaultValue
               | DbName
               | DbSchema
               | DbSize
               | DbTable
               | DbTablespace
               | DbType
               | DbView
               | DefaultValue
               | Domain
               | Embedded
               | Extends
               | FetchTypeEager
               | FetchTypeLazy
               | FK
               | Future
               | GeneratedValue
               | Id
               | InitialValue
               | InMemoryRepository
               | InputType
               | Insertable
               | JoinEntity
               | Label
               | LinkByAttr
               | LinkByFK
               | LinkByJoinEntity
               | LongText
               | ManyToMany
               | MappedBy
               | Max
               | MaxLen
               | Min
               | MinLen
               | NotBlank
               | NotEmpty
               | NotNull
               | ObjectType
               | OneToOne
               | Optional
               | OrphanRemoval
               | Package
               | Past
               | Pattern
               | PrimitiveType
               | ReadOnly
               | Size
               | SizeMax
               | SizeMin
               | Transient
               | Unique
               | UnsignedType
               | Updatable)
%state ANNOTATION
%state TAG
%state DECORATOR_CONTENT
%state LINE_COMMENT
%state BLOCK_COMMENT
%state ENTITY
%state ENTITY_BODY
%state ATTRIBUTE
%state ATTRIBUTE_METADATA
%state POST_DECORATOR_NAME


%%

<YYINITIAL> {

    {WHITE_SPACE}         { logText(); return IGNORED; }
    {ELEMENT_NAME}        { logText(); pushCurrentState(); yybegin(ENTITY); return ENTITY_NAME; }

}

<YYINITIAL, ATTRIBUTE_METADATA, POST_DECORATOR_NAME> {
    "@"                   { logText(); pushCurrentState(); yybegin(ANNOTATION); return AT; }
    "#"                   { logText(); pushCurrentState(); yybegin(TAG); return SHARP; }
}

<YYINITIAL, ANNOTATION, TAG, DECORATOR_CONTENT, LINE_COMMENT,
BLOCK_COMMENT, ENTITY, ENTITY_BODY, ATTRIBUTE, ATTRIBUTE_METADATA> {
    "//"                  { logText(); pushCurrentState(); yybegin(LINE_COMMENT); return new TelosysElementType("//"); }
    "/\*"                 { logText(); pushCurrentState(); yybegin(BLOCK_COMMENT); return new TelosysElementType("/*"); }
}

<ENTITY> {

    {WHITE_SPACE}         { logText(); return IGNORED; }
    "{"                   { logText(); yybegin(ENTITY_BODY); return new TelosysElementType("{"); }

    <ENTITY_BODY> {

        {ELEMENT_NAME}        { logText(); pushCurrentState(); yybegin(ATTRIBUTE); return ATTRIBUTE_NAME; }
        {WHITE_SPACE}         { logText(); return IGNORED; }
        "}"                   { logText(); yybegin(popState()); return new TelosysElementType("}"); }

        <ATTRIBUTE> {

            {WHITE_SPACE}        { logText(); return IGNORED; }
            ":"                  { logText(); yybegin(ATTRIBUTE_METADATA); return new TelosysElementType(":");}

            <ATTRIBUTE_METADATA> {

                {WHITE_SPACE}        { logText(); return IGNORED; }
                {ATTRIBUTE_TYPE}     { logText(); return TelosysTypes.ATTRIBUTE_TYPE; }
                \w+(\[\])?           { logText(); return TelosysTypes.ENTITY_NAME; }
                "{"                  { return new TelosysTokenType("{"); }
                "}"                  { return new TelosysTokenType("}"); }
                ";"                  { logText(); yybegin(popState()); return new TelosysElementType(";");}

            }

        }

    }

}

<ANNOTATION> {
    {ANNOTATION_NAME}          { logText(); yybegin(POST_DECORATOR_NAME); return ANNOTATION_NAME; }
}

<TAG> {
    {ELEMENT_NAME}          { logText(); yybegin(POST_DECORATOR_NAME); return TAG_NAME; }
}

<POST_DECORATOR_NAME> {
    {WHITE_SPACE}           { logText(); return IGNORED; }
    "("                     { logText(); yybegin(DECORATOR_CONTENT); return new TelosysElementType("("); }
    \w|}                    { logText(); yybegin(popState()); yypushback(1); }
}

<DECORATOR_CONTENT> {
    {WHITE_SPACE}           { logText(); return IGNORED; }
    \d+                     { logText(); return NUMBER; }
    ("true"|"false")        { logText(); return BOOLEAN; }
    (\w+|\.)+               { logText(); return NAME; }
    (\".*\")                { logText(); return STRING; }
    ","                     { logText(); return new TelosysElementType(","); }
    ")"                     { logText(); yybegin(popState()); return new TelosysElementType(")"); }
}

<LINE_COMMENT> {
    [^\r\n]+                 { logText(); return COMMENT_TEXT; }
    {EOL}                    { logText(); yybegin(popState()); return EOL; }
}

<BLOCK_COMMENT> {
    [^\*/]+       { logText(); return COMMENT_TEXT; }
    "*/"          { logText(); yybegin(popState()); return new TelosysElementType("*/"); }
}

[^] { logText(); return BAD_CHARACTER; }
