// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface TelosysEntity extends PsiElement {

  @NotNull
  List<TelosysAttribute> getAttributeList();

  @NotNull
  List<TelosysComment> getCommentList();

}
