package org.mustbe.consulo.ini;

import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.jetbrains.annotations.NotNull;
import com.intellij.icons.AllIcons;
import com.intellij.ide.IconDescriptor;
import com.intellij.ide.IconDescriptorUpdater;
import com.intellij.psi.PsiElement;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniIconDescriptorUpdater implements IconDescriptorUpdater
{
	@Override
	public void updateIcon(@NotNull IconDescriptor iconDescriptor, @NotNull PsiElement element, int i)
	{
		if(element instanceof IniProperty)
		{
			iconDescriptor.setMainIcon(AllIcons.Nodes.Property);
		}
	}
}
