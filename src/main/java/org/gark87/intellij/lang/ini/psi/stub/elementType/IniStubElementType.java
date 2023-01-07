package org.gark87.intellij.lang.ini.psi.stub.elementType;

import consulo.language.ast.ASTNode;
import consulo.language.psi.PsiElement;
import consulo.language.psi.stub.IStubElementType;
import consulo.language.psi.stub.IndexSink;
import consulo.language.psi.stub.StubElement;
import org.gark87.intellij.lang.ini.IniLanguage;
import org.jetbrains.annotations.NonNls;

import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public abstract class IniStubElementType<T extends StubElement, E extends PsiElement> extends IStubElementType<T, E>
{
	public IniStubElementType(@Nonnull @NonNls String debugName)
	{
		super(debugName, IniLanguage.INSTANCE);
	}

	public abstract E createPsi(@Nonnull ASTNode astNode);

	@Nonnull
	@Override
	public String getExternalId()
	{
		return "INI." + toString();
	}

	@Override
	public void indexStub(@Nonnull T t, @Nonnull IndexSink indexSink)
	{

	}
}

