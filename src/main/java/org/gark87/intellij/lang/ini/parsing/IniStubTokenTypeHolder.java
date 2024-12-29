package org.gark87.intellij.lang.ini.parsing;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.psi.stub.ObjectStubSerializerProvider;
import consulo.language.psi.stub.StubElementTypeHolder;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @author VISTALL
 * @since 07/01/2023
 */
@ExtensionImpl
public class IniStubTokenTypeHolder extends StubElementTypeHolder<IniStubTokenTypes> {
    @Nullable
    @Override
    public String getExternalIdPrefix() {
        return "ini.";
    }

    @Nonnull
    @Override
    public List<ObjectStubSerializerProvider> loadSerializers() {
        return allFromStaticFields(IniStubTokenTypes.class, Field::get);
    }
}
