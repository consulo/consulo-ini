package org.gark87.intellij.lang.ini.psi.stub.elementType;

import javax.annotation.Nonnull;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.EmptyStub;
import com.intellij.psi.stubs.EmptyStubElementType;
import consulo.psi.tree.IElementTypeAsPsiFactory;
import org.gark87.intellij.lang.ini.IniLanguage;
import org.gark87.intellij.lang.ini.psi.IniSection;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniSectionElementType extends EmptyStubElementType<IniSection> implements IElementTypeAsPsiFactory
{
	public IniSectionElementType()
	{
		super("INI_SECTION", IniLanguage.INSTANCE);
	}

	@Override
	public IniSection createPsi(@Nonnull EmptyStub stub)
	{
		//noinspection unchecked
		return new IniSection(stub, this);
	}

	@Nonnull
	@Override
	public PsiElement createElement(@Nonnull ASTNode astNode)
	{
		return new IniSection(astNode);
	}
}
