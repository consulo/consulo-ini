package consulo.ini.presentation;

import javax.annotation.Nullable;
import javax.swing.Icon;

import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.gark87.intellij.lang.ini.psi.IniSection;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProvider;
import consulo.annotations.RequiredReadAction;
import consulo.awt.TargetAWT;
import consulo.ide.IconDescriptorUpdaters;

/**
 * @author VISTALL
 * @since 31.07.2015
 */
public class IniPropertyPresentation implements ItemPresentation
{
	public static class Provider implements ItemPresentationProvider<IniProperty>
	{
		@Override
		public ItemPresentation getPresentation(IniProperty item)
		{
			return new IniPropertyPresentation(item);
		}
	}

	private IniProperty myItem;

	public IniPropertyPresentation(IniProperty item)
	{
		myItem = item;
	}

	@Nullable
	@Override
	@RequiredReadAction
	public String getPresentableText()
	{
		return myItem.getName();
	}

	@Nullable
	@Override
	@RequiredReadAction
	public String getLocationString()
	{
		IniSection section = myItem.getSection();
		return section.getName();
	}

	@Nullable
	@Override
	public Icon getIcon(boolean unused)
	{
		return TargetAWT.to(IconDescriptorUpdaters.getIcon(myItem, 0));
	}
}
