package solutions.sulfura.telosysintellijplugin.lang.syntaxhighlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import solutions.sulfura.telosysintellijplugin.lang.TelosysDslLanguageFileType;

import javax.swing.*;
import java.util.Map;

public class TelosysColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Entity name", TelosysDslSyntaxHighlighter.ENTITY_NAME),
            new AttributesDescriptor("Attribute name", TelosysDslSyntaxHighlighter.ATTRIBUTE_NAME),
            new AttributesDescriptor("Attribute type", TelosysDslSyntaxHighlighter.ATTRIBUTE_TYPE),
            new AttributesDescriptor("Annotation", TelosysDslSyntaxHighlighter.ANNOTATION),
            new AttributesDescriptor("Tag", TelosysDslSyntaxHighlighter.TAG),
            new AttributesDescriptor("Name", TelosysDslSyntaxHighlighter.NAME),
            new AttributesDescriptor("Number", TelosysDslSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Boolean", TelosysDslSyntaxHighlighter.BOOLEAN),
            new AttributesDescriptor("String", TelosysDslSyntaxHighlighter.STRING),
            new AttributesDescriptor("Comment", TelosysDslSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Bad character", TelosysDslSyntaxHighlighter.BAD_CHARACTER)};

    @Override
    public @Nullable Icon getIcon() {
        return TelosysDslLanguageFileType.INSTANCE.getIcon();
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new TelosysDslSyntaxHighlighter();
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return """
                
                @DbTable(app_user_aud)@DbSchema(public)
                AppUserAud {
                
                  // attributes
                  userId : long { @Id @GeneratedValue(IDENTITY) @DbName(user_id) };
                  revtype : short { @GeneratedValue(IDENTITY) #Tag1(true) };
                  rev : int { @GeneratedValue(IDENTITY) @FK(fklrwde4gab1o0jmxy358bobg55, Revinfo.rev) };
                  username : string { @GeneratedValue(IDENTITY) @DbType("varchar(55)") @Size(55) #Tag2 };
                
                  // links
                  revinfo : Revinfo { @LinkByFK(fklrwde4gab1o0jmxy358bobg55) };
                
                }
                """;
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return Map.of();
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "Telosys";
    }
}
