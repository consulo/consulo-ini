package consulo.ini.presentation;

import consulo.annotation.component.ExtensionImpl;
import consulo.navigation.ItemPresentation;
import consulo.navigation.ItemPresentationProvider;
import org.gark87.intellij.lang.ini.psi.IniProperty;

import jakarta.annotation.Nonnull;

@ExtensionImpl
public class IniPropertyPresentationProvider implements ItemPresentationProvider<IniProperty> {
    @Nonnull
    @Override
    public Class<IniProperty> getItemClass() {
        return IniProperty.class;
    }

    @Nonnull
    @Override
    public ItemPresentation getPresentation(IniProperty item) {
        return new IniPropertyPresentation(item);
    }
}
