package com.zhaojj11.jam.albion.manager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zhaojunjie
 */
public class EastAlbionOnlineDataApiDto {

    public record PriceResponseItem(
        String itemId, String city, int quality,
        @JsonProperty("sell_price_min") long sellPriceMin,
        @JsonProperty("sell_price_min_date") String sellPriceMinDate,
        @JsonProperty("sell_price_max") long sellPriceMax,
        @JsonProperty("sell_price_max_date") String sellPriceMaxDate,
        @JsonProperty("buy_price_min") long buyPriceMin,
        @JsonProperty("buy_price_min_date") String butPriceMinDate,
        @JsonProperty("buy_price_max") long buyPriceMax,
        @JsonProperty("buy_price_max_date") String buyPriceMaxDate
    ) {
    }

    public record PriceRequest(
        String locations, String qualities
    ) {
    }
}
