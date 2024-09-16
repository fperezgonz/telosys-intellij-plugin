// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysBlockComment;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysComment;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysLineComment;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysVisitor;

public class TelosysCommentImpl extends ASTWrapperPsiElement implements TelosysComment {

  public TelosysCommentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TelosysVisitor visitor) {
    visitor.visitComment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TelosysVisitor) accept((TelosysVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TelosysBlockComment getBlockComment() {
    return findChildByClass(TelosysBlockComment.class);
  }

  @Override
  @Nullable
  public TelosysLineComment getLineComment() {
    return findChildByClass(TelosysLineComment.class);
  }

}
