// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysAnnotation;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysDecoratorContent;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysVisitor;

public class TelosysAnnotationImpl extends ASTWrapperPsiElement implements TelosysAnnotation {

  public TelosysAnnotationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TelosysVisitor visitor) {
    visitor.visitAnnotation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TelosysVisitor) accept((TelosysVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public TelosysDecoratorContent getDecoratorContent() {
    return findChildByClass(TelosysDecoratorContent.class);
  }

}
