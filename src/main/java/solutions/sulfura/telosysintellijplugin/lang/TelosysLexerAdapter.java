package solutions.sulfura.telosysintellijplugin.lang;

import com.intellij.lexer.FlexAdapter;

public class TelosysLexerAdapter extends FlexAdapter {

    public TelosysLexerAdapter() {
        super(new _TelosysLexer(null));
    }

}
