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

import javax.annotation.Nonnull;

import org.gark87.intellij.lang.ini.psi.SectionImpl;
import com.intellij.find.impl.HelpID;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniFindUsagesProvider implements FindUsagesProvider
{
	@Override
	public WordsScanner getWordsScanner()
	{
		return new IniWordsScanner();
	}

	@Override
	public boolean canFindUsagesFor(@Nonnull PsiElement psiElement)
	{
		return psiElement instanceof SectionImpl;
	}

	@Override
	public String getHelpId(@Nonnull PsiElement psiElement)
	{
		return HelpID.FIND_OTHER_USAGES;
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
}
