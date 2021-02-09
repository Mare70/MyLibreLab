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

public class GaugeCircuit extends JVSMain {
    private double oldValue;
    private double oldValue2;
    private ExternalIF panelElement;
    private Image image;
    private VSObject in = null;
    private VSObject in2 = null;


    public void onDispose() {
        image.flush();
        image = null;
    }

    public void paint(java.awt.Graphics g) {
        drawImageCentred(g, image);
    }

    public void init() {
        initPins(0, 0, 0, 2);
        setSize(50, 45);

        element.jSetInnerBorderVisibility(false);
        element.jSetTopPinsVisible(false);
        element.jSetRightPinsVisible(false);
        element.jSetBottomPinsVisible(false);

        image = element.jLoadImage(element.jGetSourcePath() + "icon.gif");


        setPin(0, ExternalIF.C_VARIANT, element.PIN_INPUT);
        setPin(1, ExternalIF.C_VARIANT, element.PIN_INPUT);
        element.jSetPinDescription(0, "Pitch in");
        element.jSetPinDescription(1, "Roll in");

        element.jSetCaptionVisible(true);
        element.jSetCaption("Horizon_JV");

        setName("Horizon_JV");
    }


    public void initInputPins() {
        in = (VSObject) element.getPinInputReference(0);
        in2 = (VSObject) element.getPinInputReference(1);
    }

    public void initOutputPins() {}


    public void checkPinDataType() {
        boolean pinIn = element.hasPinWire(0);
        int dt = element.C_VARIANT;
        if (pinIn == true) {
            dt = element.jGetPinDrahtSourceDataType(0);

            if (dt == element.C_DOUBLE)
                dt = element.C_DOUBLE;
            else if (dt == element.C_INTEGER)
                dt = element.C_INTEGER;
            else if (dt == element.C_BYTE)
                dt = element.C_BYTE;
            else
                dt = element.C_DOUBLE;
        }
        element.jSetPinDataType(0, dt);

        pinIn = element.hasPinWire(1);
        dt = element.C_VARIANT;
        if (pinIn == true) {
            dt = element.jGetPinDrahtSourceDataType(1);

            if (dt == element.C_DOUBLE)
                dt = element.C_DOUBLE;
            else if (dt == element.C_INTEGER)
                dt = element.C_INTEGER;
            else if (dt == element.C_BYTE)
                dt = element.C_BYTE;
            else
                dt = element.C_DOUBLE;
        }

        element.jSetPinDataType(1, dt);

        element.jRepaint();
    }



    public void process() {
        if (in != null) {
            double value = 0;
            if (in instanceof VSDouble) {
                VSDouble val = (VSDouble) in;
                value = val.getValue();
            } else if (in instanceof VSInteger) {
                VSInteger val = (VSInteger) in;
                value = (double) val.getValue();
            } else if (in instanceof VSByte) {
                VSByte val = (VSByte) in;
                value = (double) val.toSigned(val.getValue());
            }

            if (value != oldValue) {
                panelElement = element.getPanelElement();
                if (panelElement != null) {
                    panelElement.jProcessPanel(0, value, (Object) this);
                    panelElement.jRepaint();
                }
                oldValue = value;
            }

        }


        if (in2 != null) {
            double value2 = 0;
            if (in2 instanceof VSDouble) {
                VSDouble val = (VSDouble) in2;
                value2 = val.getValue();
            } else if (in2 instanceof VSInteger) {
                VSInteger val = (VSInteger) in2;
                value2 = (double) val.getValue();
            } else if (in2 instanceof VSByte) {
                VSByte val = (VSByte) in2;
                value2 = (double) val.toSigned(val.getValue());
            }

            if (value2 != oldValue2) {
                panelElement = element.getPanelElement();
                if (panelElement != null) {
                    panelElement.jProcessPanel(1, value2, (Object) this);
                    panelElement.jRepaint();
                }
                oldValue2 = value2;
            }

        }


    }


}
