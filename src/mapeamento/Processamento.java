/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapeamento;

import java.util.Arrays;

/**
 *
 * @author Gus
 */
public class Processamento extends javax.swing.JPanel {

    /**
     * Creates new form Processamento
     */
   private PDI pdi;
   private Arquivo arq = new Arquivo(); 
   private String[] listaImgs;
   private final String newline = System.lineSeparator();
   
    public Processamento() {
        initComponents();
        iniciarProcessamento();
    }
    
    public void iniciarProcessamento() {
        new Thread() { 
           @Override public void run() {
               
               pdi= new PDI(arq);
               listaImgs = pdi.verificaNecessidade(area_Processamento1);
               
             
               if(listaImgs != null){
                   arq.escolheDir();
                   area_Processamento1.append("Path Escolhido: "+arq.getPath()+newline);
                   System.out.println("array: "+Arrays.toString(listaImgs));
                   
                   
                   //seta as imagens que estão no diretório
                   area_Processamento1.append("Setando a lista de imagens no diretório."+newline);
                   //pdi.setImagens(arq.abreArquivos(arq.getPath()));
                   pdi.setImagens(listaImgs);// seta somente as imagens que devem ser processadas e não todas.
                   
                   
                   //diminuir as imagens
                   label_Barra.setText("Redução das Imagens: 0%");
                   area_Processamento1.append("Diminuindo o tamanho das imagens a ser processadas..."+newline);
                   pdi.reduzDefinicaoLote(pdi.getImagens(),area_Processamento1, barra, label_Barra);
                   //processar e guardar no banco.
                   label_Barra.setText("Processando e Armazenando: 0%");
                   pdi.processarEArmazernar(pdi.getImagens(),11,0.6,0.05,2.0,0.0,0.0,area_Processamento1, area_Processamento2, barra, label_Barra);
                   area_Processamento1.append("PROCESSAMENTO FINALIZADO COM SUCESSO!"+newline);
                   area_Processamento1.setCaretPosition(area_Processamento1.getDocument().getLength());//cursoor ir para o final               
               }
               else{
                   area_Processamento1.setText(area_Processamento1.getText()+"Não há imagens a ser processada!\r\n");
                   area_Processamento2.setText(area_Processamento2.getText()+"Não há imagens a ser processada!\r\n");
                   System.out.println("Não há imagens a ser processada!");
               }
           }
        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        area_Processamento1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_Processamento2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        label_Barra = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();

        area_Processamento1.setEditable(false);
        area_Processamento1.setColumns(20);
        area_Processamento1.setRows(5);
        jScrollPane1.setViewportView(area_Processamento1);

        area_Processamento2.setEditable(false);
        area_Processamento2.setColumns(20);
        area_Processamento2.setRows(5);
        jScrollPane2.setViewportView(area_Processamento2);

        jLabel1.setText("Resultado:");

        label_Barra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Processamento de Imagens em Lote");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(barra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label_Barra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addGap(3, 3, 3)
                .addComponent(label_Barra, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_Processamento1;
    private javax.swing.JTextArea area_Processamento2;
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_Barra;
    // End of variables declaration//GEN-END:variables
}
