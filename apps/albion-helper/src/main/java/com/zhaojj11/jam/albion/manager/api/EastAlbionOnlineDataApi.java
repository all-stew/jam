package com.zhaojj11.jam.albion.manager.api;

import com.zhaojj11.jam.albion.manager.dto.EastAlbionOnlineDataApiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 接口层
 *
 * @author zhaojunjie
 */
@Component
@FeignClient(name = "east-albion-online-data", url = "https://east.albion-online-data.com")
public interface EastAlbionOnlineDataApi {

    /**
     * 获取城市的物品价格
     *
     * @param itemList 物品id列表
     * @param request  请求参数
     * @return list
     */
    @GetMapping(value = "/api/v2/stats/Prices/{itemList}.json")
    List<EastAlbionOnlineDataApiDto.PriceResponseItem> listPrice(@PathVariable("itemList") String itemList, @SpringQueryMap EastAlbionOnlineDataApiDto.PriceRequest request);
}
