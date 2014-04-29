package org.gark87.intellij.lang.ini.psi.stub;

import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniPropertyIndex extends StringStubIndexExtension<IniProperty>
{
	@NotNull
	public static IniPropertyIndex getInstance()
	{
		return EP_NAME.findExtension(IniPropertyIndex.class);
	}

	@NotNull
	@Override
	public StubIndexKey<String, IniProperty> getKey()
	{
		return IniIndexKeys.PROPERTY_KEY;
	}
}
