package kr.co.goodee39.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
	
	public String getXml() {

		StringBuffer sb = new StringBuffer();
		
		String xmlFile = "";

		try {
			// URL 설정
			StringBuilder urlBuilder = new StringBuilder("http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/abandonmentPublic");
			// 인증키 설정
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=QWmRBRgQFVjPLxlHE0NTfMfwlmHMGKmPqTeI1D%2BPhZO2gQzZpIR0ycYZCtH%2BN7p8W7amKDhwRqHFzjCfSU%2Fvzw%3D%3D");
			//유기날짜 시작
			
			//유기날짜 종료
			
			// 축종 : 견(417000)
			urlBuilder.append("&" + URLEncoder.encode("upkind", "UTF-8") + "=" + URLEncoder.encode("417000", "UTF-8"));
			// 출력 페이지 수
			urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
			// 총 가져올 정보 수
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("500", "UTF-8"));
			// urlBuilder.append("&type=json"); /*json 출력인데 안먹힘*/

			// 설정한 url바탕으로 url 생성
			URL url = new URL(urlBuilder.toString());
			System.out.println(url.toString());
			
			// 생성한 url과 http 통신 위해 HttpURLConnection 설정
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			// http요청에 필요한 타입 설정
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");

			//반환코드 : 200 (200은 정상일 때 코드)
			//System.out.println("Response code: " + conn.getResponseCode());

			//텍스트 타입 설정 : 한글 깨짐 방지
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			// rd 내용 읽으면 <item>블럭마다 단락 띄우고 저장
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			//rd 처리 끝 > 닫기
			rd.close();
			//url연결 후 정보 다 가져옴 > 닫기
			conn.disconnect();

			// String화
			xmlFile = sb.toString();
			
			//controller로 String화 된 sb전달하기
			return xmlFile;
			

		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}
}
