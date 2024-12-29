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

import consulo.annotation.component.ExtensionImpl;
import consulo.document.util.TextRange;
import consulo.language.psi.AbstractElementManipulator;
import consulo.language.util.IncorrectOperationException;
import org.gark87.intellij.lang.ini.psi.SectionImpl;

import jakarta.annotation.Nonnull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
@ExtensionImpl
public class SectionManipulator extends AbstractElementManipulator<SectionImpl>
{
	@Override
	public SectionImpl handleContentChange(SectionImpl element, TextRange range, String newContent) throws IncorrectOperationException
	{
		final String oldText = element.getText();
		String newText = oldText.substring(0, range.getStartOffset()) + newContent + oldText.substring(range.getEndOffset());
		return (SectionImpl) element.replaceWithText(newText);
	}

	@Nonnull
	@Override
	public Class<SectionImpl> getElementClass()
	{
		return SectionImpl.class;
	}
}

