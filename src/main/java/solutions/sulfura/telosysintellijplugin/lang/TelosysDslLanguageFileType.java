package solutions.sulfura.telosysintellijplugin.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class TelosysDslLanguageFileType extends LanguageFileType {

    Icon fileIcon = IconLoader.getIcon("/anyType.svg", TelosysDslLanguageFileType.class);

    public static final TelosysDslLanguageFileType INSTANCE = new TelosysDslLanguageFileType();

    public TelosysDslLanguageFileType() {
        super(TelosysDsl.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Telosys Dsl";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Telosys dsl language file";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "entity";
    }

    @Override
    public Icon getIcon() {
        return fileIcon;
    }


}
