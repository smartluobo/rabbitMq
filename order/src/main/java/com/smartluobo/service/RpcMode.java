package com.smartluobo.service;

import com.smartluobo.rpc.DepotService;
import com.smartluobo.rpc.RpcProxy;
import com.smartluobo.vo.GoodTransferVo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;


@Service
@Qualifier("rpc")
public class RpcMode implements IProDepot {

    private static final String IP = "127.0.0.1";
    private static final int PORT = 10002;

    public void processDepot(String goodsId, int amount) {

        DepotService service = RpcProxy.getRmoteProxyObj(DepotService.class,
                new InetSocketAddress(IP,PORT));
        GoodTransferVo goodTransferVo = new GoodTransferVo();
        goodTransferVo.setGoodsId(goodsId);
        goodTransferVo.setChangeAmount(amount);
        goodTransferVo.setInOrOut(true);
        service.changeDepot(goodTransferVo);
    }
}
