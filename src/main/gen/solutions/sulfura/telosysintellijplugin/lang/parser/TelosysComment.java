// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface TelosysComment extends PsiElement {

  @Nullable
  TelosysBlockComment getBlockComment();

  @Nullable
  TelosysLineComment getLineComment();

}