package com.rain.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.swetake.util.Qrcode;
public class EncoderHandler {
	
	public void encoderQRCoder(String content, HttpServletResponse response) {
		try {
			int MAX_DATA_LENGTH = 500; // �������ɶ�ά�����������С. 500�ֽڵ�ԭʼ����, ���ɶ�ά��ʱ, ��89���  
	        byte[] d = content.getBytes();  
	        int dataLength = d.length;  
	        int imageWidth = 200; /* 269��Ԥ�ȼ��������. ע�⣺ͼ���ȱ�������ɵĶ�ά��ͼ���ȴ�,�������,����,��ά��ʶ�𲻳��� */  
	        int imageHeight = imageWidth;  
	        BufferedImage bi = new BufferedImage(imageWidth, imageHeight,  
	                BufferedImage.TYPE_INT_RGB);  
	        Graphics2D g = bi.createGraphics();  
	        g.setBackground(Color.WHITE);  
	        g.clearRect(0, 0, imageWidth, imageHeight);  
	        g.setColor(Color.BLACK);  
	        if (dataLength > 0 && dataLength <= MAX_DATA_LENGTH) {  
	            /* ���ɶ�ά�� */  
	            Qrcode qrcode = new Qrcode();  
	            qrcode.setQrcodeErrorCorrect('M'); // L, Q, H, Ĭ��  
	            qrcode.setQrcodeEncodeMode('B'); // A, N, Ĭ��  
	            qrcode.setQrcodeVersion(5); // 0<= version <=40; 89�ֽ�,  
	                                            // (89-1)*3+2+3-1+1 = 269  
	            boolean[][] b = qrcode.calQrcode(d);  
	            int qrcodeDataLen = b.length;  
	            for (int i = 0; i < qrcodeDataLen; i++) {  
	                for (int j = 0; j < qrcodeDataLen; j++) {  
	                    if (b[j][i]) {  
	                        g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3); /* 
	                                                                 * ����ά��ͼ��, 
	                                                                 * ������ͼ�ο���� 
	                                                                 * ((qrcodeDataLen-1)*3+2) + 
	                                                                 * 3 -1 = 136; 
	                                                                 * ���ɵ�image�Ŀ�ȴ�С����>=(136+1),��Χ��1������������ʶ�˿�����Ϊ��ά�� 
	                                                                 */  
	                        /* 
	                         * fillRect(int x, int y, int width, int height) �������ã� 
	                         * ���ָ���ľ��Ρ��þ�����ߺ��ұ�λ�� x �� x + width - 1�����ߺ͵ױ�λ�� y �� y + 
	                         * height - 1�� �õ��ľ��θ��ǵ�������Ϊ width ���أ��߶�Ϊ height ���ء� 
	                         * ʹ��ͼ�������ĵĵ�ǰ��ɫ���þ��Ρ� ������ x - Ҫ�����ε� x ���ꡣ y - Ҫ�����ε� y 
	                         * ���ꡣ width - Ҫ�����εĿ�ȡ� height - Ҫ�����εĸ߶ȡ� 
	                         *  
	                         * �ο���http://bk.chinaar.com/index.php?doc-view-2999 
	                         */  
	                    }  
	                }  
	            }  
	            System.out.println("��ά�����ݳ���(�ֽ�):" + qrcodeDataLen);  
	        } else {  
	            return;  
	        }  
	        g.dispose();  
	        bi.flush();  
			
			//���ɶ�ά��QRCodeͼƬ
			ImageIO.write(bi, "png", response.getOutputStream());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
