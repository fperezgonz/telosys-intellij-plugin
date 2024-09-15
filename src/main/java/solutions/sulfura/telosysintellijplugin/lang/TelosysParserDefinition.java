package solutions.sulfura.telosysintellijplugin.lang;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysParser;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysTypes;

import static solutions.sulfura.telosysintellijplugin.lang.parser.TelosysTypes.BLOCK_COMMENT;
import static solutions.sulfura.telosysintellijplugin.lang.parser.TelosysTypes.LINE_COMMENT;

public class TelosysParserDefinition implements ParserDefinition {

    static IFileElementType INSTANCE = new IFileElementType(TelosysDsl.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new TelosysLexerAdapter();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new TelosysParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return INSTANCE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return TokenSet.create(LINE_COMMENT, BLOCK_COMMENT);
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return TelosysTypes.Factory.createElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new TelosysFile(viewProvider);
    }
}
