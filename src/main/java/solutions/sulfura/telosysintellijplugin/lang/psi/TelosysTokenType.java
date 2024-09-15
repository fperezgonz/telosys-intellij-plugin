package solutions.sulfura.telosysintellijplugin.lang.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import solutions.sulfura.telosysintellijplugin.lang.TelosysDsl;

public class TelosysTokenType extends IElementType {

    public TelosysTokenType(@NonNls @NotNull String debugName) {
        super(debugName, TelosysDsl.INSTANCE);
    }

    @Override
    public String toString() {
        return "TelosysTokenType." + super.toString();
    }
}
