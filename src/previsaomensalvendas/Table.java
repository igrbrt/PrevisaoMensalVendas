/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package previsaomensalvendas;

/**
 *
 * @author Glaubos
 */
public class Table {

    private int rows;
    private int columms;
    private Double data[][];

    public Table(int r, int c) {
        this.rows = r;
        this.columms = c;
        this.data = new Double[rows][columms];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumms() {
        return columms;
    }

    public void setColumms(int columms) {
        this.columms = columms;
    }

    public Double[][] getData() {
        return data;
    }

    public void setData(Double[][] data) {
        this.data = data;
    }

    public void teste() {
    }
}
