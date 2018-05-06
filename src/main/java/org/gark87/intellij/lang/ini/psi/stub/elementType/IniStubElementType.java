package org.gark87.intellij.lang.ini.psi.stub.elementType;

import org.gark87.intellij.lang.ini.IniLanguage;
import org.jetbrains.annotations.NonNls;
import javax.annotation.Nonnull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;

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
		return "ini." + toString();
	}

	@Override
	public void indexStub(@Nonnull T t, @Nonnull IndexSink indexSink)
	{

	}
}

