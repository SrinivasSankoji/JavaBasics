package com.example.demo;

public class StringSplit {
	public static void main(String[] args) {
		/**String strMain = "randomFromList(merchantCode_SIT)";
		String randomFromList = strMain.split("randomFromList")[1];
		String randomFromValue=randomFromList.substring(1, randomFromList.length()-1);
		System.out.println(randomFromValue);**/
		
		String message="Suite à votre import, si vous ne recevez pas un email de CALIS,écrivez à list.alerte-cam@renault.com Chargement du fichier effectuï¿½";
		String[] randomFromList = message.split(",");
		String firstLine=randomFromList[0].concat(randomFromList[1]);
		String[] newMessage=randomFromList[2].split(".com");
		String secondLine=newMessage[0];
		String thirdLine=newMessage[1];
		System.out.println(firstLine);
		System.out.println(secondLine);
		System.out.println(thirdLine);
	}
}
