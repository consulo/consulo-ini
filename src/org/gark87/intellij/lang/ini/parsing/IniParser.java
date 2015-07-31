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

import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LanguageVersion;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniParser implements PsiParser
{
	@Override
	@NotNull
	public ASTNode parse(@NotNull IElementType root, @NotNull PsiBuilder builder, @NotNull LanguageVersion languageVersion)
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

