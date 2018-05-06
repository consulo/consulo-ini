package org.gark87.intellij.lang.ini.psi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import consulo.lang.LanguageVersion;
import consulo.psi.tree.ASTLeafFactory;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniAstLeafFactory implements ASTLeafFactory
{
	@Nonnull
	@Override
	public LeafElement createLeaf(@Nonnull IElementType type, @Nonnull LanguageVersion languageVersion, @Nonnull CharSequence text)
	{
		return new SectionImpl(type, text);
	}

	@Override
	public boolean test(@Nullable IElementType input)
	{
		return input == IniTokenTypes.SECTION;
	}
}