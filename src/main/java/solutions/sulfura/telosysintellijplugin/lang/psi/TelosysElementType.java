package solutions.sulfura.telosysintellijplugin.lang.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import solutions.sulfura.telosysintellijplugin.lang.TelosysDsl;

public class TelosysElementType extends IElementType {

    public TelosysElementType(@NonNls @NotNull String debugName) {
        super(debugName, TelosysDsl.INSTANCE);
    }

}
