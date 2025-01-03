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

import consulo.language.ast.ASTNode;
import consulo.language.ast.IElementType;
import consulo.language.parser.PsiBuilder;
import consulo.language.parser.PsiParser;
import consulo.language.version.LanguageVersion;

import jakarta.annotation.Nonnull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniParser implements PsiParser
{
	@Override
	@Nonnull
	public ASTNode parse(@Nonnull IElementType root, @Nonnull PsiBuilder builder, @Nonnull LanguageVersion languageVersion)
	{
		final PsiBuilder.Marker rootMarker = builder.mark();
		Parsing.SectionInfo sectionMarker = new Parsing.SectionInfo(builder.mark());
		while(!builder.eof())
		{
			sectionMarker = Parsing.parseStatement(builder, sectionMarker);
		}

		if(sectionMarker != null)
		{
			sectionMarker.done();
		}

		rootMarker.done(root);
		return builder.getTreeBuilt();
	}
}

