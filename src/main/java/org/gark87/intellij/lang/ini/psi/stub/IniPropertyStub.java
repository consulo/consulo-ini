package org.gark87.intellij.lang.ini.psi.stub;

import consulo.index.io.StringRef;
import consulo.language.psi.stub.NamedStubBase;
import consulo.language.psi.stub.StubElement;
import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.gark87.intellij.lang.ini.psi.IniProperty;

import javax.annotation.Nullable;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniPropertyStub extends NamedStubBase<IniProperty>
{
	public IniPropertyStub(StubElement parent, @Nullable StringRef name)
	{
		super(parent, IniStubTokenTypes.PROPERTY, name);
	}

	public IniPropertyStub(StubElement parent, @Nullable String name)
	{
		super(parent, IniStubTokenTypes.PROPERTY, name);
	}
}
