package org.gark87.intellij.lang.ini.psi;

import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.ASTLeafFactory;
import com.intellij.lang.LanguageVersion;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniAstLeafFactory implements ASTLeafFactory
{
	@NotNull
	@Override
	public LeafElement createLeaf(@NotNull IElementType type, @NotNull LanguageVersion<?> languageVersion, @NotNull CharSequence text)
	{
		return new SectionImpl(type, text);
	}

	@Override
	public boolean apply(@Nullable IElementType input)
	{
		return input == IniTokenTypes.SECTION;
	}
}