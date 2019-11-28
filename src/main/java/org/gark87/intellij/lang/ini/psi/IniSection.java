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

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.stubs.EmptyStub;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.util.ArrayFactory;
import com.intellij.util.IncorrectOperationException;
import consulo.annotation.access.RequiredReadAction;
import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.jetbrains.annotations.NonNls;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniSection extends IniStubElement<EmptyStub<IniSection>> implements PsiNamedElement, PsiNameIdentifierOwner
{
	public static final IniSection[] EMPTY_ARRAY = new IniSection[0];

	public static ArrayFactory<IniSection> ARRAY_FACTORY = new ArrayFactory<IniSection>()
	{
		@Nonnull
		@Override
		public IniSection[] create(int count)
		{
			return count == 0 ? EMPTY_ARRAY : new IniSection[count];
		}
	};

	public IniSection(ASTNode node)
	{
		super(node);
	}

	public IniSection(@Nonnull EmptyStub<IniSection> stub, @Nonnull IStubElementType nodeType)
	{
		super(stub, nodeType);
	}

	@Nullable
	@RequiredReadAction
	public IniSectionHeader getHeader()
	{
		return getStubOrPsiChild(IniStubTokenTypes.SECTION_HEADER);
	}

	@Nonnull
	public SectionImpl[] getSubSections()
	{
		return findChildrenByClass(SectionImpl.class);
	}

	@Nonnull
	@RequiredReadAction
	public IniProperty[] getProperties()
	{
		return getStubOrPsiChildren(IniStubTokenTypes.PROPERTY, IniProperty.ARRAY_FACTORY);
	}

	@Override
	@RequiredReadAction
	public String getName()
	{
		IniSectionHeader header = getHeader();
		return header == null ? null : header.getName();
	}

	@Nullable
	@Override
	public PsiElement getNameIdentifier()
	{
		return null;
	}

	@Override
	public PsiElement setName(@NonNls @Nonnull String s) throws IncorrectOperationException
	{
		return null;
	}
}