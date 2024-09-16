package solutions.sulfura.telosysintellijplugin.lang.syntaxhighlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import solutions.sulfura.telosysintellijplugin.lang.TelosysLexerAdapter;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysTypes;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class TelosysDslSyntaxHighlighter implements SyntaxHighlighter {


    public static final TextAttributesKey ENTITY_NAME =
            createTextAttributesKey("ENTITY_NAME", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey ANNOTATION =
            createTextAttributesKey("ANNOTATION", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey TAG =
            createTextAttributesKey("TAG", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey DECORATOR_VALUE =
            createTextAttributesKey("DECORATOR_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey ATTRIBUTE_NAME =
            createTextAttributesKey("ATTRIBUTE_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey ATTRIBUTE_TYPE =
            createTextAttributesKey("ATTRIBUTE_TYPE", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("TELOSYS_DSL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] ENTITY_NAME_KEYS = new TextAttributesKey[]{ENTITY_NAME};
    private static final TextAttributesKey[] ANNOTATION_KEYS = new TextAttributesKey[]{ANNOTATION};
    private static final TextAttributesKey[] TAG_KEYS = new TextAttributesKey[]{TAG};
    private static final TextAttributesKey[] DECORATOR_VALUE_KEYS = new TextAttributesKey[]{DECORATOR_VALUE};
    private static final TextAttributesKey[] ATTRIBUTE_NAME_KEYS = new TextAttributesKey[]{ATTRIBUTE_NAME};
    private static final TextAttributesKey[] ATTRIBUTE_TYPE_KEYS = new TextAttributesKey[]{ATTRIBUTE_TYPE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] BAD_CHARACTER_KEYS = new TextAttributesKey[]{BAD_CHARACTER};

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new TelosysLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {

        if (tokenType.equals(TelosysTypes.ATTRIBUTE_NAME)) {
            return ATTRIBUTE_NAME_KEYS;
        }
        if (tokenType.equals(TelosysTypes.ENTITY_NAME)) {
            return ENTITY_NAME_KEYS;
        }
        if (tokenType.equals(TelosysTypes.ANNOTATION_NAME) || tokenType.equals(TelosysTypes.AT)) {
            return ANNOTATION_KEYS;
        }
        if (tokenType.equals(TelosysTypes.TAG_NAME) || tokenType.equals(TelosysTypes.SHARP)) {
            return TAG_KEYS;
        }
        if (tokenType.equals(TelosysTypes.DECORATOR_VALUE)) {
            return DECORATOR_VALUE_KEYS;
        }
        if (tokenType.equals(TelosysTypes.ATTRIBUTE_TYPE)) {
            return ATTRIBUTE_TYPE_KEYS;
        }
        if (tokenType.equals(TelosysTypes.COMMENT_TEXT)) {
            return COMMENT_KEYS;
        }

        return new TextAttributesKey[0];
    }
}
