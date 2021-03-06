/*
 * Created by JFormDesigner on Sun Jan 23 16:56:22 CET 2011
 */

package editor;

import hyperGraphs.HLH;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.jgoodies.forms.layout.*;

/**
 * @author sz gajek
 */
public class SettingsDialog extends JDialog {
	
	MainWindow mainWindow;
	
	public SettingsDialog(Frame owner) {
		super(owner);
		this.mainWindow=(MainWindow)owner;
		initComponents();
		
		horSize_TF.setText(String.valueOf(mainWindow.sizeX));
		vertSize_TF.setText(String.valueOf(mainWindow.sizeY));
		gridSize_TF.setText(String.valueOf(mainWindow.gridSize));
		gridMeters_TF.setText(String.valueOf(HLH.gridToMeters));
		sensorRange_TF.setText(String.valueOf(HLH.sensorRange));
		
		if (mainWindow.getDashedLineMeansVis()){
			dashedModeVIS_radio.setSelected(true);
		}else {
			dashedModeACC_radio.setSelected(true);
		}
		
		floorNumberComboBox.setSelectedItem(String.valueOf(mainWindow.getFloorCount()));
	}

	public SettingsDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	private void cancel_buttonActionPerformed(ActionEvent e) {
		this.dispose();
	}

	private void apply_buttonActionPerformed(ActionEvent e) {
		
		applyBasicSettings();
		this.dispose();
	}
	
	/**
	 * ustawienie podstawowych parametrów z setings dialog niewymagajacych resetu
	 * inicjalizuje wszystkie layout editory z nowymi wart
	 */
	private void applyBasicSettings(){
		
		mainWindow.sizeX=Integer.parseInt( horSize_TF.getText());
		mainWindow.sizeY=Integer.parseInt( vertSize_TF.getText());
		mainWindow.gridSize=Integer.parseInt( gridSize_TF.getText());
		HLH.gridToMeters=Float.parseFloat( gridMeters_TF.getText());
		HLH.sensorRange = Float.parseFloat(sensorRange_TF.getText());
		mainWindow.initLayouts();
		
	}
	
 
 
	private void dashedModeACC_radioItemStateChanged(ItemEvent e) {
//		if (e.getStateChange()==ItemEvent.SELECTED){
//			mainWindow.setDashedLineMeansVis(false);
//		}
	}

	private void dashedModeVIS_radioItemStateChanged(ItemEvent e) {
//		if (e.getStateChange()==ItemEvent.SELECTED){
//			mainWindow.setDashedLineMeansVis(true);
//		}
	}

	/**
	 * ustawia watosci z settings dialog, czysci  i inicjalizuje wszystko.
	 * dodatkowo tworzy nowa liste layout edytoryw i floors combo -losc pieter moze sie zmienic
	 * wywoluje applyBasicSettings ktore inicjalizuje layout editory
	 * @param e
	 */
	private void applyAndResetActionPerformed(ActionEvent e) {
		
		int floorCount = Integer.parseInt((String )floorNumberComboBox.getSelectedItem() );
		mainWindow.setFloorCount(floorCount);
		
		if (dashedModeVIS_radio.isSelected()){
			mainWindow.setDashedLineMeansVis(true);
		}else {
			mainWindow.setDashedLineMeansVis(false);
		}
		
		
		mainWindow.clearAll();
		mainWindow.initLayoutEditorsList();
		
		mainWindow.initFloorsEditor();
		mainWindow.initGraph();
		mainWindow.initFloorsCombo();
		
		applyBasicSettings();
		
		this.dispose();
	}

	private void floorNumberComboBoxItemStateChanged(ItemEvent e) {
		// TODO add your code here
	}

	private void sensorRange_TFFocusLost(FocusEvent e) {
		String newValue = sensorRange_TF.getText();
		
		try{
			Float.parseFloat(newValue);
		}catch (NumberFormatException ex ){
			JOptionPane.showMessageDialog(this, "Enter a valid float number");
			sensorRange_TF.setText(String.valueOf(HLH.sensorRange));
		}
	}

	private void gridMeters_TFFocusLost(FocusEvent e) {
		try {
			Float.parseFloat( gridMeters_TF.getText());
		}catch (NumberFormatException ex ){
			JOptionPane.showMessageDialog(this, "Enter a valid float number");
			gridMeters_TF.setText(String.valueOf(HLH.gridToMeters));
		}
	}

	private void gridSize_TFFocusLost(FocusEvent e) {
		try {
			Integer.parseInt( gridSize_TF.getText());
		}catch (NumberFormatException ex ){
			JOptionPane.showMessageDialog(this, "Enter a valid integer number");
			gridSize_TF.setText(String.valueOf(mainWindow.gridSize));
		}
	}

	private void vertSize_TFFocusLost(FocusEvent e) {
		try {
			Integer.parseInt( vertSize_TF.getText());
		}catch (NumberFormatException ex ){
			JOptionPane.showMessageDialog(this, "Enter a valid integer number");
			vertSize_TF.setText(String.valueOf(mainWindow.sizeY));
		}
	}

	private void horSize_TFFocusLost(FocusEvent e) {
		try {
			Integer.parseInt( horSize_TF.getText());
		}catch (NumberFormatException ex ){
			JOptionPane.showMessageDialog(this, "Enter a valid integer number");
			horSize_TF.setText(String.valueOf(mainWindow.sizeX));
		}
	}

	 

	 

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		panel1 = new JPanel();
		horSize_lab = new JLabel();
		horSize_TF = new JTextField();
		vertSize_lab = new JLabel();
		vertSize_TF = new JTextField();
		gridSize_lab = new JLabel();
		gridSize_TF = new JTextField();
		gridMeters_lab = new JLabel();
		gridMeters_TF = new JTextField();
		sensorRange_lab = new JLabel();
		sensorRange_TF = new JTextField();
		sensorRangeRightColLabel = new JLabel();
		panel3 = new JPanel();
		dashedLineLab = new JLabel();
		dashedModeACC_radio = new JRadioButton();
		dashedModeRightColLabel = new JLabel();
		dashedModeVIS_radio = new JRadioButton();
		panel4 = new JPanel();
		floorsNumberLab = new JLabel();
		floorNumberComboBox = new JComboBox();
		floorNumberRightColLabel = new JLabel();
		buttonsBottomPanel = new JPanel();
		applyAndReset = new JButton();
		apply_button = new JButton();
		cancel_button = new JButton();
		CellConstraints cc = new CellConstraints();

		//======== this ========
		setTitle("Settings");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new FormLayout(
			"105dlu:grow",
			"2*(default, $lgap), 31dlu, $lgap, bottom:46dlu:grow, $lgap, bottom:default, $lgap, 9dlu"));

		//======== panel1 ========
		{

			panel1.setLayout(new FormLayout(
				"75dlu, $lcgap, 95dlu, $lcgap, default:grow",
				"4*(default, $lgap), default"));

			//---- horSize_lab ----
			horSize_lab.setText("Horizontal Size");
			panel1.add(horSize_lab, cc.xy(1, 1, CellConstraints.RIGHT, CellConstraints.DEFAULT));

			//---- horSize_TF ----
			horSize_TF.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					horSize_TFFocusLost(e);
				}
			});
			panel1.add(horSize_TF, cc.xy(3, 1));

			//---- vertSize_lab ----
			vertSize_lab.setText("Vertical Size");
			panel1.add(vertSize_lab, cc.xy(1, 3, CellConstraints.RIGHT, CellConstraints.CENTER));

			//---- vertSize_TF ----
			vertSize_TF.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					vertSize_TFFocusLost(e);
				}
			});
			panel1.add(vertSize_TF, cc.xy(3, 3));

			//---- gridSize_lab ----
			gridSize_lab.setText("Grid size[px]");
			panel1.add(gridSize_lab, cc.xy(1, 5, CellConstraints.RIGHT, CellConstraints.DEFAULT));

			//---- gridSize_TF ----
			gridSize_TF.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					gridSize_TFFocusLost(e);
				}
			});
			panel1.add(gridSize_TF, cc.xy(3, 5));

			//---- gridMeters_lab ----
			gridMeters_lab.setText("Grid size[meters]");
			panel1.add(gridMeters_lab, cc.xy(1, 7, CellConstraints.RIGHT, CellConstraints.DEFAULT));

			//---- gridMeters_TF ----
			gridMeters_TF.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					gridMeters_TFFocusLost(e);
				}
			});
			panel1.add(gridMeters_TF, cc.xy(3, 7));

			//---- sensorRange_lab ----
			sensorRange_lab.setText("Sensor range[meters]");
			panel1.add(sensorRange_lab, cc.xy(1, 9, CellConstraints.RIGHT, CellConstraints.DEFAULT));

			//---- sensorRange_TF ----
			sensorRange_TF.setText("6");
			sensorRange_TF.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					sensorRange_TFFocusLost(e);
				}
			});
			panel1.add(sensorRange_TF, cc.xy(3, 9));

			//---- sensorRangeRightColLabel ----
			sensorRangeRightColLabel.setText("");
			panel1.add(sensorRangeRightColLabel, cc.xy(5, 9));
		}
		contentPane.add(panel1, cc.xy(1, 3, CellConstraints.LEFT, CellConstraints.TOP));

		//======== panel3 ========
		{
			panel3.setLayout(new FormLayout(
				"75dlu, $lcgap, 95dlu, $lcgap, default:grow",
				"2*(default)"));

			//---- dashedLineLab ----
			dashedLineLab.setText("Dashed Line Meaning");
			panel3.add(dashedLineLab, cc.xy(1, 1, CellConstraints.RIGHT, CellConstraints.DEFAULT));

			//---- dashedModeACC_radio ----
			dashedModeACC_radio.setText("Accesibility");
			dashedModeACC_radio.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					dashedModeACC_radioItemStateChanged(e);
				}
			});
			panel3.add(dashedModeACC_radio, cc.xy(3, 1));

			//---- dashedModeRightColLabel ----
			dashedModeRightColLabel.setText("(requires reset)");
			panel3.add(dashedModeRightColLabel, cc.xy(5, 1, CellConstraints.LEFT, CellConstraints.DEFAULT));

			//---- dashedModeVIS_radio ----
			dashedModeVIS_radio.setText("Visibility and Adjency");
			dashedModeVIS_radio.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					dashedModeVIS_radioItemStateChanged(e);
				}
			});
			panel3.add(dashedModeVIS_radio, cc.xy(3, 2));
		}
		contentPane.add(panel3, cc.xy(1, 5, CellConstraints.LEFT, CellConstraints.TOP));

		//======== panel4 ========
		{
			panel4.setLayout(new FormLayout(
				"75dlu, $lcgap, 95dlu, $lcgap, default:grow",
				"2*(default, $lgap), default"));

			//---- floorsNumberLab ----
			floorsNumberLab.setText("Number of floors");
			panel4.add(floorsNumberLab, cc.xy(1, 1, CellConstraints.RIGHT, CellConstraints.DEFAULT));

			//---- floorNumberComboBox ----
			floorNumberComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"1",
				"2",
				"3",
				"4",
				"5",
				"6",
				"7",
				"8",
				"9",
				"10",
				"11",
				"12",
				"15",
				"20",
				"25",
				"30"
			}));
			floorNumberComboBox.setSelectedIndex(2);
			floorNumberComboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					floorNumberComboBoxItemStateChanged(e);
				}
			});
			panel4.add(floorNumberComboBox, cc.xy(3, 1, CellConstraints.LEFT, CellConstraints.DEFAULT));

			//---- floorNumberRightColLabel ----
			floorNumberRightColLabel.setText("(requires reset)");
			panel4.add(floorNumberRightColLabel, cc.xy(5, 1, CellConstraints.LEFT, CellConstraints.DEFAULT));
		}
		contentPane.add(panel4, cc.xy(1, 7, CellConstraints.LEFT, CellConstraints.TOP));

		//======== buttonsBottomPanel ========
		{
			buttonsBottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

			//---- applyAndReset ----
			applyAndReset.setText("Apply and Reset");
			applyAndReset.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					applyAndResetActionPerformed(e);
				}
			});
			buttonsBottomPanel.add(applyAndReset);

			//---- apply_button ----
			apply_button.setText("Apply");
			apply_button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					apply_buttonActionPerformed(e);
				}
			});
			buttonsBottomPanel.add(apply_button);

			//---- cancel_button ----
			cancel_button.setText("Cancel");
			cancel_button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cancel_buttonActionPerformed(e);
				}
			});
			buttonsBottomPanel.add(cancel_button);
		}
		contentPane.add(buttonsBottomPanel, cc.xy(1, 9, CellConstraints.FILL, CellConstraints.BOTTOM));
		setSize(530, 375);
		setLocationRelativeTo(getOwner());

		//---- dashedMeaning_BG ----
		ButtonGroup dashedMeaning_BG = new ButtonGroup();
		dashedMeaning_BG.add(dashedModeACC_radio);
		dashedMeaning_BG.add(dashedModeVIS_radio);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JPanel panel1;
	private JLabel horSize_lab;
	private JTextField horSize_TF;
	private JLabel vertSize_lab;
	private JTextField vertSize_TF;
	private JLabel gridSize_lab;
	private JTextField gridSize_TF;
	private JLabel gridMeters_lab;
	private JTextField gridMeters_TF;
	private JLabel sensorRange_lab;
	private JTextField sensorRange_TF;
	private JLabel sensorRangeRightColLabel;
	private JPanel panel3;
	private JLabel dashedLineLab;
	private JRadioButton dashedModeACC_radio;
	private JLabel dashedModeRightColLabel;
	private JRadioButton dashedModeVIS_radio;
	private JPanel panel4;
	private JLabel floorsNumberLab;
	private JComboBox floorNumberComboBox;
	private JLabel floorNumberRightColLabel;
	private JPanel buttonsBottomPanel;
	private JButton applyAndReset;
	private JButton apply_button;
	private JButton cancel_button;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
