package consulo.ini.presentation;

import consulo.annotation.access.RequiredReadAction;
import consulo.language.icon.IconDescriptorUpdaters;
import consulo.localize.LocalizeValue;
import consulo.navigation.ItemPresentation;
import consulo.ui.image.Image;
import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.gark87.intellij.lang.ini.psi.IniSection;
import org.jspecify.annotations.Nullable;

/**
 * @author VISTALL
 * @since 2015-07-31
 */
public class IniPropertyPresentation implements ItemPresentation {
    private IniProperty myItem;

    public IniPropertyPresentation(IniProperty item) {
        myItem = item;
    }

    @Override
    @RequiredReadAction
    public LocalizeValue getPresentableText() {
        return LocalizeValue.ofNullable(myItem.getName());
    }

    @Override
    @RequiredReadAction
    public @Nullable String getLocationString() {
        IniSection section = myItem.getSection();
        return section.getName();
    }

    @Override
    @RequiredReadAction
    public @Nullable Image getIcon() {
        return IconDescriptorUpdaters.getIcon(myItem, 0);
    }
}
