package solutions.sulfura.telosysintellijplugin.lang;

import com.intellij.lang.Language;

public class TelosysDsl extends Language {

    public static final TelosysDsl INSTANCE = new TelosysDsl();

    protected TelosysDsl() {
        super("TelosysDsl");
    }

}
