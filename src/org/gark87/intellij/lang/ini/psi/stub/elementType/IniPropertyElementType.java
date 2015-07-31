package org.gark87.intellij.lang.ini.psi.stub.elementType;

import java.io.IOException;

import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.gark87.intellij.lang.ini.psi.stub.IniIndexKeys;
import org.gark87.intellij.lang.ini.psi.stub.IniPropertyStub;
import org.jetbrains.annotations.NotNull;
import org.mustbe.consulo.RequiredReadAction;
import com.intellij.lang.ASTNode;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.io.StringRef;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniPropertyElementType extends IniStubElementType<IniPropertyStub, IniProperty>
{
	public IniPropertyElementType()
	{
		super("INI_PROPERTY");
	}

	@Override
	public IniProperty createPsi(@NotNull IniPropertyStub iniPropertyStub)
	{
		return new IniProperty(iniPropertyStub);
	}

	@RequiredReadAction
	@Override
	public IniPropertyStub createStub(@NotNull IniProperty iniProperty, StubElement stubElement)
	{
		String name = iniProperty.getName();
		return new IniPropertyStub(stubElement, name);
	}

	@Override
	public void serialize(@NotNull IniPropertyStub iniPropertyStub, @NotNull StubOutputStream stubOutputStream) throws IOException
	{
		stubOutputStream.writeName(iniPropertyStub.getName());
	}

	@NotNull
	@Override
	public IniPropertyStub deserialize(@NotNull StubInputStream inputStream, StubElement stubElement) throws IOException
	{
		StringRef ref = inputStream.readName();
		return new IniPropertyStub(stubElement, ref);
	}

	@Override
	public IniProperty createPsi(@NotNull ASTNode astNode)
	{
		return new IniProperty(astNode);
	}

	@Override
	public void indexStub(
			@NotNull IniPropertyStub iniPropertyStub, @NotNull IndexSink indexSink)
	{
		String name = iniPropertyStub.getName();
		if(name == null)
		{
			return;
		}
		indexSink.occurrence(IniIndexKeys.PROPERTY_KEY, name);
	}
}
