import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClientView extends JFrame{
	
	private Container mainContainer;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel treePanel;
	private JPanel rightPanel;
	private JPanel mapImgPanel;
	private JPanel mapSearchPanel;
	private JPanel mapPanel;
	private JPanel infoPanel;
	private JPanel infoFromGooglePanel;
	private JPanel infoFromUserPanel;
	private JPanel infoMemoPanel;
	private JPanel zoomPanel;
	private JPanel leftZoomPanel;
	private JPanel rightZoomPanel;
	
	private JTextField searchTextField;
	private static JButton searchButton;
	private static JButton zoomInButton;
	private static JButton zoomOutButton;
	private JLabel zoomLabel;
	
	String location = new String();
	int zoom;
	
	private GoogleAPI googleAPI =new GoogleAPI();
	private JLabel googleMap=new JLabel();
	ClientView(String title){
		super(title);
		this.setSize(1000,700);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainContainer=this.getContentPane();
//		mainContainer.setSize(1000,700);
		mainContainer.setLayout(new BorderLayout(0,0));
		mainContainer.setBackground(Color.WHITE);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK));
		
		
		
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
		
		
		
		
		topPanel=new JPanel();
		topPanel.setBorder(new LineBorder(Color.BLACK,2));
		topPanel.setBackground(Color.ORANGE);
		topPanel.setLayout(new FlowLayout(5));
		topPanel.add(participant);
		mainContainer.add(topPanel,BorderLayout.NORTH);
		
		middlePanel=new JPanel();
		middlePanel.setBorder(new LineBorder(Color.BLACK,2));
		middlePanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.X_AXIS));
//		middlePanel.add(middleLabel);
		mainContainer.add(middlePanel,BorderLayout.CENTER);
		
		
		treePanel=new JPanel();
		treePanel.setBorder(new LineBorder(Color.BLACK,2));//2 para is 선두께
		treePanel.setBackground(Color.WHITE);
		treePanel.setPreferredSize(new Dimension(700,700));
//		westPanel.setLayout(new FlowLayout(1));
		treePanel.add(treeMap);//will be change into map
		//mainContainer.add(westPanel,BorderLayout.CENTER);
		middlePanel.add(treePanel);
		
		rightPanel=new JPanel();
		rightPanel.setMinimumSize(new Dimension(300,700));
		rightPanel.setMaximumSize(new Dimension(300,700));
		rightPanel.setBorder(new LineBorder(Color.BLACK));
//		rightPanel.setBackground(Color.BLUE);
		rightPanel.setLayout(new GridLayout(2,1));
//		rightPanel.add(map);
		//mainContainer.add(rightPanel,BorderLayout.CENTER);
		middlePanel.add(rightPanel);
		
		mapImgPanel=new JPanel();//구글지도 들어갈위치 
		mapImgPanel.setMinimumSize(new Dimension(300,300));
		mapImgPanel.setMaximumSize(new Dimension(300,300));
		mapImgPanel.setBorder(new LineBorder(Color.BLACK,2));
		mapImgPanel.setBackground(Color.WHITE);
//		mapImgPanel.add(googleMapLabel);
		
		
		mapSearchPanel=new JPanel();
		mapSearchPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		mapSearchPanel.setBorder(new LineBorder(Color.BLACK,2));
		mapSearchPanel.setBackground(Color.WHITE);
//		mapSearchPanel.add(searchLabel);
		
		zoomPanel = new JPanel();
		zoomPanel.setLayout(new BorderLayout(0,0));
		zoomPanel.setBackground(Color.WHITE);
		leftZoomPanel = new JPanel();
		rightZoomPanel = new JPanel();

		rightZoomPanel.setBackground(Color.WHITE);
		leftZoomPanel.setBackground(Color.WHITE);
		
		
		zoomPanel.add(leftZoomPanel,BorderLayout.WEST);
		zoomPanel.add(rightZoomPanel,BorderLayout.EAST);
		
		
		mapPanel=new JPanel();
		mapPanel.setBorder(new LineBorder(Color.BLACK,2));
		mapPanel.setBackground(Color.WHITE);
		mapPanel.setLayout(new BorderLayout(0,0));
		mapPanel.add(mapSearchPanel,BorderLayout.NORTH);
		mapPanel.add(mapImgPanel,BorderLayout.CENTER);
		mapPanel.add(zoomPanel,BorderLayout.SOUTH);
		rightPanel.add(mapPanel);
		
		infoPanel=new JPanel();
		infoPanel.setBorder(new LineBorder(Color.BLACK,2));
		infoPanel.setBackground(Color.BLUE);
		infoPanel.setLayout(new GridLayout(3,1));
		rightPanel.add(infoPanel);
//		infoPanel.add(infoLabel);
		
		infoFromGooglePanel=new JPanel();
		infoFromGooglePanel.setBorder(new LineBorder(Color.BLACK,2));
		infoFromGooglePanel.setBackground(Color.WHITE);
		infoFromGooglePanel.add(infoFromGoogleLabel);
		infoPanel.add(infoFromGooglePanel);
		
		infoFromUserPanel=new JPanel();
		infoFromUserPanel.setBorder(new LineBorder(Color.BLACK,2));
		infoFromUserPanel.setBackground(Color.WHITE);
		infoFromUserPanel.add(infoFromUserLabel);
		infoPanel.add(infoFromUserPanel);
		
		infoMemoPanel=new JPanel();
		infoMemoPanel.setBorder(new LineBorder(Color.BLACK,2));
		infoMemoPanel.setBackground(Color.WHITE);
		infoMemoPanel.add(infoMemoLabel);
		infoPanel.add(infoMemoPanel);
	}
	
	public void fillSearchPanel() {
		searchTextField = new JTextField(20);
		searchTextField.setSize(new Dimension(100,30));
		searchButton =new JButton("검색");

		mapSearchPanel.add(searchTextField);
		mapSearchPanel.add(searchButton);
		searchButton.addMouseListener(new Event());
	}
	public void zoomPanel() {
		zoomInButton = new JButton("+");
		zoomOutButton = new JButton("-");
		zoomLabel = new JLabel("Zoom : "+ zoom);
		leftZoomPanel.add(zoomLabel);
		rightZoomPanel.add(zoomInButton);
		rightZoomPanel.add(zoomOutButton);
		
		zoomInButton.addMouseListener(new zoomInEvent());
		zoomOutButton.addMouseListener(new zoomOutEvent());
	}
	
	public void setMap(String location, int zoomIdx) {
		googleAPI.downloadMap(location, zoomIdx);
		googleMap.setIcon(googleAPI.getMap(location));
		googleAPI.fileDelete(location);
		mapImgPanel.add(googleMap);
//		pack();
		
	}
	public void search() {
		
	}
	public class zoomInEvent implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			zoom += 1;
			setMap(searchTextField.getText(), zoom+1);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
	public class zoomOutEvent implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			zoom -= 1;
			setMap(searchTextField.getText(), zoom+1);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
	
	public class Event implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			zoom = 15;
			setMap(searchTextField.getText(), zoom);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	public static void main(String[] args) {
		ClientView cv=new ClientView("network project");
		cv.location = "서울";
		cv.zoom = 15;
		cv.mkGrid();
		cv.setMap(cv.location, cv.zoom);
		cv.fillSearchPanel();
		cv.zoomPanel();
		
		
		
		cv.setVisible(true);
		
		
		
	}
}
