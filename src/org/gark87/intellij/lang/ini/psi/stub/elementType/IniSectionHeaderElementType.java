package org.gark87.intellij.lang.ini.psi.stub.elementType;

import java.io.IOException;

import org.gark87.intellij.lang.ini.psi.IniSectionHeader;
import org.gark87.intellij.lang.ini.psi.stub.IniSectionHeaderStub;
import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.RequiredReadAction;
import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.io.StringRef;

/**
 * @author VISTALL
 * @since 31.07.15
 */
public class IniSectionHeaderElementType extends IniStubElementType<IniSectionHeaderStub, IniSectionHeader>
{
	public IniSectionHeaderElementType()
	{
		super("INI_SECTION_HEADER");
	}

	@Override
	public IniSectionHeader createPsi(@NotNull IniSectionHeaderStub IniSectionHeaderStub)
	{
		return new IniSectionHeader(IniSectionHeaderStub, this);
	}

	@Override
	public IniSectionHeader createPsi(@NotNull ASTNode astNode)
	{
		return new IniSectionHeader(astNode);
	}

	@RequiredReadAction
	@Override
	public IniSectionHeaderStub createStub(@NotNull IniSectionHeader iniSection, StubElement stubElement)
	{
		String name = iniSection.getName();
		return new IniSectionHeaderStub(stubElement, name);
	}

	@Override
	public void serialize(@NotNull IniSectionHeaderStub IniSectionHeaderStub, @NotNull StubOutputStream stubOutputStream) throws IOException
	{
		stubOutputStream.writeName(IniSectionHeaderStub.getName());
	}

	@NotNull
	@Override
	public IniSectionHeaderStub deserialize(@NotNull StubInputStream inputStream, StubElement stubElement) throws IOException
	{
		StringRef ref = inputStream.readName();
		return new IniSectionHeaderStub(stubElement, ref);
	}
}
