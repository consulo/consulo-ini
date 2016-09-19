package consulo.ini.navigation.gotoSymbol;

import org.gark87.intellij.lang.ini.psi.IniProperty;
import org.gark87.intellij.lang.ini.psi.stub.IniIndexKeys;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.navigation.ChooseByNameContributorEx;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.util.ArrayUtil;
import com.intellij.util.CommonProcessors;
import com.intellij.util.Processor;
import com.intellij.util.indexing.FindSymbolParameters;
import com.intellij.util.indexing.IdFilter;

/**
 * @author VISTALL
 * @since 29.04.14
 */
public class IniGotoSymbolContributor implements ChooseByNameContributorEx
{
	@Override
	public void processNames(@NotNull Processor<String> processor, @NotNull GlobalSearchScope scope, @Nullable IdFilter filter)
	{
		StubIndex.getInstance().processAllKeys(IniIndexKeys.PROPERTY_KEY, processor, scope, filter);
	}

	@Override
	public void processElementsWithName(@NotNull String name, @NotNull Processor<NavigationItem> processor, @NotNull FindSymbolParameters parameters)
	{
		StubIndex.getInstance().processElements(IniIndexKeys.PROPERTY_KEY, name, parameters.getProject(), parameters.getSearchScope(),
				parameters.getIdFilter(), IniProperty.class, processor);
	}

	@NotNull
	@Override
	public String[] getNames(Project project, boolean includeNonProjectItems)
	{
		CommonProcessors.CollectProcessor<String> processor = new CommonProcessors.CollectProcessor<String>();
		StubIndex.getInstance().processAllKeys(IniIndexKeys.PROPERTY_KEY, project, processor);
		return ArrayUtil.toStringArray(processor.getResults());
	}

	@NotNull
	@Override
	public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems)
	{
		CommonProcessors.CollectProcessor<NavigationItem> processor = new CommonProcessors.CollectProcessor<NavigationItem>();
		processElementsWithName(name, processor, FindSymbolParameters.wrap(pattern, project, includeNonProjectItems));
		return processor.toArray(NavigationItem.ARRAY_FACTORY);
	}
}
