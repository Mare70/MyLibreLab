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

public class Info2D extends JVSMain {
    private Image image;
    private VSObject in;
    private VSInteger cols = new VSInteger(0);
    private VSInteger rows = new VSInteger(0);

    public void paint(java.awt.Graphics g) {
        drawImageCentred(g, image);
    }

    public void onDispose() {
        if (image != null) {
            image.flush();
            image = null;
        }
    }

    public void init() {
        initPins(0, 2, 0, 1);
        setSize(20 + 32 + 3, 32 + 4);
        initPinVisibility(false, true, false, true);
        element.jSetInnerBorderVisibility(true);

        image = element.jLoadImage(element.jGetSourcePath() + "icon.gif");


        setPin(0, ExternalIF.C_INTEGER, element.PIN_OUTPUT); // Cols
        setPin(1, ExternalIF.C_INTEGER, element.PIN_OUTPUT); // Rows
        setPin(2, ExternalIF.C_VARIANT, element.PIN_INPUT); // in

        String strLocale = Locale.getDefault().toString();

        element.jSetPinDescription(0, "Columns");
        element.jSetPinDescription(1, "Rows");
        element.jSetPinDescription(2, "in");

        element.jSetCaptionVisible(false);
        element.jSetCaption("Info2D");
        setName("Info2D");
    }


    public void initInputPins() {
        in = (VSObject) element.getPinInputReference(2);

    }


    public void initOutputPins() {
        element.setPinOutputReference(0, cols);
        element.setPinOutputReference(1, rows);
    }


    public void start() {

    }


    public void process() {
        if (in != null) {
            if (in instanceof VS2DString) {
                VS2DString val = (VS2DString) in;
                cols.setValue(val.getColumns());
                rows.setValue(val.getRows());
                element.notifyPin(0);
                element.notifyPin(1);
            } else if (in instanceof VS2DBoolean) {
                VS2DBoolean val = (VS2DBoolean) in;
                cols.setValue(val.getColumns());
                rows.setValue(val.getRows());
                element.notifyPin(0);
                element.notifyPin(1);
            } else if (in instanceof VS2DDouble) {
                VS2DDouble val = (VS2DDouble) in;
                cols.setValue(val.getColumns());
                rows.setValue(val.getRows());
                element.notifyPin(0);
                element.notifyPin(1);
            } else if (in instanceof VS2DInteger) {
                VS2DInteger val = (VS2DInteger) in;
                cols.setValue(val.getColumns());
                rows.setValue(val.getRows());
                element.notifyPin(0);
                element.notifyPin(1);
            }
        } else {
            cols.setValue(-1);
            rows.setValue(-1);
            element.notifyPin(0);
            element.notifyPin(1);
        }

    }

}
