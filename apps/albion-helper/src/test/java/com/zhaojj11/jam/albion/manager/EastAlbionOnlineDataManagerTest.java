package com.zhaojj11.jam.albion.manager;

import com.zhaojj11.jam.albion.manager.api.EastAlbionOnlineDataApi;
import com.zhaojj11.jam.albion.manager.dto.EastAlbionOnlineDataApiDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;


@Import({EastAlbionOnlineDataManager.class})
@ExtendWith(SpringExtension.class)
class EastAlbionOnlineDataManagerTest {
    public static List<EastAlbionOnlineDataApiDto.PriceResponseItem> priceResponseItems;
    @Resource
    private EastAlbionOnlineDataManager eastAlbionOnlineDataManager;
    @MockBean
    private EastAlbionOnlineDataApi eastAlbionOnlineDataApi;

    @BeforeAll
    static void init() {
        priceResponseItems = List.of(new EastAlbionOnlineDataApiDto.PriceResponseItem(
            "UNIQUE_HIDEOUT",
            "Thetford",
            1,
            0,
            "0001-01-01T00:00:00",
            0,
            "0001-01-01T00:00:00",
            11000000,
            "2023-07-05T10:45:00",
            11000001,
            "2023-07-05T10:45:00"
        ));
    }

    @Test
    void testListPrice() {
        Mockito.when(eastAlbionOnlineDataApi.listPrice(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(priceResponseItems);
        List<EastAlbionOnlineDataApiDto.PriceResponseItem> responseItems = eastAlbionOnlineDataManager.listPrice(
            List.of("UNIQUE_HIDEOUT"),
            List.of("Thetford"),
            List.of(1)
        );
        Assertions.assertEquals(1, responseItems.size());
    }

}