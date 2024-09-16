// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysBlockComment;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysVisitor;

public class TelosysBlockCommentImpl extends ASTWrapperPsiElement implements TelosysBlockComment {

  public TelosysBlockCommentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TelosysVisitor visitor) {
    visitor.visitBlockComment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TelosysVisitor) accept((TelosysVisitor)visitor);
    else super.accept(visitor);
  }

}
