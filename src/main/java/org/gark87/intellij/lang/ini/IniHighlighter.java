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

package org.gark87.intellij.lang.ini;

import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.tree.IElementType;
import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniHighlighter extends SyntaxHighlighterBase
{
	private static final Map<IElementType, TextAttributesKey> keys1;

	@Override
	@Nonnull
	public Lexer getHighlightingLexer()
	{
		return new IniHighlightingLexer();
	}

	public static final TextAttributesKey INI_KEY = TextAttributesKey.createTextAttributesKey("INI.KEY", DefaultLanguageHighlighterColors.NUMBER);

	public static final TextAttributesKey INI_VALUE = TextAttributesKey.createTextAttributesKey("INI.VALUE", DefaultLanguageHighlighterColors.COMMA);

	public static final TextAttributesKey INI_SECTION = TextAttributesKey.createTextAttributesKey("INI.SECTION",
			DefaultLanguageHighlighterColors.KEYWORD);

	public static final TextAttributesKey INI_BRACKETS = TextAttributesKey.createTextAttributesKey("INI.BRACES",
			DefaultLanguageHighlighterColors.KEYWORD);

	public static final TextAttributesKey INI_SECTION_SEPARATOR = TextAttributesKey.createTextAttributesKey("INI.SECTION_SEPARATOR",
			DefaultLanguageHighlighterColors.KEYWORD);

	public static final TextAttributesKey INI_QUOTED_STRING = TextAttributesKey.createTextAttributesKey("INI.QUOTED_STRING",
			DefaultLanguageHighlighterColors.STRING);

	public static final TextAttributesKey INI_COMMENT = TextAttributesKey.createTextAttributesKey("INI.LINE_COMMENT",
			DefaultLanguageHighlighterColors.LINE_COMMENT);

	public static final TextAttributesKey INI_KEY_VALUE_SEPARATOR = TextAttributesKey.createTextAttributesKey("INI.KEY_VALUE_SEPARATOR",
			DefaultLanguageHighlighterColors.OPERATION_SIGN);

	static
	{
		keys1 = new HashMap<IElementType, TextAttributesKey>();

		keys1.put(IniTokenTypes.VALUE_CHARACTERS, INI_VALUE);
		keys1.put(IniTokenTypes.END_OF_LINE_COMMENT, INI_COMMENT);
		keys1.put(IniTokenTypes.KEY_CHARACTERS, INI_KEY);
		keys1.put(IniTokenTypes.SECTION, INI_SECTION);
		keys1.put(IniTokenTypes.LBRACKET, INI_BRACKETS);
		keys1.put(IniTokenTypes.RBRACKET, INI_BRACKETS);
		keys1.put(IniTokenTypes.SECTION_SEPARATOR, INI_SECTION_SEPARATOR);
		keys1.put(IniTokenTypes.KEY_VALUE_SEPARATOR, INI_KEY_VALUE_SEPARATOR);
		keys1.put(IniTokenTypes.QUOTED_STRING, INI_QUOTED_STRING);
	}

	@Override
	@Nonnull
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType)
	{
		return pack(keys1.get(tokenType));
	}

	public static final Map<TextAttributesKey, Pair<String, HighlightSeverity>> DISPLAY_NAMES = new HashMap<>();

	static
	{
		DISPLAY_NAMES.put(INI_KEY, new Pair<String, HighlightSeverity>(IniBundle.message("options.ini.attribute.descriptor.property.key"), null));
		DISPLAY_NAMES.put(INI_VALUE, new Pair<String, HighlightSeverity>(IniBundle.message("options.ini.attribute.descriptor.property.value"),
				null));
		DISPLAY_NAMES.put(INI_KEY_VALUE_SEPARATOR, new Pair<String, HighlightSeverity>(IniBundle.message("options.ini.attribute.descriptor.property"
				+ ".separator"), null));
		DISPLAY_NAMES.put(INI_COMMENT, new Pair<String, HighlightSeverity>(IniBundle.message("options.ini.attribute.descriptor.comment"), null));
		DISPLAY_NAMES.put(INI_SECTION, new Pair<String, HighlightSeverity>(IniBundle.message("options.ini.attribute.descriptor.section"), null));
		DISPLAY_NAMES.put(INI_BRACKETS, new Pair<String, HighlightSeverity>(IniBundle.message("options.ini.attribute.descriptor.section.brackets"),
				null));
		DISPLAY_NAMES.put(INI_SECTION_SEPARATOR, new Pair<String, HighlightSeverity>(IniBundle.message("options.ini.attribute.descriptor.section" +
				".separator"), null));
		DISPLAY_NAMES.put(INI_QUOTED_STRING, new Pair<String, HighlightSeverity>(IniBundle.message("options.ini.attribute.descriptor.quoted.string"), null));
	}
}
