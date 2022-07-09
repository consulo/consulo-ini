/*
 * Copyright 2010 gark87
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gark87.intellij.lang.ini.parsing;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.ast.ASTNode;
import consulo.language.ast.IElementType;
import consulo.language.ast.IFileElementType;
import consulo.language.ast.TokenSet;
import consulo.language.file.FileViewProvider;
import consulo.language.impl.psi.ASTWrapperPsiElement;
import consulo.language.lexer.Lexer;
import consulo.language.parser.ParserDefinition;
import consulo.language.parser.PsiParser;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiFile;
import consulo.language.version.LanguageVersion;
import org.gark87.intellij.lang.ini.IniLanguage;
import org.gark87.intellij.lang.ini.psi.IniFile;
import org.gark87.intellij.lang.ini.psi.stub.elementType.IniStubElementType;

import javax.annotation.Nonnull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
@ExtensionImpl
public class IniParserDefinition implements ParserDefinition
{
	@Nonnull
	@Override
	public Language getLanguage()
	{
		return IniLanguage.INSTANCE;
	}

	@Override
	@Nonnull
	public Lexer createLexer(@Nonnull LanguageVersion languageVersion)
	{
		return new _IniLexer();
	}

	@Override
	@Nonnull
	public PsiParser createParser(@Nonnull LanguageVersion languageVersion)
	{
		return new IniParser();
	}

	@Override
	@Nonnull
	public IFileElementType getFileNodeType()
	{
		return IniElementTypes.FILE;
	}

	@Override
	@Nonnull
	public TokenSet getWhitespaceTokens(@Nonnull LanguageVersion languageVersion)
	{
		return IniTokenTypes.WHITESPACES;
	}

	@Override
	@Nonnull
	public TokenSet getCommentTokens(@Nonnull LanguageVersion languageVersion)
	{
		return IniTokenTypes.COMMENTS;
	}

	@Override
	@Nonnull
	public TokenSet getStringLiteralElements(@Nonnull LanguageVersion languageVersion)
	{
		return IniTokenTypes.STRINGS;
	}

	@Override
	@Nonnull
	public PsiElement createElement(ASTNode node)
	{
		final IElementType type = node.getElementType();
		if(type instanceof IniStubElementType)
		{
			return ((IniStubElementType) type).createPsi(node);
		}
		return new ASTWrapperPsiElement(node);
	}

	@Override
	public PsiFile createFile(FileViewProvider viewProvider)
	{
		return new IniFile(viewProvider);
	}

	@Override
	@Nonnull
	public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right)
	{
		if(left.getElementType() == IniTokenTypes.END_OF_LINE_COMMENT)
		{
			return SpaceRequirements.MUST_LINE_BREAK;
		}
		return SpaceRequirements.MAY;
	}
}
