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

package org.gark87.intellij.lang.ini.psi;

import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.ASTFactory;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniASTFactory extends ASTFactory
{
	@Nullable
	public CompositeElement createComposite(final IElementType type)
	{
		if(type instanceof IFileElementType)
		{
			return new FileElement(type, null);
		}
		return new CompositeElement(type);
	}

	@Nullable
	public LeafElement createLeaf(final IElementType type, CharSequence text)
	{
		if(type == IniTokenTypes.SECTION)
		{
			return new SectionImpl(type, text);
		}
		return new LeafPsiElement(type, text);
	}
}

