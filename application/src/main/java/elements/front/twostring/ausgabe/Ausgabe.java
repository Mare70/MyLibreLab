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

package elements.front.twostring.ausgabe;/*
                                                                * Copyright (C) 2020 MyLibreLab
                                                                * Based on MyOpenLab by Carmelo Salafia www.myopenlab.de
                                                                * Copyright (C) 2004 Carmelo Salafia cswi@gmx.de
                                                                *
                                                                * This program is free software: you can redistribute it
                                                                * and/or modify
                                                                * it under the terms of the GNU General Public License
                                                                * as published by
                                                                * the Free Software Foundation, either version 3 of the
                                                                * License, or
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

import elements.tools.JVSMain;

import VisualLogic.ExternalIF;
import VisualLogic.variables.VSString;

public class Ausgabe extends JVSMain {
    private ExternalIF panelElement;
    private Image image;
    private VSString in;
    private String oldValue;
    private boolean firstTime = true;

    public void paint(java.awt.Graphics g) {
        drawImageCentred(g, image);
    }

    public void init() {
        initPins(0, 0, 0, 1);
        setSize(45, 40);

        element.jSetInnerBorderVisibility(true);
        initPinVisibility(false, false, false, true);

        image = element.jLoadImage(element.jGetSourcePath() + "icon.gif");

        setPin(0, ExternalIF.C_STRING, element.PIN_INPUT);

        element.jSetCaptionVisible(false);
        element.jSetCaption("Ausgabe (String)");

        setName("Ausgabe (String)");
    }


    public void initInputPins() {
        in = (VSString) element.getPinInputReference(0);
    }

    public void initOutputPins() {
        firstTime = true;
    }

    public void process() {
        if (in != null) {
            if (in.getValue() != oldValue || firstTime) {
                oldValue = in.getValue();
                firstTime = false;
                panelElement = element.getPanelElement();
                if (panelElement != null) panelElement.jProcessPanel(0, 0.0, in);
            }
        }

    }

}