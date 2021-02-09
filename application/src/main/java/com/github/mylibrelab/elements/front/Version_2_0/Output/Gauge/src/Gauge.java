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

package com.github.mylibrelab.elements.front.Version_2_0.Output.Gauge.src;// *****************************************************************************


public class Gauge extends JVSMain {
    private double value0;
    private Image image;
    ExternalIF panelElement;

    private VSDouble in;

    public void onDispose() {
        image.flush();
        image = null;
    }


    public void paint(java.awt.Graphics g) {
        drawImageCentred(g, image);
    }

    public void init() {
        initPins(0, 0, 0, 1);
        setSize(40, 25);

        initPinVisibility(false, false, false, true);
        image = element.jLoadImage(element.jGetSourcePath() + "icon.gif");

        setPin(0, ExternalIF.C_DOUBLE, element.PIN_INPUT);

        setName("Gauge2");
    }



    public void initInputPins() {
        in = (VSDouble) element.getPinInputReference(0);
    }

    public void initOutputPins() {}

    public void start() {
        value0 = -1;
    }

    public void process() {

        if (in != null && value0 != in.getValue()) {
            value0 = in.getValue();
            panelElement = element.getPanelElement();
            panelElement.jProcessPanel(0, value0, this);
            panelElement.jRepaint();
        }

    }

}
