package org.mustbe.consulo.ini.presentation;

import javax.swing.Icon;

import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.gark87.intellij.lang.ini.psi.IniSection;
import org.jetbrains.annotations.Nullable;
import org.mustbe.consulo.RequiredReadAction;
import com.intellij.ide.IconDescriptorUpdaters;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProvider;

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
		return IconDescriptorUpdaters.getIcon(myItem, 0);
	}
}
