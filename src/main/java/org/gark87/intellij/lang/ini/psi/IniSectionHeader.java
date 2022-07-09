package org.gark87.intellij.lang.ini.psi;

import consulo.annotation.access.RequiredReadAction;
import consulo.language.ast.ASTNode;
import consulo.language.psi.PsiElement;
import consulo.language.psi.PsiNamedElement;
import consulo.language.psi.stub.IStubElementType;
import consulo.language.util.IncorrectOperationException;
import consulo.util.collection.ContainerUtil;
import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import org.gark87.intellij.lang.ini.psi.stub.IniSectionHeaderStub;
import org.jetbrains.annotations.NonNls;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author VISTALL
 * @since 31.07.2015
 */
public class IniSectionHeader extends IniStubElement<IniSectionHeaderStub> implements PsiNamedElement
{
	public IniSectionHeader(@Nonnull ASTNode node)
	{
		super(node);
	}

	public IniSectionHeader(@Nonnull IniSectionHeaderStub stub, @Nonnull IStubElementType nodeType)
	{
		super(stub, nodeType);
	}

	@Override
	@RequiredReadAction
	public String getName()
	{
		IniSectionHeaderStub stub = getStub();
		if(stub != null)
		{
			return stub.getName();
		}
		List<PsiElement> psiElements = findChildrenByType(IniTokenTypes.SECTION);
		PsiElement lastItem = ContainerUtil.getLastItem(psiElements);
		return lastItem == null ? null : lastItem.getText();
	}

	@Override
	public PsiElement setName(@NonNls @Nonnull String name) throws IncorrectOperationException
	{
		return null;
	}
}
