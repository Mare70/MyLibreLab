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

package elements.circuit.numerik.parser.math.calc.src.expressionparser;/*
                                                                                              * Copyright (C) 2020
                                                                                              * MyLibreLab
                                                                                              * Based on MyOpenLab by
                                                                                              * Carmelo Salafia
                                                                                              * www.myopenlab.de
                                                                                              * Copyright (C) 2004
                                                                                              * Carmelo Salafia
                                                                                              * cswi@gmx.de
                                                                                              *
                                                                                              * This program is free
                                                                                              * software: you can
                                                                                              * redistribute it and/or
                                                                                              * modify
                                                                                              * it under the terms of
                                                                                              * the GNU General Public
                                                                                              * License as published by
                                                                                              * the Free Software
                                                                                              * Foundation, either
                                                                                              * version 3 of the
                                                                                              * License, or
                                                                                              * (at your option) any
                                                                                              * later version.
                                                                                              *
                                                                                              * This program is
                                                                                              * distributed in the hope
                                                                                              * that it will be useful,
                                                                                              * but WITHOUT ANY
                                                                                              * WARRANTY; without even
                                                                                              * the implied warranty of
                                                                                              * MERCHANTABILITY or
                                                                                              * FITNESS FOR A PARTICULAR
                                                                                              * PURPOSE. See the
                                                                                              * GNU General Public
                                                                                              * License for more
                                                                                              * details.
                                                                                              *
                                                                                              * You should have received
                                                                                              * a copy of the GNU
                                                                                              * General Public License
                                                                                              * along with this program.
                                                                                              * If not, see
                                                                                              * <http://www.gnu.org/
                                                                                              * licenses/>.
                                                                                              *
                                                                                              */

import java.awt.*;

/**
 *
 * @author Homer
 */
public class Visual extends javax.swing.JFrame {

    private Parser parser = null;

    /** Creates new form Visual */
    public Visual() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jButton1.setText("Draw");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("80*exp(-((x/40)^2)) ");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(26, 26, 26)
                                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 176,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton1)
                                .addContainerGap(188, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jButton1))
                                .addContainerGap(364, Short.MAX_VALUE)));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 463) / 2, (screenSize.height - 425) / 2, 463, 425);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

        parser = new Parser(jTextField1.getText());
        repaint();

    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Visual().setVisible(true);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);


        if (parser != null) {
            int mitteX = getWidth() / 2;
            int mitteY = getHeight() / 2;

            double oldX = -10;
            double oldY = 0;

            double zoomX = 1;
            double zoomY = 1;

            int c = 0;
            for (double x = -200; x < 200; x += 0.5) {
                parser.clearVars();
                parser.addVar("x", x);

                double y = parser.parseString();
                // double y=Math.sin(x);

                if (c == 0) {
                    oldX = x;
                    oldY = y;
                }
                c++;
                g.drawLine(mitteX + (int) (x * zoomX), mitteY - (int) (y * zoomY), mitteX + (int) (oldX * zoomX),
                        mitteY - (int) (oldY * zoomY));

                oldX = x;
                oldY = y;

            }

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}