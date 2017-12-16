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

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import consulo.lang.LanguageVersion;
import org.gark87.intellij.lang.ini.psi.IniFile;
import org.gark87.intellij.lang.ini.psi.stub.elementType.IniStubElementType;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniParserDefinition implements ParserDefinition
{
	@Override
	@NotNull
	public Lexer createLexer(@NotNull LanguageVersion languageVersion)
	{
		return new _IniLexer();
	}

	@Override
	@NotNull
	public PsiParser createParser(@NotNull LanguageVersion languageVersion)
	{
		return new IniParser();
	}

	@Override
	@NotNull
	public IFileElementType getFileNodeType()
	{
		return IniElementTypes.FILE;
	}

	@Override
	@NotNull
	public TokenSet getWhitespaceTokens(@NotNull LanguageVersion languageVersion)
	{
		return IniTokenTypes.WHITESPACES;
	}

	@Override
	@NotNull
	public TokenSet getCommentTokens(@NotNull LanguageVersion languageVersion)
	{
		return IniTokenTypes.COMMENTS;
	}

	@Override
	@NotNull
	public TokenSet getStringLiteralElements(@NotNull LanguageVersion languageVersion)
	{
		return IniTokenTypes.STRINGS;
	}

	@Override
	@NotNull
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
	@NotNull
	public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right)
	{
		if(left.getElementType() == IniTokenTypes.END_OF_LINE_COMMENT)
		{
			return SpaceRequirements.MUST_LINE_BREAK;
		}
		return SpaceRequirements.MAY;
	}
}
