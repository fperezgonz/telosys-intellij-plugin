// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import solutions.sulfura.telosysintellijplugin.lang.parser.impl.*;
import solutions.sulfura.telosysintellijplugin.lang.psi.TelosysElementType;
import solutions.sulfura.telosysintellijplugin.lang.psi.TelosysTokenType;

public interface TelosysTypes {

  IElementType ANNOTATION = new TelosysElementType("ANNOTATION");
  IElementType ATTRIBUTE = new TelosysElementType("ATTRIBUTE");
  IElementType BLOCK_COMMENT = new TelosysElementType("BLOCK_COMMENT");
  IElementType COMMENT = new TelosysElementType("COMMENT");
  IElementType DECORATOR = new TelosysElementType("DECORATOR");
  IElementType DECORATOR_CONTENT = new TelosysElementType("DECORATOR_CONTENT");
  IElementType DECORATOR_PARAMETER = new TelosysElementType("DECORATOR_PARAMETER");
  IElementType ENTITY = new TelosysElementType("ENTITY");
  IElementType LINE_COMMENT = new TelosysElementType("LINE_COMMENT");
  IElementType TAG = new TelosysElementType("TAG");

  IElementType ANNOTATION_NAME = new TelosysTokenType("ANNOTATION_NAME");
  IElementType AT = new TelosysTokenType("AT");
  IElementType ATTRIBUTE_NAME = new TelosysTokenType("ATTRIBUTE_NAME");
  IElementType ATTRIBUTE_TYPE = new TelosysTokenType("ATTRIBUTE_TYPE");
  IElementType BOOLEAN = new TelosysTokenType("BOOLEAN");
  IElementType COMMENT_TEXT = new TelosysTokenType("COMMENT_TEXT");
  IElementType ENTITY_NAME = new TelosysTokenType("ENTITY_NAME");
  IElementType EOL = new TelosysTokenType("EOL");
  IElementType IGNORED = new TelosysTokenType("IGNORED");
  IElementType NAME = new TelosysTokenType("NAME");
  IElementType NUMBER = new TelosysTokenType("NUMBER");
  IElementType SHARP = new TelosysTokenType("SHARP");
  IElementType STRING = new TelosysTokenType("STRING");
  IElementType TAG_NAME = new TelosysTokenType("TAG_NAME");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANNOTATION) {
        return new TelosysAnnotationImpl(node);
      }
      else if (type == ATTRIBUTE) {
        return new TelosysAttributeImpl(node);
      }
      else if (type == BLOCK_COMMENT) {
        return new TelosysBlockCommentImpl(node);
      }
      else if (type == COMMENT) {
        return new TelosysCommentImpl(node);
      }
      else if (type == DECORATOR) {
        return new TelosysDecoratorImpl(node);
      }
      else if (type == DECORATOR_CONTENT) {
        return new TelosysDecoratorContentImpl(node);
      }
      else if (type == DECORATOR_PARAMETER) {
        return new TelosysDecoratorParameterImpl(node);
      }
      else if (type == ENTITY) {
        return new TelosysEntityImpl(node);
      }
      else if (type == LINE_COMMENT) {
        return new TelosysLineCommentImpl(node);
      }
      else if (type == TAG) {
        return new TelosysTagImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
