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

package elements.circuit.vectorenmatrix.matrixmul;// *****************************************************************************

import java.awt.Image;
import java.util.Locale;

import elements.tools.JVSMain;

import VisualLogic.ExternalIF;
import VisualLogic.variables.VS2DDouble;

public class MatrixMul extends JVSMain {
    private Image image;
    private final VS2DDouble out = new VS2DDouble(0, 0);
    private VS2DDouble inA = null;
    private VS2DDouble inB = null;

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
        initPins(0, 1, 0, 2);
        setSize(45 + 3, 36);
        initPinVisibility(false, true, false, true);
        element.jSetInnerBorderVisibility(false);

        image = element.jLoadImage(element.jGetSourcePath() + "image.png");

        setPin(0, ExternalIF.C_ARRAY2D_DOUBLE, element.PIN_OUTPUT); // Out
        setPin(1, ExternalIF.C_ARRAY2D_DOUBLE, element.PIN_INPUT); // in A
        setPin(2, ExternalIF.C_ARRAY2D_DOUBLE, element.PIN_INPUT); // in B

        String strLocale = Locale.getDefault().toString();

        element.jSetPinDescription(0, "A*B");
        element.jSetPinDescription(1, "A");
        element.jSetPinDescription(2, "B");


        element.jSetCaptionVisible(false);
        element.jSetCaption("Matrix Mul");
        setName("Matrix Mul");

    }


    public void initInputPins() {
        inA = (VS2DDouble) element.getPinInputReference(1);
        inB = (VS2DDouble) element.getPinInputReference(2);

        if (inA == null) inA = new VS2DDouble(0, 0);
        if (inB == null) inB = new VS2DDouble(0, 0);
    }


    public void initOutputPins() {
        element.setPinOutputReference(0, out);
    }


    public void start() {

    }



    /*
     * Multiplizieren der Matrix (m x n) mit einer
     * zweiten Matrix b (n x l). Rückgabewert ist
     * das Ergebnis der Multiplikation
     * (eine (m x l) - Matrix) oder null, wenn die
     * Anzahl der Spalten dieser Matrix nicht mit
     * der Anzahl der Zeilen in b übereinstimmt
     * und daher eine Multiplikation nicht möglich
     * ist
     */
    VS2DDouble multipliziereMit(VS2DDouble a, VS2DDouble b) {
        int m = a.getRows(); // Anzahl Zeilen
        int n = a.getColumns(); // Anzahl Spalten
        int mb = b.getRows(); // Anzahl Zeilen in b
        int nb = b.getColumns(); // Anzahl Spalten in b

        if (n != mb) {

            return null; // Dimensionen nicht passend
        }

        // (m x nb) - Ergebnismatrix c erzeugen
        // und Multiplikation durchführen
        VS2DDouble c = new VS2DDouble(nb, m);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nb; j++) {
                double summe = 0.0;
                for (int k = 0; k < n; k++) {
                    summe = summe + a.getValue(k, i) * b.getValue(j, k);
                }
                c.setValue(j, i, summe);
            }
        }
        return c;
    }

    public void process() {
        if (inA.getColumns() > 0 || inA.getRows() > 0) {
            if (inB.getColumns() > 0 || inB.getRows() > 0) {
                VS2DDouble temp = multipliziereMit(inA, inB);
                if (temp != null) {
                    out.copyValueFrom(temp);
                    element.notifyPin(0);
                } else {
                    element.jException("A.Column <> B.Rows");
                }
            }

        }

    }

}