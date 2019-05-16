/*
 * License
 * This software is distributed under the license  * 
 * Open to modification and redistribution * 
 */
package ui;

/**
 *
 * @author robert
 */

import dripirrimanager.DripIrriSystem;
public class DripWorksheet extends javax.swing.JFrame {

    DripIrriSystem systemConfiguration;
    /**
     * Creates new form DripWorksheet
     */
    public DripWorksheet() {
        initComponents();
    }
    /**
     * Overloaded constructor to enable printing of the system data
     */
    public DripWorksheet(DripIrriSystem dripConfiguration) {
        
        //initialize the UI
        initComponents();
        this.systemConfiguration = dripConfiguration;
        showSystemData();
    }
    
    /**
     * Show the Data in the UI
    */
    public void showSystemData() {
        /*SITE INRFORMATION*/
        nameOfSite.setText(systemConfiguration.getField().getFieldName());
        siteName.setText(systemConfiguration.getField().getFieldName());
        siteOwner.setText(systemConfiguration.getField().getFieldOwner());
        address.setText(systemConfiguration.getField().getFieldAddress());
        city.setText(systemConfiguration.getField().getFieldCity());
        contact.setText(systemConfiguration.getField().getFieldContact());
        if(systemConfiguration.getField().getFieldLength() == 0) {
            area.setText("Unspecified.");
        }
        else {
            String stringArea = formatFloat(systemConfiguration.getField().calculateFieldArea());
            area.setText(stringArea);
        }
        
        /*SOIL*/
        soilType.setText(systemConfiguration.getField().getFieldSoilType());
        waterSource.setText(systemConfiguration.getField().getFieldWaterSource());
        waterQuality.setText(systemConfiguration.getField().getFieldWaterQuality());
        
        /*CLIMATE*/
        climate.setText(systemConfiguration.getField().getFieldClimatePET().getClimate());
        
        /*CROP*/
        cropName.setText(systemConfiguration.getCrop().getCropName());
        
        if(systemConfiguration.getCrop().getPlantScheme().equals("dense")) { 
            waterRequirement.setText(formatFloat(systemConfiguration.calcWaterRequirement())+" inches/day");
        }
        else {
            waterRequirement.setText(formatFloat(systemConfiguration.calcWaterRequirement())+" gallons/day");
        }
        
        /*MAIN PIPE*/
        mainName.setText(systemConfiguration.getMainPipe().getPipeModelName());
        mainMaterial.setText(systemConfiguration.getMainPipe().getPipeMaterial());
        mainLength.setText(formatFloat(systemConfiguration.calcLengthOfMainPipe())+" m");
        /*SUB-MAIN PIPE*/ /* TO BE CHANGED*/
        submainName.setText(systemConfiguration.getSubmain().getPipeModelName());
        submainLength.setText("0.00"+" m");
        subMainMaterial.setText(systemConfiguration.getSubmain().getPipeMaterial());
        /*MANIFOLD PIPE*/ /* TO BE CHANGED*/
        manifoldName.setText(systemConfiguration.getManifold().getPipeModelName());
        manifoldLength.setText("0.00"+" m");
        manifoldMaterial.setText(systemConfiguration.getManifold().getPipeMaterial());
        
        /*LATERAL PIPE*/
        if(systemConfiguration.getLateralPipeType().equals("Dripline")) {
            // hide the emitter
            emitterLabel.hide();
            
            emitterFlowRateLabel.hide();
            emitterFlowRate.hide();
           
            emitterNameLabel.hide();
            emitterName.hide();
            
            emitterNumberLabel.hide();
            emitterNumber.hide();
            
            emitterSpacingLabel.hide();
            emitterSpacing.hide();
            
            emitterTypeLabel.hide();
            emitterTypeLabel.hide();
            
            // set the lateral tubing only to dripline
            typeOfLateral.setText("Dripline");
            lateralName.setText(systemConfiguration.getDripline().getPipeModelName());
            lateralFlowRate.setText(formatFloat(systemConfiguration.getDripline().getPipeFlowRate()) + "l/h");
            lateralLength.setText(formatFloat(systemConfiguration.calcLengthOfLateral()) + "l/h");
            lateralMaterial.setText(systemConfiguration.getDripline().getPipeMaterial());
            lateralNumber.setText(String.valueOf(systemConfiguration.calcNumberOfDriplines()));
            lateralSpacing.setText(formatFloat(systemConfiguration.calcActualLateralSpacing()));
            
        }
        else if(systemConfiguration.getLateralPipeType().equals("Blank Tubing")) {
            
            typeOfLateral.setText("Blank Tubing");
            // set the blank tubing
            lateralName.setText(systemConfiguration.getLateralPipe().getPipeModelName());
            lateralFlowRate.setText(formatFloat(systemConfiguration.getLateralPipe().getPipeFlowRate()) + "l/h");
            lateralLength.setText(formatFloat(systemConfiguration.calcLengthOfLateral()) + "l/h");
            lateralMaterial.setText(systemConfiguration.getLateralPipe().getPipeMaterial());
            lateralNumber.setText(String.valueOf(systemConfiguration.calcNumberOfDriplines()));
            lateralSpacing.setText(formatFloat(systemConfiguration.calcActualLateralSpacing()));
            
            // set the emitter too and then show it
            emitterFlowRate.setText(formatFloat(systemConfiguration.getEmitter().getEmitterFlowRate())+" l/h");
            emitterName.setText(systemConfiguration.getEmitter().getEmitterModelName());
            emitterNumber.setText(String.valueOf(systemConfiguration.calcNumberOfEmitters()));
            emitterSpacing.setText(formatFloat(systemConfiguration.calcEmitterSpacing()));
            emitterType.setText(systemConfiguration.getEmitter().getEmitterInletType());
        }
        
        /*SYSTEM RUNTIME*/
        systemRunTime.setText(formatFloat(systemConfiguration.calcSystemRuntime())+" H");
        
        
    }
    
    /** format the float to 2 decimal places and return it as a string*/
    private String formatFloat(float theFloat) {
        return String.format("%.2f", theFloat);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        headingPanel = new javax.swing.JPanel();
        nameOfSite = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        soilLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        siteNameLabel = new javax.swing.JLabel();
        siteOwnerLabel = new javax.swing.JLabel();
        siteNameLabel2 = new javax.swing.JLabel();
        siteNameLabel3 = new javax.swing.JLabel();
        siteName = new javax.swing.JLabel();
        siteNameLabel5 = new javax.swing.JLabel();
        siteOwner = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        area = new javax.swing.JLabel();
        city = new javax.swing.JLabel();
        siteNameLabel4 = new javax.swing.JLabel();
        siteNameLabel6 = new javax.swing.JLabel();
        siteNameLabel7 = new javax.swing.JLabel();
        siteNameLabel8 = new javax.swing.JLabel();
        siteNameLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        climate = new javax.swing.JLabel();
        soilType = new javax.swing.JLabel();
        waterSource = new javax.swing.JLabel();
        cropName = new javax.swing.JLabel();
        cropCategory = new javax.swing.JLabel();
        waterRequirement = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        siteNameLabel10 = new javax.swing.JLabel();
        siteNameLabel11 = new javax.swing.JLabel();
        siteNameLabel12 = new javax.swing.JLabel();
        mainName = new javax.swing.JLabel();
        submainName = new javax.swing.JLabel();
        manifoldName = new javax.swing.JLabel();
        mainMaterial = new javax.swing.JLabel();
        subMainMaterial = new javax.swing.JLabel();
        manifoldMaterial = new javax.swing.JLabel();
        mainLength = new javax.swing.JLabel();
        manifoldLength = new javax.swing.JLabel();
        submainLength = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emitterLabel = new javax.swing.JLabel();
        typeOfLateral = new javax.swing.JLabel();
        emitterNameLabel = new javax.swing.JLabel();
        siteNameLabel14 = new javax.swing.JLabel();
        siteNameLabel15 = new javax.swing.JLabel();
        siteNameLabel16 = new javax.swing.JLabel();
        siteNameLabel17 = new javax.swing.JLabel();
        lateralName = new javax.swing.JLabel();
        lateralMaterial = new javax.swing.JLabel();
        lateralLength = new javax.swing.JLabel();
        lateralNumber = new javax.swing.JLabel();
        lateralSpacing = new javax.swing.JLabel();
        siteNameLabel18 = new javax.swing.JLabel();
        lateralFlowRate = new javax.swing.JLabel();
        siteNameLabel19 = new javax.swing.JLabel();
        emitterTypeLabel = new javax.swing.JLabel();
        emitterSpacingLabel = new javax.swing.JLabel();
        emitterFlowRateLabel = new javax.swing.JLabel();
        emitterNumberLabel = new javax.swing.JLabel();
        emitterName = new javax.swing.JLabel();
        emitterType = new javax.swing.JLabel();
        emitterSpacing = new javax.swing.JLabel();
        emitterFlowRate = new javax.swing.JLabel();
        emitterNumber = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        systemRunTime = new javax.swing.JLabel();
        waterQuality = new javax.swing.JLabel();
        discardBtn = new javax.swing.JButton();
        printBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Drip Irrigation Worksheet");

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));
        mainpanel.setForeground(new java.awt.Color(0, 0, 0));

        headingPanel.setBackground(new java.awt.Color(255, 255, 255));
        headingPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        nameOfSite.setBackground(new java.awt.Color(255, 255, 255));
        nameOfSite.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nameOfSite.setForeground(new java.awt.Color(0, 51, 51));
        nameOfSite.setText("nameOfFarm");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Worksheet --");

        javax.swing.GroupLayout headingPanelLayout = new javax.swing.GroupLayout(headingPanel);
        headingPanel.setLayout(headingPanelLayout);
        headingPanelLayout.setHorizontalGroup(
            headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(nameOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(355, 355, 355))
        );
        headingPanelLayout.setVerticalGroup(
            headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(headingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameOfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        contentPanel.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SITE INFORMATION");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" CLIMATE :");

        soilLabel.setBackground(new java.awt.Color(255, 255, 255));
        soilLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soilLabel.setForeground(new java.awt.Color(0, 0, 0));
        soilLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        soilLabel.setText("SOIL");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CROP");

        siteNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel.setText("Site Name :");

        siteOwnerLabel.setBackground(new java.awt.Color(255, 255, 255));
        siteOwnerLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteOwnerLabel.setForeground(new java.awt.Color(0, 0, 0));
        siteOwnerLabel.setText("Owner :");

        siteNameLabel2.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel2.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel2.setText("Address :");

        siteNameLabel3.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel3.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel3.setText("Contact :");

        siteName.setBackground(new java.awt.Color(255, 255, 255));
        siteName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        siteName.setForeground(new java.awt.Color(0, 0, 0));
        siteName.setText("Site Name :");

        siteNameLabel5.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel5.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel5.setText("Site Area :");

        siteOwner.setBackground(new java.awt.Color(255, 255, 255));
        siteOwner.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        siteOwner.setForeground(new java.awt.Color(0, 0, 0));
        siteOwner.setText("Site Name :");

        address.setBackground(new java.awt.Color(255, 255, 255));
        address.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        address.setForeground(new java.awt.Color(0, 0, 0));
        address.setText("Site Name :");

        contact.setBackground(new java.awt.Color(255, 255, 255));
        contact.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        contact.setForeground(new java.awt.Color(0, 0, 0));
        contact.setText("Site Name :");

        area.setBackground(new java.awt.Color(255, 255, 255));
        area.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        area.setForeground(new java.awt.Color(0, 0, 0));
        area.setText("Site Name :");

        city.setBackground(new java.awt.Color(255, 255, 255));
        city.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        city.setForeground(new java.awt.Color(0, 0, 0));
        city.setText("Site Name :");

        siteNameLabel4.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel4.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel4.setText("Soil Type :");

        siteNameLabel6.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel6.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel6.setText("Water Source :");

        siteNameLabel7.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel7.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel7.setText("Name :");

        siteNameLabel8.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel8.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel8.setText("Category :");

        siteNameLabel9.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel9.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        siteNameLabel9.setText("Water Req :");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        climate.setBackground(new java.awt.Color(255, 255, 255));
        climate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        climate.setForeground(new java.awt.Color(0, 0, 0));
        climate.setText("Site Name :");

        soilType.setBackground(new java.awt.Color(255, 255, 255));
        soilType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        soilType.setForeground(new java.awt.Color(0, 0, 0));
        soilType.setText("Site Name :");

        waterSource.setBackground(new java.awt.Color(255, 255, 255));
        waterSource.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        waterSource.setForeground(new java.awt.Color(0, 0, 0));
        waterSource.setText("Site Name :");

        cropName.setBackground(new java.awt.Color(255, 255, 255));
        cropName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cropName.setForeground(new java.awt.Color(0, 0, 0));
        cropName.setText("Site Name :");

        cropCategory.setBackground(new java.awt.Color(255, 255, 255));
        cropCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cropCategory.setForeground(new java.awt.Color(0, 0, 0));
        cropCategory.setText("Site Name :");

        waterRequirement.setBackground(new java.awt.Color(255, 255, 255));
        waterRequirement.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        waterRequirement.setForeground(new java.awt.Color(0, 0, 0));
        waterRequirement.setText("Site Name :");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SUB-MAIN PIPE");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MANIFOLD PIPE");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("MAIN PIPE");

        siteNameLabel10.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel10.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel10.setText("Name :");

        siteNameLabel11.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel11.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel11.setText("Length :");

        siteNameLabel12.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel12.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel12.setText("Material :");

        mainName.setBackground(new java.awt.Color(255, 255, 255));
        mainName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mainName.setForeground(new java.awt.Color(0, 0, 0));
        mainName.setText("Site Name :");

        submainName.setBackground(new java.awt.Color(255, 255, 255));
        submainName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        submainName.setForeground(new java.awt.Color(0, 0, 0));
        submainName.setText("Site Name :");

        manifoldName.setBackground(new java.awt.Color(255, 255, 255));
        manifoldName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        manifoldName.setForeground(new java.awt.Color(0, 0, 0));
        manifoldName.setText("Site Name :");

        mainMaterial.setBackground(new java.awt.Color(255, 255, 255));
        mainMaterial.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        mainMaterial.setForeground(new java.awt.Color(0, 0, 0));
        mainMaterial.setText("Site Name :");

        subMainMaterial.setBackground(new java.awt.Color(255, 255, 255));
        subMainMaterial.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        subMainMaterial.setForeground(new java.awt.Color(0, 0, 0));
        subMainMaterial.setText("Site Name :");

        manifoldMaterial.setBackground(new java.awt.Color(255, 255, 255));
        manifoldMaterial.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        manifoldMaterial.setForeground(new java.awt.Color(0, 0, 0));
        manifoldMaterial.setText("Site Name :");

        mainLength.setBackground(new java.awt.Color(255, 255, 255));
        mainLength.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mainLength.setForeground(new java.awt.Color(0, 0, 0));
        mainLength.setText("Site Name :");

        manifoldLength.setBackground(new java.awt.Color(255, 255, 255));
        manifoldLength.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        manifoldLength.setForeground(new java.awt.Color(0, 0, 0));
        manifoldLength.setText("Site Name :");

        submainLength.setBackground(new java.awt.Color(255, 255, 255));
        submainLength.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        submainLength.setForeground(new java.awt.Color(0, 0, 0));
        submainLength.setText("Site Name :");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("LATERAL");

        emitterLabel.setBackground(new java.awt.Color(255, 255, 255));
        emitterLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        emitterLabel.setForeground(new java.awt.Color(0, 0, 0));
        emitterLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emitterLabel.setText("EMITTER");

        typeOfLateral.setBackground(new java.awt.Color(255, 255, 255));
        typeOfLateral.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        typeOfLateral.setForeground(new java.awt.Color(0, 0, 0));
        typeOfLateral.setText("type");

        emitterNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        emitterNameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        emitterNameLabel.setForeground(new java.awt.Color(0, 0, 0));
        emitterNameLabel.setText("Name :");

        siteNameLabel14.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel14.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel14.setText("Length :");

        siteNameLabel15.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel15.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel15.setText("Material :");

        siteNameLabel16.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel16.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel16.setText("Number :");

        siteNameLabel17.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel17.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel17.setText("Spacing :");

        lateralName.setBackground(new java.awt.Color(255, 255, 255));
        lateralName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lateralName.setForeground(new java.awt.Color(0, 0, 0));
        lateralName.setText("Site Name :");

        lateralMaterial.setBackground(new java.awt.Color(255, 255, 255));
        lateralMaterial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lateralMaterial.setForeground(new java.awt.Color(0, 0, 0));
        lateralMaterial.setText("Site Name :");

        lateralLength.setBackground(new java.awt.Color(255, 255, 255));
        lateralLength.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lateralLength.setForeground(new java.awt.Color(0, 0, 0));
        lateralLength.setText("Site Name :");

        lateralNumber.setBackground(new java.awt.Color(255, 255, 255));
        lateralNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lateralNumber.setForeground(new java.awt.Color(0, 0, 0));
        lateralNumber.setText("Site Name :");

        lateralSpacing.setBackground(new java.awt.Color(255, 255, 255));
        lateralSpacing.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lateralSpacing.setForeground(new java.awt.Color(0, 0, 0));
        lateralSpacing.setText("Site Name :");

        siteNameLabel18.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel18.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel18.setText("Flow Rate :");

        lateralFlowRate.setBackground(new java.awt.Color(255, 255, 255));
        lateralFlowRate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lateralFlowRate.setForeground(new java.awt.Color(0, 0, 0));
        lateralFlowRate.setText("Site Name :");

        siteNameLabel19.setBackground(new java.awt.Color(255, 255, 255));
        siteNameLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        siteNameLabel19.setForeground(new java.awt.Color(0, 0, 0));
        siteNameLabel19.setText("Name :");

        emitterTypeLabel.setBackground(new java.awt.Color(255, 255, 255));
        emitterTypeLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        emitterTypeLabel.setForeground(new java.awt.Color(0, 0, 0));
        emitterTypeLabel.setText("Type :");

        emitterSpacingLabel.setBackground(new java.awt.Color(255, 255, 255));
        emitterSpacingLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        emitterSpacingLabel.setForeground(new java.awt.Color(0, 0, 0));
        emitterSpacingLabel.setText("Spacing :");

        emitterFlowRateLabel.setBackground(new java.awt.Color(255, 255, 255));
        emitterFlowRateLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        emitterFlowRateLabel.setForeground(new java.awt.Color(0, 0, 0));
        emitterFlowRateLabel.setText("Flow Rate :");

        emitterNumberLabel.setBackground(new java.awt.Color(255, 255, 255));
        emitterNumberLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        emitterNumberLabel.setForeground(new java.awt.Color(0, 0, 0));
        emitterNumberLabel.setText("Number :");

        emitterName.setBackground(new java.awt.Color(255, 255, 255));
        emitterName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emitterName.setForeground(new java.awt.Color(0, 0, 0));
        emitterName.setText("Site Name :");

        emitterType.setBackground(new java.awt.Color(255, 255, 255));
        emitterType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emitterType.setForeground(new java.awt.Color(0, 0, 0));
        emitterType.setText("Site Name :");

        emitterSpacing.setBackground(new java.awt.Color(255, 255, 255));
        emitterSpacing.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emitterSpacing.setForeground(new java.awt.Color(0, 0, 0));
        emitterSpacing.setText("Site Name :");

        emitterFlowRate.setBackground(new java.awt.Color(255, 255, 255));
        emitterFlowRate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emitterFlowRate.setForeground(new java.awt.Color(0, 0, 0));
        emitterFlowRate.setText("Site Name :");

        emitterNumber.setBackground(new java.awt.Color(255, 255, 255));
        emitterNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        emitterNumber.setForeground(new java.awt.Color(0, 0, 0));
        emitterNumber.setText("Site Name :");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("SYSTEM RUNTIME");

        systemRunTime.setBackground(new java.awt.Color(255, 255, 255));
        systemRunTime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        systemRunTime.setForeground(new java.awt.Color(0, 0, 0));
        systemRunTime.setText("Site Name :");

        waterQuality.setBackground(new java.awt.Color(255, 255, 255));
        waterQuality.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        waterQuality.setForeground(new java.awt.Color(0, 0, 0));
        waterQuality.setText("Site Name :");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(soilLabel)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(siteOwnerLabel)
                                    .addComponent(siteNameLabel)
                                    .addComponent(siteNameLabel2)
                                    .addComponent(siteNameLabel3)
                                    .addComponent(siteNameLabel5)
                                    .addComponent(siteNameLabel4)
                                    .addComponent(siteNameLabel6)
                                    .addComponent(siteNameLabel7)
                                    .addComponent(siteNameLabel8)
                                    .addComponent(siteNameLabel9)))
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(climate)
                            .addComponent(area)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(waterSource, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(soilType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cropCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cropName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(contact, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(siteOwner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(siteName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(waterQuality, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(waterRequirement, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(70, 70, 70)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(siteNameLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(siteNameLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(siteNameLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel9)
                            .addComponent(emitterLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(99, 99, 99))
                                            .addComponent(mainName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(mainMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addComponent(mainLength, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70)))
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(submainName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(subMainMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(submainLength, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(manifoldLength, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(manifoldMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(manifoldName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(typeOfLateral, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel10)
                                .addGap(28, 28, 28)
                                .addComponent(systemRunTime, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(siteNameLabel15)
                                    .addComponent(siteNameLabel14)
                                    .addComponent(siteNameLabel16)
                                    .addComponent(siteNameLabel17)
                                    .addComponent(siteNameLabel18)
                                    .addComponent(siteNameLabel19))
                                .addGap(18, 18, 18)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lateralName, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lateralMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lateralLength, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                        .addComponent(lateralNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lateralSpacing, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lateralFlowRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emitterNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emitterNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emitterTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emitterSpacingLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emitterFlowRateLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emitterName, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emitterType, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emitterSpacing, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(emitterNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                        .addComponent(emitterFlowRate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addGap(15, 15, 15))
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel)
                            .addComponent(siteName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteOwnerLabel)
                            .addComponent(siteOwner))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel2)
                            .addComponent(address)
                            .addComponent(city))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel3)
                            .addComponent(contact))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel5)
                            .addComponent(area))
                        .addGap(28, 28, 28)
                        .addComponent(soilLabel)
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel4)
                            .addComponent(soilType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel6)
                            .addComponent(waterSource)
                            .addComponent(waterQuality))
                        .addGap(18, 18, 18)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(climate))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(siteNameLabel7)
                                    .addComponent(cropName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(siteNameLabel8))
                            .addComponent(cropCategory))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel9)
                            .addComponent(waterRequirement)))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel8))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))))
                                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(siteNameLabel10)
                                                .addGap(12, 12, 12)
                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(siteNameLabel12)
                                                    .addComponent(mainMaterial)
                                                    .addComponent(subMainMaterial)
                                                    .addComponent(manifoldMaterial))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(siteNameLabel11)
                                                    .addComponent(mainLength)
                                                    .addComponent(manifoldLength)
                                                    .addComponent(submainLength)))
                                            .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(submainName)
                                                        .addComponent(mainName))
                                                    .addComponent(manifoldName))))
                                        .addGap(30, 30, 30)
                                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(typeOfLateral)
                                            .addComponent(jLabel10)
                                            .addComponent(systemRunTime))
                                        .addGap(18, 18, 18)
                                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lateralName)
                                            .addComponent(siteNameLabel19))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(siteNameLabel15))
                                    .addComponent(lateralMaterial))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(siteNameLabel14)
                                    .addComponent(lateralLength))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(siteNameLabel16))
                            .addComponent(lateralNumber))
                        .addGap(12, 12, 12)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel17)
                            .addComponent(lateralSpacing))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siteNameLabel18)
                            .addComponent(lateralFlowRate))
                        .addGap(5, 5, 5)
                        .addComponent(emitterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emitterNameLabel)
                            .addComponent(emitterName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emitterTypeLabel)
                            .addComponent(emitterType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emitterSpacingLabel)
                            .addComponent(emitterSpacing))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emitterFlowRateLabel)
                            .addComponent(emitterFlowRate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emitterNumberLabel)
                            .addComponent(emitterNumber))))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        discardBtn.setBackground(new java.awt.Color(255, 255, 255));
        discardBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        discardBtn.setForeground(new java.awt.Color(0, 0, 0));
        discardBtn.setText("Discard");
        discardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardBtnActionPerformed(evt);
            }
        });

        printBtn.setBackground(new java.awt.Color(255, 255, 255));
        printBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printBtn.setForeground(new java.awt.Color(0, 0, 0));
        printBtn.setText("Print");

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(366, 366, 366)
                .addComponent(discardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(248, 248, 248)
                .addComponent(printBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGap(510, 510, 510))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addComponent(headingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(printBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1298, 742));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void discardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardBtnActionPerformed
        // Close this window
        this.dispose();
    }//GEN-LAST:event_discardBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DripWorksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DripWorksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DripWorksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DripWorksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DripWorksheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel area;
    private javax.swing.JLabel city;
    private javax.swing.JLabel climate;
    private javax.swing.JLabel contact;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel cropCategory;
    private javax.swing.JLabel cropName;
    private javax.swing.JButton discardBtn;
    private javax.swing.JLabel emitterFlowRate;
    private javax.swing.JLabel emitterFlowRateLabel;
    private javax.swing.JLabel emitterLabel;
    private javax.swing.JLabel emitterName;
    private javax.swing.JLabel emitterNameLabel;
    private javax.swing.JLabel emitterNumber;
    private javax.swing.JLabel emitterNumberLabel;
    private javax.swing.JLabel emitterSpacing;
    private javax.swing.JLabel emitterSpacingLabel;
    private javax.swing.JLabel emitterType;
    private javax.swing.JLabel emitterTypeLabel;
    private javax.swing.JPanel headingPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lateralFlowRate;
    private javax.swing.JLabel lateralLength;
    private javax.swing.JLabel lateralMaterial;
    private javax.swing.JLabel lateralName;
    private javax.swing.JLabel lateralNumber;
    private javax.swing.JLabel lateralSpacing;
    private javax.swing.JLabel mainLength;
    private javax.swing.JLabel mainMaterial;
    private javax.swing.JLabel mainName;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JLabel manifoldLength;
    private javax.swing.JLabel manifoldMaterial;
    private javax.swing.JLabel manifoldName;
    private javax.swing.JLabel nameOfSite;
    private javax.swing.JButton printBtn;
    private javax.swing.JLabel siteName;
    private javax.swing.JLabel siteNameLabel;
    private javax.swing.JLabel siteNameLabel10;
    private javax.swing.JLabel siteNameLabel11;
    private javax.swing.JLabel siteNameLabel12;
    private javax.swing.JLabel siteNameLabel14;
    private javax.swing.JLabel siteNameLabel15;
    private javax.swing.JLabel siteNameLabel16;
    private javax.swing.JLabel siteNameLabel17;
    private javax.swing.JLabel siteNameLabel18;
    private javax.swing.JLabel siteNameLabel19;
    private javax.swing.JLabel siteNameLabel2;
    private javax.swing.JLabel siteNameLabel3;
    private javax.swing.JLabel siteNameLabel4;
    private javax.swing.JLabel siteNameLabel5;
    private javax.swing.JLabel siteNameLabel6;
    private javax.swing.JLabel siteNameLabel7;
    private javax.swing.JLabel siteNameLabel8;
    private javax.swing.JLabel siteNameLabel9;
    private javax.swing.JLabel siteOwner;
    private javax.swing.JLabel siteOwnerLabel;
    private javax.swing.JLabel soilLabel;
    private javax.swing.JLabel soilType;
    private javax.swing.JLabel subMainMaterial;
    private javax.swing.JLabel submainLength;
    private javax.swing.JLabel submainName;
    private javax.swing.JLabel systemRunTime;
    private javax.swing.JLabel typeOfLateral;
    private javax.swing.JLabel waterQuality;
    private javax.swing.JLabel waterRequirement;
    private javax.swing.JLabel waterSource;
    // End of variables declaration//GEN-END:variables
}
