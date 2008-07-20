package marytts.tools.analysis;

import gov.noaa.pmel.sgt.dm.SGTData;
import gov.noaa.pmel.sgt.dm.SimpleLine;
import gov.noaa.pmel.sgt.dm.SGTMetaData;
import gov.noaa.pmel.sgt.swing.JPlotLayout;

import marytts.util.math.Histogram;
/**
 *
 * @author  sathish
 */
public class DrawHistogram extends javax.swing.JFrame {
  
    public JPlotLayout layout_;
    public Histogram histData;
    
    /** Creates new form DarwHistogram */
    public DrawHistogram(double[] data){
        initComponents();
        this.setHistogramData(data, 25);
        this.drawFirstHistogram(25);
    }
    
    public DrawHistogram(double[] data, int nbins){
        initComponents();
        this.setHistogramData(data, nbins);
        this.drawFirstHistogram(nbins);
    }
   
    
    private void drawFirstHistogram(int nbins){
        try{
            layout_ = new JPlotLayout(false, false, false,
                                  "Trajectory data",
                                  null,
                                  false);
            layout_ = this.plotHistogram(layout_);
            this.getHistogram().resize(histogram.size());
            bandwidth.setValue(nbins);
            histogram.add(this.getHistogram());
            histogram.updateUI();
            //System.out.println("Mean: "+histData.mean());
            //System.out.println("Variance: "+histData.variance());
            //System.out.println("Max: "+histData.max());
            //System.out.println("Min: "+histData.min());
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        histogram = new javax.swing.JPanel();
        controls = new javax.swing.JPanel();
        bandwidth = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        histogram.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Histogram"));

        javax.swing.GroupLayout histogramLayout = new javax.swing.GroupLayout(histogram);
        histogram.setLayout(histogramLayout);
        histogramLayout.setHorizontalGroup(
            histogramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        histogramLayout.setVerticalGroup(
            histogramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        bandwidth.setMaximum(200);
        bandwidth.setMinimum(5);
        bandwidth.setValue(25);
        bandwidth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                changeBandWidth(evt);
            }
        });

        jLabel1.setText("No. of Bins :");

        jLabel2.setText("25");

        javax.swing.GroupLayout controlsLayout = new javax.swing.GroupLayout(controls);
        controls.setLayout(controlsLayout);
        controlsLayout.setHorizontalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsLayout.createSequentialGroup()
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bandwidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(controlsLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        controlsLayout.setVerticalGroup(
            controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsLayout.createSequentialGroup()
                .addComponent(bandwidth, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(controls, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(histogram, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(histogram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(controls, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void changeBandWidth(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_changeBandWidth
// TODO add your handling code here:
     int bwSlide = bandwidth.getValue();
     try{
        this.jLabel2.setText(""+bwSlide);
        this.rePlotHistogram(bwSlide);
        this.getHistogram().resize(histogram.size());
        histogram.add(this.getHistogram());
        histogram.updateUI();
        //this.setVisible(true);
        
    }
    catch(Exception e){
        System.err.println("Exception: "+e);
        e.printStackTrace();
    } 
     
}//GEN-LAST:event_changeBandWidth

 

  
 public void setHistogramData(double[] data, int nbins){
     this.histData = new Histogram(data, nbins);
 }
 
        
  public JPlotLayout plotHistogram(JPlotLayout layout){
        
        //layout = this.plotHistogram(layout_);
        /*
         * Batch changes to layout.
         */
        layout.setBatch(true);
        layout.setTitles("Hitogram Analysis",
                "",
                "");
        layout.setTitleHeightP(0.2, 0.2);
        //pack();
        SimpleLine sdata = new SimpleLine(histData.getSampleArray(), 
                histData.getHistArray()," Float " + "Hist1");
        SGTMetaData meta = new SGTMetaData("Values",
                "data",
                false,
                false);
        sdata.setXMetaData(meta);
        meta = new SGTMetaData("Histogram",
                "no. of occurrences",
                false,
                false);
        sdata.setYMetaData(meta);
        SGTData data = sdata;
        layout.addData(data);
        layout.setBatch(false);  
        return layout;
    }
    
    public void rePlotHistogram(int bandwidth){
        this.clearHistogram();
        histData.changeSettings(bandwidth);
        layout_ = this.plotHistogram(layout_);
    }
    
    public void clearHistogram(){
        layout_.clear();
    }
    
    public JPlotLayout getHistogram(){
        
        return layout_;
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider bandwidth;
    private javax.swing.JPanel controls;
    private javax.swing.JPanel histogram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

}