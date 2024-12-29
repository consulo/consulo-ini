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

import consulo.language.ast.IElementType;
import consulo.language.impl.psi.LeafPsiElement;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiNamedElement;
import consulo.language.psi.PsiReference;
import consulo.language.util.IncorrectOperationException;
import consulo.util.collection.ArrayUtil;
import consulo.util.collection.SmartList;
import org.jetbrains.annotations.NonNls;

import jakarta.annotation.Nullable;
import java.util.List;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class SectionImpl extends LeafPsiElement implements PsiNamedElement
{
	public SectionImpl(IElementType type, CharSequence text)
	{
		super(type, text);
	}

	@Override
	public PsiReference getReference()
	{
		return new SectionPsiReference(this);
	}

	@Nullable
	public SectionImpl[] getSubSections()
	{
		List<SectionImpl> result = new SmartList<SectionImpl>();
		for(PsiElement child = this; child != null; child = child.getNextSibling())
		{
			if(child instanceof SectionImpl)
			{
				result.add((SectionImpl) child);
			}
		}
		return ArrayUtil.toObjectArray(result, SectionImpl.class);
	}

	@Override
	public String getName()
	{
		return getText();
	}

	@Override
	public PsiElement setName(@NonNls String s) throws IncorrectOperationException
	{
		return this;
	}
}
