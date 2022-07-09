package consulo.ini.navigation.gotoSymbol;

import consulo.annotation.component.ExtensionImpl;
import consulo.application.util.function.Processor;
import consulo.content.scope.SearchScope;
import consulo.ide.navigation.ChooseByNameContributorEx;
import consulo.ide.navigation.GotoSymbolContributor;
import consulo.language.psi.scope.GlobalSearchScope;
import consulo.language.psi.search.FindSymbolParameters;
import consulo.language.psi.stub.IdFilter;
import consulo.language.psi.stub.StubIndex;
import consulo.navigation.NavigationItem;
import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.gark87.intellij.lang.ini.psi.stub.IniIndexKeys;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author VISTALL
 * @since 29.04.14
 */
@ExtensionImpl
public class IniGotoSymbolContributor implements GotoSymbolContributor, ChooseByNameContributorEx
{
	@Override
	public void processNames(@Nonnull Processor<String> processor, @Nonnull SearchScope scope, @Nullable IdFilter filter)
	{
		StubIndex.getInstance().processAllKeys(IniIndexKeys.PROPERTY_KEY, processor, (GlobalSearchScope) scope, filter);
	}

	@Override
	public void processElementsWithName(@Nonnull String name, @Nonnull Processor<NavigationItem> processor, @Nonnull FindSymbolParameters parameters)
	{
		StubIndex.getInstance().processElements(IniIndexKeys.PROPERTY_KEY, name, parameters.getProject(), (GlobalSearchScope) parameters.getSearchScope(),
				parameters.getIdFilter(), IniProperty.class, processor);
	}
}
