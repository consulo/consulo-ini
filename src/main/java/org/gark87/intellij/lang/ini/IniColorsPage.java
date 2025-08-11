/*
 * Copyright 2010 gark87
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gark87.intellij.lang.ini;

import consulo.annotation.component.ExtensionImpl;
import consulo.colorScheme.TextAttributesKey;
import consulo.colorScheme.setting.AttributesDescriptor;
import consulo.ini.localize.IniLocalize;
import consulo.language.editor.colorScheme.setting.ColorSettingsPage;
import consulo.language.editor.highlight.SyntaxHighlighter;
import consulo.localize.LocalizeValue;
import jakarta.annotation.Nonnull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
@ExtensionImpl
public class IniColorsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] ATTRS;

    static {
        ATTRS = new AttributesDescriptor[IniHighlighter.DISPLAY_NAMES.size()];
        TextAttributesKey[] keys = IniHighlighter.DISPLAY_NAMES.keySet().toArray(new TextAttributesKey[IniHighlighter.DISPLAY_NAMES.keySet().size()]);
        for (int i = 0; i < keys.length; i++) {
            TextAttributesKey key = keys[i];
            LocalizeValue name = IniHighlighter.DISPLAY_NAMES.get(key).getFirst();
            ATTRS[i] = new AttributesDescriptor(name, key);
        }
    }


    @Override
    @Nonnull
    public LocalizeValue getDisplayName() {
        return IniLocalize.ini();
    }

    @Override
    @Nonnull
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRS;
    }

    @Override
    @Nonnull
    public SyntaxHighlighter getHighlighter() {
        return new IniHighlighter();
    }

    @Override
    @Nonnull
    public String getDemoText() {
        return "; Comment on keys and values\n" +
            "[section : subsection ]\n" +
            "key1  = value1 \"quoted string\"";
    }
}
