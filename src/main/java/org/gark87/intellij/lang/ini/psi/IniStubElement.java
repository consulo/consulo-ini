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

import consulo.annotation.access.RequiredReadAction;
import consulo.language.Language;
import consulo.language.ast.ASTNode;
import consulo.language.impl.psi.stub.StubBasedPsiElementBase;
import consulo.language.psi.PsiElement;
import consulo.language.psi.StubBasedPsiElement;
import consulo.language.psi.stub.IStubElementType;
import consulo.language.psi.stub.StubElement;
import org.gark87.intellij.lang.ini.IniLanguage;

import javax.annotation.Nonnull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniStubElement<T extends StubElement> extends StubBasedPsiElementBase<T> implements StubBasedPsiElement<T>
{
	public IniStubElement(@Nonnull ASTNode node)
	{
		super(node);
	}

	@Override
	public PsiElement getParent()
	{
		return getParentByStub();
	}

	public IniStubElement(@Nonnull T stub, @Nonnull IStubElementType nodeType)
	{
		super(stub, nodeType);
	}

	@RequiredReadAction
	@Nonnull
	@Override
	public Language getLanguage()
	{
		return IniLanguage.INSTANCE;
	}
}
