package org.gark87.intellij.lang.ini.psi.stub;

import javax.annotation.Nullable;

import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.gark87.intellij.lang.ini.psi.IniProperty;
import com.intellij.psi.stubs.NamedStubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.util.io.StringRef;

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
