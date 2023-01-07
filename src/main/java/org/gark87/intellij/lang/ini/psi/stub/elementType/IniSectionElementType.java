package org.gark87.intellij.lang.ini.psi.stub.elementType;

import consulo.language.ast.ASTNode;
import consulo.language.ast.IElementTypeAsPsiFactory;
import consulo.language.psi.PsiElement;
import consulo.language.psi.stub.EmptyStub;
import consulo.language.psi.stub.EmptyStubElementType;
import org.gark87.intellij.lang.ini.IniLanguage;
import org.gark87.intellij.lang.ini.psi.IniSection;

import javax.annotation.Nonnull;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniSectionElementType extends EmptyStubElementType<IniSection> implements IElementTypeAsPsiFactory
{
	public IniSectionElementType()
	{
		super("SECTION", IniLanguage.INSTANCE);
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
