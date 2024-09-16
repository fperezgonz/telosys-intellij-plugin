// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysAttribute;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysDecorator;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysVisitor;

import java.util.List;

public class TelosysAttributeImpl extends ASTWrapperPsiElement implements TelosysAttribute {

  public TelosysAttributeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TelosysVisitor visitor) {
    visitor.visitAttribute(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TelosysVisitor) accept((TelosysVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TelosysDecorator> getDecoratorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TelosysDecorator.class);
  }

}
