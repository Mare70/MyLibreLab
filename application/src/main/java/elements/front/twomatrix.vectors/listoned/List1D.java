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

package elements.front.twomatrix.vectors.listoned;/*
                                                                         * Copyright (C) 2020 MyLibreLab
                                                                         * Based on MyOpenLab by Carmelo Salafia
                                                                         * www.myopenlab.de
                                                                         * Copyright (C) 2004 Carmelo Salafia
                                                                         * cswi@gmx.de
                                                                         *
                                                                         * This program is free software: you can
                                                                         * redistribute it and/or modify
                                                                         * it under the terms of the GNU General Public
                                                                         * License as published by
                                                                         * the Free Software Foundation, either version
                                                                         * 3 of the License, or
                                                                         * (at your option) any later version.
                                                                         *
                                                                         * This program is distributed in the hope that
                                                                         * it will be useful,
                                                                         * but WITHOUT ANY WARRANTY; without even the
                                                                         * implied warranty of
                                                                         * MERCHANTABILITY or FITNESS FOR A PARTICULAR
                                                                         * PURPOSE. See the
                                                                         * GNU General Public License for more details.
                                                                         *
                                                                         * You should have received a copy of the GNU
                                                                         * General Public License
                                                                         * along with this program. If not, see
                                                                         * <http://www.gnu.org/licenses/>.
                                                                         *
                                                                         */

import java.awt.*;

import elements.tools.JVSMain;

import VisualLogic.ExternalIF;
import VisualLogic.variables.VS1DString;

public class List1D extends JVSMain {
    private Image image;
    private VS1DString out = new VS1DString(1);
    private ExternalIF panelElement;

    private VS1DString in;

    public void onDispose() {
        image.flush();
        image = null;
    }

    public void paint(java.awt.Graphics g) {
        drawImageCentred(g, image);
    }

    public void init() {
        initPins(0, 1, 0, 1);
        setSize(50, 35);

        initPinVisibility(false, true, false, true);
        image = element.jLoadImage(element.jGetSourcePath() + "icon.gif");

        setPin(0, ExternalIF.C_ARRAY1D_STRING, element.PIN_OUTPUT);
        setPin(1, ExternalIF.C_ARRAY1D_STRING, element.PIN_INPUT);

        setName("List1D-Version-1.0");
    }

    public void initInputPins() {
        in = (VS1DString) element.getPinInputReference(1);
    }

    public void initOutputPins() {
        element.setPinOutputReference(0, out);
    }

    public void start() {
        panelElement = element.getPanelElement();
    }

    public void changePin(int pinIndex, Object value) {
        Object[] values = (Object[]) value;
        if (values != null) {
            out.resize(values.length);


            for (int i = 0; i < values.length; i++) {
                out.setValue(i, (String) values[i]);
            }
            element.notifyPin(0);

        }
    }

    public void process() {

        if (in != null) {
            if (panelElement != null) {
                panelElement.jProcessPanel(0, 0.0, in);
            }
        }

    }

}