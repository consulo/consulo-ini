package org.gark87.intellij.lang.ini.psi.stub.elementType;

import java.io.IOException;

import org.gark87.intellij.lang.ini.psi.IniSection;
import org.gark87.intellij.lang.ini.psi.stub.IniSectionStub;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.io.StringRef;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniSectionElementType extends IniStubElementType<IniSectionStub, IniSection>
{
	public IniSectionElementType()
	{
		super("INI_SECTION");
	}

	@Override
	public IniSection createPsi(@NotNull IniSectionStub IniSectionStub)
	{
		return new IniSection(IniSectionStub);
	}

	@Override
	public IniSectionStub createStub(@NotNull IniSection IniSection, StubElement stubElement)
	{
		String name = IniSection.getName();
		return new IniSectionStub(stubElement, name);
	}

	@Override
	public void serialize(@NotNull IniSectionStub IniSectionStub, @NotNull StubOutputStream stubOutputStream) throws IOException
	{
		stubOutputStream.writeName(IniSectionStub.getName());
	}

	@NotNull
	@Override
	public IniSectionStub deserialize(@NotNull StubInputStream inputStream, StubElement stubElement) throws IOException
	{
		StringRef ref = inputStream.readName();
		return new IniSectionStub(stubElement, ref);
	}

	@Override
	public IniSection createPsi(@NotNull ASTNode astNode)
	{
		return new IniSection(astNode);
	}
}
