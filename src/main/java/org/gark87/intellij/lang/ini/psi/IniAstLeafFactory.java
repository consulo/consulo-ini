package org.gark87.intellij.lang.ini.psi;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.ast.IElementType;
import consulo.language.impl.ast.ASTLeafFactory;
import consulo.language.impl.ast.LeafElement;
import consulo.language.version.LanguageVersion;
import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author VISTALL
 * @since 29.04.14
 */
@ExtensionImpl
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