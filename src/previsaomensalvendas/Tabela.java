/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package previsaomensalvendas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author klimaco
 */
public class Tabela {
    
    private List<Double> entradas;
    private List<Double> valoresPrevisao;
    
    public Tabela() {
        entradas = new ArrayList<>();
        valoresPrevisao = new ArrayList<>();
        try {
            
            double[][] valores = new double[12][12];
            
            
            File arq = new File("C:\\Users\\Igor\\Documents\\NetBeansProjects\\PrevisaoMensalVendas\\src\\previsaomensalvendas\\files\\tabela");
            
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String linha = "";
            int k = 0;
            while ((linha = bufferedReader.readLine()) != null) {
                
                String[] split = linha.split("  ");
                for (int w = 0; w < split.length; w++) {
                    
                    Double temp = Double.parseDouble(split[w]);
                    // dividido por 40 para discretizar o valor no intervalo -1, 1.
                    valores[k][w] = temp / 40.0;
                }
                k++;
            }
            //transformar a matriz de valores em uma lista
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < 12; i++) {
                    entradas.add(valores[i][j]);
                }
            }
            fileReader.close();
            bufferedReader.close();
            //separar os valores apenas para previsao
            for (int y = 84; y < entradas.size(); y++) {
                valoresPrevisao.add(entradas.get(y));
            }           
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public List<Double> getEntradas() {
        return entradas;
    }
    
    public void setEntradas(List<Double> entradas) {
        this.entradas = entradas;
    }

    public List<Double> getValoresPrevisao() {
        return valoresPrevisao;
    }

    public void setValoresPrevisao(List<Double> valoresPrevisao) {
        this.valoresPrevisao = valoresPrevisao;
    }
    
}
