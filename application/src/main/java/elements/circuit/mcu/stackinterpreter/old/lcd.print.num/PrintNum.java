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

package elements.circuit.mcu.stackinterpreter.old.lcd.print.num;// *****************************************************************************

import java.awt.*;

import javax.swing.*;

import elements.tools.MCUMainFlow;

import VisualLogic.VSBasisIF;
import VisualLogic.variables.VSFlowInfo;
import VisualLogic.variables.VSString;

public class PrintNum extends MCUMainFlow {
    private final VSFlowInfo out = new VSFlowInfo();
    private final VSString param = new VSString("");
    private Image image;
    private VSBasisIF basis;
    private VSFlowInfo in = null;

    public void paint(java.awt.Graphics g) {
        if (element != null) {
            Rectangle bounds = element.jGetBounds();
            Graphics2D g2 = (Graphics2D) g;

            g2.setFont(font);

            int mitteX = bounds.x + (bounds.width) / 2;
            int mitteY = bounds.y + (bounds.height) / 2;

            int distanceY = 10;

            g2.setColor(new Color(204, 204, 255));
            g2.fillRect(bounds.x, mitteY - distanceY, bounds.width, 2 * distanceY);
            g2.setColor(Color.BLACK);
            g2.drawRect(bounds.x, mitteY - distanceY, bounds.width, 2 * distanceY);


            String caption = "LCD_PRINT_NUM(" + param.getValue() + ")";

            drawCaption(g2, caption.trim(), 0);
        }
        super.paint(g);
    }

    private void generateCode() {

        int id = element.jGetID();

        // Überprüfe ob die Variablen oder Konstanten korrekt sind
        String errors = "";
        errors += checkProperty("var/cons", param.getValue(), MCUMainFlow.VAR_OR_CONST);

        if (errors.length() > 0) element.jShowMessage(errors);


        String code = "";
        String pa = "";

        // Variable oder Konstante
        if (isConst(param.getValue())) {
            pa = "PUSH_SI_C " + param.getValue();
        } else if (isVariable(param.getValue())) {
            pa = "LOAD_I " + param.getValue();
        }

        code += "\n";
        code += "  ELEMENT" + id + ":   // LCD_Print_Num\n";
        code += "    " + pa + " \n";
        code += "    LCD_PRINT_SI \n";
        if (element.hasPinWire(1)) {
            code += "    JMP %nextElement1%\n";
        }

        code += "\n";
        element.jSetTag(2, code);

    }

    public void xOnInit() {
        super.xOnInit();
    }


    public void start() {
        generateCode();
    }

    public void init() {
        standardWidth = 130;
        width = standardWidth;
        height = 40;

        initPins(1, 0, 1, 0);
        setSize(width, height);
        initPinVisibility(true, true, true, true);

        element.jSetInnerBorderVisibility(false);

        image = element.jLoadImage(element.jGetSourcePath() + "icon.gif");

        setPin(0, element.C_FLOWINFO, element.PIN_INPUT);
        setPin(1, element.C_FLOWINFO, element.PIN_OUTPUT);


        element.jSetCaptionVisible(false);
        element.jSetCaption("Calculate");


        setName("#MCU-FLOWCHART-CALCULATE#");

    }

    public void initInputPins() {
        in = (VSFlowInfo) element.getPinInputReference(0);
        basis = element.jGetBasis();
    }


    public void initOutputPins() {
        element.setPinOutputReference(1, out);
    }

    public void setPropertyEditor() {
        element.jAddPEItem("var/const", param, 0, 0);

        // localize();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Attention!", JOptionPane.ERROR_MESSAGE);
    }

    public void propertyChanged(Object o) {


        if (o.equals(param)) // darf Variable oder Konstante sein!
        {
            if (isConst(param.getValue())) {

            } else if (isVariable(param.getValue())) {
                // OK
            } else {
                param.setValue("");
                showMessage("No Variable or illegale const");
            }
        }
        element.jRepaint();
    }


    public void process() {

    }

    public void loadFromStream(java.io.FileInputStream fis) {
        param.loadFromStream(fis);
    }


    public void saveToStream(java.io.FileOutputStream fos) {
        param.saveToStream(fos);
    }

}