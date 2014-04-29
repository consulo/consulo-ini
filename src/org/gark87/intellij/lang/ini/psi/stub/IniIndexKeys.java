package org.gark87.intellij.lang.ini.psi.stub;

import org.gark87.intellij.lang.ini.psi.IniProperty;
import com.intellij.psi.stubs.StubIndexKey;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public interface IniIndexKeys
{
	StubIndexKey<String, IniProperty> PROPERTY_KEY = StubIndexKey.createIndexKey("ini.property.key");
}
