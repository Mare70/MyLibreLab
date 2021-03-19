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

package elements.circuit.interfacepackage.fourefours;/*
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
                                                                            * but WITHOUT ANY WARRANTY; without even the
                                                                            * implied warranty of
                                                                            * MERCHANTABILITY or FITNESS FOR A
                                                                            * PARTICULAR PURPOSE. See the
                                                                            * GNU General Public License for more
                                                                            * details.
                                                                            *
                                                                            * You should have received a copy of the GNU
                                                                            * General Public License
                                                                            * along with this program. If not, see
                                                                            * <http://www.gnu.org/licenses/>.
                                                                            *
                                                                            */

/**
 *
 * @author salafica
 */
class MyTimer extends Thread {

    public boolean stop = false;
    public PCIO owner;
    public int delay = 100;

    @Override
    public void run() {

        stop = false;
        while (!stop) {

            owner.send(new byte[] {'R', 'I', 'A'});

            owner.send(new byte[] {'A', '0'});
            owner.send(new byte[] {'A', '1'});
            owner.send(new byte[] {'A', '2'});
            owner.send(new byte[] {'A', '3'});


            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
            }
        }
    }


}