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

import org.gark87.intellij.lang.ini.IniFileType;
import org.gark87.intellij.lang.ini.IniLanguage;
import org.jetbrains.annotations.NotNull;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IniFile extends PsiFileBase
{
	public IniFile(FileViewProvider viewProvider)
	{
		super(viewProvider, IniLanguage.INSTANCE);
	}

	@Override
	@NotNull
	public FileType getFileType()
	{
		return IniFileType.INSTANCE;
	}
}