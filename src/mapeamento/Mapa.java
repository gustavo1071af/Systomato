/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapeamento;
    
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import mapeamento.DAO.TalhaoDAO;
import mapeamento.DAO.TomatesDAO;
import mapeamento.beans.ImagemProcessada;
import mapeamento.beans.Talhao;
import mapeamento.beans.Tomates;


/**
 *
 * @author Gus
 */
public class Mapa extends javax.swing.JPanel {


    private MeuJPanel matrizpainel[][];
    private String talhao;
    private int x;
    private int y;
    static String formatoDataBr = "dd/MM/yyyy";


    /**
     * Creates new form Mapa
     * @param talhao_Selecionada
     */
    public Mapa(String talhao_Selecionada) {
        initComponents();
        System.out.println(talhao_Selecionada);
        this.talhao = talhao_Selecionada;
        List<Tomates> tomatesDoTalhao = TomatesDAO.getTomatesComImagensProcesadasPorTalhao(talhao);

        //SISTOM-1
        Talhao beanTalhao = TalhaoDAO.get(talhao);

        int qtd_Ruas = beanTalhao.getQtdRuas();
        int qtd_TomatesPorLinha = beanTalhao.getQtd_TomatesPorLinhas();

        //considerando que cada rua tem 2 linhas.
        this.y = qtd_Ruas * 2;
        this.x = qtd_TomatesPorLinha;

        //aplica o resultado para fazer o grid
        matrizpainel = new MeuJPanel[x][y];

        GridLayout grid = new GridLayout(x, y);
        setLayout(grid);
        for (int x = 0; x < this.x; x++) {
            for (int y = 0; y < this.y; y++) {

                matrizpainel[x][y] = new MeuJPanel();
                //SISTOM-1
                matrizpainel[x][y].setBackground(new Color(0, 128, 0));//Green
                matrizpainel[x][y].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));//preto
                populaPainelComTomate(matrizpainel[x][y], tomatesDoTalhao, x, y);

                add(matrizpainel[x][y]);
            }
        }

    }

    public boolean isInt(String v) {
        try {
            Integer.parseInt(v);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //SISTOM-1
    private void populaPainelComTomate(MeuJPanel meuJPanel, List<Tomates> tomatesDoTalhao, int x1, int y1) {
        final MeuJPanel painelAux = meuJPanel;
        for (Tomates tomate : tomatesDoTalhao) {
            int numTom = tomate.getNumTom();
            int coluna = tomate.getColuna();
            // a adição do 1 no y1 e x1 é porque o for q cria os componentes começa com zero, e se mudar da erro pois vai falta 1 grid
            if (coluna == y1+1 && numTom == x1+1) {
                JLabel label = new JLabel();
                label.setText("*");
                painelAux.add(label);
                painelAux.setTom(tomate);
                //painelAux.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
                meuJPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {

                        final JFrame parent = new JFrame();
                        TomateDialog t1 = new TomateDialog(parent, true, painelAux.getTom());
                        t1.setSize(800, 600);
                        //System.out.println(painelAux.getTom().getNomeArquivo());
                        
                        final SimpleDateFormat formatoBr = new SimpleDateFormat(formatoDataBr);
                        t1.setTitle("Rua=" + painelAux.getTom().getRua() + " Linha=" + painelAux.getTom().getLinha()
                                + " Numtom=" + painelAux.getTom().getNumTom() + " Data=" + formatoBr.format(painelAux.getTom().getData()));
                        t1.setVisible(true);
                        t1.setLocationRelativeTo(null);

                    }

                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        //evento passar mouse aqui

                        painelAux.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

                        //matrizpainel[x][y].setBackground(Color.red);
                    }

                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        //evento sair do target aqui
                        painelAux.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
                    }

                });
                //final evento
                //escolher cor de acordo com o estado
                ImagemProcessada imagemProcessada = tomate.getImagemProcessada();
                int estado = imagemProcessada.getEstado();
                switch (estado) {
                    case 1: {
                        meuJPanel.setBackground(new Color(0, 128, 0));
                        break;
                    }//Green
                    case 2: {
                        meuJPanel.setBackground(new Color(144, 238, 144));
                        break;
                    }//LightGreen
                    case 3: {
                        meuJPanel.setBackground(new Color(255, 255, 0));
                        break;
                    }//Yellow
                    case 4: {
                        meuJPanel.setBackground(new Color(255, 165, 0));
                        break;
                    }//Orange
                    case 5: {
                        meuJPanel.setBackground(new Color(255, 140, 0));
                        break;
                    }//DarkOrange
                    case 6: {
                        meuJPanel.setBackground(new Color(255, 69, 0));
                        break;
                    }//OrangeRed
                    default: {
                        meuJPanel.setBackground(new Color(0, 128, 0));
                        break;
                    }//Green
                }//switch
              
            }//if
            
        }//for     
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
