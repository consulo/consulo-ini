package consulo.ini.presentation;

import consulo.annotation.access.RequiredReadAction;
import consulo.language.icon.IconDescriptorUpdaters;
import consulo.navigation.ItemPresentation;
import consulo.ui.image.Image;
import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.gark87.intellij.lang.ini.psi.IniSection;

import javax.annotation.Nullable;

/**
 * @author VISTALL
 * @since 31.07.2015
 */
public class IniPropertyPresentation implements ItemPresentation
{
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
	public Image getIcon()
	{
		return IconDescriptorUpdaters.getIcon(myItem, 0);
	}
}
