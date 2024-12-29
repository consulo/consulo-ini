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

package org.gark87.intellij.lang.ini.findUsages;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.findUsage.FindUsagesProvider;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiNamedElement;
import org.gark87.intellij.lang.ini.IniLanguage;
import org.gark87.intellij.lang.ini.psi.SectionImpl;

import jakarta.annotation.Nonnull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
@ExtensionImpl
public class IniFindUsagesProvider implements FindUsagesProvider
{
	@Override
	public boolean canFindUsagesFor(@Nonnull PsiElement psiElement)
	{
		return psiElement instanceof SectionImpl;
	}

	@Override
	@Nonnull
	public String getType(@Nonnull PsiElement psiElement)
	{
		return "section";
	}

	@Override
	@Nonnull
	public String getDescriptiveName(@Nonnull PsiElement psiElement)
	{
		String name = ((PsiNamedElement) psiElement).getName();
		return name == null ? "" : name;
	}

	@Override
	@Nonnull
	public String getNodeText(@Nonnull PsiElement psiElement, boolean b)
	{
		return getDescriptiveName(psiElement);
	}

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return IniLanguage.INSTANCE;
	}
}
