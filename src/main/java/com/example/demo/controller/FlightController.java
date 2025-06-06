
    /**  
    * @Title: CityController.java
    * @Package com.example.demo.controller
    * @Description: TODO(用一句话描述该文件做什么)
    * @author wjk
    * @date 2018年5月10日
    * @version V1.0  
    */

package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flight;
import com.example.demo.model.FlightSearchParam;
import com.example.demo.model.FlightSearchResult;
import com.example.demo.model.FlightSearchRoundResult;
import com.example.demo.service.FlightService;

import jakarta.annotation.Resource;

@RequestMapping("/api/flights")
@RestController
@CrossOrigin(origins = "http://localhost:5173") // 允许React前端跨域访问
public class FlightController {
    @Resource 
    private  FlightService flightService;


    @GetMapping("/flight")
    public Flight listCity() {
    	Flight result = flightService.getOneflight(111l);
    	System.out.println(result);
        return  result;
    }
    
    @PostMapping("/searchRound")
    public FlightSearchRoundResult searchRoundFlights(@RequestBody FlightSearchParam request) {
    	System.out.println("后端接收到的参数: " + request); // 打印请求参数
    	//启程航班查询
    	List<FlightSearchResult> resultTo = flightService.getFlightSearchResult(request);
    	
    	//返程航班查询
    	request.setDepartureDate(request.getReturnDate());
    	String swapString = request.getDeparture();
    	request.setDeparture(request.getDestination());
    	request.setDestination(swapString);
    	List<FlightSearchResult> resultBack = flightService.getFlightSearchResult(request);
    	
    	//返回值作成
    	FlightSearchRoundResult results = new FlightSearchRoundResult();
    	results.setDepartureFlights(resultTo);
    	results.setReturnFlights(resultBack);
        return  results;
    }
    @PostMapping("/searchSingle")
    public List<FlightSearchResult> searchSingleFlights(@RequestBody FlightSearchParam request) {
    	System.out.println("后端接收到的参数: " + request); // 打印请求参数
    	//航班查询
    	List<FlightSearchResult> results = flightService.getFlightSearchResult(request);
        return  results;
    }
    

}
