package com.zhaojj11.jam.albion.manager;

import com.zhaojj11.jam.albion.manager.api.EastAlbionOnlineDataApi;
import com.zhaojj11.jam.albion.manager.dto.EastAlbionOnlineDataApiDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaojunjie
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EastAlbionOnlineDataManager {

    private final EastAlbionOnlineDataApi eastAlbionOnlineDataApi;

    public @Nonnull List<EastAlbionOnlineDataApiDto.PriceResponseItem> listPrice(@Nonnull List<String> itemIds, @Nonnull List<String> locations, @Nonnull List<Integer> qualities) {
        if (CollectionUtils.isEmpty(itemIds)) {
            return new ArrayList<>();
        }


        String itemListStr = itemIds.stream().map(String::valueOf).collect(Collectors.joining());
        String locationsStr = locations.stream().map(String::valueOf).collect(Collectors.joining());
        String qualitiesStr = qualities.stream().map(String::valueOf).collect(Collectors.joining());

        EastAlbionOnlineDataApiDto.PriceRequest priceRequest = new EastAlbionOnlineDataApiDto.PriceRequest(locationsStr, qualitiesStr);

        return eastAlbionOnlineDataApi.listPrice(itemListStr, priceRequest);
    }
}
