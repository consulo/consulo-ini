package org.gark87.intellij.lang.ini.psi;

import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import consulo.lang.LanguageVersion;
import consulo.psi.tree.ASTLeafFactory;
import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniAstLeafFactory implements ASTLeafFactory
{
	@NotNull
	@Override
	public LeafElement createLeaf(@NotNull IElementType type, @NotNull LanguageVersion languageVersion, @NotNull CharSequence text)
	{
		return new SectionImpl(type, text);
	}

	@Override
	public boolean apply(@Nullable IElementType input)
	{
		return input == IniTokenTypes.SECTION;
	}
}