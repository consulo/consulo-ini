package org.gark87.intellij.lang.ini.psi.stub.elementType;

import org.gark87.intellij.lang.ini.IniLanguage;
import org.gark87.intellij.lang.ini.psi.IniSection;
import org.jetbrains.annotations.NotNull;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.EmptyStub;
import com.intellij.psi.stubs.EmptyStubElementType;
import com.intellij.psi.tree.IElementTypeAsPsiFactory;

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
	public IniSection createPsi(@NotNull EmptyStub stub)
	{
		//noinspection unchecked
		return new IniSection(stub, this);
	}

	@NotNull
	@Override
	public PsiElement createElement(@NotNull ASTNode astNode)
	{
		return new IniSection(astNode);
	}
}
