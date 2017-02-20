package com.chrisreading.wallpaperchanger.handler;

import java.util.HashMap;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.UINT_PTR;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIFunctionMapper;
import com.sun.jna.win32.W32APITypeMapper;

/**
 * Use's JNA (I just found this on stackoverflow)
 */
public class ChangeHandler {
	
	public ChangeHandler() {	

	}
	
	public void change(String path) {
		SPI.INSTANCE.SystemParametersInfo(
				new UINT_PTR(SPI.SPI_SETDESKWALLPAPER), 
				new UINT_PTR(0), 
				path, 
				new UINT_PTR(SPI.SPIF_UPDATEINIFILE | SPI.SPIF_SENDWININICHANGE));
	}
	
	public interface SPI extends StdCallLibrary {
		long SPI_SETDESKWALLPAPER = 20;
		long SPIF_UPDATEINIFILE = 0x01;
		long SPIF_SENDWININICHANGE = 0x02;
		
	      SPI INSTANCE = (SPI) Native.loadLibrary("user32", SPI.class, new HashMap<String, Object>() {
	          {
	             put(OPTION_TYPE_MAPPER, W32APITypeMapper.UNICODE);
	             put(OPTION_FUNCTION_MAPPER, W32APIFunctionMapper.UNICODE);
	          }
	       });

	       boolean SystemParametersInfo(
	           UINT_PTR uiAction,
	           UINT_PTR uiParam,
	           String pvParam,
	           UINT_PTR fWinIni
	         );
	}

}
