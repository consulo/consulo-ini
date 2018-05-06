package org.gark87.intellij.lang.ini.psi;

import java.util.List;

import javax.annotation.Nonnull;

import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import org.gark87.intellij.lang.ini.psi.stub.IniSectionHeaderStub;
import org.jetbrains.annotations.NonNls;
import consulo.annotations.RequiredReadAction;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.containers.ContainerUtil;

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
