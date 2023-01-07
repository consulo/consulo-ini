package consulo.ini;

import consulo.annotation.component.ExtensionImpl;
import consulo.language.Language;
import consulo.language.editor.highlight.SingleLazyInstanceSyntaxHighlighterFactory;
import consulo.language.editor.highlight.SyntaxHighlighter;
import org.gark87.intellij.lang.ini.IniHighlighter;
import org.gark87.intellij.lang.ini.IniLanguage;

import javax.annotation.Nonnull;
/**
 * @author VISTALL
 * @since 2019-02-26
 */
@ExtensionImpl
public class InitSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory
{
	@Nonnull
	@Override
	protected SyntaxHighlighter createHighlighter()
	{
		return new IniHighlighter();
	}

	@Nonnull
	@Override
	public Language getLanguage()
	{
		return IniLanguage.INSTANCE;
	}
}
