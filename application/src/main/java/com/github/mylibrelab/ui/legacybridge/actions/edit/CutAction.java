/*
 * Copyright (C) 2020 MyLibreLab
 * Based on MyOpenLab by Carmelo Salafia www.myopenlab.de
 * Copyright (C) 2004  Carmelo Salafia cswi@gmx.de
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.github.mylibrelab.ui.legacybridge.actions.edit;

import org.jetbrains.annotations.NotNull;

import com.github.mylibrelab.action.*;
import com.github.mylibrelab.resources.Resources;
import com.github.mylibrelab.ui.icons.AllIcons;

@Action
@ParentGroup(defaultGroups = DefaultActionGroup.EDIT_MENU)
public class CutAction extends BasicAction {


    public CutAction() {
        super(Resources.getResourceText("actions.cut.displayName"),
                AllIcons.Actions.Cut, AllIcons.Actions.CutDisabled);
    }

    @Override
    public void actionPerformed(@NotNull ActionContext context) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
