/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;


//import java.util.Timer;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class proyecto extends javax.swing.JFrame {

    public Parqueo[] sotano1;
    public Parqueo[] sotano2;
    public Parqueo[] sotano3;
    public long tarifa;
    public long fraccion;
    public String archivo;

    /**
     * Creates new form proyecto
     */
    public proyecto() {
        initComponents();

        this.tarifa   = 411; // Centavos (por redondeo)
        //this.fraccion = 30*60; // Media hora
        this.fraccion = 10; // Pruebas
        this.archivo  = "registro.log";

        // Inicialización de parqueos
        this.sotano1 = new Parqueo[12];
        this.sotano2 = new Parqueo[9];
        this.sotano3 = new Parqueo[11];
        int i;
        for(i=0; i < sotano1.length; i++){
            this.sotano1[i] = new Parqueo(1,i+1,this.fraccion);
        }
        for(i=0; i < sotano2.length; i++){
            this.sotano2[i] = new Parqueo(2,i+1,this.fraccion);
        }
        for(i=0; i < sotano3.length; i++){
            this.sotano3[i] = new Parqueo(3,i+1,this.fraccion);
        }

        // Marcajes iniciales
        this.contarParqueos();
        this.marcarParqueos();
    }

    private void marcarParqueos() {
        this.Parqueo101.setBackground(this.sotano1[0].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo102.setBackground(this.sotano1[1].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo103.setBackground(this.sotano1[2].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo104.setBackground(this.sotano1[3].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo105.setBackground(this.sotano1[4].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo106.setBackground(this.sotano1[5].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo107.setBackground(this.sotano1[6].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo108.setBackground(this.sotano1[7].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo109.setBackground(this.sotano1[8].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo110.setBackground(this.sotano1[9].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo111.setBackground(this.sotano1[10].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo112.setBackground(this.sotano1[11].libre() == 1?Color.GREEN:Color.RED);

        this.Parqueo201.setBackground(this.sotano2[0].libre ()== 1?Color.GREEN:Color.RED);
        this.Parqueo202.setBackground(this.sotano2[1].libre ()== 1?Color.GREEN:Color.RED);
        this.Parqueo203.setBackground(this.sotano2[2].libre ()== 1?Color.GREEN:Color.RED);
        this.Parqueo204.setBackground(this.sotano2[3].libre ()== 1?Color.GREEN:Color.RED);
        this.Parqueo205.setBackground(this.sotano2[4].libre ()== 1?Color.GREEN:Color.RED);
        this.Parqueo206.setBackground(this.sotano2[5].libre ()== 1?Color.GREEN:Color.RED);
        this.Parqueo207.setBackground(this.sotano2[6].libre ()== 1?Color.GREEN:Color.RED);
        this.Parqueo208.setBackground(this.sotano2[7].libre ()== 1?Color.GREEN:Color.RED);
        this.Parqueo209.setBackground(this.sotano2[8].libre ()== 1?Color.GREEN:Color.RED);

        this.Parqueo301.setBackground(this.sotano3[0].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo302.setBackground(this.sotano3[1].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo303.setBackground(this.sotano3[2].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo304.setBackground(this.sotano3[3].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo305.setBackground(this.sotano3[4].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo306.setBackground(this.sotano3[5].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo307.setBackground(this.sotano3[6].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo308.setBackground(this.sotano3[7].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo309.setBackground(this.sotano3[8].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo310.setBackground(this.sotano3[9].libre() == 1?Color.GREEN:Color.RED);
        this.Parqueo311.setBackground(this.sotano3[10].libre() == 1?Color.GREEN:Color.RED);

    }

    private int contarParqueos () {
        int libre1 = 0;
        int libre2 = 0;
        int libre3 = 0;
        int libres = 0;

        for(int i = 0 ; i < this.sotano1.length; i++) {
            libre1+= this.sotano1[i].libre();
        }
        for(int i = 0 ; i < this.sotano2.length; i++) {
            libre2+= this.sotano2[i].libre();
        }
        for(int i = 0 ; i < this.sotano3.length; i++) {
            libre3+= this.sotano3[i].libre();
        }
        libres = libre1+libre2+libre3;

        lSotano1Libre.setText(Integer.toString(libre1));
        lSotano1ocupado.setText(Integer.toString(this.sotano1.length-libre1));
        lSotano2libre.setText(Integer.toString(libre2));
        lSotano2ocupado.setText(Integer.toString(this.sotano2.length-libre2));
        lSotano3libre.setText(Integer.toString(libre3));
        lSotano3ocupado.setText(Integer.toString(this.sotano3.length-libre3));

        lTotalLibre.setText(Integer.toString(libres));
        lTotalOcupado.setText(Integer.toString(this.sotano1.length+this.sotano2.length+this.sotano3.length-libres));

        lSotano1Libre.repaint();
        lSotano1ocupado.repaint();
        lSotano2libre.repaint();
        lSotano2ocupado.repaint();
        lSotano3libre.repaint();
        lSotano3ocupado.repaint();

        lTotalLibre.repaint();
        lTotalOcupado.repaint();

        return libres;
    }

    private Parqueo accionParqueo(Parqueo parqueo){
        if( parqueo.libre() == 1){
            if(JOptionPane.showConfirmDialog (null,"¿Desea asignar este parqueo?",null,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                parqueo.marcarEntrada();
                this.contarParqueos();
            }
        } else {
            if(JOptionPane.showConfirmDialog (null,"¿Desea pagar este parqueo?",null,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                parqueo.marcarSalida();
                long tiempo = parqueo.calcularTiempo();
                String texto = "Parqueo El Descanso\n\n";
                texto+="Hora de entrada: " + parqueo.getStingEntrada()+"\n";
                texto+="Hora de salida:  " + parqueo.getStingSalida()+"\n";
                texto+="Tiempo total:    " + parqueo.getStringTiempo(tiempo)+"\n";
                texto+="Total a cancelar: Q "+ String.format("%.2f",parqueo.calcularCobro(this.tarifa)/100) +"\n";
                parqueo.escribirArchivo(this.archivo,this.tarifa);
                parqueo.limpiar();
                this.contarParqueos();
                tTicketText.setText(texto);
                dTicket.setModal(true);
                dTicket.setVisible(true);
            }
        }
        return parqueo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fSotano1 = new javax.swing.JFrame();
        lSotano1titulo = new javax.swing.JLabel();
        Parqueo101 = new javax.swing.JButton();
        Parqueo102 = new javax.swing.JButton();
        Parqueo103 = new javax.swing.JButton();
        Parqueo104 = new javax.swing.JButton();
        Parqueo105 = new javax.swing.JButton();
        Parqueo106 = new javax.swing.JButton();
        Parqueo107 = new javax.swing.JButton();
        Parqueo108 = new javax.swing.JButton();
        Parqueo109 = new javax.swing.JButton();
        Parqueo110 = new javax.swing.JButton();
        Parqueo111 = new javax.swing.JButton();
        Parqueo112 = new javax.swing.JButton();
        parqueo1regresar = new javax.swing.JButton();
        fSotano2 = new javax.swing.JFrame();
        lSotano2titulo = new javax.swing.JLabel();
        Parqueo201 = new javax.swing.JButton();
        Parqueo202 = new javax.swing.JButton();
        Parqueo203 = new javax.swing.JButton();
        Parqueo204 = new javax.swing.JButton();
        Parqueo205 = new javax.swing.JButton();
        Parqueo206 = new javax.swing.JButton();
        Parqueo207 = new javax.swing.JButton();
        Parqueo208 = new javax.swing.JButton();
        Parqueo209 = new javax.swing.JButton();
        parqueo2regresar = new javax.swing.JButton();
        fSotano3 = new javax.swing.JFrame();
        lSotano3titulo = new javax.swing.JLabel();
        Parqueo301 = new javax.swing.JButton();
        Parqueo302 = new javax.swing.JButton();
        Parqueo303 = new javax.swing.JButton();
        Parqueo304 = new javax.swing.JButton();
        Parqueo305 = new javax.swing.JButton();
        Parqueo306 = new javax.swing.JButton();
        Parqueo307 = new javax.swing.JButton();
        Parqueo308 = new javax.swing.JButton();
        Parqueo309 = new javax.swing.JButton();
        Parqueo310 = new javax.swing.JButton();
        Parqueo311 = new javax.swing.JButton();
        parqueo3regresar = new javax.swing.JButton();
        dTicket = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTicketText = new javax.swing.JTextArea();
        bCerrarTicket = new javax.swing.JButton();
        fStats = new javax.swing.JFrame();
        fStatsRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        statText1 = new javax.swing.JTextField();
        statText2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        parqueo1ir = new javax.swing.JButton();
        parqueo2ir = new javax.swing.JButton();
        parqueo3ir = new javax.swing.JButton();
        lSotano1Libre = new javax.swing.JLabel();
        lSotano1ocupado = new javax.swing.JLabel();
        lSotano2libre = new javax.swing.JLabel();
        lSotano2ocupado = new javax.swing.JLabel();
        lSotano3libre = new javax.swing.JLabel();
        lSotano3ocupado = new javax.swing.JLabel();
        lTotalLibre = new javax.swing.JLabel();
        lTotalOcupado = new javax.swing.JLabel();
        bStats = new javax.swing.JButton();

        fSotano1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        fSotano1.setMinimumSize(new java.awt.Dimension(450, 300));
        fSotano1.setSize(new java.awt.Dimension(450, 300));

        lSotano1titulo.setText("Sotano 1");

        Parqueo101.setText("01");
        Parqueo101.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo101MouseClicked(evt);
            }
        });

        Parqueo102.setText("02");
        Parqueo102.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo102MouseClicked(evt);
            }
        });

        Parqueo103.setText("03");
        Parqueo103.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo103MouseClicked(evt);
            }
        });

        Parqueo104.setText("04");
        Parqueo104.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo104MouseClicked(evt);
            }
        });

        Parqueo105.setText("05");
        Parqueo105.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo105MouseClicked(evt);
            }
        });

        Parqueo106.setText("06");
        Parqueo106.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo106MouseClicked(evt);
            }
        });

        Parqueo107.setText("07");
        Parqueo107.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo107MouseClicked(evt);
            }
        });

        Parqueo108.setText("08");
        Parqueo108.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo108MouseClicked(evt);
            }
        });

        Parqueo109.setText("09");
        Parqueo109.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo109MouseClicked(evt);
            }
        });

        Parqueo110.setText("10");
        Parqueo110.setPreferredSize(new java.awt.Dimension(50, 75));
        Parqueo110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo110MouseClicked(evt);
            }
        });

        Parqueo111.setText("11");
        Parqueo111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo111MouseClicked(evt);
            }
        });

        Parqueo112.setText("12");
        Parqueo112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo112MouseClicked(evt);
            }
        });

        parqueo1regresar.setText("Regresar");
        parqueo1regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parqueo1regresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fSotano1Layout = new javax.swing.GroupLayout(fSotano1.getContentPane());
        fSotano1.getContentPane().setLayout(fSotano1Layout);
        fSotano1Layout.setHorizontalGroup(
            fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lSotano1titulo)
                    .addGroup(fSotano1Layout.createSequentialGroup()
                        .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fSotano1Layout.createSequentialGroup()
                                .addComponent(Parqueo107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fSotano1Layout.createSequentialGroup()
                                .addComponent(Parqueo101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Parqueo106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Parqueo112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(parqueo1regresar))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        fSotano1Layout.setVerticalGroup(
            fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSotano1titulo)
                .addGap(18, 18, 18)
                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Parqueo101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fSotano1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Parqueo109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo111, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo112, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(parqueo1regresar)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        fSotano2.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        fSotano2.setMinimumSize(new java.awt.Dimension(450, 300));
        fSotano2.setSize(new java.awt.Dimension(450, 300));

        lSotano2titulo.setText("Sotano 2");

        Parqueo201.setText("01");
        Parqueo201.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo201MouseClicked(evt);
            }
        });

        Parqueo202.setText("02");
        Parqueo202.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo202MouseClicked(evt);
            }
        });

        Parqueo203.setText("03");
        Parqueo203.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo203MouseClicked(evt);
            }
        });

        Parqueo204.setText("04");
        Parqueo204.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo204MouseClicked(evt);
            }
        });

        Parqueo205.setText("05");
        Parqueo205.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo205MouseClicked(evt);
            }
        });

        Parqueo206.setText("06");
        Parqueo206.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo206MouseClicked(evt);
            }
        });

        Parqueo207.setText("07");
        Parqueo207.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo207MouseClicked(evt);
            }
        });

        Parqueo208.setText("08");
        Parqueo208.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo208MouseClicked(evt);
            }
        });

        Parqueo209.setText("09");
        Parqueo209.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo209MouseClicked(evt);
            }
        });

        parqueo2regresar.setText("Regresar");
        parqueo2regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parqueo2regresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fSotano2Layout = new javax.swing.GroupLayout(fSotano2.getContentPane());
        fSotano2.getContentPane().setLayout(fSotano2Layout);
        fSotano2Layout.setHorizontalGroup(
            fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lSotano2titulo)
                    .addGroup(fSotano2Layout.createSequentialGroup()
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parqueo206, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo201, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parqueo207, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo202, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parqueo208, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo203, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parqueo209, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fSotano2Layout.createSequentialGroup()
                                .addComponent(Parqueo204, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Parqueo205, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(parqueo2regresar))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        fSotano2Layout.setVerticalGroup(
            fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSotano2titulo)
                .addGap(18, 18, 18)
                .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Parqueo201, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo203, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Parqueo204, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Parqueo205, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Parqueo202, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fSotano2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Parqueo206, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo208, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo209, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo207, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(parqueo2regresar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        fSotano3.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        fSotano3.setMaximumSize(new java.awt.Dimension(450, 300));
        fSotano3.setMinimumSize(new java.awt.Dimension(450, 300));
        fSotano3.setPreferredSize(new java.awt.Dimension(450, 300));
        fSotano3.setSize(new java.awt.Dimension(450, 300));

        lSotano3titulo.setText("Sotano 3");

        Parqueo301.setText("01");
        Parqueo301.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo301MouseClicked(evt);
            }
        });

        Parqueo302.setText("02");
        Parqueo302.setToolTipText("");
        Parqueo302.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo302MouseClicked(evt);
            }
        });

        Parqueo303.setText("03");
        Parqueo303.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo303MouseClicked(evt);
            }
        });

        Parqueo304.setText("04");
        Parqueo304.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo304MouseClicked(evt);
            }
        });

        Parqueo305.setText("05");
        Parqueo305.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo305MouseClicked(evt);
            }
        });

        Parqueo306.setText("06");
        Parqueo306.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo306MouseClicked(evt);
            }
        });

        Parqueo307.setText("07");
        Parqueo307.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo307MouseClicked(evt);
            }
        });

        Parqueo308.setText("08");
        Parqueo308.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo308MouseClicked(evt);
            }
        });

        Parqueo309.setText("09");
        Parqueo309.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo309MouseClicked(evt);
            }
        });

        Parqueo310.setText("10");
        Parqueo310.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo310MouseClicked(evt);
            }
        });

        Parqueo311.setText("11");
        Parqueo311.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Parqueo311MouseClicked(evt);
            }
        });

        parqueo3regresar.setText("Regresar");
        parqueo3regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parqueo3regresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fSotano3Layout = new javax.swing.GroupLayout(fSotano3.getContentPane());
        fSotano3.getContentPane().setLayout(fSotano3Layout);
        fSotano3Layout.setHorizontalGroup(
            fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fSotano3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(Parqueo301, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo302, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo303, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo304, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo305, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lSotano3titulo)
                    .addGroup(fSotano3Layout.createSequentialGroup()
                        .addComponent(Parqueo306, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo307, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo308, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo309, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo310, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Parqueo311, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(parqueo3regresar))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        fSotano3Layout.setVerticalGroup(
            fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fSotano3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSotano3titulo)
                .addGap(18, 18, 18)
                .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Parqueo305, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Parqueo301, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Parqueo303, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Parqueo304, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Parqueo302, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(fSotano3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Parqueo306, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Parqueo307, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Parqueo309, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Parqueo310, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Parqueo311, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Parqueo308, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(parqueo3regresar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        dTicket.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        dTicket.setMinimumSize(new java.awt.Dimension(400, 300));
        dTicket.setResizable(false);
        dTicket.setSize(new java.awt.Dimension(400, 300));

        tTicketText.setColumns(20);
        tTicketText.setRows(5);
        jScrollPane2.setViewportView(tTicketText);

        bCerrarTicket.setText("Cerrar");
        bCerrarTicket.setMaximumSize(new java.awt.Dimension(100, 25));
        bCerrarTicket.setMinimumSize(new java.awt.Dimension(100, 25));
        bCerrarTicket.setPreferredSize(new java.awt.Dimension(100, 25));
        bCerrarTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bCerrarTicketMouseClicked(evt);
            }
        });
        bCerrarTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dTicketLayout = new javax.swing.GroupLayout(dTicket.getContentPane());
        dTicket.getContentPane().setLayout(dTicketLayout);
        dTicketLayout.setHorizontalGroup(
            dTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(dTicketLayout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(bCerrarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        dTicketLayout.setVerticalGroup(
            dTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCerrarTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fStats.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        fStats.setMinimumSize(new java.awt.Dimension(425, 400));
        fStats.setResizable(false);
        fStats.setSize(new java.awt.Dimension(425, 400));

        fStatsRegresar.setText("Regresar");
        fStatsRegresar.setMaximumSize(new java.awt.Dimension(100, 25));
        fStatsRegresar.setMinimumSize(new java.awt.Dimension(100, 25));
        fStatsRegresar.setPreferredSize(new java.awt.Dimension(100, 25));
        fStatsRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fStatsRegresarMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Usuarios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Horas de mas vehiculos");

        statText1.setEditable(false);

        statText2.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Estadísticas");

        javax.swing.GroupLayout fStatsLayout = new javax.swing.GroupLayout(fStats.getContentPane());
        fStats.getContentPane().setLayout(fStatsLayout);
        fStatsLayout.setHorizontalGroup(
            fStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fStatsLayout.createSequentialGroup()
                .addGroup(fStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fStatsLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(fStatsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statText1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statText2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(fStatsRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        fStatsLayout.setVerticalGroup(
            fStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fStatsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(fStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(statText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fStatsRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        parqueo1ir.setToolTipText("");
        parqueo1ir.setLabel("Sotano 1");
        parqueo1ir.setMaximumSize(new java.awt.Dimension(100, 25));
        parqueo1ir.setMinimumSize(new java.awt.Dimension(100, 25));
        parqueo1ir.setPreferredSize(new java.awt.Dimension(100, 25));
        parqueo1ir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parqueo1irMouseClicked(evt);
            }
        });

        parqueo2ir.setLabel("Sotano 2");
        parqueo2ir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parqueo2irMouseClicked(evt);
            }
        });

        parqueo3ir.setLabel("Sotano 3");
        parqueo3ir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parqueo3irMouseClicked(evt);
            }
        });

        lSotano1Libre.setBackground(new java.awt.Color(0, 255, 0));
        lSotano1Libre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano1Libre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano1Libre.setText("0");
        lSotano1Libre.setToolTipText("");
        lSotano1Libre.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano1Libre.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano1Libre.setName(""); // NOI18N
        lSotano1Libre.setOpaque(true);
        lSotano1Libre.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano1ocupado.setBackground(new java.awt.Color(255, 0, 0));
        lSotano1ocupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano1ocupado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano1ocupado.setText("0");
        lSotano1ocupado.setToolTipText("");
        lSotano1ocupado.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano1ocupado.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano1ocupado.setName(""); // NOI18N
        lSotano1ocupado.setOpaque(true);
        lSotano1ocupado.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano2libre.setBackground(new java.awt.Color(0, 255, 0));
        lSotano2libre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano2libre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano2libre.setText("0");
        lSotano2libre.setToolTipText("");
        lSotano2libre.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano2libre.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano2libre.setName(""); // NOI18N
        lSotano2libre.setOpaque(true);
        lSotano2libre.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano2ocupado.setBackground(new java.awt.Color(255, 0, 0));
        lSotano2ocupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano2ocupado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano2ocupado.setText("0");
        lSotano2ocupado.setToolTipText("");
        lSotano2ocupado.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano2ocupado.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano2ocupado.setName(""); // NOI18N
        lSotano2ocupado.setOpaque(true);
        lSotano2ocupado.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano3libre.setBackground(new java.awt.Color(0, 255, 0));
        lSotano3libre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano3libre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano3libre.setText("0");
        lSotano3libre.setToolTipText("");
        lSotano3libre.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano3libre.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano3libre.setName(""); // NOI18N
        lSotano3libre.setOpaque(true);
        lSotano3libre.setPreferredSize(new java.awt.Dimension(25, 17));

        lSotano3ocupado.setBackground(new java.awt.Color(255, 0, 0));
        lSotano3ocupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lSotano3ocupado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lSotano3ocupado.setText("0");
        lSotano3ocupado.setToolTipText("");
        lSotano3ocupado.setMaximumSize(new java.awt.Dimension(25, 17));
        lSotano3ocupado.setMinimumSize(new java.awt.Dimension(25, 17));
        lSotano3ocupado.setName(""); // NOI18N
        lSotano3ocupado.setOpaque(true);
        lSotano3ocupado.setPreferredSize(new java.awt.Dimension(25, 17));

        lTotalLibre.setBackground(new java.awt.Color(0, 255, 0));
        lTotalLibre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lTotalLibre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTotalLibre.setText("0");
        lTotalLibre.setToolTipText("");
        lTotalLibre.setMaximumSize(new java.awt.Dimension(25, 17));
        lTotalLibre.setMinimumSize(new java.awt.Dimension(25, 17));
        lTotalLibre.setName(""); // NOI18N
        lTotalLibre.setOpaque(true);
        lTotalLibre.setPreferredSize(new java.awt.Dimension(25, 17));

        lTotalOcupado.setBackground(new java.awt.Color(255, 0, 0));
        lTotalOcupado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lTotalOcupado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTotalOcupado.setText("0");
        lTotalOcupado.setToolTipText("");
        lTotalOcupado.setMaximumSize(new java.awt.Dimension(25, 17));
        lTotalOcupado.setMinimumSize(new java.awt.Dimension(25, 17));
        lTotalOcupado.setName(""); // NOI18N
        lTotalOcupado.setOpaque(true);
        lTotalOcupado.setPreferredSize(new java.awt.Dimension(25, 17));

        bStats.setLabel("Stats");
        bStats.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bStatsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bStats, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(parqueo1ir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parqueo2ir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(parqueo3ir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lTotalLibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lTotalOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lSotano3libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lSotano3ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lSotano2libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lSotano2ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lSotano1Libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lSotano1ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parqueo1ir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSotano1Libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSotano1ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parqueo2ir)
                    .addComponent(lSotano2libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSotano2ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parqueo3ir)
                    .addComponent(lSotano3libre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lSotano3ocupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTotalLibre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lTotalOcupado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        bStats.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void parqueo1irMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parqueo1irMouseClicked
        this.setVisible(false);
        fSotano1.setVisible(true);
    }//GEN-LAST:event_parqueo1irMouseClicked

    private void parqueo2irMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parqueo2irMouseClicked
        this.setVisible(false);
        fSotano2.setVisible(true);
    }//GEN-LAST:event_parqueo2irMouseClicked

    private void parqueo3irMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parqueo3irMouseClicked
        this.setVisible(false);
        fSotano3.setVisible(true);
    }//GEN-LAST:event_parqueo3irMouseClicked

    private void parqueo1regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parqueo1regresarMouseClicked
        this.contarParqueos();
        fSotano1.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_parqueo1regresarMouseClicked

    private void parqueo2regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parqueo2regresarMouseClicked
        this.contarParqueos();
        fSotano2.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_parqueo2regresarMouseClicked

    private void parqueo3regresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parqueo3regresarMouseClicked
        this.contarParqueos();
        fSotano3.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_parqueo3regresarMouseClicked

    private void bStatsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bStatsMouseClicked
        stats estadisticas = new stats();
        String[] registro = new String[6];
        String linea;

        try{
            BufferedReader br = new BufferedReader(new FileReader(this.archivo));
            while ( (linea = br.readLine() ) != null) {
                registro = linea.split("\\|");
                estadisticas.procesarRegistro(Long.parseLong(registro[2]));
            }
            br.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No se puede encontrar el archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se puede leer el archivo");
        }

        estadisticas.ordenarFechas();
        estadisticas.horasMaximas();

        for(int i = 0; i < estadisticas.registros; i++){
            jTable1.setValueAt(estadisticas.fechas[i], i, 0);
            jTable1.setValueAt(estadisticas.autos[i],  i, 1);
        }
        statText1.setText(String.valueOf(estadisticas.maxHoras[0]));
        statText2.setText(String.valueOf(estadisticas.maxHoras[1]));

/*
        for(int i = 0; i < 24; i++){
            jTable1.setValueAt(i, i, 0);
            jTable1.setValueAt(String.valueOf(estadisticas.horas[i]), i, 1);
        }
//*/

        this.setVisible(false);
        fStats.setVisible(true);
    }//GEN-LAST:event_bStatsMouseClicked

    private void fStatsRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fStatsRegresarMouseClicked
        for(int i = 0;i < jTable1.getRowCount();i++){
            jTable1.setValueAt("", i, 0);
            jTable1.setValueAt("", i, 1);
        }
        statText1.setText("");
        statText2.setText("");

        fStats.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_fStatsRegresarMouseClicked

    private void bCerrarTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bCerrarTicketMouseClicked
        dTicket.setModal(false);
        dTicket.setVisible(false);
    }//GEN-LAST:event_bCerrarTicketMouseClicked

    private void Parqueo101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo101MouseClicked
        this.sotano1[0] = this.accionParqueo(this.sotano1[0]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo101MouseClicked

    private void Parqueo102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo102MouseClicked
        this.sotano1[1] = this.accionParqueo(this.sotano1[1]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo102MouseClicked

    private void Parqueo103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo103MouseClicked
        this.sotano1[2] = this.accionParqueo(this.sotano1[2]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo103MouseClicked

    private void Parqueo104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo104MouseClicked
        this.sotano1[3] = this.accionParqueo(this.sotano1[3]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo104MouseClicked

    private void Parqueo105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo105MouseClicked
        this.sotano1[4] = this.accionParqueo(this.sotano1[4]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo105MouseClicked

    private void Parqueo106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo106MouseClicked
        this.sotano1[5] = this.accionParqueo(this.sotano1[5]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo106MouseClicked

    private void Parqueo107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo107MouseClicked
        this.sotano1[6] = this.accionParqueo(this.sotano1[6]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo107MouseClicked

    private void Parqueo108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo108MouseClicked
        this.sotano1[7] = this.accionParqueo(this.sotano1[7]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo108MouseClicked

    private void Parqueo109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo109MouseClicked
        this.sotano1[8] = this.accionParqueo(this.sotano1[8]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo109MouseClicked

    private void Parqueo110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo110MouseClicked
        this.sotano1[9] = this.accionParqueo(this.sotano1[9]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo110MouseClicked

    private void Parqueo111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo111MouseClicked
        this.sotano1[10] = this.accionParqueo(this.sotano1[10]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo111MouseClicked

    private void Parqueo112MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo112MouseClicked
        this.sotano1[11] = this.accionParqueo(this.sotano1[11]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo112MouseClicked

    private void Parqueo201MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo201MouseClicked
         this.sotano2[0] = this.accionParqueo (this.sotano2 [0]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo201MouseClicked

    private void Parqueo202MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo202MouseClicked
        this.sotano2[1] = this.accionParqueo (this.sotano2 [1]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo202MouseClicked

    private void Parqueo203MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo203MouseClicked
        this.sotano2[2] = this.accionParqueo (this.sotano2 [2]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo203MouseClicked

    private void Parqueo204MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo204MouseClicked
        this.sotano2[3] = this.accionParqueo (this.sotano2 [3]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo204MouseClicked

    private void Parqueo205MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo205MouseClicked
        this.sotano2[4] = this.accionParqueo (this.sotano2 [4]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo205MouseClicked

    private void Parqueo206MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo206MouseClicked
        this.sotano2[5] = this.accionParqueo (this.sotano2 [5]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo206MouseClicked

    private void Parqueo207MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo207MouseClicked
        this.sotano2[6] = this.accionParqueo (this.sotano2 [6]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo207MouseClicked

    private void Parqueo208MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo208MouseClicked
        this.sotano2[7] = this.accionParqueo (this.sotano2 [7]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo208MouseClicked

    private void Parqueo209MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo209MouseClicked
        this.sotano2[8] = this.accionParqueo (this.sotano2 [8]);
         this.marcarParqueos();
    }//GEN-LAST:event_Parqueo209MouseClicked

    private void Parqueo301MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo301MouseClicked
        this.sotano3[0] = this.accionParqueo(this.sotano3[0]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo301MouseClicked

    private void Parqueo302MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo302MouseClicked
        this.sotano3[1] = this.accionParqueo(this.sotano3[1]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo302MouseClicked

    private void Parqueo303MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo303MouseClicked
        this.sotano3[2] = this.accionParqueo(this.sotano3[2]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo303MouseClicked

    private void Parqueo304MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo304MouseClicked
        this.sotano3[3] = this.accionParqueo(this.sotano3[3]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo304MouseClicked

    private void Parqueo305MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo305MouseClicked
        this.sotano3[4] = this.accionParqueo(this.sotano3[4]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo305MouseClicked

    private void Parqueo306MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo306MouseClicked
        this.sotano3[5] = this.accionParqueo(this.sotano3[5]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo306MouseClicked

    private void Parqueo307MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo307MouseClicked
        this.sotano3[6] = this.accionParqueo(this.sotano3[6]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo307MouseClicked

    private void Parqueo308MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo308MouseClicked
        this.sotano3[7] = this.accionParqueo(this.sotano3[7]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo308MouseClicked

    private void Parqueo309MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo309MouseClicked
        this.sotano3[8] = this.accionParqueo(this.sotano3[8]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo309MouseClicked

    private void Parqueo310MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo310MouseClicked
        this.sotano3[9] = this.accionParqueo(this.sotano3[9]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo310MouseClicked

    private void Parqueo311MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Parqueo311MouseClicked
        this.sotano3[10] = this.accionParqueo(this.sotano3[10]);
        this.marcarParqueos();
    }//GEN-LAST:event_Parqueo311MouseClicked

    private void bCerrarTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bCerrarTicketActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Parqueo101;
    private javax.swing.JButton Parqueo102;
    private javax.swing.JButton Parqueo103;
    private javax.swing.JButton Parqueo104;
    private javax.swing.JButton Parqueo105;
    private javax.swing.JButton Parqueo106;
    private javax.swing.JButton Parqueo107;
    private javax.swing.JButton Parqueo108;
    private javax.swing.JButton Parqueo109;
    private javax.swing.JButton Parqueo110;
    private javax.swing.JButton Parqueo111;
    private javax.swing.JButton Parqueo112;
    private javax.swing.JButton Parqueo201;
    private javax.swing.JButton Parqueo202;
    private javax.swing.JButton Parqueo203;
    private javax.swing.JButton Parqueo204;
    private javax.swing.JButton Parqueo205;
    private javax.swing.JButton Parqueo206;
    private javax.swing.JButton Parqueo207;
    private javax.swing.JButton Parqueo208;
    private javax.swing.JButton Parqueo209;
    private javax.swing.JButton Parqueo301;
    private javax.swing.JButton Parqueo302;
    private javax.swing.JButton Parqueo303;
    private javax.swing.JButton Parqueo304;
    private javax.swing.JButton Parqueo305;
    private javax.swing.JButton Parqueo306;
    private javax.swing.JButton Parqueo307;
    private javax.swing.JButton Parqueo308;
    private javax.swing.JButton Parqueo309;
    private javax.swing.JButton Parqueo310;
    private javax.swing.JButton Parqueo311;
    private javax.swing.JButton bCerrarTicket;
    private javax.swing.JButton bStats;
    private javax.swing.JDialog dTicket;
    private javax.swing.JFrame fSotano1;
    private javax.swing.JFrame fSotano2;
    private javax.swing.JFrame fSotano3;
    private javax.swing.JFrame fStats;
    private javax.swing.JButton fStatsRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lSotano1Libre;
    private javax.swing.JLabel lSotano1ocupado;
    private javax.swing.JLabel lSotano1titulo;
    private javax.swing.JLabel lSotano2libre;
    private javax.swing.JLabel lSotano2ocupado;
    private javax.swing.JLabel lSotano2titulo;
    private javax.swing.JLabel lSotano3libre;
    private javax.swing.JLabel lSotano3ocupado;
    private javax.swing.JLabel lSotano3titulo;
    private javax.swing.JLabel lTotalLibre;
    private javax.swing.JLabel lTotalOcupado;
    private javax.swing.JButton parqueo1ir;
    private javax.swing.JButton parqueo1regresar;
    private javax.swing.JButton parqueo2ir;
    private javax.swing.JButton parqueo2regresar;
    private javax.swing.JButton parqueo3ir;
    private javax.swing.JButton parqueo3regresar;
    private javax.swing.JTextField statText1;
    private javax.swing.JTextField statText2;
    private javax.swing.JTextArea tTicketText;
    // End of variables declaration//GEN-END:variables
}
