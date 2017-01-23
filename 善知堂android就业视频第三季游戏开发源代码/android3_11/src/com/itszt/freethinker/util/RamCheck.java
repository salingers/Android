package com.itszt.freethinker.util;

import com.itszt.freethinker.entity.Sprite;

/**
 *	company: http://www.itszt.com ( or http://itszt.losoon.com)
 *	author: freethinker(ÍõÖÎ¹ú)
 *	email: 1942623403@qq.com
 *		2012-4-22
 */

public class RamCheck {
	public static boolean ifRam(Sprite s1,Sprite s2){
		return ifRam(s1.x,s1.y, s1.x+s1.spriteWidth, s1.y + s1.spriteHeight, s2.x,s2.y, s2.x+s2.spriteWidth, s2.y + s2.spriteHeight);
	}
	public static boolean ifRam(int x1, int y1, int x2, int y2,int x3,int y3, int x4,int y4){
		if(x1<=x4 && y1<=y4 && x2>=x3 && y2>=y3){
			System.out.println(x1+"  "+y1+"  "+x2+"  "+y2+"  "+x3+"  "+y3+"  "+x4+"  "+y4);
			return true;
		}
		return false;
	}
}
