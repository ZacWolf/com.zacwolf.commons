package com.zacwolf.commons.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;

import com.zacwolf.commons.HashMap;

public class ImageUtilities {

	public	enum	SCALING{
			FIT,
			FIXED,
			TO
	}
final	static	private	Map<String,BufferedImage>	cache	=	new HashMap<String,BufferedImage>(true);
final	static	public	BufferedImage				brokenImage;

	static {
		try {
			brokenImage	=	ImageIO.read(ImageUtilities.class.getClassLoader().getResourceAsStream("broken_image.png"));
			if (brokenImage==null) {
				throw new IOException("Image was null");
			}
		} catch (final IOException e) {
			throw new RuntimeException("Could not load broken_image.png default…",e);
		}
	}

	/**
	 * All static methods, so private constuctor
	 */
    private ImageUtilities() {}

	public static BufferedImage getImage(final File file) {
final	String	key	=	file.getAbsolutePath();
    	if (cache.containsKey(key)) {
    		return cache.get(key);
    	}
		try{
final	BufferedImage	img		=	ImageIO.read(file);
			if(img==null) {
				return brokenImage;
			} else {
				cache.put(key, img);
				return img;
			}
		} catch (final IOException io) {
			return brokenImage;
		}
    }

    public static BufferedImage getImage(final String name) {
    	if (cache.containsKey(name)) {
    		return cache.get(name);
    	}
		try{
final	BufferedImage	img		=	ImageIO.read(ImageUtilities.class.getClassLoader().getResourceAsStream(name));
			if(img==null) {
				return brokenImage;
			} else {
				cache.put(name, img);
				return img;
			}
		} catch (final IOException io) {
			return brokenImage;
		}
    }

    public static BufferedImage getImage(final URL url){
    	if (cache.containsKey(url.getFile())) {
    		return cache.get(url.getPath());
    	}
    	try {
final	BufferedImage	img		=	ImageIO.read(url.openStream());
			if(img==null) {
				return brokenImage;
			} else {
				cache.put(url.getPath(), img);
				return img;
			}
		} catch (final IOException io) {
			return brokenImage;
		}
    }

    public static BufferedImage render(final BufferedImage img, final Color bgcolor) throws NoAlphaChanel {
    	if (img.getType()!=BufferedImage.TYPE_INT_RGB) {
    		throw new NoAlphaChanel();
    	}
final	int				w			=	img.getWidth(null);
final	int				h			=	img.getHeight(null);
final	BufferedImage	newimg		=	new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
final   Graphics2D		g2			=	newimg.createGraphics();
						g2.setColor(bgcolor);
						g2.fillRect(0, 0, w, h);
	    				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    try {
	    	while(!g2.drawImage(img, 0, 0, w, h, null)) {
	    		//block until the image is drawn
	    		Thread.sleep(10);
	    	}
	    } catch (final InterruptedException e) {}
	    				g2.dispose();
	    return newimg;
	}

    /**
     * Scale the specified image based on the SCALING type.
     * FIT will scale up/down the image to fit centered within with new image size
     * FIXED will not scale the image, instead changing the canvas size
     * 		(clipping if the image is larger, and filling around if the image is smaller
     * 		 both centered within the new image size)
     * TO will scale the image to the exact size specified
     * @param srcImg
     * @param w
     * @param h
     * @param scaling
     * @return
     */
	public static BufferedImage scaleImage(final BufferedImage srcImg, final int w, final int h, final SCALING scaling){
final	Image			scaledImage;
		if (scaling==SCALING.TO) {
						scaledImage	=	srcImg.getScaledInstance(w, h, Image.SCALE_DEFAULT);
		} else if (scaling==SCALING.FIT) {
			if (srcImg.getWidth(null)>w) {
						scaledImage	=	srcImg.getScaledInstance(-1, h, Image.SCALE_DEFAULT);
			} else if (srcImg.getHeight(null)>h) {
						scaledImage	=	srcImg.getScaledInstance(w, -1, Image.SCALE_DEFAULT);
			} else {	scaledImage	=	srcImg;
			}
		} else {		scaledImage	=	srcImg;
		}
final	BufferedImage	resizedImg	=	new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		final int				x			=	(w-scaledImage.getWidth(null))/2;
		final int				y			=	(h-scaledImage.getHeight(null))/2;
final   Graphics2D		g2			=	resizedImg.createGraphics();
	    				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    try {
	    	while(!g2.drawImage(scaledImage, x, y, w, h, null)) {
	    		//block until the image is drawn
	    		Thread.sleep(10);
	    	}
	    } catch (final InterruptedException e) {}
	    				g2.dispose();
	    return resizedImg;
	}

	public static class NoAlphaChanel extends Exception{
final	static	private	long	serialVersionUID	=	7240346518064167165L;
	}
}
