package com.smartluobo.controller;

import com.smartluobo.service.ProcessOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OrderController {

    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    private static final String SUCCESS = "suc";
    private static final String FAILUER = "failure";

    @Autowired
    private ProcessOrder processOrder;

    @RequestMapping("/order")
    public String userReg(){
        return "index";
    }

    @RequestMapping("/confirmOrder")
    @ResponseBody
    public String confirmOrder(@RequestParam("goodsId")String goodsId,
                           @RequestParam("amount")int amount){
        try {
            processOrder.processOrder(goodsId,amount);
            return SUCCESS;
        } catch (Exception e) {
            logger.error("订单确认异常！",e);
            return FAILUER;
        }
    }


}
