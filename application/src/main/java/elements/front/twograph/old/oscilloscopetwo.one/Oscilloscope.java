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

package elements.front.twograph.old.oscilloscopetwo.one;/*
                                                                               * Copyright (C) 2020 MyLibreLab
                                                                               * Based on MyOpenLab by Carmelo Salafia
                                                                               * www.myopenlab.de
                                                                               * Copyright (C) 2004 Carmelo Salafia
                                                                               * cswi@gmx.de
                                                                               *
                                                                               * This program is free software: you can
                                                                               * redistribute it and/or modify
                                                                               * it under the terms of the GNU General
                                                                               * Public License as published by
                                                                               * the Free Software Foundation, either
                                                                               * version 3 of the License, or
                                                                               * (at your option) any later version.
                                                                               *
                                                                               * This program is distributed in the hope
                                                                               * that it will be useful,
                                                                               * but WITHOUT ANY WARRANTY; without even
                                                                               * the implied warranty of
                                                                               * MERCHANTABILITY or FITNESS FOR A
                                                                               * PARTICULAR PURPOSE. See the
                                                                               * GNU General Public License for more
                                                                               * details.
                                                                               *
                                                                               * You should have received a copy of the
                                                                               * GNU General Public License
                                                                               * along with this program. If not, see
                                                                               * <http://www.gnu.org/licenses/>.
                                                                               *
                                                                               */

import java.awt.*;

import elements.tools.JVSMain;

import VisualLogic.ExternalIF;
import VisualLogic.variables.VSColor;
import VisualLogic.variables.VSGroup;

public class Oscilloscope extends JVSMain {
    public VSGroup ch1 = null;
    public VSGroup ch2 = null;
    public VSGroup ch3 = null;
    public VSGroup ch4 = null;
    public VSGroup ch5 = null;
    public VSColor color1 = null;
    public VSColor color2 = null;
    public VSColor color3 = null;
    public VSColor color4 = null;
    public VSColor color5 = null;
    private ExternalIF panelElement = null;
    private Image image;


    public Oscilloscope() {
        super();
    }

    public void onDispose() {
        image.flush();
        image = null;
    }

    public void paint(java.awt.Graphics g) {
        drawImageCentred(g, image);
    }

    public void init() {
        initPins(0, 0, 0, 10);
        setSize(40, 120);
        initPinVisibility(false, false, false, true);

        // die Channel Eingänge
        setPin(0, ExternalIF.C_GROUP, element.PIN_INPUT);
        setPin(1, ExternalIF.C_GROUP, element.PIN_INPUT);
        setPin(2, ExternalIF.C_GROUP, element.PIN_INPUT);
        setPin(3, ExternalIF.C_GROUP, element.PIN_INPUT);
        setPin(4, ExternalIF.C_GROUP, element.PIN_INPUT);

        // Für die Farben (Channel Farben)
        setPin(5, ExternalIF.C_COLOR, element.PIN_INPUT);
        setPin(6, ExternalIF.C_COLOR, element.PIN_INPUT);
        setPin(7, ExternalIF.C_COLOR, element.PIN_INPUT);
        setPin(8, ExternalIF.C_COLOR, element.PIN_INPUT);
        setPin(9, ExternalIF.C_COLOR, element.PIN_INPUT);

        element.jSetPinDescription(0, "CH 1");
        element.jSetPinDescription(1, "CH 2");
        element.jSetPinDescription(2, "CH 3");
        element.jSetPinDescription(3, "CH 4");
        element.jSetPinDescription(4, "CH 5");

        element.jSetPinDescription(5, "COL CH1");
        element.jSetPinDescription(6, "COL CH2");
        element.jSetPinDescription(7, "COL CH3");
        element.jSetPinDescription(8, "COL CH4");
        element.jSetPinDescription(9, "COL CH5");

        image = element.jLoadImage(element.jGetSourcePath() + "icon.gif");


        element.jSetCaptionVisible(true);
        element.jSetCaption("osc");

        setName("Oscilloscope");
    }


    public void initInputPins() {
        ch1 = (VSGroup) element.getPinInputReference(0);
        ch2 = (VSGroup) element.getPinInputReference(1);
        ch3 = (VSGroup) element.getPinInputReference(2);
        ch4 = (VSGroup) element.getPinInputReference(3);
        ch5 = (VSGroup) element.getPinInputReference(4);

        color1 = (VSColor) element.getPinInputReference(5);
        color2 = (VSColor) element.getPinInputReference(6);
        color3 = (VSColor) element.getPinInputReference(7);
        color4 = (VSColor) element.getPinInputReference(8);
        color5 = (VSColor) element.getPinInputReference(9);
    }

    public void initOutputPins() {

    }

    public void process() {
        if (panelElement != null) {
            if (ch1 != null) panelElement.jProcessPanel(0, 1, ch1);
            if (ch2 != null) panelElement.jProcessPanel(0, 2, ch2);
            if (ch3 != null) panelElement.jProcessPanel(0, 3, ch3);
            if (ch4 != null) panelElement.jProcessPanel(0, 4, ch4);
            if (ch5 != null) panelElement.jProcessPanel(0, 5, ch5);

            if (color1 != null) panelElement.jProcessPanel(0, 6, color1);
            if (color2 != null) panelElement.jProcessPanel(0, 7, color2);
            if (color3 != null) panelElement.jProcessPanel(0, 8, color3);
            if (color4 != null) panelElement.jProcessPanel(0, 9, color4);
            if (color5 != null) panelElement.jProcessPanel(0, 10, color5);

        }
    }

    public void start() {
        panelElement = element.getPanelElement();
        if (panelElement != null) panelElement.jRepaint();
    }


}