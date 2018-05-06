package consulo.ini;

import com.intellij.icons.AllIcons;
import com.intellij.psi.PsiElement;
import consulo.ide.IconDescriptor;
import consulo.ide.IconDescriptorUpdater;
import org.gark87.intellij.lang.ini.psi.IniProperty;
import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 29.04.14
 */
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
