package org.gark87.intellij.lang.ini.psi.stub.elementType;

import consulo.annotation.access.RequiredReadAction;
import consulo.index.io.StringRef;
import consulo.language.ast.ASTNode;
import consulo.language.psi.stub.StubElement;
import consulo.language.psi.stub.StubInputStream;
import consulo.language.psi.stub.StubOutputStream;
import org.gark87.intellij.lang.ini.psi.IniSectionHeader;
import org.gark87.intellij.lang.ini.psi.stub.IniSectionHeaderStub;

import javax.annotation.Nonnull;
import java.io.IOException;

/**
 * @author VISTALL
 * @since 31.07.15
 */
public class IniSectionHeaderElementType extends IniStubElementType<IniSectionHeaderStub, IniSectionHeader>
{
	public IniSectionHeaderElementType()
	{
		super("SECTION_HEADER");
	}

	@Override
	public IniSectionHeader createPsi(@Nonnull IniSectionHeaderStub IniSectionHeaderStub)
	{
		return new IniSectionHeader(IniSectionHeaderStub, this);
	}

	@Override
	public IniSectionHeader createPsi(@Nonnull ASTNode astNode)
	{
		return new IniSectionHeader(astNode);
	}

	@RequiredReadAction
	@Override
	public IniSectionHeaderStub createStub(@Nonnull IniSectionHeader iniSection, StubElement stubElement)
	{
		String name = iniSection.getName();
		return new IniSectionHeaderStub(stubElement, name);
	}

	@Override
	public void serialize(@Nonnull IniSectionHeaderStub IniSectionHeaderStub, @Nonnull StubOutputStream stubOutputStream) throws IOException
	{
		stubOutputStream.writeName(IniSectionHeaderStub.getName());
	}

	@Nonnull
	@Override
	public IniSectionHeaderStub deserialize(@Nonnull StubInputStream inputStream, StubElement stubElement) throws IOException
	{
		StringRef ref = inputStream.readName();
		return new IniSectionHeaderStub(stubElement, ref);
	}
}
