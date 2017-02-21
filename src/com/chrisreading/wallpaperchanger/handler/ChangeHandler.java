package com.chrisreading.wallpaperchanger.handler;

import java.io.IOException;
import java.util.HashMap;

import com.chrisreading.wallpaperchanger.utility.OSUtility;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.UINT_PTR;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIFunctionMapper;
import com.sun.jna.win32.W32APITypeMapper;

/**
 * Changes the wallpaper based on the OS
 */
public class ChangeHandler {
	
	public void change(String path) throws IOException {
		if(OSUtility.isWindows()) {
			SPI.INSTANCE.SystemParametersInfo(
					new UINT_PTR(SPI.SPI_SETDESKWALLPAPER), 
					new UINT_PTR(0), 
					path, 
					new UINT_PTR(SPI.SPIF_UPDATEINIFILE | SPI.SPIF_SENDWININICHANGE));	
		} else if(OSUtility.isMac()) {
			// I have no idea if this works, I don't own a mac
			String as[] = {
					"osascript",
					"-e", "tell application \"Finder\"",
					"-e", "set desktop picture to POSIX file \"" + path + "\"",
					"-e", "end tell"
			};
			
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(as);
		}
		
		// TODO: create function for linux
	}
	
	/**
	 * Windows
	 */
	public interface SPI extends StdCallLibrary {
		long SPI_SETDESKWALLPAPER = 20;
		long SPIF_UPDATEINIFILE = 0x01;
		long SPIF_SENDWININICHANGE = 0x02;
		
		@SuppressWarnings("serial")
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
