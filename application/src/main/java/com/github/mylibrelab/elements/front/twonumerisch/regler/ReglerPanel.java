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

package com.github.mylibrelab.elements.front.twonumerisch.regler;/*
                                                                  * Copyright (C) 2020 MyLibreLab
                                                                  * Based on MyOpenLab by Carmelo Salafia
                                                                  * www.myopenlab.de
                                                                  * Copyright (C) 2004 Carmelo Salafia cswi@gmx.de
                                                                  *
                                                                  * This program is free software: you can redistribute
                                                                  * it and/or modify
                                                                  * it under the terms of the GNU General Public License
                                                                  * as published by
                                                                  * the Free Software Foundation, either version 3 of
                                                                  * the License, or
                                                                  * (at your option) any later version.
                                                                  *
                                                                  * This program is distributed in the hope that it will
                                                                  * be useful,
                                                                  * but WITHOUT ANY WARRANTY; without even the implied
                                                                  * warranty of
                                                                  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
                                                                  * See the
                                                                  * GNU General Public License for more details.
                                                                  *
                                                                  * You should have received a copy of the GNU General
                                                                  * Public License
                                                                  * along with this program. If not, see
                                                                  * <http://www.gnu.org/licenses/>.
                                                                  *
                                                                  */

import java.awt.*;

import com.github.mylibrelab.elements.tools.CustomAnalogComp;

public class ReglerPanel extends CustomAnalogComp {
    public void init() {
        super.init();
        knobSizeInProzent.setValue(37);
        nibbleLenInProzent.setValue(30);
        nibbleCircleSizeInProzent.setValue(6);
        showBackground.setValue(false);
        backColor.setValue(new Color(204, 204, 204));
        nibbleColor.setValue(new Color(253, 153, 0));
        showNibbleAsCircle.setValue(true);
        font.setValue(new Font("Dialog", Font.BOLD, 11));
        // buttonColor.setValue(new Color(102,102,102));
        lineColor.setValue(new Color(255, 242, 181));

        setSize(140, 140);
    }

}