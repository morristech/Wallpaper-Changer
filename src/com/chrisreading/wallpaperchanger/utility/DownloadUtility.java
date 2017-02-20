package com.chrisreading.wallpaperchanger.utility;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Downloads a file from a given url
 */
public class DownloadUtility {

	public static File download(String fileUrl, String fileDest) throws IOException {
		URL url = new URL(fileUrl);
		BufferedInputStream input = new BufferedInputStream(url.openStream());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		byte[] buf = new byte[1024];
		int n = 0;
		while(-1 != (n = input.read(buf)))
			output.write(buf, 0, n);
		output.close();
		input.close();
		
		byte[] response = output.toByteArray();
		File file = new File(fileDest);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(response);
		fos.close();
		
		return file;
	}
	
}
