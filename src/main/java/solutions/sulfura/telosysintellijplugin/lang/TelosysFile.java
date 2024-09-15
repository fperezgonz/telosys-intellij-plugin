package solutions.sulfura.telosysintellijplugin.lang;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class TelosysFile extends PsiFileBase {

    protected TelosysFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, TelosysDsl.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return TelosysDslLanguageFileType.INSTANCE;
    }

}
