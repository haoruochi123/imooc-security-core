package com.imooc.security.core.validate.code;
/**
 * @ClassName: ImageCode  
 * @Description: 图形验证码
 * @author 郝若池
 * @date 2019年6月2日 下午8:06:17
 */

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class ImageCode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedImage image ;
	
	private String code;
	
	public ImageCode(BufferedImage image,String code) {
		this.image = image;
		this.code = code;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
