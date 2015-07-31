package org.gark87.intellij.lang.ini.psi;

import org.consulo.lombok.annotations.ArrayFactoryFields;
import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import org.gark87.intellij.lang.ini.psi.stub.IniPropertyStub;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mustbe.consulo.RequiredReadAction;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProviders;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.IncorrectOperationException;

/**
 * @author VISTALL
 * @since 29.04.14
 */
@ArrayFactoryFields
public class IniProperty extends IniStubElement<IniPropertyStub> implements PsiNamedElement, PsiNameIdentifierOwner
{
	public IniProperty(@NotNull ASTNode node)
	{
		super(node);
	}

	public IniProperty(@NotNull IniPropertyStub stub)
	{
		super(stub, IniStubTokenTypes.PROPERTY);
	}

	@Override
	public PsiElement setName(@NonNls @NotNull String s) throws IncorrectOperationException
	{
		return null;
	}

	@Override
	@RequiredReadAction
	public String getName()
	{
		PsiElement nameIdentifier = getNameIdentifier();
		return nameIdentifier == null ? null : nameIdentifier.getText();
	}

	@NotNull
	@RequiredReadAction
	public IniSection getSection()
	{
		IniSection section = getStubOrPsiParentOfType(IniSection.class);
		assert section != null;
		return section;
	}

	@Nullable
	@Override
	@RequiredReadAction
	public PsiElement getNameIdentifier()
	{
		return findChildByType(IniTokenTypes.KEY_CHARACTERS);
	}

	@Override
	public ItemPresentation getPresentation()
	{
		return ItemPresentationProviders.getItemPresentation(this);
	}
}
