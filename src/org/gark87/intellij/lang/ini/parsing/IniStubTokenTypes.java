package org.gark87.intellij.lang.ini.parsing;

import org.gark87.intellij.lang.ini.psi.stub.elementType.IniPropertyElementType;
import org.gark87.intellij.lang.ini.psi.stub.elementType.IniSectionElementType;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public interface IniStubTokenTypes
{
	IniPropertyElementType PROPERTY = new IniPropertyElementType();
	IniSectionElementType SECTION = new IniSectionElementType();
}
