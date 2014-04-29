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

import org.consulo.lombok.annotations.ArrayFactoryFields;
import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.gark87.intellij.lang.ini.psi.stub.IniSectionStub;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.IncorrectOperationException;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
@ArrayFactoryFields
public class IniSection extends IniStubElement<IniSectionStub> implements PsiNamedElement, PsiNameIdentifierOwner
{
	public IniSection(ASTNode node)
	{
		super(node);
	}

	public IniSection(@NotNull IniSectionStub stub)
	{
		super(stub, IniStubTokenTypes.SECTION);
	}

	@NonNls
	public String toString()
	{
		return "Section: " + getText();
	}

	@NotNull
	public SectionImpl[] getSubSections()
	{
		return findChildrenByClass(SectionImpl.class);
	}

	@NotNull
	public IniProperty[] getProperties()
	{
		return getStubOrPsiChildren(IniStubTokenTypes.PROPERTY, IniProperty.ARRAY_FACTORY);
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