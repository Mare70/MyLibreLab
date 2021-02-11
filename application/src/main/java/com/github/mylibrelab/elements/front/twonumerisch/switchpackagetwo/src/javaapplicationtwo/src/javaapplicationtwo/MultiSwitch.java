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

package com.github.mylibrelab.elements.front.twonumerisch.switchpackagetwo.src.javaapplicationtwo.src.javaapplicationtwo;/*
                                                                                                                          * Copyright
                                                                                                                          * (C)
                                                                                                                          * 2020
                                                                                                                          * MyLibreLab
                                                                                                                          * Based
                                                                                                                          * on
                                                                                                                          * MyOpenLab
                                                                                                                          * by
                                                                                                                          * Carmelo
                                                                                                                          * Salafia
                                                                                                                          * www
                                                                                                                          * .
                                                                                                                          * myopenlab
                                                                                                                          * .de
                                                                                                                          * Copyright
                                                                                                                          * (C)
                                                                                                                          * 2004
                                                                                                                          * Carmelo
                                                                                                                          * Salafia
                                                                                                                          * cswi
                                                                                                                          *
                                                                                                                          * @
                                                                                                                          * gmx
                                                                                                                          * .de
                                                                                                                          *
                                                                                                                          * This
                                                                                                                          * program
                                                                                                                          * is
                                                                                                                          * free
                                                                                                                          * software:
                                                                                                                          * you
                                                                                                                          * can
                                                                                                                          * redistribute
                                                                                                                          * it
                                                                                                                          * and
                                                                                                                          * /or
                                                                                                                          * modify
                                                                                                                          * it
                                                                                                                          * under
                                                                                                                          * the
                                                                                                                          * terms
                                                                                                                          * of
                                                                                                                          * the
                                                                                                                          * GNU
                                                                                                                          * General
                                                                                                                          * Public
                                                                                                                          * License
                                                                                                                          * as
                                                                                                                          * published
                                                                                                                          * by
                                                                                                                          * the
                                                                                                                          * Free
                                                                                                                          * Software
                                                                                                                          * Foundation,
                                                                                                                          * either
                                                                                                                          * version
                                                                                                                          * 3
                                                                                                                          * of
                                                                                                                          * the
                                                                                                                          * License,
                                                                                                                          * or
                                                                                                                          * (at
                                                                                                                          * your
                                                                                                                          * option)
                                                                                                                          * any
                                                                                                                          * later
                                                                                                                          * version.
                                                                                                                          *
                                                                                                                          * This
                                                                                                                          * program
                                                                                                                          * is
                                                                                                                          * distributed
                                                                                                                          * in
                                                                                                                          * the
                                                                                                                          * hope
                                                                                                                          * that
                                                                                                                          * it
                                                                                                                          * will
                                                                                                                          * be
                                                                                                                          * useful,
                                                                                                                          * but
                                                                                                                          * WITHOUT
                                                                                                                          * ANY
                                                                                                                          * WARRANTY;
                                                                                                                          * without
                                                                                                                          * even
                                                                                                                          * the
                                                                                                                          * implied
                                                                                                                          * warranty
                                                                                                                          * of
                                                                                                                          * MERCHANTABILITY
                                                                                                                          * or
                                                                                                                          * FITNESS
                                                                                                                          * FOR
                                                                                                                          * A
                                                                                                                          * PARTICULAR
                                                                                                                          * PURPOSE.
                                                                                                                          * See
                                                                                                                          * the
                                                                                                                          * GNU
                                                                                                                          * General
                                                                                                                          * Public
                                                                                                                          * License
                                                                                                                          * for
                                                                                                                          * more
                                                                                                                          * details.
                                                                                                                          *
                                                                                                                          * You
                                                                                                                          * should
                                                                                                                          * have
                                                                                                                          * received
                                                                                                                          * a
                                                                                                                          * copy
                                                                                                                          * of
                                                                                                                          * the
                                                                                                                          * GNU
                                                                                                                          * General
                                                                                                                          * Public
                                                                                                                          * License
                                                                                                                          * along
                                                                                                                          * with
                                                                                                                          * this
                                                                                                                          * program.
                                                                                                                          * If
                                                                                                                          * not,
                                                                                                                          * see
                                                                                                                          * <http
                                                                                                                          * :
                                                                                                                          * /
                                                                                                                          * /
                                                                                                                          * www
                                                                                                                          * .
                                                                                                                          * gnu
                                                                                                                          * .
                                                                                                                          * org
                                                                                                                          * /
                                                                                                                          * licenses
                                                                                                                          * /
                                                                                                                          * >
                                                                                                                          * .
                                                                                                                          *
                                                                                                                          */

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Homer
 */
public class MultiSwitch extends javax.swing.JPanel {
    private final int anzahlStellungen = 4;
    private int status = 0;

    /**
     * Creates new form MultiSwitch
     */
    public MultiSwitch() {
        initComponents();
        setBackground(Color.DARK_GRAY);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt)// GEN-FIRST:event_formMousePressed
    {// GEN-HEADEREND:event_formMousePressed
        status++;

        if (status >= anzahlStellungen) status = 0;
        repaint();
    }// GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void drawRect(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, width, height);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, width, height);

        g.setColor(Color.BLACK);
        double fx = ((double) width) / 100.0;

        int w = (int) (fx * 10);

        double f = height / 4.0;
        for (int i = 1; i < 4; i++) {
            int d = y + (int) (i * f);
            g.drawLine(x + w, d, x + width - w, d);
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int d = getHeight() / anzahlStellungen;

        double fx = ((double) getWidth()) / 100.0;

        int x = (int) (fx * 5);

        int y = status * d + x;

        drawRect(g, x, y, getWidth() - x * 2, d - x * 2);
    }

}