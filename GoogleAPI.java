import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

import javax.swing.ImageIcon;

import org.omg.CORBA.portable.OutputStream;

public class GoogleAPI {
	private String key;
	GoogleAPI(){
		key="";
	}
	
	public void downloadMap(String location) {
		try {
			int zoomIdx=15;
			String imageURL="https://maps.googleapis.com/maps/api/staticmap?center="
			+URLEncoder.encode(location,"UTF-8")+"&zoom="+zoomIdx+"&size=330x270&key="+key;
			//default zoom is 15 -> proper to see location
			
			URL url=new URL(imageURL);
			InputStream is =url.openStream();
			FileOutputStream os=new FileOutputStream(location);
			byte[] b=new byte[2048];
			int length;
			while((length =is.read(b))!=-1) {
				os.write(b,0,length);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ImageIcon getMap(String location) {
		return new ImageIcon((new ImageIcon(location)).getImage().getScaledInstance(330, 270, java.awt.Image.SCALE_SMOOTH));
	}
	public void fileDelete(String fileName) {
		File f=new File(fileName);
		f.delete();
	}
}
