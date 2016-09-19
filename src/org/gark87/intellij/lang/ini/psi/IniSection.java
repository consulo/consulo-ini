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

import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import consulo.annotations.RequiredReadAction;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.stubs.EmptyStub;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.util.IncorrectOperationException;
import consulo.lombok.annotations.ArrayFactoryFields;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
@ArrayFactoryFields
public class IniSection extends IniStubElement<EmptyStub<IniSection>> implements PsiNamedElement, PsiNameIdentifierOwner
{
	public IniSection(ASTNode node)
	{
		super(node);
	}

	public IniSection(@NotNull EmptyStub<IniSection> stub, @NotNull IStubElementType nodeType)
	{
		super(stub, nodeType);
	}

	@Nullable
	@RequiredReadAction
	public IniSectionHeader getHeader()
	{
		return getStubOrPsiChild(IniStubTokenTypes.SECTION_HEADER);
	}

	@NotNull
	public SectionImpl[] getSubSections()
	{
		return findChildrenByClass(SectionImpl.class);
	}

	@NotNull
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
	public PsiElement setName(@NonNls @NotNull String s) throws IncorrectOperationException
	{
		return null;
	}
}