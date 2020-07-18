package edu.vinaenter.cland.utils;

import edu.vinaenter.cland.constants.GlobalsConstant;

public class PaginationUtil {
	
	public static int getOffSet(int currentPage) {
		return (currentPage -1) * GlobalsConstant.LIMIT_Page;
	}
	
	public static int getOffSet(int currentPage, final int limit) {
		return (currentPage -1) * limit;
	}
}
