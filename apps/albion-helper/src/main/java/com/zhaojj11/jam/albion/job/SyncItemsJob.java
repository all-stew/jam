package com.zhaojj11.jam.albion.job;

import com.zhaojj11.jam.albion.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhaojj11
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SyncItemsJob {

    private final ItemService itemService;

    @Scheduled(cron = "* 30 10 * * SUN")
    public void syncItems() {
        itemService.syncItems();
    }

}
