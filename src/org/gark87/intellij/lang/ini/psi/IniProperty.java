package org.gark87.intellij.lang.ini.psi;

import org.consulo.lombok.annotations.ArrayFactoryFields;
import org.gark87.intellij.lang.ini.parsing.IniStubTokenTypes;
import org.gark87.intellij.lang.ini.parsing.IniTokenTypes;
import org.gark87.intellij.lang.ini.psi.stub.IniPropertyStub;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.lang.ASTNode;
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
	public String getName()
	{
		PsiElement nameIdentifier = getNameIdentifier();
		return nameIdentifier == null ? null : nameIdentifier.getText();
	}

	@Nullable
	@Override
	public PsiElement getNameIdentifier()
	{
		return findChildByType(IniTokenTypes.KEY_CHARACTERS);
	}
}
