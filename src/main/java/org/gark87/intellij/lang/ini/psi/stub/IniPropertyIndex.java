package org.gark87.intellij.lang.ini.psi.stub;

import consulo.language.psi.stub.StringStubIndexExtension;
import consulo.language.psi.stub.StubIndexKey;
import org.gark87.intellij.lang.ini.psi.IniProperty;

import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniPropertyIndex extends StringStubIndexExtension<IniProperty>
{
	@Nonnull
	public static IniPropertyIndex getInstance()
	{
		return EP_NAME.findExtensionOrFail(IniPropertyIndex.class);
	}

	@Nonnull
	@Override
	public StubIndexKey<String, IniProperty> getKey()
	{
		return IniIndexKeys.PROPERTY_KEY;
	}
}
