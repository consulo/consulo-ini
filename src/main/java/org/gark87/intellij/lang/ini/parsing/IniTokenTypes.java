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

import consulo.language.ast.IElementType;
import consulo.language.ast.TokenSet;
import consulo.language.ast.TokenType;
import org.gark87.intellij.lang.ini.IniLanguage;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public interface IniTokenTypes
{
	IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
	IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

	IElementType END_OF_LINE_COMMENT = new IElementType("END_OF_LINE_COMMENT", IniLanguage.INSTANCE);
	IElementType KEY_CHARACTERS = new IElementType("KEY_CHARACTERS", IniLanguage.INSTANCE);
	IElementType VALUE_CHARACTERS = new IElementType("VALUE_CHARACTERS", IniLanguage.INSTANCE);
	IElementType KEY_VALUE_SEPARATOR = new IElementType("KEY_VALUE_SEPARATOR", IniLanguage.INSTANCE);
	IElementType EOL = new IElementType("EOL", IniLanguage.INSTANCE);
	IElementType SECTION = new IElementType("SECTION", IniLanguage.INSTANCE);
	IElementType QUOTED_STRING = new IElementType("QUOTED_STRING", IniLanguage.INSTANCE);
	IElementType RBRACKET = new IElementType("RBRACKET", IniLanguage.INSTANCE);
	IElementType LBRACKET = new IElementType("LBRACKET", IniLanguage.INSTANCE);
	IElementType SECTION_SEPARATOR = new IElementType("SECTION_SEPARATOR", IniLanguage.INSTANCE);

	TokenSet COMMENTS = TokenSet.create(END_OF_LINE_COMMENT);
	TokenSet STRINGS = TokenSet.create(IniTokenTypes.QUOTED_STRING);
	TokenSet WHITESPACES = TokenSet.create(WHITE_SPACE);
	TokenSet SECTIONS = TokenSet.create(IniTokenTypes.SECTION);

}
