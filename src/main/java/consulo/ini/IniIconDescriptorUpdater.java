package consulo.ini;

import consulo.annotation.component.ExtensionImpl;
import consulo.application.AllIcons;
import consulo.language.icon.IconDescriptor;
import consulo.language.icon.IconDescriptorUpdater;
import consulo.language.psi.PsiElement;
import org.gark87.intellij.lang.ini.psi.IniProperty;

import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 29.04.14
 */
@ExtensionImpl
public class IniIconDescriptorUpdater implements IconDescriptorUpdater
{
	@Override
	public void updateIcon(@Nonnull IconDescriptor iconDescriptor, @Nonnull PsiElement element, int i)
	{
		if(element instanceof IniProperty)
		{
			iconDescriptor.setMainIcon(AllIcons.Nodes.Property);
		}
	}
}
