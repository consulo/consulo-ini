/**
 * @author VISTALL
 * @since 07/01/2023
 */
module consulo.ini {
    requires consulo.ide.api;
    requires consulo.language.editor.api;
    requires consulo.language.impl;
    requires consulo.navigation.api;
    
    exports consulo.ini;
    exports consulo.ini.localize;
    exports consulo.ini.navigation.gotoSymbol;
    exports consulo.ini.presentation;
    exports org.gark87.intellij.lang.ini;
    exports org.gark87.intellij.lang.ini.findUsages;
    exports org.gark87.intellij.lang.ini.parsing;
    exports org.gark87.intellij.lang.ini.psi;
    exports org.gark87.intellij.lang.ini.psi.stub;
}