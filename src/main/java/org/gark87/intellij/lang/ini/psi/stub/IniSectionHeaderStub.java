package org.gark87.intellij.lang.ini.psi.stub;

import consulo.index.io.StringRef;
import consulo.language.psi.stub.NamedStubBase;
import consulo.language.psi.stub.StubElement;
import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.gark87.intellij.lang.ini.psi.IniSectionHeader;

import jakarta.annotation.Nullable;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniSectionHeaderStub extends NamedStubBase<IniSectionHeader>
{
	public IniSectionHeaderStub(StubElement parent, @Nullable StringRef name)
	{
		super(parent, IniStubTokenTypes.SECTION_HEADER, name);
	}

	public IniSectionHeaderStub(StubElement parent, @Nullable String name)
	{
		super(parent, IniStubTokenTypes.SECTION_HEADER, name);
	}
}
