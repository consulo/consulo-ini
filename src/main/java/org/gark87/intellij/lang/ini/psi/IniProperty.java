package org.gark87.intellij.lang.ini.psi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import org.gark87.intellij.lang.ini.psi.stub.IniPropertyStub;
import org.jetbrains.annotations.NonNls;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProviders;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.util.ArrayFactory;
import com.intellij.util.IncorrectOperationException;
import consulo.annotations.RequiredReadAction;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniProperty extends IniStubElement<IniPropertyStub> implements PsiNamedElement, PsiNameIdentifierOwner
{
	public static final IniProperty[] EMPTY_ARRAY = new IniProperty[0];

	public static ArrayFactory<IniProperty> ARRAY_FACTORY = new ArrayFactory<IniProperty>()
	{
		@Nonnull
		@Override
		public IniProperty[] create(int count)
		{
			return count == 0 ? EMPTY_ARRAY : new IniProperty[count];
		}
	};

	public IniProperty(@Nonnull ASTNode node)
	{
		super(node);
	}

	public IniProperty(@Nonnull IniPropertyStub stub)
	{
		super(stub, IniStubTokenTypes.PROPERTY);
	}

	@Override
	public PsiElement setName(@NonNls @Nonnull String s) throws IncorrectOperationException
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

	@Nonnull
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
