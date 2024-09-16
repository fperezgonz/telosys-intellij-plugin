// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysDecoratorContent;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysDecoratorParameter;
import solutions.sulfura.telosysintellijplugin.lang.parser.TelosysVisitor;

import java.util.List;

public class TelosysDecoratorContentImpl extends ASTWrapperPsiElement implements TelosysDecoratorContent {

  public TelosysDecoratorContentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TelosysVisitor visitor) {
    visitor.visitDecoratorContent(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TelosysVisitor) accept((TelosysVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TelosysDecoratorParameter> getDecoratorParameterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TelosysDecoratorParameter.class);
  }

}
