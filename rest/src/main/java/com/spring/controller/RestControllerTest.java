package com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.SampleVO;

@RestController	//리턴값을 마음대로 전송할 수 있다.
public class RestControllerTest {
	
	//produces : 서버에서 생산하는 문서의 타입을 지정
	@GetMapping(value="/hello", produces="text/plain;charset=utf-8")
	public String sayHello() {
		return "박유성모마리아";
	}
	
	//json databind 라이브러리를 통해 jason 형태로 출력가능
	//key:value 형식으로
	// EX) {"mno":"1234","firstName":"hong","lastName":"Dong"}
	//xml과 json 라이브러리를 동시에 사용 시 default로 xml 타입으로 나온다
			/*<SampleVO>
			<mno>1234</mno>
			<firstName>hong</firstName>
			<lastName>Dong</lastName>
			</SampleVO>*/
	//하지만 주소 뒤에 .json을 통해 json 형식으로 다시 출력 가능
	
	@GetMapping("/sendVO")
	public SampleVO sendVO() {
		SampleVO sample = new SampleVO();
		sample.setMno("1234");
		sample.setFirstName("hong");
		sample.setLastName("Dong");
		return sample;		
	}
	
	@GetMapping(value="/sendList", produces=MediaType.APPLICATION_JSON_VALUE)
	//produces => DataType을 JSON으로 사용
	public List<SampleVO> sendList() {
		List<SampleVO> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			SampleVO sample = new SampleVO();
			sample.setMno(""+i);
			sample.setFirstName("hong"+i);
			sample.setLastName("Dong"+i);
			list.add(sample);
		}
		return list;		
	}
	
	//ResponseEntity : 데이터 + http 상태 코드
	//다양한 형태의 데이터와 상태코드를 같이 담아서 보낼 때 사용
	@GetMapping("/check")	//http://localhost:8080/check?height=100&weight=100
	public ResponseEntity<SampleVO> check(double height, double weight) {
		SampleVO sample = new SampleVO();
		sample.setMno("123");
		sample.setFirstName(""+height);
		sample.setLastName(""+weight);
		
		ResponseEntity<SampleVO> entity=null;
		if(height<150) {
			entity=ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sample);
		}else {
			entity=ResponseEntity.status(HttpStatus.OK).body(sample);			
		}
		return entity;
	}
	
	//http://localhost:8080/product/bags/1234
	//http://localhost:8080/product/shoes/5678
	//http://localhost:8080/product/cloth/9076	
	
	//PathVariable : 경로에 들어오는 값을 변수에 담아서 처리
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") String pid) {
		return new String[] {"category : "+cat, "productId : "+pid};
	}
}
