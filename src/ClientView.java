import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class ClientView extends JFrame{
	ClientView(String title){
		super(title);
		this.setSize(1000,700);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		
	}
	public void mkGrid() {
		JLabel participant=new JLabel("참여자 목록: ");
		JLabel treeMap=new JLabel("tree map position");
		JLabel googleMapLabel=new JLabel("google map");
		JLabel searchLabel=new JLabel("search position");
		JLabel infoLabel=new JLabel("information panel");
		JLabel middleLabel=new JLabel("this is middle");
		JLabel infoFromGoogleLabel=new JLabel("info from google");
		JLabel infoFromUserLabel=new JLabel("info from user");
		JLabel infoMemoLabel=new JLabel("memo");
		//label will be deleted.. these are for explaination about panel
		
		Container mainContainer=this.getContentPane();
		mainContainer.setLayout(new BorderLayout(0,0));
		mainContainer.setBackground(Color.WHITE);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK));
		
		JPanel topPanel=new JPanel();
		topPanel.setBorder(new LineBorder(Color.BLACK,2));
		topPanel.setBackground(Color.ORANGE);
		topPanel.setLayout(new FlowLayout(5));
		topPanel.add(participant);
		mainContainer.add(topPanel,BorderLayout.NORTH);
		
		JPanel middlePanel=new JPanel();
		middlePanel.setBorder(new LineBorder(Color.BLACK,2));
		middlePanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
//		middlePanel.add(middleLabel);
		mainContainer.add(middlePanel,BorderLayout.CENTER);
		
		
		JPanel treePanel=new JPanel();
		treePanel.setBorder(new LineBorder(Color.BLACK,2));//2 para is 선두께
		treePanel.setBackground(Color.WHITE);
		treePanel.setPreferredSize(new Dimension(400,700));
//		westPanel.setLayout(new FlowLayout(1));
		treePanel.add(treeMap);//will be change into map
		//mainContainer.add(westPanel,BorderLayout.CENTER);
		middlePanel.add(treePanel);
		
		JPanel rightPanel=new JPanel();
		rightPanel.setBorder(new LineBorder(Color.BLACK,2));
//		rightPanel.setBackground(Color.BLUE);
		rightPanel.setLayout(new GridLayout(2,1));
//		rightPanel.add(map);
		//mainContainer.add(rightPanel,BorderLayout.CENTER);
		middlePanel.add(rightPanel);
		
		JPanel mapImgPanel=new JPanel();//구글지도 들어갈위치 
		mapImgPanel.setBorder(new LineBorder(Color.BLACK,2));
		mapImgPanel.setBackground(Color.ORANGE);
		mapImgPanel.add(googleMapLabel);
		
		
		JPanel mapSearchPanel=new JPanel();
		mapSearchPanel.setBorder(new LineBorder(Color.BLACK,2));
		mapSearchPanel.setBackground(Color.WHITE);
		mapSearchPanel.add(searchLabel);
		
		JPanel mapPanel=new JPanel();
		mapPanel.setBorder(new LineBorder(Color.BLACK,2));
		mapPanel.setBackground(Color.WHITE);
		mapPanel.setLayout(new BorderLayout(10,2));
		mapPanel.add(mapSearchPanel,BorderLayout.NORTH);
		mapPanel.add(mapImgPanel,BorderLayout.CENTER);
		rightPanel.add(mapPanel);
		
		JPanel infoPanel=new JPanel();
		infoPanel.setBorder(new LineBorder(Color.BLACK,2));
		infoPanel.setBackground(Color.BLUE);
		infoPanel.setLayout(new GridLayout(3,1));
		rightPanel.add(infoPanel);
//		infoPanel.add(infoLabel);
		
		JPanel infoFromGooglePanel=new JPanel();
		infoFromGooglePanel.setBorder(new LineBorder(Color.BLACK,2));
		infoFromGooglePanel.setBackground(Color.WHITE);
		infoFromGooglePanel.add(infoFromGoogleLabel);
		infoPanel.add(infoFromGooglePanel);
		
		JPanel infoFromUserPanel=new JPanel();
		infoFromUserPanel.setBorder(new LineBorder(Color.BLACK,2));
		infoFromUserPanel.setBackground(Color.WHITE);
		infoFromUserPanel.add(infoFromUserLabel);
		infoPanel.add(infoFromUserPanel);
		
		JPanel infoMemoPanel=new JPanel();
		infoMemoPanel.setBorder(new LineBorder(Color.BLACK,2));
		infoMemoPanel.setBackground(Color.WHITE);
		infoMemoPanel.add(infoMemoLabel);
		infoPanel.add(infoMemoPanel);
	}
	public static void main(String[] args) {
		ClientView cv=new ClientView("network project");
		cv.mkGrid();
		cv.setVisible(true);
		
		
	}
}
