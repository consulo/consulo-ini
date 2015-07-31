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

import org.gark87.intellij.lang.ini.IniBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
@org.consulo.lombok.annotations.Logger
public class Parsing
{
	public static class SectionInfo
	{
		private PsiBuilder.Marker myMarker;
		private boolean myNotEmpty;

		public SectionInfo(@NotNull PsiBuilder.Marker marker)
		{
			myMarker = marker;
		}

		@NotNull
		public SectionInfo notEmpty()
		{
			myNotEmpty = true;
			return this;
		}

		public void done()
		{
			if(myNotEmpty)
			{
				myMarker.done(IniElementTypes.SECTION);
			}
			else
			{
				myMarker.drop();
			}
		}
	}

	@Nullable
	public static SectionInfo parseStatement(PsiBuilder builder, @Nullable SectionInfo sectionMarker)
	{
		IElementType tokenType = skipEOLs(builder);
		if(tokenType == IniTokenTypes.LBRACKET)
		{
			return parseSectionName(builder, sectionMarker);
		}
		else if(tokenType == IniTokenTypes.KEY_CHARACTERS)
		{
			assert sectionMarker != null;
			parseProperty(builder);
			return sectionMarker.notEmpty();
		}
		else
		{
			builder.advanceLexer();
			builder.error(IniBundle.message("parsing.ini.unexpected.start"));
		}
		return sectionMarker;
	}

	private static SectionInfo parseSectionName(PsiBuilder builder, @Nullable SectionInfo oldMarker)
	{
		if(oldMarker != null)
		{
			oldMarker.done();
		}

		PsiBuilder.Marker rootMarker = builder.mark();

		PsiBuilder.Marker headerMarker = builder.mark();
		LOGGER.assertTrue(builder.getTokenType() == IniTokenTypes.LBRACKET);
		builder.advanceLexer();
		IElementType tokenType = builder.getTokenType();
		boolean afterSeparator = false;
		while(!builder.eof() && (tokenType == IniTokenTypes.SECTION_SEPARATOR || tokenType == IniTokenTypes.SECTION))
		{
			if(afterSeparator && (tokenType == IniTokenTypes.SECTION_SEPARATOR))
			{
				builder.error(IniBundle.message("parsing.ini.consecutive.separators"));
			}
			afterSeparator = (tokenType == IniTokenTypes.SECTION_SEPARATOR);
			builder.advanceLexer();
			tokenType = builder.getTokenType();
		}
		if(tokenType != IniTokenTypes.RBRACKET)
		{
			builder.error(IniBundle.message("parsing.ini.expect.bracket"));
		}
		if(tokenType != IniTokenTypes.EOL)   // no errors should be after EOL
		{
			builder.advanceLexer();
		}
		headerMarker.done(IniStubTokenTypes.SECTION_HEADER);

		return new SectionInfo(rootMarker);
	}

	@Nullable
	private static IElementType skipEOLs(PsiBuilder builder)
	{
		IElementType tokenType = builder.getTokenType();
		while(!builder.eof() && tokenType == IniTokenTypes.EOL)
		{
			builder.advanceLexer();
			tokenType = builder.getTokenType();
		}
		return tokenType;
	}

	public static void parseProperty(PsiBuilder builder)
	{
		IElementType tokenType = builder.getTokenType();
		if(tokenType == IniTokenTypes.KEY_CHARACTERS)
		{
			final PsiBuilder.Marker prop = builder.mark();

			parseKey(builder);
			if(builder.getTokenType() == IniTokenTypes.KEY_VALUE_SEPARATOR)
			{
				parseKeyValueSeparator(builder);
				parseValue(builder);
			}
			prop.done(IniElementTypes.PROPERTY);
			lookupEOL(builder);
		}
	}

	private static void lookupEOL(PsiBuilder builder)
	{
		while(!builder.eof() && builder.getTokenType() != IniTokenTypes.EOL)
		{
			builder.error(IniBundle.message("parsing.ini.non.eol"));
			builder.advanceLexer();
		}
		skipEOLs(builder);
	}

	private static void parseKeyValueSeparator(final PsiBuilder builder)
	{
		LOGGER.assertTrue(builder.getTokenType() == IniTokenTypes.KEY_VALUE_SEPARATOR);
		builder.advanceLexer();
	}

	private static void parseValue(final PsiBuilder builder)
	{
		while(!builder.eof() && builder.getTokenType() == IniTokenTypes.VALUE_CHARACTERS || builder.getTokenType() == IniTokenTypes.QUOTED_STRING)
		{
			builder.advanceLexer();
		}
	}

	private static void parseKey(final PsiBuilder builder)
	{
		LOGGER.assertTrue(builder.getTokenType() == IniTokenTypes.KEY_CHARACTERS);
		builder.advanceLexer();
	}
}
