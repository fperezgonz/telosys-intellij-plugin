// This is a generated file. Not intended for manual editing.
package solutions.sulfura.telosysintellijplugin.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import static solutions.sulfura.telosysintellijplugin.lang.parser.TelosysTypes.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TelosysParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return telosys_file(b, l + 1);
  }

  /* ********************************************************** */
  // AT ANNOTATION_NAME decorator-content?
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT, ANNOTATION_NAME);
    r = r && annotation_2(b, l + 1);
    exit_section_(b, m, ANNOTATION, r);
    return r;
  }

  // decorator-content?
  private static boolean annotation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation_2")) return false;
    decorator_content(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ATTRIBUTE_NAME IGNORED* ":" IGNORED* ( ATTRIBUTE_TYPE | ENTITY_NAME ) IGNORED* "{" IGNORED* (decorator IGNORED* )* "}" IGNORED* ";"
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    if (!nextTokenIs(b, ATTRIBUTE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATTRIBUTE_NAME);
    r = r && attribute_1(b, l + 1);
    r = r && consumeToken(b, ":");
    r = r && attribute_3(b, l + 1);
    r = r && attribute_4(b, l + 1);
    r = r && attribute_5(b, l + 1);
    r = r && consumeToken(b, "{");
    r = r && attribute_7(b, l + 1);
    r = r && attribute_8(b, l + 1);
    r = r && consumeToken(b, "}");
    r = r && attribute_10(b, l + 1);
    r = r && consumeToken(b, ";");
    exit_section_(b, m, ATTRIBUTE, r);
    return r;
  }

  // IGNORED*
  private static boolean attribute_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "attribute_1", c)) break;
    }
    return true;
  }

  // IGNORED*
  private static boolean attribute_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "attribute_3", c)) break;
    }
    return true;
  }

  // ATTRIBUTE_TYPE | ENTITY_NAME
  private static boolean attribute_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_4")) return false;
    boolean r;
    r = consumeToken(b, ATTRIBUTE_TYPE);
    if (!r) r = consumeToken(b, ENTITY_NAME);
    return r;
  }

  // IGNORED*
  private static boolean attribute_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "attribute_5", c)) break;
    }
    return true;
  }

  // IGNORED*
  private static boolean attribute_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "attribute_7", c)) break;
    }
    return true;
  }

  // (decorator IGNORED* )*
  private static boolean attribute_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_8")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attribute_8_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attribute_8", c)) break;
    }
    return true;
  }

  // decorator IGNORED*
  private static boolean attribute_8_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_8_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = decorator(b, l + 1);
    r = r && attribute_8_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IGNORED*
  private static boolean attribute_8_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_8_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "attribute_8_0_1", c)) break;
    }
    return true;
  }

  // IGNORED*
  private static boolean attribute_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute_10")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "attribute_10", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "/*" COMMENT_TEXT*  "*/"
  public static boolean block_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_comment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_COMMENT, "<block comment>");
    r = consumeToken(b, "/*");
    r = r && block_comment_1(b, l + 1);
    r = r && consumeToken(b, "*/");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT_TEXT*
  private static boolean block_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_comment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, COMMENT_TEXT)) break;
      if (!empty_element_parsed_guard_(b, "block_comment_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // line-comment | block-comment
  public static boolean comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = line_comment(b, l + 1);
    if (!r) r = block_comment(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // annotation | tag
  public static boolean decorator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator")) return false;
    if (!nextTokenIs(b, "<decorator>", AT, SHARP)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECORATOR, "<decorator>");
    r = annotation(b, l + 1);
    if (!r) r = tag(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "(" IGNORED* decorator-parameter IGNORED* ( "," IGNORED* decorator-parameter)* ")"
  public static boolean decorator_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECORATOR_CONTENT, "<decorator content>");
    r = consumeToken(b, "(");
    r = r && decorator_content_1(b, l + 1);
    r = r && decorator_parameter(b, l + 1);
    r = r && decorator_content_3(b, l + 1);
    r = r && decorator_content_4(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IGNORED*
  private static boolean decorator_content_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_content_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "decorator_content_1", c)) break;
    }
    return true;
  }

  // IGNORED*
  private static boolean decorator_content_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_content_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "decorator_content_3", c)) break;
    }
    return true;
  }

  // ( "," IGNORED* decorator-parameter)*
  private static boolean decorator_content_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_content_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!decorator_content_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "decorator_content_4", c)) break;
    }
    return true;
  }

  // "," IGNORED* decorator-parameter
  private static boolean decorator_content_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_content_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && decorator_content_4_0_1(b, l + 1);
    r = r && decorator_parameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IGNORED*
  private static boolean decorator_content_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_content_4_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "decorator_content_4_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NAME|NUMBER|STRING|BOOLEAN
  public static boolean decorator_parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decorator_parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECORATOR_PARAMETER, "<decorator parameter>");
    r = consumeToken(b, NAME);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, BOOLEAN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ENTITY_NAME IGNORED* "{" IGNORED* ((comment | attribute)+ IGNORED*)+ "}"
  public static boolean entity(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity")) return false;
    if (!nextTokenIs(b, ENTITY_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ENTITY_NAME);
    r = r && entity_1(b, l + 1);
    r = r && consumeToken(b, "{");
    r = r && entity_3(b, l + 1);
    r = r && entity_4(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, m, ENTITY, r);
    return r;
  }

  // IGNORED*
  private static boolean entity_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "entity_1", c)) break;
    }
    return true;
  }

  // IGNORED*
  private static boolean entity_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "entity_3", c)) break;
    }
    return true;
  }

  // ((comment | attribute)+ IGNORED*)+
  private static boolean entity_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity_4_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!entity_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entity_4", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (comment | attribute)+ IGNORED*
  private static boolean entity_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity_4_0_0(b, l + 1);
    r = r && entity_4_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (comment | attribute)+
  private static boolean entity_4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_4_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = entity_4_0_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!entity_4_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "entity_4_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // comment | attribute
  private static boolean entity_4_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_4_0_0_0")) return false;
    boolean r;
    r = comment(b, l + 1);
    if (!r) r = attribute(b, l + 1);
    return r;
  }

  // IGNORED*
  private static boolean entity_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entity_4_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "entity_4_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "//" COMMENT_TEXT* EOL
  public static boolean line_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_comment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINE_COMMENT, "<line comment>");
    r = consumeToken(b, "//");
    r = r && line_comment_1(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT_TEXT*
  private static boolean line_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_comment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, COMMENT_TEXT)) break;
      if (!empty_element_parsed_guard_(b, "line_comment_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // SHARP TAG_NAME decorator-content?
  public static boolean tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag")) return false;
    if (!nextTokenIs(b, SHARP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SHARP, TAG_NAME);
    r = r && tag_2(b, l + 1);
    exit_section_(b, m, TAG, r);
    return r;
  }

  // decorator-content?
  private static boolean tag_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_2")) return false;
    decorator_content(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IGNORED* (comment IGNORED*)* (decorator IGNORED*)* entity IGNORED* (comment IGNORED*)*
  static boolean telosys_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = telosys_file_0(b, l + 1);
    r = r && telosys_file_1(b, l + 1);
    r = r && telosys_file_2(b, l + 1);
    r = r && entity(b, l + 1);
    r = r && telosys_file_4(b, l + 1);
    r = r && telosys_file_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IGNORED*
  private static boolean telosys_file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "telosys_file_0", c)) break;
    }
    return true;
  }

  // (comment IGNORED*)*
  private static boolean telosys_file_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!telosys_file_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "telosys_file_1", c)) break;
    }
    return true;
  }

  // comment IGNORED*
  private static boolean telosys_file_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comment(b, l + 1);
    r = r && telosys_file_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IGNORED*
  private static boolean telosys_file_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "telosys_file_1_0_1", c)) break;
    }
    return true;
  }

  // (decorator IGNORED*)*
  private static boolean telosys_file_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!telosys_file_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "telosys_file_2", c)) break;
    }
    return true;
  }

  // decorator IGNORED*
  private static boolean telosys_file_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = decorator(b, l + 1);
    r = r && telosys_file_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IGNORED*
  private static boolean telosys_file_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "telosys_file_2_0_1", c)) break;
    }
    return true;
  }

  // IGNORED*
  private static boolean telosys_file_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "telosys_file_4", c)) break;
    }
    return true;
  }

  // (comment IGNORED*)*
  private static boolean telosys_file_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!telosys_file_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "telosys_file_5", c)) break;
    }
    return true;
  }

  // comment IGNORED*
  private static boolean telosys_file_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = comment(b, l + 1);
    r = r && telosys_file_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IGNORED*
  private static boolean telosys_file_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "telosys_file_5_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, IGNORED)) break;
      if (!empty_element_parsed_guard_(b, "telosys_file_5_0_1", c)) break;
    }
    return true;
  }

}
