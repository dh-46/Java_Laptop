package tw.org.iii.practiceJava;

public class Reviewed030_StringBuffer {
	/*	NOTE 20180805AM1 StringBuffer
	 * 	
	 * 	StringBuffer & StringBuilder用法一樣
	 * 	
	 * 	觀念:
	 * 	使用任何類別物件前記得先看API
	 * 		看建構式
	 * 		有無無傳參數建構式
	 * 		是否為Final-->不能繼承
	 * 		其他方法介紹(它的父類別)
	 * 
	 * 	物件型別sysout印toString
	 * 	基本型別sysout印其值
	 * 	
	 * 	>> 字串回傳的物件實體為新的物件實體
	 * 	>> StringBuffer回傳的為其原本的物件實體
	 */
	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1); // 印出該物件的toString
		System.out.println(sb1.capacity());	// 容量
		System.out.println(sb1.length());	// 字串長度
		
		System.out.println("--------");
		
		// StringBuffer.append-->傳回StringBuffer
		StringBuffer sb2 = sb1.append("123456789123123");
		// 兩個物件名稱 但是否是兩個物件實體?
		System.out.println("sb1 :" + sb1);
		System.out.println("sb1 :" + sb1.capacity());
		System.out.println("sb1 :" + sb1.length());
		
		System.out.println("sb2 :" + sb2);
		System.out.println("sb2 :" + sb2.capacity());
		System.out.println("sb2 :" + sb2.length());
		
		// 比較兩者是否相同=> 因為沒有override, equals & == 效果相同
		System.out.println(sb1 == sb2); // true!?
		
		System.out.println("--------");
		
		sb1.append("6");
		System.out.println("sb1 :" + sb1);
		System.out.println("sb1 :" + sb1.capacity());
		System.out.println("sb1 :" + sb1.length());
		
		System.out.println("--------");
		
		// 字串長度超過容量=>自動增加容量
		sb1.append("7");
		System.out.println("sb1 :" + sb1);
		System.out.println("sb1 :" + sb1.capacity());
		System.out.println("sb1 :" + sb1.length());
		
		
		System.out.println("--------");
		
		// StringBuffer的方法會傳回自己的物件實體[傳回來的還是sb1] 所以可以一直呼叫
		sb1.append("8").replace(0, 5, "Hello").append("World");
		System.out.println("sb1 :" + sb1);
		System.out.println("sb1 :" + sb1.capacity());
		System.out.println("sb1 :" + sb1.length());
		
		System.out.println("--------");
		
		// 呼叫的方法會傳回本物件實體, 才可以這樣做
		// 字串傳回的是新的物件實體, 所以不能這樣做.
		Reviewed0301_StringBuffer obj1 = new Reviewed0301_StringBuffer();
		System.out.println(obj1.calSum());
		obj1.setS1(15)
			.setS2(56)
			.setS3(66);
		System.out.println(obj1.calSum());
		
		System.out.println("--------");
		
		// 比對StringBuffer的字串內容是否一樣
		StringBuffer sb3 = new StringBuffer("123");
		StringBuffer sb4 = new StringBuffer("123");
		// 沒有override=>== & equals效果一樣
		System.out.println(sb3.equals(sb4));
		
		System.out.println("--------");
		
		// 那要怎麼樣比對兩邊的內容=>利用toString變成字串
		// 變成字串就有String.equals可以使用
		System.out.println(sb3.toString().equals(sb4));	// 為什麼編譯失敗? 這裡sb4的型別是StringBuffer
		System.out.println(sb3.toString().equals(sb4.toString())); // 轉換相同型別
		
		System.out.println("--------");
		
		/*
		 *	#90 為什麼編譯失敗?
		 *	重點在於型別轉換
		 *	String.equals(Object obj) [我要一台車 你給我一台保時捷]
		 *	--> 傳遞進來的都是Object
		 *	--> 要比對字串內容, 但是你給的可能是StringBuffer/其他類別
		 *	--> 所以需要強制轉型 但是String & StringBuffer為旁系血親 非直系血親 無法強制轉型
		 *	--> 如果轉型失敗無法比較=>Return false
		 *	=> 所以才需要先用toString轉成字串型別
		 *
		 */
		
		Reviewed_Bike b1 = new Reviewed_Bike();
		String s2 = new String("123");
		System.out.println(sb3.toString().equals(b1)); // 字串跟腳踏車型別不同不能比阿~
		System.out.println(sb3.toString().equals(s2)); // s2 為字串物件 => true
	}

}


class Reviewed0301_StringBuffer {
	int s1, s2, s3;
	Reviewed0301_StringBuffer setS1(int s1) {
		this.s1=s1; return this;
	}
	Reviewed0301_StringBuffer setS2(int s2) {
		this.s2=s2; return this;
	}
	Reviewed0301_StringBuffer setS3(int s3) {
		this.s3=s3; return this;
	}
	
	int calSum() {
		return s1 + s2 +s3;
	}
}